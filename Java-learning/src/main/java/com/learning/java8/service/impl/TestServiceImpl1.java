package com.learning.java8.service.impl;

import com.learning.java8.service.TestService;

public class TestServiceImpl1 implements TestService {
    @Override
    public String getcurrentTime() {
        return "11111current:" + System.currentTimeMillis();
    }
}
