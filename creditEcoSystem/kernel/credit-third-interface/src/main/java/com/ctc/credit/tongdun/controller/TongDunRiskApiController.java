package com.ctc.credit.tongdun.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.blackgreylist.constant.ResponseStatusEnum;
import com.ctc.credit.tongdun.api.dto.TongDunResRiskApiDto;
import com.ctc.credit.tongdun.api.service.TongDunReqRiskApiService;
import com.ctc.credit.tongdun.model.TongDunReqRiskApiEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiRequest;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiResponse;
import com.ctc.credit.tongdun.service.TongDunReqRiskApiInfoService;
import com.ctc.credit.tongdun.service.TongDunResRiskApiService;


@Controller
@RequestMapping(value = "/service/tdrac")
public class TongDunRiskApiController {
	private static Logger logger=Logger.getLogger(TongDunRiskApiController.class);
	@Autowired
	TongDunReqRiskApiService tongDunReqRiskApiService;
	@Autowired
	TongDunReqRiskApiInfoService tongDunRiskApiInfoService;
	@Autowired
	TongDunResRiskApiService tongDunResRiskApiService;
	
	
	@RequestMapping(value = "/queryriskapiinfo.action", method = RequestMethod.POST)
	public @ResponseBody JSONObject queryRiskApiInfo(@RequestParam String reqRiskApiInfo) throws Exception{
		Date date=new Date();
		Map<String, Object> result = new HashMap<String, Object>();
		String decodeReqRiskApiInfo=reqRiskApiInfo;
		try {
			decodeReqRiskApiInfo=new String(Base64.decodeBase64(reqRiskApiInfo.getBytes()),"UTF-8");
		} catch (UnsupportedEncodingException  e) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "传入参数解码异常,原始内容 : " + reqRiskApiInfo);
			e.printStackTrace();
			return JSONObject.fromObject(result);
		}
		
		HandleTdRiskApiRequest handleTdRiskApiRequest = (HandleTdRiskApiRequest) JSONObject.toBean(
				JSONObject.fromObject(decodeReqRiskApiInfo),
				HandleTdRiskApiRequest.class);
		
		TongDunReqRiskApiEntity tongDunReqRiskEntity = tongDunRiskApiInfoService.tongDunReqRiskInfoSave(handleTdRiskApiRequest);
		
		HandleTdRiskApiResponse handleTdResponse=new HandleTdRiskApiResponse();	
		Long mt = date.getTime();
		TongDunResRiskApiDto tongDunResRiskApiDto = tongDunReqRiskApiService.getTongDunRiskData(handleTdRiskApiRequest);
		date = new Date();
		Long m2 = date.getTime();
		logger.info("同盾风险API查询耗时:"+(m2-mt)+"毫秒");
		handleTdResponse.setTongDunResRiskApiDto(tongDunResRiskApiDto);
		handleTdResponse.setP_id(tongDunReqRiskEntity.getId());
		tongDunResRiskApiService.tongDunResRiskInfoSave(handleTdResponse);
		
		
		JSONObject jo = JSONObject.fromObject(tongDunResRiskApiDto.getResinfo());
		String fd = jo.get("final_decision").toString();
		
		JSONObject jon = new JSONObject();
		if("Reject".equals(fd)){
			jon.put("status", "000");
		}else{
			jon.put("status", "001");
		}
		
		jon.put("message", "");
		
		
		return jon;
		
	}
	
	
}


