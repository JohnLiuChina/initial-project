package com.learning.java8.learning.designPattern.memento;

public class Originator {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveState() {
        return new Memento(this.getState());
    }

    public void recoverState(Memento memento) {
        this.setState(memento.getState());
    }

}
