package com.learning.java8.learning.designPattern.factory.simpleFactory;

public class Pear implements Fruit {

    public Pear() {
        make();
    }

    @Override
    public void make() {
        System.out.println("declare a Pear");
    }

}
