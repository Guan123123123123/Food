package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.SpeacecookDAO;
import com.wzs.entity.Speacecook;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SpeacecookService {
    @Resource
    SpeacecookDAO speacecookDAO;
    public int add(Speacecook speacecook){
        return  speacecookDAO.insert(speacecook);
    }
    public int del(int speaceid){
        return  speacecookDAO.deleteByPrimaryKey(speaceid);
    }
    public int upd(Speacecook speacecook){
        return speacecookDAO.updateByPrimaryKey(speacecook);
    }
    public  Speacecook findOne(int speaceid){
        return speacecookDAO.selectByPrimaryKey(speaceid);
    }
    public List<Speacecook> findAll(){
        return speacecookDAO.selectAll();
    }

    public PageData<Speacecook> findByPage(int curPage, int pageSize, String speacename) {

        if ("".equals(speacename) || speacename == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Speacecook> speacecooks = speacecookDAO.selectAll();
            PageInfo<Speacecook> pageInfo = new PageInfo<Speacecook>(speacecooks);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Speacecook> pd = new PageData<Speacecook>();

            pd.setData(speacecooks);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Speacecook> depts = speacecookDAO.queryByName(speacename);
            PageInfo<Speacecook> pageInfo = new PageInfo<Speacecook>(depts);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(depts);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }
}
