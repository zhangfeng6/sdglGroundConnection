package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DiscarMapper;
import com.dyhc.sdglgroundconnection.pojo.Discar;
import com.dyhc.sdglgroundconnection.service.DiscarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度用车业务实现
 **/
@Service
public class DiscarServiceImpl implements DiscarService {

    @Autowired
    private DiscarMapper discarMapper;
    @Autowired
    private  VehicleTypeServiceImpl vehicleTypeService;


    /**
     * 查询调度用车表:贾晓亮
     * @param disCarId
     * @return
     */
    @Override
    public Discar discar(Integer disCarId) throws Exception{
        Discar discar =discarMapper.discar(disCarId);
        discar.setVehicleType(vehicleTypeService.vehicleType(discar.getTypeId()));
        return discar;
    }

    /**
     * 查看车辆公司
     * @param dispatchId
     * @return
     */
    @Override
    public Discar listDiscar(Integer dispatchId)throws Exception {
        return discarMapper.listDiscar(dispatchId);
    }

    @Override
    public Discar selectDiscarByOfferId(Integer offerId)throws Exception {
        return discarMapper.selectDiscarByOfferId(offerId);
    }
}
