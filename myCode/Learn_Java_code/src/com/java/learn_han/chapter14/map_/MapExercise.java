package com.java.learn_han.chapter14.map_;

import java.util.*;

/**
 * @author CDUY
 * @version 1.0
 */
public class MapExercise {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Employee("CDUY", 20000, 1));
        map.put(2, new Employee("milan", 200, 2));
        map.put(3, new Employee("tom", 90000, 3));

        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()) {
            Object key =  iterator.next();
            Employee employee = (Employee)map.get(key);
            if (employee.getSalary() > 18000) {
                System.out.println(employee);
            }
/*            System.out.println(map.get(key));*/
        }
    }
}

class Employee {
    private String name;
    private double salary;
    private long id;

    public Employee(String name, double salary, long id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id=" + id +
                '}';
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}