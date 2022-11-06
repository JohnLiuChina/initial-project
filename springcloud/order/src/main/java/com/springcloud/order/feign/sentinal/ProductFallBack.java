package com.springcloud.order.feign.sentinal;

import com.springcloud.order.feign.ProductService;
import org.springframework.stereotype.Component;

@Component
public class ProductFallBack implements ProductService {
    @Override
    public String shopping(String id) {
        return "远程调用降级";
    }
}
