package com.learning.java8.learning.designPattern.flyweight;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class PowerBankFactory {

    private static Map<Integer, BasePowerBankFlyWeight> powerBankFlyWeightMap = new ConcurrentHashMap<>();
    private static Integer num = 1;

    static {
        PowerBank lm = new PowerBank(num, "罗马仕");
        num++;
        PowerBank xm = new PowerBank(num, "小米");
        powerBankFlyWeightMap.put(lm.getId(), lm);
        powerBankFlyWeightMap.put(xm.getId(), xm);
    }

    /**
     * 添加一个充电宝到充电宝箱中
     */
    public void addPowerBank(BasePowerBankFlyWeight powerBank) {
        num++;
        powerBankFlyWeightMap.put(num, powerBank);
    }

    /**
     * 取出充电宝
     */
    public static synchronized BasePowerBankFlyWeight usePowerBank(Integer num) {

        // 首先查找指定的充电宝
        BasePowerBankFlyWeight powerBank = powerBankFlyWeightMap.get(num);

        // 如果找不到指定编号的充电宝或者指定编号充电宝正在使用中，则随机返回一个充电宝
        if (Objects.isNull(powerBank) || powerBank.inUse) {

            // 遍历连接迟中所有充电宝
            for (BasePowerBankFlyWeight p : powerBankFlyWeightMap.values()) {

                // 如果某个充电宝未在使用，则返回这个充电宝
                if (!p.inUse) {
                    p.use();
                    return p;
                }
            }

            // 循环到最后都没有空闲的充电宝，则返回null
            return null;
        }

        // 如果找到了指定编号的充电宝且没有在使用，直接返回指定充电宝
        powerBank.use();
        return powerBank;
    }

}
