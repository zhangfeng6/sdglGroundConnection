package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;

import org.apache.ibatis.annotations.Param;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;
public interface TourismtemplateService {
    /**
     * 查询全部旅游模板
     * @return
     */
    List<Tourismtemplate> selectTourismtemplate()throws Exception;

    /**
     * 赵伟伟
     * 添加模板
     * @return
     */
    int addTourismtemplate(Tourismtemplate tourismtemplate) throws Exception;


    /**
     * 赵伟伟
     * 按名称查询模板
     * @return
     */
    Tourismtemplate selectByName(String tourismtemplateName) throws Exception;



    /**
     * 根据模板名称和创建人查询符合条件的模板信息    张枫
     * @param tempName  模板名称
     * @param username  创建人
     * @return
     * @throws Exception
     */
    PageInfo<Tourismtemplate> listtemplate(String tempName,String username,Integer pageNo,Integer pageSize)throws Exception;

    /**
     * 根据模板id删除模板和 派生表信息
     * @param tid
     * @return
     * @throws Exception
     */
    int removetourismtemplate(Integer tid)throws Exception;

    /**
     * 根据模板名称判断该名称是否可用
     * @param temName
     * @return
     * @throws Exception
     */
    boolean getinfoBytemName(String temName)throws Exception;

    /**
     * 新增模板操作
     * @param temName
     * @param info
     * @return
     */
    int savetourismtermplate(String temName,Integer[] info,Integer id)throws Exception;
    /**
     * 根据模板id获取所有符合条件的派生表信息
     * @param tid
     * @return
     */
    Map<String,Object> listtandlBytid(Integer tid) throws  Exception;
}
