# [异常](./TCH_Han/Chapter12.md)  
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

## 1.1异常介绍

<img src="../img/TCH_Han/ch12_2.png" style="zoom:87%;" />

<img src="../img/TCH_Han/ch12_1.png" style="zoom:87%;" />





## 1.2小结

1. 异常分为两大类，运行时异常和编译时异常。
2. 运行时异常：编译器检查不出来。一般是指编程时的逻辑错误，是程序员应该避免出现的异常。```java.lang.RuntimeException```类及其子类都是运行时异常。
3. 对于运行时异常，可以不作处理，因为这类异常很普遍，若全处理可能会对程序的可读性和运行效率产生影响。
4. 编译时异常：是编译器要求必须处置的异常。



## 1.3常见的运行异常

1. ```NullPointerException``` 空指针异常 
2. ```ArithmeticException```数学运算异常 
3. ```ArrayIndexOutOfBoundsException ```数组下标越界异常 
4.  ```ClassCastException``` 类型转换异常 
5. ```NumberFormatException``` 数字格式不正确异常[]





## 1.4编译异常

### 1.4.1编译异常介绍

**编译异常是指在编译期间，就必须处理的异常，否则代码不能通过编译。**



### 1.4.2常见的编译异常

<img src="../img/TCH_Han/ch12_3.png" style="zoom:87%;" />

### 1.4.3案例





## 1.5课堂练习





## 1.6异常处理

### 1.6.1异常处理基本介绍

**异常处理就是当异常发生时，对异常处理的方式。**



### 1.6.2异常处理方式

1. ```try-catch-finally```
   - 程序员在代码中捕获发生的异常，自行处理。
2. ```throws```
   - 将发生的异常抛出，交给调用者（方法处理），最顶级的处理这就是```JVM```。



### 1.6.3示意图

<img src="../img/TCH_Han/ch12_4.png" style="zoom:87%;" />

<img src="../img/TCH_Han/ch12_5.png" style="zoom:87%;" />



# 2

## 2.1```try-catch```异常处理

<img src="../img/TCH_Han/ch12_6.png" style="zoom:87%;" />

### 2.1.1```try-catch```快速入门



### 2.1.2```try-catch```使用的注意事项

<img src="../img/TCH_Han/ch12_7.png" style="zoom:87%;" />

<img src="../img/TCH_Han/ch12_8.png" style="zoom:87%;" />

<img src="../img/TCH_Han/ch12_9.png" style="zoom:87%;" />



## 2.2课堂练习(1)：异常处理



## 2.3```try-catch```小结

# 3

## 3.1```throws```基本介绍

<img src="../img/TCH_Han/ch12_10.png" style="zoom:87%;" />

## 3.2快速入门



## 3.3注意事项与细节

<img src="../img/TCH_Han/ch12_11.png" style="zoom:87%;" />





## 3.4自定义异常

### 3.4.1基本概念

打不过程序中出现了某些“错误”，但该错误信息并没有在Throwable子类中描述处理，这个时候可以自己设计异常类，用于描述该错误信息。



### 3.4.2自定义异常的步骤

<img src="../img/TCH_Han/ch12_12.png" style="zoom:87%;" />



### 3.4.3自定义异常的应用实例





# 作业
```
```