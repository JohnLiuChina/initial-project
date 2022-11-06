package com.learning.java8.learning.lambda;

import com.learning.java8.entity.Apple;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、方法引用:若lambda体中的内容有方法已经实现了，可以使用方法引用
 * 可以理解为方法引用是lambda表达式的另外一种表现形式
 * <p>
 * 主要有三种语法格式
 * <p>
 * 对象::实例方法名
 * <p>
 * 类::静态方法名
 * <p>
 * 类::实例方法名
 * <p>
 * 注意：
 * 1.Lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的参数列表以及返回值类型保持一致
 * <p>
 * 二、构造器引用
 * <p>
 * 格式：
 * ClassName::new
 * <p>
 * 注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * <p>
 * 三、数组引用：
 * <p>
 * Type::new
 */
public class MethodRef {

    //对象::实例方法名
    @Test
    public void test1() {
        Consumer<String> consumer = (s) -> System.out.println(s);
        Consumer<String> consumer1 = System.out::println;
        Apple apple = new Apple("green", 140);
        Supplier<String> supplier = apple::getColor;
        Supplier<Long> supplier1 = apple::getWeight;
        System.out.println(supplier1.get());
    }

    //类::静态方法名
    @Test
    public void test2() {
        Comparator<Integer> comparator = Integer::compare;
    }

    //类::实例方法名
    @Test
    public void test3() {
        BiPredicate<String, String> biPredicate = (x, y) -> x.equals(y);//若expression中第一个参数是调用者，第二个是参数，可以使用类名::实例方法名替代

    }

    //构造器引用 调用的构造器参数格式与函数式接口对应
    @Test
    public void test4() {
        Supplier<Apple> supplier = () -> new Apple("l", 1);
        System.out.println(supplier.get());
    }

    //数组引用
    @Test
    public void test5() {
        Function<Integer, String[]> function = x -> new String[x];
        String[] str = function.apply(5);
        System.out.println(str.length);
        Function<Integer, String[]> fun = String[]::new;
        System.out.println(fun.apply(10).length);
    }
}
