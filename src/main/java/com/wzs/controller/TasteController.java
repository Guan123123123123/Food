package com.wzs.controller;

import com.wzs.entity.Taste;
import com.wzs.service.TeasteService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("taste")
public class TasteController {
    @Resource
    TeasteService teasteService;
    @RequestMapping("show1")
    public String show(){
        return "back/Taste/TasteShow";
    }
    @RequestMapping("add1")
    public String add(){
        return "back/Taste/TasteAdd";
    }
    @RequestMapping("tasteAdd")
    @ResponseBody
    public int deptAdd(Taste taste){
        System.out.println("speacecook==>"+taste);
        int add=teasteService.add(taste);
        return add;
    }
    @RequestMapping("Update")
    public String update1(int tasteid, Model model) {
        System.out.println("============111111=======");
        System.out.println("tasteid = " + tasteid);
        Taste taste = teasteService.findOne(tasteid);
        System.out.println("taste = " + taste);
        model.addAttribute("taste", taste);
        return "back/Taste/TasteUpdate";
    }

    @RequestMapping("tasteUpdate")
    @ResponseBody
    public int procesUpdate(Taste taste) {
        System.out.println("taste = " + taste);
        int upt = teasteService.upd(taste);
        return upt;
    }

    @RequestMapping("showTaste")
    @ResponseBody
    public PageData show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        String sname = name;
        PageData<Taste> byPage = teasteService.findByPage(page, limit, name);
        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }

    @RequestMapping("del")
    @ResponseBody
    public int del(int tasteid) {
        int del = teasteService.del(tasteid);
        return del;
    }

    //查询全部
    @RequestMapping("findAll")
    @ResponseBody
    public List<Taste> findAll() {
        return teasteService.findAll();
    }
}
