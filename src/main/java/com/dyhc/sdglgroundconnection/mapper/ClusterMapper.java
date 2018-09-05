package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Cluster;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ClusterMapper  extends CommonMapper<Cluster>{
    /**
     * 查看接团信息
     * @param dispatchId
     * @return
     */
    Cluster ClusterById(Integer dispatchId)throws  Exception;

    /**
     * 根据调度Id获取接团信息表数据
     * @param Did
     * @return
     * @throws Exception
     */
    Cluster getClusterByDid(@Param("Did")Integer Did)throws Exception;
}
