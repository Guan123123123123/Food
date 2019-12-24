package com.wzs.controller;

import com.wzs.entity.Material;
import com.wzs.service.MaterialService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("material")
public class MaterialController {
    @Resource
    MaterialService materialService;

    @RequestMapping("show")
    public String show() {
        return "back/material/MaterialShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/material/MaterialAdd";
    }

    @RequestMapping("update")
    public String update(int materialid, Model model) {
        Material one = materialService.findOne(materialid);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/material/MaterialUpdate";
    }

    @RequestMapping("materialAdd")
    @ResponseBody
    public  int  Add(Material material) {
        int add = materialService.add(material);
        return add;
    }


    @RequestMapping("materialUpdate")
    @ResponseBody
    public  int  Update(Material material) {
        int upt = materialService.upd(material);
        return upt;
    }

    @RequestMapping("materialShow")
    @ResponseBody
    public PageData Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Material> all = materialService.findByPage(page, limit, name);
        return all;
    }

    @RequestMapping("materialDelete")
    @ResponseBody
    public int Del(int materialid) {
        int del = materialService.del(materialid);
        return del;
    }


}
