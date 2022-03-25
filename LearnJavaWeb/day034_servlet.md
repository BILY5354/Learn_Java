## day06_Servlet

### 1. Servlet简介

#### 1.1 为什么学Servlet

> 案例：以注册为例，如需实现注册功能
>
> 1. regist.html中的数据，提交到java
>    - 【xxx.java文件默认不能直接以url方式访问，所以需要Servlet解决当前问题】
> 2. 在java使用jdbc技术，将数据提交到database

#### 1.2 Servlet概述（Server Applet）

- Servlet：相当于具有【url特性】的java代码
- **如果把Web应用比作一个餐厅，Servlet就是餐厅中的服务员**——负责接待顾客、上菜、结账。
- Servlet指的是javax.servlet.Servlet接口及其子接口，也可以指实现了Servlet接口的实现类。

#### 1.3 Servlet特性

- Servlet的实例对象由Servlet容器负责创建；
- Servlet的方法由容器在特定情况下调用；
- Servlet容器会在Web应用卸载时销毁Servlet对象的实例。

> web.xml：web应用部署描述符，主要用于各种web组件的注册。

#### 1.4 创建Servlet步骤

1. 搭建web工程环境

2. 创建class  MyFirstServlet实现javax.servlet.Servlet接口

3. service()：处理请求，做出响应

4. 在web.xml中，注册MyFirstServlet

   ```xml
   <servlet>
       <servlet-name>MyFirstServlet</servlet-name>
       <!--标识类全类名，目的让服务器创建当前Servlet-->
       <servlet-class>com.atguigu.servlet.MyFirstServlet</servlet-class>
   </servlet>
   <servlet-mapping>
       <servlet-name>MyFirstServlet</servlet-name>
       <!--为servlet设置虚拟URL-->
       <url-pattern>/MyFirstServlet</url-pattern>
   </servlet-mapping>
   ```

### 2. Servlet工作原理

- 请求MyFirstServlet
- 在web.xml中【<servlet-mapping>中<url-pattern>】查找指定url
- 通过<servlet-name>映射到<servlet-class>【全类名】
- 执行MyFirstServlet中的相应方法

### 3. Servlet生命周期【面试题】

- 构造器
  - 执行时机：第一次接收请求时，执行。
  - 执行次数：在整个生命周期中，只执行一次。【Servlet单例】
- init()
  - 执行时机：第一次接收请求时，执行构造器之后，执行。
  - 执行次数：在整个生命周期中，只执行一次。
- service()
  - 执行时机：每次接收请求，都会执行。
  - 执行次数：在整个生命周期中，只执行多次。
- destroy()
  - 执行时机：在关闭服务器或重启服务器时，执行。
  - 执行次数：在整个生命周期中，只执行一次。

> 当Servlet第一次接收请求时，Servlet容器【web容器|web服务器】创建Servlet【执行构造器】，之后执行init()方法，进行初始化操作。最后执行service()方法，处理请求，做出响应。【以后再次接收请求，只执行service()方法】。当关闭或重启服务器时，执行destroy()方法，销毁Servlet。

- Servlet生命周期_扩展

  - 如在web.xml中做如下配置

    ```xml
    <!--设置Servlet创建时机：启动服务器时创建Servlet
            index:设置Servlet被创建优先级【int类型且正整数，最小值1】
                数值越小，优先级越高
    
    -->
    <load-on-startup>1</load-on-startup>
    ```

  - 此时，Servlet生命周期，如下调整
    - 构造执行时机为：启动服务后，执行
    - init()执行时机为：启动服务器，执行构造器后，执行。
    - 其他方法，无变化。

### 4. ServletConfig与ServletContext对象

#### 4.1 ServletConfig

- 概述：该对象相当于封装了Servlet配置信息，每个Servlet都有唯一对应的ServletConfig对象

- 作用：

  - 获取当前Servlet名称：servletConfig.getServletName()

  - 获取ServletContext对象：servletConfig.getServletContext()

  - 获取当前Servlet初始化参数：servletConfig.getInitParameter()

    - web.xml中配置初始化参数

      ```
      <init-param>
          <param-name>url</param-name>
          <param-value>jdbc:mysql://localhost:3306/dbname</param-value>
      </init-param>
      ```



#### 4.2 ServletContext对象【Servlet上下文对象】

