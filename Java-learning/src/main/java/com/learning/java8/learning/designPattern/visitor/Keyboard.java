package com.learning.java8.learning.designPattern.visitor;

public class Keyboard implements ComputerPart {
    @Override
    public void accept(ComputePartVisitor visitor) {
        visitor.visit(this);
    }
}
