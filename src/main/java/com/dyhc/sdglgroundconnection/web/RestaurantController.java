package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.MealType;
import com.dyhc.sdglgroundconnection.pojo.Restaurant;
import com.dyhc.sdglgroundconnection.service.DisrestaurantService;
import com.dyhc.sdglgroundconnection.service.MealTypeService;
import com.dyhc.sdglgroundconnection.service.RestaurantService;
import com.dyhc.sdglgroundconnection.utils.ClientFileUploadUtil;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 餐馆 控制层
 **/
@RequestMapping("/Restaurant")
@RestController
public class RestaurantController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(RestaurantController.class);

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private DisrestaurantService disrestaurantService;
    @Autowired
    private MealTypeService mealTypeService;


    /**
     * 赵伟伟
     * 查询饭店信息
     * @param pageNo
     * @param pageSize
     * @param restaurantName
     * @param restaurantAddress
     * @param whetherDel
     * @return
     */
    @RequestMapping("/showAllRestaurants")
    public ReponseResult showRestaurant(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize,String restaurantName,String restaurantAddress,Integer whetherDel) {
        try {
            PageInfo<Restaurant> pageInfo = restaurantService.listRestaurants(pageNo,pageSize,restaurantName,restaurantAddress,whetherDel);
            ReponseResult<List> data = ReponseResult.ok(pageInfo.getList(), pageInfo.getTotal(), "分页获取饭店成功！");
            logger.info(" method:showHotel  分页获取饭店成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showRestaurant  获取饭店数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }



    /**
     * 赵伟伟
     * 查询饭店类型是否重复
     * @return
     */
    @RequestMapping("/selectTypeById")
    public ReponseResult selectTypeById(Integer valueId, Integer restaurantId,Integer typeId) {
        int count =0;
        try {
            if (restaurantId==0){
                MealType mealType = restaurantService.selectMealTypeByTypeId(typeId);
                restaurantId = mealType.getRestaurantId();
            }
            count = restaurantService.selectTypeById(valueId,restaurantId);
            ReponseResult<Object> data = ReponseResult.ok(count, "查询成功！");
            logger.info(" method:showHotel  查询成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showRestaurant  查询失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 赵伟伟
     * 删除饭店
     * @param restaurantId
     * @return
     */
    @RequestMapping("/delRestaurantById")
    @LogNotes(operationType="饭店",content="删除")
    public ReponseResult delRestaurantById(Integer restaurantId) {
        try {
            Integer i = restaurantService.delRestaurantById(restaurantId);
            ReponseResult<Object> data = ReponseResult.ok("删除成功！");
            logger.info(" method:delRestaurantById  删除饭店成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showRestaurant  删除饭店失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("删除失败！");
            return err;
        }
    }


    /**
     * 赵伟伟
     * 新增饭店
     * @param multipartFile
     * @param request
     * @return
     */
    @PostMapping("/insertRestaurant")
    @LogNotes(operationType="饭店",content="保存")
    public ReponseResult insertRestaurant(HttpServletRequest request,@RequestParam("multipartFile") MultipartFile multipartFile) {
        try {
            String restaurant2 = request.getParameter("restaurant");
            ObjectMapper objectMapper = new ObjectMapper();
            Restaurant restaurant=objectMapper.readValue(restaurant2,Restaurant.class);
            Integer i = 0;
            String uploadResult = ClientFileUploadUtil.uploadImage(multipartFile, ".jpg");
            restaurant.setPicturePath(uploadResult);
            if (restaurant.getRestaurantId()!=0){
                i = restaurantService.updateRestaurantById(restaurant);
            }else{
                restaurant.setWhetherDel(0);
                i = restaurantService.insertRestaurant(restaurant);
            }
            ReponseResult<Object> data = ReponseResult.ok("保存成功！");
            logger.info(" method:insertRestaurant  保存饭店成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:insertRestaurant  保存饭店失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("保存失败！");
            return err;
        }
    }






    /**
     * 赵伟伟
     * @param request
     * @return
     */
    @PostMapping("/insertRestaurant1")
    @LogNotes(operationType="饭店",content="保存")
    public ReponseResult insertRestaurant1(HttpServletRequest request) {
        try {
            String restaurant2 = request.getParameter("restaurant");
            ObjectMapper objectMapper = new ObjectMapper();
            Restaurant restaurant=objectMapper.readValue(restaurant2,Restaurant.class);
            Integer i = 0;
            String smg = "";
            if (restaurant.getRestaurantId()!=0){
                i = restaurantService.updateRestaurantById1(restaurant);
                smg = "保存成功！";
            }else{
                smg = "图片不能为空！";
            }
            ReponseResult<Object> data = ReponseResult.ok(smg);
            logger.info(" method:insertRestaurant  "+smg);
            return data;
        } catch (Exception e) {
            logger.error(" method:insertRestaurant  保存饭店失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("保存失败！");
            return err;
        }
    }








    /**
     * 赵伟伟
     * 按编号查询饭店
     * @param restaurantId
     * @return
     */
    @RequestMapping("/selectRestaurantById")
    public ReponseResult selectRestaurantById(Integer restaurantId) {
        try {
            Restaurant restaurant = restaurantService.selectRestaurantById(restaurantId);
            ReponseResult<Object> data = ReponseResult.ok(restaurant,"查询成功！");
            logger.info(" method:delRestaurantById  查询饭店成功！");
            return data;
        } catch (Exception e) {
            logger.error(" method:showRestaurant  查询饭店失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("查询失败！");
            return err;
        }
    }





}
