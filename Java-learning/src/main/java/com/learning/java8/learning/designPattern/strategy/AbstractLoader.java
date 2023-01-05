package com.learning.java8.learning.designPattern.strategy;

/**
 * 使用模板模式
 */
public abstract class AbstractLoader {

    public abstract void load();

    public abstract void verify();

    public abstract void prepare();

    public abstract void analysis();

    public abstract void init();

    public abstract void instantiation();

    public abstract void uninstall();

    public void allInOne() {
        this.load();
        this.verify();
        this.prepare();
        this.analysis();
        this.init();
        this.instantiation();
        this.uninstall();
    }

}
