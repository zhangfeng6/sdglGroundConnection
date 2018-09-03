package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Offer;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价信息业务接口
 **/
public interface OfferService {

    /**
     * 赵伟伟
     * 查询报价单
     * @param travelName
     * @return
     */
    PageInfo<Offer> selectOffer(Integer pageNo,Integer PageSize,String travelName)throws Exception;

    /**
     * 赵伟伟
     * 新增报价单信息
     * @param offer
     * @return
     */
    int insertOffer(Offer offer) throws Exception;


    /**
     * 赵伟伟
     * 按id查询报价单
     * @param offerId
     * @return
     */
    Offer selectOfferByOfferId(int offerId)throws Exception;


    /**
     * 赵伟伟
     * 确认成团
     * @return
     */
    int queren(int offerId)throws Exception;
}
