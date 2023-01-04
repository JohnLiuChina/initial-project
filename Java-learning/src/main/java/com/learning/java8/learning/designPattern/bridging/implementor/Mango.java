package com.learning.java8.learning.designPattern.bridging.implementor;

public class Mango implements Fruit {
    @Override
    public void beAdded(String food) {
        System.out.println("芒果" + food);
    }
}
