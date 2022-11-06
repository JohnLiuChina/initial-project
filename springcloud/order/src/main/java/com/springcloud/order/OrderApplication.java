package com.springcloud.order;

import com.springcloud.ribbon.config.LoadbalanceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;

@EnableFeignClients
@SpringBootApplication
@EnableTransactionManagement
// 此处为通过配置类的方式进行LB
//@RibbonClients(value = {
//        @RibbonClient(name = "stock-service", configuration = LoadbalanceConfig.class)
//})
public class OrderApplication {
    @Bean
    @LoadBalanced
    public RestTemplate initRestTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class);
    }
}
