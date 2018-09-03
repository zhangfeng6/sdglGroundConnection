package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.Reportaccommodation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账住宿业务接口
 **/
public interface ReportaccommodationService {
    /**
     * 导游报账住宿：贾晓亮
     * @param reportaccommodation
     * @return
     */
   Integer saveReportaccommodation(Reportaccommodation reportaccommodation)throws Exception;


    /**
     * 根据导游到账明细id查询导游住宿报账明细信息
     * @param reportDetailId 导游报账明细id
     * @return
     * @throws Exception
     */
   List<Reportaccommodation> listReportaccommodationByreportDetailId(Integer reportDetailId)throws Exception;

    /**
     * 新增报账住宿
     * @param reportaccommodation
     * @return
     */
    Integer   save_Reportaccommodation(Reportaccommodation reportaccommodation)throws Exception;
}
