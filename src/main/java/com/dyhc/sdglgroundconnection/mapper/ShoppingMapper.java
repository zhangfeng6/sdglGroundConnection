package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Shopping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 购物
 **/
@Mapper
@Component
public interface ShoppingMapper extends CommonMapper<Shopping>{
    /**
     * 根据景点id查询购物地点
     * @param scenicSpotId
     * @return
     */
    List<Shopping> listShoppingByScenicSpotId(@Param("scenicSpotId") Integer scenicSpotId)throws Exception;


    /**
     * 根据购物id删除该购物地点
     * @param shoppingId
     * @throws Exception
     */
    void deleteShoppingById(@Param("shoppingId") Integer shoppingId)throws Exception;


    /**
     * 根据景点id删除购物地点
     * @param scenicSpotId
     * @throws Exception
     */
    void deleteShoppingsByscenicSpotId(@Param("scenicSpotId") Integer scenicSpotId)throws Exception;

    /**
     * 获取所有未删除的购物地信息
     * @return
     * @throws Exception
     */
    List<Shopping> listNoDelShopping()throws Exception;
}
