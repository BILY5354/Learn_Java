# [集合](./TCH_Han/Chapter14.md)  
# 值得注意的概念
- ```itit```快速生成while循环
- idea在默认下回阉割部分数据显示，在Build,Execution...->Debugger->Data Views->Java->取消勾选Enblde altermative view for...
- 
-  
1. [](#1)
2. [](#2)
3. [](#3)
4. [](#4)
5. [作业](#作业)  
# 1

## 1.1集合的基本简介

### 1.1.1数组的缺陷：

1. 长度开始时必须指定，而且一旦指定，不能更改。
2. 保存的必须为同一类型的元素。
3. 使用数组进行增加/删除元素比较麻烦

<img src="../img/TCH_Han/ch14_8.png" style="zoom:87%;" />

### 1.1.2集合：

1. 可以**动态保存**任意多个对象，使用比较方便
2. 提供了一些列方便的操作对象的方法：add、remove、set、get
3. 使用集合添加、删除元素简洁明了



### 1.1.3基本介绍

**两图必记**

1. 集合主要是两组(单列集合 , 双列集合)
2. Collection 接口有两个重要的子接口 List Set , 他们的实现子类都是单列集合
3. Map 接口的实现子类 是双列集合，存放的 K-V
4. 把老师梳理的两张图记住

- 单列集合

<img src="../img/TCH_Han/ch14_9.png" style="zoom:87%;" />

- 双列集合

<img src="../img/TCH_Han/ch14_10.png" style="zoom:87%;" />



## 1.2```Collection```接口实现类的特点

```java
public interface Collection<E> extends Iterable<E>
```

1. ```Collection```实现子类可以存放多个元素，每个元素可以是```Object```
2. 有些```Collection```的实现类，可以存放重复的元素，有些不行
3. 有些```Collection```的实现类，有些事有序的List，有些不是有序Set
4. ```Collection```接口没有直接的实现子类，是通过它的子接口Set和List来实现的

```java
package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.List;

public class CollectionMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
//        add:添加单个元素
        list.add("jack");
        list.add(10);//list.add(new Integer(10))
        list.add(true);
        System.out.println("list=" + list);
//        remove:删除指定元素
        //list.remove(0);//删除第一个元素
        list.remove(true);//指定删除某个元素
        System.out.println("list=" + list);
//        contains:查找元素是否存在
        System.out.println(list.contains("jack"));//T
//        size:获取元素个数
        System.out.println(list.size());//2
//        isEmpty:判断是否为空
        System.out.println(list.isEmpty());//F
//        clear:清空
        list.clear();
        System.out.println("list=" + list);
//        addAll:添加多个元素
        ArrayList list2 = new ArrayList();
        list2.add("红楼梦");
        list2.add("三国演义");
        list.addAll(list2);
        System.out.println("list=" + list);
//        containsAll:查找多个元素是否都存在
        System.out.println(list.containsAll(list2));//T
//        removeAll：删除多个元素
        list.add("聊斋");
        list.removeAll(list2);
        System.out.println("list=" + list);//[聊斋]
//        说明：以ArrayList实现类来演示.

    }
}
```



### 1.2.1```Collection```接口遍历元素方式1-使用 Iterator(迭代器)

<img src="../img/TCH_Han/ch14_11.png" style="zoom:87%;" />

<img src="../img/TCH_Han/ch14_12.png" style="zoom:87%;" />

<img src="../img/TCH_Han/ch14_13.png" style="zoom:87%;" />

```java
package com.hspedu.collection_;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionIterator {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {

        Collection col = new ArrayList();//向上转型

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));


        //System.out.println("col=" + col);
        //现在老师希望能够遍历 col集合
        //1. 先得到 col 对应的 迭代器
        Iterator iterator = col.iterator();
        //2. 使用while循环遍历 快速生成 while => itit
        //显示所有的快捷键的的快捷键 ctrl + j
        while (iterator.hasNext()) {
            //返回下一个元素，类型是Object 并多态绑定
            Object obj = iterator.next();
            System.out.println("obj=" + obj);

        }
        //3. 当退出while循环后 , 这时iterator迭代器，指向最后的元素
        //   iterator.next();//NoSuchElementException
        //4. 如果希望再次遍历，需要重置我们的迭代器
        iterator = col.iterator();//重置
        System.out.println("===第二次遍历===");
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            System.out.println("obj=" + obj);

        }

    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
```



### 1.2.2Collection 接口遍历对象方式 2-for 循环增强

**特点：**增强for就是简化版的iterator，本质相同，只能用于遍历集合或数组。

**基本语法**

```java
for (元素类型 元素名 : 集合名或数组名) {
    访问元素
}
```

```java
package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionFor {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        Collection col = new ArrayList();

        col.add(new Book("三国演义", "罗贯中", 10.1));
        col.add(new Book("小李飞刀", "古龙", 5.1));
        col.add(new Book("红楼梦", "曹雪芹", 34.6));

        //老韩解读
        //1. 使用增强for, 在Collection集合
        //2. 增强for， 底层仍然是迭代器
        //3. 增强for可以理解成就是简化版本的 迭代器遍历
        //4. 快捷键方式 I
//        for (Object book : col) {
//            System.out.println("book=" + book);
//        }
        for (Object o : col) {
            System.out.println("book=" + o);
        }

        //增强for，也可以直接在数组使用
//        int[] nums = {1, 8, 10, 90};
//        for (int i : nums) {
//            System.out.println("i=" + i);
//        }


    }
}
```



### 1.2.3课堂练习

**要求**

 * 创建  3个 Dog {name, age}  对象，放入到 ArrayList 中，赋给 List 引用
 * 用迭代器和增强for循环两种方式来遍历
 * 重写Dog 的toString方法， 输出name和age

```java
package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CollectionExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Dog("小黑", 3));
        list.add(new Dog("大黄", 100));
        list.add(new Dog("大壮", 8));


        //先使用for增强
        for (Object dog : list) {
            System.out.println("dog=" + dog);
        }

        //使用迭代器
        System.out.println("===使用迭代器来遍历===");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object dog =  iterator.next();
            System.out.println("dog=" + dog);

        }

    }
}

class Dog {
    private String name;
    private int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
```



# 2

## 2.1List 接口和常用方法

### 2.1.1List 接口基本介绍

```java
package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1. List集合类中元素有序(即添加顺序和取出顺序一致)、且可重复 [案例]
        List list = new ArrayList();
        list.add("jack");
        list.add("tom");
        list.add("mary");
        list.add("hsp");
        list.add("tom");
        System.out.println("list=" + list);
        //2. List集合中的每个元素都有其对应的顺序索引，即支持索引
        //   索引是从0开始的
        System.out.println(list.get(3));//hsp
        //3.
    }
}
```




### 2.1.2List 接口的常用方法

<img src="../img/TCH_Han/ch14_2.png" style="zoom:87%;" />

```java
package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

public class ListMethod {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("张三丰");
        list.add("贾宝玉");
//        void add(int index, Object ele):在index位置插入ele元素
        //在index = 1的位置插入一个对象
        list.add(1, "韩顺平");
        System.out.println("list=" + list);
//        boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
        List list2 = new ArrayList();
        list2.add("jack");
        list2.add("tom");
        list.addAll(1, list2);
        System.out.println("list=" + list);
//        Object get(int index):获取指定index位置的元素
        //说过
//        int indexOf(Object obj):返回obj在集合中首次出现的位置
        System.out.println(list.indexOf("tom"));//2
//        int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
        list.add("韩顺平");
        System.out.println("list=" + list);
        System.out.println(list.lastIndexOf("韩顺平"));
//        Object remove(int index):移除指定index位置的元素，并返回此元素
        list.remove(0);
        System.out.println("list=" + list);
//        Object set(int index, Object ele):设置指定index位置的元素为ele , 相当于是替换.
        list.set(1, "玛丽");
        System.out.println("list=" + list);
//        List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
        // 注意返回的子集合 fromIndex <= subList < toIndex
        List returnlist = list.subList(0, 2);
        System.out.println("returnlist=" + returnlist);

    }
}
```



### 2.1.3List 接口课堂练习 

- 添加10个以上的元素(比如String "hello" )，在2号位插入一个元素"韩顺平教育"，获得第5个元素，删除第6个元素，修改第7个元素，在使用迭代器遍历集合，要求:使用List的实现类ArrayList完成。

```java
package com.hspedu.list_;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListExercise {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
     
        List list = new ArrayList();
        for (int i = 0; i < 12; i++) {
            list.add("hello" + i);
        }
        System.out.println("list=" + list);

        //在2号位插入一个元素"韩顺平教育"
        list.add(1, "韩顺平教育");
        System.out.println("list=" + list);
        //获得第5个元素
        System.out.println("第五个元素=" + list.get(4));
        //删除第6个元素
        list.remove(5);
        System.out.println("list=" + list);
        //修改第7个元素
        list.set(6, "三国演义");
        System.out.println("list=" + list);

        //在使用迭代器遍历集合
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object obj =  iterator.next();
            System.out.println("obj=" + obj);
        }
    }
}
```



### 2.1.4List 的三种遍历方式 [ArrayList, LinkedList,Vector]



### 2.1.5实现类的课堂练习 2

```java
package com.java.learn_han.chapter14.list_;

import java.util.ArrayList;
import java.util.List;

public class ListExercise02 {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", "曹雪芹", 1000));
        list.add(new Book("西游记", "吴承恩", 100));
        list.add(new Book("水浒传", "施耐庵", 10));

        for (Object o : list) {
            System.out.println(o);
        }

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < list.size() - 1; j++) {
                Book book1 = (Book) list.get(j);//向下转型 因为返回的是 Object
                Book book2 = (Book) list.get(j + 1);

                if (book1.getPrice() > book2.getPrice()) {
                    list.set(j, book2);
                    list.set(j+1,book1);
                }
            }
        }
        System.out.println("======排序后======");
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                "author" + author + '\n' +
                ", price=" + price +
                '}';
    }
}
```



## 2.2ArrayList 底层结构和源码分析

### 2.2.1ArrayList 的注意事项

<img src="../img/TCH_Han/ch14_4.png" style="zoom:87%;" />

### 2.2.2ArrayList 的底层操作机制源码分析(重点，难点.)



<img src="../img/TCH_Han/ch14_5.png" style="zoom:87%;" />





## 2.3Vector 底层结构和源码剖析

### 2.3.1Vector 的基本介绍

<img src="../img/TCH_Han/ch14_6.png" style="zoom:87%;" />



### 2.3.2Vector 和 ArrayList 的比较

|                 | 底层结构         | 版本   | 线程安全（同步）效率 | 扩容倍数                                                     |
| --------------- | ---------------- | ------ | -------------------- | ------------------------------------------------------------ |
| ```ArrayList``` | 可变数组         | jdk1.2 | 不安全，效率高       | 如果有参构造1.5倍，如果是无参1.第一次10 2.从第二次开始按1.5扩 |
| ```Vector```    | 可变数组Object[] | jdk1.0 | 安全，效率不高       | 如果是无参，默认10满后，就按2倍扩容，如果指定大小，则每次直接按2倍扩容 |





## 2.4LinkedList 底层结构

### 2.4.1LinkedList 的全面说明 

1. LinkedList底层实现类双向链表和双端队列特点
2. 可以添加任意元素（元素可以重复），包括null
3. 线程不安全，没有实现同步



### 2.4.2LinkedList 的底层操作机制

<img src="../img/TCH_Han/ch14_7.png" style="zoom:87%;" />



### 2.4.3LinkedList 的增删改查案例



## 2.5ArrayList 和 LinkedList 的比较

|            | 底层结构 | 增删的效率         | 该查的效率 |
| ---------- | -------- | ------------------ | ---------- |
| ArrayList  | 可变数组 | 较低 数组扩容      | 较高       |
| LinkedList | 双向链表 | 较高，通过链表追加 | 较低       |



# 3

## 3.1Set 接口和常用方法

### 3.1.1Set 接口基本介绍

1. 无序（添加和取出的顺序不一致），没有索引
2. 不允许重复元素，所以最多包含一个null
3. JDK API中set接口的实现类有



### 3.1.2Set 接口的常用方法

和 List 接口一样, Set 接口也是 Collection 的子接口，因此，常用方法和 Collection 接口一样



### 3.1.3Set 接口的遍历方式



### 3.1.4Set 接口的常用方法举例





## 3.2Set 接口实现类-HashSet 

### 3.2.1HashSet 的全面说明



### 3.2.2HashSet 案例说明





### 3.2.3HashSet 底层机制说明 



### 3.2.4HashSet 课堂练习 1



### 3.2.5HashSet 课后练习 2





## 3.3Set 接口实现类-LinkedHashSet

### 3.3.1LinkedHashSet 的全面说明 



### 3.3.2LinkedHashSet 课后练习题 LinkedHashSetExercise.java





## 3.4Map 接口和常用方法



### 3.4.1Map 接口实现类的特点 [很实用]



### 3.4.2Map 接口常用方法



### 3.4.3Map 接口遍历方法





### 3.4.4Map 接口课堂练习 



## 3.5Map 接口实现类-HashMap 



### 3.5.1HashMap 小结 



### 3.5.2HashMap 底层机制及源码剖析



### 3.5.3HashMap 底层机制及源码剖析





## 3.6Map 接口实现类-Hashtable

### 3.6.1HashTable 的基本介绍



### 3.6.2Hashtable 和 HashMap 对比

|           | 版本 | 线程安全（同步） | 效率 | 允许null健null值 |
| --------- | ---- | ---------------- | ---- | ---------------- |
| HashMap   | 1.2  | 不安全           | 高   | 可以             |
| Hashtable | 1.0  | 安全             | 较低 | 不可以           |





## 3.7Map 接口实现类-Properties

### 3.7.1基本介绍 



### 3.7.2基本使用 



## 3.86总结-开发中如何选择集合实现类(记住)

```
```
# 4

## 4.1Collections 工具类

### 4.1.1Collections 工具类介绍 



### 4.1.2排序操作：（均为 static 方法)



### 4.1.3排序操作：（均为 static 方法) 



### 4.1.4查找、替换

```
```
# 作业
```
```