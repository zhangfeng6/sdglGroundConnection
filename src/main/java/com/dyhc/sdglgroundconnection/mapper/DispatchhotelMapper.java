package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dispatchhotel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店
 **/
@Mapper
@Component
public interface DispatchhotelMapper extends CommonMapper<Dispatchhotel>{


    /***
     * 调度酒店表信息：贾晓亮
     * @param offerId
     * @return
     */
    List<Dispatchhotel> dispatchhotelSelectAll(@Param("offerId")Integer offerId)throws  Exception;


    /**
     * 根据调度id获取调度酒店信息
     * @param dispatchId
     * @return
     */
    Dispatchhotel getDispatchHotel(@Param("dispatchId") Integer dispatchId, @Param("weight")Integer weight)throws  Exception;

    /**
     * 查看住宿地点
     * @return
     */
    List<String> listDispatchhotelAll(Integer dispatchId)throws  Exception;

    /**
     * 根据调度id获取调度酒店表信息
     * @param Did
     * @return
     * @throws Exception
     */
    List<Dispatchhotel> listDispatchhotelByDid(@Param("Did")Integer Did)throws Exception;
}
