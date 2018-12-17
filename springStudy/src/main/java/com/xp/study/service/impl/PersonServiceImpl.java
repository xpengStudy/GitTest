package com.xp.study.service.impl;

import com.xp.study.resepotory.impl.PersonResipotroyImpl;
import com.xp.study.service.PersonService;

import java.util.*;

public class PersonServiceImpl implements PersonService {

    private PersonResipotroyImpl userResipotroyDi;

    //如果有多个属性
    private List<String>  lists = new ArrayList<String>();

    private Set<String>   sets  = new HashSet<String>();

    private Map<String,String> maps = new HashMap<String,String>();

    private Properties  properties = new Properties();


    public PersonResipotroyImpl getUserResipotroyDi() {
        return userResipotroyDi;
    }

    public void setUserResipotroyDi(PersonResipotroyImpl userResipotroyDi) {
        this.userResipotroyDi = userResipotroyDi;
    }

    public List<String> getLists() {
        return lists;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public Set<String> getSets() {
        return sets;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public Map<String, String> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /*public PersonResipotroyImpl getUserResipotroy(){
            return userResipotroyDi;
        }*/
    public void setUserResipotroy(PersonResipotroyImpl userResipotroy){
        this.userResipotroyDi = userResipotroy;
    }

    @Override
    public List<String> getList() {
        return lists;
    }

    @Override
    public Set<String> getSet() {
        return sets;
    }

    @Override
    public Map<String, String> getMap() {
        return maps;
    }

    @Override
    public Properties getPro() {
        return properties;
    }

    @Override
    public void save() {
        PersonResipotroyImpl utest = new PersonResipotroyImpl();
        utest.save();
    }


}
