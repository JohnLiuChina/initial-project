package com.learning.java8;

import com.learning.java8.learning.designPattern.visitor.Computer;
import com.learning.java8.learning.designPattern.visitor.ConcreteVisitor;

public class VisitorTest {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.accept(new ConcreteVisitor());
        int a = 1;
        System.out.println(3<3);
        System.out.println(a++);
    }
}
