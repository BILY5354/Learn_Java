package com.java.learn_han.chapter10.codeblock_;

public class CodeBlockDetail02 {
    public static void main(String[] args) {
        A a = new A();
    }
}

class A {
    private static  int n1 = getN1();

    static {
        System.out.println("A静态代码块01");
    }

    public static int getN1() {
        System.out.println("getN1被调用");
        return 100;
    }
}