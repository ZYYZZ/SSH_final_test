# 软件工具与环境大作业

&emsp;班级：软件171&emsp;&emsp;姓名：王炯霄&emsp;&emsp;学号：3170921002

## 设计

### 基础业务设计
<p style="text-indent:2em">1. 需求分析</p>

&emsp;&emsp; （1） 管理员：对图书信息进行增删改查功能、对用户的查询删除功能、对图书借阅记录的查询  
&emsp;&emsp; （2） 用户：对图书的借还书目登记、对自身信息的修改  
&emsp;&emsp; （3） 整体：界面使用简单、使用SSH框架编写  

<p style="text-indent:2em">2. 概要设计</p>

![概要设计](image\概要设计.png)

&emsp;&emsp; （1） 管理员和用户进行登录之后不同的界面可选自己所需的操作  
&emsp;&emsp; （2） 将action层划分为三类请求：Login处理页面特殊请求跳转 Admin处理管理员请求 User处理用户请求  
&emsp;&emsp; （3） 对Dao层不同的数据库表使用不同的Dao类实现  

<p style="text-indent:2em">3. 详细设计</p>  

![概要设计](image\概要顺序图.png)  

&emsp;&emsp; &ensp;先根据需求分析对action层方法和struts文档进行规划，struts分为三个包，分别为Login、Admin和User对应action层中的三个类。  
&emsp;&emsp; &ensp;对action中的方法由Service中的方法处理解决，设计三个Service处理前端请求。  
&emsp;&emsp; &ensp;由于需求分析需要对用户信息、图书信息及借阅信息进行处理。所以数据库中设计用户表、图书表、借阅表。归还表。每个表对应一个Dao层中的类，对其进行各种增删改查。

  
### 数据库设计

![概要设计](image\E-R.png)  

### 前端设计

![概要设计](image\界面.png)  
  
## git的使用
