package com.learning.java8;

import com.learning.java8.learning.designPattern.chain.*;
import com.learning.java8.utils.ExecutorUtil;
import org.junit.Test;

public class CheckChainTest {

    @Test
    public void test() throws InterruptedException {
        Event eventA = new Event();
        Event eventB = new Event();
        eventA.setDate(7);
        eventB.setDate(4);
        CheckChain chain = CheckChain.Builder()
                .addChecker(new GroupChain())
                .addChecker(new LeaderChain())
                .addChecker(new BossChain())
                .build();
        ExecutorUtil.execute(() -> {
            chain.proceed(eventA);
        });
        ExecutorUtil.execute(() -> {
            chain.proceed(eventB);
        });
        Thread.sleep(11111);
    }

}
