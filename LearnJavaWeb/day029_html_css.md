## day01_HTML_CSS

### 1. B/S与C/S

- B/S指浏览器与服务器之间工作方式
  - 优势：无需占用本地存储空间
  - 不足：所有请求与响应占用大量网络带宽
- C/S指客户端与服务器之间工作方式
  - 优势：无需占用大量网络带宽
  - 不足：需要占用本地存储空间

### 2. 网页三要素

- 结构【HTML】
- 表现【CSS】
- 行为【JavaScript|jQuery】

### 3. HTML语法

- HTML整体分为两类标签，一类叫有开始有结束标签【成对标签】，另一类叫自结束标签
- HTML不区分大小写
- HTML标签可以嵌套，但不能交叉嵌套
- HTML标签必须正确关闭
- HTML标签属性必须有值，且用双引号括起来
- HTML注释不能嵌套

### 4. HTML常用标签

- 标题标签
  - 语法：\<h1>\</h1>  - \<h6>\</h6>
  - 作用：标题
  - 特点：自带换2行效果

- 换行标签
  - 语法：\<br> 或 \<br/>
  - 作用：换行
- 分区布局标签
  1. div
     - 语法：\<div>\</div>
     - 作用：div本身无实际语义，主要用于分区布局。
     - 特点：自带换1行效果【块级元素】
  2. span
     - 语法：\<span>\</span>
     - 作用：span本身无实际语义，主要用于分区布局。
     - 特点：不自带换行效果【内联元素】

- 段落标签
  - 语法：\<p>\</p>
  - 作用：区分段落
  - 特点：自带换2行效果

- 实体字符【转义字符】
  - 语法：以&开头，以;结尾
  - 常用字符如下
    - 空格：\&nbsp;    \&emsp;【中文空格】
    -  大于号：\&gt;
    - 小于号：\&lt;
    - 版权号：\&copy;

- 分割线
  - 语法：\<hr>
  - 作用：分隔

### 5. HTML重点标签

- 插入图片
  - 语法：\<img src=""  title="" alt="">
  - 属性：
    - src：设置插入图片路径
    - title：设置【鼠标移入时】文本提示
    - alt：设置【当图片路径有误时】文本提示
- 关于路径
  - 相对路径：相对当前文件路径，进行查找目标路径。
    - 如目标文件与当前文件，在同一目标下，可以直接查找使用。
    - 如目标文件与当前文件，不在同一目标下
      - 先找目标文件的上一级目录，再找目标文件
      - 如目标文件与当前文件也不在同一目录，最终基于当前项目进行查找。
    - ./：当前目录
    - ../：当前目录的上一级目录
  - 绝对路径：基于服务下的某种特定路径【http://192.168.x.x/staticpro_1021】
  - 真实路径：基于本地盘符路径【D:/dir/xxx】

- 超链接
  - 语法：\<a href="" target="">文本\</a>
  - 属性
    - href：设置链接路径
    - target：设置链接目录路径方式【\_self或\_blank】
      - _self【默认值】：以当前选项卡打开，目录路径
      - _blank：以新选项卡打开，目标路径

### 6. HTML重点标签-列表

- 无序列表
  - 语法：\<ul>\<li>\</li>\</ul>
  - 列表类型：type属性值
    - disc【默认值】：实心圆形
    - square：实心方形
    - circle：空心圆形

- 有序列表
  - 语法\<ol>\<li>\</li>\<ol>
  - 列表类型：type属性值
    - 1
    - a|A
    - i|I

- 自定义列表
  - 语法：\<dl><dt><dt><dd></dd>\</dl>

### 7. HTML中表格

- 语法

  - 使用<table>标签定义表格，使用<tr>标签定义行，使用<td>定义单元格，使用<th>定义表头

- 表格跨行跨列

  - colspan：跨列
  - rowspan：跨行

