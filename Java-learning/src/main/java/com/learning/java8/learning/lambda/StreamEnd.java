package com.learning.java8.learning.lambda;

import com.alibaba.fastjson.JSONObject;
import com.learning.java8.entity.Apple;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 数据源—>stream->一系列流水线操作->新的stream，不影响数据源
 *
 * 一、Stream的三个步骤
 *
 *  1.创建Stream
 *
 *  2.中间操作
 *
 *  3.终止操作（终端操作）
 *
 */
public class StreamEnd {
    List<Apple> list = Arrays.asList(
            new Apple("red", 200L, Apple.Status.BUSY),
            new Apple("blue", 210L, Apple.Status.FREE),
            new Apple("white", 20L, Apple.Status.BUSY),
            new Apple("yellow", 304L, Apple.Status.VOCATION),
            new Apple("yellow", 304L, Apple.Status.VOCATION)
    );
    /**
     * 查找与匹配
     * allMatch——检查是否匹配所有元素
     * anyMatch——检查是否至少匹配一个元素
     * noneMatch——检查是否没有匹配所有元素
     * findFirst——返回当前流中的第一个元素
     * findAny——返回当前流中的任意元素
     * count——返回流中的元素总数
     * max/min——返回流中的最大/小值
     */
    @Test
    public void test(){
        System.out.println(list.stream()
                .allMatch(apple -> apple.getStatus().equals(Apple.Status.BUSY)));
        System.out.println(list.stream()
                .anyMatch(apple -> apple.getStatus().equals(Apple.Status.VOCATION)));
        System.out.println(list.stream()
                .noneMatch(apple -> apple.getStatus().equals(2)));
        Optional<Apple> optionalApple = list.stream()
                .sorted(Comparator.comparing(Apple::getWeight))
                .findFirst();
        System.out.println(optionalApple.get());

        Optional<Apple> optionalAppleFree = list.stream()
                .filter(apple -> apple.getStatus().equals(Apple.Status.VOCATION))
                .findAny();
        System.out.println(optionalAppleFree.get());

        Optional<Long> longOptional = list.stream()
                .map(Apple::getWeight)
                .min(Long::compareTo);
        System.out.println(longOptional.get());
    }

    /**
     * 归约
     * reduce(T identity, BinaryOperator) / reduce(BinaryOperator)——可以将流中的元素反复结合起来，得到一个值
     */
    @Test
    public void reduce(){
        List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        int sum = list.stream().reduce(0, Integer::sum);

        System.out.println(sum);

        Optional<Long> weightSum = this.list.stream()
                .map(Apple::getWeight)
                .reduce(Long::sum);

        long wL = this.list.stream()
                .map(Apple::getWeight)
                .reduce(0L, Long::sum);

        System.out.println(weightSum.get() + wL);
    }

    /**
     * 收集
     * collect——将流转换为其他形式，接收一个Collector接口的实现，用于给stream中元素做汇总的方法
     */
    @Test
    public void collect(){
        List<String> l = list.stream()
                .map(Apple::getColor)
                .collect(Collectors.toList());
        System.out.println(l);

        Set<String> set = list.stream()
                .map(Apple::getColor)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        LinkedList<String> linkedList=  list.stream()
                .map(Apple::getColor)
                .collect(Collectors.toCollection(LinkedList::new));
        linkedList.forEach(System.out::println);

        long count = list.stream().count();

        double avg = list.stream()
                .collect(Collectors.averagingLong(Apple::getWeight));

        double avgg = list.stream()
                .map(Apple::getWeight)
                .collect(Collectors.averagingLong(a -> a));

        System.out.println(count);
        System.out.println(avgg);
    }

    /**
     * 分组
     */
    @Test
    public void group(){
        Map<Apple.Status, List<Apple>> apples = list.stream()
                .collect(Collectors.groupingBy(Apple::getStatus));
        apples.forEach((a, b) -> System.out.println(a + ":" + b));
    }

