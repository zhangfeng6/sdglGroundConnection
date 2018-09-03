package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.GuideMapper;
import com.dyhc.sdglgroundconnection.mapper.GuidescheduleMapper;
import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.dyhc.sdglgroundconnection.pojo.Guide;
import com.dyhc.sdglgroundconnection.pojo.Guideschedule;
import com.dyhc.sdglgroundconnection.service.GuideService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游业务实现
 **/
@Service
public class GuideServiceImpl implements GuideService {

    @Autowired
    private GuideMapper guideMapper;
    @Autowired
    private GuidescheduleMapper guidescheduleMapper;

    /**
     * 判断导游是否有重复的导游证件号
     * @param certificate
     * @return
     */
    @Override
    public Guide pdcertificate(String certificate)throws Exception {
        return guideMapper.pdcertificate(certificate);
    }

    /**
     * 分页查询导游信息
     * @param pageNo
     * @param PageSize
     * @param guideName
     * @return
     */
    @Override
    public PageInfo<Guide> listGuide(@RequestParam("pageNo") Integer pageNo, @RequestParam("PageSize")Integer PageSize, @RequestParam("guideName")String guideName)throws Exception {
        PageHelper.startPage(pageNo,PageSize,true);
        PageInfo<Guide> pageInfo=new PageInfo<>(guideMapper.listGuide(pageNo,PageSize,guideName));
        return pageInfo;
    }

    /**
     * 删除都有信息
     * @param guideId
     * @return
     */
    @Override
    public Integer removeGuide(Integer guideId) throws  Exception {
        Integer Ak =0;
        try {
            Ak=guideMapper.deleteByPrimaryKey(guideId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Ak;
    }

    /**
     * 新增导游信息
     * @param guide
     * @return
     */
    @Override
    public Integer saveGuide(Guide guide)throws Exception {
        guide.setCreationDate(new Date());
        guide.setModifiedData(new Date());
        guide.setModifier(1);
        guide.setCreater(2);
        guide.setWhetherDel(0);
        guide.setState(3);
        Integer Ak =0;
        try {
            Ak=guideMapper.insert(guide);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Ak;
    }

    /**
     * 修改导游信息(贾晓亮)
     * @param guide
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateGuide(Guide guide) throws  Exception {
        guide.setCreationDate(new Date());
        guide.setModifiedData(new Date());
        guide.setModifier(1);
        guide.setCreater(2);
        guide.setWhetherDel(0);
        guide.setState(3);
        Integer Ak =0;
        try {
            Ak=guideMapper.updateByPrimaryKeySelective(guide);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Ak;
    }

    /**
     *导游修改赋值
     * @return
     */
    public  Guide assignmentGuide(Integer assignment)throws Exception{
        Guide guide = null;
        try {
            guide = guideMapper.selectByPrimaryKey(assignment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  guide;
    }

    @Override
    public Guide login(String username, String password) throws Exception {
        return guideMapper.login(username,password);
    }

    @Override
    public List<Guideschedule> listguidescheduleBygid(String year, String month) throws Exception {
        return guidescheduleMapper.listguideschedule(year, month);
    }

    @Override
    public Guide getGuideById(Integer guideId) throws Exception {
        return guideMapper.selectByPrimaryKey(guideId);
    }

    @Override
    public List<Guide> listGuideName() throws Exception {
        return guideMapper.listGuideName();
    }

    @Override
    public Integer updateGuideByPassword(Guide guide) throws Exception {
        return guideMapper.updateByPrimaryKeySelective(guide);
    }


    /**
     * 导游信息
     * @param guideId
     * @return
     */
    @Override
    public Guide ShowAllGuide(Integer guideId)throws Exception {
        return guideMapper.ShowAllGuide(guideId);
    }
}
