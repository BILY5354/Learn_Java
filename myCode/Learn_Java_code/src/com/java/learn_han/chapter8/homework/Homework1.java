package com.java.learn_han.chapter8.homework;

public class Homework1 {
    public static void main(String[] args) {
        Person[] peoples = new Person[3];
        peoples[0] = new Person("jack", 10, "学生");
        peoples[1] = new Person("milan", 30, "老师");
        peoples[2] = new Person("tom", 60, "退休");

        for (int i = 0; i < peoples.length; i++) {
            System.out.println(peoples[i]);//默认对象的.toString()
        }

        System.out.println("排序后，从大到小");
        peoples[0].compareAge(peoples);
        for (int i = 0; i < peoples.length; i++) {
            System.out.println(peoples[i]);//默认对象的.toString()
        }
    }
}
