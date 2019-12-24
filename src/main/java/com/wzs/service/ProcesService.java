package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.ProcesDAO;
import com.wzs.entity.Proces;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProcesService {
    @Resource
    ProcesDAO procesDAO;

    public int add(Proces proces) {
        return procesDAO.insert(proces);
    }

    public int del(int procesid) {
        return procesDAO.deleteByPrimaryKey(procesid);
    }

    public int upd(Proces proces) {
        return procesDAO.updateByPrimaryKey(proces);
    }

    public Proces findOne(int procesid) {
        return procesDAO.selectByPrimaryKey(procesid);
    }

    public List<Proces> findAll() {
        return procesDAO.selectAll();
    }

    public PageData<Proces> findByPage(int curPage, int pageSize, String procesname) {

        if ("".equals(procesname) || procesname == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Proces> depts = procesDAO.selectAll();
            PageInfo<Proces> pageInfo = new PageInfo<Proces>(depts);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Proces> pd = new PageData<Proces>();

            pd.setData(depts);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Proces> process = procesDAO.queryByName(procesname);
            PageInfo<Proces> pageInfo = new PageInfo<Proces>(process);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(process);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }

}
