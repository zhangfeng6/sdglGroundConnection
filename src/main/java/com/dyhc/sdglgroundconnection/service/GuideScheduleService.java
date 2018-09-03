package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GuideScheduleService {

    /**
     * 添加请假信息
     * @param list
     * @return
     */
    Integer insertGuideSchedule(List<Guideschedule> list)throws Exception;
}
