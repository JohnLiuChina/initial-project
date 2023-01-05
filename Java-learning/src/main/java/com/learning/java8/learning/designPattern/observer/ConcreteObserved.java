package com.learning.java8.learning.designPattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteObserved implements Observed {

    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver(String message) {
        observers.forEach(a -> {
            a.update(message);
        });
    }

}
