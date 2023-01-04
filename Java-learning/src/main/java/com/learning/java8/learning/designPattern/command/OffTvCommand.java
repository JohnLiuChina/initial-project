package com.learning.java8.learning.designPattern.command;

/**
 * 具体命令角色，绑定接收者与命令
 */
public class OffTvCommand extends AbstractCommand {

    private ReceiverTv tv;

    public OffTvCommand(ReceiverTv receiverTv) {
        tv = receiverTv;
    }

    @Override
    public void execute() {
        tv.off();
    }

}
