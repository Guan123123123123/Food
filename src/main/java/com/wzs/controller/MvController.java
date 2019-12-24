package com.wzs.controller;

import com.wzs.entity.Mv;
import com.wzs.service.MvService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("mv")
public class MvController {
    @Resource
    MvService mvService;
    //反回查询页面
    @RequestMapping("show")
    public String show(){
        return "back/Mv/MvShow";
    }
    //添加
    @RequestMapping("add1")
    public String add(){
        return "back/Mv/MvAdd";
    }
    //添加页面
    @RequestMapping("mvAdd")
    @ResponseBody
    public int LevelsAdd(Mv mv){
        System.out.println("levels--------------->"+mv);
        int add=mvService.add(mv);
        return add;
    }
    //修改查询
    @RequestMapping("Update")
    public String update1(int mvid, Model model){
        System.out.println("============================+--");
        System.out.println("mvid="+mvid);
        Mv mv=mvService.findOne(mvid);
        System.out.println("one==>" +mv);
        model.addAttribute("mv",mv);
        return "back/Mv/MvUpdate";
    }

    @RequestMapping("mvUpdate")
    @ResponseBody
    public int levelsUpdate(Mv food) {
        System.out.println("levels = " + food);
        int upt = mvService.upd(food);
        return upt;
    }
    @RequestMapping("showmv")
    @ResponseBody
    public PageData show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        PageData<Mv> byPage = mvService.findByPage(page, limit, name);


        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }


    @RequestMapping("del")
    @ResponseBody
    public int del(int mvid) {
        int del = mvService.del(mvid);
        return del;
    }

}
