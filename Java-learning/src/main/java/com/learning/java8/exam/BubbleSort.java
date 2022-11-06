package com.learning.java8.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {
        List<Integer> randomList = Arrays.asList(14, 2423, 3123, 41, 1, 35, 641, 37, 18);
        int size = randomList.size();
        int cnt = 0;
        //i < size - 1 : N个数字要排N-1次
        for(int i = 0; i < size - 1; i++){
            cnt++;
            //j < size -1 : 每一趟会排好一位，所以下一次需要排序的元素就会少一个，即每i趟排N-i次，内外的减一都是因为从零开始
            for(int j = 0; j < size - 1 - i; j++){
                if(randomList.get(j) < randomList.get(j + 1)){
                    int temp = randomList.get(j);
                    randomList.set(j, randomList.get(j + 1));
                    randomList.set(j + 1, temp);
                }
            }
        }
        System.out.println(randomList);
        System.out.println(cnt);
    }

}
