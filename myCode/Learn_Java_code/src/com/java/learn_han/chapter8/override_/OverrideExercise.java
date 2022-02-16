package com.java.learn_han.chapter8.override_;

public class OverrideExercise {
    public static void main(String[] args) {

        Person person = new Person("Boss", 62);
        person.Say();

        Student student = new Student("stuMartin", 12, 123, 99);
        student.Say();
    }
}
