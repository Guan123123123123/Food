package com.wzs.controller;

import com.wzs.entity.Knowtype;
import com.wzs.service.KnowtypeService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("knowtype")
public class KnowtypeController {
    @Resource
    KnowtypeService knowtypeService;

    @RequestMapping("show")
    public String show() {
        return "back/knowtype/KnowtypeShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/knowtype/KnowtypeAdd";
    }

    @RequestMapping("update")
    public String update(int knowtypeid, Model model) {
        Knowtype one = knowtypeService.findOne(knowtypeid);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/knowtype/KnowtypeUpdate";
    }

    @RequestMapping("knowtypeAdd")
    @ResponseBody
    public  int  Add(Knowtype knowtype) {
        int add = knowtypeService.add(knowtype);
        return add;
    }


    @RequestMapping("knowtypeUpdate")
    @ResponseBody
    public  int  Update(Knowtype knowtype) {
        int upt = knowtypeService.upd(knowtype);
        return upt;
    }

    @RequestMapping("knowtypeShow")
    @ResponseBody
    public PageData Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Knowtype> all = knowtypeService.findByPage(page, limit, name);
        return all;
    }

    @RequestMapping("knowtypeDelete")
    @ResponseBody
    public int Del(int knowtypeid) {
        int del = knowtypeService.del(knowtypeid);
        return del;
    }
}
