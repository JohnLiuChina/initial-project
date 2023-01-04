package com.learning.java8.learning.designPattern.composite.safe;

import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {

    private List<Component> childComponents = new ArrayList<>();

    private String name;

    public Composite(String name) {
        this.name = name;
    }

    public void addChild(Component child) {
        childComponents.add(child);
    }

    public void removeChild(int index) {
        childComponents.remove(index);
    }

    public List<Component> getChildren() {
        return childComponents;
    }

    @Override
    public void printStruct() {
        System.out.println(name + " children: ");
        childComponents.forEach(Component::printStruct);
    }


}
