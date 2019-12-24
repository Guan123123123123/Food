package com.wzs.controller;

import com.wzs.service.FrontService;
import com.wzs.service.MvService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("skipPage")
public class SkipPageController {




    @RequestMapping("about")
    public String about(){
        return "front/about";
    }

    @RequestMapping("blog")
    public String blog(){
        return "front/blog";
    }

    @RequestMapping("blog-single")
    public String blog_single(){
        return "front/blog-single";
    }

    @RequestMapping("contact")
    public String contact(){
        return "front/contact";
    }

    @RequestMapping("gallery")
    public String gallery(){
        return "front/gallery";
    }

    @RequestMapping("gallery-single")
    public String gallery_single(){
        return "front/gallery-single";
    }

    /**
     * 前台主页
     * @return
     */
    @RequestMapping("indexFood")
    public String indexFood(){
        return "front/indexFood";
    }

    @RequestMapping("services")
    public String services(){
        return "front/services";
    }

    /**
     * 前台注册
     * @return
     */
    @RequestMapping("regist")
    public String regist(){
        return "front/regist";
    }

    /**
     * 前台登陆
     * @return
     */
    @RequestMapping("login")
    public String login(){
        return "front/login";
    }

    /**
     * 前台个人中心
     * @return
     */
    @RequestMapping("pcenter")
    public String pcenter(){
        return "front/pcenter";
    }

    /**
     * 购买视频缴费支付
     * @return
     */
    @RequestMapping("payVideo")
    public String payVideo(){
        return "front/payVideo";
    }

    /**
     * 404
     * @return
     */
    @RequestMapping("page404")
    public String page404(){
        return "front/404";
    }

    /**
     * a
     * @return
     */
    //添加节点部分
    @RequestMapping("a")
    public String a(){
        return "front/a";
    }



}
