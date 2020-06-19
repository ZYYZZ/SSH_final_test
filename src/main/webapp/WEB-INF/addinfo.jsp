<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>信息输入</title>
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
		document.getElementById("formAdd").submit();
	}
</script>
</head>
<body style = "background:url(images/back0.2.jpg); background-size: 100%;">
	<form id="formAdd" name="form3" action="Addinfo.action" method="post">
  		<table width="500" height="120" border="1" align="center">
   		 <caption>
     	 <span style = "font-size: 36px;font-weight: bold;">信息录入</span>
		 </caption>
    	<tr>
    	  <td align = "center" width="266">图书名称：</td>
    	  <td width="318"><input  type="text" name="book.name" id="bookname" ></td>
    	</tr>
    	<tr>
     	  <td align = "center">价格：</td>
    	  <td><input type="text" name="book.price" id="price" ></td>
    	</tr>
    	
    	<tr>
     	  <td align = "center">数量：</td>
    	  <td><input type="text" name="book.count" id="count" >
    	</tr>
    	<tr>
     	  <td align = "center">作者：</td>
    	  <td><input type="text" name="book.author" id="author" >
    	</tr>
  	</table>
  	<div align="center">
    		<button form="form3" onclick="Tiaozhuan()">信息提交</button>
	</div>
	<div align="right">
		<a href="BacktoAdmin.action">返回</a>
	</div>
	<jsp:include page ="/DynamicTime.jsp"/>
</body>
</html>