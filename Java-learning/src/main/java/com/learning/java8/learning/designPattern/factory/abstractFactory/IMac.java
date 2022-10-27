package com.learning.java8.learning.designPattern.factory.abstractFactory;

public class IMac implements Pc {

    public IMac() {
        this.makePc();
    }

    @Override
    public void makePc() {
        System.out.println("declare a imac");
    }

}
