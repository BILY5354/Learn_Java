package com.java.learn_han.chapter14.map_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author CDUY
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put(1, new Employee("小明", 10000));
        hashMap.put(2, new Employee("大明", 20000));
        hashMap.put(3, new Employee("大大明", 60000));

        for (Object obj : hashMap.entrySet()) {
            Map map = (Map)obj;
            map.
        }
    }
}

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
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
}

