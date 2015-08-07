package com.ctc.credit.tongdun.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDetailDto;
import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDetailDto;
import com.ctc.credit.tongdun.api.service.TongDunDetailByIdService;
import com.ctc.credit.tongdun.model.TongDunReqApiDetailEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailRequest;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiDetailResponse;
import com.ctc.credit.tongdun.service.TongDunReqRiskApiDetailService;
import com.ctc.credit.tongdun.service.TongDunResRiskApiDetailService;

@Controller
@RequestMapping(value = "/service/tdradc")
public class TongDunRiskApiDetailController {
	private static Logger logger=Logger.getLogger(TongDunRiskApiDetailController.class);
	
	@Autowired
	TongDunReqRiskApiDetailService tongDunReqRiskDetailService;
	@Autowired
	TongDunDetailByIdService tongDunDetailByIdService;
	@Autowired
	TongDunResRiskApiDetailService tongDunResRiskApiDetailService;
	
	
	@RequestMapping(value = "/queryriskapiinfodetail.action", method = RequestMethod.GET)
	public @ResponseBody JSONObject queryRiskApiInfoDetail(
			@RequestParam("sequence_id") String sequence_id,@RequestParam("rule_uuid") String rule_uuid,@RequestParam("others_value") String others_value) throws Exception{
		Date date=new Date();
		
		TongDunReqRiskApiDetailDto tongDunReqRiskApiDetailDto=new TongDunReqRiskApiDetailDto();
		InputStream input = null;
		Properties prop = new Properties();
		input = ConfigsContant.class.getClassLoader().getResourceAsStream("tongdun.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			logger.equals(e.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				input = null;
				e.printStackTrace();
			}
		}
		tongDunReqRiskApiDetailDto.setPartner_code(prop.getProperty("partner_code"));
		tongDunReqRiskApiDetailDto.setPartner_key(prop.getProperty("partner_key"));
		tongDunReqRiskApiDetailDto.setSequence_id(sequence_id);
		tongDunReqRiskApiDetailDto.setRule_uuid(rule_uuid);
		HandleTdRiskApiDetailRequest handleTdRiskApiDetailRequest=new HandleTdRiskApiDetailRequest();
		handleTdRiskApiDetailRequest.setOthers_value(others_value);
		handleTdRiskApiDetailRequest.setTongDunReqRiskApiDetailDto(tongDunReqRiskApiDetailDto);
		TongDunReqApiDetailEntity tongDunReqDetailEntity=tongDunReqRiskDetailService.tongDunReqRiskDetailInfoSave(handleTdRiskApiDetailRequest);
		Long mt = date.getTime();
		TongDunResRiskApiDetailDto tongDunResRiskApiDetailDto=tongDunDetailByIdService.queryDetailById(handleTdRiskApiDetailRequest);
		date = new Date();
		Long m2 = date.getTime();
		logger.info("同盾风险API详情查询耗时:"+(m2-mt)+"毫秒");
		HandleTdRiskApiDetailResponse handleTdRiskApiDetailResponse=new HandleTdRiskApiDetailResponse();
		handleTdRiskApiDetailResponse.setP_id(tongDunReqDetailEntity.getId());
		handleTdRiskApiDetailResponse.setTongDunResRiskApiDetailDto(tongDunResRiskApiDetailDto);
		tongDunResRiskApiDetailService.tongDunResApiDetailInfoSave(handleTdRiskApiDetailResponse);
		
		return JSONObject.fromObject(handleTdRiskApiDetailResponse);
		
	}
}
