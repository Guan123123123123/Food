package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.KnowDAO;
import com.wzs.entity.Know;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class KnowService {
    @Resource
    KnowDAO knowDAO;

    public int add(Know know){
        return knowDAO.insert(know);
    }
    public int del(Integer knowid){
        return knowDAO.deleteByPrimaryKey(knowid);
    }
    public int upd(Know know){
        return knowDAO.updateByPrimaryKey(know);
    }
    public Know findOne(Integer knowid){
        return  knowDAO.selectByPrimaryKey(knowid);
    }
    public PageData<Know> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Know> www = knowDAO.selectAll();
            System.out.println("================= " + www);
            PageInfo<Know> pageInfo=new PageInfo<Know>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Know> pd = new PageData<Know>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Know> www  = knowDAO.queryByName(name);
            System.out.println("www = " + www);
            PageInfo<Know> pageInfo=new PageInfo<Know>(www);

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
    public List<Map<String,Object>> findA(){
        return knowDAO.findA();
    };


}
