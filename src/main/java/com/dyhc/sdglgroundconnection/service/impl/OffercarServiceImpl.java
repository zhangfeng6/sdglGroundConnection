package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OffercarMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Offercar;
import com.dyhc.sdglgroundconnection.service.OffercarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价用车业务实现
 **/
@Service
public class OffercarServiceImpl implements OffercarService {

    @Autowired
    private OffercarMapper offercarMapper;

    @Override
    public int insertOffercar(Offercar offercar)throws Exception {
        return offercarMapper.insertOffercar(offercar);
    }

    @Override
    public Offercar selectOffercarByOfferId(int offerId)throws Exception {
        return offercarMapper.selectOffercarByOfferId(offerId);
    }

    @Override
    public Dictionaries selectOffercarById(int valueId)throws Exception {
        return offercarMapper.selectOffercarById(valueId);
    }
}
