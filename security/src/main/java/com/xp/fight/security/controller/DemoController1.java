package com.xp.fight.security.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sun.plugin.liveconnect.SecurityContextHelper;

@Controller
public class DemoController1 {


    @RequestMapping("/login")
    public  String userLogin(){
        return "demo_sign";
    }


    @RequestMapping("/login-error")
    public  String loginError(){
        return "login-error";
    }

    @RequestMapping("/login-success")
    public String loginSuccese(){
        return "login-success";
    }

    @RequestMapping("/whoim")
    @ResponseBody
    public Object whoIm(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
