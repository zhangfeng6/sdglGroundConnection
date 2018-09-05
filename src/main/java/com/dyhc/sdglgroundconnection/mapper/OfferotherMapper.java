package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Offerother;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价其他
 **/
@Mapper
@Component
public interface OfferotherMapper extends CommonMapper<Offerother>{

    /**
     * 赵伟伟
     * 新增其他报价
     * @param offerother
     * @return
     */
    int insertOfferother(Offerother offerother)throws  Exception;

    /**
     * 赵伟伟
     * 按报价单编号查询
     * @param offerId
     * @return
     */
    Offerother selectOfferotherByOfferId(@Param("offerId") int offerId)throws  Exception;
}
