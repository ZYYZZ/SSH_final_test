<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix = "s" uri = "/struts-tags" %>
<html>
<head>
<%
	String  result = "XX图书欢迎您";
	if(request.getAttribute("result")!=null){
		result = (String) request.getAttribute("result");
	}
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录图书管理系统 </title>
<style type="text/css">
button {
        width: 200px;  
        padding:8px;  
        background-color: #428bca;  
        border-color: #357ebd;  
        color: #fff;  
        -moz-border-radius: 10px;  
        -webkit-border-radius: 10px;  
        border-radius: 10px; /* future proofing */  
        -khtml-border-radius: 10px; /* for old Konqueror browsers */  
        text-align: center;  
        vertical-align: middle;  
        border: 1px solid transparent;  
        font-weight: 900;  
        font-size:125%  
      }
      table
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        table td, table th
        {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }
        table thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        table tr:nth-child(odd)
        {
            background: #fff;
        }
        table tr:nth-child(even)
        {
            background: #F5FAFA;
        }
<!--
.STYLE1 {
	font-size: 36px;
	font-weight: bold;
}
-->
</style>
<script>
	function Tiaozhuan() {
		document.getElementById("form2").submit();
	}
</script>
</head>
<body style = "background:url(images/back0.2.jpg); background-size: 100%;">
<br><br><br><br><br><br><br>
<form id = "form2" method="post" action="Login_Check">
  <table width="400" height="120" border="1" align="center">
    <caption>
      <span class="STYLE1">XX图书</span>
    </caption>
    <tr>
      <td align = "center" width="166">用户名：</td>
      <td width="318"><input name="user.username" type="text" id="username"></td>
    </tr>
    <tr>
      <td align = "center">密码：</td>
      <td><input name="user.password" type="password" id="password"></td>
    </tr>
    <tr>
      <td colspan="2" align = "center">
      <p>还没有账号？<a href="reg.jsp">点击注册</a></p>
      
    </tr>
  </table>
</form>
<div align="center"><button  form="form2" onclick="Tiaozhuan()">登录</button></div>
<p align = "center" style = "color:red"><%=result %> </p>
<jsp:include page ="/DynamicTime.jsp"/>
</body>
</html>