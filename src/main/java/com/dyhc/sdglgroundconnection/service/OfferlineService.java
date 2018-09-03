package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Offer;
import com.dyhc.sdglgroundconnection.pojo.Offerline;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价线路信息记录业务接口
 **/
public interface OfferlineService {
    /**
     * 赵伟伟
     * 查询线路
     * @return
     */
    List<Offerline> selectOfferline()throws Exception;

    /**
     * 赵伟伟
     * 查询线路
     * @param offerLineRecordId
     * @return
     */
    Offerline selectByofferLineRecordId(Integer offerLineRecordId)throws Exception;

    /**
     * 新增报价线路信息
     * @param offerline
     * @return
     */
    int insertOfferline(Offerline offerline)throws Exception;


    /**
     * 赵伟伟
     * 按报价单编号查询
     * @param offerId
     * @return
     */
    List<Offerline> selectOfferlineByOfferId(int offerId)throws Exception;
}
