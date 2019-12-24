package com.wzs.controller;

import com.wzs.entity.FoodType;
import com.wzs.service.FoodTypeService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("foodtype")
public class FoodTypeController {
    @Resource
    FoodTypeService foodTypeService;

    @RequestMapping("ftshow")
    public String show() {
        return "back/foodtype/FoodTypeShow";
    }

    @RequestMapping("ftadd")
    public String add() {
        return "back/foodtype/FoodTypeAdd";
    }

    @RequestMapping("ftupdate")
    public String update(int typeid, Model model) {
        FoodType one = foodTypeService.findOne(typeid);
        model.addAttribute("one", one);
        return "back/foodtype/FoodTypeUpdate";
    }

    @RequestMapping("foodtypeAdd")
    @ResponseBody
    public int foodtypeAdd(FoodType foodType) {
        return foodTypeService.add(foodType);
    }

    @RequestMapping("foodtypeUpdate")
    @ResponseBody
    public int foodtypeUpdate(FoodType foodType) {
        return foodTypeService.update(foodType);
    }

    @RequestMapping("foodtypeShow")
    @ResponseBody
    public PageData foodtypeShow(int page, int limit, String name) {
        return foodTypeService.findByPage(page, limit, name);
    }

    @RequestMapping("foodtypeDelete")
    @ResponseBody
    public int delete(int typeid) {
        return foodTypeService.delete(typeid);
    }
}
