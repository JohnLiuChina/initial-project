package com.learning.java8.learning.designPattern.observer;

public interface Observed {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObserver(String message);

}
