package com.dyhc.sdglgroundconnection.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 进入页面-控制器
 **/
@Controller
@RequestMapping("/admins")
public class EnterAdminPageController {

    // 日志对象
    private Logger logger = LoggerFactory.getLogger(EnterAdminPageController.class);

    /**
     * git测试页面
     * @return
     */
    @RequestMapping("/index.html")
    public String enterIndex() {
        return "index";
    }

    /**
     * 分页demo1
     * @return
     */
    @RequestMapping("/PageDemo1.html")
    public String enterPageDemo1() {
        return "PageDemo1";
    }



    /**
     * 派团单
     * @return
     */
    @RequestMapping("/Delegation")
    public String Delegation() {
        return "voucher/Mission";
    }

    /**
     * 分页demo2
     * @return
     */
    @RequestMapping("/PageDemo2.html")
    public String enterPageDemo2() {
        return "PageDemo2";
    }



    /**
     * 进入admin-info页面
     * @return
     */
    @RequestMapping("/admin-info.html")
    public String  adminInfo() {
        return "admin/index/admin-info";
    }

    /**
     * 进入adminIndex页面
     * @return
     */
    @RequestMapping("/adminIndex.html")
    public String  adminIndex() {
        return "admin/index/adminIndex";
    }

    /**
     * 进入article-add页面
     * @return
     */
    @RequestMapping("/article-add.html")
    public String  articleAdd() {
        return "admin/index/article-add";
    }

    /**
     * 进入article-detail页面
     * @return
     */
    @RequestMapping("/article-detail.html")
    public String  articleDetail() {
        return "admin/index/article-detail";
    }

    /**
     * 进入article-list页面
     * @return
     */
    @RequestMapping("/article-list.html")
    public String  articleList() {
        return "admin/index/staff-list";
    }

    /**
     * 进入article-list1页面
     * @return
     */
    @RequestMapping("/article-list1.html")
    public String  articleList1() {
        return "admin/index/article-list1";
    }

    /**
     * 进入column-danye-detail页面
     * @return
     */
    @RequestMapping("/column-danye-detail.html")
    public String  columnDanyeDetail() {
        return "admin/index/column-danye-detail";
    }

    /**
     * 进入danye-detail页面
     * @return
     */
    @RequestMapping("/danye-detail.html")
    public String  danyeDetail() {
        return "admin/index/danye-detail";
    }

    /**
     * 进入danye-list页面
     * @return
     */
    @RequestMapping("/danye-list.html")
    public String  danyeDist() {
        return "admin/index/danye-list";
    }

    /**
     * 进入email页面
     * @return
     */
    @RequestMapping("/email.html")
    public String  email() {
        return "admin/index/email";
    }

    /**
     * 进入email-write页面
     * @return
     */
    @RequestMapping("/email-write.html")
    public String  emailWrite() {
        return "admin/index/email-write";
    }

    /**
     * 进入login页面
     * @return
     */
    @RequestMapping("/login.html")
    public String  login() {
        return "admin/index/login";
    }

    /**
     * 进入menu1页面
     * @return
     */
    @RequestMapping("/menu1.html")
    public String  menu1() {
        return "admin/index/menu1";
    }

    /**
     * 进入menu2页面
     * @return
     */
    @RequestMapping("/menu2.html")
    public String  menu2() {
        return "admin/index/menu2";
    }

    /**
     * 进入menu-add页面
     * @return
     */
    @RequestMapping("/menu-add.html")
    public String  menuAdd() {
        return "admin/index/menu-add";
    }


    /**
     * 进入menu-update页面
     * @return
     */
    @RequestMapping("/menu-update.html")
    public String  menuUpdate(Integer accountTypeId, HttpServletRequest request) {
        request.setAttribute("accountTypeId",accountTypeId);
        return "admin/index/menu-update";
    }

    /**
     * 进入menu-guide-add.html页面
     * @return
     */
    @RequestMapping("/menu-guide-add.html")
    public String   menuGuideAdd() {
        return "admin/index/menu-guide-add";
    }

    /**
     * 进入menu-guide-add.html页面
     * @return
     */
    @RequestMapping("/menu-guide-update.html")
    public  String  menuGuideupdate(Integer guideId,HttpServletRequest request) {
        request.setAttribute("guideId",guideId);
        System.out.println(request.getAttribute("guideId"));
        return "admin/index/menu-guide-update";
    }



    /**
     * 进入menu-add1页面
     * @return
     */
    @RequestMapping("/menu-add1.html")
    public String  menuAdd1() {
        return "admin/index/menu-add1";
    }

    /**
     * 进入rbac-admin页面
     * @return
     */
    @RequestMapping("/rbac-admin.html")
    public String  rbacAdmin() {
        return "admin/index/rbac-admin";
    }

    /**
     * 进入rbac-user-list页面
     * @return
     */
    @RequestMapping("/rbac-user-list.html")
    public String  rbacUserList() {
        return "admin/index/rbac-user-list";
    }

    /**
     * 进入system页面
     * @return
     */
    @RequestMapping("/system.html")
    public String  system() {
        return "admin/index/system";
    }

    /**
     * 进入welcome页面
     * @return
     */
    @RequestMapping("/welcome.html")
    public String  welcome() {
        return "admin/index/welcome";
    }


    /**
     * 进入company-admin页面
     * @return
     */
    @RequestMapping("/company-admin.html")
    public String  companyAdmin() {
        return "admin/index/company-admin";
    }

    /**
     * 进入company-admin页面
     * @return
     */
    @RequestMapping("/log-operate-admin.html")
    public String  logOperateAdmin() {
        return "admin/index/log-operate-admin";
    }

    /**
     * 进入system页
     * @return
     */
    @RequestMapping("/travel_add.html")
    public String  traveladd() {
        return "admin/index/travel_add";
    }
    /**
     * 进入system页
     * @return
     */
    @RequestMapping("/travel_list.html")
    public String  travellist() {
        return "admin/index/travel_list";
    }

    /**
     * 进入travel_upd.html页面   刘跃云
     * @return
     */
    @RequestMapping("/travel_upd.html")
    public String  menuUpdatel(Integer travelId, HttpServletRequest request) {
        request.setAttribute("travelId",travelId);
        System.out.println(11111);
        return "admin/index/travel_upd";
    }
    /**
     * 进入companyone_admin.html页面   刘跃云
     * @return
     */
    @RequestMapping("/companyone_admin.html")
    public String  company_updat() {
        System.out.println(1);
        return "admin/index/companytwo-admin";
    }



    /**
     * 进入company_update.html页面   刘跃云
     * @return
     */
    @RequestMapping("/companytwo_update.html")
    public String  company_update(Integer companyId, HttpServletRequest request) {
        request.setAttribute("companyId",companyId);
        System.out.println("112345"+companyId);
        return "admin/index/companytwo-update";
    }
    /**
     * 进入staff-add.html页面   刘跃云
     * @return
     */
    @RequestMapping("/staff-add.html")
    public String  lllili() {
        return "admin/index/staff-add";
    }
    /**
     * 进入staff-add.html页面   刘跃云
     * @return
     */
    @RequestMapping("/staff-upd.html")
    public String  haha(Integer staffId, HttpServletRequest request) {
        request.setAttribute("staffId",staffId);
        System.out.println("112345"+staffId);
        return "admin/index/staff-add";
    }

}