    /**
     * 多级分组
     */
    @Test
    public void multipleGroup(){
        Map<Apple.Status, Map<String, List<Apple>>> multipleGroup = list.stream()
                .collect(Collectors.groupingBy(Apple::getStatus, Collectors.groupingBy(Apple::getColor)));
        multipleGroup.forEach((m, v) -> System.out.println(m + ":" + v));
    }

    /**
     * 分区
     */
    @Test
    public void partition(){
        Map<Boolean, List<Apple>> map = list.stream()
                .collect(Collectors.partitioningBy(a -> a.getWeight() >= 150));
        System.out.println(map.get(true));
    }

    /**
     * 统计
     */
    @Test
    public void statistic(){
        LongSummaryStatistics longSummaryStatistics = list.stream()
                .collect(Collectors.summarizingLong(Apple::getWeight));
        System.out.println(longSummaryStatistics.getAverage());
        System.out.println(longSummaryStatistics.getMax());
        System.out.println(longSummaryStatistics.getCount());
        System.out.println(longSummaryStatistics.getMin());
        System.out.println(longSummaryStatistics.getSum());
    }

    /**
     * 连接
     */
    @Test
    public void joining(){
        String str = list.stream()
                .map(Apple::getColor)
                .collect(Collectors.joining(",", "B", "E"));
        System.out.println(str);
    }

    @Test
    public void testing(){
        Integer[] nums = new Integer[]{1,2,3,4,5,6,7};
        Arrays.stream(nums)
                .map(n -> n * n)
                .forEach(System.out::println);

        int result = Arrays.stream(nums)
                .reduce(0, (a, b) -> a + b);
        System.out.println(result);
    }

    @Test
    public void forEach(){
//        list.forEach(System.out::println);
//
//        list.forEach(l -> {
//            l.setColor("222222");
//        });
//
//        list.forEach(System.out::println);

        List<String> strings = new ArrayList<>();
        strings.forEach(System.out::println);
    }

    @Test
    public void regex(){
        String content = "a22";

        String pattern = "^([\\u4e00-\\u9fa5]*$|[A-Za-z]*)$[^@/:=”<>{\\[\\]}\\s\\x22]+.{2,128}$";

        String p1 = "^([\\u4e00-\\u9fa5]|[A-Za-z][^@/:=”<>{\\[\\]}\\s\\x22])$";

        String p2 = "^(0|[1-9][0-9]*)$";

        boolean isMatch = Pattern.matches(p1, content);
        System.out.println(isMatch);
    }


    public static final int a = 1;
    @Test
    public void listlist(){
        String s = String.valueOf(a);
        System.out.println(s);
    }

    @Test
    public void list(){
        Apple apple = new Apple();
        List<Apple> list = new ArrayList<>();
        for(int i = 0; i < 4; i++){
            apple.setWeight((long)i);
            list.add((Apple) apple.clone());
        }
        System.out.println(list);
        System.out.println(list.stream().filter(apple1 -> apple1.getWeight() == 1).count());
    }

    @Test
    public void nul(){
        System.out.println((double) 16383 / 1024);
    }

    @Test
    public void testEmpty(){
        List<String> strings = new ArrayList<>();
        strings.forEach(System.out::println);
    }

    @Test
    public void emptyFilter(){
        List<String> strings = Arrays.asList("1", "2", "3");
        strings = strings.stream()
                .filter(str -> str.equals("1"))
                .collect(Collectors.toList());
        System.out.println(strings);
    }

    @Test
    public void finallyTest(){
        int i = 1;
        try{
            if(i == 1)
                return;
        }finally {
            System.out.println("finally after return of try");
        }
    }

    @Test
    public void testJson(){
        Map<String, String> map = new HashMap<>();
        map.put("1", "2");
        System.out.println(map.toString());
    }

    @Test
    public void testReplace(){
        String uri = "/hcmp/code";
        String[] secondStep = uri.split("/");
        System.out.println(secondStep.length);
        String placeholder = "";
        for(int i = 0; i < secondStep.length - 1; i++){
            placeholder = placeholder.concat(secondStep[i].concat("/"));
        }
        String result = placeholder.concat("PathVariable");
        System.out.println(JSONObject.toJSONString(result));
    }
}
