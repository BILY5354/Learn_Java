## day14_ajax_json

## Ajax

### 1. 同步请求&异步请求

#### 1.1 同步请求

- 请求方式
  - \<a href="#">\</a>
  - \<form action="#">\</form>
  - js中 location.href=""
  - ...
- 同步请求不足
  - 浏览器向服务器发送请求，服务器做出响应之前，整个浏览器不能发生用户行为，减低用户体验度
  - 如整个页码只需要刷新局部数据时，同步请求也必须刷新整个页码，增加服务器压力

#### 1.2 异步请求【局部请求】

- 请求方式：ajax()
- 异步请求，主要用于弥补同步请求的缺陷。开发时，一般结合同步请求与异步请求，共同使用。

- 异步请求使用场景
  - 大厂，应用软件中，搜索框级联提示、首页商品展示。
  - 硅谷书城项目中，购物车中修改购物项数量、注册中验证用户名是否存在。

### 2. Ajax简介

- Ajax全称：**A**synchronous  **J**avascript **A**nd **X**ML”（异步JavaScript和XML）
- Ajax本质：通过JS向服务器【在不发生页面跳转】发送请求，并异步【以回调函数】载入内容技术。

### 3. Ajax语法

- ajax基本语法

  ```javascript
  $.ajax({
      type: "POST",                       //设置提交方式【GET|POST|PUT|DELETE】
      url: "AjaxTestServlet",             //设置提交路径
      data: "name=John&location=Boston",  //设置请求参数
      dataType:"text",                    //预期服务器返回的数据类型[text\json]
      success: function(msg){             //请求成功回调函数
          alert( "Data Saved: " + msg );
      },
      error:function () {                 //请求失败回调函数
          alert("请求失败！");
      }
  });
  ```

- ajax简写语法
  - $.get(url,[data],[success],[dataType]);   //以get方式请求
  - $.post(url,[data],[success],[dataType]);//以post方式请求
  - $.getJSON(url,[data],[success]);             //以get方式请求,并以json格式响应数据



## JSON

### 1. Json简介

- json全称：JavaScript Object Notation【是JS提供的一种轻量级的数据交换格式】
- json本质：是一个javaScript对象，但这个对象比较特殊【js环境下】，可以方便与string类型相互转换。

- json作用：在不同语音、不同生态之间传递数据。

### 2. Json语法

- var jsonObj = {"key":value,"key2":value2,...};

- json的key建议使用string类型，json的value支持js中的数据类型。

- Json使用

  ```javascript
  var jsons = {
      "key1":"abc", // 字符串类型
      "key2":1234,  // Number
      "key3":[1234,"21341","53"], // 数组
      "key4":{                    // json类型
          "key4_1" : 12,
          "key4_2" : "kkk"
      },
      "key5":[{                  // json数组
          "key5_1_1" : 12,
          "key5_1_2" : "abc"
      },
          {
              "key5_2_1" : 41,
              "key5_2_2" : "bbj"
          }]
  };
  
  // alert(jsons.key2);           //1234
  // alert(jsons.key3[2]);        //53
  // alert(jsons.key4.key4_2);    //kkk
  alert(jsons.key5[1].key5_2_2);       //bbj
  ```

### 3. Json解析

#### 3.1 在JavaScript环境下，Json对象与Json字符串转换问题

- json对象转换为jsonString
  - JSON.stringify( json )：此方法可以把一个json对象转换成为json字符串 
- jsonString转换为json对象
  - JSON.parse( jsonString )： 此方法可以把一个json字符串转换成为json对象

#### 3.2  在Java环境下，Java对象【bean\list\map】与Json字符串转换问题

> Google下的Gson工具类

- java对象转换为jsonString

  ```java
  Gson gson = new Gson();
  String jsonString = gson.toJson(stu);
  ```

- jsonString转换为java对象

  ```java
  //javaBean
  Student student = gson.fromJson(jsonString, Student.class);
  //List或Map
  List<Student> listRs = gson.fromJson(jsonString, new TypeToken<List<Student>>() {
          }.getType());
  Map<String,Student> mapRs = gson.fromJson(jsonString,new TypeToken<Map<String,Student>>(){}.getType());
          
  ```











