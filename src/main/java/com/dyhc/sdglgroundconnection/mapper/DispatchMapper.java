package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Dispatch;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度
 **/
@Mapper
@Component
public interface DispatchMapper extends CommonMapper<Dispatch>{

    /**
     * 根据条件获取调度信息
     * @param djsth        地接社团号
     * @param dyname       导游名称
     * @param state         状态
     * @return
     */
    List<Dispatch> listdispatch(@Param("djsth")String djsth,@Param("dyname")String dyname,@Param("state")Integer state);
}
