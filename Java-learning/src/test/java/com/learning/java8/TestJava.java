package com.learning.java8;

import com.learning.java8.service.Abstract;
import com.learning.java8.service.TestService;
import com.learning.java8.service.impl.TestServiceImpl;
import com.learning.java8.service.impl.TestServiceImpl1;

public class TestJava {

    static class AbstractE extends Abstract{
        @Override
        public void functionA() {
            System.out.println("AbstractAbstractAbstract");
        }
    }

    public static void main(String[] args) {
        System.out.println("----------");
        //[类型] 变量名 = new 构造函数;
        TestService testService = new TestServiceImpl();
        System.out.println(testService.getcurrentTime());

        testService = new TestServiceImpl1();
        System.out.println(testService.getcurrentTime());


        Abstract ab = new AbstractE();
        ab.functionA();

    }

}
