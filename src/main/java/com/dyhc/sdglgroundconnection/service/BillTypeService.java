package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Bill;
import com.dyhc.sdglgroundconnection.pojo.BillType;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据类型业务接口
 **/
public interface BillTypeService {
    /**
     * 单据分页查询
     * @param pageNo
     * @param pageSize
     * @param typeName
     * @return
     */
    PageInfo<BillType> ShowAllBillType(@Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize,@Param("typeName") String typeName)throws Exception;

    /**
     * 删除单据信息
     * @param billTypeId
     * @return
     */
    Integer removeBillType(@Param("billTypeId") Integer billTypeId)throws Exception;

    /**
     * 新增单据信息
     * @param billType
     * @return
     */
    Integer saveBillType(BillType billType)throws Exception;

    /**
     * 修改单据信息
     * @param billType
     * @return
     */
    Integer updateBillType(BillType billType)throws Exception;

    /**
     * 新增单据信息是判断是否数据库有相同信息，如果有就不进行新增
     * @param typeName
     * @return
     */
    BillType equalBillType(@Param("typeName") String typeName)throws Exception;
    /**
     * 修改赋值
     * @param billTypeId
     * @return
     */
    BillType fuzhiBillType(Integer billTypeId)throws Exception;

    /**
     * 获取所有单据类型
     * @return
     * @throws Exception
     */
    List<BillType> listBillAll()throws Exception;
}
