<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>黑灰名单查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
<style type="text/css">
body{
	font-family:微软雅黑;
}
h3{
	margin-left:28px;
}
select{
	width:173px;
}
.wth2{
	margin-left:60px;
}
.wth4{
	margin-left:30px;
}
.wth6{
margin-left:0px;
}
.ui-columns-search{
	display:none;
}
#queryTable{
	font-family:微软雅黑;
	font-size:15px;
}
#quertTip{
	font-size:12px;	
}
</style>
<link rel="stylesheet" href="../css/classic.css">
<script type="text/javascript" src="../js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="../js/jquery.columns.min.js"></script>
<script type="text/javascript" src="../js/ajaxpaging.js"></script>
<script type="text/javascript">
window.service_domain = "http://localhost:8080/credit-third-interface/";
function openDetailWindow(actionType,id){
	if("Z"==actionType){
		var req_url = window.service_domain+'service/blackgraylist/querydetail.action?id='+id+"&actionType="+actionType;
		$.ajax({
			type: 'POST',
		    url: req_url,
		    dataType: "jsonp",
		    success: function (json) {
		    	alert("作废成功！");
		    	window.location.reload();
		    }
		});
	}else{
		window.open("../jsp/blkgraydetail.jsp?id="+id+"&actionType="+actionType);
	}
};
var schema = [
               {"header":"名单明细编号", "key":"id"},
               {"header":"报警类别", "key":"warnLevel"},
               {"header":"名单类别名称", "key":"categoryDesc"},
               {"header":"添加人", "key":"createUser"},
               {"header":"添加时间", "key":"createDate"},
               {"header":"姓名", "key":"custName"},
               {"header":"身份证号", "key":"custIdnum"},
               {"header":"手机号码", "key":"custMobile"},
               {"header":"单位名称", "key":"custCorpName"},
               {"header":"状态", "key":"enable"},
               {"header":"备注", "key":"memo"},
               {"header":"操作", "key":"id", "template":'<a href="javascript:void(0)" onclick="openDetailWindow(\'Z\',\'{{id}}\')">作废</a> <a target="_blank" href="javascript:void(0)" onclick="openDetailWindow(\'D\',\'{{id}}\')">详细</a>'}
           ];

$(document).ready(function() {
	//$(".ui-table-size>select option[value='10']").attr("selected", true);
});

function doQuery(){
	var warnLevel=$("#warnLevel_").val();
	var categoryName=$("#categoryName_").val();
	var sourceSys=$("#sourceSys_").val();
	var status=$("#status_").val();
	var listId=$("#listId_").val();
	var createDateBegin=$("#createDateBegin_").val();
	var createDateEnd = $("#createDateEnd_").val();
	var condition = {
			  "queryType":warnLevel,
			  "querySource":categoryName,
			  "querySource":status,
			  "querySource":listId,
			  "querySource":createDateBegin,
			  "querySource":createDateEnd
			 };
	var req_url = window.service_domain+'service/blackgraylist/queryblkgraydetail.action';
	//这里我们自己指定了jsonp的callback的名字
	$.ajax({
	    url: req_url,
	    dataType: "jsonp",
	    success: function (json) {
	    	 $('#columns').columns({
	             data:json.data,
	             schema:schema,
	             pages: json.pages,
	             total: json.total,
	             query:condition,
	             plugins:['ajaxpaging']
	         }); 
	    }

	});
}
</script>
</head>
<body>
	<h3>|黑灰名单明细查询</h3>
      <div id="queryTable">
      	<span class="wth4"><label for="">报警类别</label></span>
        <select id="warnLevel" onchange="">
			<option value="0">黑名单</option>
			<option value="1">灰名单</option>
		</select>
        <span class="wth4"><label for="">类别名称</label></span>
        <select id="queryType" onchange="changeHandle(this.value)">
			<option value="PY90035">电话正查</option>
			<option value="PY21603">电话反查</option>
			<option value="PY21303">法人核查</option>
		</select>
		<br/>
        <span class="wth4">
	        <label for="">来源系统</label>
	        <select id="sourceSys" onchange="">
				<option value="0">征信系统</option>
				<!-- <option value="1">小贷系统</option>
				<option value="2">账务系统</option> -->
			</select>
		</span>
        <span class="wth2">
        	<label for="">状态</label></span>
	        <select id="status" onchange="">
					<option value="0">正常</option>
					<option value="1">已作废</option>
			</select>
        </br>
		<span class="wth6"><label for="">名单明细编号</label></span>
        <input type="text" value="" />
        <span class="wth4"><label for="">添加时间</label></span>
        <input type="text" value="" />-<input type="text" value="" />
        <input type="button" value="查询" onClick="doQuery()"/>
        <label for="">
        <div id="quertTip">
       		</br><b>仅允许检索以下信息：</b></br>
			<b>身份证号、姓名、手机号码、住宅电话、住宅地址、单位名称、单位电话、单位地址</b>
			</label>
        </div>
      </div>
	<div id="columns"></div>
</body>
</html>