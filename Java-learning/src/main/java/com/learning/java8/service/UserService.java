package com.learning.java8.service;
/**
 * 用户的业务层接口
 */

import com.learning.java8.entity.User;

import java.util.List;

public interface UserService {
    List<User> findUserByName(String username);
    void insert(User userBean);
}
