package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Disshopp;
import com.dyhc.sdglgroundconnection.pojo.Shopping;
import com.dyhc.sdglgroundconnection.service.DisshoppService;
import com.dyhc.sdglgroundconnection.service.ShoppingService;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 购物 控制层
 **/
@RestController
@RequestMapping("shopping")
public class ShoppingController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(ShoppingController.class);

    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private DisshoppService disshoppService;

    /**
     * 添加景点附近的购物地点
     * @param scenicSpotId
     * @param shoppingSite
     * @return
     */
    @RequestMapping("insertShopping")
    @LogNotes(operationType="购物地点",content="添加")
    public ReponseResult insertShopping(Integer scenicSpotId,String shoppingSite){
        Shopping shopping=new Shopping();
        shopping.setShoppingSite(shoppingSite);
        shopping.setScenicSpotId(scenicSpotId);
        shopping.setCreater(1);
        shopping.setWhetherDel(0);
        shopping.setCreationDate(new Date());
        try {
            ReponseResult<Integer> data=ReponseResult.ok(shoppingService.insertShopping(shopping),"添加购物地点成功");
            return  data;
        }catch (Exception e){
            ReponseResult<Integer> data=ReponseResult.err("添加购物地点失败");
            e.printStackTrace();
            return  data;
        }
    }

    /**
     * 修改景点附近的购物地点
     * @param shoppingId
     * @return
     */
    @LogNotes(operationType="购物地点",content="修改")
    @RequestMapping("updateShopping")
    public ReponseResult updateShopping(Integer shoppingId,String shoppingSite){

        try {
            Shopping shopping=shoppingService.getShoppingById(shoppingId);
            shopping.setShoppingSite(shoppingSite);
            ReponseResult<Integer> data=ReponseResult.ok(shoppingService.updateShopping(shopping,shoppingSite),"修改购物地点成功");
            return  data;
        }catch (Exception e){
            ReponseResult<Integer> data=ReponseResult.err("修改购物地点失败");
            e.printStackTrace();
            return  data;
        }
    }

    /**
     * 删除景点附近的购物地点
     * @param shoppingId
     * @return
     */
    @LogNotes(operationType="购物地点",content="删除")
    @RequestMapping("deleteShoppingById")
    public ReponseResult deleteShoppingById(Integer shoppingId){
        try {
            ReponseResult<Integer> data=ReponseResult.ok(shoppingService.deleteShoppingById(shoppingId),"删除购物地点成功");
            return  data;
        }catch (Exception e){
            ReponseResult<Integer> data=ReponseResult.err("删除购物地点失败");
            e.printStackTrace();
            return  data;
        }
    }

    /**
     *根据购物id查询该购物地点的信息
     * @param shoppingId
     * @return
     */
    @RequestMapping("getShoppingById")
    public ReponseResult getShoppingById(@RequestParam("shoppingId")Integer shoppingId){
        try {
            ReponseResult data=ReponseResult.ok(shoppingService.getShoppingById(shoppingId),"查询购物信息成功");
            return data;
        }catch (Exception e){
            ReponseResult data=ReponseResult.err("查询购物信息失败");
            e.printStackTrace();
            return  data;
        }
    }




}
