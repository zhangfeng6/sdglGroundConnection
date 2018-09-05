package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Tourismandline;
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 模板与线路表关联表
 **/
@Mapper
@Component
public interface TourismandlineMapper extends CommonMapper<Tourismandline>{

    /**
     * 赵伟伟
     * 查询模板中的线路
     * @param tourismId
     * @return
     */
    List<Tourismandline> selectTourismandlineAll(@Param("tourismId") int tourismId)throws Exception;

    /**
     * 根据模板id删除信息   张枫
     * @param tid
     * @return
     * @throws Exception
     */
    int removeTourismandline(@Param("tid")Integer tid)throws Exception;

    /**
     * 获取指定模板的所有线路id
     * @return
     */
    List<Tourismandline> listtlBytid(@Param("tid")Integer tid)throws Exception;

}
