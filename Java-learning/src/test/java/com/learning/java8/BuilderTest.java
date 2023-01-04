package com.learning.java8;

import com.learning.java8.learning.designPattern.builder.User;

import java.util.UUID;

public class BuilderTest {
    public static void main(String[] args) {
        User user = User.Builder()
                .uid(UUID.randomUUID().toString())
                .age(1)
                .gender("male")
                .name("adsad")
                .build();
        System.out.println(user);
    }
}
