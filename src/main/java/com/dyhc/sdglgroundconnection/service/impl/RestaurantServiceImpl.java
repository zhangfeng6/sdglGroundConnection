package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.DictionariesMapper;
import com.dyhc.sdglgroundconnection.mapper.HotelMapper;
import com.dyhc.sdglgroundconnection.mapper.MealTypeMapper;
import com.dyhc.sdglgroundconnection.mapper.RestaurantMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.MealType;
import com.dyhc.sdglgroundconnection.pojo.Restaurant;
import com.dyhc.sdglgroundconnection.service.RestaurantService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 餐馆业务实现
 **/
@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Autowired
    private DictionariesMapper dictionariesMapper;

    @Autowired
    private MealTypeMapper mealTypeMapper;


    @Override
    public PageInfo<Restaurant> listRestaurants(Integer pageNo, Integer PageSize,String restaurantName, String restaurantAddress,Integer whetherDel) throws Exception {
        PageHelper.startPage(pageNo, PageSize, true);
        List<Restaurant> list = restaurantMapper.selectByEx(restaurantName,restaurantAddress,whetherDel);
        for (Restaurant r:list) {
            r.setMealType(mealTypeMapper.selectMealTypeByRestaurantId(r.getRestaurantId()));
        }
        PageInfo<Restaurant> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int delRestaurantById(int restaurantId) throws Exception {
        return restaurantMapper.delRestaurantById(restaurantId);
    }

    @Override
    public int insertRestaurant(Restaurant restaurant)throws Exception {
        return restaurantMapper.insert(restaurant);
    }

    @Override
    public Restaurant selectRestaurantById(int restaurantId)throws Exception {
        return restaurantMapper.selectByPrimaryKey(restaurantId);
    }

    @Override
    public int updateRestaurantById(Restaurant restaurant)throws Exception {
        return restaurantMapper.updateRestaurantById(restaurant);
    }

    @Override
    public int updateRestaurantById1(Restaurant restaurant)throws Exception {
        return restaurantMapper.updateRestaurantById1(restaurant);
    }

    @Override
    public int selectTypeById(Integer valueId, Integer restaurantId)throws Exception {
        return restaurantMapper.selectTypeById(valueId,restaurantId);
    }

    @Override
    public MealType selectMealTypeByTypeId(Integer typeId)throws Exception {
        return restaurantMapper.selectMealTypeByTypeId(typeId);
    }


}
