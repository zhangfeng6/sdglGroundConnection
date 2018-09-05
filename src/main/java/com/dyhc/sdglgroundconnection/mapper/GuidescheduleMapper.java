package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 导游时间安排表
 */
@Mapper
@Component
public interface GuidescheduleMapper extends CommonMapper<Guideschedule>{

    /**
     * 获取导游请假信息 根据条件
     * @param year
     * @param month
     * @return
     */
    List<Guideschedule> listguideschedule(@Param("year")String year,@Param("month")String month)throws  Exception;


}
