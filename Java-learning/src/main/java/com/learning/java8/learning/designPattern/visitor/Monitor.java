package com.learning.java8.learning.designPattern.visitor;

public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputePartVisitor visitor) {
        visitor.visit(this);
    }
}
