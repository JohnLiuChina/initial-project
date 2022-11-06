package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class TransactionTest {
    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("spring.xml");
    }

    @Test
    public void test() {
        JdbcTemplate bean = context.getBean(JdbcTemplate.class);
        System.out.println(bean);
        Long maps = bean.queryForObject("select count(*) from instance", Long.class);
        System.out.println(maps);
    }
}
