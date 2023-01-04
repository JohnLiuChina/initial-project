package com.learning.java8.learning.designPattern.bridging.abstraction;

import com.learning.java8.learning.designPattern.bridging.implementor.Fruit;

public class Cake extends Food {

    public Cake(Fruit fruit) {
        super(fruit);
    }

    @Override
    public void add() {
        fruit.beAdded("蛋糕");
    }

}
