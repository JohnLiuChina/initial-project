package com.learning.java8.learning.designPattern.interpret;

public class TerminalExpression implements Expression {

    private String name;

    public TerminalExpression(String name) {
        this.name = name;
    }

    @Override
    public boolean interpret(String context) {
        return context.contains(name);
    }

}
