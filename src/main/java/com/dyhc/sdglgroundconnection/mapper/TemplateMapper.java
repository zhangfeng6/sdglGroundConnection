package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.pojo.Template;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板
 **/
@Mapper
@Component
public interface TemplateMapper  extends CommonMapper<Template>{

    /**
     * 根据模板名称和创建人查询符合条件的模板信息    张枫
     * @param tempName  模板名称
     * @param username  创建人
     * @return
     * @throws Exception
     */
    List<Template> listtemplate(@Param("tempName")String tempName,@Param("username")String username)throws Exception;

    /**
     * 根据模板名称返回模板对象  判读是否存在    张枫
     * @param templateName
     * @return
     * @throws Exception
     */
    Template gettemplateByName(@Param("templateName")String templateName) throws Exception;

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
    Template selectTemplateAll(@Param("templateId") int templateId)throws Exception;



    /**
     * 赵伟伟
     * 按编号查询景点信息
     * @param templateId
     * @return
     */
    List<Scenicspot> selectscenicSpotById(@Param("templateId") int templateId)throws Exception;


    /**
     * 赵伟伟
     * 按编号查询
     * @param templateId
     * @return
     */
    Template selecctNameById(@Param("templateId") int templateId)throws Exception;

    /**
     * 查看路线
     * @param templateId
     * @return
     */
    Template listTemplate(Integer templateId)throws Exception;
}
