package com.wzs.controller;

import com.alibaba.fastjson.JSONArray;
import com.wzs.entity.Review;
import com.wzs.service.ReviewService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("review")
public class ReviewController {
    @Resource
    ReviewService reviewService;

    @RequestMapping("show")
    public String show() {
        return "back/Review/ReviewShow";
    }
    @RequestMapping("add")
    public String add() {
        return "back/Review/ReviewAdd";
    }

    @RequestMapping("update")
    public String update(int rid, Model model) {
        Review one = reviewService.findOne(rid);
        System.out.println("one = " + one);
        model.addAttribute("one",one);
        return "back/Review/ReviewUpdate";
    }

    @RequestMapping("reviewAdd")
    @ResponseBody
    public  int  Add(Review review) {
        int add = reviewService.add(review);
        return add;
    }


    @RequestMapping("reviewUpdate")
    @ResponseBody
    public  int  Update(Review review) {
        int upt = reviewService.upd(review);
        return upt;
    }

    @RequestMapping("reviewShow")
    @ResponseBody
    public String Show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);

        PageData<Review> all = reviewService.findByPage(page, limit, name);
        String jsonStr = JSONArray.toJSONStringWithDateFormat(all,"yyyy-MM-dd");

        return jsonStr;
    }

    @RequestMapping("reviewDelete")
    @ResponseBody
    public int Del(int rid) {
        int del = reviewService.del(rid);
        return del;
    }
}
