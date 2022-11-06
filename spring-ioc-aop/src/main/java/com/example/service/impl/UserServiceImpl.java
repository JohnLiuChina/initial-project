package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public String generateUuid() {
//        throw new RuntimeException("dasdasd");
        return UUID.randomUUID().toString();
    }

    @Override
    public String generateUuidSimplify() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
