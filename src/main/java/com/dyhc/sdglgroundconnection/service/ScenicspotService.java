package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.mapper.CommonMapper;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点业务接口
 *
 **/
public interface ScenicspotService {

    /**
     * 根据名称、地址、等级状态查询景点
     * @param typeId
     * @return
     */
    PageInfo<Scenicspot> listScenicspots(Integer typeId, String scenicSpotName, String scenicSpotAddress, Integer pageNo, Integer pageSize) throws Exception;



    /**
     * 根据父景点编号查询景点名称
     * @param parentId
     * @return
     */
    PageInfo<Scenicspot> getScenicspotByParentId(Integer parentId)throws Exception;

    /**
     * 根据父景点名称
     * @return
     */
    List<Scenicspot> getScenicspotParentName()throws Exception;


    /**
     * 添加景点信息
     * @param scenicspot
     * @return
     */
    Integer insertScenicspot(Scenicspot scenicspot)throws Exception;


    /**
     * 根据景点id查询该景点信息
     * @param scenicSpotId
     * @return
     */
    Scenicspot getScenicspotById(Integer scenicSpotId)throws Exception;

    /**
     * 修改景点信息
     * @param scenicspot
     */
    Integer updateScenicspot(Scenicspot scenicspot)throws Exception;



    /**
     * 根据景点id删除该景点
     * @param scenicSpotId
     */
    Integer deleteScenicspotById(Integer scenicSpotId)throws Exception;

    /**
     * 查看所有景点信息   张枫
     * @return
     * @throws Exception
     */
    List<Scenicspot> listScenicspotAll() throws Exception;


    /**
     * 按编号查询景点
     * @param scenicSpotId
     * @return
     */
    Scenicspot selectByScenicSpotId(Integer scenicSpotId)throws Exception;
    /**
     * 按编号查询景点
     * @param scenicSpotId
     * @return
     */
    List<Scenicspot> ShowScenicSpotId(Integer scenicSpotId)throws Exception;


    /**
     * 查询所有景点
     * @return
     */
    List<Scenicspot> selectAllScenic()throws Exception;
}
