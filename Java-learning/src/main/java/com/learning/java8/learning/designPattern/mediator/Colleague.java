package com.learning.java8.learning.designPattern.mediator;

public abstract class Colleague {

    protected String name;

    protected Mediator mediator;

    public Colleague(Mediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void getMessage(String message, String fromName);

    public abstract void contact(String message, String ... toColleagueNames);

}
