package com.learning.java8.learning.designPattern.factory.simpleFactory;

public class Appele implements Fruit {

    public Appele() {
        make();
    }

    @Override
    public void make() {
        System.out.println("declare a Apple");
    }

}
