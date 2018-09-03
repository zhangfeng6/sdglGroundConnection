package com.dyhc.sdglgroundconnection.service.impl;

import com.dyhc.sdglgroundconnection.mapper.MealTypeMapper;
import com.dyhc.sdglgroundconnection.pojo.Dictionaries;
import com.dyhc.sdglgroundconnection.pojo.MealType;
import com.dyhc.sdglgroundconnection.service.MealTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 饮食类型业务实现
 **/
@Service
public class MealTypeServiceImpl implements MealTypeService {

    @Autowired
    private MealTypeMapper mealTypeMapper;

    @Override
    public List<MealType> selectMealTypeByRestaurantId(int restaurantId) throws Exception{
        return mealTypeMapper.selectMealTypeByRestaurantId(restaurantId);
    }

    @Override
    public int updateMealType(MealType mealType)throws Exception {
        return mealTypeMapper.updateMealType(mealType);
    }

    @Override
    public int delMealTypeById(MealType mealType)throws Exception {
        return mealTypeMapper.delMealTypeById(mealType);
    }

    @Override
    public int insertMealType(MealType mealType)throws Exception {
        return mealTypeMapper.insertMealType(mealType);
    }

    @Override
    public List<Dictionaries> selectDic()throws Exception {
        return mealTypeMapper.selectDic();
    }

    @Override
    public MealType selectById(int typeId)throws Exception {
        return mealTypeMapper.selectById(typeId);
    }

    @Override
    public List<Dictionaries> selectMealType()throws Exception {
        return mealTypeMapper.selectMealType();
    }


}
