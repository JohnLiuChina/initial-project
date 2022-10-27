package com.learning.java8.learning.lambda;

import com.google.common.base.Function;
import com.learning.java8.entity.Apple;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ps : expression是实现，还需要调用
 */
public class LambdaExpression {
    public static void main(String[] args) {
        Comparator<Apple> byColor = new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        };

        List<Apple> list = Collections.emptyList();

        list.sort(byColor);

        Comparator<Apple> byColor2 = (o1, o2) -> o1.getColor().compareTo(o2.getColor());

        list.sort(byColor2);

        Runnable i = () -> {
        };

        Function<String, String> stringStringFunction = (String str) -> {
            return "123";
        };
    }
}
