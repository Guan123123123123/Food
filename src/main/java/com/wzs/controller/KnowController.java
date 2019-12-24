package com.wzs.controller;

import com.alibaba.fastjson.JSONArray;
import com.wzs.entity.Know;
import com.wzs.service.KnowService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("know")
public class KnowController {
    @Resource
    KnowService knowService;

    @RequestMapping("show")
    public String show() {
        return "back/know/KnowShow";
    }
    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("list",knowService.findA());
        return "back/know/KnowAdd";
    }

    @RequestMapping("update")
    public String update(int knowid, Model model) {

        Know one = knowService.findOne(knowid);
        System.out.println("one = " + one);
        model.addAttribute("list",knowService.findA());
        model.addAttribute("one",one);
        return "back/know/KnowUpdate";
    }

    @RequestMapping("knowAdd")
    @ResponseBody
    public  int  Add(Know know) {
        int add = knowService.add(know);
        return add;
    }


    @RequestMapping("knowUpdate")
    @ResponseBody
    public  int  Update(Know know) {
        System.out.println("know = " + know);
        int upt = knowService.upd(know);
        System.out.println("upt = ====" + upt);
        return upt;
    }

    @RequestMapping("knowShow")
    @ResponseBody
    public String Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        PageData<Know> all = knowService.findByPage(page, limit, name);
        String jsonStr = JSONArray.toJSONStringWithDateFormat(all, "yyyy-MM-dd HH:mm:ss");
        return jsonStr;
    }

    @RequestMapping("knowDelete")
    @ResponseBody
    public int Del(int knowid) {
        int del = knowService.del(knowid);
        return del;
    }

}
