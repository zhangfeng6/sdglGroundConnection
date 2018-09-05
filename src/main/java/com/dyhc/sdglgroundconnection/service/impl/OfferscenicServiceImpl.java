package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.OfferscenicMapper;
import com.dyhc.sdglgroundconnection.pojo.Offerscenic;
import com.dyhc.sdglgroundconnection.service.OfferscenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价景点业务实现
 **/
@Service
public class OfferscenicServiceImpl implements OfferscenicService {

    @Autowired
    private OfferscenicMapper offerscenicMapper;

    @Override
    public int insertOfferscenic(Offerscenic offerscenic)throws Exception {
        return offerscenicMapper.insertOfferscenic(offerscenic);
    }

    @Override
    public List<Offerscenic> selectOfferscenicByOfferId(int offerId)throws Exception {
        return offerscenicMapper.selectOfferscenicByOfferId(offerId);
    }
}
