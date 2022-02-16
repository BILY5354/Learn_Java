package com.java.learn_han.chapter8.super_;

public class B extends A {

    public int n1 = 888;

    public void test() {
        System.out.println("B类的test()运行并开始调用父类的属性和方法");
        System.out.println("super.n1= " + super.n1);//找父类的n1，
        super.cal();//寻找父类的cal()

        System.out.println("现在开始调用了本类的属性和方法");
        System.out.println("用n1调用本类属性：" + n1);
        System.out.println("用this.n1调用本类属性：" + this.n1);
        System.out.print("用cal()调用本类方法");
        cal();
        System.out.print("用this.cal()调用本类方法");
        this.cal();//调用本类的cal()
    }

    public void cal() {
        System.out.println("B类的cal()方法...");
    }

    public void ok() {
        super.test100();//可以，公共
        super.test200();//可以，保护
        super.test300();//可以，默认
        //super.test400();//不可以，不能访问父类private方法
    }

    //回顾：访问父类的构造器，只能放在构造器的第一句且只出现一句
    public B() {
        super();
    }
}
