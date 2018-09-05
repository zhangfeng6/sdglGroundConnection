package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Offerrestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价餐厅
 **/
@Mapper
@Component
public interface OfferrestaurantMapper extends CommonMapper<Offerrestaurant>{

    /**
     * 赵伟伟
     * 新增餐厅报价
     * @param offerrestaurant
     * @return
     */
    int insertOfferrestaurant(Offerrestaurant offerrestaurant)throws  Exception;

    /**
     * 赵伟伟
     * 根据报价编号查询
     * @param offerId
     * @return
     */
    List<Offerrestaurant> selectOfferRestaurantByOfferId(@Param("offerId") int offerId)throws  Exception;
}
