package com.example;

import com.example.beans.User;
import com.example.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IocTest {

    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
    }

    @Test
    public void contextTest() {
        UserController user = context.getBean(UserController.class);
        System.out.println(user.getUuid());
    }

}
