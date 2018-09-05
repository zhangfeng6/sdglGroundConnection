package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.AccountTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.dyhc.sdglgroundconnection.service.AccountTypeService;
import com.dyhc.sdglgroundconnection.service.StaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 账户类型业务实现
 **/
@Service
public class AccountTypeServiceImpl implements AccountTypeService {

    @Autowired
    private AccountTypeMapper accountTypeMapper;
    /**
     *账户类型分页模糊查询
     * @param pageNo 当前页码
     * @param PageSize 每页显示记录数
     * @return
     */
    @Override
    public PageInfo<AccountType> listAccountType(Integer pageNo, Integer PageSize,String bank) throws Exception {
        PageHelper.startPage(pageNo,PageSize,true);
        PageInfo<AccountType>pageInfo=new PageInfo<>(accountTypeMapper.listAccountType(pageNo,PageSize,bank));
        return pageInfo;
    }
    /**
     * 删除账户类型
     * @param
     * @return
     */
    @Override
    public Integer removeAccountType(Integer accountTypeId) throws Exception {
        Integer remove=0;
        try {
            remove=accountTypeMapper.removeAccountType(accountTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return remove;
    }

    /**
     * 新增账户类型
     * @param accountType
     * @return
     */
    @Override
    public Integer saveAccountType(AccountType accountType)throws Exception {
        Integer saveAccountType=0;
        try {
            accountType.setWhetherDel(0);
            accountType.setCreateDate(new Date());
            accountType.setUpDate(new Date());
            accountType.setCreateBy(1);
            accountType.setUpdateBy(2);
            saveAccountType=accountTypeMapper.insert(accountType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saveAccountType;
    }

    /**
     * 修改账户类型
     * @param accountType
     * @return
     * @throws Exception
     */
    @Override
    public Integer updateAccountType(AccountType accountType)throws Exception {
        accountType.setUpDate(new Date());
        accountType.setCreateBy(1);
        accountType.setUpdateBy(2);
        Integer updateAccountType=0;
        try {
            updateAccountType=accountTypeMapper.updateAccountType(accountType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updateAccountType;
    }

    /**
     * 显示账目修改信息赋值
     * @param accountTypeId
     * @return
     */
    @Override
    public AccountType updateShowAll(Integer accountTypeId)throws Exception {
        AccountType accountType=null;
        try {
            accountType=accountTypeMapper.selectByPrimaryKey(accountTypeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountType;
    }
}
