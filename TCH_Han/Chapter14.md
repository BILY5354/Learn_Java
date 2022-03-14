# [集合](./TCH_Han/Chapter14.md)  
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

## 1.1集合的基本简介

数组的缺陷：

1. 长度开始时必须指定，而且一旦指定，不能更改。
2. 保存的必须为同一类型的元素。
3. 使用数组进行增加/删除元素比较麻烦



集合：

1. 可以**动态保存**任意多个对象，使用比较方便
2. 提供了一些列方便的操作对象的方法：add、remove、set、get
3. 使用集合添加、删除元素简洁明了

```    
```


## 1.2```Collection```接口实现类的特点

```java
public interface Collection<E> extends Iterable<E>
```

1. ```Collection```实现子类可以存放多个元素，每个元素可以是```Object```
2. 有些```Collection```的实现类，可以存放重复的元素，有些不行
3. 有些```Collection```的实现类，有些事有序的List，有些不是有序Set
4. ```Collection```接口没有直接的实现子类，是通过它的子接口Set和List来实现的



### 1.2.1```Collection```接口遍历元素方式1-使用 Iterator(迭代器)





### 1.2.2Collection 接口遍历对象方式 2-for 循环增强



### 1.2.3课堂练习

<img src="../img/TCH_Han/ch14_1.png" style="zoom:87%;" />





# 2

## 2.1List 接口和常用方法

### 2.1.1List 接口基本介绍

```
```


### 2.1.2List 接口的常用方法

<img src="../img/TCH_Han/ch14_2.png" style="zoom:87%;" />



### 2.1.3List 接口课堂练习 

<img src="../img/TCH_Han/ch14_3.png" style="zoom:87%;" />





### 2.1.4List 的三种遍历方式 [ArrayList, LinkedList,Vector]



### 2.1.5实现类的课堂练习 2



## 2.2ArrayList 底层结构和源码分析

### 2.2.1ArrayList 的注意事项

<img src="../img/TCH_Han/ch14_4.png" style="zoom:87%;" />

### 2.2.2ArrayList 的底层操作机制源码分析(重点，难点.)

<img src="../img/TCH_Han/ch14_5.png" style="zoom:87%;" />





## 2.3Vector 底层结构和源码剖析

### 2.3.1Vector 的基本介绍

<img src="../img/TCH_Han/ch14_6.png" style="zoom:87%;" />



### 2.3.2Vector 和 ArrayList 的比较





# 3

```
```
# 4
```
```
# 作业
```
```