## day08_EL_JSTL

## EL

### 1. EL简介

- EL概述：EL（Expression Language）是**JSP内置的表达式语言**，主要用于替换Jsp中表达式。
- EL作用
  - EL可以：获取**域**中对象、及对象中的属性
  - EL也可以：做基本的运算操作
- EL特点
  - EL在得到某个数据时，会**自动进行数据类型的转换**。
  - 使用EL表达式输出数据时，如果有则输出数据，**如果为null则什么也不输出。**

### 2. EL使用

- EL基本使用

  - ${标识符}：默认从小域到大域进行检索数据
  - ${域对象.标识符}：从指定域中获取数据

- EL获取域中的对象及对象属性

  - ${域对象.对象.属性}

    - 属性定义：封装后的成员变量。

    - ```jsp
      ${sessionScope.stu.name}
      ```

  - ${域对象.对象.getXXX()}

  - ${域对象.对象["属性"]}

### 3. EL运算符

- empty运算符：判断空值【true:空】
  - “”
  - null
  - 数组或集合长度为0

- 判断非空
  - ${empty 标识符}：判断空值【true:空】
  - ${!empty 标识符}：判断非空【true:非空】
  - ${not empty 标识符}：判断非空【true:非空】

### 4. EL11个内置对象【隐含对象|隐式对象】

- EL域对象					对应JSP域对象
  - **pageScope**				pageContext
  - **requestScope**                           request
  - **sessionScope**                            session
  - **applicationScope**                      application
- Jsp域对象，同时通用于EL中
  - **pageContext**：可以直接获取JSP中，其他8个内置对象

- 其他6个内置对象
  - **param**：获取请求参数，与jsp中request.getParameter()作用一致。
  - paramValues：获取请求参数【多个】，与request.getParameterValues()作用一致。
  - **header**：获取请求头，与jsp中request.getHeader()作用一致。
  - headerValue：获取请求头【多个】
  - **cookie**：获取Cookie信息
  - initParam：获取上下文初始化参数，与jsp中ServletContext.getInitParameter()作用一致

- 总结：
  - jsp中  pageContext对象 = EL中 pageScope【域】 + pageContext【获取jsp中其他8个内置对象】
  - jsp中 request = El中  requestScope【域】 + param【获取请参数】 + header【获取请求头】
    - request【获取请求参数+获取请求头+获取URL+转发+域】
  - 问：如何在EL中获取URL信息？
    - 答：${pageContext.request.contextPath}

## JSTL

### 1. JSTL简介

- JSTL全称：JSP Standard Tag Library【JSP标准标签库】

- JSTL：相当于以标签形式，书写java代码，目的：简化JSP中的脚本片段

- JSTL共有5组标签库，需要掌握其中3种

  - 核心标签库

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  - 格式化标签库

    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

  - 函数库

    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

### 2. JSTL使用步骤

1. 导入2个jar包

   taglibs-standard-spec-1.2.1.jar

   taglibs-standard-impl-1.2.1.jar

2. 引入标签库

3. 使用

   ```jstl
   <c:set var="s" value="zs" scope="request"></c:set>
   ```



### 3. JSTL常用标签

