package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.TasteDAO;
import com.wzs.entity.Taste;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TeasteService {
    @Resource
    TasteDAO tasteDAO;
    public int add(Taste taste) {
        return tasteDAO.insert(taste);
    }

    public int del(int tstateid) {
        return tasteDAO.deleteByPrimaryKey(tstateid);
    }

    public int upd(Taste taste) {
        return tasteDAO.updateByPrimaryKey(taste);
    }

    public Taste findOne(int tasteid) {
        return tasteDAO.selectByPrimaryKey(tasteid);
    }

    public List<Taste> findAll() {
        return tasteDAO.selectAll();
    }

    public PageData<Taste> findByPage(int curPage, int pageSize, String tastename) {

        if ("".equals(tastename) || tastename == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Taste> tastes = tasteDAO.selectAll();
            PageInfo<Taste> pageInfo = new PageInfo<Taste>(tastes);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Taste> pd = new PageData<Taste>();

            pd.setData(tastes);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Taste> process = tasteDAO.queryByName(tastename);
            PageInfo<Taste> pageInfo = new PageInfo<Taste>(process);
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
