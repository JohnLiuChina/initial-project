package com.learning.java8.controller;

import com.learning.java8.entity.User;
import com.learning.java8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAllByJpa/{username}")
    public List<User> findAll(@PathVariable("username") String username){
        return userService.findUserByName(username);
    }

}
