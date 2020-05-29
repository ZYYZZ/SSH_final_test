<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<div id="time1" style="top:0;right:0px;position:absolute;color:#484891;">
		<script type="text/javascript">
		//非动态显示
		//document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
		//动态显示
		setInterval("document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());",1000);
	</script>
</div>