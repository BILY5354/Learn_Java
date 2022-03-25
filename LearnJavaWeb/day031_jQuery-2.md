## day03_jQuery

### 1.jQuery简介

- jQuery是兼容多浏览器、轻量级的免费开源JavaScript库。
- jQuery宗旨：Write Less,Do More【写的少，做的多】

### 2. $与$()

- $是jQuery，jQuery函数引用
- $()是触发【调用】核心函数

### 3. 核心函数作用【$()】

1. 传入参数为函数时：$(function(){})，类似与window.onload作用
   - $(fn) 与window.onload=fn区别
     1. 加载时机不同，前者当前文档【绘制成功】后执行fn，后者当前文档【完全加载】后执行fn。
        - 绘制成功：节点加载【绘制】成功【标签、属性、文本】
        - 总结：$(fn)先执行，window.onload=fn后执行
     2. 在当前文档中，书写次数不同：前者可以书写多次，后者只能书写一次。
        - 后者如果书写多次，后面window.onload会覆盖前面
     3. 语法结构不同，前者有两种语法结构，后者只有一种语法结构
        - $(document).ready(fn);  ==  $(fn);
2. 传入参数为选择器字符串时： $(选择器字符串)
3. 传入参数为HTML字符串时：$(HTML字符串)，创建HTML元素节点
4. 传入参数为DOM对象时： $(DOM对象)，将DOM对象转换为jQuery对象

### 4. DOM对象与jQuery对象转换问题

> 为什么DOM对象与jQuery对象需要转换呢？
>
> ​	因为：默认情况，DOM对象与jQuery对象不能调用对方的属性或方法，所以，当需要调用对方的属性或方法时，需要类型转换

- DOM对象转换为jQuery对象
  - var $obj = $(DOM对象);
- jQuery对象转换为DOM对象【将jQuery对象看成数组或集合（伪数组）】
  - var domObj = $obj[0]
  - var domObj = $obj.get(0)

### 5. jQuery选择器

#### 5.1 基本选择器

- $("#id")：id选择器
- $("标签名")：标签选择器
- $(".类名")：类选择器
- $("*")：【全局】选择器
- $("p,span,#id,.class")：并集选择器

#### 5.2 层级【层次】选择器

- $("E F")：后代选择器
- $("E>F")：子代选择器【子一代】
- $("E+F")：相邻选择器【后一个元素】
- $("E~F")：同辈选择器【后面所有兄弟元素】

#### 5.3 过滤选择器

- 基本过滤选择器

  - $(":first")
  - $(":last")
  - $(":eq()")
  - $(":gt()")
  - $(":lt()")
  - $(":even")
  - $(":odd")
  - $(":header")
  - $(":animated")
  - $(":not()")

- 内容过滤选择器

  - $(":contains()")
  - $(":has()")
  - $(":empty")
  - $(":parent")

- 可见性过滤选择器

  - $(":hidden")
  - $(":visible")

- 属性过滤选择器

  - $("[id]")
  - $("[id='']")
  - $("[id!='']")
  - $("[id^$*=]")
  - $("[id]\[name='']")

- 子元素过滤选择器

  - $(":first-child")：为【每个】父元素匹配子元素
  - $(":last-child")

- 表单过滤选择器

  - $(":input")：匹配所有表单项【input\select\textarea\button】元素
  - $(":text")
  - $(":password")
  - $(":radio")
  - $(":checkbox")
  - $(":submit")
  - $(":reset")
  - $(":file")
  - $(":hidden")
  - $(":button")

- 表单对象属性过滤选择器

  - $(":enabled")
  - $(":disabled")

  - $(":checked")：匹配【单选框和复选框选中的】元素
  - $(":selected")：匹配【下拉框选中的】元素



### 6. jQuery操作DOM

> DOM:文档对象模型【文档节点、元素节点、属性节点、文本节点】

#### 6.1 jQuery 操作标签【元素节点】

- 增
  - 内后
    - append()
    - appendTo()
  - 内前
    - prepend()
    - prependTo()
  - 外后
    - after()
    - insertAfter()
  - 外前
    - before()
    - insertBefore()
- 删
  - empty()：掏空
  - remove()：删除本身
- 改
  - replaceWith()
  - replaceAll()
- 查【API中筛选】
  - eq()
  - first()
  - last()
  - filter()
  - is()
  - has()
  - add()
  - children()
  - find()
  - next()
  - nextAll()
  - prev()
  - prevAll()
  - parent()
  - parents()

#### 6.2 jQuery操作属性

- attr(“”)：获取指定属性值
- attr("","")：为指定属性赋值
- prop()：同上【attr升级版】

#### 6.3 jQuery操作文本

- text()：获取文本值
- text("")：设置文本值
- html()
- val()：获取指定元素value属性值
- val("")：为指定元素设置value属性值
- val([""])：为下拉框、单选框、多选框设置选中状态

#### 6.4 jQuery操作样式表

- css("")：获取指定样式表
- css("","")：为指定元素设置样式表
- addClass()
- removeClass()



### 7. jQuery常用事件

- $(document).ready(fn)：当前文档绘制成功后执行
- click(fn)：单击事件
- live("事件名",fn)：事件委派【$xxx.live("事件名",fn)】
- delegate(“选择器”，“事件名”，fn)
- change(fn)：文本改变且失去焦点事件
- mouseover(fn)：鼠标移入【悬停】事件
- mouseout(fn)：鼠标移出事件



### 8. 正则表达式

- 为什么需要正则表达式

  - 在软件研发中，往往对数据验证要求比较严格【用户名只能是字母、数字、_（6-12位）】，此时使用正则表达式验证数据，更加方便、安全。
- 正则表达式概述：一组验证数据规则
- 使用
  - 语法：
    1. var reg = /规则/;
    2. var reg2 = /^[规则]{n,m}$/;
       - {n}：只能匹配n次
       - {n,m}：n次=<匹配<=m次
       - {n，}：匹配>=n次
  - 验证
    - test()：返回boolean类型数值【true:数据合法，false:数据不合法】

- 特殊规则

  - 特殊字符

    - \d：等价于[0-9]
    - \w：等价于[a-zA-Z0-9_]
    - .：匹配除'\n'任何字符

  - 特殊次数

    *：等价于{0，}【匹配任意次】

    +：等价于{1，}【匹配至少一次】

    ?：等价于{0,1}【匹配0次或1次】

- 示例代码

  ```javascript
  $("#btnSub").click(function () {
     //获取用户名[用户名只能是字母、数字、_（6-12位）]
     var unValue = $("#username").val();
     //定义用户名正则规则
     // var unReg = /a/;          //包含字母‘a’即可
     // var unReg = /^a/;         //以字母'a'开头即可
     // var unReg = /a$/;         //以字母'a'结尾即可
     // var unReg = /ab/;         //包含字母'ab'即可【ab不可拆分】
     // var unReg = /^[ab]$/;      //包含一个字母‘a’或‘b’
     var unReg = /^[a-zA-Z0-9_]{6,12}$/;          //字母、数字、_（6-12位）
     if(unReg.test(unValue) == false){
        alert("用户名不合法！");
        return false;
     }
  
  });
  ```