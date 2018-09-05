package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社
 **/
@Mapper
@Component
public interface TravelMapper extends CommonMapper<Travel> {



    /**
     * 赵伟伟
     * 查询全部组团社
     * @return
     */
    List<Travel> selectTravel()throws Exception;


    /**
     * 赵伟伟
     * 查询组团社
     * @param travelId
     * @return
     */
    Travel selectTravelById(@Param("travelId") Integer travelId)throws Exception;


    List<Travel> listTravelLike(@Param("travelName") String travelName)throws Exception;
    /**
     * 删除
     * @param travelId
     * @return
     */
    Integer getUpdTrave(Integer travelId)throws Exception;

    /**
     * 修改条件查
     * @param travelId
     * @return
     */
    Travel getupdBytravelId(Integer travelId)throws Exception;

    /**
     * 修改
     * @return
     */

    Integer getupdlala(Travel travel)throws Exception;


    /**
     * 根据组团社查询导游
     * @param travelId
     * @return
     */
    Guide selectGuideByTravelId(@Param("travelId") Integer travelId)throws Exception;


    /**
     * 根据组团社id查询司机
     * @param travelId
     * @return
     */
    Dispatch selectDispatchByTravelId(@Param("travelId") Integer travelId)throws Exception;

    /**
     * genju组团社id查询计调员
     * @param travelId
     * @return
     */
    Staff selectStaffByTraveId(@Param("travelId") Integer travelId)throws Exception;

    /**
     * 根据组团社id查询线路
     * @param travelId
     * @return
     */
    Offer selectOfferByTravelId(@Param("travelId") Integer travelId)throws Exception;

    /**
     * 查询组团表信息
     * @param travelId
     * @return
     */
    Travel  travel(@Param("travelId") Integer travelId)throws Exception;

    /**
     * 根据组团社Id查询餐厅导游报价
     * @param travelId
     * @return
     */
    List<Disrestaurant> selectReportrestaurantByTravelId(@Param("travelId") Integer travelId)throws Exception;

    /**
     * 根据组团社Id查询餐厅导游报价
     * @param travelId
     * @return
     */
    List<Disrestaurant> selectReportrestaurantByTravelId1(@Param("travelId") Integer travelId)throws Exception;



    /**
     * 根据组团社Id查询导游酒店报价
     * @param travelId
     * @return
     */
    List<Dispatchhotel> selectReportaccommodationByTravelId(@Param("travelId") Integer travelId)throws Exception;


    /**
     * 根据组团社Id查询导游景点门票报账
     * @param travelId
     * @return
     */
    List<Disattr> selectReportticketByTravelId(@Param("travelId") Integer travelId)throws Exception;

    /**
     * 根据组团社Id查询导游车费报账
     * @param travelId
     * @return
     */
    Discar selectReportfareByTravelId(@Param("travelId") Integer travelId)throws Exception;

    /**
     * 查找所有未删除的组团社信息
     * @return
     * @throws Exception
     */
    List<Travel> listNoDelTravel()throws Exception;
}
