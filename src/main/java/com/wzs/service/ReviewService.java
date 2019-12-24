package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.ReviewDAO;
import com.wzs.entity.Review;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReviewService {
    @Resource
    ReviewDAO reviewDAO;
    public int add(Review review){
        return reviewDAO.insert(review);
    }
    public int del(Integer rid){
        return reviewDAO.deleteByPrimaryKey(rid);
    }
    public int upd(Review review){
        return reviewDAO.updateByPrimaryKey(review);
    }
    public Review findOne(Integer rid){
        return  reviewDAO.selectByPrimaryKey(rid);
    }
    public PageData<Review> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Review> www = reviewDAO.selectAll();
            PageInfo<Review> pageInfo=new PageInfo<Review>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Review> pd = new PageData<Review>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Review> www = reviewDAO.queryByName(name);
            PageInfo<Review> pageInfo=new PageInfo<Review>(www);
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
