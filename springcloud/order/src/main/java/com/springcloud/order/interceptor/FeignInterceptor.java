package com.springcloud.order.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 全局Feign拦截器配置
 *  - 单独配置可不放入IOC，在yml中配置各远程服务的拦截器
 */
@Slf4j
@Component
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        log.info("-------INTO FeignInterceptor-------");
    }
}