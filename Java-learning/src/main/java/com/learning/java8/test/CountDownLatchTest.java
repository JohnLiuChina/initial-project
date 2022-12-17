package com.learning.java8.test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        new Thread(new Leader(latch)).start();
        new Thread(new Leader(latch)).start();
        for (int i = 0; i < 5; i++) {
            new Thread(new Worker(latch)).start();
        }
    }

    private static class Worker implements Runnable {
        private CountDownLatch latch;
        private Worker(){};
        public Worker(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + latch.getCount());
            latch.countDown();
        }
    }

    private static class Leader implements Runnable{

        private CountDownLatch latch;

        public Leader(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                System.out.println("Leader waiting");
                latch.await();
                System.out.println("Leader waiting over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
