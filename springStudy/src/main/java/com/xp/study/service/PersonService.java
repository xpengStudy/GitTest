package com.xp.study.service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public interface PersonService {
    List<String>  getList();
    Set<String>   getSet();
    Map<String,String> getMap();
    Properties  getPro();

    void save();
}
