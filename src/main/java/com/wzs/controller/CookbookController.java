package com.wzs.controller;

import com.alibaba.fastjson.JSONArray;
import com.wzs.entity.Cookbook;
import com.wzs.service.CookbookService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("cookbook")
public class CookbookController {
    @Resource
    CookbookService cookbookService;
    @RequestMapping("show")
    public String show() {
        return "back/cookbook/CookbookShow";
    }

    @RequestMapping("CookbookShow")
    @ResponseBody
    public String show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        PageData<Cookbook> all = cookbookService.findByPage(page, limit, name);
        String jsonStr = JSONArray.toJSONStringWithDateFormat(all,"yyyy-MM-dd");
        return jsonStr;
    }
}
