package com.learning.java8.learning.designPattern.chain;

import com.learning.java8.learning.designPattern.chain.CheckChain;
import com.learning.java8.learning.designPattern.chain.Event;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GroupChain extends CheckChain {
    @Override
    public void proceed(Event event) {
        if (event.getDate() > 3) {
            if(nextChecker != null) {
                log.info("Group无法处理Event,移交下一节点");
                nextChecker.proceed(event);
            } else {
                log.info("Group无法处理Event");
            }
        } else {
            log.info("Group处理Event");
        }
    }
}
