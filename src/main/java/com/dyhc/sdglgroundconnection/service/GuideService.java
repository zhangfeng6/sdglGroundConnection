package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Guide;
import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游业务接口
 **/
public interface GuideService {
    /**
     * 分页查询导游信息表
     * @param pageNo
     * @param PageSize
     * @param guideName
     * @return
     */
    PageInfo<Guide> listGuide(Integer pageNo, Integer PageSize,String guideName)throws Exception;

    /**
     * 删除导游信息
     * @param guideId
     * @return
     */
    Integer removeGuide(Integer guideId) throws  Exception;

    /**
     * 新增导游信息
     * @param guide
     * @return
     * @throws Exception
     */
    Integer saveGuide(Guide guide)throws Exception;

    /**
     * 修改导游信息
     * @param guide
     * @return
     * @throws Exception
     */
    Integer updateGuide(Guide guide)throws  Exception;

    /**
     * 导游修改赋值
     * @param guideId
     * @return
     */
    Guide  assignmentGuide(Integer guideId)throws Exception;

    /**
     * 微信小程序之导游登录
     * @param username
     * @param password
     * @return
     */
    Guide login(String username,String password)throws Exception;


    /**
     * 微信小程序之导游修改密码
     * @param guide
     * @return
     */
    Integer updateGuideByPassword(Guide guide)throws Exception;

   /* *//**
     * 根据条件获取导游安排信息
     * @param year
     * @param month
     * @return
     * @throws Exception
     *//*
    List<Guideschedule>listguidescheduleBygid(Integer guideId, String year, String month)throws Exception;*/

    /**
     * 导游信息
     * @param guideId
     * @return
     */
    Guide ShowAllGuide(Integer guideId)throws Exception;

    List<Guideschedule>listguidescheduleBygid(String year, String month)throws Exception;

    /**
     * 获取导游名称
     * @param guideId
     * @return
     * @throws Exception
     */
    Guide getGuideById(Integer guideId)throws Exception;

    /**
     * 判断是否有重复的导游证件数据
     * @param certificate
     * @return
     */
    Guide  pdcertificate(@Param("certificate") String certificate)throws Exception;

    /**
     * 获取所有导游名称
     * @return
     * @throws Exception
     */
    List<Guide> listGuideName()throws Exception;


    /**
     *修改导游头像
     * @param guideId
     * @param tx
     * @throws Exception
     */
    Integer updateTX(Integer guideId,String tx)throws Exception ;

    /**
     * 判断导游信息是否有重复
     * @param username
     * @return
     */
    Guide panduanGuide(String username)throws Exception;
}
