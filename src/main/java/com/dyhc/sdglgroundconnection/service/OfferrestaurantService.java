package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Offerrestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价餐厅业务接口
 **/
public interface OfferrestaurantService {

    /**
     * 赵伟伟
     * 新增餐厅报价
     * @param offerrestaurant
     * @return
     */
    int insertOfferrestaurant(Offerrestaurant offerrestaurant)throws Exception;

    /**
     * 赵伟伟
     * 根据报价编号查询
     * @param offerId
     * @return
     */
    List<Offerrestaurant> selectOfferRestaurantByOfferId(int offerId)throws Exception;
}
