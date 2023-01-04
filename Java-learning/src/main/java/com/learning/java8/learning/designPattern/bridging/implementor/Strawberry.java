package com.learning.java8.learning.designPattern.bridging.implementor;

public class Strawberry implements Fruit {

    @Override
    public void beAdded(String food) {
        System.out.println("草莓" + food);
    }

}
