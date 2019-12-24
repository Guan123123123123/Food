package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.HomecookDAO;
import com.wzs.entity.Homecook;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomecookService {
    @Resource
    HomecookDAO homecookDAO;

    public int add(Homecook homecook){
        return homecookDAO.insert(homecook);
    }
    public int del(Integer homeid){
        return homecookDAO.deleteByPrimaryKey(homeid);
    }
    public int upd(Homecook homecook){
        return homecookDAO.updateByPrimaryKey(homecook);
    }
    public Homecook findOne(Integer homeid){
        return  homecookDAO.selectByPrimaryKey(homeid);
    }
    public List<Homecook> findAll() {
        return homecookDAO.selectAll();
    }
    public PageData<Homecook> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Homecook> www = homecookDAO.selectAll();
            PageInfo<Homecook> pageInfo=new PageInfo<Homecook>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Homecook> pd = new PageData<Homecook>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Homecook> www = homecookDAO.queryByName(name);
            PageInfo<Homecook> pageInfo=new PageInfo<Homecook>(www);
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



}
