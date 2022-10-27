package com.example;

import com.example.config.PropertiesConfiguration;
import com.example.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MyApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MyApplication.class);
        FieldService bean = run.getBean(FieldService.class);
        bean.insert();
    }
}
