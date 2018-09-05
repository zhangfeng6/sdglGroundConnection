package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.pojo.VehicleType;
import com.dyhc.sdglgroundconnection.service.DictionariesService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 字典 控制层
 **/
@RestController
@RequestMapping("/Dictionaries")
public class DictionariesController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(DictionariesController.class);

    @Autowired
    private DictionariesService dictionariesService;

    /**
     * 获取所有的景点等级
     * @return
     */
    @RequestMapping("listDictionaries")
    public ReponseResult listDictionaries(Integer dictionariesId){
        try {
            PageInfo<Dictionaries> pageInfo=dictionariesService.listDictionaries();
            ReponseResult<List> data=ReponseResult.ok(pageInfo.getList(),"获取所有的景点等级成功");
            return  data;
        }catch (Exception e){
            ReponseResult<List> data=ReponseResult.err("获取所有的景点等级失败");
            e.printStackTrace();
            return  data;
        }
    }


    /**
     * 获取所有的景点等级
     * @return
     */
    @RequestMapping("listDictionaries1")
    public ReponseResult listDictionaries1(){
        try {
            PageInfo<Dictionaries> pageInfo=dictionariesService.listDictionaries1();
            ReponseResult<List> data=ReponseResult.ok(pageInfo.getList(),"获取所有的车辆类型成功");
            return  data;
        }catch (Exception e){
            ReponseResult<List> data=ReponseResult.err("获取所有的车辆类型失败");
            e.printStackTrace();
            return  data;
        }
    }


    /**
     * 获取所有的车辆类型
     * @return
     */
    @RequestMapping("listVehicletype")
    public ReponseResult listVehicletype(Integer dictionariesId){
        try {
            List<VehicleType> list=dictionariesService.listVehicletype();
            ReponseResult<List> data=ReponseResult.ok(list,"获取所有的车辆类型成功");
            return  data;
        }catch (Exception e){
            ReponseResult<List> data=ReponseResult.err("获取车辆类型失败");
            e.printStackTrace();
            return  data;
        }
    }

    /**origin/master
     * 获取餐馆类型
     * @return
     */
    @RequestMapping("selectByDictionariesId")
    public ReponseResult selectByDictionariesId(Integer dictionariesId) {
        try {
            Dictionaries dictionaries=dictionariesService.selectByDictionariesId(dictionariesId);
            ReponseResult<Object> data=ReponseResult.ok(dictionaries,"获取餐馆类型成功");
            return  data;
        }catch (Exception e){
            ReponseResult<List> data=ReponseResult.err("获取餐馆类型失败");
            return data;
        }
    }

    /**
     * 获取车辆类型
     * @return
     */
    @RequestMapping("/listhoteltype")
    public ReponseResult listhoteltype(){
        try {
            ReponseResult<List> data=ReponseResult.ok(dictionariesService.listhoteltype(),"获取所有的车辆类型成功");
            return  data;
        }catch (Exception e){
            ReponseResult<List> data=ReponseResult.err("获取所有的车辆类型失败");
            e.printStackTrace();
            return  data;
        }
    }

    /**
     * 分页查看餐厅类型
     * @param pageNo
     * @param pageSize
     * @param
     * @param valueContent1
     * @return
     */
    @RequestMapping("/DictionariesCan.html")
    public ReponseResult DictionariesCan(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize, @RequestParam("valueContent1")String valueContent1){
        try{
            System.out.println(pageNo);
            PageInfo<Dictionaries> pageInfoTravel=dictionariesService.listDictionariesCan(pageNo,pageSize,valueContent1);
            ReponseResult<List> data = ReponseResult.ok(pageInfoTravel.getList(), pageInfoTravel.getTotal(), "分页获取餐厅类型成功！");
            logger.info(" method:DictionariesCan  分页获取餐厅类型成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:DictionariesCan  获取餐厅类型数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 分页查看车辆类型
     * @param pageNo
     * @param pageSize
     * @param
     * @param valueContent1
     * @return
     */
    @RequestMapping("/DictionariesCar.html")
    public ReponseResult DictionariesCar(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize,@RequestParam("valueContent1")String valueContent1){
        try{
            System.out.println(pageNo);
            PageInfo<Dictionaries> pageInfoTravel=dictionariesService.listDictionariesCar(pageNo,pageSize,valueContent1);
            ReponseResult<List> data = ReponseResult.ok(pageInfoTravel.getList(), pageInfoTravel.getTotal(), "分页获取餐厅类型成功！");
            logger.info(" method:DictionariesCan  分页获取餐厅类型成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:DictionariesCan  获取餐厅类型数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 分页查看酒店类型
     * @param pageNo
     * @param pageSize
     * @param
     * @param valueContent1
     * @return
     */
    @RequestMapping("/DictionariesHotel.html")
    public ReponseResult DictionariesHotel(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize,@RequestParam("valueContent1")String valueContent1){
        try{
            System.out.println(pageNo);
            PageInfo<Dictionaries> pageInfoTravel=dictionariesService.listDictionariesHotel(pageNo,pageSize,valueContent1);
            ReponseResult<List> data = ReponseResult.ok(pageInfoTravel.getList(), pageInfoTravel.getTotal(), "分页获取餐厅类型成功！");
            logger.info(" method:DictionariesCan  分页获取餐厅类型成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:DictionariesCan  获取餐厅类型数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 餐厅类型删除    修改
     * @param valueContent1
     * @return
     */
    @RequestMapping("/DictionariesCanOne")
    public ReponseResult<Integer> DictionariesCanOne(String valueContent1){
        try{
            System.out.println(valueContent1);
            Integer result=0;
            Integer data=0;
            result=dictionariesService.getDictionariesByOne(valueContent1);
            if(result>0){
                data=1;
            }logger.info(" method:DictionariesCanOne  删除餐厅类型成功！");
            return ReponseResult.ok(data,"删除餐厅类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCanOne  删除餐厅类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 车辆类型删除    修改
     * @param valueContent1
     * @return
     */
    @LogNotes(operationType="餐厅类型",content="删除")
    @RequestMapping("/DictionariesByDel.html")
    public ReponseResult<Integer> getDictionariesByDel(String valueContent1){
        try{
            System.out.println(valueContent1);
            Integer result=0;
            Integer data=0;
            result=dictionariesService.getDictionariesByDel(valueContent1);
            if(result>0){
                data=1;
            }logger.info(" method:DictionariesCanOne  删除餐厅类型成功！");
            return ReponseResult.ok(data,"删除餐厅类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCanOne  删除餐厅类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 酒店类型删除    修改
     * @param valueContent1
     * @return
     */
    @LogNotes(operationType="酒店类型",content="删除")
    @RequestMapping("/DictionariesHotelByDel.html")
    public ReponseResult<Integer> getDictionariesHotelByDel(String valueContent1){
        try{
            System.out.println(valueContent1);
            Integer result=0;
            Integer data=0;
            result=dictionariesService.getDictionariesHotelByDel(valueContent1);
            if(result>0){
                data=1;
            }logger.info(" method:DictionariesCanOne  删除餐厅类型成功！");
            return ReponseResult.ok(data,"删除餐厅类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCanOne  删除餐厅类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }




    /**
     * 餐厅类型添加    修改
     * @param dictionaries
     * @return
     */
    @LogNotes(operationType="餐厅类型",content="保存")
    @RequestMapping("/DictionariesCanthree")
    public ReponseResult<Integer> DictionariesCanthree( Dictionaries dictionaries){
        try{
            Integer data=0;
            Integer num=0;
            Dictionaries d=dictionariesService.DictionariesCanMax();
            if(d==null){
                num=1;
            }else {
                num=d.getValueId();
                num++;
            }
            if(dictionaries.getDictionariesId()!=0){
                data=dictionariesService.getDictionariesByUpd(dictionaries);
                System.out.println(789);
            }else {
                dictionaries.setValueId(num);
                dictionaries.setTypeCode("DIET");
                dictionaries.setTypeName("饮食类型");
                dictionaries.setWhetherDel(0);
                dictionaries.setCreateBy(1);
                dictionaries.setCreateDate(new Date());
                data=dictionariesService.getDictionariesAdd(dictionaries);
                System.out.println(data);
            }
            logger.info(" method:DictionariesCanthree  操作餐厅类型成功！");
            return ReponseResult.ok(data,"操作餐厅类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCanthree  操作餐厅类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 车辆类型添加    修改
     * @param dictionaries
     * @return
     */
    @LogNotes(operationType="车辆类型",content="保存")
    @RequestMapping("/DictionariesCarthree.html")
    public ReponseResult<Integer> DictionariesCarthree( Dictionaries dictionaries){
        try{
            System.out.println(dictionaries);
            Integer data=0;
            Integer num;
            Dictionaries d=dictionariesService.DictionariesCarMax();
            if(d==null){
                num=1;
            }else {
                num=d.getValueId();
                num++;
            }
            if(dictionaries.getDictionariesId()!=0){
                data=dictionariesService.getDictionariesCarUpd(dictionaries);
            }else {
                dictionaries.setValueId(num);
                dictionaries.setTypeCode("VEHICLE");
                dictionaries.setTypeName("车辆类型");
                dictionaries.setWhetherDel(0);
                dictionaries.setCreateBy(1);
                dictionaries.setCreateDate(new Date());
                data=dictionariesService.getDictionariescarAdd(dictionaries);
                System.out.println(data);
            }
            logger.info(" method:DictionariesCarthree  操作车辆类型成功！");
            return ReponseResult.ok(data,"操作车辆类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCarthree  操作车辆类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 酒店类型添加    修改
     * @param dictionaries
     * @return
     */
    @LogNotes(operationType="酒店类型",content="保存")
    @RequestMapping("/DictionariesHotelthree.html")
    public ReponseResult<Integer> DictionariesHotelthree( Dictionaries dictionaries){
        try{
            System.out.println(dictionaries);
            Integer data=0;
            Integer num;
            Dictionaries d=dictionariesService.DictionariesHotelMax();
            if(d==null){
                num=1;
            }else {
                num=d.getValueId();
                num++;
            }
            if(dictionaries.getDictionariesId()!=0){
                data=dictionariesService.getDictionariesHotelUpd(dictionaries);
                System.out.println(789);
            }else {
                dictionaries.setValueId(num);
                dictionaries.setTypeCode("THEROOM");
                dictionaries.setTypeName("酒店类型");
                dictionaries.setWhetherDel(0);
                dictionaries.setCreateBy(1);
                dictionaries.setCreateDate(new Date());
                data=dictionariesService.getDictionariesHotelAdd(dictionaries);
                System.out.println(data);
            }
            logger.info(" method:DictionariesHotelthree  操作酒店类型成功！");
            return ReponseResult.ok(data,"操作酒店类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesHotelthree  操作酒店类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 餐厅类型修改   chakan
     * @param dictionariesId
     * @return
     */
    @RequestMapping("/DictionariesCanSelect.html")
    public ReponseResult DictionariesCanSelect(Integer dictionariesId){
        try{
            Dictionaries dictionaries=dictionariesService.getgetDictionariesSelect(dictionariesId);
            logger.info(" method:DictionariesCanSelect  查看餐厅类型成功！");
            return ReponseResult.ok(dictionaries,"查看餐厅类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCanSelect  查看餐厅类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 车辆类型修改   chakan
     * @param dictionariesId
     * @return
     */
    @RequestMapping("/DictionariesCarSelect.html")
    public ReponseResult DictionariesCarSelect(Integer dictionariesId){
        try{
            Dictionaries dictionaries=dictionariesService.getgetDictionariesCarSelect(dictionariesId);
            logger.info(" method:DictionariesCanSelect  查看餐厅类型成功！");
            return ReponseResult.ok(dictionaries,"查看餐厅类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCanSelect  查看餐厅类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 酒店类型修改   chakan
     * @param dictionariesId
     * @return
     */
    @RequestMapping("/DictionariesHotelSelect.html")
    public ReponseResult DictionariesHotelSelect(Integer dictionariesId){
        try{
            Dictionaries dictionaries=dictionariesService.getgetDictionariesHotelSelect(dictionariesId);
            logger.info(" method:DictionariesCanSelect  查看餐厅类型成功！");
            return ReponseResult.ok(dictionaries,"查看餐厅类型成功！");
        }catch (Exception e) {
            logger.error(" method:DictionariesCanSelect  查看餐厅类型失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 判断酒店类型是否存在
     * @param valueContent1
     * @return
     */
    @RequestMapping("/DictionariesByNameType")
    public ReponseResult DictionariesByNameType(String valueContent1){
        try{
            Integer data=0;
            Dictionaries dictionaries=dictionariesService.AAA(valueContent1);
            if(dictionaries!=null){
                data=1;
            }
            logger.info(" method:DictionariesByNameType  判断酒店类型是否存在成功！");
            return ReponseResult.ok(data,"判断酒店类型是否存在成功！");
        }catch (Exception e){
            logger.error(" method:DictionariesByNameType  判断酒店类型是否存在失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 判断餐厅类型是否存在
     * @param valueContent1
     * @return
     */
    @RequestMapping("/DictionariesByNameTypecan")
    public ReponseResult DictionariesByNameTypecan(String valueContent1){
        try{
            Integer data=0;
            Dictionaries dictionaries=dictionariesService.getDictionariesByNameTypecan(valueContent1);
            if(dictionaries!=null){
                data=1;
            }
            logger.info(" method:DictionariesByNameTypecan  判断餐厅类型是否存在成功！");
            return ReponseResult.ok(data,"判断餐厅类型是否存在成功！");
        }catch (Exception e){
            logger.error(" method:DictionariesByNameTypecan  判断餐厅类型是否存在失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 判断车辆类型是否存在
     * @param valueContent1
     * @return
     */
    @RequestMapping("/DictionariesByNameTypecar")
    public ReponseResult DictionariesByNameTypecar(String valueContent1){
        System.out.println("........................................");
        try{
            Integer data=0;
            Dictionaries dictionaries=dictionariesService.getDictionariesByNameTypecar(valueContent1);
            if(dictionaries!=null){
                data=1;
            }
            logger.info(" method:DictionariesByNameTypecan  判断车辆类型是否存在成功！");
            return ReponseResult.ok(data,"判断车辆类型是否存在成功！");
        }catch (Exception e){
            logger.error(" method:DictionariesByNameTypecan  判断车辆类型是否存在失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
