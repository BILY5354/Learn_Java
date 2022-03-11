package com.java.learn_han.chapter11.homework;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework3 {
    public static void main(String[] args) {
        Animal animal = new Cat() ;
        animal.shout();
        animal = new Dog();
        animal.shout();
    }
}

abstract class Animal {
    public abstract void shout();
}

class Cat extends Animal {
    public void shout() {
        System.out.println("小猫喵喵叫");
    }
}

class Dog extends Animal {
    public void shout() {
        System.out.println("小狗汪汪叫");
    }
}
