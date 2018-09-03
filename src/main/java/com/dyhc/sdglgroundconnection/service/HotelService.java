package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店业务接口
 **/
public interface HotelService {

    PageInfo<Hotel> listHotels(Integer pageNo,Integer PageSize) throws Exception;

    /**
     * 获取所有酒店信息 张枫
     * @return
     * @throws Exception
     */
    List<Hotel> listHotelNoPage() throws Exception;

    /**
     * 根据id获取指定的酒店信息 张枫
     * @param id
     * @return
     * @throws Exception
     */
    Hotel getHotelById(Integer id) throws Exception;


    /**
     * 赵伟伟
     * 查询酒店
     * @return
     * @throws Exception
     */
    List<Hotel> selectHotel() throws Exception;


    /**
     * 按编号查询景点
     * @param
     * @return
     */
    Hotel selectByHotelId(Integer hotelId)throws Exception;

    /**
     *查询酒店表:小亮
     * @return
     * @throws Exception
     */
    PageInfo<Hotel> hotelShowAll(Integer pageNo,Integer pageSize,String hotelName)throws  Exception;

    /**
     * 根据酒店表的编号查询下面的房间:小亮
     * @param hotelId
     * @return
     */
    List<RoomType> roomTypeList(Integer hotelId) throws  Exception;

    /**
     * 新增酒店信息
     * @param hotel
     * @return
     */
    Integer saveHotel(Hotel hotel) throws  Exception;

    /**
     * 修改酒店信息
     * @param hotel
     * @return
     * @throws Exception
     */
    Integer updateHotel(Hotel hotel)throws Exception;


    /**
     * 删除酒店下房间
     * @param hotelId
     * @return
     */
    Integer removeRoomType(Integer hotelId)throws  Exception;

    /**
     * 删除酒店信息
     * @param removeHoter
     * @return
     * @throws Exception
     */
    Integer removeHotel(Integer removeHoter)throws  Exception;
    /**
     * 新增房间信息
     * @param roomType
     * @return
     */
    Integer saveRommType(RoomType roomType)throws  Exception;

    /**
     * 修改房间信息
     * @param roomType
     * @return
     * @throws Exception
     */
    Integer updateRoomType(RoomType roomType)throws  Exception;

    /**
     * 酒店房间修改赋值:贾晓亮
     * @param typeId
     * @return
     */
    RoomType fuzhiRoomType(Integer typeId)throws  Exception;
    /**
     * 修改酒店进行赋值操作：贾晓亮
     * @param hotelId
     * @return
     * @throws Exception
     */
    Hotel fuzhiHotel(Integer hotelId)throws Exception;


    List<Dictionaries> selectRoomType()throws Exception;


    /**
     * 根据id查询餐馆数量
     * @param valueId
     * @param
     * @return
     */
    int selectTypeById(Integer valueId,Integer hotelId)throws Exception;

}
