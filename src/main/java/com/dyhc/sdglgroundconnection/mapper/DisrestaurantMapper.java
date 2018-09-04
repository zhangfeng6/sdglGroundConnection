package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Disrestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度餐厅
 **/
@Mapper
@Component
public interface DisrestaurantMapper extends CommonMapper<Disrestaurant>{



    /**
     * 根据id获取调度餐厅信息
     * @param dispatchId
     * @param weight
     * @return
     * @throws Exception
     */
    List<Disrestaurant> getDisrestaurantById(@Param("dispatchId") Integer dispatchId, @Param("weight") Integer weight)throws Exception;

    /**
     * 查看用餐地点
     * @return
     */
    List<String> listDisrestaurantAll(Integer dispatchId);

    /**
     * 根据调度id获取调度餐厅表数据  张枫
     * @param Did
     * @return
     * @throws Exception
     */
    List<Disrestaurant> listDisrestaurantByDid(@Param("Did")Integer Did)throws Exception;
}
