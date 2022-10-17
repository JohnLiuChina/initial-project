package com.example.entity;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {
    @Test
    public void iocTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("ioc-config.xml");
        System.out.println("ioc is ready");
        User user = context.getBean(User.class);
        System.out.println(user);
    }
}
