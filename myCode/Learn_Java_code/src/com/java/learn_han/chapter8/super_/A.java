package com.java.learn_han.chapter8.super_;

public class A extends Base {

    //n1 是继承了Base类中的
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;//子类是不可访问的

    public void test100() {
    }

    protected void test200() {
    }

    void test300() {
    }

    private void test400() {//子类是不可访问的
    }
}
