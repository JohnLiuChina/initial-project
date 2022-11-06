package com.example;

import com.example.beans.StuA;
import com.example.beans.StuB;
import com.example.beans.User;
import com.example.config.IocCongfig;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocTest {

    private AnnotationConfigApplicationContext context;

    @Before
    public void init() {
        context = new AnnotationConfigApplicationContext(IocCongfig.class);
    }

    @Test
    public void iocTest() {
        User user = context.getBean(User.class);
        System.out.println(user.getId());
    }

    @Test
    public void frameworkTest() {
        System.out.println(context.getBean(StuA.class));
        System.out.println(context.getBean(StuB.class));
        System.out.println(context.getBean("CC"));
    }

}
