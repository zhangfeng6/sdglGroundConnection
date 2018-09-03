package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.CarrentalMapper;
import com.dyhc.sdglgroundconnection.mapper.VehicleTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import com.dyhc.sdglgroundconnection.service.VehicleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 车辆类型业务实现
 **/
@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    private VehicleTypeMapper vehicleTypeMapper;

    @Autowired
    private CarrentalMapper carrentalMapper;


    @Override
    public Integer deleteVehicleTypesBycarRentalId(Integer carRentalId) throws Exception {
        try {
            vehicleTypeMapper.deleteVehicleTypesBycarRentalId(carRentalId);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer insertVehicleType(VehicleType vehicleType) throws Exception {
        try {
            List<VehicleType> list=vehicleTypeMapper.listVehicleTypeByValueId(vehicleType.getValueId(),vehicleType.getCarRentalId());
            if (list.size()>0){
                return 3;
            }else {
                vehicleTypeMapper.insertVehicleType(vehicleType);
                return 1;
            }

        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public VehicleType getVehicletypeByTypeId(Integer typeId) throws Exception {
        return vehicleTypeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public Integer updateVehicleType(VehicleType vehicleType) throws Exception {
        try {
            vehicleTypeMapper.updateVehicleType(vehicleType);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public Integer deleteVehicleTypeById(Integer typeId)throws Exception {
        try {
            vehicleTypeMapper.deleteVehicleTypeById(typeId);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<VehicleType> listVehicleTypeByValueId(Integer valueId, Integer carRentalId)throws Exception {
        return vehicleTypeMapper.listVehicleTypeByValueId(valueId,carRentalId);
    }

    /**
     * 查询车辆类型表
     * @param typeId
     * @return
     */
    @Override
    public VehicleType vehicleType(Integer typeId)throws Exception {
        VehicleType vehicleType=vehicleTypeMapper.vehicleType(typeId);
        vehicleType.setCarrental(carrentalMapper.carrental(vehicleType.getCarRentalId()));
        return vehicleType;
    }
}