- **3.1 核心标签库**

  - **\<c:set>标签**

    - **作用：**\<c:set>标签 用于 添加 或 修改 域中的属性。

    - **属性：**

      - scope是哪个作用域
      - var 是属性名
      - value 是属性值
      - target 是要修改的目标对象
      - property 是要修改或者添加的属性名

    - **示例代码**

      ```jsp
      <%--声明变量--%>
      <c:set scope="" var="" value=""></c:set>
      <%--修改属性值--%>
      <c:set target="" property="" value=""></c:set>
      ```

  - **\<c:out>标签**

    - **作用：**\<c:out>用于计算一个表达式并将结果输出到当前页面。功能类似于JSP表达式<%= %>和EL表达式${}

    - **属性**

      | 属性    | 作用                        | 参数类型 |
      | ------- | --------------------------- | -------- |
      | value   | 要输出的值                  | Object   |
      | default | 当value为null时显示的默认值 | Object   |
      | escaXml | 是否对特殊字符进行转义      | boolean  |

    - **示例代码**

      ```jsp
      <c:out value="${requestScope.stuName2}" default="stuName2 is null!"></c:out>
      
      <c:set value="<a href='#'>超链接</a>" var="temp"></c:set>
      <c:out value="${pageScope.temp}" escapeXml="false"></c:out>
      ```

  - **\<c:if>标签**

    - **作用：**\<c:if>标签 判断表达式的值，如果表达式的值为 true 则执行其主体内容。

    - **属性**

      | **属性** | **描述**               | **是否必要** | **默认值** |
      | -------- | ---------------------- | ------------ | ---------- |
      | test     | 条件                   | 是           | 无         |
      | var      | 用于存储条件结果的变量 | 否           | 无         |
      | scope    | var属性的作用域        | 否           | page       |

    - **示例代码**

      ```jsp
      <c:set var="yOn" value="true"></c:set>
      <c:if test="${pageScope.yOn == true}" var="bool" scope="request">
          正在听课！
      </c:if>
      ```

  - **\<c:choose>、\<c:when>、\<c:otherwise>标签(常用)**

    - **作用：**\<c:choose>标签与Java switch语句的功能一样，用于在众多选项中做出选择。

    - **属性：**

      test属性：条件判断，返回boolean类型

    - **示例代码**

      ```jsp
      <c:set var="age" value="88" scope="request"></c:set>
      <c:choose>
          <c:when test="${requestScope.age < 18}">
              未成年
          </c:when>
          <c:when test="${requestScope.age>=18 and requestScope.age<30}">
              青年
          </c:when>
          <c:when test="${requestScope.age>=30 and requestScope.age<60}">
              中年
          </c:when>
          <c:when test="${requestScope.age>=60 and requestScope.age<80}">
              中老年
          </c:when>
          <c:otherwise>
              老年
          </c:otherwise>
      </c:choose>
      ```

      

  - **\<c:forEach>标签**

    - **作用：**\<c:forEach>标签是迭代一个集合中的对象-可以是数组，也可以是list，也可以是map对象。

    - **属性：**

      | **属性**  | **描述**                                   | **是否必要** | **默认值**   |
      | --------- | ------------------------------------------ | ------------ | ------------ |
      | items     | 要被循环的数据集合-可以使用el表达式        | 否           | 无           |
      | begin     | 开始的索引（0=第一个元素，1=第二个元素）   | 否           | 0            |
      | end       | 最后一个索引（0=第一个元素，1=第二个元素） | 否           | Last element |
      | step      | 每一次迭代的步长                           | 否           | 1            |
      | var       | 代表当前条目的变量名称                     | 否           | 无           |
      | varStatus | 代表循环状态的变量名称                     | 否           | 无           |

    - **示例代码**

      ```jsp
      <%--普通循环--%>
      <c:forEach var="i" begin="1" end="10" step="2">
          ${i}&nbsp;
      </c:forEach>
      <%--增强循环--%>
      <%
          List<Student> list = new ArrayList<Student>();
          list.add(new Student(10001,"zijian"));
          list.add(new Student(10002,"yafei"));
          list.add(new Student(10003,"zhiyuan"));
          list.add(new Student(10004,"admin"));
          request.setAttribute("list",list);
      %>
      <c:forEach items="${requestScope.list}" var="stu">
          ${stu.id} &emsp; ${stu.name2}<br>
      </c:forEach>
      ```

  

  **3.2 其他标签库or函数库**

  - **格式化标签库之fmt**

    - **作用：**格式化数据，如日期、数字等

    - **属性：**

      - value:格式化数据
      - pattern：格式化规则

    - **示例代码**

      ```jsp
      <%
          Date date = new Date();
          request.setAttribute("date",date);
      %>
      <fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd hh:mm:ss"></fmt:formatDate>
      ```

  - **函数库**

    - **作用：**类似java中String作用

    - **示例代码**

      ```jsp
      ${fn:contains("HEllo", "he")}
      结果:false
      ```

      

  
