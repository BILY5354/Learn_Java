package com.java.learn_han.chapter9.my_pro;

import java.util.Scanner;

public class Houses {

    private String[] houseInfo = {"编号", "房主", "电话", "地址", "月租", "状态（已出租/未出租）"};
    private String[][] houses = new String[100][6];
    static int houseNum = 1;

    public Houses() {
        houses[0] = new String[]{"1", "CDUY", "333", "地球", "100", "未出租"};
    }

    /**
     * 功能 显示租房标题
     */
    public void displayHouseInfo() {
        for (int i = 0; i < houseInfo.length; i++) {
            System.out.print(houseInfo[i] + "\t\t");
        }
    }


    /**
     * 功能1
     */
    public void inputHouse() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一下信息");

        houseNum++;//房源数量加1
        for (int i = 0; i < 6; i++) {
            System.out.print(houseInfo[i] + ": ");
            houses[houseNum - 1][i] = scanner.next();//录入最新的房源，但房源与保存下标差1
        }

        System.out.println("录入成功");
    }

    /**
     * 功能2
     * */

    /**
     * 功能5
     */
    public void displayHouses() {
        for (int i = 0; i < houseNum; i++) {
            System.out.println();
            for (int j = 0; j < houses[j].length; j++) {
                System.out.print(houses[i][j] + "\t\t\t");
            }
        }
    }
}
