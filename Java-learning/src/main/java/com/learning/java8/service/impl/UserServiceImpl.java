package com.learning.java8.service.impl;

import com.learning.java8.entity.User;
import com.learning.java8.mapper.UserMapper;
import com.learning.java8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户的业务层实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUserByName(String username){
        return userMapper.findUserByName(username);
    }

    @Override
    public void insert(User userBean) {

    }
}
