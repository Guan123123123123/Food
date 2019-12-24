package com.wzs.controller;


import com.alibaba.fastjson.JSONArray;
import com.qq.connect.QQConnectException;
import com.qq.connect.oauth.Oauth;
import com.wzs.entity.Account;
import com.wzs.service.AccountService;
import com.wzs.utils.PageData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("account")
public class AccountController {

    //qq登录
    @RequestMapping("/qqLogin")
    public void qqLogin(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {//qq登录
        response.setContentType("text/html;charset=utf-8");
        try {
            response.sendRedirect(new Oauth().getAuthorizeURL(request));
            session.setAttribute("beforLoginUrl",request.getHeader("Referer"));
        } catch (QQConnectException e) {
            e.printStackTrace();
        }
    }
    //退出登录
    @RequestMapping("/Logout")
    public String logout(HttpSession session){
        session.removeAttribute("account");
        session.removeAttribute("oauth");
        return  "success";
        //return "redirect:/blog/article";
    }
    @Resource
    AccountService accountService;

    @RequestMapping("show")
    public String show() {
        return "back/account/AccountShow";
    }
    @RequestMapping("/add")
    public String add() {
        return "back/account/AccountAdd";
    }

    @RequestMapping("/update")
    public String update1(int aid, Model model) {
        Account one = accountService.findOne(aid);
        System.out.println("one = " + one);
        model.addAttribute("account",one);
        return "back/account/AccountUpdate";
    }

    @RequestMapping("accountAdd")
    @ResponseBody
    public  int  deptAdd(Account account) {
        int add = accountService.add(account);
        return add;
    }


    @RequestMapping("accountUpdate")
    @ResponseBody
    public  int  deptUpdate(Account account) {
        int upt = accountService.upd(account);
        return upt;
    }

    @RequestMapping("accountShow")
    @ResponseBody
    public String show(int page, int limit, String name) {
        System.out.println("Page = " + page);
        System.out.println("limit = " + limit);
        System.out.println("name = " + name);
        PageData<Account> all = accountService.findByPage(page, limit, name);
        String jsonStr = JSONArray.toJSONStringWithDateFormat(all, "yyyy-MM-dd HH:mm:ss");
        return jsonStr;
    }

    @RequestMapping("accountDelete")
    @ResponseBody
    public int del(int aid) {
        int del = accountService.del(aid);
        return del;
    }
}
