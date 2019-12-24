package com.wzs.controller;

import com.wzs.entity.Proces;
import com.wzs.service.ProcesService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("proces")
public class ProcesController {
    @Resource
    ProcesService procesService;

    @RequestMapping("show1")
    public String show(){
        return "back/Proces/ProcesShow";
    }
    @RequestMapping("add1")
    public String add(){
        return "back/Proces/ProcesAdd";
    }
    @RequestMapping("procesAdd")
    @ResponseBody
    public int deptAdd(Proces proces){
        System.out.println("speacecook==>"+proces);
        int add=procesService.add(proces);
        return add;
    }
    @RequestMapping("Update")
    public String update1(int procesid, Model model) {
        System.out.println("============111111=======");
        System.out.println("speaceid = " + procesid);
        Proces proces = procesService.findOne(procesid);
        System.out.println("proces = " + proces);
        model.addAttribute("proces", proces);
        return "back/Proces/procesUpdate";
    }

    @RequestMapping("procesUpdate")
    @ResponseBody
    public int procesUpdate(Proces proces) {
        System.out.println("proces = " + proces);
        int upt = procesService.upd(proces);
        return upt;
    }

    @RequestMapping("showProces")
    @ResponseBody
    public PageData show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        String sname = name;
        PageData<Proces> byPage = procesService.findByPage(page, limit, name);
        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }

    @RequestMapping("del")
    @ResponseBody
    public int del(int procesid) {
        int del = procesService.del(procesid);
        return del;
    }

    //查所有
    @RequestMapping("findAll")
    @ResponseBody
    public List<Proces> findAll() {
        return procesService.findAll();
    }
}
