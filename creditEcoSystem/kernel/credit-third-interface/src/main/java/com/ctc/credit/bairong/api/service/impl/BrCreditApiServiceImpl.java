package com.ctc.credit.bairong.api.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.bfd.facade.MerchantBean;
import com.bfd.facade.MerchantServer;
import com.ctc.credit.bairong.api.dto.AssetsDto;
import com.ctc.credit.bairong.api.dto.AuthenticationDto;
import com.ctc.credit.bairong.api.dto.BrReportRequestDto;
import com.ctc.credit.bairong.api.dto.BrReportResponseDto;
import com.ctc.credit.bairong.api.dto.DegreeDto;
import com.ctc.credit.bairong.api.dto.RatingDto;
import com.ctc.credit.bairong.api.dto.RuleResultDto;
import com.ctc.credit.bairong.api.dto.ScoreDto;
import com.ctc.credit.bairong.api.dto.SpecialListDto;
import com.ctc.credit.bairong.api.dto.TitleDto;
import com.ctc.credit.bairong.api.dto.account.AccountChangeDto;
import com.ctc.credit.bairong.api.dto.account.AccountTypeDto;
import com.ctc.credit.bairong.api.dto.account.CreditcardDto;
import com.ctc.credit.bairong.api.dto.account.DebitcardDto;
import com.ctc.credit.bairong.api.dto.account.MonthPeriodDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyLoanDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyNoDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyOragnDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyTypeDto;
import com.ctc.credit.bairong.api.dto.applyLoan.MonthDto;
import com.ctc.credit.bairong.api.dto.consumption.ConsumptionDto;
import com.ctc.credit.bairong.api.dto.consumption.EvaluationContentDto;
import com.ctc.credit.bairong.api.dto.consumption.LevelDto;
import com.ctc.credit.bairong.api.dto.consumption.AssessmentDto;
import com.ctc.credit.bairong.api.dto.consumption.CommodityTypeDto;
import com.ctc.credit.bairong.api.dto.flag.FlagDto;
import com.ctc.credit.bairong.api.dto.internet.InternetDto;
import com.ctc.credit.bairong.api.dto.internet.InternetStatisticsDto;
import com.ctc.credit.bairong.api.dto.location.LocationDto;
import com.ctc.credit.bairong.api.dto.media.CommTypeDto;
import com.ctc.credit.bairong.api.dto.media.MediaDto;
import com.ctc.credit.bairong.api.dto.media.PashMonthDto;
import com.ctc.credit.bairong.api.dto.online.NodeOneDto;
import com.ctc.credit.bairong.api.dto.online.NodeTwoDto;
import com.ctc.credit.bairong.api.dto.online.OnlineDto;
import com.ctc.credit.bairong.api.dto.online.OnlineNoDaysDto;
import com.ctc.credit.bairong.api.dto.stabliity.StabilityDto;
import com.ctc.credit.bairong.api.service.BrCreditApiService;
import com.ctc.credit.bairong.constant.ConfigsContant;

import net.sf.json.JSONObject;

/**
 * 百融:客户端API接口实现
 * 
 * @author danggang
 *
 */
@Service
public class BrCreditApiServiceImpl implements BrCreditApiService {

	private static Logger logger = Logger.getLogger(BrCreditApiServiceImpl.class);

