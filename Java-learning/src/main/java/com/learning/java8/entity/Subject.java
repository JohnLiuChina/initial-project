package com.learning.java8.entity;

import lombok.Data;

@Data
public class Subject {

    private String name;

    public Subject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "[Subject: " + this.hashCode() + ",name:" + name + "]";
    }
}