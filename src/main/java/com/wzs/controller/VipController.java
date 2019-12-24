package com.wzs.controller;


import com.wzs.entity.Vip;
import com.wzs.service.VipService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("vip")
public class VipController {
    @Resource
    VipService vipService;

    @RequestMapping("show1")
    public String show(){
        return "back/Vip/VipShow";
    }
    @RequestMapping("add1")
    public String add(){
        return "back/Vip/VipAdd";
    }
    @RequestMapping("vipAdd")
    @ResponseBody
    public int deptAdd(Vip vip){
        System.out.println("vip----------==>"+vip);
        int add=vipService.add(vip);
        return add;
    }
    @RequestMapping("Update")
    public String update1(int vipid, Model model) {
        System.out.println("============111111=======");
        System.out.println("vipid---- = " + vipid);
        Vip vip = vipService.findOne(vipid);
        System.out.println("vip--- = " + vip);
        model.addAttribute("vip", vip);
        return "back/Vip/VipUpdate";
    }

    @RequestMapping("vipUpdate")
    @ResponseBody
    public int procesUpdate(Vip vip) {
        System.out.println("proces = " + vip);
        int upt = vipService.upd(vip);
        return upt;
    }

    @RequestMapping("showVip")
    @ResponseBody
    public PageData show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        String sname = name;
        PageData<Vip> byPage = vipService.findByPage(page, limit, name);
        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }

    @RequestMapping("del")
    @ResponseBody
    public int del(int vipid) {
        int del = vipService.del(vipid);
        return del;
    }
}
