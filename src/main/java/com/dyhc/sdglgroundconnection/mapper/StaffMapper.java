package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 人员
 **/
@Mapper
@Component
public interface StaffMapper extends CommonMapper<Staff>{

    /**
     * 赵伟伟
     * 用户登录
     * @param theUserName
     * @param password
     * @return
     * @throws Exception
     */
    Staff login(@Param("theUserName") String theUserName,@Param("password") String password) throws Exception;
    /**
     * 分页查看全部
     * @param staffname
     * @return
     */
    List<Staff> getStaffAll(@Param("staffname") String staffname)throws Exception;

    /**
     * 删除 修改
     * @param staff
     * @return
     */
    Integer getStaffUpd(Staff staff)throws Exception;

    /**
     * 修改
     * @param staff
     * @return
     */
    Integer getStaffUpdTwo(Staff staff)throws Exception;
    /**
     * 不修改图片
     * @param staff
     * @return
     */
    Integer getStaffUpdThree(Staff staff)throws Exception;

    /**
     * 修改  查看
     * @param staffId
     * @return
     */
    Staff getStaffUpdTwoById(Integer staffId)throws Exception;

    /**
     * 判断用户是否存在
     * @return
     */
    Staff getserlectBy()throws Exception;

    /**
     * 查看计调员
     * @param dispatchId
     * @return
     */
    Staff listStaff(Integer  dispatchId)throws Exception;

    /**
     * 修改个人信息并修改图片
     * @param currentAddress
     * @param phone
     * @param qqnumber
     * @param uploadResult
     */
    void updateStaffInfo1(@Param("currentAddress")String currentAddress,@Param("phone")String phone,@Param("qqnumber")String qqnumber,@Param("uploadResult")String uploadResult,@Param("staffId")Integer staffId)throws Exception;

    /**
     * 修改个人信息不修改图片
     * @param currentAddress
     * @param phone
     * @param qqnumber
     */
    void updateStaffInfo2(@Param("currentAddress")String currentAddress,@Param("phone")String phone,@Param("qqnumber")String qqnumber,@Param("staffId")Integer staffId)throws Exception;


    /**
     * 判断旧密码是否正确
     * @param staffId
     * @return
     * @throws Exception
     */
    Staff pdPassword(@Param("staffId") Integer staffId)throws Exception;


    /**
     * 修改密码
     * @param staffId
     * @param password
     * @throws Exception
     */
    void updatePassword(@Param("staffId") Integer staffId,@Param("password") String password)throws Exception;
    /**
     * 判断用户名是否存在
     * @param theUserName
     * @return
     * @throws Exception
     */
    Staff StaffByName(String theUserName) throws Exception;

}
