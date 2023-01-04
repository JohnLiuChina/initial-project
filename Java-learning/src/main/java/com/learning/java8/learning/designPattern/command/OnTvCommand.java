package com.learning.java8.learning.designPattern.command;

public class OnTvCommand extends AbstractCommand {

    private ReceiverTv tv;

    public OnTvCommand(ReceiverTv tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.on();
    }

}
