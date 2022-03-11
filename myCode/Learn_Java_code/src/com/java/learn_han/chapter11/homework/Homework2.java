package com.java.learn_han.chapter11.homework;

/**
 * @author CDUY
 * @version 1.0
 */
public class Homework2 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());

        Frock frock1 = new Frock();
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println(frock1.getSeriaNumber());
        System.out.println(frock2.getSeriaNumber());
        System.out.println(frock3.getSeriaNumber());
    }
}

class Frock {
    private static int currentNum = 100000;
    private int seriaNumber;

    public Frock() {
        this.seriaNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSeriaNumber() {
        return seriaNumber;
    }
}
