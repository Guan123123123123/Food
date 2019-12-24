package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.FuntionDAO;
import com.wzs.entity.Funtion;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FuntionService {
        @Resource
        FuntionDAO funtionDAO;

    public int add(Funtion funtion){
        return funtionDAO.insert(funtion);
    }
    public int del(Integer funtionid){
        return funtionDAO.deleteByPrimaryKey(funtionid);
    }
    public int upd(Funtion funtion){
        return funtionDAO.updateByPrimaryKey(funtion);
    }
    public List<Funtion> findAll() {
        return funtionDAO.selectAll();
    }
    public Funtion findOne(Integer funtionid){
        return  funtionDAO.selectByPrimaryKey(funtionid);
    }
    public PageData<Funtion> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Funtion> www = funtionDAO.selectAll();
            PageInfo<Funtion> pageInfo=new PageInfo<Funtion>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Funtion> pd = new PageData<Funtion>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Funtion> www = funtionDAO.queryByName(name);
            PageInfo<Funtion> pageInfo=new PageInfo<Funtion>(www);
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
