package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Reportrestaurant;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账餐厅业务接口
 **/
public interface ReportrestaurantService {
    /**
     * 导游报账餐厅：贾晓亮
     * @param reportrestaurant
     * @return
     */
    Integer saveReportrestaurant(Reportrestaurant reportrestaurant)throws Exception;


    /**
     * 获取导游餐厅报账明细信息
     * @param reportDetailId
     * @return
     * @throws Exception
     */
    List<Reportrestaurant> listReportrestaurantById(Integer reportDetailId)throws Exception;
}
