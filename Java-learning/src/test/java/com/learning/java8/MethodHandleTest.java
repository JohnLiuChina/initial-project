package com.learning.java8;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MethodHandleTest {
    public int a=0;
    static Integer si=6;
    String s="Hello world";

    public MethodHandleTest(int d){

    }

    private void do1(){
        a++;
        System.out.println(a);

    }
}

class Study1 {
    public static void main(String[] args) throws Throwable {
        MethodType methodType= MethodType.methodType(Void.TYPE);


        MethodHandleTest test1=new MethodHandleTest(4);


        MethodHandle methodHandle2= MethodHandles.lookup().findVirtual(
                MethodHandleTest.class,"do1",methodType
        );

        methodHandle2.invokeExact(test1);
    }
    public void do1(){
        do2();
    }
    public void do2(){
        System.out.println("12");
    }
}
