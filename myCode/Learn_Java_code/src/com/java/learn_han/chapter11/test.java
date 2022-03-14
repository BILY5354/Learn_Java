package com.java.learn_han.chapter11;

/**
 * @author CDUY
 * @version 1.0
 */
public class test {
    public static void main(String[] args) {
        new Cellphone(){}.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
    }
}

interface Bell {
    void ring();
}

class Cellphone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}
