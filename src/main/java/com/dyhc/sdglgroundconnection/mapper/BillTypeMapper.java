package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.BillType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据类型
 **/
@Mapper
@Component
public interface BillTypeMapper extends CommonMapper<BillType>{
    /**
     * 单据分页查询
     * @param pageNo
     * @param pageSize
     * @param typeName
     * @return
     */
 List<BillType> ShowAllBillType(@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize,@Param("typeName")String typeName)throws  Exception;

    /**
     * 判断单据类型名称
     * @param typeName
     * @return
     */
 BillType equalBillType(@Param("typeName")String typeName)throws  Exception;
}
