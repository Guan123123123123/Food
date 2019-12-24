package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.HardDAO;
import com.wzs.entity.Hard;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HardService {
    @Resource
    HardDAO hardDAO;

    public int add(Hard hard){
        return hardDAO.insert(hard);
    }
    public int del(Integer hardid){
        return hardDAO.deleteByPrimaryKey(hardid);
    }
    public int upd(Hard hard){
        return hardDAO.updateByPrimaryKey(hard);
    }
    public Hard findOne(Integer hardid){
        return  hardDAO.selectByPrimaryKey(hardid);
    }
    public List<Hard> findAll() {
        return hardDAO.selectAll();
    }

    public PageData<Hard> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Hard> www = hardDAO.selectAll();
            PageInfo<Hard> pageInfo=new PageInfo<Hard>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Hard> pd = new PageData<Hard>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Hard> www = hardDAO.queryByName(name);
            PageInfo<Hard> pageInfo=new PageInfo<Hard>(www);
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
