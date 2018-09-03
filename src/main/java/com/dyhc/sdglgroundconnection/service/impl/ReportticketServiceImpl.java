package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ReportticketMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportticket;
import com.dyhc.sdglgroundconnection.service.ReportticketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账门票业务实现
 **/
@Service
public class ReportticketServiceImpl implements ReportticketService {

    @Autowired
    private ReportticketMapper reportticketMapper;

    /**
     *导游报账门票新增;贾晓亮
     * @param reportticket
     * @return
     */
    @Override
    public Integer saveReportticket(Reportticket reportticket)throws Exception {
        Integer  number=0;
        try {
            number=reportticketMapper.insert(reportticket);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public List<Reportticket> listReportticketById(Integer reportDetailId) throws Exception {
        return reportticketMapper.listReportticketById(reportDetailId);
    }
}
