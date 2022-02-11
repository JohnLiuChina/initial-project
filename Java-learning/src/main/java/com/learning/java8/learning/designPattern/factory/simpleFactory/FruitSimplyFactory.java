package com.learning.java8.learning.designPattern.factory.simpleFactory;

public class FruitSimplyFactory {

    public Fruit declareFruit(String type){
        Fruit result;
        switch (type){
            case "apple":
                result = new Appele();
                break;
            case "pear":
                result = new Pear();
                break;
            default:
                result = null;
                break;
        }
        return result;
    }

}
