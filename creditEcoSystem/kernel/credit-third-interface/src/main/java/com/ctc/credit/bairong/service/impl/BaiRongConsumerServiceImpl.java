package com.ctc.credit.bairong.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bfd.facade.Apply_source;
import com.bfd.facade.Biz_industry;
import com.bfd.facade.Biz_positon;
import com.bfd.facade.Biz_type;
import com.bfd.facade.Educationallevel;
import com.bfd.facade.House_type;
import com.bfd.facade.Marriage;
import com.ctc.credit.bairong.api.dto.AssetsDto;
import com.ctc.credit.bairong.api.dto.AuthenticationDto;
import com.ctc.credit.bairong.api.dto.BrReportRequestDto;
import com.ctc.credit.bairong.api.dto.BrReportResponseDto;
import com.ctc.credit.bairong.api.dto.HandleBrRequest;
import com.ctc.credit.bairong.api.dto.HandleBrResponse;
import com.ctc.credit.bairong.api.dto.RatingDto;
import com.ctc.credit.bairong.api.dto.RuleResultDto;
import com.ctc.credit.bairong.api.dto.ScoreDto;
import com.ctc.credit.bairong.api.dto.SpecialListDto;
import com.ctc.credit.bairong.api.dto.TitleDto;
import com.ctc.credit.bairong.api.dto.account.AccountChangeDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyLoanDto;
import com.ctc.credit.bairong.api.dto.consumption.ConsumptionDto;
import com.ctc.credit.bairong.api.dto.flag.FlagDto;
import com.ctc.credit.bairong.api.dto.internet.InternetDto;
import com.ctc.credit.bairong.api.dto.location.LocationDto;
import com.ctc.credit.bairong.api.dto.media.MediaDto;
import com.ctc.credit.bairong.api.dto.online.OnlineDto;
import com.ctc.credit.bairong.api.dto.stabliity.StabilityDto;
import com.ctc.credit.bairong.api.service.BrCreditApiService;
import com.ctc.credit.bairong.api.service.impl.BrCreditApiServiceImpl;
import com.ctc.credit.bairong.service.BaiRongConsumerService;
import com.ctc.credit.bairong.service.CreareBrAccoutChangeEntiryService;
import com.ctc.credit.bairong.service.CreareBrMediaEntiryService;
import com.ctc.credit.bairong.service.CreareBrOnlineEntiryService;
import com.ctc.credit.bairong.service.CreareBrRatingService;
import com.ctc.credit.bairong.service.CreareBrRequestEntieyService;
import com.ctc.credit.bairong.service.CreareBrRuleresultService;
import com.ctc.credit.bairong.service.CreareBrScoreService;
import com.ctc.credit.bairong.service.CreareBrSpeciallistService;
import com.ctc.credit.bairong.service.CreareBrTitleService;
import com.ctc.credit.bairong.service.CreateBrApplyLoanEntiryService;
import com.ctc.credit.bairong.service.CreateBrCommodityEntiryService;
import com.ctc.credit.bairong.service.CreditBrAssetsEntiryService;
import com.ctc.credit.bairong.service.CreditBrAuthenticationEntityService;
import com.ctc.credit.bairong.service.CreditBrFlagEntirySerive;
import com.ctc.credit.bairong.service.CreditBrIneternetCityEntiryService;
import com.ctc.credit.bairong.service.CreditBrLocationEntiryService;
import com.ctc.credit.bairong.service.CreditBrStabilityEntiryService;

/**
 * 
 * @author danggang
 *
 */
@Service
@Transactional
public class BaiRongConsumerServiceImpl implements BaiRongConsumerService {

	private static Logger logger = Logger.getLogger(BaiRongConsumerServiceImpl.class);
	 
	@Autowired
	BrCreditApiService brCreditApiService;
	
	@Autowired
	CreditBrAuthenticationEntityService creditBrAuthenticationEntityService;
	
	@Autowired
	CreditBrAssetsEntiryService creditBrAssetsEntiryService;
	
