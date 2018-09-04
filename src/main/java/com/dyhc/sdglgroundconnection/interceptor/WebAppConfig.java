package com.dyhc.sdglgroundconnection.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {


    /**
     * 赵伟伟
     * 注册自定义拦截器，添加拦截路径和排除拦截路径
     * @param registry
     */
   @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new InterceptorConfig()).addPathPatterns("/**")
                .excludePathPatterns("/admins/login.html","/static/**","/Staff/login",
                        "/admin/**","/css/**","/font/**","/images/**","/js/**"
                        ,"/lay/modules/**","/WeChat/guideLogin",
                        "/WeChat/pdOldPassword","/WeChat/updateGuideByPassword",
                        "/WeChat/insertLog","/WeChat/getDispatchByguideId",
                        "/WeChat/assignmentGuide","/WeChat/getHoterById","" +
                        "/WeChat/getRestaurantById","/WeChat/getShoppingByIdWX"
                        ,"/WeChat/getTemplateById","/WeChat/upload","/WeChat/updateTX",
                        "/WeChat/saveReportaccommodation","/WeChat/baozhangType","/WeChat/dictionaries","/WeChat/saveReportaccommodation","/RoomType/roomType_All","/Reportaccommodation/jiudianquanbu","/Reportfare/savereportaccommodation","/Reportqutsubsidy/saveReportqutsubsidy","/Reportrestaurant/saveStaurant","/Reportticket/saveReportticket","/WeChat/dictionaries","/Reportingotherexpenses/saveReportingotherexpenses");
    }

}
