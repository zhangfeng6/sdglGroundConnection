package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细业务接口
 **/
public interface ReportdetailService {

    /**
     * 获取所有导游报账明细
     * @param groupNumber
     * @param states
     * @return
     */
    PageInfo showInfoAll(Integer groupNumber,Integer states,Integer pageNo,Integer pageSize)throws Exception;


    /**
     * 根据id获取导游报账明细信息：陈庆武
     * @param reportDetailId
     * @return
     * @throws Exception
     */
    Reportdetail getReportdetailById(Integer reportDetailId)throws Exception;

    /**
     * 查询地接导游报账明细：贾晓亮
     * @param dispatchId
     * @return
     */
    Reportdetail reportdetail(Integer dispatchId)throws Exception;


    /**
     * 通过导游报账的审核
     * @param reportDetailId
     * @return
     */
    Integer tgShenHe(Integer reportDetailId)throws Exception;

    /**
     * 通过导游报账的审核
     * @param reportDetailId
     * @return
     */
    Integer bhShenHe(Integer reportDetailId)throws Exception;

    /**
     * 结算导游报账
     * @param reportDetailId
     * @return
     */
    Integer jsShenHe(Integer reportDetailId)throws Exception;

    /**
     * 查询报账类型
     * @return
     */
    List<Dictionaries> baozhangType()throws Exception;

    /**
     * 新增导游报账信息主表（贾晓亮）
     * @return
     */
    Integer save_Reportfetails(Reportdetail  reportdetail)throws Exception;


}
