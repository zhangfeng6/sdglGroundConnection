package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点
 **/
@Mapper
@Component
public interface ScenicspotMapper extends CommonMapper<Scenicspot>{

    /**
     * 根据名称、地址、等级查询景点
     * @param typeId
     * @return
     */
    List<Scenicspot> listScenicspots(@Param("typeId") Integer typeId, @Param("scenicSpotName")String scenicSpotName, @Param("scenicSpotAddress") String scenicSpotAddress)throws Exception;

    /**
     * 根据父景点编号查询景点名称
     * @param parentId
     * @return
     */
    List<Scenicspot> getScenicspotByParentId(@Param("parentId") Integer parentId)throws Exception;

    /**
     * 修改景点信息
     * @param scenicspot
     */
    void updateScenicspot(Scenicspot scenicspot)throws  Exception;


    /**
     * 根据景点id删除该景点
     * @param scenicSpotId
     */
    void deleteScenicspotById(@Param("scenicSpotId") Integer scenicSpotId)throws  Exception;


    /**
     * 按编号查询景点
     * @param scenicSpotId
     * @return
     */
    Scenicspot selectByScenicSpotId(@Param("scenicSpotId") Integer scenicSpotId)throws  Exception;
    /**
     * 按编号查询景点
     * @param scenicSpotId
     * @return
     */
    List<Scenicspot> ShowScenicSpotId(@Param("scenicSpotId") Integer scenicSpotId)throws  Exception;

    /**
     * 根据父景点名称
     * @return
     */
    List<Scenicspot> getScenicspotParentName()throws Exception;


    /**
     * 查询所有景点
     * @return
     */
    List<Scenicspot> selectAllScenic()throws Exception;

    /**
     * 获取所有未删除的景点信息 张枫
     * @return
     * @throws Exception
     */
    List<Scenicspot> listNoDelScenicspot()throws Exception;
}
