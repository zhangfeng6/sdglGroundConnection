package com.dyhc.sdglgroundconnection.service;
import com.dyhc.sdglgroundconnection.pojo.Tourismandline;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.List;
import java.util.Map;

public interface TourismandlineService {
    /**
     * 赵伟伟
     * 查询模板中的线路
     * @param tourismId
     * @return
     */
    List<Tourismandline> selectTourismandlineAll(int tourismId)throws Exception;

}
