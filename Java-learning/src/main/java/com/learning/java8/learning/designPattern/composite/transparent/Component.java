package com.learning.java8.learning.designPattern.composite.transparent;

import java.util.List;

/**
 * 透明合成，优点：客户端无需再关心操作的对象类型，均为Component
 */
public abstract class Component {

    public abstract void printStruct();

    public void addChild(Component component) {
        throw new UnsupportedOperationException("unSupported operation");
    }

    public void removeChild(int index) {
        throw new UnsupportedOperationException("unSupported operation");
    }

    public List<Component> getChildren() {
        throw new UnsupportedOperationException("unSupported operation");
    }

}
