# [面向对象编程（基础部分）](./TCH_Han/Chapter7.md)  
# 值得注意的概念
- 体会面相过程与面向对象的不同之处
- 在一个类中，方法内不能再定义一个方法，**不能嵌套**
- 实参和形参的类型要一致或兼容、个数、顺序必须一致
- 形参拷贝是不会影响实参的



1. [类与对象](#1)
2. [](#2)
3. [](#3)
4. [](#4)
5. [作业](#作业)  
## 1

### 1.1 创建对象

```java
//先声明再创建
Cat cat;
cat = new Cat();

//直接创建
Cat cat = new Cat();
```



### 1.2 成员方法

像上一章说的[实现相同功能时与```C```的对比](./Chapter6.md#2)，因为```Java```把世间万物都封装成类了，然后类有一个个方法，这些在类里面方法就称为**成员方法**。与面向过程语言```C```的子程序、函数概念相当。

> 我的（**片面**）理解是想要在```Java```实现数组输出的方法，也需要定义一个类然将这个方法放到其中。
>
> 为什么要这样做呢，为什么不可以像```C```那样在主函数外面定一个新的函数然再主函数中调用即可？而是要定义一个类把方法（对应```C```的函数）放在其中，然调用时候先创建一个对象再用这个对象调用方法呢。
>
> 因为如果只是实现这一个步骤，相比与```C```要定义一个类好像有些多余，但是```Java```的思想就是**面向对象**的，把世间万物看成共同共有的属性抽取出来定义成类，然就可以让拥有这些属性的事物去使用。
>
> 这是编程思想的不同。虽然这里举的例子是先想到实现一个方法然却发现这样在```Java```中运行不了，故为其封装成一个类，毫无疑问一开始我被面向过程的思想所影响了。
>
> 就像是所有的载具都有加速这一属性，如果现在```Java```中要开发游戏中的驾驶汽车模块，就得先定义载具类然在这个类中定义加速这个方法。



### 1.3 方法的使用例子

```java
//方法在同一类中，直接调用即可
class A {
    public void print(int n) {
        System.out.println("方法被调用：n = " + n);
    }
    public void sayNu() {
        print(100);//调用同类方法
    }
}


//跨类方法调用，则需要创建对象
class A {
    B b = new B();
    b.hi();//跨类调用
}

class B {
    public void hi() {
        System.out.println("B类中的hi方法被执行");
    }
}
```



### 1.4 课堂练习(1)：写方法判断奇偶数并返回```boolean```

```java
import java.util.Scanner;

public class myHomework {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		System.out.print("输入要判断奇偶的数：");
		int nu = sca.nextInt();

		AA a = new AA();

		if (nu < 0) {//负数的处理
			nu *= -1;
		}

		if (a.panDuan(nu)) {
			System.out.println("输入的是奇数");
		} else {
			System.out.println("输入的偶数");
		}
	} 
}

class AA {
	public boolean panDuan(int n) {
		if (n % 2 == 1) { //奇数
			return true;//奇数为真
		} else {
			return false;
		}
	}
} 	
```



### 1.5课堂练习(2)：输入行、列与符号打印出对应效果

```java
import java.util.Scanner;

public class myHomework {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		AA a = new AA();

		a.printTip("输入行：");
		int hang = sca.nextInt();
		a.printTip("输入列：");
		int lie = sca.nextInt();
		a.printTip("输入字符：");
		char c = sca.next().charAt(0);
		
		a.printSth(hang, lie, c);

		sca.close();
	} 
}

class AA {
	public void printTip(String str) {//其实用语
		System.out.println(str);
	}

	public void printSth(int i, int j, char c) {//行、列、所打印的字符
		printTip("输出结果：");//同类调用
		for (int a = 0; a < i; a++) {
			for (int b = 0; b < j; b++) {
				System.out.print(c);
			}
			printTip("\t");//同类调用，换行
		}
	}
} 	
```





## 2

### 2.1  基本数据类型传参机制

**形参改变并不会影响实参**。

```java
public class myHomework {
	public static void main(String[] args) {
		int a = 10; int b = 20; //创建 AA 对象 名字 obj 
		AA obj = new AA(); 
		obj.swap(a, b); //调用 swap 
		System.out.println("main 方法 a=" + a + " b=" + b);//a=10 b=20
	} 
}

class AA {
	public void swap(int a, int b) {
		int temp = a;
		a =b;
		b= temp;
		System.out.println("swap 方法 a=" + a + " b=" + b);
	}
} 	
```


### 2.2 引用数据类型传参机制 （数组，对象）

**引用类型**传递的是地址（传递也是值，但是值是地址），可以通过**形参影响实参**。

- 数组

```java
public class myHomework {
	public static void main(String[] args) {

		int[] arr = {1, 2, 3};
		System.out.println("main方法中的数组 ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

		BB b = new BB();
		b.test100(arr);//调用
	} 
}

class BB {
	public void test100(int[] arr) {
		arr[0] = 200;
		System.out.println("test100方法中的数组 ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}
} 		
```

![](../img/TCH_Han/ch7_1.png)



- 对象

# 为什么p=null 和 p = new Person(); 对应示意图！不懂！

```java
public class myHomework {
	public static void main(String[] args) {

		BB b = new BB();
		
		//操作1
		Person p = new Person();
		p.name = "jack";
		p.age = 10;
		System.out.println("main 的 p.name 和p.age:\n" + p.name + "\t" + p.age);
		b.test200(p);
		System.out.println("执行操作一 的 p.name 和 p.age:\n" + p.name + "\t" + p.age);
		
		//操作2
		Person p1 = new Person();
		p1.name = "jack";
		p1.age = 10;
		System.out.println("\nmain 的 p1.name 和p1.age:\n" + p1.name + "\t" + p1.age);
		b.test201(p1);
		System.out.println("执行操作二 和p1.age:\n" + p1.name + "\t" + p1.age);
		
		//操作3
		Person p2 = new Person();
		p2.name = "jack";
		p2.age = 10;
		System.out.println("\nmain 的 p2.name 和p2.age:\n" + p2.name + "\t" + p2.age);
		b.test201(p2);
		System.out.println("执行操作三 和p2.age:\n" + p2.name + "\t" + p2.age);
	} 
}

class Person {
	String name;
	int age;
}

class BB {
	//操作1
	public void test200(Person p) {
		p.age = 9999;//修改属性
	}
	//操作2
	public void test201(Person p) {
		p = new Person();//修改属性
		p.name = "tom";
		p.age = 99;
	}
	//操作3
	public void test202(Person p) {
		p = null;
	}
} 	
```

<img src="../img/TCH_Han/ch7_2.png" style="zoom:67%;" />



### 2.3 成员方法返回类型是引用类型的实例

```java
public class myHomework {
	public static void main(String[] args) {

		Person p = new Person();
		p.name = "martin";
		p.age = 100;
		MyTools tools = new MyTools();
		Person p2 = tools.copyPerson(p);

		//到此 p 和 p2 是 Person 对象，但是是两个独立的对象，属性相同 
		System.out.println("p 的属性 age=" + p.age + " 名字=" + p.name); 
		System.out.println("p2 的属性 age=" + p2.age + " 名字=" + p2.name); 
		
		System.out.println(p == p2);//可以像对象比较看看是否为同一个对象 
	} 
}

class Person {
	String name;
	int age;
}

class MyTools {
	public Person copyPerson(Person p) {
		Person p1 = new Person();
		p1.name = p.name;
		p1.age = p.age;
		return p1;
	}
}
```

![](../img/TCH_Han/ch7_3.png)



## 3

### 3.1 课堂练习(1)：递归实现斐波那契

```java
import java.util.Scanner;

public class myHomework {
	public static void main(String[] args) {

		Scanner sca = new Scanner(System.in);
		T t = new T();
		System.out.print("输入整数：");
		int i = sca.nextInt();
		System.out.println(i + " 的斐波那契数是： " + t.fibonacci(i));
	} 
}

class T {
	public int fibonacci(int n) {
		if( n >= 1) { 
			if( n == 1 || n == 2) { 
				return 1; 
			} else { 
				return fibonacci(n-1) + fibonacci(n-2); 
			} 
		} else { 
			System.out.println("要求输入的 n>=1 的整数"); return -1; 
		}
	}
}
```



### 3.2课堂练习(2)：递归实现猴子吃桃

```java
```




## 4

```
```
## 作业
```
```