package com.learning.java8.learning.lambda;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java8 内置四大核心函数式接口
 * Consumer<T>:消费型接口
 * void accept(T t);
 * Supplier<T>:供给型接口
 * T get();
 * Function<T, R>:函数型接口
 * R apply(T t);
 * Predicate<T>:断言型接口
 * boolean test(T t);
 */
public class LambdaInterface {

    //Consumer
    @Test
    public void testConsumer() {
        consumer(10100d, m -> {
            m = m * 2;
            System.out.println(m);
        });
    }

    public void consumer(double money, Consumer<Double> consumer) {
        consumer.accept(money);
    }

    //Supplier
    @Test
    public void testSupplier() {
        List<Integer> list = getNumList(10, () -> (int) (Math.random() * 100));
        list.forEach((integer -> System.out.println(integer)));
    }

    public List<Integer> getNumList(int num, Supplier<Integer> supplier) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < num; i++) {
            result.add(supplier.get());
        }
        return result;
    }

    //Function
    @Test
    public void testFunction() {
        System.out.println(strHandler("\t\t\t sajkldjals d \t\t   ", (s) -> s.trim()));
    }

    public String strHandler(String str, Function<String, String> function) {
        return function.apply(str);
    }

    //Predicate
    @Test
    public void testPredicate() {
        List<String> strings = Arrays.asList("adafdaf", "dsafadf", "dsagfdgsfs", "ewafrfsf");
        filterStr(strings, s -> s.contains("w")).forEach(System.out::println);
    }

    public List<String> filterStr(List<String> list, Predicate<String> predicate) {
        ArrayList<String> result = new ArrayList<>();
        for (String s : list) {
            if (predicate.test(s))
                result.add(s);
        }
        return result;
    }

}
