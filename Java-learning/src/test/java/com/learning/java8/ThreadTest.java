package com.learning.java8;

public class ThreadTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":1234");
        Task task = new Task();
        task.start();
        System.out.println("waiting...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Task extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":shopping");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":shopping over");
        }
    }

}
