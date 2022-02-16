package com.java.learn_han.chapter8.extend_;

public class ExdendsDetail {
    public static void main(String[] args) {
        System.out.println("======第一个对象======");
        Sub sub = new Sub();
        System.out.println("======第二个对象======");
        Sub sub2 = new Sub("jack");//创建了子对象sub2
        System.out.println("======第三个对象======");
        Sub sub3 = new Sub("King", 10);
    }
}
