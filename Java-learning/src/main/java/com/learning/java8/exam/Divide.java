package com.learning.java8.exam;

public class Divide {

    public static void main(String[] args) {
        System.out.println(divide(-3, -2));
    }

    private static int dividePlus(int dividend, int divisor) {
        boolean flag = false;
        if (dividend < 0 || divisor < 0) {
            if (divisor > 0 || dividend > 0) {
                flag = true;
            }
        }
        String dividendStr = dividend > 0 ? String.valueOf(dividend) : String.valueOf(dividend).substring(1);
        String divisorStr = divisor > 0 ? String.valueOf(divisor) : String.valueOf(divisor).substring(1);
        return 0;
    }

    private static int divide(int dividend, int divisor) {
        if (-2147483648 == dividend) {
            if (divisor == -1) {
                return 2147483647;
            }
            if (divisor == 1) {
                return -2147483648;
            }
        }
        boolean flag = false;
        if (dividend < 0 || divisor < 0) {
            if (divisor > 0 || dividend > 0) {
                flag = true;
            }
        }
        long i = Math.abs((long) dividend);
        long j = Math.abs((long) divisor);
        int result = 0;
        while (i >= 0) {
            i -= j;
            if (i >= 0) {
                result++;
            }
        }
        return flag ? -result : result;
    }

}
