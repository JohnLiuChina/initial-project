package com.learning.java8.utils;

public class MonitorUtil {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void start(){
        threadLocal.set(System.currentTimeMillis());
    }

    public static void finish(String methodName){
        System.out.println(methodName + "耗时：" + (System.currentTimeMillis() - threadLocal.get()) + "ms");
    }

}
