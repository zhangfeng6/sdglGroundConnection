package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Reportingotherexpenses;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账其他支出业务接口
 **/
public interface ReportingotherexpensesService {

    /***
     *导游报账其他支出：贾晓亮
     * @param reportingotherexpenses
     * @return
     */
    Integer saveReportingotherexpenses(Reportingotherexpenses reportingotherexpenses)throws Exception;


    /**
     * 获取导游报账其他支出明细信息
     * @param reportDetailId
     * @return
     * @throws Exception
     */
    Reportingotherexpenses listReportingotherexpensesById(Integer reportDetailId)throws Exception;
}
