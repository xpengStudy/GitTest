package com.study.studyspringboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {

    @RequestMapping("/hello")
    public String index(){
        return  "Hello  SpringBoot";
    }
}
