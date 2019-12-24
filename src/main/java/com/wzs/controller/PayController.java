package com.wzs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("pc")
public class PayController {

    @RequestMapping("toindex")
    public String toindex(){
        return "payTest";
    }


}
