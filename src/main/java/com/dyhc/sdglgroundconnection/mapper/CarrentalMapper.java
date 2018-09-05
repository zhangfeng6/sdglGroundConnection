package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Carrental;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 *汽车租赁公司
 **/
@Mapper
@Component
public interface CarrentalMapper extends CommonMapper<Carrental>{

    /**
     * 根据公司名称模糊查询公司信息
     * @param carRentalName
     * @return
     * @throws Exception
     */
    List<Carrental> listCarRentals(@Param("carRentalName") String carRentalName)throws  Exception;


    /**
     * 根据条件添加公司
     */
    void insertCarRental(Carrental carrental)throws Exception;


    /**
     * 根据公司id删除公司
     * @param carRentalId
     */
    void deleteCarRentalBycarRentalId(@Param("carRentalId") Integer carRentalId)throws Exception;


    /**
     * 查询是否有相同名称的公司
     * @param carRentalName
     * @return
     */
    List<Carrental> getCarrentalByName(@Param("carRentalName") String carRentalName)throws  Exception;

    /**
     * 根据valueId进行查询返回车辆公司对象
     * @param valueId
     * @return
     * @throws Exception
     */
    List<Carrental> listcarrentalByvalueId(@Param("valueId")Integer valueId)throws Exception;

    /**
     * 查询汽车租赁公司表
     * @return
     */
    Carrental carrental(@Param("carRentalId")Integer carRentalId)throws  Exception;

}
