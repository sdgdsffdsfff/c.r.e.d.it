var contactorsCnt=0;
var contactors = [];
/**
 * [addContact 添加联系人]
 */
function addContact () {
    contactorsCnt++;
    var id = "_contact_"+contactorsCnt;
    contactors.push(id);
    $("#tableContact").append("<tr id='"+id+"'><td><input type=\"text\" value=\"\"></td><td><select class=\"form-control\"><option value=\"1\">父母</option><option value=\"2\">子女</option><option value=\"3\">工作证明人</option><option value=\"4\">其他亲属联系人</option><option value=\"9\">其他联系人</option></select></td><td><input type=\"text\" value=\"\"></td><td><input type=\"text\" value=\"\"></td><td><input type=\"text\" value=\"\"></td><td><input type=\"text\" value=\"\"></td><td><input type=\"text\" value=\"\"></td></tr>");
}
/**
 * [removeContact 删除联系人]
 * @return {[type]} [删除联系人]
 */
function removeContact(){
    var contactid = contactors.pop();
    $("#"+contactid).remove();
}
/**
 * [addRuleResult 添加规则结果]
 */
function addRuleResult (hitRules) {
    var cnt = 1;
    var ruleResults =[];
    for (var i = 0; i < hitRules.length; i++) {
        var ruleType = hitRules[i].ruleType;
        if("0"==ruleType){
        	var ruleResult = [];
            ruleResult.push(cnt);
            ruleResult.push(hitRules[i].ruleId);
            ruleResult.push(hitRules[i].ruleDesc);
            ruleResult.push("无");
            ruleResult.push("无");
            cnt++;
            ruleResults.push(ruleResult);
        }else if("1"==ruleType){
            var hitHist =  hitRules[i].hitHist;
            for (var j = 0; j < hitHist.length; j++) {
            	var ruleResult = [];
                ruleResult.push(cnt);
                ruleResult.push(hitRules[i].ruleId);
                ruleResult.push(hitRules[i].ruleDesc);
                var sourceSys = hitHist[j].sourceSys;
                sourceSys = sourceSys=="01"?"信贷系统":sourceSys=="02"?"车贷系统":sourceSys=="03"?"消金":"其他系统";
                ruleResult.push(sourceSys);
                ruleResult.push(hitHist[j].applyCode);
                cnt++;
                ruleResults.push(ruleResult);
            };
        }else{
        	 var hitHist =  hitRules[i].hitHist;
             for (var j = 0; j < hitHist.length; j++) {
            	 var ruleResult = [];
                 ruleResult.push(cnt);
                 ruleResult.push(hitRules[i].ruleId);
                 ruleResult.push(hitRules[i].ruleDesc);
                 var sourceSys = hitHist[j].sourceSys;
                 sourceSys = sourceSys=="01"?"信贷系统":sourceSys=="02"?"车贷系统":sourceSys=="03"?"消金":"其他系统";
                 ruleResult.push(sourceSys);
                 ruleResult.push(hitHist[j].applyCode);
                 cnt++;
                 ruleResults.push(ruleResult);
             };
        }
    };
    for (var i = 0; i < ruleResults.length; i++) {
        var ruleResult = ruleResults[i];
        $("#tableRuleResult").append("<tr><td>"+ruleResult[0]+"</td><td>"+ruleResult[1]+"</td><td>"+ruleResult[2]+"</td><td>"+ruleResult[3]+"</td><td>"+ruleResult[4]+"</td></tr>");
    };
}

