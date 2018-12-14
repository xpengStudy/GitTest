package com.xp.study.controller;

import com.xp.study.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        //1.创建spring IOC 容器
        ApplicationContext  ctx =  new ClassPathXmlApplicationContext("META-INFO/applicationContext.xml");
        //2.从IOC容器获取对象
        HelloWord helloWord   = (HelloWord) ctx.getBean("helloWord");
        //3.调用对象方法
        helloWord.hello();

        //从IOC容器获取 接口对象
        PersonService personService = (PersonService)ctx.getBean("personService");
        personService.save();

    }
}
