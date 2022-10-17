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

    public String generateUUid() {
        return UUID.randomUUID().toString();
    }
}
