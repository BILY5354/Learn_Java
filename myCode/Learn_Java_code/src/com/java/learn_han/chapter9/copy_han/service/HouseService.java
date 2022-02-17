package com.java.learn_han.chapter9.copy_han.service;

import com.java.learn_han.chapter9.copy_han.domain.House;


public class HouseService {

    private House[] houses;//保存House对象
    private int houseNums = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;//记录当前的id增长到哪个值

    public HouseService(int size) {
        houses = new House[size];//当创建HouseService对象，指定数组大小
        houses[0] = new House(1, "CDUY", "333", "home", 100, "未出租");

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

    //findById方法,返回House对象或者null
    public House findById(int findId) {

        //遍历数组
        for (int i = 0; i < houseNums; i++) {
            if (findId == houses[i].getId()) {
                return houses[i];
            }
        }

        return null;
    }

    //del方法，删除一个房屋信息
    public boolean del(int delId) {
        int index = -1;
        for (int i = 0; i < houseNums; i++) {
            if (delId == houses[i].getId()) {//要删除的房屋(id),是数组下标为i的元素
                index = i;//就使用index记录i
            }
        }

        if (index == -1) {//说明delId在数组中不存在(有点绕..)
            return false;
        }
        //注意这里老师的写法
        //如删除的是下标1，不进入for，然把下标1置空，
        //如删除的是下标0，进入for，把1的覆盖掉原0的位置，然把下标1置空
        //也就是删除了一个东西，如果在最后一位直接把这一位置空，否则把后面的数据推前到本位置（前面的不需懂）
        for (int i = index; i < houseNums - 1; i++) {
            houses[i] = houses[i + 1];
        }
        //把当有存在的房屋信息的最后一个 设置null
        houses[--houseNums] = null;
        return true;
    }

    //list方法，返回houses
    public House[] list() {
        return houses;
    }
}
