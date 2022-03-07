package com.java.learn_han.chapter10.codeblock_;

public class Exercise01 {
}
class Person {
    public static int total;
    static {
            total = 100;
        System.out.println("in static block!");
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println("total = "+ Person.total);
        System.out.println("total = "+ Person.total);
    }
}