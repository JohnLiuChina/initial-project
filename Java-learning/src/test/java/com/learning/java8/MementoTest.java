package com.learning.java8;

import com.learning.java8.learning.designPattern.memento.CareTaker;
import com.learning.java8.learning.designPattern.memento.Originator;

public class MementoTest {

    public static void main(String[] args) {
        Originator originator = new Originator();
        CareTaker caretaker = new CareTaker();

        originator.setState(" 状态#1 攻击力:100");
        // 保存了当前的状态
        caretaker.addMemento(originator.saveState());

        originator.setState(" 状态#2 攻击力:80");
        caretaker.addMemento(originator.saveState());

        originator.setState(" 状态#3 攻击力:50");
        caretaker.addMemento(originator.saveState());

        // 希望恢复到状态#1
        System.out.println("当前状态是： " + originator.getState());
        originator.recoverState(caretaker.get(0));
        System.out.println("恢复后的状态是： " + originator.getState());
    }
}
