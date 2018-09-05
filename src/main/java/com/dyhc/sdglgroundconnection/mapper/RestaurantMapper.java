package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.MealType;
import com.dyhc.sdglgroundconnection.pojo.Restaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 餐馆
 **/
@Mapper
@Component
public interface RestaurantMapper extends CommonMapper<Restaurant>{
    /**
     * 赵伟伟
     * 模糊查询饭店
     * @param restaurantName
     * @param restaurantAddress
     * @param whetherDel
     * @return
     */
    List<Restaurant> selectByEx(@Param("restaurantName") String restaurantName,@Param("restaurantAddress") String restaurantAddress,@Param("whetherDel") Integer whetherDel)throws  Exception;

    /**
     * 赵伟伟
     * 按照id删除饭店
     * @param restaurantId
     * @return
     */
    int delRestaurantById(@Param("restaurantId") int restaurantId) throws Exception;


    /**
     * 赵伟伟
     * 修改饭店
     * @param restaurant
     * @return
     */
    int updateRestaurantById(Restaurant restaurant)throws  Exception;

    /**
     * 赵伟伟
     * 修改饭店
     * @param restaurant
     * @return
     */
    int updateRestaurantById1(Restaurant restaurant)throws  Exception;

    /**
     * 根据valueId获取饭店信息
     * @param valueId
     * @return
     * @throws Exception
     */
    List<Restaurant> listrestaurantByvalueId(@Param("valueId")Integer valueId)throws Exception;


    /**
     * 根据id查询餐馆数量
     * @param valueId
     * @param restaurantId
     * @return
     */
    int selectTypeById(@Param("valueId") Integer valueId,@Param("restaurantId") Integer restaurantId)throws  Exception;


    MealType selectMealTypeByTypeId(@Param("typeId") Integer typeId)throws  Exception;
}
