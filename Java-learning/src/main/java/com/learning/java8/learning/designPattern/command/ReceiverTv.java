package com.learning.java8.learning.designPattern.command;

/**
 * 命令模式——接收者
 *
 */
public class ReceiverTv {

    public void on() {
        System.out.println("tv is going to power on");
    }

    public void off() {
        System.out.println("closing tv");
    }

}
