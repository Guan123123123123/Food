package com.wzs.controller;

import com.wzs.entity.Users;
import com.wzs.service.UsersService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("users")
public class UsersController {

    @Resource
    UsersService usersService;

    @RequestMapping("show")
    public String show() {
        return "back/users/UsersShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/users/UsersAdd";
    }

    @RequestMapping("info")
    public String info(HttpSession session, Model model) {
        Map<String, Object> user  = (Map<String, Object>) session.getAttribute("users");
        Integer uid1 = (Integer)user.get("uid");

        Users one = usersService.findOne(uid1);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/users/UsersUpdate";
    }


    @RequestMapping("update")
    public String update(int uid, Model model) {
        Users one = usersService.findOne(uid);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/users/UsersUpdate";
    }

    @RequestMapping("usersAdd")
    @ResponseBody
    public  int  Add(Users users) {
        int add = usersService.add(users);
        return add;
    }


    @RequestMapping("usersUpdate")
    @ResponseBody
    public  int  Update(Users users) {
        int upt = usersService.upd(users);
        return upt;
    }

    @RequestMapping("usersShow")
    @ResponseBody
    public PageData Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Users> all = usersService.findByPage(page, limit, name);
        return all;
    }

    @RequestMapping("usersDelete")
    @ResponseBody
    public int Del(int uid) {
        int del = usersService.del(uid);
        return del;
    }
}
