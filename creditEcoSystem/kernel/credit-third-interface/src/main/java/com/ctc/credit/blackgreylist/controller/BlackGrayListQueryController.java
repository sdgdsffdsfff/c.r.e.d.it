package com.ctc.credit.blackgreylist.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertySetStrategy;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctc.credit.blackgreylist.model.BlkGrayListQueryPara;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.model.CreditBlkgraylistRoleEntity;
import com.ctc.credit.blackgreylist.service.CreditBlkgraylistDetailEntityService;
import com.ctc.credit.blackgreylist.service.IBlkgrayListRoleService;
import com.ctc.credit.common.PropertyStrategyWrapper;


@Controller
@RequestMapping(value = "/service/blackgraylist")
public class BlackGrayListQueryController {

	private static Logger logger = Logger.getLogger(XlsFileuploadController.class);
	
	private static Integer pageSize = 8;
	
	/** 详细 **/
	private static String ACTION_TYPE_DETAIL = "D";
	
	/** 作废**/
	private static String ACTION_TYPE_ZUOFEI = "Z";
	
	@Autowired
	CreditBlkgraylistDetailEntityService creditBlkgraylistDetailEntityService;
	
	@Autowired
	IBlkgrayListRoleService iBlkgrayListRoleService;
	
	@RequestMapping(value = "/queryblkgraydetail.action", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject queryBlkGrays(HttpServletRequest request){
		BlkGrayListQueryPara blkGrayListQueryPara = getParaFromRequest(request);
		int count = creditBlkgraylistDetailEntityService.queryCount(blkGrayListQueryPara);
		Map<String, Object> returnEntity = new HashMap<>();
		returnEntity.put("total", count);
		returnEntity.put("pages", getPages(count));
		List<CreditBlkgraylistDetailEntity> creditBlkgraylistDetailEntities = creditBlkgraylistDetailEntityService.queryCreditBlkgraylistDetailEntities(blkGrayListQueryPara);
		for (CreditBlkgraylistDetailEntity creditBlkgraylistDetailEntity : creditBlkgraylistDetailEntities)
			initData(creditBlkgraylistDetailEntity);
		returnEntity.put("data", JSONArray.fromObject(creditBlkgraylistDetailEntities));
		return JSONObject.fromObject(returnEntity);
	}
	
	@RequestMapping(value = "/querydetail.action", method = RequestMethod.GET)
	public @ResponseBody
	JSONObject queryBlkGraydetail(HttpServletRequest request){
		String actionType = request.getParameter("actionType");
		String id = request.getParameter("id");
		CreditBlkgraylistDetailEntity blkgraylistDetailEntity = creditBlkgraylistDetailEntityService.queryBlkgrayEntity(id);
		initData(blkgraylistDetailEntity);
		if(ACTION_TYPE_DETAIL.equals(actionType)){
			return JSONObject.fromObject(blkgraylistDetailEntity);
		}else if (ACTION_TYPE_ZUOFEI.equals(actionType)) {
			logger.info("明细编号："+blkgraylistDetailEntity.getId()+"被作废，时间："+new Date().toString());
			blkgraylistDetailEntity.setEnable(new Long(1));
			creditBlkgraylistDetailEntityService.update(blkgraylistDetailEntity);
			deleteIndex(blkgraylistDetailEntity.getId());
			return JSONObject.fromObject("{msg:'作废成功！'}");
		}
		return JSONObject.fromObject(blkgraylistDetailEntity);
	}
	
	/**
	 * 从request中解析参数并封装
	 * 
	 * @param request
	 * @return
	 */
	private BlkGrayListQueryPara getParaFromRequest(HttpServletRequest request){
		String query = request.getParameter("query");
		try {
			query = URLDecoder.decode(query,"UTF-8");
			query = query.replace("\\", "");
			if (query.startsWith("\"")) {
				query=query.substring(1, query.length()-1);
			}
		} catch (UnsupportedEncodingException e) {
			logger.info(e.getMessage(),e);
		}
		BlkGrayListQueryPara blkGrayListQueryPara = (BlkGrayListQueryPara) getBean(JSONObject.fromObject(query),BlkGrayListQueryPara.class);
		Integer pageCur = 1;
		if(StringUtils.isNotEmpty(request.getParameter("page")))
			pageCur = Integer.valueOf(request.getParameter("page"));
		Integer rowStart = (pageCur-1)*pageSize+1;
		Integer rowLimit = pageSize;
		blkGrayListQueryPara.setRowStart(rowStart);
		blkGrayListQueryPara.setRowLimit(rowLimit);
		return blkGrayListQueryPara;
	}
	
	private int getPages(int total){
		if (total>0) {
			return total%pageSize==0?total/pageSize:total/pageSize+1;
		}
		return 0;
		
	}
	
	private <T> Object getBean(JSONObject jsonObject, Class<T> clazz) {
		// 声明JsonConfig对象
		JsonConfig cfg = new JsonConfig();
		// 设置属性包装器
		cfg.setPropertySetStrategy(new PropertyStrategyWrapper(
				PropertySetStrategy.DEFAULT));
		// 设置要转换成的JavaBean
		cfg.setRootClass(clazz);
		// 转换
		Object object = JSONObject.toBean(jsonObject, cfg);
		return object;
	}
	/**
	 * 删除 查询索引
	 * @param srcId
	 */
	private void deleteIndex(String srcId){
		List<CreditBlkgraylistRoleEntity> creditBlkgraylistRoleEntities = null;
		try {
			creditBlkgraylistRoleEntities = iBlkgrayListRoleService.queryEntitiesById(srcId);
		} catch (Exception e) {
			logger.error("查询【"+srcId+"】索引失败！");
			logger.error(e.getMessage());
		}
		try {
			if(null!=creditBlkgraylistRoleEntities&&creditBlkgraylistRoleEntities.size()>0){
				iBlkgrayListRoleService.deleteAll(creditBlkgraylistRoleEntities);
				logger.info("共删除索引数据"+creditBlkgraylistRoleEntities.size()+"条");
			}
		} catch (Exception e) {
			logger.error("删除【"+srcId+"】索引失败！");
			logger.error(e.getMessage());
		}
	}
	
	/**
	 * 初始化数据
	 * @param creditBlkgraylistDetailEntity
	 */
	private void initData(CreditBlkgraylistDetailEntity creditBlkgraylistDetailEntity){
		Long warnbLevel = creditBlkgraylistDetailEntity.getWarnLevel();
		Long enable = creditBlkgraylistDetailEntity.getEnable();
		String dateString = creditBlkgraylistDetailEntity.getCreateDate();
		Long channel = creditBlkgraylistDetailEntity.getChannel();
		Long sourceSys = creditBlkgraylistDetailEntity.getSourceSys();
		if (null==channel||new Long(0l).equals(channel)) {
			creditBlkgraylistDetailEntity.setChannelDesc("征信系统");
		}
		if (null==sourceSys||new Long(0l).equals(sourceSys)) {
			creditBlkgraylistDetailEntity.setSourceSysDesc("征信系统");
		}else if (new Long(1l).equals(sourceSys)) {
			creditBlkgraylistDetailEntity.setSourceSysDesc("小贷系统");
		}else if (new Long(2l).equals(sourceSys)) {
			creditBlkgraylistDetailEntity.setSourceSysDesc("账务系统");
		}else if (new Long(3l).equals(sourceSys)) {
			creditBlkgraylistDetailEntity.setSourceSysDesc("平安前海");
		}
		if (0==warnbLevel) {
			creditBlkgraylistDetailEntity.setWarnLevelDesc("黑名单");
		}else if(1==warnbLevel){
			creditBlkgraylistDetailEntity.setWarnLevelDesc("灰名单");
		}else{
			creditBlkgraylistDetailEntity.setWarnLevelDesc("未知");
		}
		if(0==enable){
			creditBlkgraylistDetailEntity.setStatus("生效中");
		}else if(1==enable){
			creditBlkgraylistDetailEntity.setStatus("作废");
		}else{
			creditBlkgraylistDetailEntity.setStatus("未知");
		}
		if(null!=dateString){
			creditBlkgraylistDetailEntity.setCreateDateDesc(dateString.substring(0, 4)+"/"+dateString.substring(4, 6)+"/"+dateString.substring(6, 8));
		}
	}
}
