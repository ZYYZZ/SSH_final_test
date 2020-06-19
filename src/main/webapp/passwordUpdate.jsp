<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,cn.edu.xaut.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<%
		String result = "";
		if(request.getAttribute("result")!=null){
			result = (String) request.getAttribute("result");
		}
		User user = (User) session.getAttribute("user");
%>
<meta charset="UTF-8">
<title>修改密码</title>
<style type="text/css">

      table{
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        table td, table th{
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }
        table thead th{
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd){
            background: #fff;
        }
        table tr:nth-child(even){
            background: #F5FAFA;
        }
	</style>
	<script>
	function passwordBegin() {
        var PASSWORD = document.getElementById("PASSWORD");
        PASSWORD.innerHTML = "密码不少于6位";
    }
	
	function passwordCheck() {
        var password = document.getElementById("newpassword").value;
        var PASSWORD = document.getElementById("PASSWORD");
        if (password == "") {
        	PASSWORD.innerHTML = "密码不能为空";
        }
        else if (password.length < 6) {
        	PASSWORD.innerHTML = "格式错误";
        } else {
        	PASSWORD.innerHTML = "正确";
            ceshi[1]=0;
        }
    }
	
	function passwordCheck_2() {
        var password = document.getElementById("newpassword").value;
        var password_2 = document.getElementById("newpassword_2").value;
        var PASSWORD_2 = document.getElementById("PASSWORD_2");
        if (password_2 == "") {
        	PASSWORD_2.innerHTML = "请输入确认密码"
        } else if (password_2 != password) {
        	PASSWORD_2.innerHTML = "两次密码不一致，请重新输入";
        } else {
        	PASSWORD_2.innerHTML = "正确";
            ceshi[2]=0;
        }
    }
	
	function Tiaozhuan(){
		var bool = confirm("确认修改密码？");
		if(bool == true){
			document.getElementById("passwordUpjsp").submit();
		}
	}
	</script>
</head>
<jsp:include page ="/DynamicTime.jsp"/>
<body style = "background:url(images/back0.2.jpg); background-size: 100%;">
	<form id="passwrodUpjsp" name="passwordUpjsp" action="passwordUpdate.action" method="post">
  		<table width="500" height="120" border="1" align="center">
   		 	<caption>
     	 	<span ><font font-size: 36px;font-weight: bold;>修改密码</font></span>
		 	</caption>
    	
	    	<tr>
	     	  	<td align = "center">新密码：</td>
	    	  	<td><input type="password" name="user.password" id="newpassword" 
	    			onfocus="passwordBegin()" onblur="passwordCheck()"></td>
	    	  	<td><span id="PASSWORD"></td>
	    	</tr>
    	
	    	<tr>
	     	  	<td align = "center">重复新密码：</td>
	    	  	<td><input type="password" name="newpassword_2" id="newpassword_2" 
	    			onblur="passwordCheck_2()">
	    	  	<td><span id="PASSWORD_2"></td>
	    	</tr>
    	
  		</table>
  	<div align="center"><button form="passwrodUpjsp" onclick="Tiaozhuan()">确认修改密码</button></div>
  		</form>
			<div align="right" margin-left:80%>
				<a href="BacktoUser.action">返回</a>
  				<!-- <form action="login_check.action" method="post">
  					<input type="hidden" name = "username" value=" user.getUsername() ">
  					<input type="hidden" name = "password" value=" user.getPassword() ">
  					<input type="submit" value="返回首页">
  				</form>	 -->
	</div>
	
	<s:debug></s:debug>
	
	<h3 align="center"><%=result %></h3>
</body>
</html>