package com.learning.java8.exam;

import com.alibaba.fastjson.JSONObject;
import org.omg.CORBA.MARSHAL;

import java.util.*;

public class MultiplicationWithString {
    public static void main(String[] args) {
        int a = 16;
        int b = 15;
        System.out.println(~ 4);
        System.out.println(multiply("1234", "567"));
    }

    /**
     * 1234
     *  567
     *
     * @param num1
     * @param num2
     * @return
     */
    private static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String result = "";
        for(int i = num1.length() - 1; i >= 0; i--) {
            String temp = "";
            // 补末位0
            for(int j = 0; j < num1.length() - 1 - i; j++) {
                temp = temp + "0";
            }
            int a = num1.charAt(i) - '0';
            int add = 0;
            for(int j = num2.length() - 1; j >=0; j--) {
                int b = num2.charAt(j) - '0';
                int t = (a * b + add);
                temp = t % 10 + temp;
                add = t / 10;
            }
            if (add > 0) {
                temp = add + temp;
            }
            result = plus(result, temp);
        }
        return result;
    }

    private static String plus(String num1, String num2) {
        String result = "";
        String a = num1.length() >= num2.length() ? num1 : num2;
        String b = num1.length() >= num2.length() ? num2 : num1;
        boolean flag = false;
        for (int i = 0; i < a.length(); i++) {
            int curA = a.charAt(a.length() - 1 - i) - 48;
            int curB = 0;
            if (b.length() - 1 - i >= 0) {
                curB = b.charAt(b.length() - 1 - i) - 48;
            }
            int pre = flag ? (curA + curB + 1) : curA + curB;
            int temp = pre % 10;
            if (pre >= 10) {
                flag = true;
            } else {
                flag = false;
            }
            result = temp + result;
        }
        return flag ? "1" + result : result;
    }
}

