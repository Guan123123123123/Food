package com.wzs.controller;

import com.wzs.entity.Collections;
import com.wzs.service.CollectionService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("collection")
public class CollectionController {
    @Resource
    CollectionService collectionService;

    @RequestMapping("show")
    public String show() {
        return "back/collection/CollectionShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/collection/CollectionAdd";
    }

    @RequestMapping("collectionAdd")
    @ResponseBody
    public  int  CollectionAdd(Collections collection) {
        int add = collectionService.add(collection);
        return add;
    }

    @RequestMapping("collectionShow")
    @ResponseBody
    public  PageData  show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        PageData<Collections> byPage = collectionService.findByPage(page, limit, name);


        //String jsonStr = JSONArray.toJSONStringWithDateFormat(byPage,"yyyy-MM-dd");
        return byPage;
    }
    @RequestMapping("collectionDelete")
    @ResponseBody
    public int del(int collectionid) {
        int del = collectionService.del(collectionid);
        return del;
    }

}
