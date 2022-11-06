package com.learning.java8.exam;

import java.util.*;

public class Exam {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 44, 44, 53, 42, 34,3, 23, 2,4, 5,1,3,5, 6,33,867};
        TreeSet treeSet = new TreeSet();
        Arrays.stream(arr).forEach(treeSet::add);
        treeSet.forEach(System.out::println);
        List<String> resultList = new ArrayList<>();

        String hex = "0xA";
        Integer value = Integer.parseInt("A", 16);
        System.out.println(value);

        long a = 13;
        Math.sqrt(a);

        for(int i = 0; i < 4; i++){
            System.out.println(i);
        }

        float f = 1.23f;
        float ff = 1.9f;
        System.out.println((int) f);
        System.out.println((int) ff);

        String[] arra = {"a"};
        String v = "";


    }

}
