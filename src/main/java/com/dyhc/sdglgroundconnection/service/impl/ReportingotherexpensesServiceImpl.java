package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ReportingotherexpensesMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportingotherexpenses;
import com.dyhc.sdglgroundconnection.service.ReportingotherexpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账其他支出业务实现
 **/
@Service
public class ReportingotherexpensesServiceImpl implements ReportingotherexpensesService {

    @Autowired
    private ReportingotherexpensesMapper reportingotherexpensesMapper;

    /**
     * 导游报账其他支出：贾晓亮
     * @param reportingotherexpenses
     * @return
     */
    @Override
    public Integer saveReportingotherexpenses(Reportingotherexpenses reportingotherexpenses)throws Exception {
        Integer number=0;
        try {
            number=reportingotherexpensesMapper.insert(reportingotherexpenses);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public Reportingotherexpenses listReportingotherexpensesById(Integer reportDetailId) throws Exception {
        return reportingotherexpensesMapper.listReportingotherexpensesById(reportDetailId);
    }
}
