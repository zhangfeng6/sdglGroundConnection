package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.mapper.ReportdetailMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.pojo.Reportqutsubsidy;
import com.dyhc.sdglgroundconnection.pojo.Reportticket;
import com.dyhc.sdglgroundconnection.service.ReportticketService;
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
 * 导游报账门票 控制层
 **/
@RequestMapping("/Reportticket")
@RestController
public class ReportticketController {
    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ReportticketController.class);
    @Autowired
    private ReportticketService reportticketService;
    @Autowired
    private ReportdetailMapper reportdetailMapper;
    /**
     * 导游报账住宿新增
     * @param
     * @return
     */
    @LogNotes(operationType="导游门票明细",content="门票新增")
    @RequestMapping("/saveReportticket")
    public ReponseResult saveReportqutsubsidy(
            @RequestParam("dispatchId")Integer dispatchId,
            @RequestParam("attrName") String attrName,@RequestParam("price") Double price,
            @RequestParam("nums")Integer nums, @RequestParam("payMethods")String payMethods){

        try {
            Reportdetail reportdetail =reportdetailMapper.All_dispatchId(dispatchId);
            Reportticket reportticket =new Reportticket();
            reportticket.setReportDetailId(reportdetail.getReportDetailId());
            reportticket.setCreateBy(1);
            reportticket.setCreateDate(new Date());
            reportticket.setStatus(0);
            reportticket.setAttrName(attrName);
            reportticket.setPrice(price);
            reportticket.setNums(nums);
            reportticket.setPayMethods(payMethods);
            Integer num=reportticketService.saveReportticket(reportticket);
            logger.info("method:saveReportqutsubsidy 导游门票明细新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("门票报账成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:saveReportqutsubsidy 导游门票明细新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }

    /**
     * 获取导游门票报账明细信息
     * @param reportDetailId
     * @return
     */
    @RequestMapping("listReportticketById")
    public ReponseResult listReportticketById(Integer reportDetailId){
        try {
            ReponseResult data=ReponseResult.ok(reportticketService.listReportticketById(reportDetailId),"获取成功");
            logger.info("mothod:listReportticketById 获取成功");
            return data;
        }catch (Exception e){
            logger.error("mothod:listReportticketById 获取失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }
}