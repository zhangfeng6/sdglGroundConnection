package com.dyhc.sdglgroundconnection.web;

import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import com.dyhc.sdglgroundconnection.service.DispatchService;
import com.dyhc.sdglgroundconnection.utils.ReponseResult;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;
import java.util.Map;

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

    @RequestMapping("/getresource")
    public ReponseResult getresource(){
        try {
            ReponseResult<Map> data=ReponseResult.ok(dispatchService.getresource(),"");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }



}
