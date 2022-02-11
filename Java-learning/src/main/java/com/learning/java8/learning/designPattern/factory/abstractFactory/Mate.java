package com.learning.java8.learning.designPattern.factory.abstractFactory;

public class Mate implements Phone {

    public Mate(){
        makePhone();
    }

    @Override
    public void makePhone() {
        System.out.println("declare a mate phone");
    }

}
