package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Disshopp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度购物业务接口
 **/
public interface DisshoppService {


    /**
     *微信小程序之获取购物地点
     * @param dispatchId
     * @param weight
     * @return
     */
    List<Disshopp> getDisshoppById(Integer dispatchId,Integer weight)throws Exception;
    /**
     * 查看购物地点
     * @return
     */
    List<String> listDisshoppAll(Integer dispatchId)throws Exception;
}