	@Autowired
	CreditBrIneternetCityEntiryService creditBrIneternetCityEntiryService;
	
	@Autowired
	CreditBrFlagEntirySerive creditBrFlagEntirySerive;
	
	@Autowired	
	CreditBrLocationEntiryService creditBrLocationEntiryService;
	
	@Autowired
	CreditBrStabilityEntiryService creditBrStabilityEntiryService;
	
	@Autowired
	CreateBrCommodityEntiryService createBrCommodityEntiryService;
	
	@Autowired
	CreateBrApplyLoanEntiryService createBrApplyLoanEntiryService;
	
	@Autowired
	CreareBrOnlineEntiryService creareBrOnlineEntiryService;
	
	@Autowired
	CreareBrMediaEntiryService creareBrMediaEntiryService;
	 
	@Autowired
	CreareBrAccoutChangeEntiryService creareBrAccoutChangeEntiryService;
	
	@Autowired
	CreareBrRequestEntieyService creareBrRequestEntieyService;
	
	@Autowired
	CreareBrSpeciallistService creareBrSpeciallistService;
	
	@Autowired
	CreareBrScoreService creareBrScoreService;
	
	@Autowired
	CreareBrRatingService creareBrRatingService;
	
	@Autowired
	CreareBrRuleresultService creareBrRuleresultService;
	
	@Autowired
	CreareBrTitleService creareBrTitleService;
	
