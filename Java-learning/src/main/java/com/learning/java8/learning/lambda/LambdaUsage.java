package com.learning.java8.learning.lambda;

import com.learning.java8.entity.Apple;

import java.util.*;
import java.util.function.*;

public class LambdaUsage {

    private static List<Apple> filter(List<Apple> sourceList, Predicate<Apple> predicate) {
        List<Apple> result = new ArrayList();
        for (Apple a : sourceList) {
            if (predicate.test(a))
                result.add(a);
        }
        return result;
    }

    private static List<Apple> filterByWeight(List<Apple> sourceList, LongPredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : sourceList) {
            if (predicate.test(a.getWeight()))
                result.add(a);
        }
        return result;
    }

    private static List<Apple> filterByColorAndWeight(List<Apple> sourceList, BiPredicate<String, Long> predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple a : sourceList) {
            if (predicate.test(a.getColor(), a.getWeight()))
                result.add(a);
        }
        return result;
    }

    private static void simpleTestConsumer(List<Apple> sourceList, Consumer<Apple> consumer) {
        for (Apple a : sourceList) {
            consumer.accept(a);
        }
    }

    private static void simpleBiConsumer(List<Apple> sourceList, BiConsumer<Apple, String> consumer) {
        for (Apple a : sourceList) {
            consumer.accept(a, a.getColor());
        }
    }

    private static String testFunction(Apple apple, Function<Apple, String> function) {
        return function.apply(apple);
    }

    private static Apple testBiFunction(String str, Long l, BiFunction<String, Long, Apple> function) {
        return function.apply(str, l);
    }

    private static Apple testSupplier(Supplier<Apple> supplier) {
        return supplier.get();
    }

    @FunctionalInterface
    public interface Adder {
        int add(int a, int b);
    }

    public interface SmartAdder extends Adder {
        int add(long a, long b);
    }

    @FunctionalInterface
    public interface Empty extends Adder {

    }

    public static void main(String[] args) {
//        Runnable r1 = ()->System.out.println("hello");
//        Runnable r2 = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        };
//        process(r1);
//        process(r2);
//        process(()->System.out.println("hello"));
        List<Apple> list = Arrays.asList(new Apple("green", 150),
                new Apple("blue", 120),
                new Apple("red", 350));
        System.out.println(filter(list, apple -> apple.getColor().equals("blue")));
        System.out.println(filterByWeight(list, weight -> weight > 100));
        System.out.println(filterByColorAndWeight(list, (color, weight) -> color.equals("green") && weight > 100));
        simpleTestConsumer(list, a -> System.out.println(a));
        simpleBiConsumer(list, (a, s) -> System.out.println(a + s));
        System.out.println(testFunction(new Apple("green", 150), a -> String.valueOf(a.getWeight() * 10)));
        IntFunction<Double> intFunction = i -> i * 100.0;
        System.out.println(intFunction.apply(57));
        System.out.println(testBiFunction("purple", 137L, (String s, Long w) -> new Apple(s, w)));
        Supplier<String> s = String::new;
        System.out.println(s.get().getClass());
        System.out.println(testSupplier(() -> new Apple("red", 10)));
        Comparator<Integer> comparator = Integer::compare;
        TreeSet<Integer> ts = new TreeSet<>(comparator);
        Runnable runnable = () -> {
        };
        process(runnable);

        Collections.sort(list, (a, b) -> (int) (a.getWeight() - b.getWeight()));
        list.forEach((apple) -> {
            System.out.println(apple.toString());
        });
    }

    public static void process(Runnable runnable) {
        runnable.run();
    }
}
