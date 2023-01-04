package com.learning.java8;

public class Text {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,24,20,9};
        System.out.println(combine(arr));
    }

    public static void handle(int code){
        switch(code) {
            case 1:
                System.out.println("ss");
                break;
            case 2:
                ;
        }
    }

    public static String combine(int[] array) {
        for(int i = 0; i < array.length; i++){
            for(int j = i + 1; j < array.length; j++) {
                int tempA = Integer.parseInt(String.valueOf(array[i]) + String.valueOf(array[j]));
                int tempB = Integer.parseInt(String.valueOf(array[j]) + String.valueOf(array[i]));
                if(tempA < tempB){
                    swap(array, i, j);
                }
            }
        }

        String resultStr = "";
        for(int i = 0; i < array.length; i++) {
            resultStr += array[i];
        }
        return resultStr;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
