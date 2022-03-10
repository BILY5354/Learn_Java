package com.java.learn_han.chapter12.exception_;

import java.util.Scanner;

/**
 * @author CDUY
 * @version 1.0
 */
public class Exception01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (true) {
            System.out.println("请输入一个整数：");
            try {
                num = Integer.parseInt(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("你输入的不是一个整数：");
            }
        }
        System.out.println(num);
    }
}
