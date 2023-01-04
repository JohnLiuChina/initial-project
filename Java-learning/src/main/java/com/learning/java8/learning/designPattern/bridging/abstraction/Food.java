package com.learning.java8.learning.designPattern.bridging.abstraction;

import com.learning.java8.learning.designPattern.bridging.implementor.Fruit;

/**
 * 桥接模式，将抽象和实现解耦，遵循开闭原则，使抽象和实现能独立变化
 */
public abstract class Food {

    protected Fruit fruit;

    public Food(Fruit fruit) {
        this.fruit = fruit;
    }

    public abstract void add();

}
