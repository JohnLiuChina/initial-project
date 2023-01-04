package com.learning.java8.learning.designPattern.decorator;

public class ConcreteComponent extends Component {
    @Override
    public void operation() {
        System.out.println("concrete operating");
    }
}
