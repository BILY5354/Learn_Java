package com.java.learn_han.chapter12.exception_;

/**
 * @author CDUY
 * @version 1.0
 */
public class Exception01 {

    public static void main(String[] args) {

        try {
            int res = 10/0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
