package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.CookstyleDAO;
import com.wzs.entity.Cookstyle;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CookstyleService {
    @Resource
    CookstyleDAO cookstyleDAO;

    public int add(Cookstyle cookstyle){
        return cookstyleDAO.insert(cookstyle);
    }
    public int del(Integer styleid){
        return cookstyleDAO.deleteByPrimaryKey(styleid);
    }
    public int upd(Cookstyle cookstyle){
        return cookstyleDAO.updateByPrimaryKey(cookstyle);
    }
    public Cookstyle findOne(Integer styleid){
        return  cookstyleDAO.selectByPrimaryKey(styleid);
    }
    public List<Cookstyle> findAll() {
        return cookstyleDAO.selectAll();
    }
    public PageData<Cookstyle> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Cookstyle> cookstyles = cookstyleDAO.selectAll();
            PageInfo<Cookstyle> pageInfo=new PageInfo<Cookstyle>(cookstyles);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Cookstyle> pd = new PageData<Cookstyle>();

            pd.setData(cookstyles);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            System.out.println(" 进来了!!!!" );
            PageHelper.startPage(curPage,pageSize);
            List<Cookstyle> cookstyles = cookstyleDAO.queryByName(name);

            System.out.println("cookstyles = " + cookstyles);

            PageInfo<Cookstyle> pageInfo=new PageInfo<Cookstyle>(cookstyles);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(cookstyles);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }


    //查询外国菜 的菜系前5个 cookstyle
    public List<Cookstyle> queryBylimit5(){
        return cookstyleDAO.queryBylimit5();
    }

}
