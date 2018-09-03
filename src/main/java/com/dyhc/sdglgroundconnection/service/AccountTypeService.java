package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.AccountType;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 账户类型业务接口
 **/
public interface AccountTypeService {
    /*
    账户类型模糊查询分页接口
     */
    PageInfo<AccountType> listAccountType(Integer pageNo, Integer PageSize,String bank) throws Exception;

    /**
     * 删除账户类型
     * @param accountTypeId
     * @return
     * @throws Exception
     */
    Integer removeAccountType(Integer accountTypeId)throws  Exception;

    /**
     * 新增账户类型
     * @param accountType
     * @return
     */
    Integer saveAccountType(AccountType accountType)throws Exception;

    /**
     * 修改账户类别信息
     * @param accountType
     * @return
     * @throws Exception
     */
    Integer updateAccountType(AccountType accountType)throws Exception;

    /**
     *显示账目修改信息
     * @param accountTypeId
     * @return
     */
    AccountType updateShowAll(Integer accountTypeId)throws Exception;
}
