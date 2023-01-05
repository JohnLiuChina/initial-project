package com.learning.java8.learning.designPattern.mediator;

public interface Mediator {

    void addColleague(Colleague colleague);

    void contact(String message, String fromName, String ... toName);

}