	@Override
	public String queryUserPortrait(HandleBrRequest handleBrRequest){
		HandleBrResponse resopnse = null;
		BrReportRequestDto brReportRequestDto = new BrReportRequestDto();
		brReportRequestDto.setMerchantName(handleBrRequest.getMerchantName());
		brReportRequestDto.setMerchantPwd(handleBrRequest.getMerchantPwd());
		brReportRequestDto.setGid(handleBrRequest.getGid());
		brReportRequestDto.setMail(handleBrRequest.getMail());
		brReportRequestDto.setIdCardNo(handleBrRequest.getIdCardNo());
		brReportRequestDto.setCell(handleBrRequest.getCell());
		brReportRequestDto.setAppVisitNum(handleBrRequest.getAppVisitNum());
		brReportRequestDto.setHomeAddr(handleBrRequest.getHomeAddr());
		brReportRequestDto.setTelBiz(handleBrRequest.getTelBiz());
		brReportRequestDto.setTelHome(handleBrRequest.getTelHome());
		brReportRequestDto.setHomeAddr(handleBrRequest.getHomeAddr());
		brReportRequestDto.setBizAddr(handleBrRequest.getBizAddr());
		brReportRequestDto.setPerAddr(handleBrRequest.getPerAddr());
		brReportRequestDto.setApplyAddr(handleBrRequest.getApplyAddr());
		brReportRequestDto.setOthAddr(handleBrRequest.getOthAddr());
		brReportRequestDto.setImei(handleBrRequest.getImei());
		brReportRequestDto.setImsi(handleBrRequest.getImsi());
		brReportRequestDto.setMobileType(handleBrRequest.getMobileType());
		brReportRequestDto.setSex(handleBrRequest.getSex());
		if(handleBrRequest.getEducationallevel() != null)
			brReportRequestDto.setEducationallevel(Educationallevel.valueOf(handleBrRequest.getEducationallevel()));
		if(handleBrRequest.getBizPositon() != null)
			brReportRequestDto.setBizPositon(Biz_positon.valueOf(handleBrRequest.getBizPositon()));
		if(handleBrRequest.getBizType() != null)
			brReportRequestDto.setBizType(Biz_type.valueOf(handleBrRequest.getBizType()));
		if(handleBrRequest.getHouseType() != null)
			brReportRequestDto.setHouseType(House_type.valueOf(handleBrRequest.getHouseType()));
		if(handleBrRequest.getMarriage() != null)
			brReportRequestDto.setMarriage(Marriage.valueOf(handleBrRequest.getMarriage()));
		if(handleBrRequest.getBizIndustry() != null)
			brReportRequestDto.setBizIndustry(Biz_industry.valueOf(handleBrRequest.getBizIndustry()));
		if(handleBrRequest.getApplySource() != null)
			brReportRequestDto.setApplySource(Apply_source.valueOf(handleBrRequest.getApplySource()));
		brReportRequestDto.setIncome(handleBrRequest.getIncome());
		brReportRequestDto.setBizWorkfor(handleBrRequest.getBizWorkfor());
		brReportRequestDto.setPostalcode(handleBrRequest.getPostalcode());
		brReportRequestDto.setApplyProduct(handleBrRequest.getApplyProduct());
		brReportRequestDto.setApplyMoney(handleBrRequest.getApplyMoney());
		brReportRequestDto.setApplyTime(handleBrRequest.getApplyTime());
		brReportRequestDto.setLoanReason(handleBrRequest.getLoanReason());
		brReportRequestDto.setBankId(handleBrRequest.getBankId());
		brReportRequestDto.setRefundPeriods(handleBrRequest.getRefundPeriods());
		brReportRequestDto.setLinkmanCell(handleBrRequest.getLinkmanCell());
		brReportRequestDto.setLinkmanName(handleBrRequest.getLinkmanName());
		brReportRequestDto.setLinkmanRela(handleBrRequest.getLinkmanRela());
		brReportRequestDto.setAppVisitNum(handleBrRequest.getAppVisitNum());
		brReportRequestDto.setEduAttNum(handleBrRequest.getEduAttNum());
		brReportRequestDto.setBankRunningAttNum(handleBrRequest.getBankRunningAttNum());
		brReportRequestDto.setName(handleBrRequest.getName());
		brReportRequestDto.setBankRunningAttNum(handleBrRequest.getBankRunningAttNum());
		brReportRequestDto.setEduAttNum(handleBrRequest.getEduAttNum());
		brReportRequestDto.setLinkmanCell(handleBrRequest.getLinkmanName());
		brReportRequestDto.setLinkmanAddr(handleBrRequest.getLinkmanAddr());
		brReportRequestDto.setRequestDate(new Date());
		if (brReportRequestDto != null) {
			creareBrRequestEntieyService.saveRequestInfo(brReportRequestDto);
		}
		//请求百融接口数据 
		BrReportResponseDto brReportResponseDto = brCreditApiService.getBrUserPortrait(brReportRequestDto);
		String jsonStr = JSONObject.fromObject(brReportResponseDto).toString();
		String result = "";
		StringBuffer sb = new StringBuffer();
		//将百融接口返回值按各个节点组织
		AuthenticationDto authenticationDto = brReportResponseDto.getAuthentication();
		if (authenticationDto != null) {
			creditBrAuthenticationEntityService.saveAuthenticationInfo(authenticationDto);
			result = JSONObject.fromObject(authenticationDto).toString();
			sb.append("authenticationDto----" + result + "----end-------");
		}
		
		AssetsDto assetsDto = brReportResponseDto.getAssets();
		if (assetsDto != null) {
			creditBrAssetsEntiryService.saveAssetsInfo(assetsDto);
			result = JSONObject.fromObject(assetsDto).toString();
			sb.append("assetsDto----" + result + "----end-------");
		}
		
		FlagDto flagDto  = brReportResponseDto.getFlagDto();
		if (flagDto != null) {
			creditBrFlagEntirySerive.saveFlagInfo(flagDto);
			result = JSONObject.fromObject(flagDto).toString();
			sb.append("flagDto----" + result + "----end-------");
		}
		
		ArrayList<InternetDto> internetDtos = brReportResponseDto.getInternets();
		if (internetDtos != null) {
			creditBrIneternetCityEntiryService.saveNeternetCityInfo(internetDtos);
//			result = JSONObject.fromObject(internetDtos).toString();
			result = JSONArray.fromObject(internetDtos).toString();
			sb.append("internetDtos----" + result + "----end-------");
		}
		
		LocationDto locationDto = brReportResponseDto.getLocation();
		if (locationDto != null) {
			creditBrLocationEntiryService.saveLocationInfo(locationDto);
			result = JSONObject.fromObject(locationDto).toString();
			sb.append("locationDto----" + result + "----end-------");
		}
		
		StabilityDto stabilityDto = brReportResponseDto.getStability();
		if (stabilityDto != null) {
			creditBrStabilityEntiryService.saveStabilityInfo(stabilityDto);
			result = JSONObject.fromObject(stabilityDto).toString();
			sb.append("stabilityDto----" + result + "----end-------");
		}
		
		ConsumptionDto consumptionDto = brReportResponseDto.getConsumption();
		if (consumptionDto != null) {
			createBrCommodityEntiryService.saveCommodityInfo(consumptionDto);
			result = JSONObject.fromObject(consumptionDto).toString();
			sb.append("consumptionDto----" + result + "----end-------");
		}
		
		ApplyLoanDto applyLoanDto = brReportResponseDto.getApplyLoan();
		if (applyLoanDto != null) {
			createBrApplyLoanEntiryService.saveApplyInfo(applyLoanDto);
			result = JSONObject.fromObject(applyLoanDto).toString();
			sb.append("applyLoanDto----" + result + "----end-------");
		}
		
		OnlineDto onlineDto = brReportResponseDto.getOnline();
		if (onlineDto != null) {
			creareBrOnlineEntiryService.saveOnlineInfo(onlineDto);
			result = JSONObject.fromObject(onlineDto).toString();
			sb.append("onlineDto----" + result + "----end-------");
		}
		
		SpecialListDto specialListDto = brReportResponseDto.getSpecialList();
		if(specialListDto != null){
			creareBrSpeciallistService.saveSpeciallistInfo(specialListDto);
			result = JSONObject.fromObject(specialListDto).toString();
			sb.append("specialListDto----" + result + "----end-------");
		}
		
		ScoreDto scoreDto = brReportResponseDto.getScore();
		if(scoreDto != null){
			creareBrScoreService.saveScoreInfo(scoreDto);
			result = JSONObject.fromObject(scoreDto).toString();
			sb.append("scoreDto----" + result + "----end-------");
		}
		
		RatingDto ratingDto = brReportResponseDto.getRating();
		if(ratingDto != null){
			creareBrRatingService.saveRaingInfo(ratingDto);
			result = JSONObject.fromObject(ratingDto).toString();
			sb.append("ratingDto----" + result + "----end-------");
		}
		
		RuleResultDto ruleResultDto = brReportResponseDto.getRuleResult();
		if(ruleResultDto != null){
			creareBrRuleresultService.saveRuleresultInfo(ruleResultDto);
			result = JSONObject.fromObject(ruleResultDto).toString();
			sb.append("ruleResultDto----" + result + "----end-------");
		}
		
		TitleDto titleDto = brReportResponseDto.getTitle();
		if(titleDto != null){
			creareBrTitleService.saveTitleInfo(titleDto);
			result = JSONObject.fromObject(titleDto).toString();
			sb.append("titleDto----" + result + "----end-------");
		}
		
		MediaDto mediaDto = brReportResponseDto.getMedia();
		if (mediaDto != null) {
			creareBrMediaEntiryService.saveMediaInfo(mediaDto);
			result = JSONObject.fromObject(mediaDto).toString();
			sb.append("mediaDto----" + result + "----end-------");
		}
				
		AccountChangeDto accountChange = brReportResponseDto.getAccountChange();
		if (accountChange != null) {
			creareBrAccoutChangeEntiryService.saveAccoutChangeInfo(accountChange);
			result = JSONObject.fromObject(accountChange).toString();
			sb.append("accountChange----" + result + "----end-------");
		}
		return sb.toString();
		
	}
}