- 概述：该对象代表当前web应用，每个web应用程序都有唯一对象的ServletContext对象。【该对象在启动服务时，被web服务器创建。】

- 作用：

  1. 获取上下文路径【带/项目名，eg:/day05_tomcat_http_servlet】

     ```java
     String contextPath = servletContext.getContextPath();
     ```

  2. 获取真实路径【d:/xxx(文件上传&文件下载)】

     ```java
     String realPath = servletContext.getRealPath("/index.html");
     ```

  3. 获取上下文初始化参数

     ```xml
     <context-param>
         <param-name>stuName</param-name>
         <param-value>caixukun</param-value>
     </context-param>
     ```

     ```java
     String stuName = servletContext.getInitParameter("stuName");
     ```

  4. 域对象【web域，共4个域对象】

### 5. 最终创建Servlet方式

> 之前创建Servlet方式不足
>
> 1. 实现Servlet接口的实现类中，方法比较冗余【只需要service()】
> 2. 没有提示注册Servlet

- EndServlet	:	HttpServlet	:	GenericServlet	:	Servlet

- GenericServlet作用

  1. 提供获取ServletConfig和ServletContext对象方法

     - getServletConfig()
     - getServletContext()

  2. 将service()方法，抽象化

     ```java
     @Override
     public abstract void service(ServletRequest req, ServletResponse res)
             throws ServletException, IOException;
     ```

- HttpServlet作用

  1. override  service()【重写service()】

     ```java
     @Override
     public void service(ServletRequest req, ServletResponse res)
         throws ServletException, IOException {
     
         HttpServletRequest  request;
         HttpServletResponse response;
     
         try {
             request = (HttpServletRequest) req;
             response = (HttpServletResponse) res;
         } catch (ClassCastException e) {
             throw new ServletException("non-HTTP request or response");
         }
         service(request, response);
     }
     ```

  2. overload  service()【重载service()】

     ```java
     protected void service(HttpServletRequest req, HttpServletResponse resp)
         throws ServletException, IOException {
     
         String method = req.getMethod();
         if("GET".eq(method)){
             doGet(req,resp);
         }else if("POST".eq(method)){
             doPost(req,resp);
         }else if(){
             //PUT  |  DELETE
             
         }...
         
     }
     ```

### 6. request【请求】与response【响应】对象

#### 6.1 request

- 类型：HttpServletRequest

- 概述：request相当于浏览器向服务器发送请求报文，封装到request对象。该对象由服务器创建，并以参数的形式发送到service()方法中，最终传入doGet()或doPost()方法中。

- 作用：

  1. 获取请求参数

     > 什么参数
     >
     > 1. ?后面内容：\<a href="EndServlet?uname=zs&pwd=123456">\</a>
     >
     > 2. 表单中参数：name属性值
     >
     >    ```
     >    <form action="EndServlet" method="post">
     >        用户名：<input id="username" type="text" name="username" value="" /><br>
     >        密码：<input id="pwd" type="password" name="password" value="123"/><br>
     >        <input id="btnSub" type="submit" value="登录" >
     >    </form>
     >    ```
     - request.getParameter()：获取单个请求参数
     - request.getParameterValues()：获取多个请求参数

  2. 获取请求头中的信息

     - request.getHeader("User-Agent|Cookie|Referer")

  3. 获取URL信息【<http://localhost:8080/day06_servlet/>】

     - 获取协议：request.getScheme()
     - 获取服务器名称：request.getServerName()
     - 获取服务器端口:request.getServerPort()
     - 获取上下文路径【带/项目名】:request.getContextPath()

  4. 转发请求【路径跳转】

     ```java
     //1. 获取转发器
     RequestDispatcher requestDispatcher = request.getRequestDispatcher("login_success.html");
     //2. 执行转发
     requestDispatcher.forward(request,response);
     ```

  5. 域对象【共四个，ServletContext|request】

#### 6.2 response

- 类型：HttpServletResponse
- 概述：response相当于服务器向浏览器做出响应报文，封装到response对象。该对象由服务器创建，并以参数的形式发送到service()方法中，最终传入doGet()或doPost()方法中。
- 作用：
  1. 获取响应流，响应数据
     - PrintWriter writer = response.getWriter();
     - writer.writer();|writer.print()
  2. 设置响应头
     - response.setHeader("Content-Type","text/html;charset=UTF-8");
  3. 重定向【路径跳转】
     - response.sendRedirect("url");

