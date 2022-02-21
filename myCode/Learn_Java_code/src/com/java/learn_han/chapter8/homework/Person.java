package com.java.learn_han.chapter8.homework;

public class Person {

    private String name;
    private int age;
    private String job;

    public Person(String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public void compareAge(Person[] people) {
        Person p = null;//临时变量，用于交换
        for (int i = 1; i < people.length; i++) {
            for (int j = 0; j < people.length - 1; j++) {
                if (people[j].age < people[j + 1].age) {
                    p = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = p;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                '}';
    }
}
