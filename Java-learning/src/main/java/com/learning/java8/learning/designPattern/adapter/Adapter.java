package com.learning.java8.learning.designPattern.adapter;

/**
 * 适配器
 */
public class Adapter extends Adaptee implements NetToUsb {
    @Override
    public void handleRequest() {
        super.request();
    }
}
