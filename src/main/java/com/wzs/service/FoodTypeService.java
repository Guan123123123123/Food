package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.FoodTypeDAO;
import com.wzs.entity.FoodType;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodTypeService {
    @Resource
    FoodTypeDAO foodTypeDAO;

    public int add(FoodType foodType) {
        return foodTypeDAO.insert(foodType);
    }

    public int delete(int typeid) {
        return foodTypeDAO.deleteByPrimaryKey(typeid);
    }

    public int update(FoodType foodType) {
        return foodTypeDAO.updateByPrimaryKey(foodType);
    }

    public List<FoodType> findAll() {
        return foodTypeDAO.selectAll();
    }

    public FoodType findOne(int typeid) {
        return foodTypeDAO.selectByPrimaryKey(typeid);
    }

    public PageData<FoodType> findByPage(int curPage, int pageSize, String name) {

        if ("".equals(name) || name == null) {

            PageHelper.startPage(curPage, pageSize);
            List<FoodType> foodtypes = foodTypeDAO.selectAll();
            PageInfo<FoodType> pageInfo = new PageInfo<FoodType>(foodtypes);
            System.out.println("pageInfo = " + pageInfo);

            PageData<FoodType> pd = new PageData<FoodType>();

            pd.setData(foodtypes);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<FoodType> foodtypes = foodTypeDAO.queryByName(name);
            PageInfo<FoodType> pageInfo = new PageInfo<FoodType>(foodtypes);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(foodtypes);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }
}
