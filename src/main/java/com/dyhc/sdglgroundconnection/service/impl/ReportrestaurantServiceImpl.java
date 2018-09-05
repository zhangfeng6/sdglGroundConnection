package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ReportrestaurantMapper;
import com.dyhc.sdglgroundconnection.pojo.Reportrestaurant;
import com.dyhc.sdglgroundconnection.service.ReportrestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账餐厅业务实现
 **/
@Service
public class ReportrestaurantServiceImpl implements ReportrestaurantService {

    @Autowired
    private ReportrestaurantMapper reportrestaurantMapper;

    /**
     * 导游报账餐厅新增
     * @param reportrestaurant
     * @return
     */
    @Override
    public Integer saveReportrestaurant(Reportrestaurant reportrestaurant)throws Exception {
        Integer number=0;
        try {
            number=reportrestaurantMapper.insert(reportrestaurant);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return number;
    }

    @Override
    public List<Reportrestaurant> listReportrestaurantById(Integer reportDetailId) throws Exception {
        return reportrestaurantMapper.listReportrestaurantById(reportDetailId);
    }
}
