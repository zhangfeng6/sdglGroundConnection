package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Guide;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游
 **/
@Mapper
@Component
public interface GuideMapper extends CommonMapper<Guide>{
    /**
     * 分页查询导游信息表
     * @param pageNo
     * @param PageSize
     * @param guideName
     * @return
     */
    List<Guide> listGuide(@Param("pageNo") Integer pageNo, @Param("PageSize") Integer PageSize,@Param("guideName")  String guideName)throws  Exception;


    /**
     * 微信小程序之导游登录
     * @param username
     * @param password
     * @return
     */
    Guide login(@Param("username") String username,@Param("password")String password)throws Exception;

    /**
     * 查询导游信息
     * @param guideId
     * @return
     */
    Guide ShowAllGuide(@Param("guideId")Integer guideId)throws  Exception;




    /**
     * 获取所有导游名称
     * @return
     * @throws Exception
     */
    List<Guide> listGuideName()throws Exception;

    /**
     * 判断是否有重复的导游证件数据
     * @param certificate
     * @return
     */
    Guide  pdcertificate(@Param("certificate") String certificate)throws  Exception;

    /**
     *修改导游头像
     * @param guideId
     * @param tx
     * @throws Exception
     */
    void updateTX(@Param("guideId") Integer guideId,@Param("tx") String tx)throws Exception ;

    /**
     * 获取没删除的所有导游信息
     * @return
     * @throws Exception
     */
    List<Guide> listNoDelGuide()throws Exception;

    /**
     * 判断导游信息是否有重复
     * @param username
     * @return
     */
    Guide panduanGuide(String username)throws Exception;
}
