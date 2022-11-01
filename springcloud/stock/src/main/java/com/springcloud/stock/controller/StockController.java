package com.springcloud.stock.controller;

import com.springcloud.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("reduct")
    public String reduct() {
        stockService.update();
        System.out.println("reduct success");
        return "ok";
    }
}
