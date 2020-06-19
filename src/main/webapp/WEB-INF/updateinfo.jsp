<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信息修改</title>
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
</style>
<script>
	function Tiaozhuan() {
		document.getElementById("formUpdate").submit();
	}
</script>
</head>
<body style = "background:url(images/back0.2.jpg); background-size: 100%;">
  		<table align = "center" width = "450" >
		<tr>
			<td align="center" colspan = "7">
				<h2>修改图书信息</h2>
			</td>
		</tr>
		<tr>
			<td colspan = "7"><p>在下方填写所需修改信息即可</p></td>
		</tr>
		<tr align="center">
			<td><b>ID</b></td>
			<td><b>图书名称</b></td>
			<td><b>数量</b></td>
			<td><b>价格</b></td>
			<td><b>作者</b></td>
		<tr>
			<form name="Updateform" id="formUpdate" action="Updateinfo.action" method ="post">
			<td> </td>
		<td>
			<input type = "hidden" name = "book.id" value="${bid}">
			<input style = "width:95%" type = "text" name= "book.name">
		</td>
		<td>
			<input style = "width:95%" type = "text" name= "book.count">
		</td>
		<td>
			<input style = "width:95%" type = "text" name= "book.price">
		</td>
		<td>
			<input style = "width:95%" type = "text" name= "book.author">
		</td>
			</form>
		</tr>
	</table>
    <div align="center">
		<button form="Updateform" onclick="Tiaozhuan()">信息提交</button>
	</div>
	<div align="right">
		<a href="BacktoAdmin.action">返回</a>
	</div>
	<jsp:include page ="/DynamicTime.jsp"/>
</body>
</html>