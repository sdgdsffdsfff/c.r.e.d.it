<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<% 
String path = request.getContextPath();
String id = request.getParameter("id");//用request得到 
String actionType = request.getParameter("actionType");//用request得到 
%> 
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>黑灰名单明细页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
<style type="text/css">
body{
	font-family:微软雅黑;
}
span{
	margin-top:3px;
}
input{
	font-size:14px;
	font-weight:900";
	font-family:微软雅黑;
}
.listNO{
	width:80%;
	font-size:15px;
	font-weight:900;
	border-bottom:black 1px solid;
	padding-bottom:5px;
	margin-bottom:5px;
}
.dataRow{
	margin-bottom:7px;
}
.spwith2{
	margin-left:65px;
}
.spwith3{
	margin-left:48px;
}
.spwith4{
	margin-left:32px;
}
.spwith5{
	margin-left:16px;
}
.spwithx{
	margin-left:39px;
}
.spwithx1{
	margin-left:30px;
}
</style>
<link rel="stylesheet" href="../css/classic.css">
<script type="text/javascript" src="../js/jquery-1.11.2.js"></script>
<script type="text/javascript">
window.service_domain = "<%=path%>";
$(document).ready(function() {
	var id = '<%=id%>';
	var actionType = '<%=actionType%>';
	var req_url = window.service_domain+'/service/blackgraylist/querydetail.action?id='+id+"&actionType="+actionType;
	$.ajax({
	    url: req_url,
	    dataType: "json",
	    id:id,
	    success: function (json) {
	    	for(var x in json){
	    		var ob = $("#"+x);
	    		if(ob){
	    			ob.val(json[x]);
	    		}
	    	}
	    }
	});
});
</script>
</head>
<body>
		<h3>|黑灰名单明细</h3>
		<div class="listNO">
			<span>名单编号：<%=id%></span>
		</div>
	<div class="dataRow">
		<span class="spwith4"><label for="">申请编号</label><input id = "applyNo" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">名单类型</label><input id = "categoryDesc" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">证件号码</label><input id = "custIdnum" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">手机号码</label><input id = "custMobile" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwith5"><label for="">住宅所在省</label><input id = "custHomeProvince" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith5"><label for="">住宅所在市</label><input id = "custHomeCity" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith5"><label for="">住宅所在区</label><input id = "custHomeDistrict" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">住宅地址</label><input id = "custHomeAddress" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwith4"><label for="">住宅电话</label><input id = "custHomePhone" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">单位名称</label><input id = "custCorpName" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">单位电话</label><input id = "custCorpPhone" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">单位地址</label><input id = "custCorpAddress" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwith6"><label for="">销售人员姓名</label><input id = "salepersonName" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith2"><label for="">备注</label><input id = "memo" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx"><label for="">信息项1</label><input id = "extInfo1" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx"><label for="">信息项2</label><input id = "extInfo2" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwithx"><label for="">信息项3</label><input id = "extInfo3" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx"><label for="">信息项4</label><input id = "extInfo4" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx"><label for="">信息项5</label><input id = "extInfo5" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx"><label for="">信息项6</label><input id = "extInfo6" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwithx"><label for="">信息项7</label><input id = "extInfo7" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx"><label for="">信息项8</label><input id = "extInfo8" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx"><label for="">信息项9</label><input id = "extInfo9" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项10</label><input id = "extInfo10" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwithx1"><label for="">信息项11</label><input id = "extInfo11" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项12</label><input id = "extInfo12" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项13</label><input id = "extInfo13" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项14</label><input id = "extInfo14" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwithx1"><label for="">信息项15</label><input id = "extInfo15" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项16</label><input id = "extInfo16" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项17</label><input id = "extInfo17" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项18</label><input id = "extInfo18" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwithx1"><label for="">信息项19</label><input id = "extInfo19" type="text" value="" readOnly="readonly"/></span>
		<span class="spwithx1"><label for="">信息项20</label><input id = "extInfo20" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">来源渠道</label><input id = "channelDesc" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">来源系统</label><input id = "sourceSysDesc" type="text" value="" readOnly="readonly"/></span>
	</div>
	<div class="dataRow">
		<span class="spwith3"><label for="">创建人</label><input id = "createUser" type="text" value="" readOnly="readonly"/></span>
		<span class="spwith4"><label for="">创建日期</label><input id = "createDate" type="text" value="" readOnly="readonly"/></span>
	</div>
</body>
</html>