package com.wzs.controller;

import com.wzs.entity.Cookstyle;
import com.wzs.service.CookstyleService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("cookstyle")
public class CookstyleController {
    @Resource
    CookstyleService cookstyleService;

    @RequestMapping("show")
    public String show() {
        return "back/cookstyle/CookstyleShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/cookstyle/CookstyleAdd";
    }

    @RequestMapping("update")
    public String update(int styleid, Model model) {
        Cookstyle one = cookstyleService.findOne(styleid);
        System.out.println("one = " + one);
        model.addAttribute("cookstyle",one);
        return "back/cookstyle/CookstyleUpdate";
    }

    @RequestMapping("cookstyleAdd")
    @ResponseBody
    public  int  Add(Cookstyle cookstyle) {
        int add = cookstyleService.add(cookstyle);
        return add;
    }


    @RequestMapping("cookstyleUpdate")
    @ResponseBody
    public  int  Update(Cookstyle cookstyle) {
        int upt = cookstyleService.upd(cookstyle);
        return upt;
    }

    @RequestMapping("cookstyleShow")
    @ResponseBody
    public PageData Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Cookstyle> all = cookstyleService.findByPage(page, limit, name);
        return all;
    }

    @RequestMapping("cookstyleDelete")
    @ResponseBody
    public int Del(int styleid) {
        int del = cookstyleService.del(styleid);
        return del;
    }

    //查询外国菜 的菜系前5个 cookstyle
    @RequestMapping("queryBylimit5")
    @ResponseBody
    public List<Cookstyle> queryBylimit5(){
        return cookstyleService.queryBylimit5();
    }

    //查询全部
    @RequestMapping("findAll")
    @ResponseBody
    public List<Cookstyle> findAll(){
        return cookstyleService.findAll();
    }
}
