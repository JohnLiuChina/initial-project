package com.demo.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.EnableAsync;

@Slf4j
@EnableAsync
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RedisApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(RedisApplication.class, args);
        } catch (Exception e) {
            log.error("", e);
        }
    }

}
