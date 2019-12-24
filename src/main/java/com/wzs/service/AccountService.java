package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.AccountDAO;
import com.wzs.entity.Account;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AccountService {
    @Resource
    AccountDAO  accountDAO;

    public int add(Account account){
        return accountDAO.insert(account);
    }
    public int del(Integer aid){
        return accountDAO.deleteByPrimaryKey(aid);
    }
    public int upd(Account account){
        return accountDAO.updateByPrimaryKey(account);
    }
    public Account findOne(Integer aid){
        return  accountDAO.selectByPrimaryKey(aid);
    }
    public PageData<Account> findByPage(int curPage, int pageSize, String aname){

        if ("".equals(aname)||aname==null){
            PageHelper.startPage(curPage,pageSize);
            List<Account> accounts = accountDAO.selectAll();
            System.out.println(accounts);
            PageInfo<Account> pageInfo=new PageInfo<Account>(accounts);
            System.out.println("pageInfo = " + pageInfo);
            PageData<Account> pd = new PageData<Account>();
            pd.setData(accounts);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());
            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Account> accounts = accountDAO.queryByName(aname);
            PageInfo<Account> pageInfo=new PageInfo<Account>(accounts);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(accounts);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }
    public Map<String,Object> queryById(String aname, String apassword){
        return accountDAO.queryById(aname,apassword);
    }

    //查询登陆的当前用户所有信息
    public Map<String,Object> findUser(String aname, String apassword){
        return accountDAO.findUser(aname,apassword);
    }

    //查询电话号 与 用户名是否是唯一标识
    public List<Account> findUnique(String aname, String aphone){
        return accountDAO.findUnique(aname,aphone);
    }
}
