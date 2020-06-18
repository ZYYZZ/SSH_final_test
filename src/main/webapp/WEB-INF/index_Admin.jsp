<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,java.text.SimpleDateFormat" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>XX图书管理</title>
<style type="text/css">
		button{  
        width: 160px;  
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
      select {
    	border: solid 1px #000;
		height:100%;
    	appearance:none;
    	-moz-appearance:none;
    	-webkit-appearance:none;

    	padding-right: 14px;

    	background: url("https://raw.githubusercontent.com/ourjs/static/gh-pages/2015/arrow.png") no-repeat scroll right center transparent;

	  }

	  #table1
        {
            border-collapse: collapse;
            margin: 0 auto;
            text-align: center;
        }
        #table1 td,th
        {
            border: 1px solid #cad9ea;
            color: #666;
            height: 30px;
        }
        #table1 thead th
        {
            background-color: #CCE8EB;
            width: 100px;
        }
        #table1 tr:nth-child(odd)
        {
            background: #fff;
        }
        #table1 tr:nth-child(even)
        {
            background: #F5FAFA;
        }
        
        .sel_btn{
            height: 21px;
            line-height: 21px;
            padding: 0 11px;
            background: #02bafa;
            border: 1px #26bbdb solid;
            border-radius: 3px;
            /*color: #fff;*/
            display: inline-block;
            text-decoration: none;
            font-size: 12px;
            outline: none;
        }
        .ch_cls{
            background: #e4e4e4;
        }
</style>
</head>
<body style = "background:url(images/back0.2.jpg); background-size: 100%;">
		<div style="float: right;margin-top:1% ;">
			<table>
			<form action="SeachOne_Ser" method ="post">
			<td>
				<select name = "Seach_type">
					<option  value = "Bid">ID</option>
					<option  value = "Bname">图书名称</option>
					<option  value = "Bauthor">作者</option>
				</select>
			</td>
			<td>
				<input type="text" name = "Seach_info">
			</td>
			<td>
				<input type="submit" value = "搜索">
			</td>	
			</tr>
			</form>
			</table>
		</div>
		<br><br>
		<h1 align="center" style = "color:red">欢迎管理员</h1>
		<p align="center" font-size:20px>请选择操作继续：</p>
		<div align="center" >
		<a href="Userprint.action">
		<button>查看用户</button>
		</a>
		
		<a href="Lprint.action">
		<button>查看借书表</button>
		</a>
	</div>
	<br>
	<br>
	<table align = "center" width = "450" id="table1">
		<tr>
			<td align="center" colspan = "7">
				<h2>所有图书信息</h2>
			</td>
		</tr>
		<tr align="center">
			<td><b>ID</b></td>
			<td><b>图书名称</b></td>
			<td><b>数量</b></td>
			<td><b>价格</b></td>
			<td><b>作者</b></td>
			<td><b>修改</b></td>
			<td><b>删除</b></td>
		</tr>	
		<s:iterator var="book" value="books" status="st">
		<tr align = "center">
			<td><s:property value="id"/></td>
			<td><s:property value="name"/></td>
			<td><s:property value="count"/></td>
			<td><s:property value="price"/></td>
			<td><s:property value="author"/></td>
			<td>
				<a href="bookdel.action?bid=${id}">删除</a>
			</td>
			<td>
				<a href="bookupd.action?bid=${id} ">修改</a>
			</td>
		</tr>
		</s:iterator>
	</table>
	<div align = "center">
				<s:if test="page==1">
					<a class="sel_btn ch_cls" href="BacktoAdmin.action">previous page</a>
				</s:if>
				<s:if test="page!=1">
					<a class="sel_btn ch_cls" href="BacktoAdmin.action?page=${page-1}">previous page</a>
				</s:if>
				
				<s:iterator var="i" begin="1" end="totalPage">
					<s:if test="page==#i">
						${i} 
					</s:if>
					<s:if test="page!=#i">
						<a class="sel_btn" href="BacktoAdmin.action?page=${i }">${i }</a>
					</s:if>
				</s:iterator>
		
				<s:if test="page==totalPage">
					<a class="sel_btn ch_cls" href="BacktoAdmin.action">next page</a>
				</s:if>
				<s:if test="page!=totalPage">
					<a class="sel_btn ch_cls" href="BacktoAdmin.action?page=${page+1}">next page</a>
				</s:if>
			</div>
	<br>
	<br>
	<div align="center">
		<a  href="Addbook.action">
    		<button>增加信息</button></a>
    	<a  href="Rebprint.action">
    		<button>查看还书表</button></a>
	</div>
	<div  align="right" margin-left:80%>
		<a style = "color:white" href="Quit">退出</a>
	</div>
	<jsp:include page ="/DynamicTime.jsp"/>
</body>
</html>