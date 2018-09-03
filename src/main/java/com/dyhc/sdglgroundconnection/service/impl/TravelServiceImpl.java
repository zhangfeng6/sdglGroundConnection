package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TravelMapper;
import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.service.TravelService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 组团社业务实现
 **/
@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelMapper travelMapper;

    @Override
    public List<Travel> selectTravel()throws Exception {
        return travelMapper.selectTravel();
    }

    /**
     * 查询组团社方法
     * @param travelId
     * @return
     */
    @Override
    public Travel selectTravelById(Integer travelId)throws Exception {
        return travelMapper.selectTravelById(travelId);
    }

    /**
     * 添加信息
     * @param travel
     * @return
     */
    @Override
    public Integer getAddTravel(Travel travel)throws Exception {
        System.out.println(travel);
        return travelMapper.insert(travel);
    }
    /**
     * 修改信息
     * @param travel
     * @return
     */
    @Override
    public Integer getTravelUpd(Travel travel)throws Exception {
        System.out.println(travel);
        return travelMapper.updateByPrimaryKey(travel);
    }

    /**
     * 按条件模糊分页
     * @param pageNo
     * @param PageSize
     * @param travelName
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Travel> listTravelLike(Integer pageNo, Integer PageSize, String travelName) throws Exception {
        PageHelper.startPage(pageNo,PageSize,true);
        PageInfo<Travel> travel1=new PageInfo<>(travelMapper.listTravelLike(travelName));
        return travel1;
    }

    /**
     * 按条件查看修改
     * @param travelId
     * @return
     * @throws Exception
     */
    @Override
    public Integer getselectById(Integer travelId) throws Exception {
        return null;
    }

    /**
     * 删除    修改
     * @param travelId
     * @return
     */
    @Override
    public Integer getUpdTrave(Integer travelId)throws Exception {
        return travelMapper.getUpdTrave(travelId);
    }

    /**
     * 修改   查看
     * @param travelId
     * @return
     */
    @Override
    public Travel getupdBytravelId(Integer travelId)throws Exception {
        return travelMapper.getupdBytravelId(travelId);
    }

    /**
     * 修改 第二次
     * @return
     */
    @Override
    public Integer getupdlala(Travel travel)throws Exception {
        return travelMapper.getupdlala(travel);
    }

    @Override
    public Guide selectGuideByTravelId(Integer travelId)throws Exception {
        return travelMapper.selectGuideByTravelId(travelId);
    }

    @Override
    public Dispatch selectDispatchByTravelId(Integer travelId)throws Exception {
        return travelMapper.selectDispatchByTravelId(travelId);
    }

    @Override
    public Staff selectStaffByTraveId(Integer travelId)throws Exception {
        return travelMapper.selectStaffByTraveId(travelId);
    }

    @Override
    public Offer selectOfferByTravelId(Integer travelId)throws Exception {
        return travelMapper.selectOfferByTravelId(travelId);
    }
    @Override
    public Travel getTravelName(Integer groupNumber) throws Exception {
        return travelMapper.selectByPrimaryKey(groupNumber);
    }

    @Override
    public List<Disrestaurant> selectReportrestaurantByTravelId(Integer travelId)throws Exception {
        return travelMapper.selectReportrestaurantByTravelId(travelId);
    }

    @Override
    public List<Disrestaurant> selectReportrestaurantByTravelId1(Integer travelId)throws Exception {
        return travelMapper.selectReportrestaurantByTravelId1(travelId);
    }

    @Override
    public List<Dispatchhotel> selectReportaccommodationByTravelId(Integer travelId) throws Exception{
        return travelMapper.selectReportaccommodationByTravelId(travelId);
    }

    @Override
    public List<Disattr> selectReportticketByTravelId(Integer travelId) throws Exception{
        return travelMapper.selectReportticketByTravelId(travelId);
    }

    @Override
    public Discar selectReportfareByTravelId(Integer travelId)throws Exception {
        return travelMapper.selectReportfareByTravelId(travelId);
    }
}
