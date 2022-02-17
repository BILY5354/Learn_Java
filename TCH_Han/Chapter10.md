# [面向对象编程（高级部分）](./TCH_Han/Chapter10.md)  
# 可以提高的地方
- 怎么使用动态的数组，使长度可变，现将数组长度定义为2
- 位于```HouseView```的```listHouse```方法有什么坑
- 位于```HouseService```的```del```方法中的删除代码
- 



## 韩老师代码

**```HouseRent.java```**

```    java
package com.java.learn_han.chapter9.copy_han;

import com.java.learn_han.chapter9.copy_han.view.HouseView;

public class HouseRent {

    public static void main(String[] args) {
        //创建HouseView对象,并且显示主菜单，是整个程序的入口
        new HouseView().mainMenu();
        System.out.println("===你退出房屋出租系统==");
    }
}
```


**```House.java```**

```java
package com.java.learn_han.chapter9.copy_han.domain;

public class House {

    //编号  房主  电话  地址  月租  状态(未出租/已出租)
    private int id;
    private String name;
    private String phone;
    private String address;
    private int rent;
    private String state;

    public House(int id, String name, String phone, String address, int rent, String state) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    //为了方便的输出对象信息，我们实现toString
    //编号  房主  电话  地址  月租  状态(未出租/已出租)
    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t" + phone +
                "\t\t" + address +
                "\t" + rent +
                "\t" + state;
    }
}
```


**```HouseService.java```**

```java
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
```


**```HouseView.java```**

```java
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

        System.out.print("姓名(" + house.getName() + "): ");
        String name = Utility.readString(8, "");//这里如果用户直接回车表示不修改该信息,默认""
        if (!"".equals(name)) {//修改
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "): ");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.print("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }

        System.out.println("修改房屋信息成功");
    }

    //编写listHouses()显示房屋列表
    public void listHouse() {
        System.out.println("房屋列表");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态（未出租/已出租）");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {//琢磨下韩老师说的有什么？雷,坑
            if (houses[i] == null) {//如果为null,就不用再显示了
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("房屋列表显示完毕");
    }

    //完成退出确认
    public void exit() {
        char c = Utility.readConfirmSelection();
        if (c == 'Y') {
            loop = false;
        }
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
```


**```Utility.java```**

```java
package com.java.learn_han.chapter9.copy_han.utils;

import java.util.Scanner;

/**
 * 工具类的作用:
 * 处理各种情况的用户输入，并且能够按照程序员的需求，得到用户的控制台输入。
 */
public class Utility {

    private static Scanner scanner = new Scanner(System.in);

    /**
     * 功能： 读取一个字符串
     *
     * @param limit       读取的长度
     * @param blankReturn 如果为true ,表示 可以读空字符串。
     *                    如果为false表示 不能读空字符串。
     *                    如果输入为空，或者输入大于limit的长度，就会提示重新输入。
     * @return
     */
    private static String readKeyBoard(int limit, boolean blankReturn) {

        String line = "";

        while (scanner.hasNextLine()) { //判断是否有下一行
            line = scanner.nextLine();//读取这一行

            if (line.length() == 0) {//如果line.length=0, 即用户没有输入任何内容，直接回车
                if (blankReturn) return line;//如果blankReturn=true,可以返回空串
                else continue;//如果blankReturn=false,不接受空串，必须输入内容
            }

            //如果用户输入的内容大于了 limit，就提示重写输入，符合则接收
            if (line.length() < 1 || line.length() > limit) {
                System.out.print("输入长度（不可大于" + limit + "）错误：请重新输入");
                continue;
            }
            break;
        }
        return line;
    }

    /**
     * 功能：读取键盘输入的整型，长度小于2位
     *
     * @return 整数
     */
    public static int readInt() {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, false);
            try {
                n = Integer.parseInt(str);//将字符串转换成整数
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }

    /**
     * 功能：读取键盘输入的 整数或默认值，如果直接回车，则返回默认值，否则返回输入的整数
     *
     * @param defaultValue 指定的默认值
     * @return 整数或默认值
     */
    public static int readInt(int defaultValue) {
        int n;
        for (; ; ) {
            String str = readKeyBoard(10, true);
            if (str.equals("")) {
                return defaultValue;
            }

            try {
                n = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                System.out.print("数字输入错误，请重新输入：");
            }
        }
        return n;
    }


    /**
     * 功能：读取键盘输入的指定长度的字符串
     *
     * @param limit 限制的长度
     * @return 指定长度的字符串
     */
    public static String readString(int limit) {
        return readKeyBoard(limit, false);
    }

    /**
     * 功能：读取键盘输入的指定长度的字符串或默认值，如果直接回车，返回默认值，否则返回字符串
     *
     * @param limit        限制的长度
     * @param defaultValue 指定的默认值
     * @return 指定长度的字符串
     */
    public static String readString(int limit, String defaultValue) {
        String str = readKeyBoard(limit, true);
        return str.equals("") ? defaultValue : str;//如果没有输入任何东西（直接回车）则默认值
    }

    /**
     * 功能：读取键盘输入的一个字符
     *
     * @return 一个字符
     */
    public static char readChar() {
        String str = readKeyBoard(1, false);
        return str.charAt(0);
    }

    /**
     * 功能：读取键盘输入的一个字符，如果直接按回车，则返回指定的默认值；否则返回输入的那个字符
     *
     * @param defaultValue 指定的默认值
     * @return 默认值或输入的字符
     */
    public static char readChar(char defaultValue) {
        String str = readKeyBoard(1, true);
        return (str.length() == 0) ? defaultValue : str.charAt(0);//要么是空字符串，要么是一个字符
    }

    /**
     * 功能：读取键盘输入的确认选项，Y或N
     * 将小的功能，封装到一个方法中.
     *
     * @return Y或N
     */
    public static char readConfirmSelection() {
        System.out.println("请输入你的选择（Y/N）：请小心选择");
        char c;
        for (; ; ) {
            String str = readKeyBoard(1, false).toUpperCase();//在这里，将接受到字符，转成了大写字母
            c = str.charAt(0);
            if (c == 'Y' || c == 'N') {
                break;
            } else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
}
```