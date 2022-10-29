package com.springcloud.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * OpenFeign已经集成ribbon、nacos
 * name:远程服务名 path:请求路径前缀
 *  - 动态代理
 */
@FeignClient(name = "stock-service", path = "/stock")
public interface StockService {

    @GetMapping("reduct")
    String reduct();

}