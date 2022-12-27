package com.learning.java8;

import com.learning.java8.utils.ExecutorUtil;

import java.util.concurrent.*;

public class ThreadTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        System.out.println(tryCatch());
        System.out.println(Thread.currentThread().getName() + ":1234");
        Task task = new Task();
        task.start();
        System.out.println("MAIN IN...");
        TaskA taskA = new TaskA();
        ExecutorUtil.execute(taskA);
        TaskB taskB = new TaskB();
        Future<String> submit = ExecutorUtil.submit(taskB);
        System.out.println("MAIN done...");
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ExecutorUtil.getThreadPool().shutdown();
    }

    private static class TaskA implements Runnable{

        @Override
        public void run() {
            threadLocal.set("task a thread local var");
            String local = threadLocal.get();
//            threadLocal.remove();
            System.out.println(Thread.currentThread().getName() + "task A with" + local);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "task A out");
        }

    }

    private static class TaskB implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + "TASK B IN" + threadLocal.get());
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + "TASK B OUT");
            return "TASK B OUT";
        }
    }

    private static class Task extends Thread {
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

    private static int tryCatch() {
        try {
            System.out.println("----");
        } catch (Exception e) {
            return 2;
        } finally {
            return 1;
        }
    }

}
