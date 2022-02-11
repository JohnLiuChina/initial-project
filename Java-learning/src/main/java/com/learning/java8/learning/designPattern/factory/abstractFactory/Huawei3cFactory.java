package com.learning.java8.learning.designPattern.factory.abstractFactory;

public class Huawei3cFactory implements Abstract3cFactory {

    @Override
    public Phone makePhone() {
        return new Mate();
    }

    @Override
    public Pc makePc() {
        return new MateBook();
    }

}
