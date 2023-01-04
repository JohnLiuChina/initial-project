package com.learning.java8.learning.designPattern.strategy;

public abstract class AbstractLoader {

    public abstract void load();

    public abstract void verify();

    public abstract void prepare();

    public abstract void analysis();

    public abstract void init();

    public abstract void instantiation();

    public abstract void uninstall();

}
