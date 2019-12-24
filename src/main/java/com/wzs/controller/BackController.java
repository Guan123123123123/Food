package com.wzs.controller;

import com.wzs.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("back")
public class BackController {

    @RequestMapping("/index")
    public String index(){
        return  "back/index";
    }
    @RequestMapping("/main")
    public String main(){
        return  "back/main";
    }

    @Autowired
    UsersService bas;

    @RequestMapping("login")
    public String login(String uname, String upassword, HttpSession session){
        System.out.println("uname = " + uname);
        System.out.println("upassword = " + upassword);
        Map<String, Object> users = bas.query(uname,upassword);
        System.out.println("users = " + users);
        if(users!=null){
            session.setAttribute("users",users);
            session.removeAttribute("msg2");
            return "back/index";
        }else{
            session.setAttribute("msg2","用户名或密码错误");
            return "redirect:/back/tologin";
        }
    }

    @RequestMapping("tologin")
    public String tologin(){
        return "back/login/login";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("users");
        return  "redirect:/back/tologin";
        //return "redirect:/blog/article";
    }

}
