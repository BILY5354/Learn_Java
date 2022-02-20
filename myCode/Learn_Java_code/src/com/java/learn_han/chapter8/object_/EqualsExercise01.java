package com.java.learn_han.chapter8.object_;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person tom = new Person("tom", 20, '男');
        Person tom1 = new Person("tom", 20, '男');
        Person ben = new Person("ben", 60, '男');


        boolean i = tom.equals(tom1);
        System.out.println(tom.equals(tom1));
        System.out.println(tom.equals(ben));


    }
}
