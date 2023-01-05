package com.learning.java8.learning.designPattern.status;

public class Work {

    private int hour;

    private boolean isFinish;

    private State state;

    public Work() {
        state = new MorningState();
    }

    public void writeProgram() {
        state.writeProgram(this);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
