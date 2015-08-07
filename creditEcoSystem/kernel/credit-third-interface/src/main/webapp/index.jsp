<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>
	">
	<title>My JSP 'hello.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<script type="text/javascript" src="js/jquery-1.11.2.js"></script>
	<script type="text/javascript">
	// 对Date的扩展，将 Date 转化为指定格式的String 
	// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
	// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
	// 例子： 
	// (new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
	// (new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
	Date.prototype.format = function(fmt) { //author: meizz 
	  var o = { 
	    "M+" : this.getMonth()+1,                 //月份 
	    "d+" : this.getDate(),                    //日 
	    "h+" : this.getHours(),                   //小时 
	    "m+" : this.getMinutes(),                 //分 
	    "s+" : this.getSeconds(),                 //秒 
	    "q+" : Math.floor((this.getMonth()+3)/3), //季度 
	    "S"  : this.getMilliseconds()             //毫秒 
	  }; 
	  if(/(y+)/.test(fmt)) 
	    fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	  for(var k in o) 
	    if(new RegExp("("+ k +")").test(fmt)) 
	  fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
	  return fmt; 
	};
</script>
<style type="text/css">
div{
margin:10px;
font-family:Consolas;
}
</style>
</head>
<body>
	<h1>鹏元 接口测试页面</h1>
	<script type="text/javascript">
	window.url = "service/py/queryCorpTelInfos.action";
	$(document).ready(function(){
		$(".PY21603").hide();
		$(".PY21303").hide();
		});
	function testPyservice(){
		var queryType=$("#queryType").val();
		var querySource=$("#querySource").val();
		var corpName=$("#corpName").val();
		var telephone=$("#telephone").val();
		var personName=$("#personName").val();
		var idNumber=$("#idNumber").val();
		var randomCode = new Date().format("yyyyMMddhhmmss");
		var pre = "PyTst";
		$("#randomCode").val(pre+randomCode);
		var condition = {
				  "queryType":queryType,
				  "querySource":querySource,
				  "queryParas":{
					  "applyNo":pre+randomCode,
					  "sendCode":pre+randomCode
				  }
				 };
		if("PY90035"==queryType){
			if(!corpName){
				alert("请输入公司名称！");
				return;
			}
			condition.queryParas.corpName = corpName;
		}else if("PY21603"==queryType){
			if(!telephone){
				alert("请输入电话号码！");
				return;
			}
			condition.queryParas.telephone = telephone;
		}else if("PY21303"==queryType){
			if(!personName){
				alert("请输入姓名！");
				return;
			}
			if(!idNumber){
				alert("请输入证件号码！");
				return;
			}
			condition.queryParas.idType = "1";
			condition.queryParas.personName = personName;
			condition.queryParas.idNumber = idNumber;
		}
		var jsonstr = JSON.stringify(condition);
		$("#queryJsonStr").text(jsonstr);
	}
	
	function doRequest(){
		var queryType=$("#queryType").val();
		var querySource=$("#querySource").val();
		var corpName=$("#corpName").val();
		var telephone=$("#telephone").val();
		var personName=$("#personName").val();
		var idNumber=$("#idNumber").val();
		var randomCode = $("#randomCode").val();
		var condition = {
				  "queryType":queryType,
				  "querySource":querySource,
				  "queryParas":{
					  "applyNo":randomCode,
					  "sendCode":randomCode
				  }
				 };
		if("PY90035"==queryType){
			condition.queryParas.corpName = corpName;
		}else if("PY21603"==queryType){
			condition.queryParas.telephone = telephone;
		}else if("PY21303"==queryType){
			condition.queryParas.idType = "1";
			condition.queryParas.personName = personName;
			condition.queryParas.idNumber = idNumber;
		}
		var jsonstr = JSON.stringify(condition);
 		$.ajax({
		  type: 'POST',
		  url: window.url,
		  data:jsonstr,
		  success: function(data){
			  $("#resultJsonStr").text(JSON.stringify(data));
		  },
		  contentType: 'application/json', 
		  dataType:'json'
		});   
	}
	function changeHandle(queryType){
		if("PY90035"==queryType){
			$(".PY90035").show();
			$(".PY21603").hide();
			$(".PY21303").hide();
		}else if("PY21603"==queryType){
			$(".PY21603").show();
			$(".PY90035").hide();
			$(".PY21303").hide();
		}else if("PY21303"==queryType){
			window.url = "service/py/queryArtificialPersonInfos.action";
			$(".PY21303").show();
			$(".PY90035").hide();
			$(".PY21603").hide();
		}
	}
	</script>
	<div>
		<select id="queryType" onchange="changeHandle(this.value)">
			<option value="PY90035">电话正查</option>
			<option value="PY21603">电话反查</option>
			<option value="PY21303">法人核查</option>
		</select>
		<select id="querySource">
			<option value="SRC1">小贷</option>
			<option value="SRC2">账务</option>
			<option value="SRC3">其他</option>
		</select>
	</div>
	<div>
		<label for="" class="comwth">Random uuid</label>
		<input id="randomCode" type="text" alt="" class="comwth" readonly="true" />
	</div>
	<div class="PY90035">
		<label for="" class="comwth">公司名称</label>
		<input id="corpName" type="text" alt="" class="comwth"/>
	</div>
	<div class="PY21603">
		<label for="" class="comwth">电话号码</label>
		<input id="telephone" type="text" alt="" class="comwth"/>
	</div>
	<div class="PY21303">
		<label for="" class="comwth">姓名</label>
		<input id="personName" type="text" alt="" class="comwth"/>
		<label for="" class="comwth">证件号码</label>
		<input id="idNumber" type="text" alt="" class="comwth"/>
	</div>
	<div>
		<label for="" class="comwth">请求Json 字符串</label>
		</br>
		<textarea id="queryJsonStr" class="comwth" cols="80" rows="20">
		</textarea>
		<textarea id="resultJsonStr" class="comwth" cols="80" rows="20">
		</textarea>
	</div>
	<button onclick="testPyservice()">生成请求Json</button>
	<button onclick="doRequest()">发送请求</button>
</body>

</html>