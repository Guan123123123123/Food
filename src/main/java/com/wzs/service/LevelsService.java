package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.LevelsDAO;
import com.wzs.entity.Levels;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LevelsService {
    @Resource
    LevelsDAO levelsDAO;
    //增
    public int add(Levels levels){
        return levelsDAO.insert(levels);
    }
    //删除
    public int del(int levelsid){
        return  levelsDAO.deleteByPrimaryKey(levelsid);
    }
    //修改
    public int upd(Levels levels){
        return levelsDAO.updateByPrimaryKey(levels);
    }
    public Levels findOne(int levelsid){
        return levelsDAO.selectByPrimaryKey(levelsid);
    }
    public List<Levels> findAll(){
        return levelsDAO.selectAll();
    }
    public PageData<Levels> findByPage(int curPage, int pageSize, String levelsname) {

        if ("".equals(levelsname) || levelsname == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Levels> levels = levelsDAO.selectAll();
            PageInfo<Levels> pageInfo = new PageInfo<Levels>(levels);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Levels> pd = new PageData<Levels>();

            pd.setData(levels);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Levels> levelss = levelsDAO.queryByName(levelsname);
            PageInfo<Levels> pageInfo = new PageInfo<Levels>(levelss);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(levelss);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }

}
