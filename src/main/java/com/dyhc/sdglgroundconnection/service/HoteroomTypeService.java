package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.HoteroomType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店房间类型业务接口
 **/
public interface HoteroomTypeService {


    /**
     * 微信小程序之获取行程内容
     * @param dispatchId
     * @param weight
     * @return
     */
    HoteroomType getHoteroomTypeById(Integer dispatchId,Integer weight)throws Exception;
    /**
     * 查看线路信息
     * @return
     */
    List<HoteroomType> listOfferlineAll(Integer dispatchId)throws Exception;
}
