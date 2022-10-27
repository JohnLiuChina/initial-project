package com.springcloud.stock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @GetMapping("reduct")
    public String reduct() {
        System.out.println("reduct success");
        return "ok";
    }
}
