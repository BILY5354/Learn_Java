package com.java.learn_han.chapter14.list_;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author CDUY
 * @version 1.0
 */
/*
- 定义一耳光Employee类，该类包含private成员属性name，sal，birthady(MyDate类型)其中birthday为MyDate类型（属性包括year,month,day）要求
        1. 创建3个Employee放入HashSet中
        2. 当name和birthday的值相同认为是相同员工，不能添加到HashSet中

*/

public class HashSetExercise2 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(new Employee2("小明", new MyDate(1960, 1, 1), 11));
        hashSet.add(new Employee2("小明", new MyDate(1960, 1, 1), 80));
        hashSet.add(new Employee2("小明", new MyDate(1960, 1, 1), 11));

        System.out.println(hashSet);
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyDate)) return false;
        MyDate myDate = (MyDate) o;
        return getYear() == myDate.getYear() &&
                getMonth() == myDate.getMonth() &&
                getDay() == myDate.getDay();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getYear(), getMonth(), getDay());
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}

class Employee2 {
    private String name;
    private MyDate birthday;
    private int age;

    public Employee2(String name, MyDate birthday, int age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee2)) return false;
        Employee2 employee2 = (Employee2) o;
        return getAge() == employee2.getAge() &&
                Objects.equals(getName(), employee2.getName()) &&
                Objects.equals(getBirthday(), employee2.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getBirthday(), getAge());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee2{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", age=" + age +
                '}' + '\n';
    }
}

