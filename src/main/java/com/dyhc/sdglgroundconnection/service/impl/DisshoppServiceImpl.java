package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DisshoppMapper;
import com.dyhc.sdglgroundconnection.pojo.Disshopp;
import com.dyhc.sdglgroundconnection.service.DisshoppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度购物业务实现
 **/
@Service
public class DisshoppServiceImpl implements DisshoppService {

    @Autowired
    private DisshoppMapper disshoppMapper;

    @Override
    public List<Disshopp> getDisshoppById(Integer dispatchId, Integer weight) throws Exception {
        return disshoppMapper.getDisshoppById(dispatchId,weight);
    }
    /**
     * 查看购物地点
     * @return
     */
    @Override
    public List<String> listDisshoppAll(Integer dispatchId) {
        return disshoppMapper.listDisshoppAll(dispatchId);
    }
}
