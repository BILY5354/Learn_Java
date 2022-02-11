# [面向对象编程（中级部分）](./TCH_Han/Chapter8.md)  
# 值得注意的概念
- 包的本质实际就是**创建不同的文件夹/目录来保存类文件**
- 一个类最多只有一个```package```且要放在代码第一行（最上面）
- 
-  
1. [```IDEA```的使用](#1)
2. [](#2)
3. [](#3)
4. [](#4)
5. [作业](#作业)  

## 1

本章的代码可以在```IDEA```中运行了。

### 1.1 ```IDEA```的快捷键

```sh
1) 删除当前行, 默认是 ctrl + Y 自己配置 ctrl + d 
2) 复制当前行, 自己配置 ctrl + alt + 向下光标 
3) 补全代码 alt + / 
4) 添加注释和取消注释 ctrl + / 【第一次是添加注释，第二次是取消注释】 
5) 导入该行需要的类 先配置 auto import , 然后使用 alt+enter 即可 
6) 快速格式化代码 ctrl + alt + L 
7) 快速运行程序 自己定义 alt + R 
8) 生成构造器等 alt + insert [提高开发效率] 
9) 查看一个类的层级关系 ctrl + H [学习继承后，非常有用] 
10) 将光标放在一个方法上，输入 ctrl + B , 可以定位到方法 [学继承后，非常有用] 
11) 自动的分配变量名 , 通过 在后面假 .var [老师最喜欢的] 
12) 还有很多其它的快捷键...
```



### 1.2 ```IDEA```设置快捷键

点击```Setting```->```Keymap```->在搜索框搜索：

1. 用```ctrl```+```滚轮```实现调字体，搜索```font```
2. 用```alt```+```d```实现快速运行，搜索```run```
3. ...



### 1.3 ```Java```常用的包

**包引入不建议用```*```**，使用哪个就用哪个。

```java
import java.lang.*;		//基本包，默认引入
import java.util.*;		//系统提供的工具包，如Scanner
import java.net.*;		//网络包，网络开发
import java.awt.*;		//界面开发GUI
```



### 1.4 包命名规则和规范

规则：只能包含数字、字母、下划线、小圆点，不能用数字开头，不能是关键字或保留字

规范：一般是小写字母 + 小圆点



### 1.4 访问修饰符

1. 公开级别：用```public```修饰，对外公开
2. 受保护级别：用```protected```修饰，对子类和同一个包中的类公开
3. 默认级别：没有修饰符号，向同一个包的类公开
4. 私有级别：用```private```修饰，只有类本身可以访问，不对外公开



| 访问级别 | 访问控制修改符 | 同类 | 同包 | 子类 | 不同包 |
| -------- | -------------- | ---- | ---- | ---- | ------ |
| 公开     | public         | ✔    | ✔    | ✔    | ✔      |
| 受保护   | protected      | ✔    | ✔    | ✔    | ✘      |
| 默认     | “无”           | ✔    | ✔    | ✘    | ✘      |
| 私有     | private        | ✔    | ✘    | ✘    | ✘      |



使用注意事项：

1. 修饰符可以用来修饰类中的属性，成员方法以及类
2. 只有默认和```public```**才能修饰类**，并且遵循上述访问权限的特点
3. 关于子类的访问权限，后面记录
4. 成员方法的访问规则和属性完全一样





## 2

### 2.1 面向对象编程三大特性之封装

面向对象编程三大特征：封装、继承和多态。

> 我（**片面**）理解封装：
>
> 将属性（成员变量）设为```private```，同时设置两个```public```的```setXXX```和```getXXX```方法

```java
package com.java.learn_han.chapter8.encap;

public class Encapsulation01 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("CDUY");
        person.setAge(21);
        person.setSalary(100);
        System.out.println(person.info());
        System.out.println(person.getSalary());

        //使用构造器指定属性
        Person smith = new Person("smith", 80, 50000);
        System.out.println("====smith的信息======");
        System.out.println(smith.info());
    }
}

/**
 * 不能随便查看人的年龄,工资等隐私，并对设置的年龄进行合理的验证。年龄合理就设置，否则给默认
 * 年龄, 必须在 1-120, 年龄， 工资不能直接查看 ， name的长度在 2-6字符 之间
 */
class Person {
    public String name;
    private int age;
    private double salary;

    public Person() {

    }

    public Person(String name, int age, double salary) {
        /*this.name = name;
        this.age = age;
        this.salary = salary;*/
        //可以将set方法写在构造器中，这样仍然可以验证
        setName(name);
        setAge(age);
        setSalary(salary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //加入对数据的校验，相当于增加了业务逻辑
        if (name.length() >= 2 && name.length() <= 6) {
            this.name = name;
        } else {
            System.out.println("名字长度不对，需要（2-6）个字符，默认名字");
            this.name = "无名人";
        }
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 1 && age <= 120) {
            this.age = age;
        } else {
            System.out.println("你设置年龄不对，需要在（1-120），给默认年龄18");
            this.age = 18;
        }
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String info() {
        return "信息为 name = " + name + " age = " + age + "薪水 = " + salary;
    }
}
```


### 2.2 课堂练习(1)：封装练习

<img src="../img/TCH_Han/ch8_1.png" style="zoom:67%;" />

```java
//AccountTest.java
package com.java.learn_han.chapter8.encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account();
        account.setName("CDUY");
        account.setSalary(10);
        account.setPassword("12346");

        System.out.println(account.showInfo());
    }
}

//Account.java
package com.java.learn_han.chapter8.encap;

public class Account {
    String name;
    double salary;
    String password;

    public Account() {

    }

    public Account(String name, double salary, String password) {
        setName(name);
        setSalary(salary);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary <= 20) {
            System.out.println("没钱啦自动充20");
            this.salary = 20;
        } else {
            this.salary = salary;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        } else {
            System.out.println("密码长度不为6，自动重置为：111111");
            this.password = "111111";
        }
    }

    public String showInfo() {
        return "Name: " + name + " Salary: " + salary + "Password: " + password;
    }
}
```





## 3

```
```
## 4
```
```
## 作业
```
```



```sh

```

