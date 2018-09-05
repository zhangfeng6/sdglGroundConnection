package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.pojo.Travel;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社业务接口
 **/
public interface TravelService {

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
    Travel selectTravelById(Integer travelId)throws Exception;

    /**
     *
     * 添加信息
     * @param travel
     * @return
     * @throws Exception
     */
    Integer getAddTravel(Travel travel) throws Exception;
    /**
     * 修改信息
     * @param travel
     * @return
     */
    Integer getTravelUpd(Travel travel) throws Exception;

    /**
     * a按条件模糊查看
     * @param pageNo
     * @param PageSize
     * @return
     * @throws Exception
     */
    PageInfo<Travel> listTravelLike(Integer pageNo, Integer PageSize, String travelName) throws Exception;

    /**
     * 按条件查看
     * @param travelId
     * @return
     * @throws Exception
     */
    Integer getselectById(Integer travelId) throws Exception;


    /**
     * 删除    修改
     * @param travelId
     * @return
     */
    Integer getUpdTrave(Integer travelId)throws Exception;

    /**
     * 修改查看
     * @param travelId
     * @return
     */
    Travel getupdBytravelId(Integer travelId)throws Exception;


    /**
     * 修改 第二次
     * @return
     */
    Integer getupdlala(Travel travel)throws Exception;



    /**
     * 根据组团社查询导游
     * @param travelId
     * @return
     */
    Guide selectGuideByTravelId(Integer travelId)throws Exception;


    /**
     * 根据组团社id查询司机
     * @param travelId
     * @return
     */
    Dispatch selectDispatchByTravelId(Integer travelId)throws Exception;

    /**
     * genju组团社id查询计调员
     * @param travelId
     * @return
     */
    Staff selectStaffByTraveId(Integer travelId)throws Exception;


    /**
     * 根据组团社id查询线路
     * @param travelId
     * @return
     */
    Offer selectOfferByTravelId(@Param("travelId") Integer travelId)throws Exception;

    /**
     * 根据组团社号获取组团社名称
     * @param groupNumber
     * @return
     */
    Travel getTravelName(Integer groupNumber)throws Exception;


    /**
     * 根据组团社Id查询餐厅导游报价
     * @param travelId
     * @return
     */
    List<Disrestaurant> selectReportrestaurantByTravelId(Integer travelId)throws Exception;

    /**
     * 根据组团社Id查询餐厅导游报价
     * @param travelId
     * @return
     */
    List<Disrestaurant> selectReportrestaurantByTravelId1(Integer travelId)throws Exception;

    /**
     * 根据组团社Id查询导游酒店报价
     * @param travelId
     * @return
     */
    List<Dispatchhotel> selectReportaccommodationByTravelId(Integer travelId)throws Exception;



    /**
     * 根据组团社Id查询导游景点门票报账
     * @param travelId
     * @return
     */
    List<Disattr> selectReportticketByTravelId(Integer travelId)throws Exception;

    /**
     * 根据组团社Id查询导游车费报账
     * @param travelId
     * @return
     */
    Discar selectReportfareByTravelId(Integer travelId)throws Exception;

}
