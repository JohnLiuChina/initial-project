package com.learning.java8;

import com.learning.java8.learning.designPattern.factory.abstractFactory.*;
import com.learning.java8.learning.designPattern.factory.simpleFactory.Fruit;
import com.learning.java8.learning.designPattern.factory.simpleFactory.FruitSimplyFactory;
import org.junit.Test;

public class FactoryTest {

    @Test
    public void factory() {

        FruitSimplyFactory fruitSimplyFactory = new FruitSimplyFactory();
        Fruit apple = fruitSimplyFactory.declareFruit("apple");
        Fruit pear = fruitSimplyFactory.declareFruit("pear");

    }

    @Test
    public void abstractFactory() {

        Abstract3cFactory apple3cFactory = new Apple3cFactory();
        Abstract3cFactory huawei3cFactory = new Huawei3cFactory();
        Pc imac = apple3cFactory.makePc();
        Phone iphone = apple3cFactory.makePhone();
        Pc matebook = huawei3cFactory.makePc();
        Phone matePhone = huawei3cFactory.makePhone();

    }

}
