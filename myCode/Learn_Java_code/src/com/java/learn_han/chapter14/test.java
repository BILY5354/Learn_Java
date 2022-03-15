package com.java.learn_han.chapter14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author CDUY
 * @version 1.0
 */
public class test {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add(new Dog("DOG1",3));
        list.add(new Dog("DOG2",30));
        list.add(new Dog("DOG3",300));

        for (Object dog : list) {
            System.out.println("dog = " + dog);
        }

        Iterator iterable = list.iterator();
        while(iterable.hasNext()) {
            Object dog = iterable.next();
            System.out.println("dpg = " + dog);
        }
    }
}

class Dog {
    private String name;
    private int age;


    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

