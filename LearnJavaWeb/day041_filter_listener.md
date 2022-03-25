## day13_Filter_Listener

## Filter

### 1. Filter简介

- Filter【过滤器】：是web三大组件之一【Servlet&Listener】
  - web组件共性
    1. 都需要实现某个接口
    2. 都需要注册【web.xml或注解】
- Filter主要用于过滤请求和响应
- Filter常用API
  - Filter接口:编写Filter需要实现Filter接口，我们来看一下Filter接口的主要方法：
    - init()方法用于初始化Filter
    - doFilter()作用和service()方法类似，是过滤请求和响应的主要方法。
    - destroy()用于在Filter对象被销毁前做一些收尾工作。如：释放资源等。
  - FilterConfig对象在服务器调用init()方法时传递进来。
    - getFilterName() 获取Filter的名字
    - getServletContext() 获取ServletContext对象（即application）
    - getInitParameter() 获取Filter的初始化参数
    - getInitParameterNames() 获取所有初始化参数的名字
  - FilterChain对象是在doFilter()方法被调用时作为参数传递进来的。
    - doFilter()方法用于调用Filter链上的下一个过滤器，如果当前过滤器为最后一个过滤器则将请求发送到目标资源。

### 2. Filter生命周期

- 构造器
  - 执行时机：启动服务器时，执行。
  - 执行次数：在整个生命周期中，只执行一次。
- init()
  - 执行时机：启动服务器时，执行构造器后，执行。
  - 执行次数：在整个生命周期中，只执行一次。
- doFilter()
  - 执行时机：每次接收【过滤URL】时，执行。
  - 执行次数：在整个生命周期中，只执行n次。【n>=1】
- destroy()
  - 执行时机：关闭服务器时，执行。
  - 执行次数：在整个生命周期中，只执行一次。

### 3. Filter工作原理

#### 3.1 单个Filter工作原理

- 浏览器向服务器发送请求【过滤器URL】
- 执行过滤器【放行请求之前】代码，过滤请求
- 放行请求：chain.doFilter(request,response);
- 执行目标资源：Servlet,处理请求，做出响应
- 执行过滤器【放行请求之后】代码，过滤响应
- 执行响应

#### 3.2 多个Filter工作原理

- 浏览器向服务器发送请求【过滤器URL】
- 执行**过滤器1**【放行请求之前】代码，过滤请求
- 放行请求：chain.doFilter(request,response);
- 执行**过滤器2**【放行请求之前】代码，过滤请求
- 放行请求：chain.doFilter(request,response);
- 执行目标资源：Servlet,处理请求，做出响应
- 执行**过滤器2**【放行请求之后】代码，过滤响应
- 执行**过滤器1**【放行请求之后】代码，过滤响应
- 执行响应

> 过滤器顺序由【<filter-mapping>】先后顺序决定

### 4. URL配置规则

- 精确匹配

  - ```xml
    <filter-mapping>
        <filter-name>Filter2</filter-name>
        <url-pattern>/MyFirstServlet</url-pattern>
    </filter-mapping>
    ```

  - ```xml
    <filter-mapping>
        <filter-name>Filter2</filter-name>
        <servlet-name>MyFirstServlet</servlet-name>
    </filter-mapping>
    ```

- 模糊匹配：URL中包含【*】的匹配

  - 前置模糊【后缀名匹配】：将【*】书写在URL的最前面
    - <url-pattern>*.jsp</url-pattern>
  - 后置模糊【目录匹配】：将【*】书写在URL的最后面
    - <url-pattern>/dir/dir2/*</url-pattern>

- 常用的URL配置

  - ```xml
    <!-- 通用于Servlet&Filter当前项目下的所有路径 -->
    <url-pattern>/*</url-pattern>
    <!-- 在Servlet中配置URL 当前项目下的所有路径 [排除所有jsp]-->
    <url-pattern>/</url-pattern>
    ```

### 5. HttpFilter

> javax.servlet.Servlet   ->   javax.servlet.http.HttpServlet
>
> EndServlet	:	HttpServlet	:	GenericServlet	: 	Servlet

- 手动搭建底层HttpFilter
  - 提供获取FilterConfig和ServletContext对象方法
  - 抽象化doFilter()方法
  - 强制类型转换，如：ServletRequest->HttpServletRequest

- 代码

  ```java
  public abstract class HttpFilter implements Filter {
      //1.提供获取FilterConfig和ServletContext对象方法
      private FilterConfig filterConfig;
      /**
       * 获取FilterConfig对象
       * @return
       */
      public FilterConfig getFilterConfig(){
          return filterConfig;
      }
      /**
       * 获取ServletContext对象
       * @throws ServletException
       */
      public ServletContext getServletContext(){
          return filterConfig.getServletContext();
      }
      @Override
      public void init(FilterConfig filterConfig) throws ServletException {
          this.filterConfig = filterConfig;
      }
      @Override
      public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
          HttpServletRequest req = (HttpServletRequest)request;
          HttpServletResponse res = (HttpServletResponse)response;
          doFilter(req,res,chain);
      }
  
      public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException;
      
      @Override
      public void destroy() {
  
      }
  }
  ```



## Listener

### 1. Listener简介

- 生活中的监听器【工种-狗仔队】
  - 监听对象：狗仔队
  - 监听目标：明星
  - 监听事件：绯闻、花边新闻、...
  - 监听结果：头条见
- 程序中的监听器
  - 监听对象：创建
  - 监听目标：application、session、request
  - 监听事件：对象创建、修改、销毁、对象中属性变化等
  - 监听结果：程序需求

### 2. 使用Listener

- 实现某个接口

  ```java
  public class TestApplicationListener implements ServletContextListener {
      /**
       * application被创建啦
       * @param sce
       */
      @Override
      public void contextInitialized(ServletContextEvent sce) {
          System.out.println("servletContext对象被创建啦！");
      }
      /**
       * application被销毁啦
       * @param sce
       */
      @Override
      public void contextDestroyed(ServletContextEvent sce) {
          System.out.println("servletContext对象被销毁啦！");
      }
  }
  ```

- 注册

  ```xml
  <!-- web.xml -->
  <listener>
      <listener-class>com.atguigu.listener.TestApplicationListener</listener-class>
  </listener>
  <!--注解：@WebListener -->
  ```

  

- 总结：Web组件加载顺序： Listener  >  Filter  >  Servlet









