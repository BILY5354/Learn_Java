package com.java.learn_han.chapter10.Innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {

        new Cellphone() {}.alarm_clock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        //也可以
        Cellphone cellphone = new Cellphone();
        cellphone.alarm_clock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴去上课了");
            }
        });
    }
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarm_clock(Bell bell) {
        bell.ring();
    }
}
