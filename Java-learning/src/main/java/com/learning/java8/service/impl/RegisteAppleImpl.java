package com.learning.java8.service.impl;

import com.learning.java8.service.RegisteService;

import java.util.Arrays;
import java.util.List;

public class RegisteAppleImpl implements RegisteService {

    private final List<String> appleList = Arrays.asList("apple1", "apple2", "apple3");

    @Override
    public void registe(String url) {
        System.out.println("registe to:" + url + appleList);
    }

    @Override
    public void foreach() {
        appleList.forEach(System.out::println);
    }

    @Override
    public String getJsonStr() {
        return null;
    }

}
