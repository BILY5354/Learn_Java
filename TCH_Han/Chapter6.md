# [数组、排序和查找](./TCH_Han/Chapter6.md)  

# 值得注意的概念
- 每个数组是存放**同一类型**数据的

- 二维数组实际上是多个一维数组组成，其中每个一维数组的长度可以不相同

  
1. [一维数组的基本概念](#1)
2. [冒泡、插入和选择排序](#2)
3. [二维数组](#3)
4. [](#4)
5. [作业](#作业)  
## 1

### 1.1 一维数组的使用

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


### 1.2 定义一个用于存放26个字母的一维数组并显示

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



### 1.3 一维数组赋值机制

如果对数组直接复制（暂不考虑长度情况），**两数组会共用内存地址**。所以修改```myList```的值```myList2```的值也会被改变。

```java
int[] myList = {1,2,3,4};
int[] myList2 = new int[4];
myList2 = myList;//直接赋值机制
```



### 1.4 一维数组拷贝

用了```1.3```的概念，那我想独立的怎么办（修改```myList```并不会改变```myList2```）？

```java
//方法一:一个一个赋值
for (int i =0; i < myList.length; i++) {
    myList2[i] = myList[i];
}
```



### 1.5 一维数组反转

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



### 1.6 一维数组添加/扩容

值得注意```next()```方法返回的是字符串，所以需要```charAt(0)```取一个字符。[注意这里使用```arr = arrNew;```](#1.3 数组赋值机制)

```java
import java.util.Scanner;

public class myHomework {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);

		int arr[] = {1, 2, 3};

		do {
			int[] arrNew = new int[arr.length + 1];//新建一个长度+1的数组	扩容
			//遍历 arr 数组，依次将arr的元素拷贝到 arrNew数组
			for(int i = 0; i < arr.length; i++) {
				arrNew[i] = arr[i];
			}
			System.out.println("请输入你要添加的元素");
			int addNum = sca.nextInt();
			arrNew[arrNew.length - 1] = addNum;
			arr = arrNew;//共用地址

			System.out.println("====arr扩容后元素情况====");
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + "\t");
			}
			System.out.println("是否继续添加 y/n");
			
			char flag = sca.next().charAt(0);
			if (flag == 'n') { 
				break; 
			}
		} while(true);
	}
}
```



## 2
 三大排序（冒泡、排序、选择）

### 2.0 **总结**

如果要升序排```54321```

- 冒泡排序中这个5就一路交换（第一轮） 45321
  43521
  43251
  43215
- 选择排序则是直接抽出来 14325
- 插入排序则是 （第二轮情况）45321
  45521（3是原先的手牌嘛最后放回去）
  44521
  34521



**下面三个例子都是升序**，由小到大。

### 2.1 冒泡排序
```java
class Sort {
	public void bubble (int a[], int size) {
		int temp;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < size - i; j++) {//这里是 size - i
				//注意是冒泡是在外循环下，内循环进行两两比较
				if (a[j] > a[j + 1]) {//如果改成 < 便是降序，由大到小
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
```



### 2.2 选择排序
```java
class Sort {
	public void select (int a[], int size) {
		int max = 0, temp = 0;//max即存放最大的，temp则是用与交换的
		for (int i = 0; i < size - 1; i++) {//这里是与冒泡不同的地方，从0开始
			max = i;
			for (int j = i + 1; j < size; j++) {
				if (a[j] < a[max]) {//后面存放的数比第一个还小，则交换
					max = j;//假设第一个最小
				}
			}
			temp = a[max];
			a[max] = a[i];;//为什么换i，因为i是现最前面的数
			a[i] = temp;
		}

	}
}
```



### 2.3 插入排序
因为插入排序的特点，所以是没有temp的

```java
class Sort {
	//插入排序 升序
	public void isort(int a[],int size) {
	    int inserter, index;
	    for (int i = 1; i < size; i++) {//与冒泡一样，第二位开始拿牌，前面有i-1张牌可以拿
	        inserter = a[i];//inserter要插入的牌就是手牌
	        index = i - 1;
	        while (index >= 0 && inserter < a[index]) {//如果从牌池中拿出的牌比手牌大，则交换（这种交换就像冒泡一样两两交换）
	            a[index + 1] = a[index];//不要写index++
	            index--;
	        }
	        a[index + 1] = inserter;//最后把一开始的牌放回去
	    }
	}
}

```



### 2.4 实现相同功能时与```C```的对比
```C```面向过程的语言，在实现一个具体功能时（冒泡排序为例）。只需写一个实现冒泡的**函数**并在主函数**直接调用**即可。可```Java```不同，面向对象的思想就是将世界的不同对象封装成类，所以我不可能单独写一个函数然后像```C```那样直接调用。那么怎么定义？

```c
int main()
{
    int a[] = {5, 4, 3, 2, 1};
    bubble(a, 5);//直接使用即可
    return 0;
}

//test2_1 冒泡排序
void bubble(int a[], int size)
{
	int temp;
	//略略
}
```



- 方法一：
  - 那就将排序都封装成一个```class```(类)，里面包括排序、插入等不同的排序方法。需要使用时，**先创建一个新的对象，再用这个对象调用排序方法**
  - 需要注意的是，一个```Java```文件最好只有一个类，这里不太规范

```java
public class myHomework {
	public static void main(String[] args) {
		int a[] = {10,8,6,4,1};
		Sort sort = new Sort();//先创建一个新的排序对象
		sort.bubble(a, a.length);//使用该对象的冒泡排序方法
	}
}

class Sort {//这里不能写public，因为一个文件中只能有一个class被声明为public
	public void bubble(int a[], int size) {
		//略略
	}
}
```



- 方法二：使用静态类，（这个知识点有些超现在的进度了，先记录下）

```java
public class myHomework {
	public static void main(String[] args) {
		int a[] = {10,8,6,4,1};
		bubble(a, a.length);
	}

	static void bubble(int a[], int size) {//使用静态类
		int temp;
		//略略
	}
}
```



## 3
### 3.1 二维数组的使用
```java
//二维数组声明
int[][] arr;	int[] arr[];	int arr[][];

//动态初始化1
类型 [][] 数组名 = new 类型[大小][大小];
int a[][] = new int [2][3];

//动态初始化2，先声明后定义
int arr[][]; 
arr = new int[2][3];//再开空间 

//动态初始化3，列数不确定
int[][] arr = new int[3][];//创建 二维数组，一个有3个一维数组，但是每个一维数组还没有开数据空间 

for(int i = 0; i < arr.length; i++) {
    //给每个一维数组开空间 new
    //如果没有给一维数组 new ,那么 arr[i]就是null
    arr[i] = new int[i + 1]; 

    for(int j = 0;  j < arr[i].length; j++) {  //遍历一维数组，并给一维数组的每个元素赋值
        arr[i][j] = i + 1;//赋值
    }
}

//静态初始化
类型 数组名[][] = {{值1， 值2...}, {值1， 值2...}, {值1， 值2...}};
int[][] arr = {{1, 2, 3}, {8, 8, 8}, {66, 2}};
```


### 3.2 案例：杨辉三角

![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171502511.png)

```java
public class myHomework {
	public static void main(String[] args) {
		int[][] yh = new int[12][];

		//初始化并赋值
		for (int i = 0; i < yh.length; i++) {
			yh[i] = new int[i + 1];

			for (int j = 0; j < yh[i].length; j++) {
				if (j == 0 || j == yh[i].length - 1) {//首尾为1
					yh[i][j] = 1;
				} else if(j > 0 && i > 0) {
					yh[i][j] = yh[i - 1][j] + yh[i - 1][j - 1];
				}
			}
		}

		//显示
		for (int i = 0; i < yh.length; i++) {
			for (int j = 0; j < yh[i].length; j++) {
				System.out.print(yh[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
```



## 4

```
```




## 作业

![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171503635.png)
![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171503789.png)

### 将元素插入升序数组

- 我的思路：判断插入的数在什么位置，如果在前面就逐个往后推，虽然增加了插入的数是自己输入的，但这样的判断有些太麻烦了

```java
import java.util.Scanner;

public class myHomework4 {
	public static void main(String args[]) {
		Scanner sca = new Scanner(System.in);
		int a[] = {10, 12, 45, 90};
		
		System.out.println("插入前的数组：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println("\n输入插入的整数：");
		int insert = sca.nextInt();
		
		int[] a_new = new int[a.length + 1];//新数组长度加1
		for (int i = 0; i < a.length; i++) {//先弄到新数组再插入
			a_new[i] = a[i];
		}

		//开始插入
		for (int i = 0; i < a_new.length; i++) {
			if (insert < a_new[i]) {//小于情况
				for (int j = a_new.length - 1; j > i; j--) {//都往后一位
					a_new[j] = a[j - 1];
				}
				a_new[i] = insert;
				break;//已经插入了，退出
			} else if (insert > a_new[a_new.length - 2]) {//倒数第二位最大
				a_new[a_new.length - 1] = insert;
				break;
			} else if(insert == a_new[i]) {//等于情况
				for (int j = a_new.length - 1; j > i; j--) {//都往后一位
					a_new[j] = a[j - 1];
				}
				a_new[i] = insert;
				break;
			}
		}

		System.out.println("插入后的数组：");
		for (int i = 0; i < a_new.length; i++) {
			System.out.print(a_new[i] + " ");
		}
	}
}
```



- 韩老师思路：先确定 添加数应该插入到哪个索引，然后扩容

```java
import java.util.Scanner;

public class myHomework4 {
	public static void main(String args[]) {
		Scanner sca = new Scanner(System.in);
		int a[] = {10, 12, 45, 90};
		int index = -1; //index就是要插入的位置
		
		System.out.println("插入前的数组：");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

		System.out.println("\n输入插入的整数：");
		int insertNum = sca.nextInt();
		
		int[] a_new = new int[a.length + 1];//新数组长度加1
		for (int i = 0; i < a.length; i++) {//先弄到新数组再插入
			a_new[i] = a[i];
		}

        //韩老师：
	 	for(int i = 0; i < a.length; i++) {//遍历数组赵插入的下标
            if(insertNum <= a[i]) {
                index = i;
                break; //找到位置后，就退出
            }
        }

        //判断index 的值
        if(index == -1) { //说明没有还没有找到位置
                index = a.length;
        }

     	for(int i = 0, j = 0; i < a_new.length; i++) { //i 控制a_new的下标  , j用来控制a数组的下标
            if( i != index ) { //说明可以把 a的元素拷贝到 a_new
                a_new[i] = a[j++];//先赋值后自增	
            } else { //i这个位置就是要插入的数
                    a_new[i] = insertNum;
            }
        }

        //让a 指向 a_new , 原来的数组，就成为垃圾，被销毁
        a = a_new;

		System.out.println("插入后的数组：");
		for (int i = 0; i < a_new.length; i++) {
			System.out.print(a_new[i] + " ");
		}
	}
}
```





### 随机生成10个数保存到数组并执行相关操作

- 先找怎么随机生成一个数，发现值在0.0到1.0，所以要扩大100倍加1并且转型。

![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171503918.png)

```java
public class myHomework5 {
	public static void main(String args[]) {
		int[] arr = new int[10];
		int max = 0, max_nu = 0;//最大值、下标
		double ava = 0;//平均值
		boolean flag = false;

		for (int i = 0; i < 10; i++) {
			arr[i] = (int)(Math.random()*100+1);//使数为1到100且为整型
			ava += arr[i];//求平均值先累加

			if (max < arr[i]) {//求最大值和下标
				max = arr[i];
				max_nu = i;
			}

			if (arr[i] == 8) {//判断是否包含8
				flag = true;
			}
		}

		System.out.println("将原数组输出：");
		for (int i = 0; i < 10; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println("\n将原数组倒序输出：");
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i] + "\t");
		}

		System.out.println("\n" + "最大值为:" + max + "\t" + "改值对应初始下标为：" + max_nu + "\t" + "平均值为：" + ava/10);

		if (flag) {
			System.out.println("该数组包含8");
		} else {
			System.out.println("该数组没有包含8");
		}

	}
}
```



### 冒泡排序

```java
class Sort {
	public void bubble (int a[], int size) {
		int temp;
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < size - i; j++) {//这里是 size - i
				//注意是冒泡是在外循环下，内循环进行两两比较
				if (a[j] > a[j + 1]) {//如果改成 < 便是降序，由大到小
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
		}
	}
}
```