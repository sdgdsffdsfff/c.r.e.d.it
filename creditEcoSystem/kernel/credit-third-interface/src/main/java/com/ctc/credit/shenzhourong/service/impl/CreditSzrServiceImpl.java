package com.ctc.credit.shenzhourong.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONObject;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.shenzhourong.api.dto.SzrCPointResponseDto;
import com.ctc.credit.shenzhourong.api.dto.SzrRequestDto;
import com.ctc.credit.shenzhourong.api.dto.SzrBlkListResponseDto;
import com.ctc.credit.shenzhourong.api.service.SzrCreditApiService;
import com.ctc.credit.shenzhourong.constant.SzrConstant;
import com.ctc.credit.shenzhourong.dao.SzrBlklistDao;
import com.ctc.credit.shenzhourong.dao.SzrCPointDao;
import com.ctc.credit.shenzhourong.dao.SzrRequestApplyDao;
import com.ctc.credit.shenzhourong.model.SzrBlklistInfo;
import com.ctc.credit.shenzhourong.model.SzrCPointInfo;
import com.ctc.credit.shenzhourong.model.SzrRequestApplyInfo;
import com.ctc.credit.shenzhourong.model.SzrRequestCondition;
import com.ctc.credit.shenzhourong.service.CreditSzrService;

/**
 * @author Chengang
 * 2015年7月23日 下午2:17:15 
 */
@Service
@Transactional
public class CreditSzrServiceImpl implements CreditSzrService {
	private static Logger logger = Logger.getLogger(CreditSzrServiceImpl.class);
	
	@Autowired
	private SzrCreditApiService creditApiService;
	
	@Autowired
	private SzrBlklistDao szrBlklistDao;
	
	@Autowired
	private SzrCPointDao szrCPointDao;
	
	@Autowired
	private SzrRequestApplyDao szrRequestApplyDao;

	public SzrBlklistDao getSzrBlklistDao() {
		return szrBlklistDao;
	}

	public void setSzrBlklistDao(SzrBlklistDao szrBlklistDao) {
		this.szrBlklistDao = szrBlklistDao;
	}
	
	public SzrCPointDao getSzrCPointDao() {
		return szrCPointDao;
	}

	public void setSzrCPointDao(SzrCPointDao szrCPointDao) {
		this.szrCPointDao = szrCPointDao;
	}

