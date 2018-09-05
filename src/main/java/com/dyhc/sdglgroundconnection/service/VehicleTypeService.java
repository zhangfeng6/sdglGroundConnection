package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 车辆类型业务接口
 **/
public interface VehicleTypeService {

    /**
     * 根据公司id删除公司下的车辆类型
     * @param carRentalId
     */
    Integer deleteVehicleTypesBycarRentalId(Integer carRentalId)throws Exception;


    /**
     * 给指定公司添加车辆类型
     * @param vehicleType
     */
    Integer insertVehicleType(VehicleType vehicleType)throws Exception;


    /**
     * 根据车辆id查询车辆信息
     * @return
     */
    VehicleType getVehicletypeByTypeId(Integer typeId)throws Exception;


    /**
     * 给指定公司修改车辆类型
     * @param vehicleType
     */
    Integer updateVehicleType(VehicleType vehicleType)throws Exception;


    /**
     * 根据id删除车辆类型
     * @param typeId
     */
    Integer deleteVehicleTypeById(Integer typeId)throws Exception;

    /**
     * 查看同一公司下是否有同种类型的车辆
     * @param valueId
     * @param carRentalId
     * @return
     */
    List<VehicleType> listVehicleTypeByValueId(Integer valueId,Integer carRentalId)throws Exception;


    /**
     *
     * @param typeId
     * @return
     */
    VehicleType vehicleType(@Param("typeId")Integer typeId)throws Exception;
}
