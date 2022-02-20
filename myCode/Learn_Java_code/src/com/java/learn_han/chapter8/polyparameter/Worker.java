package com.java.learn_han.chapter8.polyparameter;

public class Worker extends Employee {

    public Worker(String name, double salary) {
        super(name, salary);
    }

    public void work() {
        System.out.println("普通员工" + getName() + "is working.");
    }

    @Override
    public double getAnnual() {//因为普通员工无其它收入
        return super.getAnnual();
    }
}
