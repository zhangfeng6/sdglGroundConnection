package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.mapper.ReportdetailMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.pojo.Reportqutsubsidy;
import com.dyhc.sdglgroundconnection.service.ReportqutsubsidyService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账出团补助 控制层
 **/
@RequestMapping("/Reportqutsubsidy")
@RestController
public class ReportqutsubsidyController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportqutsubsidyController.class);

    @Autowired
    private ReportqutsubsidyService reportqutsubsidyService;
    @Autowired
    private ReportdetailMapper reportdetailMapper;
    /**
     * 导游报账住宿新增
     * @param
     * @return
     */
    @LogNotes(operationType="导游补助明细",content="补助新增")
    @RequestMapping("/saveReportqutsubsidy")
    public ReponseResult saveReportqutsubsidy(@RequestParam("dispatchId")Integer dispatchId,@RequestParam("DailyCost")Double DailyCost,@RequestParam("nums")Integer nums,@RequestParam("guideNum")Integer guideNum){
        try {
            Reportdetail reportdetail =reportdetailMapper.All_dispatchId(dispatchId);
            Reportqutsubsidy reportqutsubsidy=new Reportqutsubsidy();
            reportqutsubsidy.setReportDetailId(reportdetail.getReportDetailId());
            reportqutsubsidy.setCreateBy(1);
            reportqutsubsidy.setCreateDate(new Date());
            reportqutsubsidy.setUpDate(new Date());
            reportqutsubsidy.setUpdateBy(2);
            reportqutsubsidy.setStatus(0);
            reportqutsubsidy.setDailyCost(DailyCost);
            reportqutsubsidy.setNums(nums);
            reportqutsubsidy.setGuideNum(guideNum);
            Integer num=reportqutsubsidyService.saveReportqutsubsidy(reportqutsubsidy);
            logger.info("method:savereportaccommodation 导游补助明细新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("住宿报账成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:savereportaccommodation 导游补助明细新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }
}
