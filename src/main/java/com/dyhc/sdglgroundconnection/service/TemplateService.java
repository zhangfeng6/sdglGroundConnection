package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.parameterentity.TemplateParameter;
import com.dyhc.sdglgroundconnection.pojo.Template;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板业务接口
 **/
public interface TemplateService {

    /**
     * 根据模板名称或创建人名称查找符合条件的模板信息  张枫
     * @param tempName  模板名称
     * @param userName  创建人名称
     * @param pageNo    当前页
     * @param pageSize  每页显示量
     * @return
     * @throws Exception
     */
    PageInfo<Template> listtemplate(String tempName, String userName, Integer pageNo, Integer pageSize)throws Exception;
    /**
     * 根据模板名称返回模板对象  判读是否存在    张枫
     * @param templateName
     * @return
     * @throws Exception
     */
    Template gettemplateByName(String templateName) throws Exception;

    /**
     * 新增模板信息       张枫
     * @param template
     * @return
     */
    int savetemplate(TemplateParameter template)throws Exception;



    /**
     * 赵伟伟
     * 查询全部模板
     * @return
     */
    List<Template> selectTemplate() throws Exception;


    /**
     * 赵伟伟
     * 按编号查询线路信息
     * @param templateId
     * @return
     */
    Template selectTemplateAll(int templateId)throws Exception;



    /**
     * 赵伟伟
     * 按编号查询
     * @param templateId
     * @return
     */
    Template selecctNameById(int templateId)throws Exception;


    /**
     * 根据线路模板id查找符合条件的信息
     * @param tid
     * @return
     */
    Map<String,Object> gettemplateById(Integer tid)throws Exception;

    /**
     * 修改模板信息
     * @param template  模板对象
     * @return
     * @throws Exception
     */
    int updatetemplate(Template template)throws Exception;

    /**
     * 删除模板信息
     * @param mid
     * @return
     */
    int removetemplate(Integer mid)throws Exception;

    /**
     * 获取所有线路信息
     * @return
     */
    List<Template> listtemplateall()throws Exception;

    /**
     * 查看路线
     * @param dispatchId
     * @return
     */
    Template listTemplate(Integer dispatchId)throws Exception;

}
