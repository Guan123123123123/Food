package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.CookbookDAO;
import com.wzs.entity.Cookbook;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CookbookService {
    @Resource
    CookbookDAO cookbookDAO;

    public PageData<Cookbook> findByPage(int curPage, int pageSize, String name) {

        if ("".equals(name) || name == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Cookbook> www = cookbookDAO.selectAll();
            System.out.println(www);
            PageInfo<Cookbook> pageInfo = new PageInfo<Cookbook>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Cookbook> pd = new PageData<Cookbook>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Cookbook> www = cookbookDAO.queryByName(name);
            PageInfo<Cookbook> pageInfo = new PageInfo<Cookbook>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }

    //查询全部
    public List<Cookbook> findAll(){
        return cookbookDAO.selectAll();
    }

    //根据id查询单个
    public Cookbook findByid(int cookid){
        return cookbookDAO.selectByPrimaryKey(cookid);
    }

}
