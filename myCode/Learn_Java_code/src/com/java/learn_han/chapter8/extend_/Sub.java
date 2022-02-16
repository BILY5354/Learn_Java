package com.java.learn_han.chapter8.extend_;

public class Sub extends Base{

    public Sub() {//无参构造器
        //super(); //默认调用父类的无参构造器
        System.out.println("子类Sub()构造器被调用....");
    }
    //当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器
    public Sub(String name) {
        super("tom");
        System.out.println("子类Sub(String name)构造器被调用....");
    }

    public Sub(String name, int age) {
        super("king", 20);
        System.out.println("子类Sub(String name, int age)构造器被调用....");
    }
}
