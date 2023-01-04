package com.learning.java8.test;

import com.learning.java8.learning.designPattern.flyweight.BasePowerBankFlyWeight;
import com.learning.java8.learning.designPattern.flyweight.PowerBank;
import com.learning.java8.learning.designPattern.flyweight.PowerBankFactory;
import com.learning.java8.utils.SnowFlake;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

@Slf4j
public class CyclicBarrierTest {

    private final SnowFlake snowFlake = new SnowFlake(31, 31);

    class Worker implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public Worker(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try {

                cyclicBarrier.await(); // 等待其它线程
                //do something...
//                System.out.println(snowFlake.nextId());
                PowerBank powerBank = (PowerBank) PowerBankFactory.usePowerBank(1);
                System.out.println(powerBank.getId() + " " + powerBank.getBrand());

            } catch (InterruptedException | BrokenBarrierException e) {
                log.error(e + "");
            }

        }

    }

    class WorkerB implements Runnable {

        private CyclicBarrier cyclicBarrier;

        public WorkerB(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {

            try {

                cyclicBarrier.await(); // 等待其它线程
                //do something...
                System.out.println(java.lang.Thread.currentThread().getName() + snowFlake.nextId());

            } catch (InterruptedException | BrokenBarrierException e) {
                log.error(e + "");
            }

        }

    }

    public void doTest() throws InterruptedException {

        final int N = 3; // 线程数
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N);
        for (int i = 0; i < N; i++) {
            new Thread(new Worker(cyclicBarrier)).start();
        }
        // CyclicBarrier可以重复使用，每满足N个await就唤醒这N个线程
//        new Thread(new WorkerB(cyclicBarrier)).start();
//        for (int i = 0; i < 4; i++) {
//            new Thread(new Worker(cyclicBarrier)).start();
//        }

    }

    public static void main(String[] args) throws InterruptedException {

        CyclicBarrierTest testCyclicBarrier = new CyclicBarrierTest();
        testCyclicBarrier.doTest();

    }

}
