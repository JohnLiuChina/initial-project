package com.learning.java8.learning.designPattern.mediator;

import java.util.HashMap;
import java.util.Map;

public class ConcreteMediator implements Mediator {

    private Map<String, Colleague> colleagueMap = new HashMap<>();

    @Override
    public void addColleague(Colleague colleague) {
        colleagueMap.put(colleague.name, colleague);
    }

    @Override
    public void contact(String message, String fromName, String... toName) {
        for (String to : toName) {
            Colleague colleague = colleagueMap.get(to);
            if (colleague != null) {
                colleague.getMessage(message, fromName);
            }
        }
    }
}
