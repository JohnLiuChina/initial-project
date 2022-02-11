package com.learning.java8.entity;

import lombok.Data;

@Data
public class Expense implements Cloneable {
    //public Expense(String billingCycle){
    //    this.billingCycle = billingCycle;
    //}

    public String getBillingCycle() {
        return billingCycle;
    }

    public void setBillingCycle(String billingCycle) {
        this.billingCycle = billingCycle;
    }

    public Integer getExpense() {
        return expense;
    }

    public void setExpense(Integer expense) {
        this.expense = expense;
    }

    private String billingCycle;

    private Integer expense;
}
