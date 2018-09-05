package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Offerscenic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价景点业务接口
 **/
public interface OfferscenicService {

    /**
     * 赵伟伟
     * 新增景点报价
     * @param offerscenic
     * @return
     */
    int insertOfferscenic(Offerscenic offerscenic)throws Exception;

    /**
     * 赵伟伟
     * 按报价编号查询
     * @return
     */
    List<Offerscenic> selectOfferscenicByOfferId(int offerId)throws Exception;
}
