package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Disattr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度景点
 **/
@Mapper
@Component
public interface DisattrMapper extends CommonMapper<Disattr>{
    /**
     * 查询调度景点表
     * @param offerId
     * @return
     */
  Disattr disattr(@Param("offerId") Integer offerId)throws  Exception;

    /**
     * 根据调度id获取调度景点表信息  张枫
     * @param Did
     * @return
     * @throws Exception
     */
  List<Disattr> listDisattrByDid(@Param("Did")Integer Did)throws Exception;

    /**
     * 根据调度id删除 调度景点信息  张枫
     * @param Did
     * @return
     * @throws Exception
     */
  int removeDisattrByDid(@Param("Did")Integer Did)throws Exception;
}
