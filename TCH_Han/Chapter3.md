# [变量](./TCH_Han/Charpter3.md)

# 值得注意的概念
- **变量三要素**：变量=变量名+值+数据类型
- 长整型需要在数后加上```l```或```L```（**默认为```int```**）、单精度浮点型需加```f```或```F```（**默认为```double```**）
- [Java中文在线文档](https://www.apiref.com/java11-zh/index.html)
-  char的本质是一个整数，在输出时是unicode码对应的字符，所以它是可以进行运算的

1. [Java数据类型](#1)
2. [数据类型转换](#2)
3. [ASIIC表](#3)
4. [基本数据类型与```String```类型转换](#4)  
4. [作业](#作业)
## 1
**图（必记）**
![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171455829.png)




## 2
![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171456633.png)

### 2.1 数据类型转换-自动转换

- 不同类型数据混合运算会自动转换成**容量（精度）最大**的数据类型

```java
float d1 = n1 + 1.1;//错，因为浮点默认是double
```

- 自动转换的方向只有从**容量（精度）小到容量大**，反之错误，[如果从容量大变容量小则需强转](#数据类型转换-强制转换)

```java
int n2 = 1.1;//错，因为不可大到小
```

- ```byte```、```short```和```char```之间**不会相互自动转换**

```java
byte b2 = n2;//错，变量赋值需判断类型，整型比byte”高一级“

byte b1 = 10;
char c1 = b1;//错，byte不可自动转char
```

- ```byte```、```short```和```char```之间可以计算，但需先转换为```int```

```java
byte b1 = 1;
byte b3 = 2;
short s1 = 1;
short s2 = b2 + s1;//错
int s2 = b2 + s1;//对
```

- ```boolean```不参与转换

```java
boolean pass = true;
int num = pass;//错
```





### 2.2 数据类型转换-强制转换

- 强制转换可使用小括号提升优先级
- ```char```可以保存```int```的常量值，但**不可以保存**```int```变量
- ```byte```和```short```、```char```类型在进行运算时，当做```int```处理

```java
int y = (int)8.8;

char c1 = 100;//正确

int m = 100;
char c2 = m;//错
```


## 3
![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171456375.png)

## 4

### 4.1 基本型转```String```
```java
int n1 = 100;
float f1 = 1.1f;
double d1 = 4.5;
boolean b1 =true;
String s1 = n1 + "";
String s2 = f1 + "";
String s3 = d1 + "";
String s4 = b1 + "";
```

### 4.2 ```Stirng```转基本型
```java
String s5 = "123";
int num1 = Integer.parseInt(s5);
double num2 = Double.parseDouble(s5);
float num3 = Float.parseFloat(s5);
long num4 = Long.parseLong(s5);
byte num5 = Byte.parseByte(s5);
short num6 = Short.parseShort(s5);
boolean b = Boolean.parseBoolean("true");
```

### 4.3 ```String```转```char```
```java
String s1 = "Hello";
char c1 = s1.charAt(0);
System.out.println(c1);//输出 H
```



## 作业
![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171457374.png)
![](https://raw.githubusercontent.com/BILY5354/Learn_Java/master/img/TCH_Han/202206171457661.png)

1. as
```
n3 = 30
n5 = 8
```

2. as
```java
public class myHomework2 {
	public static void main(String args[]) {
		char c1='\n';
		char c2='\t';
		char c3='\r';
		char c4='\\';
		char c5='1';
		char c6='2';
		char c7='3';
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
		System.out.println(c5);
		System.out.println(c6);
		System.out.println(c7);
	}
}
```

3. **不要把```"\t"```写成```'\t'```否则会显示数字**
   - 这是因为单引号是字符串，字符串的相加实际上是对应ASCII码相加
   - ```System.out.println('a'+'b');```相当于97+98故显示195

```java
public class myHomework3 {
	public static void main(String args[]) {
		String book1="小学语文",book2="初中物理";
		char sex1='男',sex2='女';
		double price1=17.2,price2=8.29;
		System.out.println(book1+"\t"+book2);
		System.out.println(sex1+"\t"+sex2);
		System.out.println(price1+"\t"+price2);
	}
}
```

4. 
```java
public class myHomework4 {
	public static void main(String argsp[]) {
		String name="张三",hobby="玩游戏";
		int age=12;
		float grade=59;
		char sex='男';
		System.out.println("姓名\t\t年龄\t成绩\t性别\t爱好\n"
			+name+"\t\t"+age+"\t"+grade+"\t"+sex+"\t"+hobby);
	}
}
```

 