	@Override
	public String doExecuteBlkListRemote(SzrRequestCondition requestCondition) {
		String result = null;
		String maxDate = null;
		String valiDate = "";
		String flag;//查询结果    0查询本地 1正常查询接口 2接口没有记录 3接口查询失败
		SzrRequestDto dto = requestCondition.getDto();
		dto.setServiceCode(SzrConstant.SZRBlklistServicecode);
		try {
		SzrBlklistInfo blklistInfo = szrBlklistDao.querycreateDate(dto.getIdNo(),dto.getName());
		if(blklistInfo != null){
			maxDate = blklistInfo.getCreateDate();
			valiDate = "180";
		}
		if(ifQueryRemote(maxDate,valiDate)){
			//调用神州融接口
			SzrBlkListResponseDto reDto = creditApiService.getSzrBlkListresult(dto);
			if(reDto.getStatus().equals("0")){
				if(!reDto.getValue().equals("记录为空")){
					flag = SzrConstant.SZRRemoteflag;
					blklistInfo = new SzrBlklistInfo();
					blklistInfo = convertSzrBlklistInfo(reDto);//将返回dto转为model实体
					blklistInfo.setApplyNo(requestCondition.getApplyNo());
					//从接口返回参数转换成SzrBlklistInfo
					if(blklistInfo != null){
						szrBlklistDao.save(blklistInfo);
						String json = JSONObject.fromObject(blklistInfo).toString();
						result = json;
					}
				}else{
					flag = SzrConstant.SZRRemoteNullflag;
					result = reDto.getValue();
					logger.info(result);
				}
			}else{
				flag = SzrConstant.SZRRemoteErrorflag;
				result = "查询失败，错误代码：" + reDto.getStatus() + ",对应原因：" +  reDto.getValue();
				logger.error(result);
			}
		}else {
			flag = SzrConstant.SZRlocalflag;
			String json = JSONObject.fromObject(blklistInfo).toString();
			result = json;
		}
		saveCondition(requestCondition,flag);//保存查询条件
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public String doExecuteCreditPointRemote(SzrRequestCondition requestCondition) {
		String result = null;
		String maxDate = null;
		String valiDate = "";
		String flag;//查询结果    0查询本地 1正常查询接口 2接口没有记录 3接口查询失败
		SzrRequestDto dto = requestCondition.getDto();
		dto.setServiceCode(SzrConstant.SZRCPointServicecode);
		//查询时候存在记录
		try {
			SzrCPointInfo cPointInfo = szrCPointDao.getCreateDate(dto.getMobile());
			if(cPointInfo != null){
				maxDate = cPointInfo.getCreateDate();
				valiDate = "180";
			}
			if(ifQueryRemote(maxDate,valiDate)){
				//调用神州融接口
				SzrCPointResponseDto reDto = creditApiService.getSzrCreditPointResult(dto);
				if(reDto.getStatus().equals("0")){
					if(!reDto.getValue().equals("记录为空")){
						flag = SzrConstant.SZRRemoteflag;
	//					SzrBlklistInfo blklistInfo = convertSzrCpointInfo(reDto);//从接口返回参数转换成SzrBlklistInfo
						cPointInfo = new SzrCPointInfo();
						BeanUtils.copyProperties(cPointInfo, reDto);//将返回DTO转成model实体
						cPointInfo.setApplyNo(requestCondition.getApplyNo());
						cPointInfo.setCreateDate(getSimpleNewDate());
						if(cPointInfo != null){
							//存库
							szrCPointDao.save(cPointInfo);
							String json = JSONObject.fromObject(cPointInfo).toString();
							result = json;
						}
					}else{
						flag = SzrConstant.SZRRemoteNullflag;
						result = reDto.getValue();
						logger.info(result);
					}
				}else{
					flag = SzrConstant.SZRRemoteErrorflag;
					result = "查询失败，错误代码：" + reDto.getStatus() + ",对应原因：" +  reDto.getValue();
					logger.error(result);
				}
			}else {
				flag = SzrConstant.SZRlocalflag;
				String json = JSONObject.fromObject(cPointInfo).toString();
				result = json;
			}
			saveCondition(requestCondition, flag);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 保存查询条件
	 * @author Chengang
	 * @param condition
	 * @param flag
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	public void saveCondition(SzrRequestCondition condition, String flag) throws IllegalAccessException, InvocationTargetException{
		SzrRequestApplyInfo applyInfo = new SzrRequestApplyInfo();
		SzrRequestDto dto = condition.getDto();
		if(dto != null){
			BeanUtils.copyProperties(applyInfo, dto);
			applyInfo.setApplyNo(condition.getApplyNo());
			applyInfo.setSourceId(condition.getSourceId());
			applyInfo.setQueryType(condition.getQueryType());
			applyInfo.setResult(flag);
			applyInfo.setCreateDate(getSimpleNewDate());
			szrRequestApplyDao.save(applyInfo);
		}
	}
	
	private Boolean ifQueryRemote(String maxDate, String days) {
		if (null == maxDate) {
			return true;
		}
		int configDys = 0;
		if (StringUtils.isEmpty(days)) {
			return false;
		} else {
			configDys = Integer.parseInt(days);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date mdate;
		try {
			mdate = sdf.parse(maxDate);
		} catch (ParseException e) {
			logger.error(e.getMessage());
			return false;
		}
		int dys = calculateDaysBetween(new Date(), mdate);
		if (dys > configDys)
			return true;
		return false;
	}
	
	private int calculateDaysBetween(Date smallDate, Date bigDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(smallDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long l1 = c.getTimeInMillis();

		c.setTime(bigDate);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		long l2 = c.getTimeInMillis();

		long betweenDays = (l2 - l1) / (1000 * 60 * 60 * 24);
		return Integer.parseInt(String.valueOf(betweenDays));
	}
	
	/**
	 * 日期转成String
	 * @author Chengang
	 * @return	sdate
	 */
	private String getSimpleNewDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String sdate = sdf.format(new Date());
		return sdate;
	}
	
	private SzrBlklistInfo convertSzrBlklistInfo(SzrBlkListResponseDto dto) throws IllegalAccessException, InvocationTargetException{
		SzrBlklistInfo entity = null;
		if(dto != null){
			String date = getSimpleNewDate();
			String grade = dto.getGrade();
			String gradeDesc = "";
			switch (grade) {
				case "99":
					gradeDesc = "权限不足";
					break;
				case "1":
					gradeDesc = "被执行人";
					break;
				case "3":
					gradeDesc = "逾期31-60天";
					break;
				case "5":
					gradeDesc = "逾期61-90天";
					break;
				case "6":
					gradeDesc = "逾期91-180天";
					break;
				case "7":
					gradeDesc = "违约";
					break;
				case "9":
					gradeDesc = "失信被执行人";
					break;
				default:
					gradeDesc = "暂无详情";
					break;
			}
			entity = new SzrBlklistInfo();
			BeanUtils.copyProperties(entity, dto);
			entity.setGradeDesc(gradeDesc);
			entity.setCreateDate(date);
		}
		return entity;
	}
	
//	private SzrBlklistInfo convertSzrCpointInfo(SzrCPointResponseDto dto){
//		SzrBlklistInfo entity = null;
//		if(dto != null){
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
//			String applyNo = sdf.format(new Date());
//			String grade = dto.getGrade();
//			String gradeDesc = "";
//			switch (grade) {
//				case "99":
//					gradeDesc = "权限不足";
//					break;
//				case "1":
//					gradeDesc = "被执行人";
//					break;
//				case "3":
//					gradeDesc = "逾期31-60天";
//					break;
//				case "5":
//					gradeDesc = "逾期61-90天";
//					break;
//				case "6":
//					gradeDesc = "逾期91-180天";
//					break;
//				case "7":
//					gradeDesc = "违约";
//					break;
//				case "9":
//					gradeDesc = "失信被执行人";
//					break;
//				default:
//					gradeDesc = "暂无详情";
//					break;
//			}
//			entity = new SzrBlklistInfo();
//			entity.setApplyNo(applyNo);
//			entity.setName(dto.getName());
//			entity.setIdNo(dto.getIdNo());
//			entity.setIdType(dto.getIdType());
//			entity.setGrade(grade);
//			entity.setGradeDesc(gradeDesc);
//			entity.setSourceId(dto.getSourceId());
//			entity.setCreateDate(applyNo);
//		}
//		return entity;
//	}

}
