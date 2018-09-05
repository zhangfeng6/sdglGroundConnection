package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DictionariesMapper;
import com.dyhc.sdglgroundconnection.mapper.RoomTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.RoomType;
import com.dyhc.sdglgroundconnection.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店类型业务实现
 **/
@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeMapper roomTypeMapper;
    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Override
    public Boolean judgeTypeName(Integer hotelId, Integer valueId) throws Exception {
        RoomType roomType=roomTypeMapper.getroomtypeByName(hotelId, valueId);
        boolean flag=true;
        if(roomType!=null){
            flag=false;
        }
        return  flag;
    }

    /**
     * 查询酒店下面的房间类型名称（贾晓亮）
     * @param hotelId
     * @return9
     */
    @Override
    public List<RoomType> roomType_All(Integer hotelId)throws Exception {
        List<RoomType> ko = null;
        ko = roomTypeMapper.roomType_All(hotelId);
        for (RoomType s:ko) {
                    Dictionaries dictionaries=dictionariesMapper.dis_All(s.getValueId());
                    s.setTypeName(dictionaries.getValueContent1());
        }
        return ko;
    }
}
