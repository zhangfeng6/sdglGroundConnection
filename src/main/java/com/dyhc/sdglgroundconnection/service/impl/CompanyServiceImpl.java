package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.CompanyMapper;
import com.dyhc.sdglgroundconnection.pojo.Company;
import com.dyhc.sdglgroundconnection.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 公司信息业务实现
 **/
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    /**
     * 查看全部(单次租车：贾晓亮使用)
     * @return
     */
    @Override
    public Company getCompany()throws Exception {
        return companyMapper.getCompany();
    }

    @Override
    public Integer getUpdCompany(Company company)throws Exception {
        return companyMapper.updateByPrimaryKey(company);
    }
}
