package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OfferrestaurantMapper;
import com.dyhc.sdglgroundconnection.pojo.Offerrestaurant;
import com.dyhc.sdglgroundconnection.service.OfferrestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价餐厅业务实现
 **/
@Service
public class OfferrestaurantServiceImpl implements OfferrestaurantService {

    @Autowired
    private OfferrestaurantMapper offerrestaurantMapper;

    @Override
    public int insertOfferrestaurant(Offerrestaurant offerrestaurant)throws Exception {
        return offerrestaurantMapper.insertOfferrestaurant(offerrestaurant);
    }

    @Override
    public List<Offerrestaurant> selectOfferRestaurantByOfferId(int offerId) throws Exception{
        return offerrestaurantMapper.selectOfferRestaurantByOfferId(offerId);
    }
}
