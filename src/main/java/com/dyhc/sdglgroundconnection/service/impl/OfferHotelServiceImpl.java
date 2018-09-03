package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OfferHotelMapper;
import com.dyhc.sdglgroundconnection.pojo.OfferHotel;
import com.dyhc.sdglgroundconnection.service.OfferHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价酒店业务实现
 **/
@Service
public class OfferHotelServiceImpl implements OfferHotelService {

    @Autowired
    private OfferHotelMapper offerHotelMapper;

    @Override
    public int insertOfferHotel(OfferHotel offerHotel)throws Exception {
        return offerHotelMapper.insertOfferHotel(offerHotel);
    }

    @Override
    public List<OfferHotel> selectOfferHotelByOfferId(int offerId) throws Exception{
        return offerHotelMapper.selectOfferHotelByOfferId(offerId);
    }
}
