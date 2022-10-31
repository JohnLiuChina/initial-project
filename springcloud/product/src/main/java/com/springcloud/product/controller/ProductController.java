package com.springcloud.product.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @PutMapping("/shopping/{id}")
    public String shopping(@PathVariable("id") String id) throws InterruptedException {
        int a = 1/0;
        Thread.sleep(5000);
        return "product " + id + " ok";
    }
}
