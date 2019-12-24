package com.wzs.controller;

import com.wzs.entity.*;
import com.wzs.service.*;
import com.wzs.utils.VideoImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("spend")
public class SpendController {
    //工艺
    @Resource
    ProcesService  procesService;
    //口味
    @Resource
    TeasteService  teasteService;
    //难度
    @Resource
    HardService  hardService;
    //菜系
    @Resource
    CookstyleService cookstyleService;
    //家常
    @Resource
    HomecookService  homecookService;
    //地方
    @Resource
    SpeacecookService  speacecookService;

    //发表菜谱的跳转
    @RequestMapping("book")
    public String show(Model model){
        List<Proces> proces = procesService.findAll();
        model.addAttribute("proces",proces);
        List<Taste> teaste = teasteService.findAll();
        model.addAttribute("teaste",teaste);
        List<Hard> hard = hardService.findAll();
        model.addAttribute("hard",hard);
        List<Cookstyle> cookstyle = cookstyleService.findAll();
        model.addAttribute("cookstyle",cookstyle);
        List<Homecook> homecook = homecookService.findAll();
        model.addAttribute("homecook",homecook);
        List<Speacecook> speacecook = speacecookService.findAll();
        model.addAttribute("speacecook",speacecook);

        return "front/spend/spendbook";
    }

    String img="";

    @RequestMapping("/upload")
    @ResponseBody
    public Integer fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req, Model model){
        System.out.println(" = =========图片上传进来了=====" );
        //上传成功会收到文件名
        String s = VideoImgUtil.helper_V_I(file, req,1);
        if (s.equals("0")){
            System.out.println("上传失败");
        }
        System.out.println("文件名====》"+s);
        //赋值
        img=s;
        Integer code=0;
        return code;
    }

    @RequestMapping("/saveInfo")
    @ResponseBody
    public String saveInfo(Cookbook cookbook, HttpSession session){
        System.out.println("============cookbook===== = " );
        String code = "0";
        System.out.println("cookbook = " + cookbook);
        String  s="/img/"+img;
        cookbook.setCookimg(s);

        Date abc = new Date(System.currentTimeMillis());
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd  HH-mm-ss");
        String format = ss.format(abc);
        cookbook.setReadlytime(format);
        //缺少aid


        return code;
    }

}
