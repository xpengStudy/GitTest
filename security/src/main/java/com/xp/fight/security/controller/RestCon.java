package com.xp.fight.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@Slf4j
public class RestCon {

    @RequestMapping("/testPostHttp")
    public void testPostHttp(@RequestBody String name,String code){
        System.out.println("name   :   "+name+ "=====   code   :    "+code );
        log.debug("Name : "+name+"      code  :   "+code);

    }



}
