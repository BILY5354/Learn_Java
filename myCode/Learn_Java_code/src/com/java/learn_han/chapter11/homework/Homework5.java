package com.java.learn_han.chapter11.homework;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework5 {
    public static void main(String[] args) {
        A a = new A();
    }

}

class A {
    private String name = "A's CDUY";

    {
        class B {
            private final String name;

            B(String name) {
                this.name = name;
            }

            public void show() {
                System.out.println("A name = " + A.this.name);
                System.out.println("B name = " + name);
            }
        }
        B b = new B("B's CDUY");
        b.show();
    }
}
