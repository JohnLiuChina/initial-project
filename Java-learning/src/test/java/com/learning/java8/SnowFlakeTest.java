package com.learning.java8;

import com.alibaba.fastjson.JSONObject;
import com.learning.java8.utils.SnowFlake;
import lombok.Data;
import org.junit.Test;

import javax.swing.plaf.BorderUIResource;
import java.util.ArrayList;
import java.util.List;

public class SnowFlakeTest {

    @Test
    public void snowFlake() {

        SnowFlake snowFlake = new SnowFlake(31, 31);
        System.out.println(snowFlake.nextId());
        System.out.println(snowFlake.nextId());

    }

    @Test
    public void test(){
        String str = "aaddads";
        char[] arr = str.toCharArray();
        List<String> strings = new ArrayList<>();
        List<Integer> integers = new ArrayList<>();
        strings.add("a");
        strings.add("vb");
        strings.add("n");
        integers.add(1);
        integers.add(14);
        integers.add(15);
        integers.add(16);
        t(arr, strings, integers);
    }

    private void t(char[] arr, List<String> strings, List<Integer> integers){
        System.out.println(arr);
        System.out.println(strings);
        System.out.println(integers);
        arr[0] = 'A';
        strings.remove(strings.size() - 1);
        integers.add(234);
        b(arr, strings, integers);
        System.out.println(arr);
        System.out.println(strings);
        System.out.println(integers);
    }

    private void b(char[] arr, List<String> strings, List<Integer> integers){
        System.out.println(arr);
        System.out.println(strings);
        System.out.println(integers);
    }

    @Data
    class Node{

        private Integer value;
        private Node left;
        private Node right;

        public Node(Integer value, Node left, Node right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    class Lock{
        public synchronized void a() throws Exception{
            System.out.println("a-a-a-a-a-a-a");
            Thread.sleep(5000);
        }
        public synchronized void b() throws Exception{
            System.out.println("b'b'b'b'b'b'b");
            Thread.sleep(5000);
        }
    }

    @Test
    public void tree(){

        Lock lock = new Lock();
        try {
            Thread a = new Thread(() -> {
                try {
                    lock.a();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            Thread b = new Thread(() -> {
                try {
                    lock.b();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            a.start();
            b.start();
        }catch (Exception e){
            e.printStackTrace();
        }

        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
