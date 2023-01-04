package com.learning.java8;

import com.learning.java8.learning.designPattern.command.OffTvCommand;
import com.learning.java8.learning.designPattern.command.OnTvCommand;
import com.learning.java8.learning.designPattern.command.ReceiverTv;
import com.learning.java8.learning.designPattern.command.RemoteControl;

public class CommandTest {
    public static void main(String[] args) {
        ReceiverTv tv = new ReceiverTv();
        OnTvCommand onTvCommand = new OnTvCommand(tv);
        OffTvCommand offTvCommand = new OffTvCommand(tv);
        RemoteControl remoteControl = new RemoteControl(onTvCommand, offTvCommand);
        remoteControl.clickOn();
        remoteControl.clickOff();
    }
}
