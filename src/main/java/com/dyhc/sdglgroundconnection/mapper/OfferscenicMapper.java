package com.dyhc.sdglgroundconnection.mapper;

import com.dyhc.sdglgroundconnection.pojo.Offerscenic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 报价景点
 **/
@Mapper
@Component
public interface OfferscenicMapper extends CommonMapper<Offerscenic>{

    /**
     * 赵伟伟
     * 新增景点报价
     * @param offerscenic
     * @return
     */
    int insertOfferscenic(Offerscenic offerscenic)throws  Exception;

    /**
     * 赵伟伟
     * 按报价编号查询
     * @return
     */
    List<Offerscenic> selectOfferscenicByOfferId(@Param("offerId") int offerId)throws  Exception;
}
