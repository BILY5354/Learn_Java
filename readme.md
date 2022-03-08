# Learn Java

**环境基于```JDK14```开发**，*如果有时候报错可能是因为版本不同导致的*，列：

```java
var p = new Person();		//JDK8时会报错
Person p = new Person();	//JDK8正确
```

**学习中参考的资料有**，笔记主要以以下教程记录，*（如有侵权，联系速删）*

- [零基础 快速学Java by 韩老师](https://www.bilibili.com/video/BV1fh411y7R8?spm_id_from=333.999.0.0)
- Java核心技术
- ...

**本仓库的结构**

- ```img```用于存放笔记图片
  - ```Notion```笔记的图片
  - 韩老师课程时的图片
- ```Learn_Core_Java```用于记录学习java核心技术时的笔记
- ```myCode```在学习中打的代码工程文件
  - ```Learn_Java_code```韩老师的代码，主要从第八章开始
- ```TCH_Han```用于记录学习韩老师课程时的笔记
- ```notion.md```
- ```readme.md```本页面

**快速构建**,在```txt```编辑后将后缀改成```bat```

```sh
md 1		//新建文件夹并命名为1
copy nul A5	//新建空白txt文件并命名为A5
```

**本笔记遇到的坑**

```sh
javac -encoding utf8 test.java 		//使编译汉字不会显示乱码
../ 							  //回上级目录，用于正确找到图片
```

**便捷的命令**（在本仓库根目录代右键Git Bash here）

```shell
//看java代码有多少行
find . "(" -name "*.java"  ")" -print | xargs wc -l
//行md文件有多少行
find . "(" -name "*.md"  ")" -print | xargs wc -l
//在TCH_Han文件夹下搜索“命名”
grep -nri 命名 TCH_Han | cat --number
```

**学习中浏览过的网站**

- [菜鸟教程](https://www.runoob.com/) 用于快速了解，比如```Java```中数组怎么定义
- [Java中文在线文档](https://www.apiref.com/java11-zh/index.html) 用于查看类的方法等
- ...

**学习中使用到的工具**

- [Typora](https://typora.io/):用```Markdown```语法记代码笔记，关键可以实时浏览
- [Sublime](https://www.sublimetext.com/):敲```Java```代码的敌方
- [Terminal](https://github.com/microsoft/terminal):用于编译```Java```文件，而且集成了```cmd```和```PowerShell```
- [git](https://git-scm.com/):用于本地笔记的上传到码云或```GitHub```
- [WinMerge](https://winmerge.org/):照老师代码敲时，比对自己写的代码和老师代码不同（Subline也有插件的）
- [SniPaste](https://www.snipaste.com/#):截图，关键可以悬浮在屏幕最前面而且支持多张
- [Notion](https://www.notion.so/zh-cn)：很强大
- idea:无需介绍YYDS
- 浏览Pdf软件




| ✔    | ✘    |
| ---- | ---- |
| ✔    | ✘    |



*****



## 零基础 快速学Java

### 第一阶段(P001 - P373)
#### [第01章 内容介绍(P001 - P006)](./TCH_Han/Chapter1.md)  
- [基本简介](./TCH_Han/Chapter1.md#1)  
#### [第02章 Java概述(P007 - P034)](./TCH_Han/Chapter2.md)
- [常用的转义字符](./TCH_Han/Chapter2.md#1)
- [Java中注释类型](./TCH_Han/Chapter2.md#2)
- [DOS命令](./TCH_Han/Chapter2.md#3)
- [**用cmd编辑Java文件**](./TCH_Han/Chapter2.md#4)  (*有Linux与Window*)
- [作业](./TCH_Han/Chapter2.md#5)
#### [第03章 变量(P035 - P062)](./TCH_Han/Chapter3.md)  
- [Java数据类型](./TCH_Han/Chapter3.md#1)
- [数据类型转换](./TCH_Han/Chapter3.md#2)
- [ASCII表](./TCH_Han/Chapter3.md#3)
- [基本数据类型与```String```类型转换](./TCH_Han/Chapter3.md#4)  
- [作业](./TCH_Han/Chapter3.md#作业)

#### [第04章 运算符(P063 - P103)](./TCH_Han/Chapter4.md)  

- [看程序写答案](./TCH_Han/Chapter4.md#1)
- [三元运算符与运算优先级](./TCH_Han/Chapter4.md#2)
- [标识符的命名规则和规范](./TCH_Han/Chapter4.md#3)
- [用户输入和进制简要](./TCH_Han/Chapter4.md#4)  
- [作业](./TCH_Han/Chapter4.md#作业)  

#### [第05章 程序控制结构(P104 - P155)](./TCH_Han/Chapter5.md)  

- [案例：输入同学成绩求平均分与不及格人数](./TCH_Han/Chapter5.md#1)
- [打印9*9乘法表](./TCH_Han/Chapter5.md#2)
- [循序渐进打印金字塔](./TCH_Han/Chapter5.md#3)
- [作业](./TCH_Han/Chapter5.md#作业)  

#### [第06章 数组、排序和查找(P156 - P191)](./TCH_Han/Chapter6.md)  
- [一维数组的基本概念](./TCH_Han/Chapter6.md#1) 
- [冒泡、插入和选择排序](./TCH_Han/Chapter6.md#2) *还说明了使用```Java```与```C```（面向过程）编程时的不同（以实现排序为例）*
- [二维数组](./TCH_Han/Chapter6.md#3)
- [作业](./TCH_Han/Chapter6.md#作业)  

#### [第07章 面向对象编程（基础部分）(P192 - P263)](./TCH_Han/Chapter7.md)  
- [类与对象](./TCH_Han/Chapter7.md#1)
- [传参机制](./TCH_Han/Chapter7.md#2)
- [递归练习](./TCH_Han/Chapter7.md#3)
- [方法重载](./TCH_Han/Chapter7.md#4)  
- [可变参数与作用域](./TCH_Han/Chapter7.md#5)  
- [构造器与对象创建](./TCH_Han/Chapter7.md#6)  
- [```this```关键字](./TCH_Han/Chapter7.md#7)  
- [作业](./TCH_Han/Chapter7.md#作业)  

#### [第08章 面向对象编程（中级部分）(P264 - P361)](./TCH_Han/Chapter8.md)  
- [```IDEA```的使用](./TCH_Han/Chapter8.md#1) *并简要介绍了```IDEA```*的设置
- [面向对象特性-封装](./TCH_Han/Chapter8.md#2)
- [面向对象特性-继承](./TCH_Han/Chapter8.md#3)
- [```super```关键字](./TCH_Han/Chapter8.md#4)  
- [方法重写/覆盖```override```](./TCH_Han/Chapter8.md#5)  
- [面向对象特性-多态](./TCH_Han/Chapter8.md#6)  
- [```object```类](./TCH_Han/Chapter8.md#7)  
- [课堂练习:零钱通](./TCH_Han/Chapter8.md#8)  
- [作业](./TCH_Han/Chapter8.md#作业)  

#### [第09章 房屋出租系统(P362 - P373)](./TCH_Han/Chapter9.md)   *代码项目章节*
### 第二阶段(P374 - P661)
#### [第10章 面向对象编程（高级部分）(P374 - P424)](./TCH_Han/Chapter10.md)  
- [类变量与类方法](./TCH_Han/Chapter10.md#1)
- [理解```main```方法语法](./TCH_Han/Chapter10.md#2)
- [代码块](./TCH_Han/Chapter10.md#3)
- [单例设计模式](./TCH_Han/Chapter10.md#4)  
- [```final```关键字](./TCH_Han/Chapter10.md#5)  
- [抽象类](./TCH_Han/Chapter10.md#6)  
- [抽象类最佳实践](./TCH_Han/Chapter10.md#7)  
- [接口](./TCH_Han/Chapter10.md#8)
- [内部类](./TCH_Han/Chapter10.md#9)    
- [作业](./TCH_Han/Chapter10.md#作业)  

#### [第11章 枚举和注解(P425 - P443)](./TCH_Han/Chapter11.md)  
- [](./TCH_Han/Chapter11.md#1)
- [](./TCH_Han/Chapter11.md#2)
- [](./TCH_Han/Chapter11.md#3)
- [](./TCH_Han/Chapter11.md#4)  
- [作业](./TCH_Han/Chapter11.md#作业) 

#### 第12章 异常(P444 - P459)



#### 第13章 常用类(P460 - P498)
#### 第14章 集合(P499 - P553)
#### 第15章 泛型(P554 - P568)
#### 第16章 坦克大战1(P569 - P579)
#### 第17章 多线程编程(P580 - P599)
#### 第18章 坦克大战2(P600 - P610)
#### 第19章 IO流(P611 - P644)
#### 第20章 坦克大战3(P645 - P661)
### 第三阶段(P662 - P910)
#### 第21章 网络编程(P662 - P684)
#### 第22章 多用户即时通信系统(P685 - P710)
#### 第23章 反射(P711 - P730)
#### 第24章 零基础学MySQL(P731 - P820)
#### 第25章 JDBC和数据库连接池(P821 - P857)
#### 第26章 满汉楼(P858 - P877)
#### 第27章 正则表达式(P878 - P904)
#### 第28章 算法优化体验课 - 骑士周游问题(P905 - P910)



****



# Java 核心技术



# [Notion的学习](./notion.md)

