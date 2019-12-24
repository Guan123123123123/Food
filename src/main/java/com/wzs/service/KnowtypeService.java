package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.KnowtypeDAO;
import com.wzs.entity.Knowtype;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class KnowtypeService {
    @Resource
    KnowtypeDAO knowtypeDAO;

    public int add(Knowtype knowtype){
        return knowtypeDAO.insert(knowtype);
    }
    public int del(Integer knowtypeid){
        return knowtypeDAO.deleteByPrimaryKey(knowtypeid);
    }
    public int upd(Knowtype knowtype){
        return knowtypeDAO.updateByPrimaryKey(knowtype);
    }
    public Knowtype findOne(Integer hardid){
        return  knowtypeDAO.selectByPrimaryKey(hardid);
    }
    public PageData<Knowtype> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Knowtype> www = knowtypeDAO.selectAll();
            PageInfo<Knowtype> pageInfo=new PageInfo<Knowtype>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Knowtype> pd = new PageData<Knowtype>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Knowtype> www = knowtypeDAO.queryByName(name);
            PageInfo<Knowtype> pageInfo=new PageInfo<Knowtype>(www);
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
