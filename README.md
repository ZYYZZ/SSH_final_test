# 软件工具与环境大作业

&emsp;班级：软件171&emsp;&emsp;姓名：王炯霄&emsp;&emsp;学号：3170921002

## 设计

### 基础业务设计
<p style="text-indent:2em" >1. 需求分析</p>

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

![概要设计](image\git使用.png)  

## Struts2
  
### MVC基本使用
```
	<action name="BacktoAdmin" class = "cn.edu.xaut.web.LoginAction" method = "backtoadmin">
       	<param name="user.username">admin</param>
		<param name="user.password">password</param>  
    	<result name = "success" type = "chain">
    			Login_Check
    	</result>
    </action>

    <action name="Login_Check" class="cn.edu.xaut.web.LoginAction" method = "login">
       		<param name="pageSize">2</param>
			<param name="page">1</param>
       		<result name="admin" >
       			/WEB-INF/index_Admin.jsp
       		</result>
       		<result name="user" >
       			/WEB-INF/index_User.jsp
       		</result>
       		<result name="input">
       			login.jsp
       		</result>
    </action>
```

&emsp;&emsp;使用action对jsp页面请求处理 不同的结果导向不同的jsp页面跳转

### Struts2标签库  
  
```
<tr align="center">
	<td><b>图书ID</b></td>
	<td><b>图书名称</b></td>
	<td><b>借书日期</b></td>
	<td><b>操作</b></td>
</tr>	

	<s:iterator var="ubl" value="ubls" status="st">
	<tr>
		<td> <s:property value="bid"/> </td>
		<td> <s:property value="bname"/> </td>
		<td> <s:property value="Ltime"/></td>
		<td>
			<form action="Rebook.action?bid=${bid}&uid=${uid}" method="post">
				<input type = "submit" value="还书">
				</form>
		</td>
	</tr>
	</s:iterator>
```
&emsp;&emsp;使用s标签对用户借书信息进行显示

## Hibernate

### Hibernate持久化

![uml图](image\对象UML图.png)

```
	public void addbook(Book nbook) {
		Session session = sessionFactory.openSession();
		session.save(nbook);
		
		session.close();
		// TODO Auto-generated method stub
	}
```
&emsp;&emsp;使用hibernate直接对对象持久化

### Hibernate检索

```
	public Book seachone(int bid){
		Session session = sessionFactory.openSession();
		String hql = "from Book where id=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, bid);
		return ( (Book) q.list().get(0) );
	}
```
&emsp;&emsp;使用hql语句对对象进行检索

### 分页查询功能

```
public List<Book> findBookByPage(int page, int pageSize) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "from Book";
		Query q = session.createQuery(hql);
		q.setFirstResult((page-1)*pageSize);
		q.setMaxResults(pageSize);
		
		List<Book> books = q.list();
		session.close();
		return books;
	}
```

&emsp;&emsp;使用页码和页码尺寸对数据库进行部分结果的查询

```
<s:iterator var="book" value="books" status="st">
	<tr align = "center">
		<td><s:property value="id"/></td>
		<td><s:property value="name"/></td>
		<td><s:property value="count"/></td>
		<td><s:property value="price"/></td>
		<td><s:property value="author"/></td>
		<td>
			<a href="bookupd.action?bid=${id} ">修改</a>
		</td>
		<td>
			<a href="bookdel.action?bid=${id}">删除</a>
		</td>	
	</tr>
</s:iterator>
```

&emsp;&emsp;使用s标签对分页查询结果进行显示

## Spring

### Spring容器的使用
![注入关系](image\注入关系图.png)

&emsp;&emsp; datasource注入sessionFactory后 注入四个Dao类中

&emsp;&emsp; 四个Dao类分别注入不同的Service层类

&emsp;&emsp; 每个Service分别注入对应的Action类

### Spring AOP使用

```
	<bean id="txManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
		<property name="sessionFactory" ref="sessionFactory"></property>
	</bean>
	
	<aop:config>
		<aop:pointcut expression="execution(public * cn.edu.xaut.service..*.*(..))" id="myService"/>
		<aop:advisor advice-ref="myAdivce" pointcut-ref="myService"/>
	</aop:config>
	
	<tx:advice id="myAdivce" transaction-manager="txManager">
		<tx:attributes>
			<tx:method name="*" propagation="REQUIRED"/>
		</tx:attributes>
	</tx:advice>
```
&emsp;&emsp; 使用sop对事物进行管理 对所有service进行数据库操作室进行Transaction的begin和commit

