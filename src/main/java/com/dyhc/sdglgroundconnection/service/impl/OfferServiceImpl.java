package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OfferMapper;
import com.dyhc.sdglgroundconnection.pojo.Offer;
import com.dyhc.sdglgroundconnection.service.OfferService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价信息业务实现
 **/
@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferMapper offerMapper;

    @Override
    public PageInfo<Offer> selectOffer(Integer pageNo,Integer PageSize,String travelName)throws Exception {
        PageHelper.startPage(pageNo, PageSize, true);
        List<Offer> list = offerMapper.selectOffer(travelName);
        PageInfo<Offer> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insertOffer(Offer offer) throws Exception {
        return offerMapper.insertOffer(offer);
    }

    @Override
    public Offer selectOfferByOfferId(int offerId)throws Exception {
        return offerMapper.selectOfferByOfferId(offerId);
    }

    @Override
    public int queren(int offerId)throws Exception {
        return offerMapper.queren(offerId);
    }
}
