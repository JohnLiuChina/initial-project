package com.learning.java8;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int cnt = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < size; i++){
            int input = sc.nextInt();
            list.add(input);
        }
        bubble(list);
        for(int i = 0; i < cnt; i++){
            System.out.print(list.get(i) + " ");
        }

    }

    private static void bubble(List<Integer> list){

        for(int i = 0; i < list.size() - 1; i++){
            for(int j = 0; j < list.size() - 1 - i; j++){
                if(list.get(j) > list.get(j + 1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }

    }

}
