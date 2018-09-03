package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.StaffMapper;
import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.dyhc.sdglgroundconnection.service.StaffService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 人员业务实现
 **/
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    /**
     * 赵伟伟
     * 登录
     * @param theUserName
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public Staff login(String theUserName, String password) throws Exception {
        return staffMapper.login(theUserName,password);
    }

    /**
     * 根据账户类型ID查询人员信息
     * @param
     * @return
     */
    @Override
    public List<Staff> idAccountType() throws Exception{
        return staffMapper.selectAll();
    }


    /**
     * 分页查看全部
     * @param pageNo
     * @param PageSize
     * @param staffname
     * @return
     * @throws Exception
     */
    @Override
    public PageInfo<Staff> listStaffLike(Integer pageNo, Integer PageSize, String staffname) throws Exception {
        PageHelper.startPage(pageNo,PageSize,true);
        PageInfo<Staff> staff=new PageInfo<>(staffMapper.getStaffAll(staffname));
        return staff;
    }

    /**
     * 删除  修改
     * @param staff
     * @return
     */
    @Override
    public Integer getStaffUpd(Staff staff)throws Exception {
        return staffMapper.getStaffUpd(staff);
    }

    /**
     * 修改
     * @param staff
     * @return
     */
    @Override
    public Integer getStaffUpdTwo(Staff staff)throws Exception {
        return staffMapper.getStaffUpdTwo(staff);
    }
    /**
     * 不修改图片
     * @param staff
     * @return
     */
    @Override
    public Integer getStaffUpdThree(Staff staff)throws Exception {
        return staffMapper.getStaffUpdThree(staff);
    }

    /**
     * 添加
     * @param staff
     * @return
     */
    @Override
    public Integer getStaffAdd(Staff staff)throws Exception {

        return staffMapper.insert(staff);
    }

    /**
     * 修改  查看
     * @param staffId
     * @return
     */
    @Override
    public Staff getStaffUpdTwoById(Integer staffId)throws Exception {
        return staffMapper.getStaffUpdTwoById(staffId);
    }

    /**
     * 判断用户是否存在
     * @return
     */
    @Override
    public Staff getserlectBy()throws Exception {
        return staffMapper.getserlectBy();
    }

    /**
     * 查看计调员
     * @param staffId
     * @return
     */
    @Override
    public Staff listStaff(Integer staffId)throws Exception {
        return staffMapper.listStaff(staffId);
    }


    @Override
    public Integer updateStaffInfo2(String currentAddress, String phone, String qqnumber, Integer staffId) throws Exception {
        try {
            staffMapper.updateStaffInfo2(currentAddress,phone,qqnumber,staffId);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Staff pdPassword(Integer staffId) throws Exception {
        return staffMapper.pdPassword(staffId);
    }

    @Override
    public Integer updatePassword(Integer staffId, String password) throws Exception {
        try {
            staffMapper.updatePassword(staffId,password);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    @Override
    public Integer updateStaffInfo1(String currentAddress, String phone, String qqnumber, String uploadResult, Integer staffId)throws Exception {
        try {
            staffMapper.updateStaffInfo1(currentAddress,phone,qqnumber,uploadResult,staffId);
            return 1;
        }catch (Exception e){
            return 0;
        }

    }

    /**
     * 判断用户名是否存在
     * @param theUserName
     * @return
     * @throws Exception
     */
    @Override
    public Staff StaffByName(String theUserName) throws Exception {
        return staffMapper.StaffByName(theUserName);
    }

}
