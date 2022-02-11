package com.learning.java8.entity;

import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Long> {

    private static final long serialVersionUID = 1L;

    private long start;

    private long end;

    private static final long THRESHOLD = 10000;

    @Override
    protected Long compute() {
        return null;
    }
}
