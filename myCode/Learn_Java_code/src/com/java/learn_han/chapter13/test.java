package com.java.learn_han.chapter13;

/**
 * @author CDUY
 * @version 1.0
 */
public class test {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = new String("hspedu");

        System.out.println(p1.name.hashCode());
        System.out.println(p2.name.hashCode());
        System.out.println(p1.name == p2.name);
    }
}

class Person {
    String name;
}

