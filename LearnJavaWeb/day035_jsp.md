## day07_Jsp

### 1. Jsp简介

- Jsp全称Java Server Pages,运行在java服务器中的页面【不能直接在浏览器中运行】
- Jsp表象：是一个可以嵌入Java代码的HTML。
- Jsp其本质:就是一个Servlet。Servlet能做的事情JSP都能做。

### 2. Jsp工作原理

> xxx_jsp.java ->>  class  xxx_jsp	:	org.apache.jasper.runtime.HttpJspBase	:	HttpServlet

- 第一次请求jsp
- 服务器先将jsp翻译为xxx_jsp.java文件
- 再将xxx_jsp.java文件编译为xxx_jsp.class文件
  - 如不是第一次
    1. 代码未改变：不会翻译&编译
    2. 代码改变：会翻译&编译

### 3. Jsp基本语法

- 指令
  - 格式：<%@  指令名  属性=属性值   属性2=属性值2 ....%>
- 模板元素
  - html|css|js...
- 脚本片段
  - 格式：<%%>
  - 作用：在_jspService()方法中，书写java代码
- 表达式
  - 格式：<%=%>
  - 作用：将数据显示到页面中
- 声明
  - 格式：<%! %>
  - 作用：在类中，书写java代码
- 注释
  - java注释
    - 单行注释：//
    - 多行注释：/**/
  - html注释
    - <!--  -->
  - jsp注释
    - <%-- --%>

### 4. Jsp中常用指令

#### 4.1 page指令

- 语法格式：<%@ page contentType="text/html;charset=UTF-8" language="java" %>
- 属性
  - contentType：与response.setContentType()作用一致
  - language：设置jsp支持语言，有且只有java
  - import：导包
  - errorPage：设置当前页面出错时的跳转页面
  - isErrorPage：设置当前页面是否包含exception内置对象。默认:false

#### 4.2 静态包含include指令

- 语法格式：<%@ include file=""%>

- file属性：设置被包含文件的路径
- 特点：被包含文件不会被翻译&编译【先包含，再翻译】
- 适用场景：页面中是静态资源较多时，【java代码较少时】使用静态包含。

### 5. Jsp中常用动作标签

> 动作标签语法格式：\<jsp:xxx>\</jsp:xxx>

#### 5.1 动作标签之动态包含

- 语法格式

  ```jsp
  <jsp:include page="index.jsp"></jsp:include>
  ```

- 特点：被包含文件同时会被翻译&编译【先翻译，再包含】
- 适用场景：页面中动态资源较多时【java代码较多时】使用动态包含。

#### 5.2 动作标签之转发

- 语法格式

  ```jsp
  <jsp:forward page="index.jsp"></jsp:forward>
  ```



### 6. Jsp九大内置对象【隐式对象|隐含对象】

> 内置对象：无需我们程序员自己手动创建，就可以直接在Jsp中使用的对象，称之为内置对象，也叫隐式对象或隐含对象。

1. pageContext
   - 页面域对象
   - 类型：javax.servlet.jsp.PageContext
   - 作用：
     1. 可以直接获取其他8个内置对象
     2. 域对象
   - 在Servlet中获取方式：无【导包后才能使用javax.servlet.jsp.PageContext;】
2. request
   - 请求域对象
   - 类型：javax.servlet.http.HttpServletRequest
   - 作用：与Servlet中讲解一致
     1. 获取请求参数:request.getParameter()
     2. 获取请求头
     3. 获取URL
     4. 转发:request.getRequestDispatcher().forward()
     5. 域对象:request.getAttribute()   |  request.setAttibute() ....
3. session
   - 会话域对象
   - 类型：javax.servlet.http.HttpSession
   - 在Servlet中获取方式：request.getSession()
4. application
   - 上下文域
   - 类型：javax.servlet.ServletContext
   - 作用：
     1. 获取上下文路径
     2. 获取真实路径
     3. 获取上下文初始化参数
     4. 域对象
   - 在Servlet中的获取方式：getServletContext()

5. page
   - 类型：java.lang.Object
   - 作用： java.lang.Object page = this;
6. response
   - 类型：javax.servlet.http.HttpServletResponse
   - 作用：
     1. 获取响应流，响应数据
     2. 设置响应头
     3. 重定向
7. out
   - 类型：javax.servlet.jsp.JspWriter
   - 作用：与Servlet中PrintWriter作用类似，将数据显示到页面
     - java.io.PrintWriter与javax.servlet.jsp.JspWriter都继承java.io.Wirter
8. config
   - 类型：javax.servlet.ServletConfig
   - 作用：
     1. 获取Servlet名称
     2. 获取初始化参数
     3. 获取ServletContext对象
9. exception
   - 类型： java.lang.Throwable
   - 作用：处理异常



- 总结：Jsp一共9个内置对象，但默认只有8个内置对象【其中exception内置对象，需要设置page指令中的【isErrorPage=true】时，才能提供】

### 7. Jsp四大域对象

#### 7.1 域对象概述

- 生活中域【区域-快递】：将物品从一个区域快递到另一区域【共享】
  - 同区快递
  - 同城快递
  - 全国快递
  - 全球快递

- 程序中域：将数据从一个区域“快递”到另一区域【共享】

#### 7.2 四大域对象详情

- pageContext【页面域】
  - 有效范围：在当前页面有效【离开当前页面失效】
- request【请求域】
  - 有效范围：在当前请求有效【不在当前请求失效】
    - 当前请求：指本次请求【请求路径发生变化就不在当前请求】
    - 转发请求时：是在当前请求
- session【会话域】
  - 有效范围：在当前会话有效【离开当前会话失效】
  - 当前会话：浏览器与服务器之间会话，与浏览器有关，与服务器无关。
    - 浏览器不关闭&不更换，即为当前会话
    - 关闭浏览器或更换浏览器，当前会话结束
- application【上下文域|web域】
  - 有效范围：当前web应用有效
  - web应用卸载失效【关闭服务器|服务器进程结束】

#### 7.3 域对象共同API

> 域对象底层维护一个Map

- 设置属性到域中：void setAttribute(String key , Object value);
- 从域中获取指定的属性：Object  getAttribute(String key);
- 移除域中指定属性：void removeAttribute(String key);







































