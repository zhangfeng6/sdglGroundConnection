package com.dyhc.sdglgroundconnection.web;
import com.dyhc.sdglgroundconnection.pojo.Restaurant;

import com.dyhc.sdglgroundconnection.pojo.Tourismtemplate;
import com.dyhc.sdglgroundconnection.service.TourismtemplateService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;


import com.github.pagehelper.PageInfo;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;


import java.util.List;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Tourismtemplate")
public class TourismtemplateController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(TemplateScenicspotController.class);

    @Autowired
    private TourismtemplateService tourismtemplateService;

    /**
     * 查询旅游模板
     * @return
     */
    @RequestMapping("/selectTourismtemplate")
    public ReponseResult selectTourismtemplate() {
        try {
            List<Tourismtemplate> list = tourismtemplateService.selectTourismtemplate();
            ReponseResult<Object> data = ReponseResult.ok(list, "查询成功！");
            logger.info(" method:selectTourismtemplate  查询旅游模板成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTourismtemplate  查询旅游模板失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }
    /**
     * 获取所有模板信息
     * @param tempname
     * @param username
     * @param pageNo
     * @param pageSize
     * @return
     */
    @RequestMapping("/listtourismtemplate")
    public ReponseResult listtourismtemplate(@RequestParam("tempname")String tempname,
                                             @RequestParam("username")String username,
                                             @RequestParam("pageNo")Integer pageNo,
                                             @RequestParam("pageSize")Integer pageSize){
        try {
            PageInfo<Tourismtemplate> page=tourismtemplateService.listtemplate(tempname, username, pageNo, pageSize);
            ReponseResult<List> data=ReponseResult.ok(page.getList(),page.getTotal(),"分页获取模板信息成功！");
            logger.info("method:listtourismtemplate 分页获取模板信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listtourismtemplate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     * 删除模板信息
     * @param tid
     * @return
     */
    @RequestMapping("/removetourism")
    @LogNotes(operationType = "模板信息",content = "删除")
    public ReponseResult removetourism(@RequestParam("tid")Integer tid){
        try {
            int result=tourismtemplateService.removetourismtemplate(tid);
            ReponseResult<Integer> data=ReponseResult.ok(result,"删除模板信息成功！");
            logger.info("method:removetourism 删除模板信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listtourismtemplate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     * 判断该模板名称是否存在
     * @param temName
     * @return
     */
    @RequestMapping("/jumptempName")
    public ReponseResult jumptempName(@RequestParam("temName")String temName){
        try {
            ReponseResult<Boolean> data=ReponseResult.ok(tourismtemplateService.getinfoBytemName(temName),"获取判断结果成功！");
            logger.info("method:removetourism 获取判断信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listtourismtemplate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }


    /**
     * 保存模板
     * @param temName
     * @param info
     * @param id
     * @return
     */
    @LogNotes(operationType="模板信息",content="保存")
    @RequestMapping("/saveorupdate")
    public ReponseResult saveorupdate(@RequestParam("temName")String temName,
                                      @RequestParam("info[]")Integer[] info,
                                      @RequestParam("id")Integer id){
        try {
            if(id==null){
                id=0;
            }
            ReponseResult<Integer> data=ReponseResult.ok(tourismtemplateService.savetourismtermplate(temName,info,id),"操作成功！");
            logger.info("method:saveorupdate 执行添加或修改操作成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:saveorupdate 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }

    }

    /**
     * 根据id获取线路信息
     * @param tid
     * @return
     */
    @RequestMapping("/listtandlById")
    public ReponseResult listtandlById(@RequestParam("tid")Integer tid){
        try {
            ReponseResult<Map> data=ReponseResult.ok(tourismtemplateService.listtandlBytid(tid),"根据id获取线路信息成功！");
            logger.info("methor:listtandlById 根据id获取线路信息成功");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:removeTemplate 系统出现异常！");
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
}
