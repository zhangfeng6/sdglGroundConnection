package com.dyhc.sdglgroundconnection.service;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 字典业务接口
 **/
public interface DictionariesService {



    /**
     * 查询景点
     * @return
     * @throws Exception
     */
    PageInfo<Dictionaries> listDictionaries()throws Exception;

    /**
     * 查询所有的车辆类型
     * @return
     */
    List<VehicleType> listVehicletype()throws Exception;

    /**
     * 赵伟伟
     * 按id查询
     * @return
     */
    Dictionaries selectByDictionariesId(int dictionariesId)throws Exception;

    PageInfo<Dictionaries> listDictionaries1()throws Exception;


    /**
     * 查询所有房间类型
     * @return
     */
    List<Dictionaries> listhoteltype()throws Exception;

    /**
     * 分页查看餐厅类型
     * @param pageNo
     * @param PageSize
     * @param valueContent1
     * @return
     * @throws Exception
     */
    PageInfo<Dictionaries> listDictionariesCan(Integer pageNo, Integer PageSize,String valueContent1) throws Exception;

    /**
     * 分页查看车辆类型
     * @param pageNo
     * @param PageSize
     * @param valueContent1
     * @return
     * @throws Exception
     */
    PageInfo<Dictionaries> listDictionariesCar(Integer pageNo, Integer PageSize,String valueContent1) throws Exception;
    /**
     * 分页查看酒店类型
     * @param pageNo
     * @param PageSize
     * @param valueContent1
     * @return
     * @throws Exception
     */
    PageInfo<Dictionaries> listDictionariesHotel(Integer pageNo, Integer PageSize,String valueContent1) throws Exception;
    /**
     * 餐厅类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesByOne(String valueContent1)throws Exception;
    /**
     * 车辆类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesByDel(String valueContent1)throws Exception;
    /**
     * 酒店类型删除    修改
     * @param valueContent1
     * @return
     */
    Integer getDictionariesHotelByDel(String valueContent1)throws Exception;

    /**
     * 餐厅添加信息
     * @param dictionaries
     * @return
     */
    Integer getDictionariesAdd(Dictionaries dictionaries)throws Exception;
    /**
     * 车辆添加信息
     * @param dictionaries
     * @return
     */
    Integer getDictionariescarAdd(Dictionaries dictionaries)throws Exception;
    /**
     * j酒店添加信息
     * @param dictionaries
     * @return
     */
    Integer getDictionariesHotelAdd(Dictionaries dictionaries)throws Exception;
    /**
     * 餐厅类型修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariesByUpd(Dictionaries dictionaries)throws Exception;
    /**
     * 车辆类型修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariesCarUpd(Dictionaries dictionaries)throws Exception;
    /**
     * 酒店类型修改
     * @param dictionaries
     * @return
     */
    Integer getDictionariesHotelUpd(Dictionaries dictionaries)throws Exception;
    /**
     * 餐厅类型修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesSelect(Integer dictionariesId)throws Exception;
    /**
     * 车辆类型修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesCarSelect(Integer dictionariesId)throws Exception;
    /**
     * 酒店类型修改  查看
     * @param dictionariesId
     * @return
     */
    Dictionaries getgetDictionariesHotelSelect(Integer dictionariesId)throws Exception;

    /**
     * 判断餐厅类型是否存在
     * @param valueContent1
     * @return
     */
    Dictionaries getDictionariesByNameTypecan(String valueContent1)throws Exception;
    /**
     * 判断车辆类型是否存在
     * @param valueContent1
     * @return
     */
    Dictionaries getDictionariesByNameTypecar(String valueContent1)throws Exception;
    /**
     * 判断酒店类型是否存在
     * @param valueContent1
     * @return
     */
    Dictionaries AAA(String valueContent1)throws Exception;

    /**
     * 添加餐厅编号
     * @param
     * @return
     */
    Dictionaries DictionariesCanMax()throws Exception;
    /**
     * 添加车辆编号
     * @param
     * @return
     */
    Dictionaries DictionariesCarMax()throws Exception;
    /**
     * 添加酒店编号
     * @param
     * @return
     */
    Dictionaries DictionariesHotelMax()throws Exception;
}
