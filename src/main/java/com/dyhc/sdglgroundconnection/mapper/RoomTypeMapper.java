package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店类型
 **/
@Mapper
@Component
public interface RoomTypeMapper extends CommonMapper<RoomType>{

    /***
     * 按照酒店编号查询酒店下的房间贾晓亮
     * @param hotelId
     * @return
     */
    List<RoomType> RoomTypeShowAll(Integer hotelId)throws  Exception;

    /**
     * 对房间类型表进行删除
     * @param hotelId
     * @return
     */
    Integer removeRoomType(@Param("hotelId")Integer hotelId)throws  Exception;

    /**
     * 判断该公司下是否存在该类型
     * @param hotelId
     * @param valueId
     * @return
     */
    RoomType getroomtypeByName(@Param("hotelId")Integer hotelId,@Param("valueId")Integer valueId)throws  Exception;
    /**
     * 查询房间类型(贾晓亮：房间名称)
     * @param hotelId
     * @return
     */
    List<RoomType> roomType_All(@Param("hotelId")Integer hotelId)throws  Exception;

    /**
     * 查询酒店Id
     * @param typeId
     * @return
     */
    RoomType type_Id(@Param("typeId")Integer typeId)throws  Exception;

}
