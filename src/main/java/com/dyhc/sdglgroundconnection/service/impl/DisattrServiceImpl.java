package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DisattrMapper;
import com.dyhc.sdglgroundconnection.pojo.Disattr;
import com.dyhc.sdglgroundconnection.service.DisattrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度景点业务实现
 **/
@Service
public class DisattrServiceImpl implements DisattrService {

    @Autowired
    private DisattrMapper disattrMapper;

    @Autowired
    private  ScenicspotServiceImpl scenicspotService;
    @Autowired
    private  DispatchServiceImpl dispatchService;//调度表

    /**
     * 查询调度景点信息
     * @param offerId
     * @return
     */
    @Override
    public Disattr disattr(Integer offerId)throws Exception {
        offerId=1;
        Disattr Disattr=disattrMapper.disattr(offerId);
        Disattr.setScenicspot(scenicspotService.ShowScenicSpotId(Disattr.getScenicSpotId()));
        Disattr.setDispatch(dispatchService.dispatchSelectAll(Disattr.getOfferId()));
        return Disattr;
    }
}
