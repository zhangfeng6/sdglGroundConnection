package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.parameterentity.TemplateParameter;
import com.dyhc.sdglgroundconnection.pojo.Template;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

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
}
