package com.learning.java8;

import org.apache.ibatis.annotations.Param;
import org.junit.Test;

public class SychronizedTest {

    public static class SuperClass{
        static {
            System.out.println("super init");
        }
        public final static int value = 1;
    }

    public static class SubClass extends SuperClass{
        static {
            System.out.println("sub init");
        }
    }

    class Worker{

        private Object lock = new Object();

        public void sleep(){
            synchronized (lock){
                System.out.println("begin sleeping" + System.currentTimeMillis());
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("stop sleeping" + System.currentTimeMillis());
            }
        }

        public void drink(){
            synchronized (this){
                System.out.println("begin drinking" + System.currentTimeMillis());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("stop drinking" + System.currentTimeMillis());
            }
        }

    }

    @Test
    public void workerTest() throws InterruptedException {
        Worker worker = new Worker();
        Thread a = new Thread(worker::drink);
        Thread b = new Thread(worker::sleep);
        a.start();
        b.start();
        Thread.sleep(10000);
    }

    @Test
    public void init(){
        System.out.println(SubClass.value);
    }

}
