package com.java.learn_han.chapter13.wrapper;

/**
 * @author CDUY
 * @version 1.0
 */
public class WrapperVSString {
    public static void main(String[] args) {

        Integer i = 100;
        String str = i + "";

        str = i.toString();

        String.valueOf(i);


    }
}
