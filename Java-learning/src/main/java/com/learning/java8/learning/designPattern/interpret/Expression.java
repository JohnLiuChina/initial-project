package com.learning.java8.learning.designPattern.interpret;

/**
 * 解释器模式，解释器模式提供了一种评估计算语言语法或表达式的方法。 这种类型的模式属于行为模式。
 * 这种模式涉及实现一个表达式接口，它告诉解释一个指定的上下文。
 * 此模式用于SQL解析，符号处理引擎等。
 */
public interface Expression {

    boolean interpret(String context);

}
