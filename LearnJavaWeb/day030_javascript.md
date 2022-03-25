## day02_JavaScript

### 1. JavaScript【Js】简介

#### 1.1 Js概述

- JavaScript是一门基于对象和事件驱动的**客户端脚本语言**

#### 1.2 Js特性

- 解释型语言：边解释边执行
- 面向对象
- 弱类型语言：对数据类型要求较弱，如声明变量时使用var代词
- 动态类型语言：如变量在运行期间可以任意赋值【数据类型】

#### 1.3 Js构成

- ECMAScript：ECMAScript是一个标准，而这需要由各厂商去实现。 
- DOM：Document Object Model【文档对象模型】JS 中通过 DOM来对 HTML 文档进行操作。只要理解了DOM就可以随心所欲的操作 WEB 页面。
- BOM：Browser Object Model【浏览器对象模型】

### 2. JavaScript基本语法

#### 2.1 变量

- 使用var声明变量
- 使用typeof()验证变量的数据类型

#### 2.2 数据类型

- 基本数据类型
  - number
  - string
  - boolean
  - null
  - undefined【未定义：只声明未赋值】
- 对象类型
  - 数组
  - 函数 
  - 一般对象

#### 2.3 运算符

- 算术运算符：+ - * / %  ++ --  +=  -+ ...

- 逻辑运算符：&& || ！   

- 三元运算符：【?:】

- 赋值运算符：=

- 关系【比较】运算符：> <  >=  <=  !=  ==  【===或!==】

  - == 与 ===【全等】 区别

    ==：比较两个变量的数值是否相等

    ===：比较两个变量是否全等【数值且数据类型相等】

  - !==【不全等】，不全等主要有以下两种情况

    - 数值不等
    - 数据类型不等

#### 2.4 流程控制【过：与Java中一致】

#### 2.5 Js中数组

- 定义数组
  - var  arr = ["zs",1,true];
  - var arr2 = new Array("zs",1,true);
- 调用数组
  - arr[index]
- 注意：
  - js的数组中可以存储任意数据【数据类型】
  - js的数组是自动扩容

### 3. JavaScript中的函数

#### 3.1 定义函数

- 定义普通函数：function 函数名([形参列表]){}
- 定义匿名函数：function([形参列表]){}

#### 3.2 调用函数

- js中调用函数时，不检查形参与实参匹配情况。

- 实参>形参【add()】

  - 自定忽略多余参数

- 实参<形参【add()】

  - 实参数据类型：number
    - 结果：NaN【not a number】，计算结果不是一个数值。
  - 实参数据类型：string
    - 结果：实参值+undefined

- js函数中存在隐式对象arguments，类似java中可变形参

  - ```JavaScript
    function add(i,j){
        alert(arguments[2]);
       return (i+j);
    }
    alert(add(2,1,300));
    ```

- 匿名函数调用

  - ```javascript
    //匿名函数
    var fun = function (i,j){
        alert("匿名函数,i:"+i);
    }
    fun(1,2);
    
    //为btnId关联单击事件
    btnEle.onclick = function(){
        //提示框
        alert("Hello JS!");
    }
    ```

#### 3.3 js中不存在函数重载及重写问题

- 在js中后面同名函数会覆盖前面同名函数

#### 3.4 函数调用注意事项【函数名与函数名()区别】

- 函数名：使用的函数的引用
- 函数名()：执行【触发】当前函数

### 4. Js中的对象

#### 4.1 数组是对象

#### 4.2 函数也是对象

#### 4.3 一般对象

- 对象创建&使用

  - 方式一：var obj = new Object()

    - 代码

      ```javascript
      //方式一
      var stu = new Object();
      stu.name = "jiale";
      stu.age = 23;
      stu.study = function(){
          alert(this.name+"正在学习，....");
      }
      alert(stu.age);
      stu.study();
      ```

  - 方式二：var obj2 = {"key1":value,"key2":value2,...};   //json对象

    - json对象的key建议使用string类型，json对象的value是js中支持的数据类型即可。

    - 代码

      ```javascript
      //方式二
      var stu = {
          "stuName":"caixukun",
          "stuAge":22,
          "study":function(){
              alert(this.stuName+"is studing...");
          }
      };
      alert(stu.stuAge);
      stu.study();
      ```

- **this关键字指向的是调用当前函数的对象。**

#### 4.4 js中自带对象

- **JavaScript内置对象**

  - Array 、Date、Math、……

- **浏览器对象**

  - window：浏览器对象模型中的核心对象

  - location：控制URL【地址栏】的对象【取值赋值】

    - ```javascript
      location = "http://www.baidu.com";
      // location.href = "http://www.baidu.com";
      ```

  - URL：统一资源定位符

- **dom对象**

  - document、body、button……



### 5. Js中常用事件

- onload：加载事件
- onclick：单击事件
- onchange：文本改变且失去焦点事件
- onsubmit：表单提交事件
- onblur：失去焦点事件

### 6. Js嵌入方式【书写位置】

- 行内js：结构与行为相耦合，不建议使用。

  ```html
  <button id="btnId" onclick="alert('hello js');">SayHello</button>
  ```

- 内部js：书写在\<script>标签中的js代码

- 外部js

  - 定义外部js:demo.js

    ```javascript
    window.onload = function(){
        //通过id获取元素
        var btnEle = document.getElementById("btnId2");
        //为btnId关联单击事件
        btnEle.onclick = function(){
            //提示框
            // window.alert("Hello JS!");
            alert("Hello JS!");
        }
    }
    ```

  - 引用外部js

    ```javascript
    <script type="text/javascript" src="demo.js"></script>
    ```

  - 注意：当\<script>标签中存在src属性时，当前标签内部不允许书写js代码【如书写js代码不会报错，但没效果】，如果需要在当前文档中书写js代码，需要新建一个\<script>标签即可。

### 7. window.onload事件作用

- 当前文档【完全加载】后执行
  - 完全加载：当前文档中所有关联内容全部加载

### 8. Js操作DOM【查询】

#### 8.1 DOM概述

- Document Object Model(文档对象模型)，将整个文档封装为document对象，便于js操作DOM。
- DOM中的节点类型
  - 文档节点(Document)：DOM标准将**整个HTML文档**的相关信息封装后得到的对象。
  - 元素节点(Element)：DOM标准将**HTML标签**的相关信息封装后得到的对象。
  - 属性节点(Attribute)：DOM标准将**HTML标签属性**的相关信息封装后得到的对象。
  - 文本节点(Text)：DOM标准将**HTML文本**的相关信息封装后得到的对象。

#### 8.2 DOM查询API

- 基于整个文档查询
  - document.getElementById()：通过id获取元素节点
  - document.getElementsByTagName()：通过标签名获取元素节点
  - document.getElementsByName()：通过name属性值获取元素节点
- 基于子元素节点查询
  - 查询子节点
    - element.childNodes：获取所有子节点
    - element.firstChild：获取第一个子节点
    - element.lastChild：获取最后一个子节点
    - elemtn.getElementsByTagName()：通过标签名获取子节点
  - 查询父节点
    - element.parentNode：获取父节点
  - 查询兄弟节点
    - element.previousSibling：获取前一个兄弟节点
    - element.nextSibling：获取后一个兄弟节点

