package com.learning.java8.learning.designPattern.visitor;

public interface ComputePartVisitor {

    void visit(Computer computer);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Mouse mouse);

}
