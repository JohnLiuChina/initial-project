package com.learning.java8.learning.lambda;

import com.learning.java8.entity.Apple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
public class StreamDoSomething {

    List<Apple> list = Arrays.asList(
            new Apple("red", 200),
            new Apple("blue", 210),
            new Apple("white", 20),
            new Apple("yellow", 304),
            new Apple("yellow", 304)
    );

    //内部迭代：迭代操作由Stream API完成
    @Test
    public void test1(){
        Stream<Apple> stream = list.stream().filter(a -> {
            System.out.println("------------------");
            return a.getWeight() >= 200;});
//        stream.forEach(System.out::println);
    }

    @Test
    public void filter(){
        list.stream().filter(a -> a.getColor().equals("red")).limit(1).forEach(System.out::println);
    }

    @Test
    public void skip(){
        list.stream().skip(3).forEach(System.out::println);
    }

    //distinct接口通过hashCode和equals实现的，所以需要重写hashCode和equals接口
    @Test
    public void distinct(){
        list.stream().distinct().forEach(System.out::println);
    }

    /**
     * 映射
     * map——接收lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * flapMap——接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流连接成一个流
     */
    @Test
    public void map(){
        List<String> strings = Arrays.asList("aaa", "bsdfk");
        strings.stream().map(s -> s.toUpperCase()).forEach(System.out::println);
        list.stream().map(Apple::getColor).forEach(System.out::println);

        list.stream().map(apple -> filterCharacter(apple.getColor())).forEach(s -> s.forEach(System.out::println));
    }

    public Stream<Character> filterCharacter(String str){
        List<Character> result = new ArrayList<>();
        for (Character ch : str.toCharArray()){
            result.add(ch);
        }
        return result.stream();
    }

    @Test
    public void flatMap(){
        list.stream()
                .flatMap(apple -> filterCharacter(apple.getColor())).forEach(System.out::println);
        List<String> a = Arrays.asList("aaa", "ssf");
        List b = new ArrayList<>();
        b.add(a);
        b.stream().forEach(System.out::println);
    }

    /**
     * sorted()——自然排序Comparable
     * sorted(Comparator com)——定制排序
     */
    @Test
    public void sort(){
        list.stream().sorted((a, b) -> {
            if(a.getColor().equals(b.getColor())){
                return a.getWeight().compareTo(b.getWeight());
            }else{
                return a.getColor().compareTo(b.getColor());
            }
        }).forEach(System.out::println);
    }

    public enum OPERATE_ACTION {
        start, stop, reboot, delete, sync, associate, unassociate, create, update, attach, detach
    }

    @Test
    public void enumTest(){
        StringBuilder stringBuilder = new StringBuilder("q");
        String s = "q";
        System.out.println(stringBuilder.equals(s));
    }

    @Test
    public void testOr(){
        System.out.println(false || false);
    }

    @Test
    public void testTryCatch(){
        int []arr = {1, 2, 3, 4};
        try {
            try {
                int num_a = arr[4];
            }catch (Exception e){
                System.out.println("inside:" + e);
            }
            System.out.println("inside continue");
        }catch (Exception e){
            System.out.println("outside:" + e);
        }
        System.out.println("outside continue");
    }

    @Test
    public void testPlus(){
        Integer i = 0;
        plus(i);
        System.out.println(i);
    }

    public void plus(Integer i){
        i++;
        System.out.println(i);
    }
}