- 代码

  ```html
  <table border="1" width="700px" height="500px" align="center">
        <tr>
           <th>表头1</th>
           <th>表头2</th>
           <th>表头3</th>
           <th>表头4</th>
           <th>表头5</th>
        </tr>
        <tr align="center">
           <td colspan="2">2122</td>
  <!--         <td>22</td>-->
           <td>23</td>
           <td>24</td>
           <td rowspan="2">2535</td>
        </tr>
        <tr align="center">
           <td>31</td>
           <td>32</td>
           <td>33</td>
           <td>34</td>
  <!--         <td>35</td>-->
        </tr>
        <tr align="center">
           <td>41</td>
           <td rowspan="2" colspan="3">424344525354</td>
  <!--         <td>43</td>-->
  <!--         <td>44</td>-->
           <td>45</td>
        </tr>
        <tr align="center">
           <td>51</td>
  <!--         <td>52</td>-->
  <!--         <td>53</td>-->
  <!--         <td>54</td>-->
           <td>55</td>
        </tr>
     </table>
  ```

### 8. HTML中表单

- 语法：使用\<form>\</form>定义表单，使用\<input>、\<select>\<option>、\<button>、\<textarea>定义表单项

- 属性：<form action="" method="">
  - action：设置表单提交路径
  - method：设置表单提交方式【get|post】
- 表单项
  - input表单项：\<input type="" name="" value="">
    - type：设置表单项类型
      - text：单行文本框
      - password：密码框
      - redio：单选按钮
      - checkbox：复选框【多选按钮】
      - submit：提交按钮
      - reset：重置按钮
      - hidden：隐藏域
      - file：文件域【文件上传】
    - name：设置表单项名称
    - value：设置表单项数值
    - checked：设置单选框和复选框默认选中
  - 下拉列表\<select>\<option>\</option>\</select>
    - selected：设置下拉框默认选中
  - 

- 注意：
  1. 如表单项需要提交数据时，必须指定当前表单项的name属性值
  2. 在设置表单项value属性时，
     - 如设置文本框和密码框，设置value属性值时是：默认值
     - 如设置submit等按钮时，设置value属性值时是：按钮的文本值
  3. 如需将单选框或复选框【多选框】设置为一组时【实现单选效果】，需要设置name属性值一致即可。
  4. 一般情况：使用单选框或复选框时，需要设置value属性值作为数据
  5. 如未指定下拉框【下拉列表】的value属性值时，默认将文本值作为value属性值。

### 9. CSS

- CSS简介

  - CSS全称为“层叠样式表 (Cascading Style Sheets)”
  - CSS作用：主要用于美化HTML页面，如：文字大小、颜色、字体、边框、位置等。

- CSS使用

  - CSS格式

    - **选择器 {**

      ​      **样式名：样式值;**

      ​      **样式名：样式值;**

      ​      **…………**

      **}**

  - 示例代码

    ```css
    <style type="text/css">
       p{
          color: blue;
          font-size: 36px;
       }
    </style>
    ```

- CSS嵌入方式【书写位置】

  1. 行内样式表【不推荐使用】

     - ```html
       <p style="color: red;">第一段落</p>
       ```

  2. 内部样式表【少量使用】

     - 书写在<style>标签内【<style>标签一般建议书写位置：<head></head>标签内】

  3. 外部样式表【推荐使用】

     - 定义外部样式表：demo.css
     - 引入外部样式表：<link href="demo.css" type="text/css" rel="stylesheet">
       - href：设置引入文件路径
       - rel：设置引入文件与当前文件关系
       - type：设置文件类型

  4. 总结：CSS嵌入方式优先级【行内>内部>外部】

- CSS选择器
  - ID选择器
    - 定义：#id名称{}
    - 使用：\<xxx id="id名称">\</xxx>
  - 类选择器
    - 定义：.类名{}
    - 使用：\<xxx class="类名">\</xxx>
  - 标签选择器
    - 定义：标签名{}
  - 总结：选择器优先级：ID选择器>类选择器>标签选择器

- CSS中颜色取值
  - 颜色名
    - red
    - green
    - blue
  - 十六进制
    - #ff0000【#f00】代表红色
    - #00ff00【#0f0】代表绿色
    - #0000ff【#00f】代表蓝色
  - rgb()
    - rgb(255,0,0)
    - rgb(0,255,0)
    - rgb(0,0,255)

















