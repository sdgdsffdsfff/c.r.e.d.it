package com.ctc.credit.lakala.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.annotation.Resource;

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
import com.ctc.credit.blackgreylist.controller.XlsFileuploadController;
import com.ctc.credit.lakala.dto.BlkWarningRequestParam;
import com.ctc.credit.lakala.dto.BlkWarningResponseParam;
import com.ctc.credit.lakala.model.LklApplyBlkList;
import com.ctc.credit.lakala.service.ILklApplyBlkListService;
import com.ctc.credit.lakala.service.LakalaServiceInterface;


@Controller
@RequestMapping(value = "/service/lakala")
public class LakalaController {
	
	private static Logger logger = Logger.getLogger(LakalaController.class);
	
	@Resource(name="blkWarningServiceImpl")
	LakalaServiceInterface<BlkWarningResponseParam,BlkWarningRequestParam> lsa;
	
	@Autowired
	ILklApplyBlkListService labs;
	
	
	@ResponseBody
	@RequestMapping(value = "/blkWarning.action", method = RequestMethod.POST)
	public JSONObject blkWarningController(@RequestParam String userInfo){
		
		String userParamInfo = userInfo;
		JSONObject result = new JSONObject();
		
		
		// 解密入参数,解决中文乱码
		try {
			userParamInfo = new String(Base64.decodeBase64(userInfo),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "传入参数解码异常,原始内容 : " + userInfo);
			e.printStackTrace();
			return result;
		}

		BlkWarningRequestParam brp = null;
		try {
			brp = (BlkWarningRequestParam) JSONObject.toBean(
					JSONObject.fromObject(userParamInfo),
					BlkWarningRequestParam.class);
		} catch (Exception ex) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "传入参数组装异常 : " + ex.getMessage());
			ex.printStackTrace();
			return result;
		}
		
		
		BlkWarningResponseParam bwrp = null;
		try {
			bwrp = lsa.doRequest(brp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		LklApplyBlkList labl = new LklApplyBlkList();
		try{
			labl.setRqEmail(brp.getEmail());
			labl.setRqGddh(brp.getGddh());
			labl.setRqGmsfhm(brp.getGmsfhm());
			labl.setRqIp(brp.getIp());
			labl.setRqSjhm(brp.getSjhm());
			labl.setRqXm(brp.getXm());
			labl.setRqYhkh(brp.getYhkh());
			labl.setRpDwCount(bwrp.getDwCount());
			labl.setRpHmdsj(bwrp.getHmdSj());
			labl.setRpHmdsjBz(bwrp.getHmdSjBz());
			labl.setRpNewDate(bwrp.getNewDate());
			labl.setRpScCount(bwrp.getScCount());
			labl.setCreateDate(new Date());
			labl.setCreateUser("admin");
			labs.save(labl);
		}catch(Exception ex){
			ex.printStackTrace();
			logger.info(ex.getMessage());
		}
		
		return  result.fromObject(bwrp);
	}
}
