package com.java.learn_han.chapter10.codeblock_;

public class CodeBlockDetail04 {
    public static void main(String[] args) {
        new B02();
    }
}

class A02 { //父类
    private static int n1 = getVal01();
    static {
        System.out.println("A02的一个静态代码块..");
    }
    {
        System.out.println("A02的第一个普通代码块..");
    }
    public int n3 = getVal02();
    public static int getVal01() {
        System.out.println("getVal01");
        return 10;
    }

    public int getVal02() {
        System.out.println("getVal02");
        return 10;
    }

    public A02() {//构造器
        System.out.println("A02的构造器");//(7)
    }

}

class B02 extends A02 { //

    private static int n3 = getVal03();

    static {
        System.out.println("B02的一个静态代码块..");
    }
    public int n5 = getVal04();
    {
        System.out.println("B02的第一个普通代码块..");//(9)
    }

    public static int getVal03() {
        System.out.println("getVal03");
        return 10;
    }

    public int getVal04() {
        System.out.println("getVal04");
        return 10;
    }

    public B02() {//构造器
        System.out.println("B02的构造器");
        // TODO Auto-generated constructor stub
    }
}

