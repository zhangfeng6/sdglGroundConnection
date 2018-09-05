package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Disattr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度景点业务接口
 **/
public interface DisattrService {
    /**
     * 查询调度景点表
     * @param offerId
     * @return
     */
    Disattr disattr(@Param("offerId") Integer offerId)throws Exception;
}
