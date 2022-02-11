package com.learning.java8.learning.designPattern.factory.abstractFactory;

public class Apple3cFactory implements Abstract3cFactory {

    @Override
    public Phone makePhone() {
        return new IPhone();
    }

    @Override
    public Pc makePc() {
        return new IMac();
    }

}
