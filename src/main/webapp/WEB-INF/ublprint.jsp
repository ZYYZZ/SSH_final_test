<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借书表</title>
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
			<td align="center" colspan = "4">
				<h2>所有借书信息</h2>
			</td>
		</tr>
		<tr align="center">
			<td><b>图书ID</b></td>
			<td><b>图书名称</b></td>
			<td><b>用户姓名</b></td>
			<td><b>借书时间</b></td>
		</tr>
			
		<s:iterator var="ubl" value="ubls" status="st">
		<tr align = "center">
			<td><s:property value="bid"/></td>
			<td><s:property value="bname"/></td>
			<td><s:property value="uname"/></td>
			<td><s:property value="Ltime"/></td>
		</tr>
		</s:iterator>
		
	</table>
	<h3 align="center">result</h3>
	
	<div align="right">
		<a href="BacktoAdmin.action">返回</a>
	</div>

</body>
</html>