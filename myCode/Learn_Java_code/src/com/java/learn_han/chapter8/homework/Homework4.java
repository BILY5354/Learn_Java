package com.java.learn_han.chapter8.homework;

public class Homework4 {
    public static void main(String[] args) {
        Worker worker = new Worker("worker", 1000, 2);
        Manager manager = new Manager("manager", 1000, 2);

        System.out.println(worker.printSalary());
        System.out.println(manager.printSalary());
    }
}

class Employee {
    private String name;
    private double salary;
    private int workDay;

    public Employee(String name, double salary, int workDay) {
        this.name = name;
        this.salary = salary;
        this.workDay = workDay;
    }

    public String printSalary() {
        return " salary ";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }
}

class Worker extends Employee {

    public Worker(String name, double salary, int workDay) {
        super(name, salary, workDay);
    }

    @Override
    public String printSalary() {
        return "普通员工：" + getName() + super.printSalary() + getSalary() * getWorkDay();
    }
}

class Manager extends Employee {

    public Manager(String name, double salary, int workDay) {
        super(name, salary, workDay);
    }

    @Override
    public String printSalary() {
        return "经理：" + getName() + super.printSalary() + (1000 + getSalary() * getWorkDay() * 1.2);
    }
}
