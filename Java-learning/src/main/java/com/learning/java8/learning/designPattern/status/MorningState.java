package com.learning.java8.learning.designPattern.status;

public class MorningState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 9) {
            System.out.println("good morning");
        } else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
