<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
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
	border-bottom:black 1px solid;
}
#createDateBegin_,#createDateEnd_{
	width:173px;
}

</style>
<link rel="stylesheet" href="../css/classic.css">
<script type="text/javascript" src="../js/jquery-1.11.2.js"></script>
<script type="text/javascript" src="../js/jquery.columns.min.js"></script>
<script type="text/javascript">
if (typeof ColumnsPlugins === 'undefined') var ColumnsPlugins = {};
ColumnsPlugins.ajaxpaging = {
    init: function() {
        var $this = this;
        
        /** turning off default functionality */
        $this.conditioning = false;
        $this.paginating = false;
        $this.searching = false;
        $this.sorting = false;

        /** creating default handler */ 
        var handler = function() {
            $.ajax({
                url:"<%=path%>/service/blackgraylist/queryblkgraydetail.action",
                async: false,
                dataType: 'json',
                data: {
                    "page": $this.page,
                    "size": $this.size,
                    "sortBy": $this.sortBy,
                    "reverse": $this.reverse,
                    "query": encodeURI(JSON.stringify($this.query))
                },
                success: function(json) {
                    $this.total = json.total;
                    $this.pages = json.pages;
                    $this.setMaster(json.data);
                    $this.create();
                }
            });
        };

        /** override handlers */ 
        $this.pageHandler = handler;
        $this.sizeHandler = handler;

        /** search handler, sets page to 1 first */ 
        $this.searchHandler = function() {
            $this.page = 1;
            handler();
        };

        /** sort handler, sets page to 1 first */ 
        $this.sortHandler = function() {
            $this.page = 1;
            handler();
        };
    },

    create: function() {
        var $this = this;
        
        /** setting current result range */
        $this.setRange();

        /** setting view variables */
        $this.view.tableTotal = $this.total;
        $this.view.prevPageExists = $this.pageExists($this.page-1);
        $this.view.nextPageExists = $this.pageExists($this.page+1); 
        $this.view.resultRange = $this.range;
    }
};
</script>
<script type="text/javascript">
window.service_domain = "<%=path%>";

function zuofeiHandle(actionType,id){
	var req_url = window.service_domain+'/service/blackgraylist/querydetail.action?id='+id+"&actionType="+actionType;
	$.ajax({
	    url: req_url,
	    dataType: "json",
	    success: function (json) {
	    	alert("作废成功！");
	    	window.location.reload();
	    }
	});
}

function openDetailWindow(actionType,id){
	if("Z"==actionType){
		 var flag =confirm("确认作废么？");
		 if(flag == true)
			 zuofeiHandle(actionType,id);
		 else
			 alert("作废失败！");
	}else{
		window.open(window.service_domain+"/jsp/blkgraydetail.jsp?id="+id+"&actionType="+actionType);
	}
};
var schema = [
               {"header":"名单明细编号", "key":"id"},
               {"header":"报警类别", "key":"warnLevelDesc"},
               {"header":"名单类别名称", "key":"categoryDesc"},
               {"header":"添加人", "key":"createUser"},
               {"header":"添加时间", "key":"createDateDesc"},
               {"header":"姓名", "key":"custName"},
               {"header":"身份证号", "key":"custIdnum"},
               {"header":"手机号码", "key":"custMobile"},
               {"header":"单位名称", "key":"custCorpName"},
               {"header":"状态", "key":"status"},
               {"header":"备注", "key":"memo"},
               {"header":"操作", "key":"id", "template":'<a href="javascript:void(0)" onclick="openDetailWindow(\'Z\',\'{{id}}\')">作废</a> <a target="_blank" href="javascript:void(0)" onclick="openDetailWindow(\'D\',\'{{id}}\')">详细</a>'}
           ];

$(document).ready(function() {
	//$(".ui-table-size>select option[value='10']").attr("selected", true);
});

function doQuery(){
	var warnLevel=$("#warnLevel_").val();
	var categoryName=$("#categoryName_").val();
	var sourceSys=$("#sourceSys_").val();//来源系统
	var sourceChannel_=$("#sourceChannel_").val();//来源渠道
	var name=$("#name").val();//姓名
	var idNum=$("#idNum").val();//身份证号
	var mobile=$("#mobile").val();//手机号码
	var homephone=$("#homephone").val();//住宅电话
	var corpName=$("#corpName").val();//单位名称
	var corpPhone=$("#corpPhone").val();//单位电话
	var corpAddress=$("#corpAddress").val();//单位地址
	var status=$("#status_").val();
	var listId=$("#listId_").val();
	var createDateBegin=$("#createDateBegin_").val();
	var createDateEnd = $("#createDateEnd_").val();
	var condition = {
			  "sourceSys":sourceSys,
			  "sourceChannel":sourceChannel_,
			  "name":name,
			  "idNum":idNum,
			  "mobile":mobile,
			  "homephone":homephone,
			  "corpName":corpName,
			  "corpPhone":corpPhone,
			  "corpAddress":corpAddress,
			  "warnLevel":warnLevel,
			  "categoryName":categoryName,
			  "status":status,
			  "listId":listId,
			  "createDateBegin":createDateBegin,
			  "createDateEnd":createDateEnd
			 };
	var req_url = window.service_domain+'/service/blackgraylist/queryblkgraydetail.action?query='+encodeURI(encodeURI(JSON.stringify(condition)));
	var ui_table_size = $(".ui-table-sortable").size();
	if(ui_table_size>0){
		 $('#columns').columns('destroy');
	}
	//这里我们自己指定了jsonp的callback的名字
	$.ajax({
	    url: req_url,
	    dataType: "json",
	    success: function (json) {
	    	if(json&&json.total>0){
	    		 $('#columns').columns({
		             data:json.data,
		             schema:schema,
		             pages: json.pages,
		             total: json.total,
		             query:JSON.stringify(condition),
		             plugins:['ajaxpaging']
		         });
	    	}else{
	    		alert("未查的数据！");
	    	}
	    }

	});
}

