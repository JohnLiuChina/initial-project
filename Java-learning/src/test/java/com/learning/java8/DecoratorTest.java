package com.learning.java8;

import com.learning.java8.learning.designPattern.decorator.Component;
import com.learning.java8.learning.designPattern.decorator.ConcreteComponent;
import com.learning.java8.learning.designPattern.decorator.ConcreteDecorator;
import com.learning.java8.learning.designPattern.decorator.Decorator;

public class DecoratorTest {

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        Decorator decorator = new ConcreteDecorator(component);
        decorator.operation();
    }

}
