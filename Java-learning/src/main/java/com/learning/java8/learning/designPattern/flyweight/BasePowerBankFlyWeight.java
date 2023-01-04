package com.learning.java8.learning.designPattern.flyweight;

/**
 * 优点
 * 缓存可以重复使用的对象，节省系统的内存开销。
 * 缺点
 * 为了共享对象，需要将某些对象导出到外部，即让外部能够调用。
 *
 */
public abstract class BasePowerBankFlyWeight {

    protected volatile boolean inUse = false;

    abstract void use();

    abstract void endUse();

}
