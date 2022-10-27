package com.example.controller;

import com.example.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FieldController {

    @Autowired
    private FieldService fieldService;

    @GetMapping("/test")
    public void test() {
        fieldService.insert();
    }

}
