package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Reportdetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细
 **/
@Mapper
@Component
public interface ReportdetailMapper extends CommonMapper<Reportdetail>{

    /**
     * 获取所有导游报账明细
     * @param groupNumber
     * @param states
     * @return
     */
    List<Reportdetail> showInfoAll(@Param("groupNumber") Integer groupNumber, @Param("states")Integer states);

    /**
     * 查询地接导游报账明细：贾晓亮
     * @param dispatchId
     * @return
     */
    Reportdetail reportdetail(@Param("dispatchId")Integer dispatchId);

    /**
     * 通过导游报账的审核
     * @param reportDetailId
     * @return
     */
    void tgShenHe(@Param("reportDetailId") Integer reportDetailId)throws Exception;

    /**
     * 通过导游报账的审核
     * @param reportDetailId
     * @return
     */
    void bhShenHe(@Param("reportDetailId") Integer reportDetailId)throws Exception;

    /**
     * 结算导游报账
     * @param reportDetailId
     * @return
     */
    void jsShenHe(@Param("reportDetailId") Integer reportDetailId)throws Exception;
    /**
     * 查询报账类型
     * @return
     */
    List<Dictionaries> baozhangType();

    /**
     * 报账字表插入总表的报账ID
     * @param dispatchId
     * @return
     */
    Reportdetail All_dispatchId(@Param("dispatchId")Integer dispatchId);



}
