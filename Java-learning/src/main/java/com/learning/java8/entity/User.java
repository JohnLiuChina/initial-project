package com.learning.java8.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Entity
//@Table(name = "user")
@Data
public class User implements Serializable, Cloneable {
    //@Id//主键
    //@Column(name = "id")//对应列名
    //@GeneratedValue(strategy = GenerationType.IDENTITY)//自增
    private Integer id;

    //@Column(name = "username")
    private String username;
    //@Column(name = "password")
    private String password;

    private Integer[] arr;

    private Expense expense;

    private static final List<String> obj = new ArrayList<String>() {{
        add("Object o1");
        add("Object o2");
    }};

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", arr=" + Arrays.toString(arr) +
                ", expense=" + expense +
                '}';
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
            return e;
        }
    }
}
