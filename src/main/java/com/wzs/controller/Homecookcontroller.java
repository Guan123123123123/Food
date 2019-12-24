package com.wzs.controller;

import com.wzs.entity.Homecook;
import com.wzs.service.HomecookService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("homecook")
public class Homecookcontroller {
    @Resource
    HomecookService homecookService;

    @RequestMapping("show")
    public String show() {
        return "back/homecook/homecookShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/homecook/homecookAdd";
    }

    @RequestMapping("update")
    public String update(int homeid, Model model) {
        Homecook one = homecookService.findOne(homeid);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/homecook/homecookUpdate";
    }

    @RequestMapping("homecookAdd")
    @ResponseBody
    public  int  Add(Homecook homecook) {
        int add = homecookService.add(homecook);
        return add;
    }


    @RequestMapping("homecookUpdate")
    @ResponseBody
    public  int  Update(Homecook homecook) {
        int upt = homecookService.upd(homecook);
        return upt;
    }

    @RequestMapping("homecookShow")
    @ResponseBody
    public PageData Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Homecook> all = homecookService.findByPage(page, limit, name);
        return all;
    }

    @RequestMapping("homecookDelete")
    @ResponseBody
    public int Del(int homeid) {
        int del = homecookService.del(homeid);
        return del;
    }


    //查全部
    @RequestMapping("findAll")
    @ResponseBody
    public List<Homecook> findAll() {
        return homecookService.findAll();
    }
}
