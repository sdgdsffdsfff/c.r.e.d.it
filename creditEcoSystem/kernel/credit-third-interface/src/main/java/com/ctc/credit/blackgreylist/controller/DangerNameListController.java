package com.ctc.credit.blackgreylist.controller;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.util.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.blackgreylist.constant.ResponseStatusEnum;
import com.ctc.credit.blackgreylist.factory.BlackNameListBuilder;
import com.ctc.credit.blackgreylist.factory.DangerListDirector;
import com.ctc.credit.blackgreylist.factory.GrayNameListBuilder;
import com.ctc.credit.blackgreylist.factory.IDangerNameListBuilder;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.IDangerList;
import com.ctc.credit.blackgreylist.service.ISearchLogService;
import com.ctc.credit.common.SpringContextHelper;
import com.ctc.credit.qianhai.service.QianHaiConsumerService;

@Controller
@RequestMapping(value = "/service/dangerNameList")
public class DangerNameListController {
	
	private Logger consoleLog = Logger.getLogger("D");
	
	@Autowired
	QianHaiConsumerService qianHaiConsumerService;
	
	@Autowired
	private ISearchLogService searchLogServiceImpl;

	@ResponseBody
	@RequestMapping(value = "/blackList.action", method = RequestMethod.POST)
	public Object showBlackList(@RequestParam String dangerInfo) {
		Date date = new Date();
		Long mt = date.getTime();
		Map<String, Object> result = new HashMap<String, Object>();
		String decodeDangerInfo = dangerInfo;

		// 解密入参数,解决中文乱码
		try {
			decodeDangerInfo = new String(Base64.decodeBase64(dangerInfo),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "传入参数解码异常,原始内容 : " + dangerInfo);
			e.printStackTrace();
			return result;
		}

		HandleRequest hr = null;
		try {
			hr = (HandleRequest) JSONObject.toBean(
					JSONObject.fromObject(decodeDangerInfo),
					HandleRequest.class);
		} catch (Exception ex) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "传入参数组装异常 : " + ex.getMessage());
			ex.printStackTrace();
			return result;
		}

		List<Map<String, Object>> r = null;
		String trigger_source = "";
		
		try {

			// Builder模式创建 检索对象
			IDangerNameListBuilder dnlb = (BlackNameListBuilder) SpringContextHelper
					.getBean("blackNameListBuilder");
			DangerListDirector dd = new DangerListDirector(dnlb);
			IDangerList dlist = dd.createDangerList();
			r = dlist.matchDangerList(hr);
			
			
			if (!r.isEmpty() && r.get(0) != null && r.get(0).get("BLKGRAY_ROLE_CODE") != null) {
				trigger_source = r.get(0).get("TIGGER_SOURCE").toString();
				result.put("status", ResponseStatusEnum.Match.getCode());
				result.put("message", "SUCCESS");
				result.put("rejectCode", r.get(0).get("BLKGRAY_ROLE_CODE")
						.toString());
				result.put(
						"rejectInfo",
						dlist.getRoleInfos()
								.get(r.get(0).get("BLKGRAY_ROLE_CODE")
										.toString()).getBlackNameDES());
				result.put("rejectTigger", r.get(0).get("TIGGER_INFO")
						.toString());
			} else {
				String riskLevel = hr.getRiskLevel();//额度策略输出的风险等级
				if (StringUtils.isNotEmpty(riskLevel)
						&& "高风险".equals(riskLevel)) {
					/***
					 * 查询前海信息 如果查到 保存并且返回前海黑名单信息 如果没有查询到。正常结束
					 */
					Boolean triggerFlg = null;
					try {
						triggerFlg = qianHaiConsumerService
								.doExecuteSingleRemoteService(hr);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if (null != triggerFlg && triggerFlg.equals(true)) {// 命中前海外部征信黑名单
						result.put("status", ResponseStatusEnum.Match.getCode());
						result.put("message", "SUCCESS");
						result.put("rejectCode", "02ZX");
						result.put("rejectInfo", "外部征信黑名单");
						result.put("rejectTigger", hr.getCardNo());
					} else {
						result.put("status",
								ResponseStatusEnum.UnMatch.getCode());
						result.put("message", "");
						result.put("rejectCode", "");
						result.put("rejectInfo", "");
						result.put("rejectTigger", "");
					}
				}else{
					result.put("status",
							ResponseStatusEnum.UnMatch.getCode());
					result.put("message", "");
					result.put("rejectCode", "");
					result.put("rejectInfo", "");
					result.put("rejectTigger", "");
				}
			}

		} catch (Exception ex) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "黑名单查询异常 : " + ex.getMessage());
			ex.printStackTrace();
			consoleLog.error(ex.getMessage());
			return result;
		}
		
		try{
			searchLogServiceImpl.saveBlackSearchLog(decodeDangerInfo,hr, result,trigger_source);
		}catch(Exception ex){
			ex.printStackTrace();
			consoleLog.error(ex.getMessage());
		}
		
		
		consoleLog.info(JSONObject.fromObject(result).toString());
		
		date = new Date();
		Long m2 = date.getTime();
		consoleLog.info("黑名单查询耗时:"+(m2-mt)+"毫秒");
		return result;

	}

	@ResponseBody
	@RequestMapping(value = "/grayList.action", method = RequestMethod.POST)
	public Object showGrayList(@RequestParam String dangerInfo) {
		Date date = new Date();
		Long mt = date.getTime();
		
		Map<String, Object> result = new HashMap<String, Object>();

		// 解密入参数,解决中文乱码
		String decodeDangerInfo = "";
		try {
			decodeDangerInfo = new String(Base64.decodeBase64(dangerInfo),
					"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "传入参数解码异常,原始内容 : " + dangerInfo);
			e.printStackTrace();
			return result;
		}

		HandleRequest hr = null;
		try {
			hr = (HandleRequest) JSONObject.toBean(
					JSONObject.fromObject(decodeDangerInfo),
					HandleRequest.class);
		} catch (Exception ex) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "传入参数组装异常 : " + ex.getMessage());
			ex.printStackTrace();
			return result;
		}

		try {
			// Builder模式创建 检索对象
			IDangerNameListBuilder dnlb = (GrayNameListBuilder) SpringContextHelper
					.getBean("grayNameListBuilder");
			DangerListDirector dd = new DangerListDirector(dnlb);
			IDangerList dlist = dd.createDangerList();

			List<Map<String, Object>> r = dlist.matchDangerList(hr);

			if (r != null && !r.isEmpty() && r.get(0) != null
					&& !r.get(0).isEmpty()) {
				result.put("status", ResponseStatusEnum.Match.getCode());
				result.put("message", "SUCCESS");
				result.put("greyListInfo", r);
			} else {
				result.put("status", ResponseStatusEnum.UnMatch.getCode());
				result.put("message", "SUCCESS");
				result.put("greyListInfo", r);
			}
		} catch (Exception ex) {
			result.put("status", ResponseStatusEnum.Exception.getCode());
			result.put("message", "灰名单查询异常 : " + ex.getMessage());
			ex.printStackTrace();
			consoleLog.error(ex.getMessage());
			return result;
		}

		try{
			searchLogServiceImpl.saveGraykSearchLog(decodeDangerInfo,hr, result);
		}catch(Exception ex){
			ex.printStackTrace();
			consoleLog.error(ex.getMessage());
		}
		
		date = new Date();
		Long m2 = date.getTime();
		consoleLog.info("灰名单查询耗时:"+(m2-mt)+"毫秒");
		return result;

	}
}
