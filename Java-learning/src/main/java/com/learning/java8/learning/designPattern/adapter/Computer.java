package com.learning.java8.learning.designPattern.adapter;

public class Computer {

    public void net(NetToUsb adapter) {
        adapter.handleRequest();
    }

    public static void main(String[] args) {
        NetToUsb netToUsb = new Adapter();
        Computer computer = new Computer();
        computer.net(netToUsb);
    }

}
