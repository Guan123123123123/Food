package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.FoodDAO;
import com.wzs.entity.Food;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FoodService {
    @Resource
    FoodDAO foodDAO;
    //增
    public int add(Food food){
        return foodDAO.insert(food);
    }
    //删除
    public int del(int foodid){
        return  foodDAO.deleteByPrimaryKey(foodid);
    }
    //修改
    public int upd(Food food){
        return foodDAO.updateByPrimaryKey(food);
    }
    public Food findOne(int foodid){
        return foodDAO.selectByPrimaryKey(foodid);
    }
    public List<Food> findAll(){
        return foodDAO.selectAll();
    }
    public PageData<Food> findByPage(int curPage, int pageSize, String foodname) {

        if ("".equals(foodname) || foodname == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Food> food = foodDAO.selectAll();
            PageInfo<Food> pageInfo = new PageInfo<Food>(food);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Food> pd = new PageData<Food>();

            pd.setData(food);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Food> food = foodDAO.queryByName(foodname);
            PageInfo<Food> pageInfo = new PageInfo<Food>(food);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(food);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }

}
