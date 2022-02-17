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
        System.out.println("查找房屋信息");
        System.out.print("请输入要查找的id：");
        int findId = Utility.readInt();

        House house = houseService.findById(findId);
        if (house != null) {
            System.out.println(house);
        } else {
            System.out.println("查找房屋信息不存在");
        }
    }

    //编写delHouse() 接收输入的id,调用Service 的del方法
    public void delHouse() {
        System.out.println("删除房屋信息");
        System.out.print("请输入待删除房屋的编号（-1退出）：");
        int delId = Utility.readInt();
        if (delId == -1) {
            System.out.println("放弃删除房屋信息");
            return;
        }
        //注意该方法本身就有循环判断的逻辑,必须输出Y/N
        char choice = Utility.readConfirmSelection();
        if (choice == 'Y') {
            if (houseService.del(delId)) {
                System.out.println("删除房屋信息成功");
            } else {
                System.out.println("房屋编号不存在，删除失败");
            }
        } else {
            System.out.println("放弃删除房屋信息");
        }

    }

    //根据id修改房屋信息
    public void update() {
        System.out.println("修改房屋信息");
        System.out.println("请选择修改房屋编号（-1表示退出）");
        int updateId = Utility.readInt();
        if (updateId == -1) {
            System.out.println("你放弃了修改房屋信息");
            return;
        }

        //老师特别提示:返回的是引用类型[即:就是数组的元素]
        //因此老师在后面对house.setXxx() ,就会修改HouseService中houses数组的元素!!!!!!!!!!
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("修改房屋信息编号不存在");
            return;
        }

        System.out.print("姓名（"+ house.getName()  +"）：");
        String name = Utility.readString(8, "");//这里如果用户直接回车表示不修改该信息,默认""
        if (!"".equals(name)) {//不是直接回车，也就是要修改
            house.setName(name);
        }

        System.out.print("（"+ house.getPhone()  +"）：");


        System.out.println("修改房屋信息成功");
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
            key = Utility.readChar();

            switch (key) {
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
            }
        } while (loop);
    }
}
