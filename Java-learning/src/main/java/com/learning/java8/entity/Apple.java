package com.learning.java8.entity;

import lombok.Data;

@Data
public class Apple implements Cloneable {

    private String color;
    private Long weight;
    private Status status;

    public Apple() {

    }

    public Apple(String color, long weight) {
        this.color = color;
        this.weight = weight;
    }

    public Apple(String color, Long weight, Status status) {
        this.color = color;
        this.weight = weight;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                ", status=" + status +
                '}';
    }

    public enum Status {
        FREE,
        BUSY,
        VOCATION
    }

    @Override
    public Object clone() {
        Apple apple = null;
        try {
            apple = (Apple) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return apple;
    }

}
