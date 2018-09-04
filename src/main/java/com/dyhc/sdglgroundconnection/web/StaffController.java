package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Staff;
import com.dyhc.sdglgroundconnection.service.StaffService;
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
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 人员 控制层
 **/
@RequestMapping("/Staff")
@RestController
public class StaffController  {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private StaffService staffService;

    /**
     * 查询人员全部信息
     * @return
     */
    @LogNotes(operationType="用户信息",content="查询账户")
    @RequestMapping("/showAllstaff")
    public ReponseResult showAllstaff(){
        try {
            ReponseResult<List<Staff>> data =ReponseResult.ok(staffService.idAccountType(),"查询成功");
            logger.info("method:showAccountType 人员查询成功");
            return  data;
        } catch (Exception e) {
            logger.info("method:showAccountType 人员查询失败");
            e.printStackTrace();
            ReponseResult<Object> error =ReponseResult.err("系统出现异常请联系管理员");
            return error;
        }
    }


    /**
     * 赵伟伟
     * 登录
     * @param theUserName
     * @param password
     * @return
     */
    @RequestMapping("login")
    public ReponseResult login(String theUserName,String password){
        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.
                        getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();//创建session对象

        Staff staff = new Staff();
        try {
            staff = staffService.login(theUserName,password);
            if(staff==null){
                ReponseResult<Integer> err = ReponseResult.ok(-1,"用户名和密码不存在！");
                System.out.println(err);
                return err;
            }else{
                session.setAttribute("staff",staff);
                logger.info(staff.getStaffname()+"登陆成功！");
                int role = staff.getRoleId();
                ReponseResult<Integer> info = ReponseResult.ok(role,"登陆成功！");
                System.out.println(info);
                return info;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("method:login  登陆失败！");
            ReponseResult<Integer> err = ReponseResult.ok(-1,"登录失败！");
            System.out.println(err);
            return err;
        }
    }

    /**
     * 分页查看全部
     * @param pageNo
     * @param pageSize
     * @param staffname
     * @return
     */
    @RequestMapping("/showstaffLike.html")
    public ReponseResult StaffLike(@RequestParam("page") Integer pageNo, @RequestParam("limit") Integer pageSize, @RequestParam("staffname")String staffname){
        try{
            System.out.println("..."+staffname+"...");
            PageInfo<Staff> pageInfoTravel=staffService.listStaffLike(pageNo,pageSize,staffname);
            ReponseResult<List> data = ReponseResult.ok(pageInfoTravel.getList(), pageInfoTravel.getTotal(), "分页获取组团社成功！");
            logger.info(" method:StaffLike  分页获取组团社成功！");
            return data;
        }catch (Exception e){
            logger.error(" method:StaffLike  获取组团社数据失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Object> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 删除   修改
     * @param staff
     * @return
     */
    @LogNotes(operationType="人员信息",content="删除")
    @RequestMapping("/StaffUpd.html")
    public ReponseResult<Integer> StaffUpd(Staff staff){
        try{
            Integer result=0;
            Integer data=0;
            result=staffService.getStaffUpd(staff);
            if(result>0){
                data=1;
            }
            logger.info(" method:showTravelupdlala  删除人员成功！");
            return ReponseResult.ok(data,"删除人员成功！");
        }catch (Exception e){
            logger.error(" method:showTravelupdlala  删除人员失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 判断用户是否存在
     * @param
     * @return
     */
    @PostMapping("/StaffSelect.html")
    public ReponseResult StaffSelect(){
        try{
            Integer data=0;
            Staff staff=staffService.getserlectBy();
            if(staff!=null){
                data=1;
            }
            System.out.println(staff.getPhone());
            logger.info(" method:StaffSelect  修改人员成功！");
            return ReponseResult.ok(data,"修改人员成功！");
        }catch (Exception e){
            logger.error(" method:StaffSelect  修改人员失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }
    /**
     * 人员信息添加
     * @param
     * @return
     */
    @LogNotes(operationType="人员信息",content="添加")
    @PostMapping("/StaffAdd.html")
    public ReponseResult StaffAdd(HttpServletRequest request, @RequestParam(value = "headPortraitPath",required = false)MultipartFile headPortraitPath){
        try{
            String staff1=request.getParameter("staff");
            ObjectMapper objectMapper=new ObjectMapper();
            Staff staff2=objectMapper.readValue(staff1,Staff.class);
            Integer i=0;
            String uploadResult=ClientFileUploadUtil.uploadImage(headPortraitPath,".jpg");
            staff2.setHeadPortraitPath(uploadResult);
            if(staff2.getStaffId()!=0){
                i=staffService.getStaffUpdTwo(staff2);
                System.out.println("***********"+i);
            }else{
                staff2.setWhetherDel(0);
                staff2.setPassword(MD5("123456"));
                i=staffService.getStaffAdd(staff2);
                System.out.println("***********"+i);
            }
            logger.info(" method:StaffAdd  保存成功！");
            return ReponseResult.ok(i,"保存成功！");
        }catch (Exception e){
            logger.error(" method:StaffAdd  保存人员失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 修改    查看
     * @param staffId
     * @return
     */
    @LogNotes(operationType="人员信息",content="修改")
    @RequestMapping("/StaffUpdTwoById.html")
    public ReponseResult StaffUpdTwoById(Integer staffId){
        try{
            Staff result=staffService.getStaffUpdTwoById(staffId);
            logger.info(" method:StaffAdd  添加人员成功！");
            return ReponseResult.ok(result,"修改人员成功！");
        }catch (Exception e){
            logger.error(" method:StaffAdd  添加人员失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 查看计调员
     * @param dispatchId
     * @return
     */
    @RequestMapping("/findStaff.html")
    public ReponseResult findStaff(Integer dispatchId){
        try{
            Staff staff=staffService.listStaff(dispatchId);
            logger.info(" method:findStaff  查看计调员成功！");
            return ReponseResult.ok(staff,"查看计调员成功！");
        }catch (Exception e) {
            logger.error(" method:findStaff  查看计调员失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }


    /**
     * 获取个人信息
     * @return
     */
    @RequestMapping("getStaffInfo")
    public ReponseResult getStaffInfo(){
        try {

            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session=request.getSession();//创建session对象
            if (session.getAttribute("staff")!=null){
                Staff staff=(Staff)session.getAttribute("staff");
                logger.info("mothod:getStaffInfo 获取成功");
                return ReponseResult.ok(staff,"获取成功");
            }else {
                logger.info("mothod:getStaffInfo 该用户还没有登录");
                return ReponseResult.ok("该用户还没有登录");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothid:getStaffInfo 获取失败");
            return ReponseResult.err("获取个人信息失败");
        }
    }


    /**
     * 修改用户信息并上传头像
     * @param multipartFile
     * @return
     */
    @RequestMapping("updateStaffInfo1")
    @LogNotes(operationType="工作人员",content="修改")
    public ReponseResult updateStaffInfo1(HttpServletRequest request ,@RequestParam("multipartFile") MultipartFile multipartFile){
        try {
            String currentAddress=request.getParameter("currentAddress");
            String phone=request.getParameter("phone");
            String qqnumber=request.getParameter("qqnumber");
            String id=request.getParameter("staffId");
            Integer staffId=Integer.parseInt(id);
            String uploadResult = ClientFileUploadUtil.uploadImage(multipartFile,".jpg");
            ReponseResult<Integer> data=null;
            if (!"".equals(uploadResult)) {
                logger.info(" method:updateStaffInfo 上传图片成功！");
                Integer result=staffService.updateStaffInfo1(currentAddress,phone,qqnumber,uploadResult,staffId);
                if (result==1){
                    HttpSession session=request.getSession();//创建session对象
                    Staff staff=(Staff) session.getAttribute("staff");
                    staff.setCurrentAddress(currentAddress);
                    staff.setPhone(phone);
                    staff.setQqnumber(qqnumber);
                    staff.setHeadPortraitPath(uploadResult);
                    session.setAttribute("staff",staff);
                    data=ReponseResult.ok(result,"修改成功");
                    logger.info("method:updateStaffInfo1 修改成功");
                }else if (result==0){
                    data=ReponseResult.err("修改失败");
                    logger.info("method:updateStaffInfo1 修改失败");
                }
            } else {
                logger.error(" method:updateStaffInfo1 上传图片失败，请稍后再试！");
                data=ReponseResult.err("上传图片失败，请稍后再试！");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:updateStaffInfo1 修改失败");
            return ReponseResult.err("修改失败");
        }
    }

    /**
     * 修改用户信息不上传头像
     * @return
     */
    @RequestMapping("updateStaffInfo2")
    @LogNotes(operationType="工作人员",content="修改")
    public ReponseResult updateStaffInfo2(HttpServletRequest request){
        try {
            String currentAddress=request.getParameter("currentAddress");
            String phone=request.getParameter("phone");
            String qqnumber=request.getParameter("qqnumber");
            String id=request.getParameter("staffId");
            Integer staffId=Integer.parseInt(id);
            Integer result=staffService.updateStaffInfo2(currentAddress,phone,qqnumber,staffId);
            ReponseResult<Integer> data=null;
            if (result==1){
                HttpSession session=request.getSession();//创建session对象
                Staff staff=(Staff) session.getAttribute("staff");
                staff.setCurrentAddress(currentAddress);
                staff.setPhone(phone);
                staff.setQqnumber(qqnumber);
                session.setAttribute("staff",staff);
                data=ReponseResult.ok(result,"修改成功");
                logger.info("method:updateStaffInfo2 修改成功");
            }else if (result==0){
                data=ReponseResult.err("修改失败");
                logger.info("method:updateStaffInfo2 修改失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:updateStaffInfo2 修改失败");
            return ReponseResult.err("修改失败");
        }
    }


    /**
     * 判断旧密码是否正确
     * @param staffId
     * @param oldPassword
     * @return
     */
    @RequestMapping("pdPassword")
    public ReponseResult pdPassword(Integer staffId,String oldPassword){
        try {
            String aa=MD5(oldPassword);
            Staff staff=staffService.pdPassword(staffId);
            ReponseResult data=null;
            if (aa.equals(staff.getPassword())){
                logger.info("mothod:pdPassword 获取成功");
                data=ReponseResult.ok("获取成功");
            }else {
                logger.error("mothod:pdPassword 获取失败");
                data=ReponseResult.ok("获取失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:pdPassword 获取失败");
            return ReponseResult.err("获取失败");
        }
    }


    /**
     * 修改密码
     * @param staffId
     * @param password
     * @return
     */
    @RequestMapping("updatePassword")
    @LogNotes(operationType="密码",content="修改")
    public ReponseResult updatePassword(Integer staffId,String password){
        try {
            String aa=MD5(password);
            Integer result=staffService.updatePassword(staffId,aa);
            ReponseResult data=null;
            if (result==1){
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                HttpSession session=request.getSession();//创建session对象
                session.removeAttribute("staff");
                logger.info("mothod:updatePassword 修改成功");
                data=ReponseResult.ok(result,"修改成功");
            }else {
                logger.error("mothod:updatePassword 修改失败");
                data=ReponseResult.ok("修改失败");
            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:pdPassword 修改失败");
            return ReponseResult.err("修改失败");
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
     * 判断用户名是否存在
     * @param theUserName
     * @return
     */
    @RequestMapping("/ShowStafftheUserName")
    public ReponseResult StaffByName(String theUserName){
        System.out.println("........................................");
        try{
            Integer data=0;

            Staff staff=staffService.StaffByName(theUserName);
            if(staff!=null){
                data=1;
            }
            logger.info(" method:StaffByName  判断车辆类型是否存在成功！");
            return ReponseResult.ok(data,"判断车辆类型是否存在成功！");
        }catch (Exception e){
            logger.error(" method:StaffByName  判断车辆类型是否存在失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 不修改图片
     * @param
     * @return
     */
    @PostMapping("/findStaffThree")
    @LogNotes(operationType="人员信息",content="修改")
    public ReponseResult findStaffThree(HttpServletRequest request){
        String file="";
        try{
            String staff1=request.getParameter("staff");
            ObjectMapper objectMapper=new ObjectMapper();
            Staff staff2=objectMapper.readValue(staff1,Staff.class);
            Integer i=0;
            if(staff2.getStaffId()!=0){
                file="保存成功";
                i=staffService.getStaffUpdThree(staff2);
                System.out.println("***********"+i);
            }else{
                file="图片不能为空";
            }
            logger.info(" method:StaffAdd  保存成功！");
            return ReponseResult.ok(i,file);
        }catch (Exception e){
            logger.error(" method:StaffAdd  保存人员失败，系统出现异常！");
            e.printStackTrace();
            ReponseResult<Integer> err = ReponseResult.err("系统出现异常！");
            return err;
        }
    }

    /**
     * 退出登录,清空session
     * @return
     */
    @RequestMapping("qingkong")
    public ReponseResult qingkong(){
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session=request.getSession();
            session.removeAttribute("staff");
            if (session.getAttribute("staff")==null){
                logger.info("mothod:qingkong 清空session成功");
                return ReponseResult.ok(1,"清空session成功");
            }else {
                logger.error("mothod:qingkong 清空session失败");
                return ReponseResult.err("清空session失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error("mothod:qingkong 清空session失败");
            return ReponseResult.err("清空session失败");
        }
    }
}
