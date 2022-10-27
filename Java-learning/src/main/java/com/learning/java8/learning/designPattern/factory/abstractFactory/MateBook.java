package com.learning.java8.learning.designPattern.factory.abstractFactory;

public class MateBook implements Pc {

    public MateBook() {
        makePc();
    }

    @Override
    public void makePc() {
        System.out.println("declare a matebook");
    }

}
