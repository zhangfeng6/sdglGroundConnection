package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 车辆类型
 **/
@Mapper
@Component
public interface VehicleTypeMapper extends CommonMapper<VehicleType> {


    /**
     * 根据条件查询所有的车辆类型
     * @return
     */
    List<VehicleType> listVehicleTypes();

    /**
     * 根据公司id删除公司下的车辆类型
     * @param carRentalId
     */
    void deleteVehicleTypesBycarRentalId(@Param("carRentalId") Integer carRentalId)throws Exception;


    /**
     * 给指定公司添加车辆类型
     * @param vehicleType
     */
    void insertVehicleType(VehicleType vehicleType)throws Exception;

    /**
     * 给指定公司修改车辆类型
     * @param vehicleType
     */
    void updateVehicleType(VehicleType vehicleType)throws Exception;

    /**
     * 根据id删除车辆类型
     * @param typeId
     */
    void deleteVehicleTypeById(@Param("typeId") Integer typeId)throws Exception;


    /**
     * 查看同一公司下是否有同种类型的车辆
     * @param valueId
     * @param carRentalId
     * @return
     */
    List<VehicleType> listVehicleTypeByValueId(@Param("valueId") Integer valueId,@Param("carRentalId")Integer carRentalId)throws Exception;

    /**
     *
     * @param typeId
     * @return
     */
    VehicleType vehicleType(@Param("typeId")Integer typeId)throws Exception;
    /**
     * 根据valueId查找车辆信息
     * @param valueId
     * @return
     * @throws Exception
     */
    List<VehicleType> listinfoByvalueId(@Param("valueId")Integer valueId)throws Exception;


}
