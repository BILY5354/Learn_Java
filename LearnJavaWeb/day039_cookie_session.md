## day11_会话控制【Cookie_Session】

> 流程控制：控制程序执行流程
>
> 会话控制：控制会话【关闭或重启浏览器时，期望会话有效】

## Cookie

### 1. Cookie简介

- 实际上就是服务器保存在浏览器上的一小段信息。【以键值对形式存储小量信息的技术】

- 主要用于帮助服务器区分不同浏览器【Http:纯文本无状态】

- Cookie由来小故事【程序员带着小女儿买饼干-很久前】

  > 很久前，饼干店搞促销活动【会员活动】

  1. 程序员来饼干店，买饼干
  2. 店家发送给程序员一张卡片【盖章：记录会员信息】
  3. 以后程序员再次来饼干店，买饼干。会携带卡片
  4. 店家通过卡片，区分会员信息

### 2. Cookie工作原理

> 回顾【程序员买饼干】故事

1. 浏览器向服务器发送请求。
2. 服务器创建Cookie对象【卡片】，Cookie对象携带用户信息，服务器将Cookie对象发送给浏览器。
3. 浏览器以后再次向服务器发送请求 ，携带Cookie对象。
4. 服务器通过Cookie对象，区分不同浏览器。

### 3. Cookie使用

- Cookie创建

  ```java
  //创建Cookie对象
  Cookie cookie = new Cookie("level","level1");
  //响应浏览器
  response.addCookie(cookie);
  ```

- Cookie获取

  ```java
  //获取cookie
  Cookie[] cookies = request.getCookies();
  for (Cookie cookie : cookies) {
      if("level".equals(cookie.getName())){
          System.out.println("cookie.getValue():" + cookie.getValue());
          break;
      }
  }
  ```

- Cookie修改

  ```java
  //创建同名cookie，进行覆盖
  Cookie cookie2 = new Cookie("level","level3");
  response.addCookie(cookie2);
  ```

- Cookie键值对

  - Cookie的name不支持中文，Cookie的value支持中文。但在Cookie中使用中文，需要设置字符集问题，比较繁琐，所以不建议使用中文，尽量使用英文。

  - 如Cookie的value必须使用中文，如下操作：

    ```java
    //设置编码
    Cookie cookie2 = new Cookie("level", URLEncoder.encode("会员3","UTF-8"));
    response.addCookie(cookie2);
    //设置解码
    URLDecoder.decode(cookie.getValue(),"UTF-8");
                    
    ```

### 4. Cookie的有效时间【持久化Cookie】

- Cookie默认会话级别有效：浏览器不关闭&不更换会话有效。
- 设置Cookie有效时间
  - setMaxAge(ss):ss单位秒，类型：int
    - ss>0：ss秒后Cookie失效
    - ss=0：Cookie立即失效
    - ss<0：恢复默认会话级别

- 注意：持久化Cookie不一定比默认会话级别的有效时间长。

### 5. Cookie的有效路径

- Cookie默认的有效路径：上下文路径【/+项目名】
- setPath()：设置cookie有效路径
  - 注意：一般有效路径会设置到当前项目下的某个路径。如：cookie.setPath(request.getContextPath()+"/index.jsp");



### 6. Cookie练习

- 使用Cookie实现【7天免输入】功能

- ```html
  <h2>7天免输入</h2>
  <form action="${pageContext.request.contextPath}/CookieServlet?method=login" method="post">
      用户名：<input name="username" type="text" value="${cookie.username.value}" /><br />
      密&emsp;码：<input name="password" type="password" value="${cookie.password.value}" /><br />
      7天免输入:<input type="checkbox" name="ck" value="ck"><br />
      <input type="submit" value="提 交" />
  </form>
  ```

- ```java
  //获取请求参数
  String username = request.getParameter("username");
  String password = request.getParameter("password");
  String ck = request.getParameter("ck");
  System.out.println("ck = " + ck);
  if(ck != null && !"".equals(ck)){
      //7天免输入[域中session]
      //创建Cookie对象,保存用户信息
      Cookie unCookie = new Cookie("username",username);
      Cookie pwdCookie = new Cookie("password",password);
      //持久化Cookie信息
      unCookie.setMaxAge(60*60*24*7);
      pwdCookie.setMaxAge(60*60*24*7);
      //响应浏览器
      response.addCookie(unCookie);
      response.addCookie(pwdCookie);
  }
  ```

### 7. Cookie缺陷【Session与Cookie区别】

- Cookie的value是String，存储数据不灵活【Object】
- Cookie数量过多时，会浪费【数据流量】
- 不同浏览器厂商对Cookie都有限制，限制数量大小【200-500个，2kb-5kb】
- Cookie存储浏览器端，相对不安全。



## Session

### 1. Session简介

- Session是Jsp九大内置对象之一
- Session是四大域对象之一
- Session是两大会话对象之一