function transLateAddress(address){
    if("省份"==address||"地级市"==address||"市、县、区"==address){
        return "";
    }
    return address;
}
function executeRule () {
    var param={
        "applyCode": "",
        "sourceSys": "",
        "queryType": "0",
        "customerInfo":{},
        "contactsInfo": []
        };
    //来源系统
    var sourceSys = $("#sourceSys").val();
    //申请单号
    var applyCode = $("#applyCode").val(); 
    //借款人姓名
    var name = $("#name").val();
    var idcard = $("#idcard").val();
    if (!sourceSys) {
        alert("业务系统不能为空！");
        return;
    };
    if (!applyCode) {
        alert("申请单号不能为空！");
        return;
    };
    if (!name) {
        alert("借款人姓名不能为空！");
        return;
    };
    if (!idcard) {
        alert("证件号码不能为空！");
        return;
    };
    // 借款产品
    var productCode = $("#productCode").val();
    // 申请日期
    var applyDate = $("#applyDate").val();
    // 可认定工资
    var approveIncome = $("#approveIncome").val();
    // 电子邮箱
    var email = $("#email").val();
    //家庭电话
    var homePhone = $("#homePhone").val();
    // 住宅地址
    var homepro = transLateAddress($("#province_").select2('data').text);
    var homeCity = transLateAddress($("#city_").select2('data').text);
    var homeDist = transLateAddress($("#country_").select2('data').text);
    var homeAddress = $("#homeAddress").val();
    // 房产地址
    var housingProvince = transLateAddress($("#housingProvince").select2('data').text);
    var housingCity = transLateAddress($("#housingCity").select2('data').text);
    var housingDist = transLateAddress($("#housingDist").select2('data').text);
    var housingAddress = $("#housingAddress").val();
    // 申请人手机号
    var mobile = $("#mobile").val();
    // 单位名称
    var companyName = $("#companyName").val();
    // 入职年份
    var inWorkTime = $("#inWorkTime").val();
    // 单位电话
    var companyPhone = $("#companyPhone").val();
    // 单位地址
    var companyProvince = transLateAddress($("#companyProvince").select2('data').text);
    var companyCity = transLateAddress($("#companyCity").select2('data').text);
    var companyDist = transLateAddress($("#companyDist").select2('data').text);
    var companyAddress = $("#companyAddress").val();
    //add later
    // 出生日期
    var birthday = $("#birthday").val();
    // 工作部门
    var department = $("#department").val();
    // 配偶姓名
    var spouseName = $("#spouseName").val();
    // 配偶证件号码
    var spouseIdNo = $("#spouseIdNo").val();    
    // 配偶单位名称
    var spouseCompany = $("#spouseCompany").val();    
    // 配偶手机号码
    var spouseMobile = $("#spouseMobile").val();

    param.applyCode=applyCode;
    param.sourceSys=sourceSys;
    customerInfo={
        "curWorkStartyear": "",
        "companyIndustry": "",
        "spouseIdno": "",
        "companyAddrCity": "",
        "businessSubType": "",
        "housingAddrDistrict": "",
        "idtype": "",
        "companyPhone": "",
        "censusAddrProvince": "",
        "profession": "",
        "approveIncome": 0,
        "homePhone": "",
        "applyProductCode": "",
        "homeAddrCity": "",
        "lendingAmount": 0,
        "companyAddrProvince": "",
        "loanApplyMonths": 0,
        "residenceStatus": "",
        "applyChannel": "",
        "emailAddress": "",
        "idcard": "",
        "businessType": "",
        "homePostcode": "",
        "occurPlace": "",
        "companyName": "",
        "currentBusinessType": "",
        "housingAddresss": "",
        "spouseName": "",
        "applyDate": "",
        "applySubchannel": "",
        "createUser": "",
        "departmentCity": "",
        "yearlyIncome": 0,
        "spouseIdtype": "",
        "vinCode": "",
        "approvedProductCode": "",
        "updateUser": "",
        "mobile": "",
        "housingAddrProvince": "",
        "housingPostcode": "",
        "highestDiploma": 0,
        "birthday": "",
        "sex": 0,
        "department": "",
        "salesmanName": "",
        "sourceSys": "",
        "companyAddrDistrict": "",
        "maritalStatus": 0,
        "loanApplyAmount": 0,
        "censusAddresss": "",
        "id": "",
        "spouseMobile": "",
        "spouseCompany": "",
        "name": "",
        "professionalTitle": 0,
        "censusAddrCity": "",
        "createDate": "",
        "carPrice": 0,
        "homeAddrDistrict": "",
        "vehicleNo": "",
        "post": 0,
        "updateDate": "",
        "repaymentBankAccount": "",
        "companyAddresss": "",
        "housingAddrCity": "",
        "engineNo": "",
        "highestEducation": 0,
        "censusAddrDistrict": "",
        "mobile1": "",
        "applyCode": "",
        "refusedCode3": "",
        "companyPostcode": "",
        "refusedCode4": "",
        "homeAddresss": "",
        "refusedCode1": "",
        "refusedCode2": "",
        "homeAddrProvince": ""
    };
    customerInfo.sourceSys=sourceSys;
    customerInfo.applyCode=applyCode;
    customerInfo.applyDate=dateFormat(applyDate);
    customerInfo.applyProductCode=productCode;
    customerInfo.approveIncome=approveIncome;
    customerInfo.companyName=companyName;
    customerInfo.emailAddress=email;
    customerInfo.mobile=mobile;
    customerInfo.name=name;
    customerInfo.idcard=idcard;
    customerInfo.homePhone=homePhone;
    customerInfo.companyPhone=companyPhone;
    customerInfo.companyAddrProvince=companyProvince;
    customerInfo.companyAddrCity=companyCity;
    customerInfo.companyAddrDistrict=companyDist;
    customerInfo.companyAddresss=companyAddress;
    customerInfo.curWorkStartyear=dateFormat(inWorkTime);
    customerInfo.homeAddrProvince=homepro;
    customerInfo.homeAddrCity=homeCity;
    customerInfo.homeAddrDistrict=homeDist;
    customerInfo.homeAddresss=homeAddress;
    customerInfo.housingProvince=housingProvince;
    customerInfo.housingAddrCity=housingCity;
    customerInfo.housingAddrDistrict=housingDist;
    customerInfo.housingAddresss=housingAddress;
    //add
    customerInfo.department = department;
    customerInfo.birthday=dateFormat(birthday);
    customerInfo.spouseName=spouseName;
    customerInfo.spouseIdno=spouseIdNo;
    customerInfo.spouseCompany=spouseCompany;
    customerInfo.spouseMobile=spouseMobile;

    var contactsInfos = getTableJson($("#dataTable"),["name","relation","mobile","idcard","companyName","department","companyPhone"]);
    var contacts = [];
    for (var i = 0; i < contactsInfos.length; i++) {
       var contactor = {};
        contactor.name=contactsInfos[i].name;
        contactor.relation=contactsInfos[i].relation;
        contactor.mobile=contactsInfos[i].mobile;
        contactor.companyName=contactsInfos[i].companyName;
        contactor.department=contactsInfos[i].department;
        contactor.companyPhone=contactsInfos[i].companyPhone;
        contacts.push(contactor);
    };
    param.contactsInfo=contacts;
    param.customerInfo=customerInfo;
    var jsonstr = JSON.stringify(param);
    $.ajax({
      type: 'POST',
      url: "service/antifraud/queryantifraud.action",
      data:jsonstr,
      success: function(data){
    	$("#tableRuleResult").empty();
        console.info(data);
        if ("0"==data.resultStatus) {
            alert("当前件没有命中规则！");
        }else{
            addRuleResult(data.hitRules);
        }
      },
      contentType: 'application/json', 
      dataType:'json'
    }); 
}

