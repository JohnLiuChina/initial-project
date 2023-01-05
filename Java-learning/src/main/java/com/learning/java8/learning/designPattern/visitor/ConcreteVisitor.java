package com.learning.java8.learning.designPattern.visitor;

public class ConcreteVisitor implements ComputePartVisitor {
    @Override
    public void visit(Computer computer) {
        System.out.println("visit computer");
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("visit keyboard");
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("visit monitor");
    }

    @Override
    public void visit(Mouse mouse) {
        System.out.println("visit mouse");
    }
}
