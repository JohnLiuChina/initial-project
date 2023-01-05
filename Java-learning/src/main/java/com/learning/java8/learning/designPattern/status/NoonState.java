package com.learning.java8.learning.designPattern.status;

public class NoonState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 17 && work.getHour() >= 9) {
            System.out.println("good noon");
        } else {
            work.setState(new EveningState());
            work.writeProgram();
        }
    }
}
