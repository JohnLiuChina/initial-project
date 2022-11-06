package com.learning.java8.learning.lambda;

import com.learning.java8.entity.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 数据源—>stream->一系列流水线操作->新的stream，不影响数据源
 * <p>
 * 一、Stream的三个步骤
 * <p>
 * 1.创建Stream
 * <p>
 * 2.中间操作
 * <p>
 * 3.终止操作（终端操作）
 */
public class StreamCreate {
    //创建Stream
    @Test
    public void createStream() {
        //通过Collection系列集合提供的stream()——串行流 或parallelStream()——并行流
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();
        //通过Arrays中的静态方法stream()获取数组流
        Apple[] array = new Apple[10];
        Stream<Apple> stream1 = Arrays.stream(array);
        //通过Stream中的静态方法of()获取数据流
        Stream<String> stringStream = Stream.of("aa", "bb", "vccc");

        /*
         *创建无限流
         *  1.迭代
         *  2.生成
         */

        //迭代
        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 2);
        stream2.limit(2).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random())
                .limit(20).forEach(System.out::println);
    }

}
