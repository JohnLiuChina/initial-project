package com.learning.java8.test;

import com.learning.java8.entity.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterApple {
    public static List<Apple> findGreenApple(List<Apple> apples) {

        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Apple> list = Arrays.asList(
                new Apple("green", 150),
                new Apple("blue", 150),
                new Apple("red", 150),
                new Apple("black", 150),
                new Apple("green", 150),
                new Apple("green", 150)
        );
        List<Apple> greenApples = findGreenApple(list);

        System.out.println(findGreenApple(list));

        Apple apple = new Apple("red", 110);
        Apple blue = new Apple("rrr", 20);
        blue.setColor(apple.getColor());
        apple.setColor("a");
        blue.setWeight(apple.getWeight());
        apple.setWeight(1L);
        System.out.println(blue);
    }
}
