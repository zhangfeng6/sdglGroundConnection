package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.parameterentity.DispatchParameter;
import com.dyhc.sdglgroundconnection.pojo.Cluster;
import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度业务接口
 **/
public interface DispatchService {
    /**
     * 根据条件查询调度信息并返回分页信息  张枫
     * @param pageNo        当前页数
     * @param pageSize      每页显示量
     * @param djsth         地接社团号
     * @param dyname        导游名称
     * @param state         调度信息状态
     * @return
     * @throws Exception
     */
    PageInfo<Dispatch> listDispatch(Integer pageNo, Integer pageSize, String djsth, String dyname, Integer state) throws Exception;

    /**
     * 获取调度页面资源信息
     * @return
     * @throws Exception
     */
    Map<String,Object> getresource()throws Exception;

    /**
     * 根据类型和类型id获取指定的信息资源
     * @param type
     * @param valueId
     * @return
     * @throws Exception
     */
    List listinfoByvalueId(String type,Integer valueId)throws Exception;



    /**
     * 根据导游id查询调度信息     陈庆武
     * @param guideId 导游id
     * @return
     */
    Dispatch getDispatchByguideId(Integer guideId)throws Exception;

    /**
     * 调度表信息:贾晓亮
     * @param dispatchId
     * @return
     */
    Dispatch dispatchSelectAll(Integer dispatchId)throws Exception;
    /* 根据调度id查询调度信息     陈庆武
     * @param reportDetailId 调度id
     * @return
     */
    Dispatch getDispatchById(Integer reportDetailId)throws Exception;
    /**
     * 分页查看调用信息         刘跃云
     * @param pageNo
     * @param pageSize
     * @param guideName
     * @param groundConnectionNumber
     * @return
     */
    PageInfo<Dispatch> ListDispatchLike(Integer pageNo, Integer pageSize, String guideName, String groundConnectionNumber)throws Exception;

    /**
     * 根据对象属性 进行修改   张枫
     * @return
     * @throws Exception
     */
    int updatestateById(Integer did, Integer gid, String travelStartTime, String travelEndTime)throws Exception;

    /**
     * 查询计调表
     * @param dispatchId
     * @return
     */
    Dispatch dispatch(@Param("dispatchId") Integer dispatchId)throws Exception;
    /* 根据报价Id查询该报价的所有信息
     * @param oid
     * @return
     * @throws Exception
     */
    Map<String,Object> getofferinfoById(Integer oid)throws Exception;
    /**
     * 查看车辆联系人
     * @param dispatchId
     * @return
     */
    Dispatch listDispatch(Integer dispatchId)throws Exception;

    /**
     * j接团信息
     * @param dispatchId
     * @return
     */
    Cluster ClusterById(Integer dispatchId)throws Exception;

    /**
     * 增加调度信息并修改报价信息的状态     张枫
     * @param dispatchParameter
     * @return
     */
    int saveDispatch(DispatchParameter dispatchParameter)throws Exception;

    /**
     * 根据调度id获取调度信息的相关记录        张枫
     * @param dispatchId
     * @return
     * @throws Exception
     */
    Map<String,Object> getDispatchinfoById(Integer dispatchId)throws Exception;

    /**s
     * 修改调度信息       张枫
     * @param dispatchParameter
     * @return
     * @throws Exception
     */
    int updateDispatch(DispatchParameter dispatchParameter)throws Exception;

    /**
     * 根据调度id修改调度状态
     * @param dispatchId
     * @throws Exception
     */
    Integer updateDispatchById(Integer dispatchId)throws Exception;

}
