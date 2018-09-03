package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ReportfareMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportfare;
import com.dyhc.sdglgroundconnection.service.ReportfareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账车费业务实现
 **/
@Service
public class ReportfareServiceImpl implements ReportfareService {

    @Autowired
    private ReportfareMapper reportfareMapper;

    /**
     *导游报账车费：贾晓亮
     * @param reportfare
     * @return
     */
    @Override
    public Integer saveReportfare(Reportfare reportfare)throws Exception {
      Integer number=0;
        try {
            number=reportfareMapper.insertSelective(reportfare);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public Reportfare listReportfareById(Integer reportDetailId) throws Exception {
        return reportfareMapper.listReportfareById(reportDetailId);
    }
}
