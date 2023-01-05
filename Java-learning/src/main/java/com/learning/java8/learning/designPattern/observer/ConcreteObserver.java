package com.learning.java8.learning.designPattern.observer;

public class ConcreteObserver implements Observer {

    private String name;

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("Name:" + name + " received message:" + message);
    }

}
