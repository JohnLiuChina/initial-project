package com.learning.java8.learning.designPattern.composite.transparent;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

    private String name;

    private List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    @Override
    public void printStruct() {
        System.out.println(name + " children:");
        children.forEach(Component::printStruct);
    }

    @Override
    public void addChild(Component component) {
        children.add(component);
    }

    @Override
    public void removeChild(int index) {
        children.remove(index);
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

}
