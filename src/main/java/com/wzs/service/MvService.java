package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.MvDAO;
import com.wzs.entity.Mv;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MvService {

    @Resource
    MvDAO mvDAO;
    //增
    public int add(Mv mv){
        return mvDAO.insert(mv);
    }
    //删除
    public int del(int mvid){
        return  mvDAO.deleteByPrimaryKey(mvid);
    }
    //修改
    public int upd(Mv mv){
        return mvDAO.updateByPrimaryKey(mv);
    }
    //查询一条
    public Mv findOne(int mvid){
        return mvDAO.selectByPrimaryKey(mvid);
    }
    public List<Mv> findAll(){
        return mvDAO.selectAll();
    }
    public PageData<Mv> findByPage(int curPage, int pageSize, String aid) {

        if ("".equals(aid) || aid == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Mv> mv = mvDAO.selectAll();
            PageInfo<Mv> pageInfo = new PageInfo<Mv>(mv);

            PageData<Mv> pd = new PageData<Mv>();

            pd.setData(mv);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Mv> mv = mvDAO.queryByName(aid);
            PageInfo<Mv> pageInfo = new PageInfo<Mv>(mv);
            PageData pd = new PageData();
            pd.setData(mv);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }


    //按照最新发布时间取指定条数查询
    public List<Mv>  findByRow(int mvnum){
        return mvDAO.findByRow(mvnum);
    }

}