/**
 * [clearApplyCode 清除申请单号]
 * @return {[type]} [清除申请单号]
 */
function clearApplyCode () {
    $(".applyCode__").attr("disabled",false); 
    $(".applyCode__").val("");
    $(".applyCode1__").text("");
}

/**
 * [setApplyCode 设置只读并生成单号]
 */
function setApplyCode () {
    $(".applyCode__").attr("disabled",true); 
    var applyCode = genApplyCode();
    $(".applyCode__").val(applyCode);
    $(".applyCode1__").text(applyCode);
}
/**
 * [setHousingAddress 设置房产地址]
 */
function setHousingAddress () {
    var homepro = $("#province_").val();
    var homeCity = $("#city_").val();
    var homeDist = $("#country_").val();
    var homeAddress = $("#homeAddress").val();
    $("#housingProvince").val(homepro);
    $("#housingProvince").change();
    $("#housingCity").val(homeCity);
    $("#housingCity").change();
    $("#housingDist").val(homeDist);
    $("#housingDist").change();
    $("#housingAddress").val(homeAddress);
}

/**
 * [clearHousingAddress 清空房产地址]
 * @return {[type]} [清空房产地址]
 */
function clearHousingAddress () {
	$("#housingProvince").val("");
    $("#housingProvince").change();
    $("#housingCity").val("0");
    $("#housingCity").change();
    $("#housingDist").val("0");
    $("#housingDist").change();
    $("#housingAddress").val("");
}

