package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.mapper.DiscarMapper;
import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.parameterentity.DispatchParameter;
import com.dyhc.sdglgroundconnection.pojo.Cluster;
import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.mapper.DiscarMapper;
import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.parameterentity.DispatchParameter;
import com.dyhc.sdglgroundconnection.pojo.Cluster;
import com.dyhc.sdglgroundconnection.service.*;
import com.dyhc.sdglgroundconnection.utils.DateDifference;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度 控制层
 **/
@RequestMapping("/dispatch")
@RestController
public class DispatchController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(DispatchController.class);

    @Autowired
    private DispatchService dispatchService;
    //酒店
    @Autowired
    private DispatchhotelService dispatchhotelService;
    //餐厅
    @Autowired
    private DisrestaurantService disrestaurantService;
    //购物
    @Autowired
    private DisshoppService disshoppService;
    //线路
    @Autowired
    private HoteroomTypeService hoteroomTypeService;
    @Autowired
    private DiscarService discarService;


    /**
     * 返回所有调度信息
     * @param pageNo
     * @param pageSize
     * @param djsth
     * @param dyname
     * @param state
     * @return
     */
    @RequestMapping("/listDispatch")
    public ReponseResult listDispatch(@RequestParam("pageNo")Integer pageNo,
                                      @RequestParam("pageSize")Integer pageSize,
                                      @RequestParam("djsth")String djsth,
                                      @RequestParam("dyname")String dyname,
                                      @RequestParam("state")Integer state){
        try {
            PageInfo<Dispatch> pageInfo=dispatchService.listDispatch(pageNo, pageSize, djsth, dyname, state);
            ReponseResult<List> data=ReponseResult.ok(pageInfo.getList(),pageInfo.getTotal(),"分页获取调度信息成功！");
            logger.info("method:listDispatch 分页获取调度信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:listDispatch 系统出现异常！");
            ReponseResult<Object> err=ReponseResult.err("系统出现异常");
            return err;
        }

    }


    /**
     * 派传单
     * @param request
     * @param dispatchId
     * @return
     */
    @RequestMapping("pai")
    public ReponseResult pai(HttpServletRequest request, Integer dispatchId){
        HttpSession session = request.getSession();
        session.setAttribute("dispatchId",dispatchId);
        ReponseResult<Object> msg=ReponseResult.err("查询成功");
        return msg;
    }


    /**
     * 计划行程单
     * @param request
     * @param dispatchId
     * @return
     */
    @RequestMapping("jihua")
    public ReponseResult jihua(HttpServletRequest request, Integer dispatchId){
        HttpSession session = request.getSession();
        session.setAttribute("dispatchId",dispatchId);
        ReponseResult<Object> msg=ReponseResult.err("查询成功");
        return msg;
    }

    /**
     * 导游日志
     * @param request
     * @param dispatchId
     * @param guideId
     * @return
     */
    @RequestMapping("rizhi")
    public ReponseResult rizhi(HttpServletRequest request, Integer dispatchId,Integer guideId){
        HttpSession session = request.getSession();
        session.setAttribute("dispatchId",dispatchId);
        session.setAttribute("guideId",guideId);
        ReponseResult<Object> msg=ReponseResult.err("查询成功");
        return msg;
    }

    /**
     * 租车合同
     * @param request
     * @param dispatchId
     * @return
     */
    @RequestMapping("zuche")
    public ReponseResult zuche(HttpServletRequest request, Integer dispatchId){
        try{
            HttpSession session = request.getSession();
            session.setAttribute("dispatchId",dispatchId);
            Discar discar = discarService.selectDiscarByOfferId(dispatchId);
            session.setAttribute("disCarId",discar.getDisCarId());
            ReponseResult<Object> msg=ReponseResult.err("查询成功");
            return msg;
        }catch(Exception e){
            ReponseResult<Object> msg=ReponseResult.err("查询失败");
            return msg;
        }

    }

    /**
     * 报价单
     * @param request
     * @param dispatchId
     * @return
     */
    @RequestMapping("bao")
    public ReponseResult bao(HttpServletRequest request, Integer dispatchId){
        HttpSession session = request.getSession();
        session.setAttribute("dispatchId",dispatchId);
        ReponseResult<Object> msg=ReponseResult.err("查询成功");
        return msg;
    }

    /**
     * 订房通知单
     * @param request
     * @param dispatchId
     * @return
     */
    @RequestMapping("ding")
    public ReponseResult ding(HttpServletRequest request, Integer dispatchId){
        HttpSession session = request.getSession();
        session.setAttribute("dispatchId",dispatchId);
        ReponseResult<Object> msg=ReponseResult.err("查询成功");
        return msg;
    }

    /**
     * 订房通知单： 贾晓亮
     * @param dispatchId
     * @return
     */
    @RequestMapping("/dispatchSelectAll")
    public  ReponseResult dispatchSelectAll(HttpServletRequest request,Integer dispatchId){
        HttpSession session = request.getSession();
        try {
            dispatchId=Integer.parseInt(session.getAttribute("dispatchId").toString());
            ReponseResult<Dispatch> data =ReponseResult.ok(dispatchService.dispatchSelectAll(dispatchId),"查询计调订房通知单成功");
            logger.info("method:getresource 查询计调订房通知单成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("method:getresource 查询计调订房通知单失败！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     *计调页面信息： 贾晓亮
     * @param dispatchId
     * @return
     */
    @RequestMapping("/dispatch")
    public  ReponseResult dispatch(Integer dispatchId){
        try {
            Dispatch dispatch =dispatchService.dispatch(dispatchId);
            ReponseResult<Dispatch> data =ReponseResult.ok(dispatch,"查询计调成功");
            logger.info("method:dispatch 查询计调成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("method:dispatch 查询计调失败！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }


    /**
     * 查询资源数据
     * @return
     */
    @RequestMapping("/getresource")
    public ReponseResult getresource(){
        try {
            ReponseResult<Map> data=ReponseResult.ok(dispatchService.getresource(),"获取资源数据成功！");
            logger.info("method:getresource 获取资源数据成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:getresource 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     * 根据类型获取资源
     * @param type
     * @param valueId
     * @return
     */
    @RequestMapping("/listinfoByvalueId")
    public ReponseResult listinfoByvalueId(@RequestParam("type")String type,@RequestParam("valueId")Integer valueId){
        try {
            ReponseResult<List> data=ReponseResult.ok(dispatchService.listinfoByvalueId(type,valueId),"根据类型获取资源！");
            logger.info("method:listinfoByvalueId 根据类型获取资源！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            logger.debug("method:listinfoBycalueId 系统异常");
            return err;
        }
    }







    /**
     *根据导游报账明细id获取调度信息
     * @param reportDetailId
     * @return
     */
    @RequestMapping("getDispatchById")
    public ReponseResult getDispatchById(Integer reportDetailId){
        try {
            Dispatch dispatch=dispatchService.getDispatchById(reportDetailId);
            Integer cha=DateDifference.differentDays(dispatch.getTravelStartTime(),dispatch.getTravelEndTime());
            List<Object> list=new ArrayList<>();
            list.add(0,dispatch);
            list.add(1,cha);
            ReponseResult data=ReponseResult.ok(list,"获取成功");
            logger.info("mothed:getDispatchById 获取调度信息成功");
            return data;
        }catch (Exception e){
            logger.error("mothed:getDispatchById 获取调度信息失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }

    /**
     * 查询调度
     * @param pageNo
     * @param pageSize
     * @param guideName
     * @param groundConnectionNumber
     * @return
     */
    @RequestMapping("/listDispatchlike")
    public ReponseResult listDispatchlike(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize, @RequestParam("guideName")String guideName, @RequestParam("groundConnectionNumber")String groundConnectionNumber){
        try{
            System.out.println("..."+groundConnectionNumber+"...");
            PageInfo<Dispatch> pageInfoTravel=dispatchService.ListDispatchLike(pageNo,pageSize,guideName,groundConnectionNumber);
            ReponseResult<List> data = ReponseResult.ok(pageInfoTravel.getList(), pageInfoTravel.getTotal(), "分页获取调度信息成功！");
            logger.info(" method:TravelLike  分页获取调度信息成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:TravelLike  获取调度信息数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 修改调度信息
     * @param did
     * @param gid
     * @param travelStartTime
     * @param travelEndTime
     * @return
     */
    @LogNotes(operationType="调度信息",content="修改")
    @RequestMapping("/updatestateById")
    public ReponseResult updatestateById(@RequestParam("did")Integer did,
                                         @RequestParam("gid")Integer gid,
                                         @RequestParam("travelStartTime")String travelStartTime,
                                         @RequestParam("travelEndTime")String travelEndTime){
        try {
            ReponseResult<Integer> data=ReponseResult.ok(dispatchService.updatestateById(did, gid, travelStartTime, travelEndTime),"审核成功！");
            logger.info("method:updatestateById 审核成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     *根据报价单Id获取报价信息 张枫
     * @param oid
     * @return
     */
    @RequestMapping("/getofferinfoById")
    public ReponseResult getofferinfoById(@RequestParam("oid")Integer oid){
        try {
            ReponseResult<Map> data=ReponseResult.ok(dispatchService.getofferinfoById(oid),"获取报价信息成功！");
            logger.info("method:getofferinfoById 获取报价信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:getofferinfoById 系统异常！");
            ReponseResult<Object> err=ReponseResult.err("系统异常！");
            return err;
        }
    }


    /**
     * 查看线路
     * @param
     * @return
     */
    @RequestMapping("/findDispatchxxx.html")
    public ReponseResult findDispatchxxx(Integer dispatchId){
        try{
            List<String> list1=dispatchhotelService.listDispatchhotelAll(dispatchId);
            List<String> list2=disrestaurantService.listDisrestaurantAll(dispatchId);
            List<String> list3=disshoppService.listDisshoppAll(dispatchId);
            List<HoteroomType> list4=hoteroomTypeService.listOfferlineAll(dispatchId);
            List list5=new ArrayList();
            list5.add(list1);
            list5.add(list2);
            list5.add(list3);
            list5.add(list4);
            logger.info(" method:findDispatchxxx  查看线路成功！");
            ReponseResult<List> data= ReponseResult.ok(list5,"查看线路成功！");
            return data;
        }catch (Exception e) {
            logger.error(" method:findDispatchxxx  查看线路失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 查看接团信息
     * @param dispatchId
     * @return
     */
    @RequestMapping("/findCluster.html")
    public ReponseResult findCluster(Integer dispatchId){
        try{
            Cluster cluster=dispatchService.ClusterById(dispatchId);
            logger.info(" method:findCluster  查看接团信息成功！");
            return ReponseResult.ok(cluster,"查看接团信息成功！");
        }catch (Exception e) {
            logger.error(" method:findCluster  查看接团信息失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 查看车辆联系人
     * @param dispatchId
     * @return
     */
    @RequestMapping("/findDispatch.html")
    public ReponseResult findDispatch(Integer dispatchId){
        try{
            Dispatch dispatch=dispatchService.listDispatch(dispatchId);
            logger.info(" method:findStaff  查看车辆联系人成功！");
            return ReponseResult.ok(dispatch,"查看车辆联系人成功！");
        }catch (Exception e) {
            logger.error(" method:findStaff  查看车辆联系人失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 新增调度信息  张枫
     * @param dispatchParameter
     * @return
     */
    @RequestMapping(value = "/saveDispatch")
    @LogNotes(operationType="调度信息",content="新增")
    public ReponseResult saveDispatch(@RequestBody DispatchParameter dispatchParameter){
        try {
            ReponseResult data=ReponseResult.ok(dispatchService.saveDispatch(dispatchParameter),"");
            logger.info("method:saveDispatch 保存调度信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:saveDispatch 系统出现错误！");
            ReponseResult<Object> err=ReponseResult.err("系统出现错误!");
            return err;
        }

    }

    /**
     * 根据调度id获取调度的相关信息 张枫
     * @param dispatchId
     * @return
     */
    @RequestMapping("/getDispatchBydispatchId")
    public ReponseResult getDispatchBydispatchId(@RequestParam("dispatchId")Integer dispatchId){
        try {
            ReponseResult<Map> data=ReponseResult.ok(dispatchService.getDispatchinfoById(dispatchId),"根据id获取调度信息成功！");
            logger.info("method:getDispatchById 获取调度信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:getDispatchById 系统异常！");
            ReponseResult err=ReponseResult.err("系统异常！");
            return err;
        }
    }

    /**
     * 修改调度信息  张枫
     * @param dispatchParameter
     * @return
     */
    @LogNotes(operationType="调度信息",content="修改")
    @RequestMapping(value = "/updateDispatch",method = RequestMethod.POST)
    public ReponseResult updateDispatch(@RequestBody DispatchParameter dispatchParameter){
        System.out.println("...........................");
        try {
            ReponseResult data=ReponseResult.ok(dispatchService.updateDispatch(dispatchParameter),"调用修改调度信息成功！");
            logger.info("method:saveDispatch 保存调度信息成功！");
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("method:saveDispatch 系统出现错误！");
            ReponseResult<Object> err=ReponseResult.err("系统出现错误!");
            return err;
        }

    }
}
