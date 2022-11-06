package com.learning.java8.exam;

import java.util.HashSet;
import java.util.Set;

/**
 * 全排列
 * ex:ABA->{ABA, BAA, AAB}
 */
public class Permutation {

    private static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        String str = "aba";
        dealing(str.toCharArray(), 0, str.length());
        System.out.println(result);
    }

    private static void dealing(char[] arr, int begin, int end){
        if(begin == end){
            result.add(new String(arr));
            return;
        }
        for(int i = begin; i < arr.length; i++){
            swap(arr, i, begin);
            dealing(arr, begin + 1, end);
            swap(arr, i, begin);
        }
    }

    private static void swap(char[] arr, int begin, int end){
        char temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

}