	@SuppressWarnings({ "rawtypes", "static-access" })
	@Override
	public BrReportResponseDto getBrUserPortrait(BrReportRequestDto brReportRequestDto) {
		logger.info("----------------BaiRong Login Request Begin------------------------");
		BrReportResponseDto brReportResponseDto = new BrReportResponseDto();
		//1.商户登录			
		try {
			MerchantServer merchantServer = new MerchantServer();
			long start = System.currentTimeMillis();
			String login_result = merchantServer.login(brReportRequestDto.getMerchantName(),brReportRequestDto.getMerchantPwd());
			logger.info("BaiRong Login Service Time：" + (System.currentTimeMillis() - start));
			JSONObject login_json=JSONObject.fromObject(login_result);
			System.out.println("login_json>>>>>>" + login_json);
			String code = login_json.getString(ConfigsContant.CODE);
			switch (code){
				//返回码 code = "00",登录成功,获取登录商户tokenid的值
				case ConfigsContant.SUCCESSFUL_OPERATION:
					String tokenid = login_json.getString(ConfigsContant.TOKENID);					
					logger.info("商户登录成功");
					
					//2.查询报告接口
					
					//设置属性值
					HashMap<String,String> map=new HashMap<String,String>();
					MerchantBean merchantBean=new MerchantBean();
					/**联系人地址**/
					map.put("branch",brReportRequestDto.getLinkmanAddr());
					/**联系人姓名**/
					map.put("fname",brReportRequestDto.getLinkmanName());
					/**登陆唯一标示**/
					merchantBean.setTokenid(tokenid);
					/**百融全局设备标识（需部署百融代码，bfdid）**/
					merchantBean.setGid(brReportRequestDto.getGid());
					/**邮箱**/
					merchantBean.setMail(brReportRequestDto.getMail());
					/**身份证号码**/
					merchantBean.setId(brReportRequestDto.getIdCardNo());
					/**手机号码**/
					merchantBean.setCell(brReportRequestDto.getCell());
					/**客户登陆APP的次数**/
					merchantBean.setApp_visit_num(brReportRequestDto.getAppVisitNum());
					/**家庭地址**/
					merchantBean.setHome_addr(brReportRequestDto.getHomeAddr());
					/**单位电话**/
					merchantBean.setTel_biz(brReportRequestDto.getTelBiz());
					/**家庭电话**/
					merchantBean.setTel_home(brReportRequestDto.getTelHome());
					/**家庭地址**/
					merchantBean.setHome_addr(brReportRequestDto.getHomeAddr());
					/**单位地址**/
					merchantBean.setBiz_addr(brReportRequestDto.getBizAddr());
					/**户籍地址**/
					merchantBean.setPer_addr(brReportRequestDto.getPerAddr());
					/**申请地址**/
					merchantBean.setApply_addr(brReportRequestDto.getApplyAddr());
					/**其他地址**/
					merchantBean.setOth_addr(brReportRequestDto.getOthAddr());
					/**IMEI号(移动应用)**/
					merchantBean.setImei(brReportRequestDto.getImei());
					/**IMSI号(移动应用)**/
					merchantBean.setImsi(brReportRequestDto.getImsi());
					/**手机品牌(移动应用)**/
					merchantBean.setMobile_type(brReportRequestDto.getMobileType());
					/**性别**/
					merchantBean.setSex(brReportRequestDto.getSex());
					/**学历**/
					merchantBean.setEducationallevel(brReportRequestDto.getEducationallevel());
					/**年收入**/
					merchantBean.setIncome(brReportRequestDto.getIncome());
					/**职位**/
					merchantBean.setBiz_positon(brReportRequestDto.getBizPositon());
					/**公司性质**/
					merchantBean.setBiz_type(brReportRequestDto.getBizType());
					/**公司名称**/
					merchantBean.setBiz_workfor(brReportRequestDto.getBizWorkfor());
					/**住房性质*/
					merchantBean.setHouse_type(brReportRequestDto.getHouseType());
					/**邮政编码*/
					merchantBean.setPostalcode(brReportRequestDto.getPostalcode());
					/**申请渠道*/
					merchantBean.setApply_source(brReportRequestDto.getApplySource());
					/**申请产品*/
					merchantBean.setApply_product(brReportRequestDto.getApplyProduct());
					/**申请额度*/
					merchantBean.setApply_money(brReportRequestDto.getApplyMoney());
					/**申请时间*/
					merchantBean.setApply_time(brReportRequestDto.getApplyTime());
					/**申请理由*/
					merchantBean.setLoan_reason(brReportRequestDto.getLoanReason());
					/**银行卡号(信用卡可不提供)*/
					merchantBean.setBank_id(brReportRequestDto.getBankId());
					/**还款期数(信用卡可不提供)*/
					merchantBean.setRefund_periods(brReportRequestDto.getRefundPeriods());;
					/**联系人手机号*/
					merchantBean.setLinkman_cell(brReportRequestDto.getLinkmanCell());
					/**联系人姓名*/
					merchantBean.setLinkman_name(brReportRequestDto.getLinkmanName());
					/**联系人关系*/
					merchantBean.setLinkman_rela(brReportRequestDto.getLinkmanRela());
					/**客户登陆APP的次数*/
					merchantBean.setApp_visit_num(brReportRequestDto.getAppVisitNum());
					/**学历、学籍证明附件数量*/
					merchantBean.setEdu_att_num(brReportRequestDto.getEduAttNum());
					/**银行卡流水附件数量*/
					merchantBean.setBank_running_att_num(brReportRequestDto.getBankRunningAttNum());
					/**姓名**/
					merchantBean.setName(brReportRequestDto.getName());
					/**婚姻状况*/
					merchantBean.setMarriage(brReportRequestDto.getMarriage());
					/**单位所属行业*/
					merchantBean.setBiz_industry(brReportRequestDto.getBizIndustry());
					/**银行卡流水附件数量*/
					merchantBean.setBank_running_att_num(brReportRequestDto.getBankRunningAttNum());
					/**学历、学籍证明附件数量*/
					merchantBean.setEdu_att_num(brReportRequestDto.getEduAttNum());
					merchantBean.setExtData(map);
					long portrait_start = System.currentTimeMillis();
					//调用百融接口
					String portrait_result= merchantServer.getUserPortrait(merchantBean);
					System.out.println("portrait_result" + portrait_result);
					logger.info("BaiRong userPortrait Service Time：" + (System.currentTimeMillis() - portrait_start));
					JSONObject portrait_json=JSONObject.fromObject(portrait_result);
					System.out.println("portrait_json>>>>>>" + portrait_json);
					/*brReportResponseDto = (BrReportResponseDto) JSONObject.toBean(portrait_json,BrReportResponseDto.class);*/
					String portCode = portrait_json.getString(ConfigsContant.CODE);
					String swiftNo = portrait_json.getString(ConfigsContant.SWIFT_NUMBER);
					switch (portCode){
						case ConfigsContant.SUCCESSFUL_OPERATION:
							Iterator keyIter = portrait_json.keys();
							while( keyIter.hasNext()){
								String key = keyIter.next().toString();  
								switch (key){
									/**设置响应标示*/
									case ConfigsContant.CODE:
										break;
									/**报告输出标识*/
									case ConfigsContant.FLAG:
										JSONObject FlagJson = portrait_json.getJSONObject(ConfigsContant.FLAG);
										FlagDto flagDto = (FlagDto) JSONObject.toBean(FlagJson, FlagDto.class);
										flagDto.setSwiftNumber(swiftNo);
										brReportResponseDto.setFlagDto(flagDto);;
										break;
										/**设置流水单号*/
									case ConfigsContant.SWIFT_NUMBER:
										break;
									/**设置身份信息核查*/
									case ConfigsContant.AUTHENTICATION:
										JSONObject authJson = portrait_json.getJSONObject(ConfigsContant.AUTHENTICATION);
										AuthenticationDto authenticationDto = (AuthenticationDto) JSONObject.toBean(authJson, AuthenticationDto.class);
										authenticationDto.setSwiftNumber(swiftNo);								
										brReportResponseDto.setAuthentication(authenticationDto);
										break;
									/**设置网上信息核查*/
									case ConfigsContant.INTERNET:
										JSONObject cityJson = portrait_json.getJSONObject(ConfigsContant.INTERNET).getJSONObject(ConfigsContant.CITY);
										Iterator citys = cityJson.keys();
										List<InternetDto> lists = new ArrayList<InternetDto>();
										while (citys.hasNext()) {
											InternetDto internetDto = new InternetDto();
											internetDto.setSwiftNumber(swiftNo);											
											String city = citys.next().toString();
											internetDto.setCity(city);
											JSONObject o = (JSONObject) cityJson.get(city);
											InternetStatisticsDto internetStatisticsDto = (InternetStatisticsDto) JSONObject.toBean(o, InternetStatisticsDto.class);
											internetDto.setInternetStatisticsDto(internetStatisticsDto);
											lists.add(internetDto);
										}
										brReportResponseDto.setInternets(lists);
										break;
									/**设置位置信息核查*/
									case ConfigsContant.LOCATION:									
										JSONObject locatJson = portrait_json.getJSONObject(ConfigsContant.LOCATION);
										LocationDto locationDao = (LocationDto) JSONObject.toBean(locatJson, LocationDto.class);
										locationDao.setSwiftNumber(swiftNo);
										brReportResponseDto.setLocation(locationDao);
										break;
									/**设置稳定性评估*/
									case ConfigsContant.STABILITY:
										JSONObject stabilityJson = portrait_json.getJSONObject(ConfigsContant.STABILITY);									
										StabilityDto stabilityDto = (StabilityDto) JSONObject.toBean(stabilityJson, StabilityDto.class);
										stabilityDto.setSwiftNumber(swiftNo);										
										brReportResponseDto.setStability(stabilityDto);;
										break;
									/**设置商品消费评估*/
									case ConfigsContant.CONSUMPTION:
										JSONObject consJson = portrait_json.getJSONObject(ConfigsContant.CONSUMPTION);
										ConsumptionDto consumptionDto = new ConsumptionDto();
										consumptionDto.setSwiftNumber(swiftNo);
										List<AssessmentDto> cunsumerLists = new ArrayList<AssessmentDto>();
										Iterator consKeys = consJson.keys();
										while (consKeys.hasNext()){										
											String consKey = consKeys.next().toString();
											AssessmentDto assessmentDto = new AssessmentDto();
											assessmentDto.setAssessmentType(consKey);
											cunsumerLists.add(assessmentDto);											
											JSONObject o = (JSONObject) consJson.get(consKey);
											Iterator oKeys = o.keys();											
											List<CommodityTypeDto> assesslLists = new ArrayList<CommodityTypeDto>();
											List<LevelDto> levelLists = new ArrayList<LevelDto>();
											while (oKeys.hasNext()){
												String okey = oKeys.next().toString();																							
												CommodityTypeDto commodityTypeDto = new CommodityTypeDto();
												commodityTypeDto.setCommodityType(okey);
												assesslLists.add(commodityTypeDto);										
												List<EvaluationContentDto> evaluationLists = new ArrayList<EvaluationContentDto>();
												//判断返回的字符串是否包含json对象
												try {
													JSONObject jsonObject = JSONObject.fromObject(o.get(okey));
													EvaluationContentDto evaluationContentDto = (EvaluationContentDto) JSONObject.toBean(jsonObject, EvaluationContentDto.class);
													evaluationLists.add(evaluationContentDto);
													commodityTypeDto.setEvaluationContentDto((ArrayList<EvaluationContentDto>) evaluationLists);
													assessmentDto.setCommodityTypeDto((ArrayList<CommodityTypeDto>) assesslLists);
												} catch (Exception e) {																										
													LevelDto levelDto = new LevelDto();
													levelDto.setCommodityType(okey);
													levelDto.setLevelRanking(o.getString(okey).toString());
													levelLists.add(levelDto);
													assessmentDto.setLevelDto((ArrayList<LevelDto>) levelLists);
												}	
											}
											consumptionDto.setAssessmentType((ArrayList<AssessmentDto>) cunsumerLists);
											brReportResponseDto.setConsumption(consumptionDto);
										}
										break;

									/**设置申请信息核查*/
									case ConfigsContant.APPLYLOAN:
										JSONObject applyJson = portrait_json.getJSONObject(ConfigsContant.APPLYLOAN);
										ApplyLoanDto applyLoanDto = new ApplyLoanDto();
										applyLoanDto.setSwiftNumber(swiftNo);
										List<MonthDto> applyLists = new ArrayList<MonthDto>();
										Iterator monthKeys = applyJson.keys();										
										while (monthKeys.hasNext()){
											MonthDto monthDto = new MonthDto();
											String monthKey = monthKeys.next().toString();
											monthDto.setMonth(monthKey);
											JSONObject applyTypeJson= (JSONObject) applyJson.get(monthKey);
											List<ApplyTypeDto> applyTypeLists = new ArrayList<ApplyTypeDto>();
											Iterator applyTypeKeys = applyTypeJson.keys();											
											while(applyTypeKeys.hasNext()){																								
												String applyTypeKey = applyTypeKeys.next().toString();
												ApplyTypeDto applyTypeDto = new ApplyTypeDto();
												applyTypeDto.setApplyType(applyTypeKey);
												applyTypeLists.add(applyTypeDto);
												monthDto.setApplyType((ArrayList<ApplyTypeDto>) applyTypeLists);
												JSONObject applyOragnJson= (JSONObject) applyTypeJson.get(applyTypeKey);
												List<ApplyOragnDto> applyOragnLists = new ArrayList<ApplyOragnDto>();
												Iterator applyOragnKeys = applyOragnJson.keys();
												while(applyOragnKeys.hasNext()){
													String applyOragnKey = applyOragnKeys.next().toString();
													ApplyOragnDto applyOragnDto = new ApplyOragnDto();
													applyOragnDto.setApplyOragn(applyOragnKey);
													applyOragnLists.add(applyOragnDto);
													applyTypeDto.setApplyOragn((ArrayList<ApplyOragnDto>) applyOragnLists);
													JSONObject applyNoJson= (JSONObject) applyOragnJson.get(applyOragnKey);
													List<ApplyNoDto> applyNoLists = new ArrayList<ApplyNoDto>();
													ApplyNoDto applyNoDto = (ApplyNoDto) JSONObject.toBean(applyNoJson, ApplyNoDto.class);
													applyNoLists.add(applyNoDto);
													applyOragnDto.setApplyNo((ArrayList<ApplyNoDto>) applyNoLists);
												}
											}
											applyLists.add(monthDto);
										}
										applyLoanDto.setMonthDto((ArrayList<MonthDto>) applyLists);
										brReportResponseDto.setApplyLoan(applyLoanDto);																														
										break;
										/**设置线上行为评估*/
									case ConfigsContant.ONLINE:
										JSONObject onlineJson = portrait_json.getJSONObject(ConfigsContant.ONLINE);
										OnlineDto onlineDto = new OnlineDto();
										onlineDto.setSwiftNumber(swiftNo);
										List<NodeOneDto> nodeOneLists = new ArrayList<NodeOneDto>();
										Iterator onlineKeys = onlineJson.keys();
										while(onlineKeys.hasNext()){
											NodeOneDto nodeOneDto = new NodeOneDto();
											String nodeOneKey = onlineKeys.next().toString();
											nodeOneDto.setNodeOne(nodeOneKey);
											nodeOneLists.add(nodeOneDto);
											onlineDto.setNodeOne((ArrayList<NodeOneDto>) nodeOneLists);
											JSONObject nodeOneJson= (JSONObject) onlineJson.get(nodeOneKey);
											List<NodeTwoDto> nodeTwoLists = new ArrayList<NodeTwoDto>();
											Iterator nodeTwoKeys = nodeOneJson.keys();
											while(nodeTwoKeys.hasNext()){
												NodeTwoDto nodeTwoDto = new NodeTwoDto();
												String nodeTwoKey = nodeTwoKeys.next().toString();
												nodeTwoDto.setNodeTwo(nodeTwoKey);
												nodeTwoLists.add(nodeTwoDto);
												nodeOneDto.setOndeTwo((ArrayList<NodeTwoDto>) nodeTwoLists);
												JSONObject noDaysJson= (JSONObject) nodeOneJson.get(nodeTwoKey);
												List<OnlineNoDaysDto> noDaysLists = new ArrayList<OnlineNoDaysDto>();
												OnlineNoDaysDto onlineNoDaysDto = (OnlineNoDaysDto) JSONObject.toBean(noDaysJson, OnlineNoDaysDto.class);
												noDaysLists.add(onlineNoDaysDto);
												nodeTwoDto.setOnlineNoDays((ArrayList<OnlineNoDaysDto>) noDaysLists);
											}
										}
										brReportResponseDto.setOnline(onlineDto);
										break;
										/**设置特殊名单评估*/
									case ConfigsContant.SPECIALLIST:
										SpecialListDto specialListDto = new SpecialListDto();
										JSONObject speciallistJson = portrait_json.getJSONObject(ConfigsContant.SPECIALLIST);
										Iterator specialKeys = speciallistJson.keys();
										List<DegreeDto> degreeList = new ArrayList<DegreeDto>();
										while (specialKeys.hasNext()) {
											String specialKey = specialKeys.next().toString();
											try{
												JSONObject typeJson = speciallistJson.getJSONObject(specialKey);
												Iterator typeKeys = typeJson.keys();
												while (typeKeys.hasNext()) {
													DegreeDto dto = new DegreeDto();
//													dto.setType(type);
													String detailKey = typeKeys.next().toString();
													JSONObject detailJson = typeJson.getJSONObject(detailKey);
													if(detailJson.toString().indexOf("degree") != -1){
														dto.setDegree(detailJson.get("degree").toString());
													}else if (detailJson.toString().indexOf("number") != -1) {
														dto.setNumber(detailJson.get("number").toString());
													}
													dto.setKey(detailKey);
													dto.setType(specialKey);
													degreeList.add(dto);
												}
											}catch(Exception e){
												
											}
											
										}
										specialListDto.setDegreeList(degreeList);
										specialListDto.setSwiftNo(swiftNo);
										brReportResponseDto.setSpecialList(specialListDto);
										System.out.println("设置特殊名单评估");
										break;
										/**设置百融评分*/
									case ConfigsContant.SCORE:
										ScoreDto scoreDto = new ScoreDto();
										JSONObject scoreJson = portrait_json.getJSONObject(ConfigsContant.SCORE);
										Iterator it = scoreJson.keys();
										while (it.hasNext()) {
											String scoreKey = it.next().toString();
											if(scoreKey.indexOf("br") != -1)
												scoreDto.setBrcreditpoint(scoreJson.get(scoreKey).toString());
										}
										scoreDto.setSwiftNo(swiftNo);
										brReportResponseDto.setScore(scoreDto);
										System.out.println("设置百融评分");
										break;
										/**设置百融策略规则（拒绝规则）*/
									case ConfigsContant.RULERESULT:
//										RuleResultDto ruleResultDto = new RuleResultDto();
//										JSONObject rule = portrait_json.getJSONObject(ConfigsContant.RULERESULT);
//										Iterator ruleKeys = rule.keys();
//										while (ruleKeys.hasNext()) {
//											String ruleKey = (String) ruleKeys.next();
//											ruleResultDto.setR101(rule.get(ruleKey).toString());
//											ruleResultDto = (RuleResultDto) JSONObject.toBean(rule, RuleResultDto.class);
//										}
//										ruleResultDto.setSwiftNo(swiftNo);
//										brReportResponseDto.setRuleResult(ruleResultDto);
//										System.out.println("设置百融策略规则（拒绝规则）");
										break;
										/**设置企业主/高管标示*/
									case ConfigsContant.TITLE:
										TitleDto titleDto = new TitleDto();
										JSONObject titleJson = portrait_json.getJSONObject(ConfigsContant.TITLE);
										if(titleJson != null){
											titleDto.setTitle(titleJson.get("title").toString());
										}
										titleDto.setSwiftNo(swiftNo);
										brReportResponseDto.setTitle(titleDto);
										System.out.println("设置企业主/高管标示");
										break;
										/**设置收支等级评估*/
									case ConfigsContant.ACCOUNTCHANGE:
										JSONObject accountJson = portrait_json.getJSONObject(ConfigsContant.ACCOUNTCHANGE);
										AccountChangeDto accountChangeDto = new AccountChangeDto();
										List<MonthPeriodDto> monthPeriodLists = new ArrayList<MonthPeriodDto>();
										accountChangeDto.setSwiftNumber(swiftNo);								
										Iterator accountKeys = accountJson.keys();
										//过去月份
										while(accountKeys.hasNext()){
											String accountKey = accountKeys.next().toString();
											try {
												JSONObject monthJson = (JSONObject) accountJson.get(accountKey);
												MonthPeriodDto monthPeriodDto = new MonthPeriodDto();
												List<AccountTypeDto> accountTypeLists = new ArrayList<AccountTypeDto>();
												monthPeriodDto.setMonthPeriod(accountKey);
												Iterator keys = monthJson.keys();
												//账户类别
												while(keys.hasNext()){
													AccountTypeDto accountTypeDto = new AccountTypeDto();
													String str = keys.next().toString();
													accountTypeDto.setAccountType(str);
													accountTypeLists.add(accountTypeDto);													
													try {
														JSONObject json = (JSONObject) monthJson.get(str);
														//信用卡
														if (str.indexOf("creditcard") !=-1) {
															Iterator creditKeys = json.keys();
															CreditcardDto creditcardDto = new CreditcardDto();
															while(creditKeys.hasNext()){
																String creditKey = creditKeys.next().toString();
																if (creditKey.indexOf("cash")!= -1) {
																	creditcardDto.setCash(json.get(creditKey).toString());
																} else if(creditKey.indexOf("default") != -1){
																	creditcardDto.setOverdue(json.get(creditKey).toString());
																} else if(creditKey.indexOf("income")!= -1){
																	creditcardDto.setIncome(json.get(creditKey).toString());
																} else if(creditKey.indexOf("outgo")!= -1){
																	creditcardDto.setOutgo(json.get(creditKey).toString());
																} else{
																	creditcardDto.setStatus(json.get(creditKey).toString());
																}
															}
															accountTypeDto.setCreditcard(creditcardDto);
														}
														//储蓄卡
														else {
															DebitcardDto DebitcardDto = (DebitcardDto) JSONObject.toBean(json, DebitcardDto.class);															
															accountTypeDto.setDebitcard(DebitcardDto);
														}
													} catch (Exception e) {
														// 贷款																
														accountTypeDto.setLoan(monthJson.getString(str));
													}											
												}
												monthPeriodDto.setAccountTypeDto((ArrayList<AccountTypeDto>) accountTypeLists);
												monthPeriodLists.add(monthPeriodDto);
											
											} catch (Exception e) {
												// TODO: handle exception
												if (accountKey.indexOf("cardindex")!=-1) {
													accountChangeDto.setCardindex(accountJson.get(accountKey).toString());
												} else {
													accountChangeDto.setRegionno(accountJson.get(accountKey).toString());;
												}
											}											
										}
										accountChangeDto.setMonthPeriodDto((ArrayList<MonthPeriodDto>) monthPeriodLists);
										brReportResponseDto.setAccountChange(accountChangeDto);
										break;								
									/**设置资产评估*/
									case ConfigsContant.ASSETS:
										JSONObject accetsJson = portrait_json.getJSONObject(ConfigsContant.ASSETS);
										AssetsDto assetsDto = (AssetsDto) JSONObject.toBean(accetsJson, AssetsDto.class);
										assetsDto.setSwiftNumber(swiftNo);								
										brReportResponseDto.setAssets(assetsDto);
										break;
										/**设置百融评级*/
									case ConfigsContant.RATING:
										JSONObject ratingJson = portrait_json.getJSONObject(ConfigsContant.RATING);
										RatingDto ratingDto = (RatingDto) JSONObject.toBean(ratingJson, RatingDto.class);
										ratingDto.setSwiftNo(swiftNo);
										brReportResponseDto.setRating(ratingDto);
										System.out.println("设置百融评级");
										break;
										/**设置位置信息核查*/
									
									/**设置媒体阅览评估*/
									case ConfigsContant.MEDIA:
										JSONObject mediaJson = portrait_json.getJSONObject(ConfigsContant.MEDIA);
										MediaDto mediaDto = new MediaDto();
										mediaDto.setSwiftNumber(swiftNo);
										List<PashMonthDto> monthLists = new ArrayList<PashMonthDto>();
										Iterator mediaKeys = mediaJson.keys();
										while(mediaKeys.hasNext()){
											PashMonthDto pashMonthDto = new PashMonthDto();
											String mediaKey = mediaKeys.next().toString();
											pashMonthDto.setMonths(mediaKey);
											monthLists.add(pashMonthDto);
											mediaDto.setMonths((ArrayList<PashMonthDto>) monthLists);
											JSONObject passMonthJson= (JSONObject) mediaJson.get(mediaKey);
											List<CommTypeDto> commLists = new ArrayList<CommTypeDto>();
											Iterator commKeys = passMonthJson.keys();
											while(commKeys.hasNext()){
												CommTypeDto commTypeDto = new CommTypeDto();
												String commodityKey = commKeys.next().toString();
												commTypeDto.setCommTypes(commodityKey);
												JSONObject json = (JSONObject) passMonthJson.get(commodityKey);
												commTypeDto.setVisitdays(json.get("visitdays").toString());
												commLists.add(commTypeDto);
												pashMonthDto.setCommTyps((ArrayList<CommTypeDto>) commLists);
											}
										}
										brReportResponseDto.setMedia(mediaDto);
										break;
									/**设置品牌兴趣评估*/
									case ConfigsContant.BRAND:
										System.out.println("设置品牌兴趣评估");
										break;
									default : 
										break;									
								}
							}							
						default : 
							break; 
					}
					brReportResponseDto.setCode(portCode);
					brReportResponseDto.setSwift_number(swiftNo);
					break;
				//返回码 code = "100004",商户登录密码不正确
				case ConfigsContant. MERCHANTS_NOT_EXIST:
					System.out.println("登录商户不存在");
					break;
				//返回码 code = "100005",商户登录密码不正确
				case ConfigsContant.LOGIN_PASSWORD_ERROR:
					System.out.println("商户登录密码不正确");
					break;	
				default : 
					break; 
			} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info(brReportResponseDto.getAuthentication().getKey_relation());
		logger.info("----------------BaiRong Login Request End------------------------");
		return brReportResponseDto;
	}
	
}