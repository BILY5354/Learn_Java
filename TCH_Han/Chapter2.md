# [Java概述](./TCH_Han/Charpter2.md)

## 值得注意的点
- Java是解释性语言，即：编译后的代码，不能直接被机器执行,需要解释器来执行, 编译性语言, 编译后的代码, 可 以直接被机器执行, c /c++
- JVM -  java virtual machine
- JDK - Java Development Kit，**JDK = JRE +** **开发工具集**
- JRE - Java Runtime Environment，**JRE = JVM + Java SE** **标准类库**
- 一个源文件**最多只有一个**```public```类，其它类不限
- 如果源文件包含一个```public```类，则文件名必须按该类名命名
- 

1. [常用的转义字符](#1)
2. [Java中注释类型](#2)
3. [DOS命令](#3)
4. [](#4)  
## 1
```
\t ：一个制表位，实现对齐的功能
\n ：换行符
\\ ：一个\
\" :一个"
\' ：一个' 
\r :一个回车 System.out.println("韩顺平教育\r 北京");
```
## 2

**多行注释中不允许有多行注释的嵌套**

```
单行注释 //
多行注释 /* */
文档注释 /** */
```


*这句话不是很懂什么意思 晚上看看*

```
javadoc -d c://temp -author -version Chapter1.java
```



## 3

### 3.1 常用的dos命令

```
1)查看当前目录是有什么内容 dir
dir dir d:\abc2\test200
2) 切换到其他盘下：盘符号 cd : change directory
案例演示：切换到 c 盘 cd /D c:
3) 切换到当前盘的其他目录下 (使用相对路径和绝对路径演示), ..\表示上一级目录
案例演示： cd d:\abc2\test200 cd ..\..\abc2\test200
4) 切换到上一级：
案例演示： cd .. 5) 切换到根目录：cd \
案例演示：cd \
6) 查看指定的目录下所有的子级目录 tree
7) 清屏 cls [苍老师]
8) 退出 DOS exit
```
### 3.2了解

```
md[创建目录]
rd[删除目录]
copy[拷贝文件]
del[删除文件]
echo[输入内容到文件]
type,move[剪切]
```



## 4

```
```