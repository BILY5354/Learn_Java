# [数组、排序和查找](./TCH_Han/Chapter6.md)  

# 值得注意的概念
- 每个数组是存放**同一类型**数据的
- 
- 
-  
1. [数组的基本概念](#1)
2. [](#2)
3. [](#3)
4. [](#4)
5. [作业](#作业)  
## 1

### 1.1 数组的使用

声明->创建->初始化

```java
//声明
int myArray[];
myArray[] int;//推荐


//创建:数据类型 数组名[] = new 数据类型[大小];
int myArray[] = new int[5];//动态定义方式1

int myArray[];//动态定义方式2
myArray = new int[5];

int myArrayLength = myArray.length;//获取数组长度，为5


//初始化
int a[] = {1,2,3,4,5};//静态初始化

int a[] = new int[5];//这两句相当于静态初始化
a[0] = 1;	a[1] = 2;	a[2] = 3;	
a[3] = 4;	a[4] = 5;
```


### 1.2 定义一个用于存放26个字母的数组并显示

```java
public class myHomework {
	public static void main(String args[]) {
		char[] chars = new char[26];

		for (int i = 0; i < chars.length; i++) {
			chars[i] = (char)('A' + i);//与整型相加会自动转换，故需强转
		}

		for (int i = 0; i < chars.length; i++) {
			System.out.print(chars[i] + " ");
		}
	}
}
```



### 1.3 数组赋值机制

如果对数组直接复制（暂不考虑长度情况），**两数组会共用内存地址**。所以修改```myList```的值```myList2```的值也会被改变。

```java
int[] myList = {1,2,3,4};
int[] myList2 = new int[4];
myList2 = myList;//直接赋值机制
```



### 1.4 数组拷贝

用了```1.3```的概念，那我想独立的怎么办（修改```myList```并不会改变```myList2```）？

```java
//方法一:一个一个赋值
for (int i =0; i < myList.length; i++) {
    myList2[i] = myList[i];
}
```



### 1.5 数组反转

**需要注意的是判断次数```myList.length```错误**，因为这样写是调转又调转了，等于没调。

```java
//方法1:：原数组调转
for (int i = 0; i < myList.length / 2; i++) {//一定要除2
    int temp = myList[i];
    myList[i] = myList[myList.length - 1 - i];
    myList[myList.length - 1 - i] = temp;
}

//方法2：逆序赋值
int[] myList2 = new int[myList.length]; //逆序遍历 myList 
for (int i = myList.length - 1, j = 0; i >= 0; i--, j++) { 
    myList2[j] = myList[i]; 
}
```



### 1.6 数组添加/扩容



## 2

```
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