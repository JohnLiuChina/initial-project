package com.learning.java8.learning.designPattern.command;

/**
 * 调用者
 */
public class RemoteControl {

    private AbstractCommand tvOn;
    private AbstractCommand tvOff;

    public RemoteControl(AbstractCommand tvOn, AbstractCommand tvOff) {
        this.tvOn = tvOn;
        this.tvOff = tvOff;
    }

    public void clickOn() {
        tvOn.execute();
    }

    public void clickOff() {
        tvOff.execute();
    }

}
