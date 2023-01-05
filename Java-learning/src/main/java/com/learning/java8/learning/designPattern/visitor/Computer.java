package com.learning.java8.learning.designPattern.visitor;

public class Computer implements ComputerPart {

    ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[]{new Keyboard(), new Monitor(), new Mouse()};
    }

    @Override
    public void accept(ComputePartVisitor visitor) {
        for (ComputerPart part : parts) {
            part.accept(visitor);
        }
        visitor.visit(this);
    }
}
