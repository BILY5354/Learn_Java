# [常用类](./TCH_Han/Chapter13.md)  
# 值得注意的概念
- 
- 
- 
-  
1. [](#1)
2. [](#2)
3. [](#3)
4. [](#4)
5. [作业](#作业)  
# 1

## 1.1包装类的分类

1. 针对八种基本数据类型相应的引用类型---包装类
2. 有了类的特点，就可以调用类中的方法
3. 如图：

<img src="../img/TCH_Han/ch13_1.png" style="zoom:87%;" />



## 1.2包装类和基本数据的转换

1. jdk5前的手动装箱和拆箱方式，装箱：基本类型->包装类型，反之，拆箱
2. jdk5以后（含5）的自动装箱和拆箱方式
3. 自动装箱底层调用的是valueof方法，比如Integer.valueOf()
4. 其它包装类的用法类似

```    
```


## 1.3课堂练习(1)：判断结果



## 1.4包装类型和String类型的相互转换



## 1.5Integer类型和Charater类的常用方法



## 1.6Integer类面试题





# 2

## 2.1String类的理解和创建对象

<img src="../img/TCH_Han/ch13_2.png" style="zoom:87%;" />

<img src="../img/TCH_Han/ch13_2.png" style="zoom:87%;" />



## 2.2创建String对象

### 2.2.1两种方式

1. 直接赋值
2. 调用构造器



### 2.2.2两种方式的区别

1. 方式一：先从常量池查看是否有“hsp”数据空间，如果有，直接指向；如果没有则重新创建，然后指向。s最终指向的是常量池的空间地址。
2. 方式二：先在堆中创建空间，里面维护了value属性，指向常量池的hsp空间。如果常量池没有“hsp”,重新创建，如果有，直接通过value指向。最终指向的是堆中的空间地址。
3. 内存分布图：

<img src="../img/TCH_Han/ch13_4.png" style="zoom:87%;" />



## 2.3课堂练习(2)



## 2.4字符串的特性

1. String是一个final类，代表不可变的字符序列
2. 字符串是不可变，一个字符串对象一旦被分配，其内容是不可变的



## 2.5面试题





## 2.6String类的常见方法

### 2.6.1

<img src="../img/TCH_Han/ch13_5.png" style="zoom:87%;" />

### 2.6.2String常见方法一览

<img src="../img/TCH_Han/ch13_6.png" style="zoom:87%;" />





<img src="../img/TCH_Han/ch13_7.png" style="zoom:87%;" />





## 2.7StringBuffer类

### 2.7.1简要介绍

- java.lang.StringBuffer代表可变的字符序列，可以对字符串内容就行增删
- 很多方法与String相同，但StringBuffer是可变长度的
- StringBuffer是一个容器



### 2.7.2String vs StringBuffer



### 2.7.3StringBuffer常见方法



### 2.7.4课堂测试题



## 2.8StringBuilder

### 2.8.1StringBuilder基本介绍

<img src="../img/TCH_Han/ch13_8.png" style="zoom:87%;" />



### 2.8.2StringBuilder常用方法



### 2.8.3String vs StringBuffer vs StringBuilder比较及效率测试



## 2.9String vs StringBuffer vs StringBuilder的选择

# 3

## 3.1MATH类的介绍

Math 类包含用于执行基本数学运算的方法，如初等指数、对数、平方根和三角函数。 

## 3.2方法一览(均为静态方法)



## 3.3Math 类常见方法应用案例

```
```
# 4

## 4.1Arrays 类常见方法应用案例 

Arrays中包含一系列静态方法，用于管理或操作数组

1. toString返回数组的字符串形式
2. sort排序（自然排序和定制排序）
3. binarySearch通过二分法搜索继续查找，要求必须排好序
4. copyOf数组元素的复制
5. fill数组元素的填充
6. equals比较两个数组元素内容是否完全一致
7. asList将一组值转换成List





## 4.2课堂练习(1)：Arrays 类课堂练习





# 5

## 5.1System 类常见方法和案例 

<img src="../img/TCH_Han/ch13_9.png" style="zoom:87%;" />





# 6

## 6.1BigInteger 和 BigDecimal 类 介绍

1. BigInteger适合保存比较大的整形
2. BigBecimal适合保存精度更高的浮点型（小数）



## 6.2BigInteger 和 BigDecimal 常见方法

1. add
2. subtract
3. multiply
4. divide



# 7

## 7.1日期类---第一代



## 7.2日期类---第二代



## 7.3日期类---第三代



## 7.4DateTimeFormatter 格式日期类



## 7.5Instant 时间戳



## 7.6第三代日期类更多方法

# 作业

```
```