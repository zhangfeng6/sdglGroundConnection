package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.GuidescheduleMapper;
import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import com.dyhc.sdglgroundconnection.service.GuideScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("guideScheduleService")
public class GuideScheduleServiceImpl implements GuideScheduleService {

    @Autowired
    private GuidescheduleMapper guidescheduleMapper;

    @Override
    public Integer insertGuideSchedule(List<Guideschedule> list) throws Exception{
        try {
            guidescheduleMapper.insertList(list);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }
}
