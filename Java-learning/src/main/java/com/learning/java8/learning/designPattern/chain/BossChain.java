package com.learning.java8.learning.designPattern.chain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BossChain extends CheckChain {
    @Override
    public void proceed(Event event) {
        log.info("Boss处理Event:{}", event);
    }
}
