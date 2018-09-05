package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Disguide;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度导游
 **/
@Mapper
@Component
public interface DisguideMapper extends CommonMapper<Disguide>{

    /**
     * 查看行程计划
     * @param dispatchId
     * @return
     */
    Disguide DisguideAll(Integer dispatchId)throws  Exception;

    /**
     * 根据调度id获取调度导游表数据  张枫
     * @return
     * @throws Exception
     */
    Disguide getDisguideByDid(@Param("Did")Integer Did)throws Exception;
}
