package com.learning.java8.learning.designPattern.bridging.abstraction;

import com.learning.java8.learning.designPattern.bridging.implementor.Fruit;

public class Milk extends Food {

    public Milk(Fruit fruit) {
        super(fruit);
    }

    @Override
    public void add() {
        fruit.beAdded("奶茶");
    }

}
