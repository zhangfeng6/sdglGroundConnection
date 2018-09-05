package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店类型业务接口
 **/
public interface RoomTypeService {

    /**
     * 判断该酒店下是否存在该类型
     * @param hotelId
     * @param valueId
     * @return
     */
    Boolean judgeTypeName(Integer hotelId,Integer valueId)throws Exception;

    /**
     * 查询房间类型(贾晓亮：房间名称)
     * @param hotelId
     * @return
     */
    List<RoomType> roomType_All(@Param("hotelId")Integer hotelId)throws Exception;
}
