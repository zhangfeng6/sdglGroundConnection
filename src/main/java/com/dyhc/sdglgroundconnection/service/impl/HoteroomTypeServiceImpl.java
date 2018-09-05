package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.HoteroomTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.HoteroomType;
import com.dyhc.sdglgroundconnection.service.HoteroomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度酒店房间类型业务实现
 **/
@Service
public class HoteroomTypeServiceImpl implements HoteroomTypeService {

    @Autowired
    private HoteroomTypeMapper hoteroomTypeMapper;

    @Override
    public HoteroomType getHoteroomTypeById(Integer dispatchId, Integer weight) throws Exception {
        return hoteroomTypeMapper.getHoteroomTypeById(dispatchId,weight);
    }
    /**
     * 查看线路信息
     * @return
     */
    @Override
    public List<HoteroomType> listOfferlineAll(Integer dispatchId)throws Exception {
        return hoteroomTypeMapper.listOfferlineAll(dispatchId);
    }
}
