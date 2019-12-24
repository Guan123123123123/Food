package com.wzs.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wzs.dao.UsersDAO;
import com.wzs.entity.Users;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UsersService {
    @Resource
    UsersDAO usersDAO;
    public int add(Users users){
        return usersDAO.insert(users);
    }
    public int del(Integer uid){
        return usersDAO.deleteByPrimaryKey(uid);
    }
    public int upd(Users users){
        return usersDAO.updateByPrimaryKey(users);
    }
    public Users findOne(Integer uid){
        return  usersDAO.selectByPrimaryKey(uid);
    }
    public PageData<Users> findByPage(int curPage, int pageSize, String name){

        if ("".equals(name)||name==null){

            PageHelper.startPage(curPage,pageSize);
            List<Users> www = usersDAO.selectAll();
            PageInfo<Users> pageInfo=new PageInfo<Users>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData<Users> pd = new PageData<Users>();

            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }else {

            PageHelper.startPage(curPage,pageSize);
            List<Users> www = usersDAO.queryByName(name);
            PageInfo<Users> pageInfo=new PageInfo<Users>(www);
            System.out.println("pageInfo = " + pageInfo);

            PageData pd = new PageData();
            pd.setData(www);
            pd.setCurPage(curPage);
            pd.setTotalCount((int) pageInfo.getTotal());
            pd.setTotalPage(pageInfo.getPages());
            pd.setPageSize(pageSize);
            pd.setCount((int) pageInfo.getTotal());

            return pd;
        }
    }
    public Map<String,Object> query(String bname, String bpassword){
        return usersDAO.query(bname,bpassword);
    }
}
