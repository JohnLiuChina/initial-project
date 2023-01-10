package com.learning.java8.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.learning.java8.aspect.Custom;
import com.learning.java8.entity.Field;
import com.learning.java8.learning.designPattern.strategy.DealingContext;
import com.learning.java8.mapper.FieldMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private FieldMapper fieldMapper;
    @Resource
    private DealingContext dealingContext;

    @Custom(info = "HelloController")
    @RequestMapping("/test/{type}")
    public String hello(@PathVariable("type") String type) {
        System.out.println("here i am");
        dealingContext.dealing(type);
        dealingContext.load(type);
        return "hello, this is springboot!";
    }

    @GetMapping("/field")
    public Object getFields() {
        QueryWrapper<Field> wrapper = new QueryWrapper<>();
        return fieldMapper.selectList(wrapper);
    }

    public void a() {
        b();
    }

    public int b() {
        return 111;
    }

}
