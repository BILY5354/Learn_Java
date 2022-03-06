package com.java.learn_han.chapter10.codeblock_;

public class CodeBlockDetail01 {
    public static void main(String[] args) {
        System.out.println(DD.i);
    }
}

class DD {
    public static int i = 999;

    static {//静态代码块
        System.out.println("BB的静态代码块被执行");
    }

    {//静态代码块
        System.out.println("BB的普通代码块被执行");
    }
}