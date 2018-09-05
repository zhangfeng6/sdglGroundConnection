package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.BillTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.Bill;
import com.dyhc.sdglgroundconnection.pojo.BillType;
import com.dyhc.sdglgroundconnection.service.BillTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据类型业务实现
 **/
@Service
public class BillTypeServiceImpl implements BillTypeService {

    @Autowired
    private BillTypeMapper billTypeMapper;
    /**
     * 单据分页查询信息
     * @param pageNo
     * @param
     * @param typeName
     * @return
     */
    @Override
    public PageInfo<BillType> ShowAllBillType(Integer pageNo, Integer pageSize, String typeName)throws Exception {
        PageHelper.startPage(pageNo,pageSize,true);
        PageInfo<BillType>pageInfo=new PageInfo<>(billTypeMapper.ShowAllBillType(pageNo,pageSize,typeName));
        return pageInfo;
    }

    /**
     * 删除单据信息
     * @return
     */
    public  Integer removeBillType(Integer billTypeId)throws Exception{
        BillType billType =new BillType();
        billType.setBillTypeId(billTypeId);
        billType.setWhetherDel(1);
      Integer Del=0;
        try {
            Del=billTypeMapper.updateByPrimaryKeySelective(billType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Del;
    }

    /**
     * 修改单据信息
     * @param billType
     * @return
     */
    public  Integer updateBillType(BillType billType)throws Exception{
        billType.setWhetherDel(0);
        billType.setCreateBy(1);
        billType.setCreateDate(new Date());
        billType.setUpdateBy(2);
        billType.setUpdateDate(new Date());
        Integer Upd=0;
        try {
            Upd=billTypeMapper.updateByPrimaryKey(billType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  Upd;
    }

    /**
     *新增单据信息
     * @return
     */
    public  Integer saveBillType(BillType billType)throws Exception{
        billType.setWhetherDel(0);
        billType.setCreateBy(1);
        billType.setCreateDate(new Date());
        billType.setUpdateBy(2);
        billType.setUpdateDate(new Date());
        Integer add=0;
        try {
            add=billTypeMapper.insert(billType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  add;
    }

    /**
     * 判断是否有重复单据类型名称
     * @return
     */
    public BillType equalBillType(String typeName)throws Exception{
        BillType billType = null;
        try {
            billType = billTypeMapper.equalBillType(typeName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  billType;
    }
    /**
     *单据修改赋值
     * @return
     */
    public BillType  fuzhiBillType(Integer billTypeId)throws Exception{
        BillType billType = null;
        try {
            billType = billTypeMapper.selectByPrimaryKey(billTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  billType;
    }

    @Override
    public List<BillType> listBillAll() throws Exception {
        return billTypeMapper.selectAll();
    }
}
