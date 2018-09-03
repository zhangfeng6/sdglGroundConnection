package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.OfferHotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价酒店业务接口
 **/
public interface OfferHotelService {

    /**
     * 赵伟伟
     * 新增酒店报价
     * @param offerHotel
     * @return
     */
    int insertOfferHotel(OfferHotel offerHotel)throws Exception;

    /**
     * 赵伟伟s
     * 按报价编号查询
     * @param offerId
     * @return
     */
    List<OfferHotel> selectOfferHotelByOfferId(int offerId)throws Exception;
}