### 2. Session工作原理【面试题】

> 如今，饼干店搞促销活动【会员活动】

1. 程序员来饼干店，买饼干
2. 店家在电脑中录入会员信息【手机号】，同时发送一张卡片给程序员【手机号】
3. 以后程序员再次来饼干店，买饼干。会携带卡片
4. 店家通过卡片，去电脑中查询会员信息，从而区分会员信息

- Session工作原理
  1. 浏览器发送请求【第一次调用(HttpServletRequest)request.getSession()】
  2. @2服务器创建Session对象，同时会创建一个特殊的Cookie对象【Cookie的name是固定值：JSESSIONID,Cookie的value是session的id】,将Cookie发送给浏览器。
  3. 以后浏览器再次请求服务器时，携带Cookie对象
  4. 服务器通过Cookie的value查找Session对象，通过Session区分不同用户信息。

- Session工作原理【扩展版本】
  1. 浏览器发送请求【不是第一次】：原则上不会再创建Session对象，会获取已创建Session对象。
  2. 判断是否可以获取Session对象的两个条件
     - 特殊Cookie是否存在
       - 不存在：返回@2步骤，重新执行后续操作。
       - 存在：判断Session对象本身是否存在？【Session默认存货30分钟-空闲时间】
         - Session存在：直接使用
         - Session不存在：返回@2步骤，重新执行后续操作。

### 3. Session 使用

- 创建&修改：服务器内部完成

  - session创建时机：第一次request.getSession()时，被创建。

- 获取：

  - html&Servlet：request.getSession()
  - jsp:session是jsp内置对象之一，直接使用

- Session中存储数据

  - session.setAttribute(String key,Object obj);
  - Object obj = session.getAttribute(String key);
  - session.removeAttibute(String key);

  

### 4. Session有效时间【空闲时间】

- Session默认空闲时间为：30分钟

  tomcat->conf->web.xml

  ```xml
  <session-config>
          <session-timeout>30</session-timeout>
      </session-config>
  ```

- 设置Session空闲时间

  1. 全局设置

     - web.xml中设置

     ```xml
     <session-config>
             <session-timeout>30</session-timeout>
         </session-config>
     ```

  2. 局部设置

     - session.setInactiveInterval(ss):单位秒，类型：int

       ss>0：在session空闲ss秒后，失效【销毁】。

       ss<=0：设置session永不失效。

- **持久化Session**

  - 步骤：
    1. 先持久化特殊Cookie对象
    2. 再持久化Session对象【如持久化时间<=30分钟，此步可省略】

  - 代码

    ```java
    HttpSession session = request.getSession();
    //持久化Cookie
    for (Cookie cookie : request.getCookies()) {
        if("JSESSIONID".equals(cookie.getName())){
            //设置cookie存活时间为20秒
            cookie.setMaxAge(20);
            response.addCookie(cookie);
            break;
        }
    }
    //设置空闲时间为：20秒
    session.setMaxInactiveInterval(20);
    ```

### 5. Session对象释放

- Session对象空闲时间达到了目标设置的最大值，自动释放

- Session对象被强制失效

  - ```java
    session.invalidate();
    ```

- Web应用卸载

- 服务器进程停止

### 6. Session钝化和活化

> Session默认会话级别有效，与浏览器有个，与服务器“无关”。
>
> Session由服务器创建
>
> 问：为什么重启或关闭服务器，“看起来没有”影响Session对象？

- **Session钝化：**Session在一段时间内没有被使用或关闭服务器时，会将当前存在的Session对象及Session对象中的数据从内存**序列化**到磁盘的过程，称之为钝化。
- **Session活化：**Session被钝化后，服务器再次调用Session对象或重启服务器时，将Session对象及Session对象中的数据从磁盘**反序列化**到内存的过程，称之为活化。

- 注意：如需Session中的数据，一同序列化及反序列化时，数据必须支持序列化【implements Serializable】



## 第7章 处理表单重复提交问题

- 表单重复提交的危害
  - 可重复注册，对数据库进行批处理攻击。（验证码已解决该问题）
  - 可重复提交已付款表单，用户支付一次订单费用，下了多个订单
  - 等待...
- 解决表单重复提交的步骤
  - 生成一个不可重复（全球唯一）的随机数(uuid)
  - 在提交表单前，将随机数(uuid)分别存放到表单内的隐藏域，和session域对象中
  - 发送“提交表单”请求
  - 判断是否提交表单，具体操作如下：
    - 分别获取隐藏域和session域中的uuid
    - 判断两个域中的数据是否相等
      - 相等：提交表单，**并将session域中的uuid移除**
      - 不等：不提交表单
- UUID
  - 定义：是一个32位16进制的随机数
  - 特点：全球唯一
  - 使用：java.util.UUID.randomUUID()















