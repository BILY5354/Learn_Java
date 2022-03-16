package com.java.learn_han.chapter14.list_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author CDUY
 * @version 1.0
 */

/*定义一耳光Employee类，改类包含：private成员属性和name,age要求：
        1. 创建3个Employee对象放入HashSet中
        2. 当name和age的值相同时，认为是相同员工，不能添加到HashSet集合中*/
public class HashSetExercise {
    public static void main(String[] args) {
        Employee employee1 = new Employee("小明", 10);
        Employee employee2 = new Employee("小明", 10);
        Employee employee3 = new Employee("小明", 90);

        HashSet hashSet = new HashSet();
        hashSet.add(employee1);
        hashSet.add(employee2);
        hashSet.add(employee3);

        System.out.println(hashSet);
    }
}

class Employee {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

   /* @Override
    public boolean equals(Object obj) {
        if (this.name.equals(((Employee) obj).name) && this.age == ((Employee) obj).age) {
            return true;
        } else {
            return false;
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
