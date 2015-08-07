package com.ctc.credit.qianhai.service.impl;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.blackgreylist.model.CreditBlkgraylistDetailEntity;
import com.ctc.credit.blackgreylist.pojo.HandleRequest;
import com.ctc.credit.blackgreylist.service.CreditBlkgraylistDetailEntityService;
import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.kernel.util.DataSecurityUtil;
import com.ctc.credit.kernel.util.DateUtil;
import com.ctc.credit.kernel.util.JsonUtil;
import com.ctc.credit.kernel.util.KeystoreUtil;
import com.ctc.credit.qianhai.api.dto.BlkListRequestBusiData;
import com.ctc.credit.qianhai.api.dto.BlkListRequestBusiDataRecord;
import com.ctc.credit.qianhai.api.dto.BlkListRequestDto;
import com.ctc.credit.qianhai.api.dto.BlkListRequestHead;
import com.ctc.credit.qianhai.api.dto.BlkListRequestSecurityInfo;
import com.ctc.credit.qianhai.api.dto.BlkListResponseBusiData;
import com.ctc.credit.qianhai.api.dto.BlkListResponseBusiDataRecord;
import com.ctc.credit.qianhai.api.dto.BlkListResponseDto;
import com.ctc.credit.qianhai.api.dto.BlkListResponseHead;
import com.ctc.credit.qianhai.api.service.QianHaiCreditApiService;
import com.ctc.credit.qianhai.constant.QianHaiEnum;
import com.ctc.credit.qianhai.model.CreditQhApplyBlkListEntity;
import com.ctc.credit.qianhai.model.CreditQhBlkListEntity;
import com.ctc.credit.qianhai.service.CreditQhApplyBlkListEntityService;
import com.ctc.credit.qianhai.service.CreditQhBlkListEntityService;
import com.ctc.credit.qianhai.service.QianHaiConsumerService;

@Service
@Transactional
public class QianHaiConsumerServiceImpl implements QianHaiConsumerService {

	private static Logger logger = Logger
			.getLogger(QianHaiConsumerServiceImpl.class);

	@Autowired
	CreditBlkgraylistDetailEntityService creditBlkgraylistDetailEntityService;

	@Autowired
	QianHaiCreditApiService qianHaiCreditApiService;

	@Autowired
	CreditQhApplyBlkListEntityService blkListApplyService;

	@Autowired
	CreditQhBlkListEntityService blkListService;

