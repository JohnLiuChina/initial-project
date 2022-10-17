package com.example.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void aopTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserService bean = context.getBean(IUserService.class);
        System.out.println(bean.generateUuid());
//        System.out.println(bean.generateUuidSimplify());
    }

}
