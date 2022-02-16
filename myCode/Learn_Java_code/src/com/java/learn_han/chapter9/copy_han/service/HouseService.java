package com.java.learn_han.chapter9.copy_han.service;

import com.java.learn_han.chapter9.copy_han.domain.House;

import java.util.Scanner;

public class HouseService {

    private House[] houses;//保存House对象
    private int houseNums = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;//记录当前的id增长到哪个值

    public HouseService(int size) {
        houses = new House[size];//当创建HouseService对象，指定数组大小
        houses[0] = new House(1,"CDUY","333","home",100,"未出租");

    }

    //add方法，添加新对象,返回boolean
    public boolean add(House newHouse) {
        //判断是否还可以继续添加(我们暂时不考虑数组扩容的问题) => 能否自己加入数组扩容机制(~~)
        if (houseNums == houses.length) {
            System.out.println("数组已满，不能再增加了。");
            return false;
        }
        houses[houseNums++] = newHouse;
        newHouse.setId(++idCounter);
        return true;
    }
}