	/**
	 * 创建请求对象，并初始化头对象。 初始化报文记录对象和索引创建原始对象
	 * 
	 * @param handleRequests
	 * @param entityMap
	 * @param detailsTosave
	 * @return
	 */
	public BlkListRequestDto createBlkListRequestBusiData(
			List<HandleRequest> handleRequests,
			Map<String, CreditQhApplyBlkListEntity> entityMap,
			Map<String, HandleRequest> handleRequestMap) {
		logger.info("###### 创建 BlkListRequestDto请求对象开始");
		BlkListRequestDto blkListRequestDto = new BlkListRequestDto();
		BlkListRequestHead blkListRequestHead = createBlkListRequestHead();
		blkListRequestDto.setHeader(blkListRequestHead);
		BlkListRequestBusiData blkListRequestBusiData = new BlkListRequestBusiData();
		String batchNo = RandomStringUtils.randomAlphanumeric(32);
		blkListRequestBusiData.setBatchNo(batchNo);
		List<BlkListRequestBusiDataRecord> resords = new ArrayList<BlkListRequestBusiDataRecord>();
		for (HandleRequest handleRequest : handleRequests) {
			BlkListRequestBusiDataRecord recored = new BlkListRequestBusiDataRecord();
			String seqNo = RandomStringUtils.randomAlphanumeric(24);
			recored.setReasonCode("04");
			recored.setIdNo(handleRequest.getCardNo());
			recored.setIdType("0");
			recored.setSeqNo(seqNo);
			recored.setName(handleRequest.getCustomerName());
			resords.add(recored);
			CreditQhApplyBlkListEntity creditQhApplyBlkListEntity = getEntityToSave(blkListRequestHead);
			creditQhApplyBlkListEntity.setReasonCode("04");
			creditQhApplyBlkListEntity.setIdNo(handleRequest.getCardNo());
			creditQhApplyBlkListEntity.setIdType("0");
			creditQhApplyBlkListEntity.setSeqNo(seqNo);
			creditQhApplyBlkListEntity.setName(handleRequest.getCustomerName());
			creditQhApplyBlkListEntity.setApplyNo(handleRequest.getApplyCode());
			creditQhApplyBlkListEntity.setBatchNo(batchNo);
			entityMap.put(seqNo, creditQhApplyBlkListEntity);
			handleRequestMap.put(seqNo, handleRequest);
		}
		blkListRequestBusiData.setRecords(resords);
		String busiStr = JSONObject.fromObject(blkListRequestBusiData)
				.toString();
		logger.info("###### 交易流水号：" + blkListRequestHead.getTransNo());
		logger.info("###### 加密前报文数据:" + busiStr);
		String busiData = null;
		try {
			logger.info("###### 业务数据busiData，加密开始");
			busiData = DataSecurityUtil.encodeBase64(DataSecurityUtil
					.encryptMode(
							ConfigsContant.QIANHAI_3DES_KEY.getBytes("utf-8"),
							busiStr.getBytes()));
			logger.info("###### 业务数据busiData，加密结束");
			PrivateKey prikey = KeystoreUtil
					.getPrivateKeyFromFile(ConfigsContant.QIANHAI_SIGN_KEY_PATH);
			logger.info("###### 业务数据busiData，签名开始");
			String signStr = DataSecurityUtil.signData(busiData, prikey);
			logger.info("###### 业务数据busiData，签名结束");
			for (Entry<String, CreditQhApplyBlkListEntity> entry : entityMap
					.entrySet()) {
				CreditQhApplyBlkListEntity valEntity = entry.getValue();
				valEntity.setSignatureValue(signStr);
			}
			BlkListRequestSecurityInfo blkListRequestSecurityInfo = new BlkListRequestSecurityInfo();
			blkListRequestSecurityInfo
					.setUserName(ConfigsContant.QIANHAI_USER_NAME);
			blkListRequestSecurityInfo.setUserPassword(DataSecurityUtil
					.encodePwd(ConfigsContant.QIANHAI_USER_PWD));
			blkListRequestSecurityInfo.setSignatureValue(signStr);
			blkListRequestDto.setBusiData(busiData);
			blkListRequestDto.setSecurityInfo(blkListRequestSecurityInfo);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		logger.info("###### 创建 BlkListRequestDto请求对象结束");
		return blkListRequestDto;
	}

	@Override
	public Map<HandleRequest, Boolean> doExecuteRemoteService(
			List<HandleRequest> handleRequests) {
		logger.info("######--- 前海黑名单远程调用开始 ---######");
		Map<HandleRequest, Boolean> reMap = new HashMap<HandleRequest, Boolean>();
		for (HandleRequest handleRequest : handleRequests) {// 默认都不是黑名单
			reMap.put(handleRequest, false);
		}
		Map<String, CreditQhApplyBlkListEntity> entityMap = new HashMap<String, CreditQhApplyBlkListEntity>();
		Map<String, HandleRequest> handleRequestMap = new HashMap<String, HandleRequest>();
		BlkListRequestDto blkListRequestDto = createBlkListRequestBusiData(
				handleRequests, entityMap, handleRequestMap);
		BlkListResponseDto response = null;
		try {
			response = qianHaiCreditApiService
					.getQianhaiCreditData(blkListRequestDto);
		} catch (Exception e) {
			String msg = e.getMessage();
			String erroCode = msg.split("||")[0];
			String erroMsg = msg.split("||")[1];
			logger.error("前海接口调用异常", e);
			saveEntitysWithException(entityMap, erroCode, erroMsg);
		}
		if (null == response) {
			logger.error("###### 申请人姓名："
					+ handleRequests.get(0).getCustomerName() + "||证件号码："
					+ handleRequests.get(0).getCardNo() + "，前海接口数据返回异常");
		} else {
			if (QianHaiEnum.E000000.equals(response.getHeader().getRtCode())) {// 交易成功
				logger.info("###### 报文交易成功");
				deCodeAndSave(response, entityMap, handleRequestMap, reMap);
			} else {
				logger.info("###### 报文交易失败，原因码："
						+ response.getHeader().getRtCode());
				saveEntitysWithException(entityMap, QianHaiEnum.EXC_CODE_A0003,
						response.getHeader().getRtCode());
			}
		}
		logger.info("######--- 前海黑名单远程调用结束 ---######");
		return reMap;
	}

	public BlkListRequestHead createBlkListRequestHead() {
		BlkListRequestHead blkListRequestHead = new BlkListRequestHead();
		blkListRequestHead.setOrgCode(QianHaiEnum.orgCode);
		blkListRequestHead.setChnlId(QianHaiEnum.chnlId);
		blkListRequestHead.setTransNo(RandomStringUtils.randomAlphanumeric(24));
		blkListRequestHead.setTransDate(DateUtil.getNowTime());
		blkListRequestHead.setAuthCode(QianHaiEnum.authCode + "_"
				+ RandomStringUtils.randomAlphanumeric(16));
		blkListRequestHead.setAuthDate(DateUtil.getNowTime());
		return blkListRequestHead;
	}

	public CreditQhApplyBlkListEntity getEntityToSave(
			BlkListRequestHead blkListRequestHead) {
		CreditQhApplyBlkListEntity creditQhBlkListEntity = new CreditQhApplyBlkListEntity();
		creditQhBlkListEntity.setOrgCode(blkListRequestHead.getOrgCode());
		creditQhBlkListEntity.setChnlId(blkListRequestHead.getChnlId());
		creditQhBlkListEntity.setTransNo(blkListRequestHead.getTransNo());
		creditQhBlkListEntity.setTransDate(blkListRequestHead.getTransDate());
		creditQhBlkListEntity.setAuthCode(blkListRequestHead.getAuthCode());
		creditQhBlkListEntity.setAuthDate(blkListRequestHead.getAuthDate());
		return creditQhBlkListEntity;
	}

	/**
	 * 数据解密 并存库
	 * 
	 * @param response
	 * @param entityMap
	 */
	public void deCodeAndSave(BlkListResponseDto response,
			Map<String, CreditQhApplyBlkListEntity> entityMap,
			Map<String, HandleRequest> handleRequestMap,
			Map<HandleRequest, Boolean> reMap) {
		String data = response.getBusiData();
		String signValue = response.getSecurityInfo().getSignatureValue();
		try {
			if (verifyData(data, signValue)) {
				logger.info("###### 业务数据busiData，验签成功");
				String busiDataString = new String(
						DataSecurityUtil.decryptMode(
								ConfigsContant.QIANHAI_3DES_KEY
										.getBytes("utf-8"), DataSecurityUtil
										.decodeBase64(data.getBytes())));
				logger.info("###### 业务数据busiData，解密成功");
				logger.info("###### 业务数据busiData解密后为：" + busiDataString);
				JSONObject jsonObject = JSONObject.fromObject(busiDataString);
				String batchNO = (String) jsonObject.get("batchNo");
				JSONArray recordsJsonStr = (JSONArray) jsonObject
						.get("records");
				List<BlkListResponseBusiDataRecord> responseRecords = new ArrayList<BlkListResponseBusiDataRecord>();
				if (null != recordsJsonStr) {
					for (Object object : recordsJsonStr) {
						JSONObject jsObject = (JSONObject) object;
						BlkListResponseBusiDataRecord a = (BlkListResponseBusiDataRecord) JsonUtil
								.getBean(jsObject,
										BlkListResponseBusiDataRecord.class);
						responseRecords.add(a);
					}
				}
				logger.info("###### 前海数据返回正常，入库操作开始...");
				BlkListResponseBusiData blkListResponseBusiData = new BlkListResponseBusiData();
				blkListResponseBusiData.setBatchNo(batchNO);
				blkListResponseBusiData.setRecords(responseRecords);
				List<CreditBlkgraylistDetailEntity> entitys = new ArrayList<CreditBlkgraylistDetailEntity>();
				blkListValidateAndSave(response, entityMap, handleRequestMap,
						reMap, responseRecords, entitys, signValue);
				logger.info("###### 前海数据存库操作成功！");
				try {
					logger.info("###### 前海命中黑名单数据创建黑灰名单索引数据开始");
					creditBlkgraylistDetailEntityService
							.saveAndCreateIndexs(entitys);
					logger.info("###### 前海命中黑名单数据创建黑灰名单索引数据结束");
				} catch (Exception e) {
					saveEntitysWithException(entityMap,
							QianHaiEnum.EXC_CODE_A0004,
							QianHaiEnum.EXC_CODE_A0004_MSG);
					logger.info("###### transNo【交易流水号】："
							+ response.getHeader().getTransNo() + "，建立索引文件失败。");
					logger.error("###### 失败原因", e);
				}
			} else {
				logger.info("###### transNo【交易流水号】："
						+ response.getHeader().getTransNo() + "，验签失败");
			}
		} catch (Exception e) {
			saveEntitysWithException(entityMap, QianHaiEnum.EXC_CODE_A0005,
					QianHaiEnum.EXC_CODE_A0005_MSG);
			logger.error(e.getMessage(), e);
		}
	}

	/**
	 * 索引原始表，扩展信息<br/>
	 * 导入如下信息项归入扩展信息项：来源：平安前海、金额范围、数据源等级、行业类型、严重等级、业务发生时间、额度策略输出的风险等级。<br/>
	 * 查询严重等级: 1 - 被执行人 3 -逾期31-60天 5 -逾期61-90天 6 -逾期91-180天 7 -违约 9 - 失信被执行人
	 * 
	 * @param creditBlkgraylistDetailEntity
	 * @param record
	 */
	private void setBlkDetailEntityExtInfos(
			CreditQhApplyBlkListEntity creditQhApplyBlkListEntity,
			CreditBlkgraylistDetailEntity creditBlkgraylistDetailEntity,
			BlkListResponseBusiDataRecord record, HandleRequest handleRequest) {
		//必要部分
		creditBlkgraylistDetailEntity.setWarnLevel(0l);//黑名单
		creditBlkgraylistDetailEntity.setChannel(0l);//渠道 ：征信系统
		creditBlkgraylistDetailEntity.setSourceSys(3l);//来源系统0:征信系统,1:小贷系统,2:账务系统,3:平安前海
		String categoryDesc = "外部征信黑名单";
		creditBlkgraylistDetailEntity
				.setCategoryCode(CreditBlkgraylistDetailEntity.BLKGRAY_GATEGORY
						.get(categoryDesc));//名单类别码
		creditBlkgraylistDetailEntity.setCategoryDesc(categoryDesc);//名单类别描述
		creditBlkgraylistDetailEntity.setEnable(0l);//默认正常状态
		
		creditBlkgraylistDetailEntity.setApplyNo(handleRequest.getApplyCode());//申请单号
		creditBlkgraylistDetailEntity.setCustName(handleRequest
				.getCustomerName());//姓名
		creditBlkgraylistDetailEntity.setCustIdnum(handleRequest.getCardNo());//身份证号
		creditBlkgraylistDetailEntity.setCustMobile(handleRequest.getMobile());//本人手机号1
		creditBlkgraylistDetailEntity.setCustMobile2(handleRequest.getBackupMobile());//本人手机号2
		creditBlkgraylistDetailEntity.setCustHomeProvince(handleRequest
				.getAddressProvince());//住宅所在省
		creditBlkgraylistDetailEntity.setCustHomeCity(handleRequest
				.getAddressCity());//住宅所在市
		creditBlkgraylistDetailEntity.setCustHomeDistrict(handleRequest
				.getAddressDistrict());//住宅所在区
		creditBlkgraylistDetailEntity.setCustHomeAddress(handleRequest
				.getAddressDetail());//住宅地址
		creditBlkgraylistDetailEntity.setCustHomePhone(handleRequest
				.getPhone());//住宅电话
		creditBlkgraylistDetailEntity.setCustCorpName(handleRequest
				.getCompanyName());//单位名称
		creditBlkgraylistDetailEntity.setCustCorpAddress(handleRequest
				.getCompanyAddressDetail());//单位地址详细地址
		creditBlkgraylistDetailEntity.setCustCorpPhone(handleRequest
				.getCompanyPhone());//单位电话
		String moneyBoundDesc = "未知金额范围";
		String moneyBound = record.getMoneyBound();
		switch (moneyBound) {
		case "0":
			moneyBoundDesc = "金额范围:无";
			break;
		case "1":
			moneyBoundDesc = "金额范围:0-1000";
			break;
		case "2":
			moneyBoundDesc = "金额范围:1000-5000";
			break;
		case "3":
			moneyBoundDesc = "金额范围:5000-20000";
			break;
		case "4":
			moneyBoundDesc = "金额范围:2w-10w";
			break;
		case "5":
			moneyBoundDesc = "金额范围:10w以上";
			break;
		case "99":
			moneyBoundDesc = "权限不足";
			break;
		default:
			break;
		}
		creditBlkgraylistDetailEntity.setApplyId(creditQhApplyBlkListEntity
				.getId());// 请求记录id
		creditBlkgraylistDetailEntity.setApplyNo(creditQhApplyBlkListEntity
				.getApplyNo());// 请求单号
		creditBlkgraylistDetailEntity.setSeqNo(creditQhApplyBlkListEntity
				.getSeqNo());// 批次唯一号
		creditBlkgraylistDetailEntity.setCreateDate(DateUtil.getFormatDateByyyyyMMddHHmmssFile(new Date()));
		creditBlkgraylistDetailEntity.setCreateUser("zxadmin");
		creditBlkgraylistDetailEntity.setMemo("平安前海黑名单");
		creditBlkgraylistDetailEntity.setExtInfo1("来源：平安前海");
		creditBlkgraylistDetailEntity.setExtInfo2(moneyBoundDesc);
		creditBlkgraylistDetailEntity.setExtInfo3("来源机构-金融机构");
		String queryGrad = record.getGradeQuery();
		String queryGradDesc = "未知严重等级";
		switch (queryGrad) {
		case "3":
			queryGradDesc = "逾期31-60天";
			break;
		case "5":
			queryGradDesc = "逾期61-90天";
			break;
		case "6":
			queryGradDesc = "逾期91-180天";
			break;
		case "7":
			queryGradDesc = "违约";
			break;
		case "9":
			queryGradDesc = "失信被执行人";
			break;
		default:
			break;
		}
		String dataStatus = record.getDataStatus();
		String dataStatusDesc = "未知数据状态";
		switch (dataStatus) {
		case "1":
			dataStatusDesc = "已验证";
			break;
		case "2":
			dataStatusDesc = "未验证";
			break;
		case "99":
			dataStatusDesc = "权限不足";
			break;
		default:
			break;
		}
		creditBlkgraylistDetailEntity.setExtInfo4(queryGradDesc);
		creditBlkgraylistDetailEntity.setExtInfo5(record.getDataBuildTime());
		creditBlkgraylistDetailEntity.setExtInfo6(handleRequest.getRiskLevel());
		creditBlkgraylistDetailEntity.setExtInfo7(dataStatusDesc);
		creditBlkgraylistDetailEntity.setExtInfo8(record.getState());
	}

	/**
	 * 数据验签
	 * 
	 * @param data
	 * @param signValue
	 * @return
	 * @throws Exception
	 */
	public Boolean verifyData(String data, String signValue) throws Exception {
		Boolean flBoolean = false;
		PublicKey publicKey = KeystoreUtil.getPubKey(
				ConfigsContant.QIANHAI_KEYSTORE_PATH,
				ConfigsContant.QIANHAI_KEYSTORE_PWD,
				ConfigsContant.QIANHAI_KEYSTORE_ALIA);
		if (StringUtils.isNotEmpty(signValue)) {
			flBoolean = DataSecurityUtil.verifyData(data, publicKey, signValue);
		}
		return flBoolean;
	}

	/**
	 * 请求异常或响应异常时，保存请求数据和错误信息
	 * 
	 * @param entityMap
	 * @param erroCode
	 * @param erroMsg
	 */
	public void saveEntitysWithException(
			Map<String, CreditQhApplyBlkListEntity> entityMap, String erroCode,
			String erroMsg) {
		for (Entry<String, CreditQhApplyBlkListEntity> entry : entityMap
				.entrySet()) {
			CreditQhApplyBlkListEntity valEntity = entry.getValue();
			valEntity.setExceptionCode(erroCode);
			valEntity.setExceptionMsg(erroMsg);
			valEntity.setCreateDate(new Date());
			valEntity.setCreateUser("zxadmin");
			blkListApplyService.save(valEntity);
		}
	}

	@Override
	public Boolean doExecuteSingleRemoteService(HandleRequest handleRequest) {
		List<HandleRequest> handleRequests = new ArrayList<HandleRequest>();
		if (null != handleRequest) {
			handleRequests.add(handleRequest);
		}
		return doExecuteRemoteService(handleRequests).get(handleRequest);
	}

	private List<CreditBlkgraylistDetailEntity> blkListValidateAndSave(
			BlkListResponseDto response,
			Map<String, CreditQhApplyBlkListEntity> entityMap,
			Map<String, HandleRequest> handleRequestMap,
			Map<HandleRequest, Boolean> reMap,
			List<BlkListResponseBusiDataRecord> responseRecords,
			List<CreditBlkgraylistDetailEntity> entitys, String signValue) {
		for (Entry<String, CreditQhApplyBlkListEntity> entry : entityMap
				.entrySet()) {
			CreditQhApplyBlkListEntity valEntity = entry.getValue();
			String seqNo = valEntity.getSeqNo();
			BlkListResponseHead blkListResponseHead = response.getHeader();
			CreditQhApplyBlkListEntity creditQhApplyBlkListEntity = entityMap
					.get(seqNo);
			creditQhApplyBlkListEntity.setRtCode(blkListResponseHead
					.getRtCode());
			creditQhApplyBlkListEntity.setRtMsg(blkListResponseHead.getRtMsg());
			creditQhApplyBlkListEntity.setSignatureValueRe(signValue);
			creditQhApplyBlkListEntity.setCreateDate(new Date());
			creditQhApplyBlkListEntity.setCreateUser("zxadmin");
			blkListApplyService.save(creditQhApplyBlkListEntity);
			HandleRequest handleRequest = handleRequestMap.get(seqNo);
			BlkListResponseBusiDataRecord blkMostGradeData = getBlkListWithSaveAllRecords(
					creditQhApplyBlkListEntity, seqNo, responseRecords);
			if (null != blkMostGradeData) {// 命中黑名单
				CreditBlkgraylistDetailEntity creditBlkgraylistDetailEntity = new CreditBlkgraylistDetailEntity();
				logger.info("###### 查询条件：" + valEntity.getName() + "|"
						+ valEntity.getIdType() + "|" + valEntity.getIdNo()
						+ "|命中前海外部黑名单");
				reMap.put(handleRequest, true);// 标示请求对象，为命中黑名单
				setBlkDetailEntityExtInfos(creditQhApplyBlkListEntity,
						creditBlkgraylistDetailEntity, blkMostGradeData,
						handleRequest);
				entitys.add(creditBlkgraylistDetailEntity);
			} else {// 未命中黑名单
				logger.info("###### 查询条件：" + valEntity.getName() + "|"
						+ valEntity.getIdType() + "|" + valEntity.getIdNo()
						+ "|未命中前海外部黑名单");
				reMap.put(handleRequest, false);// 标示请求对象，未命中黑名单
			}
		}
		return entitys;
	}

	/**
	 * 获取具有相同seqno 的返回结果集中命中黑名单的数据，并保存所有的返回结果
	 * 
	 * @param seqNo
	 * @param responseRecords
	 * @return
	 */
	private BlkListResponseBusiDataRecord getBlkListWithSaveAllRecords(
			CreditQhApplyBlkListEntity creditQhApplyBlkListEntity,
			String seqNo, List<BlkListResponseBusiDataRecord> responseRecords) {
		BlkListResponseBusiDataRecord returnRecord = null;
		for (BlkListResponseBusiDataRecord record : responseRecords) {
			String gradeQuery = record.getGradeQuery();
			CreditQhBlkListEntity creditQhBlkListEntity = new CreditQhBlkListEntity();
			creditQhBlkListEntity
					.setApplyId(creditQhApplyBlkListEntity.getId());
			creditQhBlkListEntity.setIdNo(creditQhApplyBlkListEntity.getIdNo());
			creditQhBlkListEntity.setIdType(creditQhApplyBlkListEntity
					.getIdType());
			creditQhBlkListEntity.setName(creditQhApplyBlkListEntity.getName());
			creditQhBlkListEntity.setSeqNo(creditQhApplyBlkListEntity
					.getSeqNo());
			creditQhBlkListEntity.setIdNo(creditQhApplyBlkListEntity.getIdNo());
			creditQhBlkListEntity.setSourceId(record.getSourceId());
			creditQhBlkListEntity.setGradeQuery(gradeQuery);
			creditQhBlkListEntity.setMoneyBound(record.getMoneyBound());
			creditQhBlkListEntity.setDataBuildTime(record.getDataBuildTime());
			creditQhBlkListEntity.setState(record.getState());
			creditQhBlkListEntity.setDataStatus(record.getDataStatus());
			creditQhBlkListEntity.setErCode(record.getErCode());
			creditQhBlkListEntity.setErMsg(record.getErMsg());
			creditQhBlkListEntity.setCreateDate(new Date());
			creditQhBlkListEntity.setCreateUser("zxadmin");
			blkListService.save(creditQhBlkListEntity);
			if (seqNo.equals(record.getSeqNo())
					&& StringUtils.isNotEmpty(gradeQuery)
					&& QianHaiEnum.BLKLIST_GRADEQUERY_COL.indexOf(gradeQuery) > -1&&returnRecord==null) {
				returnRecord = record;
			}
		}
		return returnRecord;
	}
}
