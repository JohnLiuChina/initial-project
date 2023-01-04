package com.learning.java8.learning.designPattern.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LeaderChain extends CheckChain{
    @Override
    public void proceed(Event event) {
        if (event.getDate() > 5) {
            if (nextChecker != null) {
                log.info("Leader无法处理Event,移交下一节点");
                nextChecker.proceed(event);
            } else {
                log.info("Leader无法处理Event");
            }
        } else {
            log.info("Leader处理Event");
        }
    }
}
