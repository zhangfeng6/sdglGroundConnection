package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Offercar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价用车业务接口
 **/
public interface OffercarService {

    /**
     * 赵伟伟
     * 新增汽车报价
     * @param offercar
     * @return
     */
    int insertOffercar(Offercar offercar)throws Exception;

    /**
     * 按报价编号查询
     * @return
     */
    Offercar selectOffercarByOfferId(int offerId)throws Exception;


    /**
     * 按编号查询
     * @param valueId
     * @return
     */
    Dictionaries selectOffercarById(int valueId)throws Exception;
}
