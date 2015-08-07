package com.ctc.credit.bairong.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.ctc.credit.bairong.api.dto.account.AccountChangeDto;
import com.ctc.credit.bairong.api.dto.applyLoan.ApplyLoanDto;
import com.ctc.credit.bairong.api.dto.consumption.ConsumptionDto;
import com.ctc.credit.bairong.api.dto.flag.FlagDto;
import com.ctc.credit.bairong.api.dto.internet.InternetDto;
import com.ctc.credit.bairong.api.dto.location.LocationDto;
import com.ctc.credit.bairong.api.dto.media.MediaDto;
import com.ctc.credit.bairong.api.dto.online.OnlineDto;
import com.ctc.credit.bairong.api.dto.stabliity.StabilityDto;

public class BrReportResponseDto {

	/** 流水号**/
	private String swift_number;
	/** 报告输出标识**/
	private FlagDto flagDto;
	/** 响应信息**/
	private String code;
	/** 身份信息核查**/
	private AuthenticationDto Authentication;
	/** 身份信息核查**/
	private ArrayList<InternetDto> Internets;
	/** 位置信息核查**/
	private LocationDto Location;
	/** 稳定性评估**/
	private StabilityDto Stability;
	/** 商品消费评估**/
	private ConsumptionDto Consumption;
	/** 申请信息核查**/
	private ApplyLoanDto ApplyLoan;	
	/** 线上行为评估**/
	private OnlineDto Online;
	/** 特殊名单评估**/
	private SpecialListDto SpecialList;
	/** 百融评分**/
	private ScoreDto Score;
	/** 百融评级**/
	private RatingDto Rating;
	/** 百融策略规则（拒绝规则）**/
	private RuleResultDto RuleResult;
	/** 企业主/高管标示）**/
	private TitleDto Title;
	/** 资产评估**/
	private AssetsDto Assets;
	/** 媒体阅览评估**/
	private MediaDto Media;
	/** 收支等级评估**/
	private AccountChangeDto accountChange;
	/** 品牌兴趣评估**/
	private BrandDto Brand;
	public String getSwift_number() {
		return swift_number;
	}
	public void setSwift_number(String swift_number) {
		this.swift_number = swift_number;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	public FlagDto getFlagDto() {
		return flagDto;
	}
	public void setFlagDto(FlagDto flagDto) {
		this.flagDto = flagDto;
	}
	public AuthenticationDto getAuthentication() {
		return Authentication;
	}
	public void setAuthentication(AuthenticationDto authentication) {
		Authentication = authentication;
	}
	
	public ArrayList<InternetDto> getInternets() {
		return Internets;
	}
	public void setInternets(List<InternetDto> lists) {
		Internets = (ArrayList<InternetDto>) lists;
	}
	public LocationDto getLocation() {
		return Location;
	}
	public void setLocation(LocationDto location) {
		Location = location;
	}
	public StabilityDto getStability() {
		return Stability;
	}
	public void setStability(StabilityDto stability) {
		Stability = stability;
	}
	public ConsumptionDto getConsumption() {
		return Consumption;
	}
	public void setConsumption(ConsumptionDto consumption) {
		Consumption = consumption;
	}
	public ApplyLoanDto getApplyLoan() {
		return ApplyLoan;
	}
	public void setApplyLoan(ApplyLoanDto applyLoan) {
		ApplyLoan = applyLoan;
	}
	public OnlineDto getOnline() {
		return Online;
	}
	public void setOnline(OnlineDto online) {
		Online = online;
	}
	public SpecialListDto getSpecialList() {
		return SpecialList;
	}
	public void setSpecialList(SpecialListDto specialList) {
		SpecialList = specialList;
	}
	public ScoreDto getScore() {
		return Score;
	}
	public void setScore(ScoreDto score) {
		Score = score;
	}
	public RatingDto getRating() {
		return Rating;
	}
	public void setRating(RatingDto rating) {
		Rating = rating;
	}
	public RuleResultDto getRuleResult() {
		return RuleResult;
	}
	public void setRuleResult(RuleResultDto ruleResult) {
		RuleResult = ruleResult;
	}
	public TitleDto getTitle() {
		return Title;
	}
	public void setTitle(TitleDto title) {
		Title = title;
	}
	public AssetsDto getAssets() {
		return Assets;
	}
	public void setAssets(AssetsDto assets) {
		Assets = assets;
	}
	public MediaDto getMedia() {
		return Media;
	}
	public void setMedia(MediaDto media) {
		Media = media;
	}
	
	public AccountChangeDto getAccountChange() {
		return accountChange;
	}
	public void setAccountChange(AccountChangeDto accountChange) {
		this.accountChange = accountChange;
	}
	public BrandDto getBrand() {
		return Brand;
	}
	public void setBrand(BrandDto brand) {
		Brand = brand;
	}
	
	
}
