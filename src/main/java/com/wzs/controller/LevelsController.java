package com.wzs.controller;

import com.wzs.entity.Levels;
import com.wzs.service.LevelsService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("levels")
public class LevelsController {
    @Resource
    LevelsService levelsService;
    //反回查询页面
    @RequestMapping("showLevels")
    public String show(){
        return "back/Levels/LevelsShow";
    }
    //添加
    @RequestMapping("add1")
    public String add(){
        return "back/Levels/LevelsAdd";
    }
    //添加页面
    @RequestMapping("LevelsAdd")
    @ResponseBody
    public int LevelsAdd(Levels levels){
        System.out.println("levels--------------->"+levels);
        int add=levelsService.add(levels);
        return add;
    }
    //修改查询
    @RequestMapping("Update")
    public String update1(int levelsid, Model model){
        System.out.println("============================+--");
        System.out.println("levelsid ="+levelsid);
        Levels one=levelsService.findOne(levelsid);
        System.out.println("one==>" +one);
        model.addAttribute("levels",one);
        return "back/Levels/LevelsUpdate";
    }

    @RequestMapping("levelsUpdate")
    @ResponseBody
    public int levelsUpdate(Levels levels) {
        System.out.println("levels = " + levels);
        int upt = levelsService.upd(levels);
        return upt;
    }
    @RequestMapping("show")
    @ResponseBody
    public PageData show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        PageData<Levels> byPage = levelsService.findByPage(page, limit, name);


        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }


    @RequestMapping("del")
    @ResponseBody
    public int del(int levelsid) {
        int del = levelsService.del(levelsid);
        return del;
    }

}
