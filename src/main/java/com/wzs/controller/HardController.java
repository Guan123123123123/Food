package com.wzs.controller;

import com.wzs.entity.Hard;
import com.wzs.service.HardService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("hard")
public class HardController {
    @Resource
    HardService hardService;

    @RequestMapping("show")
    public String show() {
        return "back/hard/HardShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/hard/HardAdd";
    }

    @RequestMapping("update")
    public String update(int hardid, Model model) {
        Hard one = hardService.findOne(hardid);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/hard/HardUpdate";
    }

    @RequestMapping("hardAdd")
    @ResponseBody
    public  int  Add(Hard hard) {
        int add = hardService.add(hard);
        return add;
    }


    @RequestMapping("hardUpdate")
    @ResponseBody
    public  int  Update(Hard hard) {
        int upt = hardService.upd(hard);
        return upt;
    }

    @RequestMapping("hardShow")
    @ResponseBody
    public PageData Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Hard> all = hardService.findByPage(page, limit, name);
        return all;
    }

    @RequestMapping("hardDelete")
    @ResponseBody
    public int Del(int hardid) {
        int del = hardService.del(hardid);
        return del;
    }

    //查询所有
    @RequestMapping("findAll")
    @ResponseBody
    public List<Hard> findAll(){
        return hardService.findAll();
    }
}
