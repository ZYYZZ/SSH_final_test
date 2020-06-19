<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="java.util.*,cn.edu.xaut.entity.User" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%
		String result = "XX图书欢迎您";
		if(request.getAttribute("result")!=null){
			result = (String) request.getAttribute("result");
		}
		User user = (User) session.getAttribute("User");%>
<meta charset="utf-8">
<title>XX图书</title>
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
</head>
<body style = "background:url(images/back0.2.jpg); background-size: 100%;">
		<div class=" posirelative select-out-div" style="float: right;margin-top:1% ;">
			<table>
			<form action="SeachOne_Ser" method ="post">
			<td>
				<select name = "Seach_type" style = "width:90% " >
					<option  value = "Bid">ID</option>
					<option  value = "Bname">图书名称</option>
					<option  value = "Bauthor">作者</option>
				</select>
			</td>
			<td>
				<input type="text" style="border:none;" name ="Seach_info">
			</td>
			<td>
				<input type="submit" value = "搜索">
			</td>
			</tr>
			</form>
			</table>
		</div>
		<br><br><br><br><br>
	<table align = "center" width = "450" >
		<tr>
			<td align="center" colspan = "4" >
				<h2>个人信息</h2>
			</td>
		</tr>
		<tr align="center">
			<td><b>ID</b></td>
			<td><b>用户名</b></td>
			<td><b>邮箱地址</b></td>
			<td><b>电话</b></td>
		</tr>	
		<tr align="center">
			<td>  <%=user.getId() %></td>
			<td>  <%=user.getUsername()%></td>
			<td>  <%=user.getEmail() %></td>
			<td>  <%=user.getPhonenum() %></td>
		</tr>
		<tr>
			<td align = "center" colspan = "4">
					<a href="passwordUpdate.jsp?">修改密码</a>
			</td>
		</tr>
		
	</table>
	<br><br><br>
	
	<table align = "center" width = "450" id="table1">
		<tr>
			<td align="center" colspan = "4">
				<h2>借书信息</h2>
			</td>
		</tr>
		
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
				<form action="Rebook.action?bid=${bid}&uid=${uid}" method ="post">
					<input type = "submit" value="还书">
				</form>
			</td>
		</tr>
		</s:iterator>
	</table>
	
	<h3 align="center" style = "color:white"> </h3>
	
	<div align="right" margin-left:80%>
		<a href="BacktoUser.action"><button>退出</button></a>
	</div>
	
	<s:debug></s:debug>
	<jsp:include page ="/DynamicTime.jsp"/>
</body>
</html>