function openFileUploadPage(){
	window.open('../jsp/xlsupload.jsp');
}

function downLoadXlsxTemplet(){
	window.open('../templet/BlkGrayListTemplet.xlsx');
}
</script>
</head>
<body>
	<h3>|黑灰名单明细查询</h3>
      <div id="queryTable">
      	<span class="wth4"><label for="">报警类别</label></span>
        <select id="warnLevel_" onchange="">
        	<option value="">全部</option>
			<option value="0">黑名单</option>
			<option value="1">灰名单</option>
		</select>
        <span class="wth4"><label for="">类别名称</label></span>
        <select id="categoryName_">
        	<option value="">全部</option>
			<option value="fraud_customet_blacklist">欺诈客户黑名单</option>
			<option value="undesirable_customer_blacklist">内部不良客户黑名单</option>
			<option value="peer_blacklist">营业部反馈同行黑名单</option>
			<option value="court_blacklist">人法网失信黑名单</option>
			<option value="network_blacklist">网络客户黑名单</option>
			<option value="rejected_customer_blacklist">内部营业部拒绝黑名单</option>
			<option value="addiction_customer_blacklist">不良嗜好客户黑名单</option>
			<option value="against_customer_blacklist">家人反对贷款客户黑名单</option>
			<option value="maliciousclaim_customer_blacklist">恶意投诉客户黑名单</option>
			<option value="undesirable_company_blacklist">不良单位黑名单</option>
			<option value="closedown_company_blacklist">倒闭工厂黑名单</option>
			<option value="focus_phone_blacklist">关注电话黑名单</option>
			<option value="staff_blacklist">内部员工黑名单</option>
			<option value="out_credit_blacklist">外部征信黑名单</option>
			<option value="A_fraud_customer_graylist">疑似欺诈客户灰名单A</option>
			<option value="B_fraud_customer_graylist">疑似欺诈客户灰名单B</option>
			<option value="C_fraud_customet_graylist">疑似欺诈客户灰名单C</option>
			<option value="D_fraud_customet_graylist">疑似欺诈客户灰名单D</option>
			<option value="disclosure_customer_graylist">身份泄露客户灰名单</option>
			<option value="peer_graylist">营业部同业灰名单</option>
			<option value="phone_graylist">关注电话黑名单超时转灰</option>
			<option value="salemen_graylist">违规销售人员进件客户灰名单</option>
		</select>
		<span class="wth4"><label for="">来源渠道</label></span>
       	<select id="sourceChannel_">
       		<option value="">全部</option>
			<option value="0">征信系统</option>
		</select>
        <span class="wth4"><label for="">来源系统</label>
	        <select id="sourceSys_" onchange="">
	       		<option value="">全部</option>
				<option value="0">征信系统</option>
				<option value="1">小贷系统</option>
				<option value="2">账务系统</option>
				<option value="3">平安前海</option>
			</select>
		</span>
		</br>
        <span class="wth2">
        	<label for="">状态</label></span>
	        <select id="status_" onchange="">
	        		<option value="">全部</option>
					<option value="0">正常</option>
					<option value="1">已作废</option>
			</select>
		<span class="wth2"><label for="">姓名</label></span>
        <input id ="name" type="text" value="" />
        <span class="wth4"><label for="">身份证号</label></span>
        <input id ="idNum" type="text" value="" />
        <span class="wth4"><label for="">手机号码</label></span>
        <input id ="mobile" type="text" value="" />
        </br>
        <span class="wth4"><label for="">住宅电话</label></span>
        <input id ="homephone" type="text" value="" />
        <span class="wth4"><label for="">单位名称</label></span>
        <input id ="corpName" type="text" value="" />
        <span class="wth4"><label for="">单位电话</label></span>
        <input id ="corpPhone" type="text" value="" />
        <span class="wth4"><label for="">单位地址</label></span>
        <input id ="corpAddress" type="text" value="" />
        </br>
		<span class="wth6"><label for="">名单明细编号</label></span>
        <input id ="listId_" type="text" value="" />
        <span class="wth4"><label for="">添加时间</label></span>
        <input id="createDateBegin_" class="laydate-icon" type="text" value="" />-<input id="createDateEnd_" class="laydate-icon" type="text" value="" />
        <input type="button" value="查询" onClick="doQuery()"/>
        <input type="button" value="下载导入模板" onClick="downLoadXlsxTemplet()"/>
        <input type="button" value="导入新名单" onClick="openFileUploadPage()"/>
        <label for="">
        <div id="quertTip">
       		</br><b>仅允许检索以下信息：</b></br>
			<b>身份证号、姓名、手机号码、住宅电话、住宅地址、单位名称、单位电话、单位地址</b>
			</label>
        </div>
      </div>
	<div id="columns"></div>
</body>
 <script type="text/javascript" src="../js/laydate.js"></script>
 <script type="text/javascript">
 laydate({
     elem: '#createDateBegin_',
     istime: true,
     format:'YYYYMMDDhhmmss',
     festival: true 
 });
 laydate({
     elem: '#createDateEnd_',
     istime: true,
     format:'YYYYMMDDhhmmss',
     festival: true 
 });
 </script>
</html>