### 7. 转发与重定向区别

- 转发地址栏不变，重定向地址改变。
- 转发可以携带request对象到目标资源，重定向未携带request对象。
- 转发浏览器发送一次，重定向浏览器发送两次请求
- 转发可以访问WEB-INF下资源，重定向不能直接访问WEB-INF下资源
  - WEB-INF属于服务器私有目录【服务器内部可以访问，浏览器不能直接访问】

### 8. web应用中的乱码问题

> 默认在请求与响应过程中，都会出现乱码情况

#### 8.1 基本术语

- 字符集：各种字符的集合，包括汉字，英文，标点符号等等。
  - 常用字符集：UTF-8【支持大量中文】、GB2312【GBK:支持少量中文】

- 编码：将字符转换为二进制数
- 解码：将二进制数转换为字符
- 乱码：一段字符的编码与解码的过程使用了不同字符集时，会出现乱码现象。

#### 8.2 乱码种类【B/S】

- 请求乱码：浏览器向服务器发送请求时，出现乱码
  - 浏览器编码与服务器解码，不一致
- 响应乱码：服务器向浏览器做出响应时，出现乱码
  - 服务器编码与浏览器解码，不一致

#### 8.3 服务器与浏览器默认编码与解码问题

- 服务器默认编码与解码一致：ISO-8859-1【不支持中文】
- 浏览器默认情况
  - 编码：UTF-8【\<meta charset="UTF-8">】
  - 解码：GBK【GB2312】

#### 8.4 乱码解决

- 解决请求乱码

  - GET请求

    - 思路：找到设置URL字符集位置

    - 代码

      ```xml
      <Connector URIEncoding="UTF-8" port="8080" protocol="HTTP/1.1"
                     connectionTimeout="20000"
                     redirectPort="8443" />
      ```

      

  - POST请求

    - 思路：将服务器解码设置为：UTF-8。【浏览器编码：UTF-8与服务器解码：ISO-8859-1】

    - 代码

      ```java
      request.setCharacterEncoding("UTF-8");
      ```

- 解决响应乱码

  - 思路&代码：【服务器编码：ISO-8859-1，浏览器解码：GBK】

    1. 设置服务器编码：GBK【支持少量中文】

       ```java
       response.setCharacterEncoding("GBK");   //设置服务器编码
       ```

    2. 设置服务器编码与浏览器解码：UTF-8【推荐使用】

       ```java
       //方式一
       response.setHeader("Content-Type","text/html;charset=UTF-8");
       //方式二【推荐使用】
       response.setContentType("text/html;charset=UTF-8");  
       ```

- 总结：三行代码，解决请求与响应的乱码问题

### 9. web应用中的路径问题

> 由于使用转发跳转路径，地址栏不变。此时使用相对路径【../】可能会出现404，所以不建议使用相对路径，建议绝对路径。

#### 9.1 什么是绝对路径

- 以"/"开头的路径，称之为绝对路径

#### 9.2 “/”代表什么

- 服务器解析“/”，“/”代表当前上下文路径【当前web应用路径】eg:<http://localhost:8080/day06_servlet>

  - 以下两种路径中的“/” 由服务器解析

    1. web.xml中配置的“/”

       ```xml
       <url-pattern>/RegistServlet</url-pattern>
       ```

    2. 转发请求中的“/”

- 浏览器解析"/"，"/"代表当前服务器路径。eg:<http://localhost:8080/>

  - 以下两种路径中的“/”由浏览器解析
    1.  重定向中的“/”
    2. 书写在静态资源中的“/”【最终在浏览器中加载运行的内容】
       - 如：html\css\js

- IDEA中编译期间web目录，等同于运行期间上下文路径【/项目名】

#### 9.3 代码

- 页面中代码【html|jsp】

  ```html
  <base href="/day06_servlet/">
  ```

- Servlet中代码

  ```java
  request.getRequestDispatcher("/pages/login_success.html").forward(request,response);
  response.sendRedirect(request.getContextPath()+"/pages/login.html");
          
  ```

### 10. 基于JavaEE6及以上版本【web3.0】，创建Servlet

```java
@WebServlet(name = "Servlet30",value = "/Servlet30")
public class Servlet30 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Servlet30!");
    }
}
```



















