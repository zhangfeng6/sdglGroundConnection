package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.HotelMapper;
import com.dyhc.sdglgroundconnection.mapper.RoomTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Hotel;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import com.dyhc.sdglgroundconnection.service.HotelService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店业务实现
 **/
@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelMapper hotelMapper;
    /**
     * 房间类型信息
     */
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    /**
     *获取酒店线面房间的信息
     * @param hotelId
     * @return
     * @throws Exception
     */
    public  List<RoomType> roomTypeList(Integer hotelId)throws Exception{
        return roomTypeMapper.RoomTypeShowAll(hotelId);
    }
    /**
     * 查询酒店标的数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    public PageInfo<Hotel> hotelShowAll(Integer pageNo, Integer pageSize,String hotelName)throws  Exception {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Hotel> hotels=hotelMapper.HotelShowAll(pageNo,pageSize,hotelName);
        for (Hotel h :hotels) {
            Integer as =h.getHotelId();
           h.setRoomTypesList(roomTypeMapper.RoomTypeShowAll(h.getHotelId()));
        }
        PageInfo<Hotel> pageInfo = new PageInfo<>(hotels);
        return pageInfo;
    }

    /**
     * 酒店新增：贾晓亮
     * @param hotel
     * @return
     */
    public Integer saveHotel(Hotel hotel) throws  Exception{
        hotel.setStatus(1);
        hotel.setWhetherDel(0);
        hotel.setCreateBy(1);
        hotel.setUpdateBy(2);
        hotel.setCreateDate(new Date());
        hotel.setUpdateDate(new Date());
       Integer number=0;
        try {
            number=hotelMapper.insert(hotel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  number;
    }

    /**
     * 修改酒店信息
     * @return
     */
   public  Integer updateHotel(Hotel hotel)throws Exception{
       hotel.setStatus(1);
       hotel.setWhetherDel(0);
       hotel.setCreateDate(new Date());
       hotel.setUpdateDate(new Date());
       hotel.setCreateBy(1);
       hotel.setUpdateBy(2);
       Integer number=0;
       try {
           number=hotelMapper.updateByPrimaryKeySelective(hotel);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return  number;
   }

    /**
     * 删除酒店下的房间
     * @param hotelId
     * @return
     * @throws Exception
     */
    public Integer removeRoomType(Integer hotelId) throws  Exception{
        Integer number=0;
        try {
            number=roomTypeMapper.removeRoomType(hotelId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  number;
    }

    /**
     * 酒店房间修改赋值
     * @param hotelId
     * @return
     * @throws Exception
     */
    public RoomType fuzhiRoomType(Integer hotelId) throws  Exception{
        RoomType number =hotelMapper.fuzhiRoomType(hotelId);
        return  number;
    }
    /**
     * 酒店修改赋值
     * @param hotelId
     * @return
     * @throws Exception
     */
    public Hotel fuzhiHotel(Integer hotelId) throws  Exception{
        Hotel number =hotelMapper.fuzhiHotel(hotelId);
        return  number;
    }

    @Override
    public List<Dictionaries> selectRoomType()throws Exception {
        return hotelMapper.selectRoomType();
    }

    @Override
    public int selectTypeById(Integer valueId, Integer hotelId)throws Exception {
        return hotelMapper.selectTypeById(valueId,hotelId);
    }


    /**
     * 删除酒店信息
     * @param hotelId
     * @return
     * @throws Exception
     */
    public Integer removeHotel(Integer hotelId) throws  Exception{
        Integer number=0;
        try {
            number=hotelMapper.removeHoter(hotelId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  number;
    }
    /**
     * 新增酒店房间信息
     * @return
     * @throws Exception
     */
    public Integer saveRommType(RoomType roomType) throws  Exception{
        roomType.setWhetherDel(0);
        roomType.setCreateBy(1);
        roomType.setCreateDate(new Date());
        Integer number=0;
        try {
            number=roomTypeMapper.insert(roomType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  number;
    }

    /**
     * 修改酒店信息
     * @return
     * @throws Exception
     */
    public Integer updateRoomType(RoomType roomType) throws  Exception{
        roomType.setUpdateDate(new Date());
        roomType.setUpdateBy(2);
        Integer number=0;
        try {
            number=roomTypeMapper.updateByPrimaryKeySelective(roomType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  number;
    }

    /**
     * 获取所有酒店信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Hotel> listHotelNoPage() throws Exception {
        return hotelMapper.listNoDelHotel();
    }
    public PageInfo<Hotel> listHotels(Integer pageNo, Integer PageSize) {
        PageHelper.startPage(pageNo, PageSize, true);
        PageInfo<Hotel> pageInfo = new PageInfo<>(hotelMapper.selectAll());
        return pageInfo;
    }
    /**
     * 根据id获取指定的酒店信息
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public Hotel getHotelById(Integer id) throws Exception {
        return hotelMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Hotel> selectHotel() throws Exception {
        return hotelMapper.selectAll();
    }

    @Override
    public Hotel selectByHotelId(Integer hotelId)throws Exception {
        return hotelMapper.selectByHotelId(hotelId);
    }
}
