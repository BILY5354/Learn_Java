package com.java.learn_han.chapter9.copy_han.view;

import com.java.learn_han.chapter9.copy_han.domain.House;
import com.java.learn_han.chapter9.copy_han.service.HouseService;
import com.java.learn_han.chapter9.copy_han.utils.Utility;

public class HouseView {

    private boolean loop = true;//控制显示菜单
    private char key = ' ';//接收用户选择
    private HouseService houseService = new HouseService(2);//设置数组的大小为2


    public void addHouse() {
        System.out.println("添加房源");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String phone = Utility.readString(12);
        System.out.print("地址：");
        String address = Utility.readString(16);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);

        //创建一个新的House对象, 注意id 是系统分配的，
        House newHouse = new House(0, name, phone, address, rent, state);
        if (houseService.add(newHouse)) {
            System.out.println("添加房源成功");
        } else {
            System.out.println("添加房源失败");
        }
    }


    public void findHouse() {

    }


    public void mainMenu() {

        do {
            System.out.println("\n房屋出租系统菜单");
            System.out.println("1 新增房源");
            System.out.println("2 查找房源");
            System.out.println("3 删除房屋信息");
            System.out.println("4 修改房屋信息");
            System.out.println("5 房源列表");
            System.out.println("6 退出");
            System.out.println("你要选择的功能是：");
            //key = Utility.readChar();

            /*switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    update();
                    break;
                case '5':
                    listHouse();
                    break;
                case '6':
                    exit();
                    break;
            }*/
        } while (loop);
    }
}
