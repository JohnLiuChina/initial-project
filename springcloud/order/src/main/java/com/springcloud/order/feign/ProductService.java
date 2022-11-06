package com.springcloud.order.feign;

import com.springcloud.order.config.FeignGlobalConfig;
import com.springcloud.order.feign.sentinal.ProductFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * OpenFeign已经集成ribbon、nacos
 * name:远程服务名 path:请求路径前缀
 *  - 动态代理
 */
//@FeignClient(name = "product-service", path = "/product")
@FeignClient(name = "product-service", path = "/product", configuration = FeignGlobalConfig.class, fallback = ProductFallBack.class)
public interface ProductService {

    @PutMapping("/shopping/{id}")
    String shopping(@PathVariable("id") String id);

}
