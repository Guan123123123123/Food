package com.wzs.controller;

import com.wzs.entity.Funtion;
import com.wzs.service.FuntionService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("funtion")
public class FuntionController {
    @Resource
    FuntionService funtionService;

    @RequestMapping("show")
    public String show() {
        return "back/funtion/FuntionShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/funtion/FuntionAdd";
    }

    @RequestMapping("update")
    public String update(int funtionid, Model model) {
        Funtion one = funtionService.findOne(funtionid);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/funtion/FuntionUpdate";
    }

    @RequestMapping("funtionAdd")
    @ResponseBody
    public  int  Add(Funtion material) {
        int add = funtionService.add(material);
        return add;
    }


    @RequestMapping("funtionUpdate")
    @ResponseBody
    public  int  Update(Funtion material) {
        int upt = funtionService.upd(material);
        return upt;
    }

    @RequestMapping("funtionShow")
    @ResponseBody
    public PageData Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Funtion> all = funtionService.findByPage(page, limit, name);
        return all;
    }

    @RequestMapping("funtionDelete")
    @ResponseBody
    public int Del(int funtionid) {
        int del = funtionService.del(funtionid);
        return del;
    }
}
