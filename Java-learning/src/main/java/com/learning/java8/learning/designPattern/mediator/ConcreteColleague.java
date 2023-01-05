package com.learning.java8.learning.designPattern.mediator;

public class ConcreteColleague extends Colleague {

    public ConcreteColleague(Mediator mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void getMessage(String message, String fromName) {
        System.out.println("我：" + name + "收到了" + fromName + "的消息：" + message);
    }

    @Override
    public void contact(String message, String... toColleagueNames) {
        mediator.contact(message, name, toColleagueNames);
    }
}
