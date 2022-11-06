package com;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.client.RestTemplate;

@Slf4j
@EnableAsync
@ComponentScan(value = "com.proxy", basePackageClasses = ProxyApplication.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class ProxyApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        try {
            SpringApplication.run(ProxyApplication.class, args);
        } catch (Exception e) {
            log.error("", e);
        }
    }
}
