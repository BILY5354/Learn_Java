package com.java.learn_han.chapter8.override_;

public class Dog extends Animal {

    //因为是重写Dog的 cry方法和 Animal的 cry定义形式一样(名称、返回类型、参数)
    public void cry() {
        System.out.println("小狗旺旺叫..");
    }

    //细节: 子类方法的返回类型是父类返回类型的子类
    public String m1() {
        return null;
    }

    public void eat() {
    }

}

class AAA {

}

class BBB extends AAA {

}