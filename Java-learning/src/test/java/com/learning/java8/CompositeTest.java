package com.learning.java8;

import com.learning.java8.learning.designPattern.composite.safe.Composite;
import com.learning.java8.learning.designPattern.composite.safe.Leaf;
import com.learning.java8.learning.designPattern.composite.transparent.Component;

public class CompositeTest {
    public static void main(String[] args) {

        //safe
        Composite root = new Composite("服装");
        Composite c1 = new Composite("男装");
        Composite c2 = new Composite("女装");
        Leaf leaf1 = new Leaf("衬衫");
        Leaf leaf2 = new Leaf("夹克");
        Leaf leaf3 = new Leaf("裙子");
        Leaf leaf4 = new Leaf("套装");

        root.addChild(c1);
        root.addChild(c2);
        c1.addChild(leaf1);
        c1.addChild(leaf2);
        c2.addChild(leaf3);
        c2.addChild(leaf4);

        root.printStruct();

        //transparent
        Component root1 = new com.learning.java8.learning.designPattern.composite.transparent.Composite("服装");
        Component c3 = new com.learning.java8.learning.designPattern.composite.transparent.Composite("男装");
        Component c4 = new com.learning.java8.learning.designPattern.composite.transparent.Composite("女装");
        Component leaf5 = new com.learning.java8.learning.designPattern.composite.transparent.Leaf("衬衫");
        Component leaf6 = new com.learning.java8.learning.designPattern.composite.transparent.Leaf("夹克");
        Component leaf7 = new com.learning.java8.learning.designPattern.composite.transparent.Leaf("裙子");
        Component leaf8 = new com.learning.java8.learning.designPattern.composite.transparent.Leaf("套装");

        root1.addChild(c3);
        root1.addChild(c4);
        c3.addChild(leaf5);
        c3.addChild(leaf6);
        c4.addChild(leaf7);
        c4.addChild(leaf8);
        root1.printStruct();

    }
}
