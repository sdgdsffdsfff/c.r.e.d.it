/**
 * 
 */
package com.ctc.credit.bairong.controller;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bfd.facade.Apply_source;
import com.bfd.facade.Biz_industry;
import com.bfd.facade.Biz_positon;
import com.bfd.facade.Biz_type;
import com.bfd.facade.Educationallevel;
import com.bfd.facade.House_type;
import com.bfd.facade.Marriage;
import com.ctc.credit.bairong.api.dto.HandleBrRequest;
import com.ctc.credit.bairong.constant.ConfigsContant;
import com.ctc.credit.bairong.service.BaiRongConsumerService;

/**
 * @author Chengang
 * 2015年7月31日 上午11:00:03 
 */
@Controller
@RequestMapping(value = "/service/br")
public class BrServiceController {
	
	@Resource
	BaiRongConsumerService baiRongConsumerService;
	
	/**
	 * 获取百融接口征信报告数据测试方法
	 * @author Chengang
	 * @return
	 */
	@RequestMapping(value = "/getUserQuery.action", method = RequestMethod.GET)
	public @ResponseBody String getUserQuery(){
		HandleBrRequest handleBrRequest = new HandleBrRequest();
		handleBrRequest.setMerchantName(ConfigsContant.NAME);
		handleBrRequest.setMerchantPwd(ConfigsContant.PASSWORD);
		handleBrRequest.setGid("00720070004d008f00000000000003bd53196a1d");
		handleBrRequest.setMail("402182229@qq.com");
		handleBrRequest.setIdCardNo("370102471212003");
		handleBrRequest.setCell("13400002049");
		handleBrRequest.setAppVisitNum(121);
		handleBrRequest.setHomeAddr("北京市石景山区");
		handleBrRequest.setTelBiz("0833-2601698");
		handleBrRequest.setTelHome("0757-81431665");
		handleBrRequest.setHomeAddr("广东省佛山市南海区罗村街道北湖一路4号时代倾城54栋604房");
		handleBrRequest.setBizAddr("广东省佛山市南海区大沥九龙五金不锈钢交易中心A11座101-102号铺");
		handleBrRequest.setPerAddr("");
		handleBrRequest.setApplyAddr("");
		handleBrRequest.setOthAddr("");
		handleBrRequest.setImei("1231241241521541111");
		handleBrRequest.setImsi("1234tysd");
		handleBrRequest.setMobileType("iPhone6");
		handleBrRequest.setSex("男");
		handleBrRequest.setEducationallevel("college_diploma");
		handleBrRequest.setBizPositon("Middle_managers");
		handleBrRequest.setBizType("Government_affiliated_institutions");
//		handleBrRequest.setHouseType("With_the_housing_loan");
		handleBrRequest.setApplySource("Counter_application");
		handleBrRequest.setMarriage("Married");
		handleBrRequest.setBizIndustry("Energy_and_communication_service");
		handleBrRequest.setIncome(1111110);
		handleBrRequest.setBizWorkfor("万度科技有限公司");
		handleBrRequest.setPostalcode("100000");
		handleBrRequest.setApplyProduct("信用卡");
		handleBrRequest.setApplyMoney("10000");
		handleBrRequest.setApplyTime("2014年11月3日 16:47:11");
		handleBrRequest.setLoanReason("花钱");
		handleBrRequest.setBankId("6217000010010884107");
		handleBrRequest.setRefundPeriods(12);
		handleBrRequest.setLinkmanCell("13336169272");
		handleBrRequest.setLinkmanRela("配偶");
		handleBrRequest.setAppVisitNum(30);
		handleBrRequest.setEduAttNum(10);
		handleBrRequest.setBankRunningAttNum(98);
		handleBrRequest.setName("李圆梅");
		handleBrRequest.setBankRunningAttNum(12);
		handleBrRequest.setEduAttNum(2);
		handleBrRequest.setLinkmanAddr("北京");
		handleBrRequest.setLinkmanName("李四");
		String result = baiRongConsumerService.queryUserPortrait(handleBrRequest);
		return result;
	}
	
	/**
	 * 获取百融接口征信报告数据对外访问方法
	 * @author Chengang
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/getBrReport.action", method = RequestMethod.GET)
	public @ResponseBody String getBrReport(@RequestBody HandleBrRequest request){
		request.setGid("00720070004d008f00000000000003bd53196a1d");
		//校验必填参数是否完整
		String msg = checkRequestCondition(request);
		String result = null;
		if(msg.equals("")){
			result = baiRongConsumerService.queryUserPortrait(request);
		}
		return result;
	}
	
	/**
	 * 参数校验
	 * @author Chengang
	 * @param request
	 * @return
	 */
	private String checkRequestCondition(HandleBrRequest request){
		String msg = "";
		if(request.getIdCardNo() == null || StringUtils.isEmpty(request.getIdCardNo()))
			msg = "身份证号码为空";
		if(request.getCell() == null || StringUtils.isEmpty(request.getCell()))
			msg = "手机号码为空";
		if(request.getMail() == null || StringUtils.isEmpty(request.getMail()))
			msg = "邮箱号为空";
		if(request.getName() == null || StringUtils.isEmpty(request.getName()))
			msg = "姓名为空";
		if(request.getGid() == null || StringUtils.isEmpty(request.getGid()))
			msg = "设备标识为空";
		if(request.getTelBiz() == null || StringUtils.isEmpty(request.getTelBiz()))
			msg = "公司座机号码为空";
		if(request.getTelHome() == null || StringUtils.isEmpty(request.getTelHome()))
			msg = "家庭座机号码为空";
		if(request.getHomeAddr() == null || StringUtils.isEmpty(request.getHomeAddr()))
			msg = "家庭地址为空";
		if(request.getBizAddr() == null || StringUtils.isEmpty(request.getBizAddr()))
			msg = "公司地址为空";
		if(request.getApplyAddr() == null || StringUtils.isEmpty(request.getApplyAddr()))
			msg = "申请地址为空";
		if(request.getEducationallevel() == null)
			msg = "学历为空";
		if(request.getMarriage() == null)
			msg = "婚姻状况为空";
		if(request.getBizWorkfor() == null || StringUtils.isEmpty(request.getBizWorkfor()))
			msg = "公司名称为空";
		if(request.getBizIndustry() == null)
			msg = "公司所属行业为空";
		if(request.getApplySource() == null)
			msg = "申请渠道为空";
		if(request.getBankId() == null || StringUtils.isEmpty(request.getBankId()))
			msg = "银行卡号为空";
		if(request.getLinkmanName() == null || StringUtils.isEmpty(request.getLinkmanName()))
			msg = "联系人姓名为空";
		if(request.getLinkmanCell() == null || StringUtils.isEmpty(request.getLinkmanCell()))
			msg = "联系人手机号为空";
		return msg;
	}

}
