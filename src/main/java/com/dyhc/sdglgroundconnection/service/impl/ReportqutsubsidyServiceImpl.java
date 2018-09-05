package com.dyhc.sdglgroundconnection.service.impl;
import com.dyhc.sdglgroundconnection.mapper.ReportqutsubsidyMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportqutsubsidy;
import com.dyhc.sdglgroundconnection.service.ReportqutsubsidyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账出团补助业务实现
 **/
@Service
public class ReportqutsubsidyServiceImpl implements ReportqutsubsidyService {

    @Autowired
    private ReportqutsubsidyMapper reportqutsubsidyMapper;

    /**
     * 导游报账出团补助：贾晓亮
     * @param reportqutsubsidy
     * @return
     */
    @Override
    public Integer saveReportqutsubsidy(Reportqutsubsidy reportqutsubsidy)throws Exception {
        Integer number=0;
        try {
            number=reportqutsubsidyMapper.insert(reportqutsubsidy);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public Reportqutsubsidy getReportqutsubsidyById(Integer reportDetailId)throws Exception {
        return reportqutsubsidyMapper.getReportqutsubsidyById(reportDetailId);
    }
}