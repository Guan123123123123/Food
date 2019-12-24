package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.VipDAO;
import com.wzs.entity.Vip;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VipService {
    @Resource
    VipDAO vipDAO;


    public int add(Vip vip) {
        return vipDAO.insert(vip);
    }

    public int del(int vipid) {
        return vipDAO.deleteByPrimaryKey(vipid);
    }

    public int upd(Vip vip) {
        return vipDAO.updateByPrimaryKey(vip);
    }

    public Vip findOne(int vipid) {
        return vipDAO.selectByPrimaryKey(vipid);
    }

    public List<Vip> findAll() {
        return vipDAO.selectAll();
    }

    public PageData<Vip> findByPage(int curPage, int pageSize, String vipname) {

        if ("".equals(vipname) || vipname == null) {

            PageHelper.startPage(curPage, pageSize);
            List<Vip> vip = vipDAO.selectAll();
            PageInfo<Vip> pageInfo = new PageInfo<Vip>(vip);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Vip> pd = new PageData<Vip>();

            pd.setData(vip);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        } else {

            PageHelper.startPage(curPage, pageSize);
            List<Vip> vip = vipDAO.queryByName(vipname);
            PageInfo<Vip> pageInfo = new PageInfo<Vip>(vip);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(vip);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }
}
