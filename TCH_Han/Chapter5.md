# [程序控制结构](./TCH_Han/Chapter5.md)  
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
## 1
```
```
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

<img src="../img/TCH_Han/ch5_0.png" style="zoom:67%;" />

<img src="../img/TCH_Han/ch5_1.png" style="zoom:67%;" />



### 过路口

```java
public class myHomework1 {
	public static void main(String args[]) {
		int num = 0;//路口数
		double money = 100000;
		while(money > 50000) {
			money -= (money*0.05);
			num++;
		}
		System.out.println("大于5000共经过路口：" + num);
		while(money > 1000) {
			money -= 1000;
			num++;
		}
		System.out.println("共经过路口：" + num);
	}
}
```



### 判断数的范围

```java
public class myHomework2 {
	public static void main(String args[]) {
		int n = 22;
		if (n > 0) {
			System.out.println("大于0");
		} else if (n < 0) {
			System.out.println("小于0");
		} else {
			System.out.println("等于0");
		}
	}
}
```



### 判断是否为闰年

- 能被4整除且不能被100整除
- 能被400整除

```java
import java.util.Scanner;

public class myHomework3 {
	public static void main(String args[]) {
		
		Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要计算的年份:");
        int year = scanner.nextInt();    //year为输入的年份
        
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            System.out.println(year+"年是闰年");
        } else {
            System.out.println(year+"年不是闰年");
        }	

	}
}
```



### 输入整数判断水仙花

```java
import java.util.Scanner;

public class myHomework4 {
	public static void main(String args[]) {
		System.out.println("输入需判断水仙花的整数：");
		Scanner sca  = new Scanner(System.in);
		int i = sca.nextInt();
		int ge = i%10, shi = (i%100)/10, bai = i/100;
		if(i == (ge*ge*ge + shi*shi*shi + bai*bai*bai)) {
			System.out.println("恭喜");
		} else {
			System.out.println("很遗憾");
		}
	}
}
```

