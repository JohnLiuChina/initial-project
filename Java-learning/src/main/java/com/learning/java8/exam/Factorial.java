package com.learning.java8.exam;

/**
 * 阶乘
 */
public class Factorial {

    public static void main(String[] args) {
        factorial(5);
    }

    public static void factorial(int number){
        multiply(number, number);
    }

    public static void multiply(int number, int result){
        if(number == 1){
            System.out.println(result);
            return;
        }
        multiply(number - 1, result = result * (number - 1));
    }

}
