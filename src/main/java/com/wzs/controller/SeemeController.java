package com.wzs.controller;

import com.wzs.entity.Seeme;
import com.wzs.service.SeemeService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("seeme")
public class SeemeController {
    @Resource
    SeemeService seemeService;

    @RequestMapping("show1")
    public String show(){

        return "back/Seeme/SeemeShow";
    }
    @RequestMapping("add1")
    public String add(){
        return "back/Seeme/SeemeAdd";
    }
    @RequestMapping("seemeAdd")
    @ResponseBody
    public int deptAdd(Seeme seeme){
        System.out.println("seeme==>"+seeme);
        int add=seemeService.add(seeme);
        return add;
    }
    @RequestMapping("Update")
    public String update1(int seemeid, Model model) {
        System.out.println("============111111=======");
        System.out.println("speaceid = " + seemeid);
        Seeme seemes = seemeService.findOne(seemeid);
        System.out.println("seeme = " + seemes);
        model.addAttribute("seeme", seemes);
        return "back/Seeme/SeemeUpdate";
    }

    @RequestMapping("seemeUpdate")
    @ResponseBody
    public int procesUpdate(Seeme seeme) {
        System.out.println("seeme = " + seeme);
        int upt = seemeService.upd(seeme);
        return upt;
    }

    @RequestMapping("showSeeme")
    @ResponseBody
    public PageData show(int page, int limit, String  name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        String sname = name;
        PageData<Seeme> byPage = seemeService.findByPage(page, limit, name);
        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }

    @RequestMapping("del")
    @ResponseBody
    public int del(int seemeid) {
        int del = seemeService.del(seemeid);
        return del;
    }
}
