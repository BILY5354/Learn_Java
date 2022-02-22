# [面向对象编程（高级部分）](./TCH_Han/Chapter10.md)  
# 值得注意的概念
- 
- 
- 
-  
1. [类变量和类方法](#1)
2. [理解```main```方法语法](#2)
3. [代码块](#3)
4. [单例设计模式](#4)
4. [```final```关键字](#5)
4. [抽象类](#6)
4. [抽象类最佳实践---模板设计模式](#7)
4. [接口](#8)
4. [内部类](#9)
4. [卖油翁和老黄牛](#10)
5. [作业](#作业)  
# 1

## 1.1 类变量快速入门

```java
//略
```





## 1.2 类变量与类方法

### 1.2.1 类变量与定义

- 类变量也叫**静态变量**/**静态属性**，是该类所有对象共享的变量，任何一个该类对象去访问它时，取到的都是相同的值
  1. ```staic```变量是同一个类中所有对象共享
  2. ```staic```类变量，在类加载时候就生产
  3. [那么和之前说的属性有啥区别呢](https://www.cnblogs.com/zxan/p/7277876.html)
- 定义：

```java
访问修饰符 static 数据类型 变量名; //推荐
static 访问修饰符 数据类型 变量名;
```



### 1.2.2 类变量内存剖析

```JDK```版本不同可能会导致静态变量存储的位置不同，但是要注意的是：

 - ```staic```变量是**同一个类**中所有对象共享

 -  ```staic```类变量，在类加载时候就生产

  

### 1.2.3 类变量使用注意事项与细节讨论

1. 什么时候需要用类变量：

   - 当需要让某个类的所有对象都共享一个变量是，就可以考虑使用类变量（静态变量）

2. 类变量与实例变量（普通属性）区别：

   - **类变量**是该类的所有对象**共享**的，而**实例变量**是每个对象**独享**的

3. 加上```static```称为类变量或静态变量，否则称为实例变量/普通变量/非静态变量

4. 类变量的方法方式有：（前提是满足访问修饰符的访问权限和范围）

   ```java
   类名.类变量名	//推荐 注意！实例变量此种访问方式错误
   对象名.类变量名
   ```

5. 类变量是在类加载是就初始化了，也就是即使没有创建对象，只要类加载了，就可以使用类变量
6. 类变量的生命周期是随类的加载开始，随着类消亡而销毁（看例子）

```java
package com.hspedu.static_; 

public class StaticDetail { 
    public static void main(String[] args) { 
        B b = new B(); 
        //System.out.println(B.n1); 
        System.out.println(B.n2); //静态变量是类加载的时候，就创建了,所以我们没有创建对象实例 
        System.out.println(C.address);  //也可通过类名.类变量名来访问
    } 
}

class B { 
    public int n1 = 100; 
    public static int n2 = 200; 
}

class C { 
    public static String address = "北京"; 
}
```






### 1.2.4 类方法基本介绍

- 类方法也叫静态方法

```java
访问修饰符 static 数据返回类型 方法名() {}//推荐
static 访问修饰符 数据返回类型 方法名() {}
```

- 类方法的调用**前提是**满足访问修饰符的访问权限

```java
class B {
    public static void printStart () {
        System.out.println("打印星星...");
    }
}
```



类方法使用案例

```java
package com.hspedu.static_; 

public class StaticMethod {
    public static void main(String[] args) { 
        
        //创建 2 个学生对象，叫学费 
        Stu tom = new Stu("tom"); 
        //tom.payFee(100); 
        Stu.payFee(100);//对不对?对 
        
        Stu mary = new Stu("mary"); 
        //mary.payFee(200); 
        Stu.payFee(200);//对 
        
        Stu.showFee();//300  输出当前收到的总学费 
        
        //如果希望不创建实例，也可以调用某个方法(即当做工具来使用) //这时，把方法做成静态方法时非常合适 
        System.out.println("9 开平方的结果是=" + Math.sqrt(9)); 
        System.out.println(MyTools.calSum(10, 30)); 
    } 
}

//开发自己的工具类时，可以将方法做成静态的，方便调用 
class MyTools { 
    //求出两个数的和 
    public static double calSum(double n1, double n2) {
        return n1 + n2; 
    }
    //可以写出很多这样的工具方法... 
}

class Stu { 
    private String name;//普通成员 
    //定义一个静态变量，来累积学生的学费 
    private static double fee = 0; 
    
    public Stu(String name) { 
        this.name = name; 
    }
    //说明 
    //1. 当方法使用了 static 修饰后，该方法就是静态方法 
    //2. 静态方法就可以访问静态属性/变量 
    public static void payFee(double fee) { 
        Stu.fee += fee;//累积到 
    }
    public static void showFee() { 
        System.out.println("总学费有:" + Stu.fee); 
    } 
}
```

  

  

### 1.2.5 类方法经典使用场景

- 当方法中不涉及到任何对象相关的成员，则可以将方法设计成静态方法，提高开发效率
- 在程序实际开发，往往会将一些通用的方法，设计成静态方法，这样便不需要创建对象可以使用，比如打印一维数组、冒泡排序，完成某个计算任务等
- 如```Math```类、```Arrays```类、```Collections```集合类看看源码



### 1.2.6 类方法使用注意事项和细节讨论

1. 类方法和普通方法都是随着类的加载而加载，将结构信息存储在方法区：
   - 类方法中无```this```参数
   - 普通方法中隐含```this```参数
2. 类方法可以通过类名调用，也可以通过对象名调用。
3. **普通方法**和对象有关，需要通过对象名调用，比如```对象名.方法名(参数)```，**不能通过类名调用**。
4. **类方法**中不允许使用和对象有关的关键字，**比如```this```和```super```**。```普通方法(成员方法)```可以。
5. ```类方法(静态方法)```中，**只能**访问**静态成员**，也可以访问**静态方法**。
6. 普通成员方案，**即**可以访问非静态成员，**也**可以访问静态成员。

**小结**：静态方法，只能访问静态的成员，非静态的方法，可以访问静态成员和非静态成员（必须遵循访问权限）。

```java
package com.hspedu.static_; 

public class StaticMethodDetail { 
    public static void main(String[] args) {
        D.hi();//ok 
        //D.say();, 错误，非静态方法，不能通过类名调用 需要先创建对象，再调用 
        new D().say();//可以
        } 
}

class D { 
    private int n1 = 100; 
    private static int n2 = 200;
    public void say() {//非静态方法,普通方法 
    }
    public static void hi() {//静态方法,类方法 
        n1 = 0;//错误，类方法中不允许使用和对象有关的关键字， 
        //比如 this 和 super。普通方法(成员方法)可以。 
        //System.out.println(this.n1); 错误的
    }
    
    //类方法(静态方法)中 只能访问 静态变量 或静态方法 
    //口诀:静态方法只能访问静态成员. 
    public static void hello() { 
        System.out.println(n2); 
        System.out.println(D.n2); 
        //System.out.println(this.n2);不能使用 
        hi();//OK 
        //say();//错误 
    }
    //普通成员方法，既可以访问 非静态成员，也可以访问静态成员
    
    //小结: 非静态方法可以访问 静态成员和非静态成员 
    public void ok() { 
        //非静态成员 
        System.out.println(n1); 
        say(); 
        //静态成员 
        System.out.println(n2); 
        hello(); 
    } 
}
```



### 1.2.7  课堂练习(1)：判断```total```值

[不用```this```如何给```total```赋值呢？](#1.2.3 类变量使用注意事项与细节讨论)。

```java
class TestPerson {
    public static void main(String[] args) {

        Person.setTotalPerson(3);
        new Person();
        Person.m();
    }
}

class Person { //StaticExercise03.java 2min 看
    private int id;
    private static int total = 0;
    public static void setTotalPerson(int total){
        
        // this.total = total;//错误，因为在static方法中，不可以使用this 关键字
        Person.total = total;//想要给total赋值就使用 类.静态属性
    }
    public Person() {//构造器
        total++;
        id = total;
    }
    public static void m() {//编写一个方法，输出total的值
        System.out.println("total的值=" + total);
    }
}
```

答案是4，**小结**：

- 静态方法只能访问静态成员（属性和方法）
- 非静态方法可以访问所有的成员
- 在编写代码时，仍然遵守访问权限规则

# 2

## 2.1 深入理解```main```方法



```
```
# 3
```
```
# 4
```
```




*****



# 作业

```
```