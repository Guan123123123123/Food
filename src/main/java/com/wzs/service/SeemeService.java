package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.SeemeDAO;
import com.wzs.entity.Seeme;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SeemeService {
    @Resource
    SeemeDAO seemeDAO;

    public int add(Seeme seeme) {
        return seemeDAO.insert(seeme);
    }

    public int del(int seemeid) {
        return seemeDAO.deleteByPrimaryKey(seemeid);
    }

    public int upd(Seeme seeme) {
        return seemeDAO.updateByPrimaryKey(seeme);
    }

    public Seeme findOne(int seemeid) {
        return seemeDAO.selectByPrimaryKey(seemeid);
    }

    public List<Seeme> findAll() {
        return seemeDAO.selectAll();
    }

    public PageData<Seeme> findByPage(int curPage, int pageSize, String  aid) {

        if ("".equals(aid) || aid == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Seeme> seemes = seemeDAO.selectAll();
            PageInfo<Seeme> pageInfo = new PageInfo<Seeme>(seemes);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Seeme> pd = new PageData<Seeme>();

            pd.setData(seemes);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Seeme> seemes = seemeDAO.queryByName(aid);
            PageInfo<Seeme> pageInfo = new PageInfo<Seeme>(seemes);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(seemes);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }
}
