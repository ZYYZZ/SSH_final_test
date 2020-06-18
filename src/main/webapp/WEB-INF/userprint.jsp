<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户信息</title>
<style type="text/css">
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
</style>
<script>
	
</script>
<jsp:include page ="/DynamicTime.jsp"/>
</head>
<body style = "background:url(images/back0.2.jpg); background-size: 100%;">
<table align = "center" width = "450" id="table1">
		<tr>
			<td align="center" colspan = "5">
				<h2>所有用户信息</h2>
			</td>
		</tr>
		<tr align="center">
			<td><b>ID</b></td>
			<td><b>用户名</b></td>
			<td><b>邮件地址</b></td>
			<td><b>手机号</b></td>
			<td><b>操作</b></td>
		</tr>
		
		<s:iterator var="user" value="users" status="st">
		<tr align = "center">
			<td><s:property value="id"/></td>
			<td><s:property value="username"/></td>
			<td><s:property value="email"/></td>
			<td><s:property value="phonenum"/></td>
			<td>
				<a href = "Userdele_Ser?id=${user.id }%>">注销</a>
			</td>	
		</tr>
		</s:iterator>
		
	</table>
	<h3 align="center"></h3>
	
	<div align="right">
		<a href="BacktoAdmin.action">返回</a>
	</div>
	
	<s:debug></s:debug>
</body>
</html>