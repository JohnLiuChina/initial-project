package com.learning.java8.learning.designPattern.flyweight;

public class PowerBank extends BasePowerBankFlyWeight {

    private Integer id;

    private String brand;

    public PowerBank(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    void use() {
        inUse = true;
        System.out.println("编号：" + id + "，品牌：" + brand + "的充电宝正在使用");
    }

    @Override
    void endUse() {
        inUse = false;
        System.out.println("编号：" + id + "，品牌：" + brand + "的充电宝使用完毕");
    }
}
