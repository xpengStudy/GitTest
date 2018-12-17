package com.xp.study.controller;

import com.xp.study.pojo.HelloWord;
import com.xp.study.service.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        /*
        //1.创建spring IOC 容器
        ApplicationContext  ctx =  new ClassPathXmlApplicationContext("META-INFO/applicationContext.xml");
        //2.从IOC容器获取对象
        HelloWord helloWord   = (HelloWord) ctx.getBean("testAddHello");
        helloWord.setName("yes or no");
        //3.调用对象方法
        helloWord.hello();*/

        /*开始学习IOC的依赖注入*/
        //从IOC容器获取 接口对象
        ApplicationContext ctx  = new ClassPathXmlApplicationContext("META-INFO/applicationContext.xml");
        PersonService personService = (PersonService)ctx.getBean("personServiceDi");
        personService.save();
        //获取list对象
        System.out.println("/**********************  list ****************/");
        List<String> lists = personService.getList();
        for(String string:lists){
            System.out.println(string);
        }
        System.out.println("/**********************  Set ****************/");
        //获取set对象
        Set<String>  sets = personService.getSet();
        for(String string:sets){
            System.out.println(string);
        }
        System.out.println("/**********************  Properties ****************/");
        //获取property对象
        Properties properties = personService.getPro();
        for(String string:properties.stringPropertyNames()){
            System.out.println(string);
        }

        System.out.println("/**********************  map ****************/");


        //获取map对象
        Map<String,String> maps = personService.getMap();
        for(String string:maps.values()){
            System.out.println(string);
        }




    }
}
