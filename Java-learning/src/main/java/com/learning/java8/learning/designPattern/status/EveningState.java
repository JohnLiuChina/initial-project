package com.learning.java8.learning.designPattern.status;

public class EveningState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() >= 17) {
            System.out.println("good evening");
        }
    }
}
