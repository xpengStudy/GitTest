package com.xp.study.service.impl;

import com.xp.study.resepotory.impl.PersonResipotroyImpl;
import com.xp.study.service.PersonService;

public class PersonServiceImpl implements PersonService {

    private PersonResipotroyImpl userResipotroyDi;

    /*public PersonResipotroyImpl getUserResipotroy(){
        return userResipotroyDi;
    }*/
    public void setUserResipotroy(PersonResipotroyImpl userResipotroy){
        this.userResipotroyDi = userResipotroy;
    }
    @Override
    public void save() {
        PersonResipotroyImpl utest = new PersonResipotroyImpl();
        utest.save();
    }


}
