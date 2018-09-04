package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.mapper.ReportdetailMapper;
import com.dyhc.sdglgroundconnection.pojo.*;
import com.dyhc.sdglgroundconnection.service.*;
import com.dyhc.sdglgroundconnection.service.impl.DictionariesServiceImpl;
import com.dyhc.sdglgroundconnection.utils.DateDifference;
import com.dyhc.sdglgroundconnection.utils.LogNotes;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.dyhc.sdglgroundconnection.utils.WechatFileUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

@Controller
@RequestMapping("/WeChat")
public class WeChatController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(GuideController.class);

    @Autowired
    private GuideService guideService;
    @Autowired
    private LogService logService;
    @Autowired
    private DispatchService dispatchService;
    @Autowired
    private HotelService hotelService;
    @Autowired
    private DispatchhotelService dispatchhotelService;
    @Autowired
    private DisrestaurantService disrestaurantService;
    @Autowired
    private MealTypeService mealTypeService;
    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private DisshoppService disshoppService;
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private HoteroomTypeService hoteroomTypeService;
    @Autowired
    private TemplateService templateService;
    @Autowired
    private BillService billService;
    @Autowired
    private ReportdetailService reportdetailService;
    @Autowired
    private DictionariesServiceImpl dictionariesService;
    @Autowired
    private ReportdetailMapper reportdetailMapper;
    @Autowired
    private ReportaccommodationService reportaccommodationService;


    /**
     * 导游报账住宿新增
     * @param
     * @return
     */
    @LogNotes(operationType="导游报账",content="住宿新增")
    @RequestMapping("/saveReportaccommodation")
    @ResponseBody
    public ReponseResult saveAccountType(
            @RequestParam("dispatchId")Integer dispatchId,
            @RequestParam("hotelName")String hotelName,
            @RequestParam("typeId")Integer typeId,
            @RequestParam("housePrice")Double housePrice,
            @RequestParam("roomNum")Integer roomNum,
            @RequestParam("accompanyingBed")Integer accompanyingBed,
            @RequestParam("accompanyingPrice")Double accompanyingPrice,
            @RequestParam("subtotal")Double subtotal,
            @RequestParam("payMethods")String payMethods){
        //创建总报账表的对象
        Reportdetail reportdetail =reportdetailMapper.All_dispatchId(dispatchId);
        //创建报账住宿
        Reportaccommodation reportaccommodation =new Reportaccommodation();
        reportaccommodation.setReportDetailId(reportdetail.getReportDetailId());
        reportaccommodation.setHotelName(hotelName);
        reportaccommodation.setTypeId(typeId);
        reportaccommodation.setHousePrice(housePrice);
        reportaccommodation.setRoomNum(roomNum);
        reportaccommodation.setAccompanyingBed(accompanyingBed);
        reportaccommodation.setAccompanyingPrice(accompanyingPrice);
        reportaccommodation.setSubtotal(subtotal);
        reportaccommodation.setPayMethods(payMethods);
        reportaccommodation.setLiveDate(new Date());
        reportaccommodation.setStatus(0);
        try {
            Integer num=reportaccommodationService.saveReportaccommodation(reportaccommodation) ;
            logger.info("method:savereportaccommodation 导游报账住宿新增成功");
            ReponseResult<Integer> data =ReponseResult.ok(num,"保存成功");
            data.setMsg("住宿报账成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:savereportaccommodation 导游报账住宿新增失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return  error;
        }
    }



    /**
     * 新增导游报账总信息（贾晓亮）
     * @return
     */
    @RequestMapping("/dictionaries")
    @ResponseBody
    public ReponseResult dictionaries(
            @RequestParam("dispatchId")Integer dispatchId,
            @RequestParam("valueId")Integer valueId,
            @RequestParam("remarks")String remarks,
            @RequestParam("receipt")Double receipt,
            @RequestParam("totalPayable")Double totalPayable,
            @RequestParam("balanceAmount")Double balanceAmount
    ){
        //创建导游报账总表信息
        try{
            Reportdetail reportdetail =new Reportdetail();
            reportdetail.setDispatchId(dispatchId);
            reportdetail.setReportDate(new Date());
            reportdetail.setReceipt(receipt);
            reportdetail.setTotalPayable(totalPayable);
            reportdetail.setTypeCode("BILL");
            reportdetail.setValueId(valueId);
            reportdetail.setBalanceAmount(balanceAmount);
            reportdetail.setRemarks(remarks);
            reportdetail.setStatus(1);
            reportdetail.setWhetherDel(0);
            reportdetail.setCreateBy(1);
            Integer A =reportdetailService.save_Reportfetails(reportdetail);
            ReponseResult data=ReponseResult.ok(A,"新增总报账成功");
            data.setMsg("总报账成功");
            logger.info("method:dictionaries 新增总报账成功");
            return data;
        }catch (Exception e){
            logger.error("method:dictionaries 新增总报账失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }


    /**
     * 微信登录
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/guideLogin")
    @ResponseBody
    public ReponseResult guideLogin(String username,String password){
        try {

            String mima=MD5(password);
            System.out.println(mima);
            Guide guide=guideService.login(username,mima);
            if (guide!=null){
                if(mima.equals(guide.getPassword())){
                    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                    HttpSession session=request.getSession();//创建session对象
                    session.setAttribute("staff",guide);
                    logger.info("method:login 微信登录成功");
                    return ReponseResult.ok(guide,"登录成功");
                }else {
                    logger.error("method:login 微信登录失败");
                    return ReponseResult.err("登录失败");
                }
            }else {
                logger.error("method:login 微信登录失败");
                return ReponseResult.err("登录失败");
            }

        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:login 微信登录失败");
            return ReponseResult.err("登录失败");
        }
    }

    /**
     * MD5加密
     * @param key
     * @return
     */
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }


    /**
     * 获取导游报账信息的类型名称
     * @return
     */
    @RequestMapping("/baozhangType")
    @ResponseBody
    public ReponseResult baozhangType(){
        try{
            ReponseResult data=ReponseResult.ok(reportdetailService.baozhangType(),"获取类型名称成功");
            logger.info("method:getReportdetailById 获取类型名称成功");
            return data;
        }catch (Exception e){
            logger.error("method:getReportdetailById 获取类型名称失败");
            e.printStackTrace();
            return ReponseResult.err("获取失败");
        }
    }



    /**
     * 上传单据
     * @return
     */
    @RequestMapping("/upload")
    @ResponseBody
    @LogNotes(operationType="单据",content="添加")
    public synchronized ReponseResult upload(HttpServletRequest request){
        try {
            Integer dispatchId=Integer.parseInt(request.getParameter("dispatchId"));
            Integer billTypeId=Integer.parseInt(request.getParameter("billTypeId"));
            String path= WechatFileUploadUtil.uploadImage(request,".jpg");
            Bill bill=billService.selectBillByDispatchIdAndBillTypeId(dispatchId,billTypeId);
            ReponseResult data=null;
            if (!path.equals("")){
                if (bill==null){
                    bill=new Bill();
                    bill.setDispatchId(dispatchId);
                    bill.setBillTypeId(billTypeId);
                    bill.setPicturePath(path);
                    bill.setWhetherDel(0);
                    bill.setCreateBy(1);
                    bill.setCreateDate(new Date());
                    Integer result=billService.insertBill(bill);
                    if (result==1){
                        logger.info("mothod:upload 上传成功");
                        data=ReponseResult.ok(result,"上传成功");

                    }else {
                        logger.error("mothod:upload 上传失败");
                        data=ReponseResult.err("上传失败");

                    }
                }else {
                    String lujing=bill.getPicturePath();
                    lujing+=","+path;
                    bill.setPicturePath(lujing);
                    Integer result=billService.updateBillById(bill);
                    if (result==1){
                        logger.info("mothod:upload 上传成功");
                        data=ReponseResult.ok(result,"上传成功");
                    }else {
                        logger.error("mothod:upload 上传失败");
                        data=ReponseResult.err("上传失败");
                    }
                }
            }else {
                logger.error("mothod:upload 上传失败");
                data=ReponseResult.err("上传失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:upload 上传失败");
            return ReponseResult.err("上传失败");
        }
    }

    /**
     * 微信小程序之判断旧密码是否输入正确
     * @param password
     * @return
     */
    @RequestMapping("/pdOldPassword")
    @ResponseBody
    public ReponseResult pdOldPassword(String password,Integer guideId){
        try {
            String mima=MD5(password);
            Guide guide=guideService.assignmentGuide(guideId);
            if (guide!=null){
                if(mima.equals(guide.getPassword())){
                    logger.info("method:pdOldPassword 旧密码输入正确");
                    return ReponseResult.ok(1,"旧密码输入正确");
                }else {
                    logger.error("method:pdOldPassword 旧密码输入失败");
                    return ReponseResult.err("旧密码输入失败");
                }
            }else {
                logger.error("method:pdOldPassword 旧密码输入失败");
                return ReponseResult.err("旧密码输入失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:pdOldPassword 微信登录失败");
            return ReponseResult.err("登录失败");
        }
    }

    /**
     * 微信小程序之修改密码
     * @return
     */
    @RequestMapping("/updateGuideByPassword")
    @LogNotes(operationType="微信小程序密码",content="修改")
    @ResponseBody
    public ReponseResult updateGuideByPassword(Guide guide){
        try {
            guide.setPassword(MD5(guide.getPassword()));
            Integer result=guideService.updateGuideByPassword(guide);
            if (result==1){
                logger.info("method:updateGuideByPassword 修改密码成功");
                return ReponseResult.ok(result,"修改成功");
            }else {
                logger.error("method:updateGuideByPassword 修改密码失败");
                return ReponseResult.err("修改失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:updateGuideByPassword 修改密码失败");
            return ReponseResult.err("修改失败");
        }
    }

    /**
     * 添加带团日志
     * @param log
     * @return
     */
    @RequestMapping("/insertLog")
    @LogNotes(operationType="日志",content="添加")
    @ResponseBody
    public ReponseResult insertLog(Log log){
        try {
            log.setWhetherDel(0);
            log.setCreater(1);
            log.setCreationDate(new Date());
            Integer result=logService.inserLog(log);
            ReponseResult data=null;
            if (result==1){
                logger.info("Mothod:insertLog  上传日志成功");
                data=ReponseResult.ok(result,"上传日志成功");
            }else {
                logger.info("Mothod:insertLog  上传日志失败");
                data=ReponseResult.ok(result,"上传日志失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("Mothod:insertLog  上传日志失败");
            return ReponseResult.err("上传日志失败");
        }
    }


    /**
     * 根据导游id查询调度信息
     * @param guideId 导游id
     * @return
     */
    @RequestMapping("/getDispatchByguideId")
    @ResponseBody
    public ReponseResult getDispatchByguideId(Integer guideId){
        try {
            Dispatch dispatch=dispatchService.getDispatchByguideId(guideId);
            Integer date=DateDifference.differentDays(dispatch.getTravelStartTime(),dispatch.getTravelEndTime());
            List<Integer> list=new ArrayList<Integer>();
            list.add(date);
            list.add(dispatch.getDispatchId());
            ReponseResult data=ReponseResult.ok(list,"获取调度对象成功");
            logger.info("method:getDispatchByguideId 获取调度对象成功");
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getDispatchByguideId 系统异常");
            return ReponseResult.err("获取调度对象失败");
        }
    }


    /**
     * 修改导游信息
     * @param guideId
     * @return
     */
    @RequestMapping("/assignmentGuide")
    @ResponseBody
    @LogNotes(operationType="导游表",content="导游修改赋值 ")
    public  ReponseResult assignmentGuide(@RequestParam("guideId") Integer guideId){
        try {
            ReponseResult<Guide> data =ReponseResult.ok(guideService.assignmentGuide(guideId),"导游信息修改赋值成功!");
            logger.info("method:showAccountType 导游信息修改赋值成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 导游信息修改赋值失败");
            e.printStackTrace();
            return  ReponseResult.err("系统出现异常请联系管理员");
        }
    }

    /**
     * 获取酒店名称:陈庆武
     * @param dispatchId
     * @return
     */
    @RequestMapping("/getHoterById")
    @ResponseBody
    public ReponseResult getHoterById(Integer dispatchId,Integer weight){
        try {
            Dispatchhotel dispatchhotel=dispatchhotelService.getDispatchHotel(dispatchId,weight);
            Hotel hotel=hotelService.getHotelById(dispatchhotel.getHotelId());
            logger.info("method:getHoterById  获取酒店名称成功！");
            return ReponseResult.ok(hotel,"获取酒店名称成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getHoterById  获取酒店名称失败！");
            return ReponseResult.err("获取酒店名称失败");
        }
    }

    /**
     * 获取餐厅信息
     * @param dispatchId
     * @param weight
     * @return
     */
    @RequestMapping("/getRestaurantById")
    @ResponseBody
    public ReponseResult getRestaurantById(Integer dispatchId,Integer weight){
        try {
            List<Disrestaurant> disrestaurant=disrestaurantService.getDisrestaurantById(dispatchId,weight);
            String aa="";
            if (disrestaurant.size()!=0 && disrestaurant!=null){
                List<MealType> mealType=new ArrayList<>();
                for (Disrestaurant d:disrestaurant) {
                    MealType mealType1=mealTypeService.selectById(d.getTypeId());
                    mealType.add(mealType1);
                }
                List<Restaurant> restaurant=new ArrayList<>();
                for (MealType m:mealType) {
                    Restaurant restaurant1=restaurantService.selectRestaurantById(m.getRestaurantId());
                    restaurant.add(restaurant1);
                }

                for (Restaurant r:restaurant) {
                    aa+=r.getRestaurantName()+"、";
                }
            }else {
                aa+="无";
            }

            logger.info(" method:getRestaurantById  获取餐厅信息成功！");
            return ReponseResult.ok(aa,"获取餐厅信息成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error(" method:getRestaurantById  获取餐厅信息失败！");
            return ReponseResult.err("获取餐厅信息失败");
        }
    }

    /**
     *微信小程序之获取购物地点
     * @param dispatchId
     * @param weight
     * @return
     */
    @RequestMapping("/getShoppingByIdWX")
    @ResponseBody
    public ReponseResult getShoppingByIdWX(Integer dispatchId,Integer weight){
        try {
            List<Disshopp> disshopp=disshoppService.getDisshoppById(dispatchId,weight);
            String aa="";
            if (disshopp.size()!=0 && disshopp!=null){
                List<Shopping> shoppings=new ArrayList<>();
                for (Disshopp d:disshopp) {
                    Shopping shopping=shoppingService.getShoppingById(d.getScenicSpotId());
                    shoppings.add(shopping);
                }
                for (Shopping s:shoppings) {
                    aa+=s.getShoppingSite()+"、";
                }
            }else {
                aa+="无";
            }
            System.out.println(aa);
            logger.info("method:getShoppingByIdWX  获取购物信息成功！");
            return ReponseResult.ok(aa,"获取购物地点成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getShoppingByIdWX  获取购物信息失败！");
            return ReponseResult.err("获取购物地点失败");
        }
    }

    /**
     * 微信小程序之获取行程内容
     * @param weight
     * @return
     */
    @RequestMapping("/getTemplateById")
    @ResponseBody
    public ReponseResult getTemplateById(Integer dispatchId,Integer weight){
        try {
            HoteroomType hoteroomType=hoteroomTypeService.getHoteroomTypeById(dispatchId,weight);
            Template template=templateService.selecctNameById(hoteroomType.getTemplateId());
            logger.error("method:getTemplateById  获取行程内容成功");
            return ReponseResult.ok(template,"获取行程内容成功");
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:getTemplateById  获取行程内容失败");
            return ReponseResult.err("获取行程内容失败");
        }
    }

    /**
     * 修改导游头像
     * @param request
     * @return
     */
    @RequestMapping("/updateTX")
    @ResponseBody
    public ReponseResult updateTX(HttpServletRequest request){
        try {
            Integer guideId=Integer.parseInt(request.getParameter("guideId"));
            String tx=WechatFileUploadUtil.uploadImage(request,".jpg");
            Integer result=guideService.updateTX(guideId,tx);
            if (result==1){
                logger.error("method:updateTX  修改头像成功");
                return ReponseResult.ok(tx,"修改头像成功");
            }else {
                logger.error("method:updateTX  修改头像失败");
                return ReponseResult.err("修改头像失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("method:updateTX  修改头像失败");
            return ReponseResult.err("修改头像失败");
        }
    }
}
