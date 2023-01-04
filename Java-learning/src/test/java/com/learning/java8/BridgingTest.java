package com.learning.java8;

import com.learning.java8.learning.designPattern.bridging.abstraction.Cake;
import com.learning.java8.learning.designPattern.bridging.abstraction.Milk;
import com.learning.java8.learning.designPattern.bridging.implementor.Mango;
import com.learning.java8.learning.designPattern.bridging.implementor.Strawberry;

public class BridgingTest {

    public static void main(String[] args) {
        Milk milk = new Milk(new Mango());
        milk.add();

        Cake cake = new Cake(new Strawberry());
        cake.add();
    }

}
