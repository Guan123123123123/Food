package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.CollectionDAO;
import com.wzs.entity.Collections;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectionService {
    @Resource
    CollectionDAO collectionDAO;

    public int add(Collections collection){
        return collectionDAO.insert(collection);
    }
    public int del(Integer collectionid){
        return collectionDAO.deleteByPrimaryKey(collectionid);
    }
    public Collections findOne(Integer collectionid){
        return  collectionDAO.selectByPrimaryKey(collectionid);
    }

    public PageData<Collections> findByPage(int curPage, int pageSize, String name){

            PageHelper.startPage(curPage,pageSize);
            List<Collections> collections = collectionDAO.selectAll();
            System.out.println(collections);
            PageInfo<Collections> pageInfo=new PageInfo<Collections>(collections);

            PageData<Collections> pd = new PageData<Collections>();

            pd.setData(collections);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());
            return pd;

        }


}
