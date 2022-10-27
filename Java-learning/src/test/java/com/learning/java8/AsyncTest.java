package com.learning.java8;

import com.learning.java8.utils.ExecutorUtil;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AsyncTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        ExecutorUtil.execute(() -> System.out.println(Thread.currentThread().getName() + ":async testing"));
        Task task = new Task();
        Future<String> future = ExecutorUtil.submit(task);
        System.out.println("async call over from main");
        String asyncResult = future.get();
        System.out.println("async result:" + asyncResult);
    }

    private static class Worker implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":async testing from Worker");
        }

    }

    private static class Task implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName() + ":do sth from Task with return");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ":task done");
            return "success";
        }

    }

}
