package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Discar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度用车业务接口
 **/
public interface DiscarService {
    /*
    查询调度用车表
     */
    Discar discar(Integer disCarId)throws Exception;

    /**
     * 查看车辆公司
     * @param dispatchId
     * @return
     */
    Discar listDiscar(Integer dispatchId)throws Exception;

    Discar selectDiscarByOfferId(Integer offerId)throws Exception;
}
