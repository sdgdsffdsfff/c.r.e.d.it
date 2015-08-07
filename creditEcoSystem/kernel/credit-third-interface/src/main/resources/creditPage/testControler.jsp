<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>My JSP 'hello.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
</head>
<body>
	<h1>Spring restful Test!</h1>
	<button onclick="testPyservice()">测试</button>
	
	<script type="text/javascript">
	function testPyservice(){
		var url = "service/py";
		var condition = {
			category:"A",
			name:"jack",
			idCard:"47823479",
			tel:"1347890000",
			memo:"cesghi"
		};
		$.ajax({
			  type: 'POST',
			  url: url,
			  data:JSON.stringify(condition),
			  success: function(data){
				  alert(data);
				  debugger;
			  },
			  contentType: 'application/json', 
			  dataType:'json'
			});
	}
	</script>
</body>
</html>