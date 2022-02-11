package com.learning.java8.service.impl;

import com.learning.java8.service.TestService;

public class TestServiceImpl implements TestService {
    @Override
    public String getcurrentTime() {
        return "current:" + System.currentTimeMillis();
    }
}
