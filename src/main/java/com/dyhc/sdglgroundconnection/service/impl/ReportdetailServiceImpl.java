package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ReportdetailMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.pojo.Reportrestaurant;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.service.ReportdetailService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细业务实现
 **/
@Service
public class ReportdetailServiceImpl implements ReportdetailService {

    @Autowired
    private ReportdetailMapper reportdetailMapper;
    @Autowired
    private  ReportaccommodationServiceImpl reportaccommodationService;//住宿
    @Autowired
    private ReportrestaurantServiceImpl reportrestaurantService;//餐厅
    @Autowired
    private  ReportticketServiceImpl reportticketService;//门票
    @Autowired
    private  ReportfareServiceImpl reportfareService;//车票
    @Autowired
    private ReportqutsubsidyServiceImpl reportqutsubsidyService;//导游报价出团补助
    @Autowired
    private  ReportingotherexpensesServiceImpl reportingotherexpensesService;//其他支出



    @Override
    public PageInfo showInfoAll(Integer groupNumber, Integer states,Integer pageNo,Integer pageSize)throws Exception {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Reportdetail> list=reportdetailMapper.showInfoAll(groupNumber,states);
        PageInfo<Reportdetail> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public Reportdetail getReportdetailById(Integer reportDetailId) throws Exception {
        return reportdetailMapper.selectByPrimaryKey(reportDetailId);
    }

    /**
     * 查看地接报价明细信息
     * @param dispatchId
     * @return
     */
    @Override
    public Reportdetail reportdetail(Integer dispatchId)throws Exception {
        Reportdetail a = null;
        try {
            a = reportdetailMapper.reportdetail(dispatchId);
            a.setReportaccommodationShow(reportaccommodationService.listReportaccommodationByreportDetailId(a.getReportDetailId()));
            a.setReportrestaurant(reportrestaurantService.listReportrestaurantById(a.getReportDetailId()));
            a.setReportticket(reportticketService.listReportticketById(a.getReportDetailId()));
            a.setReportfare(reportfareService.listReportfareById(a.getReportDetailId()));
            a.setReportqutsubsidy(reportqutsubsidyService.getReportqutsubsidyById(a.getReportDetailId()));
            a.setReportingotherexpenses(reportingotherexpensesService.listReportingotherexpensesById(a.getReportDetailId()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @Override
    public Integer tgShenHe(Integer reportDetailId) throws Exception {
        try {
            reportdetailMapper.tgShenHe(reportDetailId);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Integer bhShenHe(Integer reportDetailId) throws Exception {
        try {
            reportdetailMapper.bhShenHe(reportDetailId);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Integer jsShenHe(Integer reportDetailId) throws Exception {
        try {
            reportdetailMapper.jsShenHe(reportDetailId);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    /**
     * 查询报账类型名称:贾晓亮
     * @return
     */
    @Override
    public List<Dictionaries> baozhangType()throws Exception {
        return reportdetailMapper.baozhangType();
    }

    /**
     * 新增总报账：贾晓亮
     * @param reportdetail
     * @return
     */
    @Override
    public Integer save_Reportfetails(Reportdetail reportdetail)throws Exception {
        return reportdetailMapper.insert(reportdetail);
    }
}
