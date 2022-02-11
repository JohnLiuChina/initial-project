package com.learning.java8.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.learning.java8.service.RegisteService;

import java.util.Arrays;
import java.util.List;

public class RegistePearImpl implements RegisteService {

    private final List<String> pearList = Arrays.asList("pear1", "pear2", "pear3");

    @Override
    public void registe(String url) {
        System.out.println("registe to:" + url + pearList);
    }

    @Override
    public void foreach() {
        pearList.forEach(pear -> {
            System.out.println(pear);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        String jsonStr = getJsonStr();
        System.out.println(jsonStr);
    }

    @Override
    public String getJsonStr() {
        return JSONObject.toJSONString(pearList);
    }

}
