package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Disshopp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度购物
 **/
@Mapper
@Component
public interface DisshoppMapper extends CommonMapper<Disshopp>{


    /**
     *微信小程序之获取购物地点
     * @param dispatchId
     * @param weight
     * @return
     */
    List<Disshopp> getDisshoppById(@Param("dispatchId") Integer dispatchId,@Param("weight") Integer weight)throws Exception;

    /**
     * 查看购物地点
     * @return
     */
    List<String> listDisshoppAll(Integer dispatchId);

    /**
     * 根据调度id获取调度购物地表数据  张枫
     * @param Did
     * @return
     * @throws Exception
     */
    List<Disshopp> listDisshoppByDid(@Param("Did")Integer Did)throws Exception;
}
