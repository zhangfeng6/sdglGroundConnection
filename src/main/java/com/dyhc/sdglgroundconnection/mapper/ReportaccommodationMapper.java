package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Reportaccommodation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账住宿
 **/
@Mapper
@Component
public interface ReportaccommodationMapper extends CommonMapper<Reportaccommodation>{

    /**
     * 根据导游到账明细id查询导游住宿报账明细信息
     * @param reportDetailId 导游报账明细id
     * @return
     * @throws Exception
     */
    List<Reportaccommodation> listReportaccommodationByreportDetailId(@Param("reportDetailId") Integer reportDetailId)throws Exception;

    /**
     * 查询全部酒店：贾晓亮
     * @return
     */
    List<Reportaccommodation>  reportaccommodation()throws  Exception;



}
