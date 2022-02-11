package com.learning.java8.learning.designPattern.factory.abstractFactory;

public class IPhone implements Phone {

    public IPhone(){
        this.makePhone();
    }

    @Override
    public void makePhone() {
        System.out.println("declare a iphone");
    }

}
