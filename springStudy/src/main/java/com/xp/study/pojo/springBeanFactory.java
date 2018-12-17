package com.xp.study.pojo;

import com.xp.study.pojo.HelloWord;
import com.xp.study.service.impl.PersonServiceImpl;

public class springBeanFactory {

    public static HelloWord createHello(){
        return new HelloWord();
    }

    public HelloWord addHello(){
        return  new HelloWord();
    }

    public HelloWord testAdd(){
        return  new HelloWord();
    }

    public PersonServiceImpl addPerson(){
        return new PersonServiceImpl();
    }
}
