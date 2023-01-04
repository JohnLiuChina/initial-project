package com.learning.java8;

import com.learning.java8.learning.designPattern.interpret.AndExpression;
import com.learning.java8.learning.designPattern.interpret.Expression;
import com.learning.java8.learning.designPattern.interpret.OrExpression;
import com.learning.java8.learning.designPattern.interpret.TerminalExpression;

public class ExpressionTest {
    public static void main(String[] args) {
        System.out.println("John is male? " + getOrExpression().interpret("John"));
        System.out.println("Julie is a married women? " + getAndExprssion().interpret("Married Julie"));
    }

    private static Expression getOrExpression() {
        Expression expr1 = new TerminalExpression("John");
        Expression expr2 = new TerminalExpression("Robert");
        return new OrExpression(expr1, expr2);
    }

    private static Expression getAndExprssion() {
        Expression expr1 = new TerminalExpression("Julie");
        Expression expr2 = new TerminalExpression("Married");
        return new AndExpression(expr1, expr2);
    }
}
