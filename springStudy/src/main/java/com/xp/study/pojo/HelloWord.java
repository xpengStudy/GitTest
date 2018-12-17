package com.xp.study.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HelloWord {

    public String name;


    public void hello(){
        System.out.println("hello:"+name);
    }

    public HelloWord  getHelloWord(String name){
        return  new HelloWord();
    }

    public  void init(){
        System.out.println("我 初始化了某些资源 ");
    }


}
