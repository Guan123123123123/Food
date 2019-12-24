package com.wzs.controller;

import com.wzs.entity.Speacecook;
import com.wzs.service.SpeacecookService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("speacecook")
public class SpeacecookController {
    @Resource
    SpeacecookService speacecookService;
    @RequestMapping("show1")
    public String show(){
        return "back/Speace/SpeacecookShow";
    }
    @RequestMapping("add1")
    public String add(){
        return "back/Speace/SpeacecookAdd";
    }
    @RequestMapping("speacecookAdd")
    @ResponseBody
    public int deptAdd(Speacecook speacecook){
        System.out.println("speacecook==>"+speacecook);
        int add=speacecookService.add(speacecook);
        return add;
    }
    @RequestMapping("Update")
    public String update1(int speaceid, Model model) {
        System.out.println("============111111=======");
        System.out.println("speaceid = " + speaceid);
        Speacecook speacecook = speacecookService.findOne(speaceid);
        System.out.println("speacecook = " + speacecook);
        model.addAttribute("speacecook", speacecook);
        return "back/Speace/speacecookUpdate";
    }

    @RequestMapping("speacecookUpdate")
    @ResponseBody
    public int speacecookUpdate(Speacecook speacecook) {
        System.out.println("speacecook = " + speacecook);
        int upt = speacecookService.upd(speacecook);
        return upt;
    }

    @RequestMapping("showSpeacecook")
    @ResponseBody
    public PageData show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        String sname = name;
        PageData<Speacecook> byPage = speacecookService.findByPage(page, limit, name);
        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }

    @RequestMapping("del")
    @ResponseBody
    public int del(int speaceid) {
        int del = speacecookService.del(speaceid);
        return del;
    }


    //查询所有
    @RequestMapping("findAll")
    @ResponseBody
    public List<Speacecook> findAll(){
        return speacecookService.findAll();
    }
}
