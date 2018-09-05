package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.TourismandlineMapper;
import com.dyhc.sdglgroundconnection.mapper.TourismtemplateMapper;
import com.dyhc.sdglgroundconnection.pojo.Tourismandline;
import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.*;

import java.util.List;

@Service
@Transactional
public class TourismtemplateServiceImpl  implements TourismtemplateService {
    @Autowired
    private TourismtemplateMapper tourismtemplateMapper;
    @Autowired
    private TourismandlineMapper tourismandlineMapper;

    /**
     * 获取指定符合查询条件的模板信息
     * @param tempName  模板名称
     * @param username  创建人
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Tourismtemplate> listtemplate(String tempName, String username,Integer pageNo,Integer pageSize) throws Exception {
        PageHelper.startPage(pageNo,pageSize);
        PageInfo<Tourismtemplate> pageInfo=new PageInfo<Tourismtemplate>(tourismtemplateMapper.listtemplate(tempName,username));
        return pageInfo;
    }

    @Override
    @Transactional()
    public int removetourismtemplate(Integer tid) throws Exception {
        try {
            tourismtemplateMapper.deleteByPrimaryKey(tid);
            tourismandlineMapper.removeTourismandline(tid);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }

    }

    /**
     * 根据模板名称判断该名称是否可用
     * @param temName
     * @return
     * @throws Exception
     */
    @Override
    public boolean getinfoBytemName(String temName) throws Exception {
        if(tourismtemplateMapper.gettemplateByName(temName)!=null){
            return false;
        }
        return true;
    }

    /**
     * 添加和修改模板信息
     * @param temName
     * @param info
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    @Transactional()
    public int savetourismtermplate(String temName, Integer[] info,Integer id) throws Exception {
        try {
            Tourismtemplate tem=new Tourismtemplate();
            tem.setTourismtemplateName(temName);
            if(id==0||id==null){
                tem.setStatus(0);
                tem.setCreateBy(1);
                tem.setCreateDate(new Date());
                tourismtemplateMapper.insert(tem);
            }else{
                tem.setUpdateBy(1);
                tem.setUpdateDate(new Date());
                tourismtemplateMapper.updateByPrimaryKeySelective(tem);
                tourismandlineMapper.removeTourismandline(id);
            }

            Tourismtemplate tid=tourismtemplateMapper.gettemplateByName(temName);
            List<Tourismandline> list=new ArrayList<Tourismandline>();
            for (int i=0; i<info.length;i++) {
                Tourismandline tandl=new Tourismandline();
                tandl.setTourismId(tid.getTourismId());
                tandl.setHowmanydays(i+1);
                tandl.setTemplateId(info[i]);
                tandl.setStatus(0);
                tandl.setCreateBy(1);
                tandl.setCreateDate(new Date());
                list.add(tandl);
            }
            tourismandlineMapper.insertList(list);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return 0;
        }
    }

    /**
     * 点击修改进行查询
     * @param tid
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> listtandlBytid(Integer tid) throws Exception{
        Map<String,Object> map=new HashMap<String,Object>();
        List<Tourismandline> list=tourismandlineMapper.listtlBytid(tid);
        Tourismtemplate tem=new Tourismtemplate();
        Tourismtemplate info=tourismtemplateMapper.selectByPrimaryKey(tid);
        map.put("info",info);
        map.put("list",list);
        return map;
    }

    /**
     * 赵伟伟
     * 查询全部模板
     * @return
     */
    @Override
    public List<Tourismtemplate> selectTourismtemplate()throws Exception {
        return tourismtemplateMapper.selectAll();
    }

    /**
     * 赵伟伟
     * 添加线路
     * @param tourismtemplate
     * @return
     * @throws Exception
     */
    @Override
    public int addTourismtemplate(Tourismtemplate tourismtemplate) throws Exception {
        return tourismtemplateMapper.addTourismtemplate(tourismtemplate);
    }

    /**
     * 按名称查询
     * @param tourismtemplateName
     * @return
     * @throws Exception
     */
    @Override
    public Tourismtemplate selectByName(String tourismtemplateName) throws Exception {
        return tourismtemplateMapper.selectByName(tourismtemplateName);
    }
}
