package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.ScenicspotMapper;
import com.dyhc.sdglgroundconnection.mapper.ShoppingMapper;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.pojo.Shopping;
import com.dyhc.sdglgroundconnection.service.ScenicspotService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点业务实现
 **/
@Service
public class ScenicspotServiceImpl implements ScenicspotService {

    @Autowired
    private ScenicspotMapper scenicspotMapper;
    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public PageInfo<Scenicspot> listScenicspots(Integer typeId, String scenicSpotName, String scenicSpotAddress, Integer pageNo, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo, pageSize, true);
        List<Scenicspot> list1=scenicspotMapper.listScenicspots(typeId,scenicSpotName,scenicSpotAddress);
        for (Scenicspot s:list1) {
            List<Shopping> list2=shoppingMapper.listShoppingByScenicSpotId(s.getScenicSpotId());
            s.setShoppings(list2);
        }
        PageInfo<Scenicspot> pageInfo = new PageInfo<>(list1);
        return pageInfo;
    }

    @Override
    public PageInfo<Scenicspot> getScenicspotByParentId(Integer parentId) throws Exception{
        List<Scenicspot> list1=scenicspotMapper.getScenicspotByParentId(parentId);
        PageInfo<Scenicspot> pageInfo=new PageInfo<Scenicspot>(list1);
        return pageInfo;
    }

    @Override
    public List<Scenicspot> getScenicspotParentName() throws Exception {
        return scenicspotMapper.getScenicspotParentName();
    }

    @Override
    public Integer insertScenicspot(Scenicspot scenicspot)throws Exception {

        return scenicspotMapper.insertSelective(scenicspot);
    }

    @Override
    public Scenicspot getScenicspotById(Integer scenicSpotId) throws Exception{
        return scenicspotMapper.selectByPrimaryKey(scenicSpotId);
    }

    @Override
    public Integer updateScenicspot(Scenicspot scenicspot) throws Exception {
        try {
            scenicspotMapper.updateScenicspot(scenicspot);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }

    }

    @Override
    public Integer deleteScenicspotById(Integer scenicSpotId)throws Exception {
        try {
            scenicspotMapper.deleteScenicspotById(scenicSpotId);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 查询所有景点信息
     * @return
     * @throws Exception
     */
    @Override
    public List<Scenicspot> listScenicspotAll() throws Exception {
        return scenicspotMapper.listNoDelScenicspot();
    }

    /**
     * 查询景点
     * @param scenicSpotId
     * @return
     */
    @Override
    public Scenicspot selectByScenicSpotId(Integer scenicSpotId)throws Exception {
        return scenicspotMapper.selectByScenicSpotId(scenicSpotId);
    }

    /**
     * 查询景点（贾晓亮：调度租车查询景点）
     * @param scenicSpotId
     * @return
     */
    @Override
    public List<Scenicspot> ShowScenicSpotId(Integer scenicSpotId)throws Exception {
        return scenicspotMapper.ShowScenicSpotId(scenicSpotId);
    }

    @Override
    public List<Scenicspot> selectAllScenic()throws Exception {
        return scenicspotMapper.selectAllScenic();
    }
}
