package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.MaterialDAO;
import com.wzs.entity.Material;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MaterialService {
    @Resource
    MaterialDAO materialDAO;

    public int add(Material meterial){
        return materialDAO.insert(meterial);
    }
    public int del(Integer meterialid){
        return materialDAO.deleteByPrimaryKey(meterialid);
    }
    public int upd(Material meterial){
        return materialDAO.updateByPrimaryKey(meterial);
    }
    public Material findOne(Integer meterialid){
        return  materialDAO.selectByPrimaryKey(meterialid);
    }
    public PageData<Material> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Material> meterials = materialDAO.selectAll();
            PageInfo<Material> pageInfo=new PageInfo<Material>(meterials);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Material> pd = new PageData<Material>();

            pd.setData(meterials);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Material> meterials = materialDAO.queryByName(name);
            PageInfo<Material> pageInfo=new PageInfo<Material>(meterials);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(meterials);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }

    //按照菜谱id查询所有配料
    public List<Material> findBycookid(int cookid){
        return materialDAO.findBycookid(cookid);
    }
}
