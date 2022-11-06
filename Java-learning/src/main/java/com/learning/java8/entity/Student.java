package com.learning.java8.entity;

import lombok.Data;

@Data
public class Student implements Cloneable {

    //引用类型
    private Subject subject;
    //基础数据类型
    private String name;

    private int age;
    //数组
    private Integer[] arr;

    /**
     * 重写clone()方法
     *
     * @return
     */
    @Override
    public Object clone() {
        //浅拷贝
        try {
            // 直接调用父类的clone()方法
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "[Student: " + this.hashCode() + ",subject:" + subject + ",name:" + name + ",age:" + age + ",arr:" + arr + "]";
    }
}
