package com.xp.study.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class HelloWord {

    public String name;


    private void hello(){
        System.out.println("hello:"+name);
    }

    public HelloWord  getHelloWord(String name){
        return  new HelloWord();
    }


}
