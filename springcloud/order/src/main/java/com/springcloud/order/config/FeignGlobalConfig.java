package com.springcloud.order.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 此处使用@Configuration为全局Feign配置，对所有远程服务均会生效
 * 局部配置在@FeignClient的configuration属性上
 */
//@Configuration
public class FeignGlobalConfig {
    /**
     * Feign日志级别为DEBUG
     *
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
