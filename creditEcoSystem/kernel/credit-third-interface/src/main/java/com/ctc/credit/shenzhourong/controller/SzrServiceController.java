/**
 * 
 */
package com.ctc.credit.shenzhourong.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.shenzhourong.api.dto.SzrRequestDto;
import com.ctc.credit.shenzhourong.model.SzrRequestCondition;
import com.ctc.credit.shenzhourong.service.CreditSzrService;

/**
 * 神州融对外方法
 * @author Chengang
 * 2015年7月24日 上午11:40:54 
 */
@Controller
@RequestMapping(value = "/service/szr")
public class SzrServiceController {
	private static Logger logger = Logger.getLogger(SzrServiceController.class);
	
	@Resource
	private CreditSzrService creditSzrService;
	
	@RequestMapping(value="/query.action",method=RequestMethod.GET)
	public @ResponseBody String query(@RequestParam String queryType){
		SzrRequestCondition condition = new SzrRequestCondition();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String applyNo = sdf.format(new Date());
//		String queryType = "SZRCPOINT";//SZRCPOINT   SZRBlkLIST
		SzrRequestDto dto = new SzrRequestDto();
		dto.setIdNo("371525199011030310");//371525199011030310  320106198107173214
		dto.setName("安威");//安威 安吉
		dto.setIdType("0");
		dto.setMobile("13589898877");
		condition.setApplyNo(applyNo);
		condition.setQueryType(queryType);
		condition.setDto(dto);
		String result = querySzr(condition);
		return result;
	}
	
	@RequestMapping(value="/querySzr.action",method=RequestMethod.GET)
	public @ResponseBody String querySzr(@RequestBody SzrRequestCondition requestCondition){
		String msg = checkRequest(requestCondition);
		String result = null;
		if(msg.equals("")){
//			SzrRequestDto dto = requestCondition.getDto();
//			dto.setUserId("lisi");
//			dto.setPassword("lisi");
//			dto.setId("371525199011030310");//371525199011030310  320106198107173214
//			dto.setName("安威");//安威 安吉
//			if(requestCondition.getQueryType().equals("BlackListAction")){
//				dto.setIdType("0");
//			}else if(requestCondition.getQueryType().equals("ZCreditScoreAction")){
//				dto.setMobile("13812345678");
//			}
			if(requestCondition.getQueryType().equals("SZRBlkLIST")){
				result = creditSzrService.doExecuteBlkListRemote(requestCondition);
			}else if(requestCondition.getQueryType().equals("SZRCPOINT")){
				result = creditSzrService.doExecuteCreditPointRemote(requestCondition);
			}
		}else {
			result = "查询参数不完整" + msg;
			logger.error(result);
		}
		return result;
	}
	
	private String checkRequest(SzrRequestCondition requestCondition){
		String msg = "";
		if(requestCondition != null){
			String queryType = requestCondition.getQueryType();
			String applyNo = requestCondition.getApplyNo();
			SzrRequestDto dto = requestCondition.getDto();
			if(queryType == null || StringUtils.isEmpty(queryType)){
				msg = "查询类型为空";
			}else if(applyNo == null || StringUtils.isEmpty(applyNo)){
				msg = "申请单号为空";
			}else if(dto == null){
				msg = "查询参数为空";
			}else if(dto.getName() == null || StringUtils.isEmpty(dto.getName())){
				msg = "姓名为空";
			}else if(dto.getIdNo() == null || StringUtils.isEmpty(dto.getIdNo())){
				msg = "证件号码为空";
			}else if(queryType.equals("SZRBlkLIST")){//BlackListAction
				if(dto.getIdType() == null || StringUtils.isEmpty(dto.getIdType()))
					msg = "证件类型为空";
			}else if(queryType.equals("SZRCREDITPOINT")){//ZCreditScoreAction
				if(dto.getMobile() == null || StringUtils.isEmpty(dto.getMobile()))
					msg = "手机号码为空";
			}
		}
		return msg;
	}

}
