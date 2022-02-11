package com.learning.java8.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/test")
    public String hello(){
        return "hello, this is springboot!";
    }

    public void a(){
        b();
    }

    public int b(){
        return 111;
    }

}
