package com.springcloud.order.controller;

import com.springcloud.order.feign.ProductService;
import com.springcloud.order.feign.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private StockService stockService;
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String resp = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        String feignResp = stockService.reduct();
        String productResp = productService.shopping(UUID.randomUUID().toString());
        return "ok" + feignResp + productResp;
    }
}
