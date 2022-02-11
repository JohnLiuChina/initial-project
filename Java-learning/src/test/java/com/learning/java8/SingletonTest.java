package com.learning.java8;

import org.junit.Test;

public class SingletonTest {

    static class Volatile{
        private static String instance = null;
    }

    @Test
    public void test(){
        for (int i = 0; i < 10; i++){
            Thread setWorker = new Thread(this::setInstance);
            setWorker.start();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void setInstance(){
        if(Volatile.instance == null){
            System.out.println("pre to set value of instance");
            Volatile.instance = String.valueOf(Math.random());
            System.out.println("post to set value of instance");
        }else {
            System.out.println("Volatile.instance:" + Volatile.instance);
        }
    }

}
