package com.learning.java8;

import com.learning.java8.learning.designPattern.status.Work;

public class StatusTest {

    public static void main(String[] args) {
        Work work = new Work();
        for (int i = 6; i < 24; i++) {
            work.setHour(i);
            work.writeProgram();
        }
    }

}
