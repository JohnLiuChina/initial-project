package com.example.controller;

import com.example.service.IUserService;
import com.example.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {
//    @Value("#{userServiceImpl}")
//    @Resource
    /**
     * @Resource和@Autowired区别
     * resource依赖JDK autowired依赖spring
     * resource优先根据名字匹配 autowired优先根据类型匹配
     */
    @Autowired
//    @Qualifier
    /**
     * 使用autowired自动装配默认按byType匹配，匹配到多个再按name（变量名）匹配
     * 识别到多个以后的修改方案：1.修改变量名称 2.补充@Component中value值 3.使用@Qualifier设置 4.通过@Primary设置某一个为主要的Bean 5.泛型
     */
    private IUserService userService;

    public String getUuid() {
        return userService.generateUUid();
    }
}
