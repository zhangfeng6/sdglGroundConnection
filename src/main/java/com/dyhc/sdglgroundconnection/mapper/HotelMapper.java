package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.*;

import com.dyhc.sdglgroundconnection.pojo.Scenicspot;

import com.dyhc.sdglgroundconnection.pojo.RoomType;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店
 **/
@Mapper
@Component
public interface HotelMapper extends CommonMapper<Hotel>{


    /**
     * 按编号查询景点
     * @param
     * @return
             */
    Hotel selectByHotelId(@Param("hotelId") Integer hotelId)throws  Exception;

    /**
     * 查询酒店信息表贾晓亮
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<Hotel> HotelShowAll(@Param("pageNo")Integer pageNo, @Param("pageSize")Integer pageSize, @Param("hotelName")String hotelName)throws  Exception;


    /**
     * 删除酒店信息
     * @param hotelId
     * @return
     * @throws Exception
     */
    Integer removeHoter(Integer hotelId)throws  Exception;

    /**
     * 房间修改赋值
     * @param typeId
     * @return
     */
    RoomType fuzhiRoomType(Integer  typeId)throws  Exception;

    /**
     * 修改酒店进行赋值操作：贾晓亮
     * @param hotelId
     * @return
     * @throws Exception
     */
    Hotel fuzhiHotel(Integer hotelId)throws Exception;

    /**
     * 根据房间类型id获取酒店信息   张枫
     * @param valueId
     * @return
     */
    List<Hotel> listhotelByvalueId(@Param("valueId")Integer valueId)throws Exception;


    List<Dictionaries> selectRoomType()throws  Exception;

    /**
     * 根据id查询餐馆数量
     * @param valueId
     * @param
     * @return
     */
    int selectTypeById(@Param("valueId") Integer valueId,@Param("hotelId") Integer hotelId)throws  Exception;

    /**
     * 获取所有未删除的酒店信息
     * @return
     * @throws Exception
     */
    List<Hotel>   listNoDelHotel()throws Exception;

}
