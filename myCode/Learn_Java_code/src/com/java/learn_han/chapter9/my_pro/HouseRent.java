package com.java.learn_han.chapter9.my_pro;

import java.util.Scanner;

public class HouseRent {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Display display = new Display();
        Houses houses = new Houses();

        int flag = -1;
        display.mainMenu();
        display.userTip();
        flag = scanner.nextInt();

        do {


            switch (flag) {
                case 1:
                    System.out.println("情按顺序输入房源信息");
                    houses.inputHouse();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    houses.displayHouseInfo();
                    houses.displayHouses();
                    break;

            }
            display.mainMenu();
            display.userTip();
            flag = scanner.nextInt();
            System.out.println("\n\n");
        } while (flag != 6);
    }


}
