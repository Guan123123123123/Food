package com.wzs.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VideoImgUtil {
    public static String helper_V_I(MultipartFile file, HttpServletRequest req,int arg){
        String localtionName="";
        //本地储存名
        if(arg==1){
             localtionName="F:\\S3\\wang\\Food\\src\\main\\resources\\static\\img";
        }
        if(arg==2) {
             localtionName="F:\\S3\\wang\\Food\\src\\main\\resources\\static\\mv";
        }

        //文件名
        String fileName = "";
        try {
            //当前计算机时间和GMT时间(格林威治时间)1970年1月1号0时0分0秒所差的毫秒数+上传时的文件名
            fileName = System.currentTimeMillis()+file.getOriginalFilename();
           // System.out.println("地址第一次====="+fileName);
            //  System.out.println("req.getServletContext()====》"+req.getServletContext().getRealPath(""));
            String destFileName=localtionName+ File.separator+fileName;
            //System.out.println("地址第二次=====>"+destFileName);
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
           // System.out.println("存储地址===》"+destFile); //     E:/IDEA_work/maven_ssm/src/main/webapp/uploaded/157571235144400课前测1.mp4
            file.transferTo(destFile);//转入上传
            //System.out.println("文件最终存储地址第二次=====>"+destFile);
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
            e.getMessage();
            return "0" ;
        } catch (IOException e) {
            e.printStackTrace();
            e.getMessage();
            return "0" ;
        }
        return fileName;
    }
}
