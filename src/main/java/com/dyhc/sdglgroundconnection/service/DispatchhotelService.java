package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店业务接口
 **/
public interface DispatchhotelService {

    /**
     * 查询调度酒店信息：贾晓亮
     * @param offerId
     * @return
     */
    List<Dispatchhotel> dispatchhotelSelectAll(Integer  offerId)throws Exception;



    /**
     * 根据调度id获取调度酒店信息
     * @param dispatchId
     * @return
     * @throws Exception
     */
    Dispatchhotel getDispatchHotel(Integer dispatchId,Integer weight)throws Exception;


    /**
     * 查看住宿地点
     * @return
     */
    List<String> listDispatchhotelAll(Integer dispatchId)throws Exception;

}
