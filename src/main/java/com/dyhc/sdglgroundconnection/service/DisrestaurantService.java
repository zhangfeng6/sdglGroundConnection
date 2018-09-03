package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Disrestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度餐厅业务接口
 **/
public interface DisrestaurantService {


    /**
     * 根据id获取调度餐厅信息
     * @param dispatchId
     * @param weight
     * @return
     * @throws Exception
     */
    Disrestaurant getDisrestaurantById(Integer dispatchId,Integer weight)throws Exception;

    /**
     * 查看用餐地点
     * @return
     */
    List<String> listDisrestaurantAll(Integer dispatchId)throws Exception;
}
