<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>黑灰名单文件上传页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
<style type="text/css">
div{
margin:10px;
font-family:Consolas;
}
</style>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery-1.11.2.js"></script>
</head>
<script type="text/javascript">
	window.$_domain_="<%=path%>";
	function doFileUpload(){
		$("#div_process").html("正在上传文件，并创建索引...");
		$("#mainForm").submit();
	}
</script>
<body>
	<h3>黑灰名单文件上传</h3>
	<form id="mainForm" action="<%=path%>/service/blackgraylist/xlsfileupload.action" method="post" enctype="multipart/form-data">
	<input type="file" name="file" size="50" />
	<br/>
	<br/>
	<input type="button" value="上传文件" onclick="doFileUpload()">
	</form>
	<div id="div_process"></div>
	<div id="div_result"></div>
</body>
</html>