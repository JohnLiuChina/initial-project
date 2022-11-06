package com.example.service;

import com.example.config.PropertiesConfiguration;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FieldService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PropertiesConfiguration configuration;

    @Transactional
    public void insert() {
        System.out.println(configuration.getName());
    }

}
