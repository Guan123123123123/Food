package com.wzs.controller;


import com.wzs.utils.VideoImgUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;


/**
 * 上传视频
 */
@Controller
@RequestMapping("uc")
public class UploadController {

    @RequestMapping("lala")
    public String uploladPage(){
        return "uoload";
    }


    @RequestMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest req, Model model){
        //上传成功会收到文件名
        String s = VideoImgUtil.helper_V_I(file, req,1);
        if (s.equals("0")){
            System.out.println("上传失败");
        }
        System.out.println("文件名====》"+s);

        return "showVideo";
    }

}