// Run timepicker
function DemoTimePicker(){
    $('#input_time').timepicker({setDate: new Date()});
}
/**
 * [genApplyCode 生成测试申请单号]
 * @return {[type]} [生成测试申请单号]
 */
function genApplyCode(){
    var uuid = new UUID();
    var applyCode ="TPA-"+uuid;
    return applyCode;
}
function dateFormat (dateStr) {
    if (!dateStr) {
        return "";  
    };
    var date = new Date(dateStr);
    var da = date.format("yyyy-MM-dd hh:mm:ss");
    return da;
}
/**
 * [initAddresses 初始各个化省市区]
 * @param  {[type]} argument [初始各个化省市区]
 * @return {[type]}          [初始各个化省市区]
 */
function initAddresses () {
    //住宅地址
    initLocation("#province_","#city_","#country_");
    //房产地址
    initLocation("#housingProvince","#housingCity","#housingDist");
    //单位地址
    initLocation("#companyProvince","#companyCity","#companyDist");
}
function initDateItems(){
    $('.datepicker').datepicker(dateConfig);
}

$(document).ready(function() {
    initAddresses();
    setApplyCode();
    $("#applyCode").bind("blur",function(){
        var appNo = $("#applyCode").val();
        $(".applyCode1__").text(appNo);
    });
    initDateItems();
    // Create Wysiwig editor for textare
    TinyMCEStart('#wysiwig_simple', null);
    TinyMCEStart('#wysiwig_full', 'extreme');
    // Add slider for change test input length
    FormLayoutExampleInputLength($( ".slider-style" ));
    // Initialize datepicker
    // $('#applyDate').datepicker({setDate: new Date()});
    // Load Timepicker plugin
//    LoadTimePickerScript(DemoTimePicker);
    // Add tooltip to form-controls
    $('.form-control').tooltip();
    // Load example of form validation
    LoadBootstrapValidatorScript(DemoFormValidator);
    // Add drag-n-drop feature to boxes
    // WinMove();
});
$.datepicker.setDefaults($.datepicker.regional['zh-CN']);
var dateConfig={//添加日期选择功能 
            yearRange:"1900:2050",
            changeMonth: true,
            changeYear: true,
            numberOfMonths:1,//显示几个月  
            showButtonPanel:true,//是否显示按钮面板  
            dateFormat: 'yy/mm/dd',//日期格式  
            showHour:true,
            showMinute:true,
            showSecond:true,
            clearText:"清除",//清除日期的按钮名称  
            closeText:"关闭",//关闭选择框的按钮名称  
            yearSuffix: '年', //年的后缀  
            prevText: "上月",
            nextText: "下月",
            currentText: "今天",
            buttonText:'选择日期',
            showButtonPanel: true,
            showOtherMonths: true,
            // showMonthAfterYear:true,//是否把月放在年的后面  
            defaultDate:new Date(),//默认日期  
            // minDate:'1900-01-01',//最小日期  
            // maxDate:'9999-12-12',//最大日期  
            monthNames: ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],  
            monthNamesShort:['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'],
            dayNames: ['星期日','星期一','星期二','星期三','星期四','星期五','星期六'],  
            dayNamesShort: ['周日','周一','周二','周三','周四','周五','周六'],  
            dayNamesMin: ['日','一','二','三','四','五','六']  
            // onSelect: function(selectedDate) {//选择日期后执行的操作  
            //     // alert(selectedDate);  
            // }  
};

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
