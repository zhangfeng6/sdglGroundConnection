package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 字典
 **/
@Mapper
@Component
public interface DictionariesMapper extends CommonMapper<Dictionaries>{


    /**
     * 查询所有的景点等级
     * @return
     */
    List<Dictionaries> listDictionaries()throws Exception;

    /**
     * 查询所有的车辆类型
     * @return
     */
    List<VehicleType> listVehicletype()throws  Exception;



    /**
     * 按id查詢
     * @param valueId
     * @return
     */
    Dictionaries selectById(@Param("valueId")int valueId)throws  Exception;


    /**
     * 按id查詢
     * @param
     * @return
     */
    Dictionaries selectByDictionariesId(@Param("dictionariesId")int dictionariesId)throws  Exception;

    /*origin/master
     * 根据类型id查询车辆类型
     * @return
     */
    Dictionaries getDictionaries(@Param("valueId") Integer valueId)throws Exception;


    /**
     * 查询所有的车辆类型
     * @return
     */
    List<Dictionaries> listDictionaries1()throws Exception;

    /**
     * 根据code获取字典表信息
     * @param code
     * @return
     * @throws Exception
     */
    List<Dictionaries> listdictionarieslBycode(@Param("code")String code)throws Exception;


    /**
     * 分页查看餐厅类型
     * @param valueContent1
     * @param valueContent1
     * @return
     */
    List<Dictionaries> getDictionariesCan(@Param("valueContent1") String valueContent1)throws  Exception;

    /**
     * 分页查车辆厅类型
     * @param valueContent1
     * @param valueContent1
     * @return
     */
    List<Dictionaries> getDictionariesCar(@Param("valueContent1") String valueContent1)throws  Exception;
    /**
     * 分页查看酒店类型
     * @param valueContent1
     * @param valueContent1
     * @return
     */
    List<Dictionaries> getDictionariesHotel(@Param("valueContent1") String valueContent1)throws  Exception;

    /**
     * 餐厅类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesByOne(String valueContent1)throws  Exception;

    /**
     * 车辆类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesByDel(String valueContent1)throws  Exception;
    /**
     * 酒店类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesHotelDel(String valueContent1)throws  Exception;

    /**
     * 餐厅修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariesByUpd(Dictionaries dictionaries)throws  Exception;
    /**
     * 车辆修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariescarUpd(Dictionaries dictionaries)throws  Exception;
    /**
     * 酒店修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariesHotelByUpd(Dictionaries dictionaries)throws  Exception;

    /**
     * 餐厅类型修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesSelect(Integer dictionariesId)throws  Exception;
    /**
     * 车辆修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesCarSelect(Integer dictionariesId)throws  Exception;
    /**
     * 酒店修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesHotelSelect(Integer dictionariesId)throws  Exception;

    /**
     * 判断餐厅类型是否存在
     * @param valueContent1
     * @return
     */
    Dictionaries getDictionariesByNameTypecan(String valueContent1)throws  Exception;

    /**
     * 判断车辆类型是否存在
     * @param valueContent1
     * @return
     */
    Dictionaries getDictionariesByNameTypecar(String valueContent1)throws  Exception;


    /**
     * 判断酒店类型是否存在
     * @param valueContent1
     * @return
     */
    Dictionaries getDictionariesByNameType(String valueContent1)throws  Exception;


    /**
     * 添加餐厅编号
     * @param
     * @return
     */
    Dictionaries DictionariesCanMax()throws  Exception;
    /**
     * 添加车辆编号
     * @param
     * @return
     */
    Dictionaries DictionariesCarMax()throws  Exception;
    /**
     * 添加酒店编号
     * @param
     * @return
     */
    Dictionaries DictionariesHotelMax()throws  Exception;

    /**
     * 查询房间类型名称（贾晓亮：在字典表）
     * @param valueId
     * @return
     */
    Dictionaries  dis_All(@Param("valueId")Integer valueId)throws  Exception;

}
