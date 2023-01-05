package com.learning.java8;

import com.learning.java8.learning.designPattern.observer.ConcreteObserved;
import com.learning.java8.learning.designPattern.observer.ConcreteObserver;

public class ObserverTest {

    public static void main(String[] args) {
        ConcreteObserved wechatServer = new ConcreteObserved();
        ConcreteObserver client1 = new ConcreteObserver("client1");
        ConcreteObserver client2 = new ConcreteObserver("client2");
        ConcreteObserver client3 = new ConcreteObserver("client3");
        ConcreteObserver client4 = new ConcreteObserver("client4");
        ConcreteObserver client5 = new ConcreteObserver("client5");
        wechatServer.addObserver(client1);
        wechatServer.addObserver(client2);
        wechatServer.addObserver(client3);
        wechatServer.addObserver(client4);
        wechatServer.addObserver(client5);
        wechatServer.notifyObserver("publish news from server");
    }

}
