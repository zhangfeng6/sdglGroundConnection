package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Disguide;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度导游业务接口
 **/
public interface DisguideService {

    /**
     * 查看行程计划
     * @param dispatchId
     * @return
     */
    Disguide DisguideAll(Integer dispatchId)throws Exception;
}
