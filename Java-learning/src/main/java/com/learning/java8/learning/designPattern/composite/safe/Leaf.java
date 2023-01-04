package com.learning.java8.learning.designPattern.composite.safe;

public class Leaf implements Component {
    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void printStruct() {
        System.out.println(name);
    }
}
