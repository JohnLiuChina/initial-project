package com.springcloud.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add")
    public String add(){
        System.out.println("下单成功");
        String resp = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
        return "ok" + resp;
    }
}
