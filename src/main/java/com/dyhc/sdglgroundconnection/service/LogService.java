package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Log;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 日志业务接口
 **/
public interface LogService {

    /**
     * 添加日志
     * @param log
     * @return
     * @throws Exception
     */
    Integer inserLog(Log log)throws Exception;

    /**
     * 查看导游带团日志：贾晓亮
     * @return
     */
    Log ShowAllLog(Integer guideId,Integer dispatchId,String creationDate)throws Exception;
}
