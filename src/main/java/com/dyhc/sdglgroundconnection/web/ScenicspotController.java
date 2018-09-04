package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Scenicspot;
import com.dyhc.sdglgroundconnection.service.ScenicspotService;
import com.dyhc.sdglgroundconnection.service.ShoppingService;
import com.dyhc.sdglgroundconnection.utils.ClientFileUploadUtil;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 景点 控制层
 **/
@RestController
@RequestMapping("/Scenicspot")
public class ScenicspotController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ScenicspotController.class);

    @Autowired
    private ScenicspotService scenicspotService;
    @Autowired
    private ShoppingService shoppingService;


    /**
     * 根据条件查询景点
     * @param typeId
     * @param scenicSpotName
     * @param scenicSpotAddress
     * @param pageNo
     * @return
     */
    @RequestMapping("/listScenicspots")
    public ReponseResult listScenicspots(Integer typeId, String scenicSpotName, String scenicSpotAddress, Integer pageNo,Integer pageSize) {
        try {
            PageInfo<Scenicspot> scenicspotPageInfo = scenicspotService.listScenicspots(typeId, scenicSpotName, scenicSpotAddress, pageNo, pageSize);
            ReponseResult<List> data = ReponseResult.ok(scenicspotPageInfo.getList(), scenicspotPageInfo.getTotal(), "分页获取景点成功！");
            logger.info(" method:showHotel  分页获取景点成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  获取景点数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 根据父景点编号查询景点名称
     * @param parentId
     * @return
     */
    @RequestMapping("/getScenicspotByParentId")
    public ReponseResult getScenicspotByParentId(Integer parentId){
        try {
            PageInfo<Scenicspot> scenicspotPageInfo = scenicspotService.getScenicspotByParentId(parentId);
            ReponseResult<List> data = ReponseResult.ok(scenicspotPageInfo.getList(), scenicspotPageInfo.getTotal(), "分页获取景点成功！");
            logger.info(" method:showHotel  分页获取景点成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showHotel  获取景点数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 获取所有父景点名称
     * @return
     */
    @RequestMapping("listScenicspot")
    public ReponseResult listScenicspot(){
        try {
            List<Scenicspot> list=scenicspotService.getScenicspotParentName();
            ReponseResult<List> data=ReponseResult.ok(list,"获取所有父景点成功");
            return data;
        }catch (Exception e){
            ReponseResult data=ReponseResult.err("获取所有父景点失败");
            e.printStackTrace();
            return data;
        }
    }


    /**
     * 添加景点
     * @return
     */
    @PostMapping("insertScenicspotInfo")
    @LogNotes(operationType="景点",content="添加")
    public ReponseResult insertScenicspotInfo(HttpServletRequest request , @RequestParam("multipartFile") MultipartFile multipartFile){
        try {
            String scenicspot1 = request.getParameter("scenicspot");
            ObjectMapper objectMapper = new ObjectMapper();
            Scenicspot scenicspot2 = objectMapper.readValue(scenicspot1, Scenicspot.class);
            // 上传图片操作
            String uploadResult = ClientFileUploadUtil.uploadImage(multipartFile,".jpg");
           scenicspot2.setTypeCode("ATTRACTIONS");
           scenicspot2.setCreateDate(new Date());
           scenicspot2.setCreateBy(1);
           scenicspot2.setPicturePath(uploadResult);
           scenicspot2.setWhetherDel(0);

            ReponseResult<Integer> data=null;
            if (!"".equals(uploadResult)) {
                logger.info(" method:testUploadImage 上传图片成功！");
                Integer result=scenicspotService.insertScenicspot(scenicspot2);
                if (result==1){
                    data=ReponseResult.ok(result,"添加景点成功");
                    logger.info("添加景点成功");
                }else if (result==0){
                    data=ReponseResult.err("添加景点失败");
                    logger.info("添加景点失败");
                }
            } else {
                logger.error(" method:testUploadImage 上传图片失败，请稍后再试！");
                return ReponseResult.err("上传图片失败，请稍后再试！");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("添加失败");
            return ReponseResult.err("添加失败");
        }
    }

    /**
     * 根据景点id查询该景点信息
     * @param scenicSpotId
     * @return
     */
    @RequestMapping("getScenicspotById")
    public ReponseResult getScenicspotById(Integer scenicSpotId){
        try {
            ReponseResult data=ReponseResult.ok(scenicspotService.getScenicspotById(scenicSpotId),"查询景点成功");
            return data;
        }catch (Exception e){
            ReponseResult data=ReponseResult.err("查询景点失败");
            e.printStackTrace();
            return  data;
        }
    }

    /**
     * 修改景点并修改图片
     * @return
     */
    @PostMapping("updateScenicspotInfo")
    @LogNotes(operationType="景点",content="修改")
    public ReponseResult updateScenicspotInfo(HttpServletRequest request , @RequestParam("multipartFile") MultipartFile multipartFile){
        try {
            String scenicspot1 = request.getParameter("scenicspot");
            ObjectMapper objectMapper = new ObjectMapper();
            Scenicspot scenicspot2 = objectMapper.readValue(scenicspot1, Scenicspot.class);
            // 上传图片操作
            String uploadResult = ClientFileUploadUtil.uploadImage(multipartFile, ".jpg");
            scenicspot2.setTypeCode("ATTRACTIONS");
            scenicspot2.setUpdateDate(new Date());
            scenicspot2.setUpdateBy(1);
            scenicspot2.setPicturePath(uploadResult);
            scenicspot2.setWhetherDel(3);

            ReponseResult<Integer> data=null;
            if (!"".equals(uploadResult)) {
                logger.info(" method:testUploadImage 上传图片成功！");
                Integer result=scenicspotService.updateScenicspot(scenicspot2);
                if (result==1){
                    data=ReponseResult.ok(result,"修改景点成功");
                    logger.info("修改景点成功");
                }else if (result==0){
                    data=ReponseResult.err("修改加景点失败");
                    logger.info("修改景点失败");
                }
            } else {
                logger.error(" method:testUploadImage 上传图片失败，请稍后再试！");
                return ReponseResult.err("上传图片失败，请稍后再试！");
            }

            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("修改失败");
            return ReponseResult.err("修改失败");
        }
    }

    /**
     * 修改景点不修改图片
     * @return
     */
    @PostMapping("updateScenicspotInfo1")
    @LogNotes(operationType="景点",content="修改")
    public ReponseResult updateScenicspotInfo1(Scenicspot scenicspot){
        try {
            scenicspot.setTypeCode("ATTRACTIONS");
            scenicspot.setUpdateDate(new Date());
            scenicspot.setUpdateBy(1);
            scenicspot.setWhetherDel(3);
            ReponseResult<Integer> data=null;
            Integer result=scenicspotService.updateScenicspot(scenicspot);
            if (result==1){
                data=ReponseResult.ok(result,"修改景点成功");
                logger.info("修改景点成功");
            }else if (result==0){
                data=ReponseResult.err("修改加景点失败");
                logger.info("修改景点失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("修改失败");
            return ReponseResult.err("修改失败");
        }
    }

    /**
     * 根据景点id删除该景点,并删除附近的购物地点
     * @param scenicSpotId
     * @return
     */
    @RequestMapping("deleteScenicspotById")
    @LogNotes(operationType="景点",content="删除")
    public ReponseResult deleteScenicspotById(Integer scenicSpotId){
        try {
            Integer result=shoppingService.deleteShoppingsByscenicSpotId(scenicSpotId);
            ReponseResult data=null;
            if (result==1){
               data=ReponseResult.ok(result,"删除景点成功");
                logger.info("删除景点成功");
                Integer result1=scenicspotService.deleteScenicspotById(scenicSpotId);
                if (result1==1){
                    data=ReponseResult.ok(result1,"删除景点成功");
                    logger.info("删除景点成功");
                }else {
                    data=ReponseResult.err("删除景点失败");
                    logger.info("删除景点失败");
                }
            }

            return  data;

        }catch (Exception e){
            ReponseResult data=ReponseResult.err("删除景点失败");
            e.printStackTrace();
            return data;
        }

    }


    /**
     * 景点模板查询
     * @return
     */
    @RequestMapping("/listScenicspotAll")
    public ReponseResult listScenicspotAll() {
        try {
            List<Scenicspot> list = scenicspotService.selectAllScenic();
            ReponseResult<Object> data = ReponseResult.ok(list,"查询成功！");
            logger.info(" method:selectTourismtemplate  查询景点模板成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:selectTourismtemplate  查询景点模板失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }

    /**
     * 获取景点
     * @return
     */
    @RequestMapping("selectByScenicSpotId")
    public ReponseResult selectByScenicSpotId(Integer scenicSpotId){
        try {
            Scenicspot scenicspot=scenicspotService.selectByScenicSpotId(scenicSpotId);
            ReponseResult<Object> data=ReponseResult.ok(scenicspot,"获取景点成功");
            return  data;
        }catch (Exception e){
            ReponseResult<List> data=ReponseResult.err("获取景点失败");
            e.printStackTrace();
            return  data;
        }
    }



}
