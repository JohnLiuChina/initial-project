package com.learning.java8.learning.designPattern.chain;

public abstract class CheckChain {

    protected CheckChain nextChecker;

    private void setNextChecker(CheckChain checker) {
       this.nextChecker = checker;
    }

    public abstract void proceed(Event event);

    public static Builder Builder() {
        return new Builder();
    }

    public static class Builder{
        private CheckChain head;
        private CheckChain tail;

        public Builder addChecker(CheckChain checker){
            if(head == null){
                head = tail = checker;
            } else {
                tail.setNextChecker(checker);
                tail = checker;
            }
            return this;
        }

        public CheckChain build() {
            return head;
        }
    }

}
