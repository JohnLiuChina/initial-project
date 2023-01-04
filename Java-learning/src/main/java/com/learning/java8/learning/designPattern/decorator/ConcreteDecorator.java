package com.learning.java8.learning.designPattern.decorator;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addedOperation();
    }

    private void addedOperation() {
        System.out.println("concrete decorator operating");
    }
}
