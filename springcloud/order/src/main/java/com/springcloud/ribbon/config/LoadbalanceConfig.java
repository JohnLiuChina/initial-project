package com.springcloud.ribbon.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 此处不能配在启动类可以扫描到的包路径下，会导致所有的Ribbon客户端均使用该配置类的LB模式
public class LoadbalanceConfig {

    @Bean
    public IRule iRule() { // 此处方法名一定要为iRule
        return new RandomRule();
    }

}
