package com.ctc.credit.antifraud.rule;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctc.credit.antifraud.annotation.RuleConfig;
import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.model.HistInfo;
import com.ctc.credit.antifraud.rule.contant.IRuleCategory;
import com.ctc.credit.antifraud.rule.contant.IRuleContant;
import com.ctc.credit.antifraud.service.ContactsInfoService;
import com.ctc.credit.antifraud.service.CustomerInfoService;
import com.ctc.credit.kernel.base.TimeUtil;
import com.ctc.credit.kernel.util.StringUtil;

@Component("iRulesFactory")
public class IRulesFactory {
	
	private static Logger logger = Logger
			.getLogger(IRulesFactory.class);
	
	@Autowired
	private CustomerInfoService customerInfoService;
	
	@Autowired
	private ContactsInfoService contactsInfoService;
	
	/**
	 * 200003</br>
	 * 申请人的入职年月晚于出生年月，但入职年份减去出生年份的差值小于18
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule200003,order=0)
	public IRuleResult rule200003(IFact iFact){
		logger.debug("规则200003执行开始。。。");
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			Date birthDate = customerInfo.getBirthday();
			String curworkdate = customerInfo.getCurWorkStartyear();
			Date curworkDate = TimeUtil.parseDayDate(curworkdate);
			Boolean flg = true;
			if(null==birthDate){
				flg = false;
				logger.debug("rule200003: "+ applyCode + "出生日期为空");
			}
			if(null==curworkDate){
				flg = false;
				logger.debug("rule200003: "+ applyCode + "入职年份空");
			}
			if (flg) {
				long l = TimeUtil.compareDate(curworkDate, birthDate);
				long ys = TimeUtil.calculateYearsBetween(birthDate, curworkDate);
				if (l>0&&ys<18) {
					iRuleResult.setRuleResult(true);
				}
			}
			
		}
		logger.debug("规则200003执结束。");
		return iRuleResult;
	}
	
	/**
	 * 200004</br>
	 * 申请人宅址与单址所在城市不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule200004,order=1)
	public IRuleResult rule200004(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String homeCity = customerInfo.getHomeAddrCity();
			String companyCity = customerInfo.getCompanyAddrCity();
			Boolean flg = true;
			if(StringUtils.isEmpty(homeCity)){
				flg = false;
				logger.debug("rule200002: "+ applyCode + "申请人家庭地址为空");
			}
			if(StringUtils.isEmpty(companyCity)){
				flg = false;
				logger.debug("rule200002: "+ applyCode + "申请人单位地址为空");
			}
			if (flg) {
				if (!StringUtil.equalsWithoutStr(homeCity, companyCity, "市", "")) {
					iRuleResult.setRuleResult(true);
				}
			}
			
		}
		return iRuleResult;
	}
	
	/**
	 * 200005</br>
	 * 申请人的单位电话与其工作证明人的固定电话相同，申请人的工作部门与其工作证明人的工作部门不相同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule200005,order=2)
	public IRuleResult rule200005(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			String comphone = customerInfo.getCompanyPhone();
			String department = customerInfo.getDepartment();
			for (ContactsInfo workProverInfo : workProverInfos) {
				String workProverComphone = workProverInfo.getCompanyPhone();
				String workProverDepartment = workProverInfo.getDepartment();
				Boolean flg = true;
				if(StringUtils.isEmpty(comphone)){
					flg = false;
					logger.debug("rule200005: "+ applyCode + "申请人单位电话为空");
				}
				if(StringUtils.isEmpty(department)){
					flg = false;
					logger.debug("rule200005: "+ applyCode + "申请人的工作部门为空");
				}
				if(StringUtils.isEmpty(workProverComphone)){
					flg = false;
					logger.debug("rule200005: "+ applyCode + "工作证明人单位电话为空");
				}
				if(StringUtils.isEmpty(workProverDepartment)){
					flg = false;
					logger.debug("rule200005: "+ applyCode + "工作证明人部门为空");
				}
				if (flg) {
					if (comphone.equals(workProverComphone)&&!department.equals(workProverDepartment)) {
						iRuleResult.setRuleResult(true);
					}
				}
				return iRuleResult;
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 200006</br>
	 * 信薪贷、信优贷产品借款人可认定工资大于20000
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule200006,order=3)
	public IRuleResult rule200006(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String productCode =  customerInfo.getApplyProductCode();
			Integer approveIncome =  customerInfo.getApproveIncome();
			Boolean flg = true;
			if(StringUtils.isEmpty(productCode)){
				flg = false;
				logger.debug("rule200006: "+ applyCode + "申请人申请产品代码为空");
			}
			if(null==approveIncome){
				flg = false;
				logger.debug("rule200006: "+ applyCode + "申请人可认定工资为空");
			}
			if (flg) {
				if (IRuleContant.XXD_XYD_CODES.indexOf(productCode)>-1&&approveIncome>20000) {
					iRuleResult.setRuleResult(true);
				}
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 200025</br>
	 * 申请人身份证号码的倒数第二位与其配偶身份证号码的倒数第二位（性别校验码）同为奇数或同为偶数
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule200025,order=4)
	public IRuleResult rule200025(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String spouseIdno = customerInfo.getSpouseIdno();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule200025: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(spouseIdno)){
				flg = false;
				logger.debug("rule200025: "+ applyCode + "申请人配偶证件号码为空");
			}
			String sexNum = null;
			String spsexNum = null;
			try {
				sexNum = idcard.substring(16, 17);
				spsexNum = spouseIdno.substring(16, 17);
			} catch (Exception e) {
				flg = false;
			}
			if(null==sexNum||null==spsexNum){
				flg = false;
			}
			if (flg) {
				if ((new Integer(sexNum)%2)==(new Integer(spsexNum)%2)) {
					iRuleResult.setRuleResult(true);
				}
			}
			
		}
		return iRuleResult;
	}
	
	/**
	 * 300001</br>
	 * 证件号码不同，申请人手机号码与系统中已有申请人手机号码相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300001,order=5)
	public IRuleResult rule300001(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300001: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300001: "+ applyCode + "申请人手机号为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300001(idcard, mobile,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300002</br>
	 * 证件号码不同，申请人电子邮箱与系统中已有申请人电子邮箱相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300002,order=6)
	public IRuleResult rule300002(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String email = customerInfo.getEmailAddress();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300002: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(email)){
				flg = false;
				logger.debug("rule300002: "+ applyCode + "申请人邮箱为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300002(idcard, email,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	
	/**
	 * 300003</br>
	 * 180天内，证件号码不同，工作证明人姓名不同，工作证明人手机号码相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300003,order=7)
	public IRuleResult rule300003(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> workProverNames = new ArrayList<String>();
			List<String> workProverMobiles = new ArrayList<String>();
			for (ContactsInfo workProverInfo : workProverInfos) {
				Boolean flg = true;
				String workProverName = workProverInfo.getName();
				String workProverMobile = workProverInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300003: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(workProverName)){
					flg = false;
					logger.debug("rule300003: "+ applyCode + "工作证明人姓名为空");
				}
				if(StringUtils.isEmpty(workProverMobile)){
					flg = false;
					logger.debug("rule300003: "+ applyCode + "工作证明手机号为空");
				}
				if (flg) {
					flgAll = true;
					workProverNames.add(workProverName);
					workProverMobiles.add(workProverMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300003(idcard, workProverNames,workProverMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300004</br>
	 * 一年内，证件号码不同，工作证明人手机号码相同，且大于等于3
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300004,order=8)
	public IRuleResult rule300004(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			String idcard = customerInfo.getIdcard();
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			List<String> workProverMobiles = new ArrayList<String>();
			for (ContactsInfo workProverInfo : workProverInfos) {
				String workProverMobile = workProverInfo.getMobile();
				Boolean flg = true;
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300004: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(workProverMobile)){
					flg = false;
					logger.debug("rule300004: "+ applyCode + "工作证明手机号为空");
				}
				if (flg) {
					flgAll = true;
					workProverMobiles.add(workProverMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300004(idcard,workProverMobiles,applyCode);
			}
			if (appCodes.size()>=3) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300005</br>
	 * 180天内，证件号码不同，申请人单电和系统中已有申请人宅电相同，且单位名称不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300005,order=9)
	public IRuleResult rule300005(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyPhone = customerInfo.getCompanyPhone();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300005: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300005: "+ applyCode + "申请人单位电话为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300005: "+ applyCode + "申请人单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300005(idcard,companyPhone,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300006</br>
	 * 180天内，证件号码不同，家庭联系人姓名不同，家庭联系人手机号码相同，且大于等于1【家庭联系人包括配偶】
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300006,order=10)
	public IRuleResult rule300006(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> familyerInfos = iFact.getFamilyContactsInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=familyerInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> familyerNames = new ArrayList<String>();
			List<String> familyerMobiles = new ArrayList<String>();
			for (ContactsInfo familyerInfo : familyerInfos) {
				Boolean flg = true;
				String familyerName = familyerInfo.getName();
				String familyerMobile = familyerInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300006: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(familyerName)){
					flg = false;
					logger.debug("rule300006: "+ applyCode + "家庭联系人姓名为空");
				}
				if(StringUtils.isEmpty(familyerMobile)){
					flg = false;
					logger.debug("rule300006: "+ applyCode + "家庭联系人手机号为空");
				}
				if (flg) {
					flgAll = true;
					familyerNames.add(familyerName);
					familyerMobiles.add(familyerMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300006(idcard, familyerNames,familyerMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300007</br>
	 * 一年内，证件号码不同，家庭联系人手机号码相同，且大于等于3
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300007,order=11)
	public IRuleResult rule300007(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> familyerInfos = iFact.getFamilyContactsInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=familyerInfos) {
			String idcard = customerInfo.getIdcard();
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			List<String> familyerMobiles = new ArrayList<String>();
			for (ContactsInfo familyerInfo : familyerInfos) {
				String familyerMobile = familyerInfo.getMobile();
				Boolean flg = true;
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300007: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(familyerMobile)){
					flg = false;
					logger.debug("rule300007: "+ applyCode + "家庭联系人手机号码为空");
				}
				if (flg) {
					flgAll = true;
					familyerMobiles.add(familyerMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300007(idcard,familyerMobiles,applyCode);
			}
			if (appCodes.size()>=3) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300009</br>
	 * 180天内，证件号码不同，其他联系人姓名不同，其他联系人手机号码相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300009,order=12)
	public IRuleResult rule300009(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> otherLinkManInfos = iFact.getOtherLinkManInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=otherLinkManInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> otherLinkManNames = new ArrayList<String>();
			List<String> otherLinkManMobiles = new ArrayList<String>();
			for (ContactsInfo otherLinkManInfo : otherLinkManInfos) {
				Boolean flg = true;
				String otherLinkManName = otherLinkManInfo.getName();
				String otherLinkManMobile = otherLinkManInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300009: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(otherLinkManName)){
					flg = false;
					logger.debug("rule300009: "+ applyCode + "其他联系人姓名为空");
				}
				if(StringUtils.isEmpty(otherLinkManMobile)){
					flg = false;
					logger.debug("rule300009: "+ applyCode + "其他联系人手机号码为空");
				}
				if (flg) {
					flgAll = true;
					otherLinkManNames.add(otherLinkManName);
					otherLinkManMobiles.add(otherLinkManMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300009(idcard, otherLinkManNames,otherLinkManMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300010</br>
	 * 一年内，证件号码不同，其他联系人手机号码相同，且大于等于3
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300010,order=13)
	public IRuleResult rule300010(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> otherLinkManInfos = iFact.getOtherLinkManInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=otherLinkManInfos) {
			String idcard = customerInfo.getIdcard();
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			List<String> otherLinkManMobiles = new ArrayList<String>();
			for (ContactsInfo otherLinkManInfo : otherLinkManInfos) {
				String otherLinkManMobile = otherLinkManInfo.getMobile();
				Boolean flg = true;
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300010: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(otherLinkManMobile)){
					flg = false;
					logger.debug("rule300010: "+ applyCode + "其他联系人手机号码为空");
				}
				if (flg) {
					flgAll = true;
					otherLinkManMobiles.add(otherLinkManMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300010(idcard,otherLinkManMobiles,applyCode);
			}
			if (appCodes.size()>=3) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300012</br>
	 * 证件号码不同，申请人的工作证明人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300012,order=14)
	public IRuleResult rule300012(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> workProverNames = new ArrayList<String>();
			List<String> workProverMobiles = new ArrayList<String>();
			for (ContactsInfo workProverInfo : workProverInfos) {
				Boolean flg = true;
				String workProverName = workProverInfo.getName();
				String workProverMobile = workProverInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300012: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(workProverName)){
					flg = false;
					logger.debug("rule300012: "+ applyCode + "工作证明人姓名为空");
				}
				if(StringUtils.isEmpty(workProverMobile)){
					flg = false;
					logger.debug("rule300012: "+ applyCode + "工作证明手机号为空");
				}
				if (flg) {
					flgAll = true;
					workProverNames.add(workProverName);
					workProverMobiles.add(workProverMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300012(idcard, workProverNames,workProverMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300013</br>
	 * 证件号码不同，申请人的工作证明人手机号码与系统中已有申请人的其他联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300013,order=15)
	public IRuleResult rule300013(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> workProverNames = new ArrayList<String>();
			List<String> workProverMobiles = new ArrayList<String>();
			for (ContactsInfo workProverInfo : workProverInfos) {
				Boolean flg = true;
				String workProverName = workProverInfo.getName();
				String workProverMobile = workProverInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300013: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(workProverName)){
					flg = false;
					logger.debug("rule300013: "+ applyCode + "工作证明人姓名为空");
				}
				if(StringUtils.isEmpty(workProverMobile)){
					flg = false;
					logger.debug("rule300013: "+ applyCode + "工作证明手机号为空");
				}
				if (flg) {
					flgAll = true;
					workProverNames.add(workProverName);
					workProverMobiles.add(workProverMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300013(idcard, workProverNames,workProverMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300014</br>
	 * 证件号码不同，申请人的家庭联系人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300014,order=16)
	public IRuleResult rule300014(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> familyerInfos = iFact.getFamilyContactsInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=familyerInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> familyerNames = new ArrayList<String>();
			List<String> familyerMobiles = new ArrayList<String>();
			for (ContactsInfo familyerInfo : familyerInfos) {
				Boolean flg = true;
				String familyerName = familyerInfo.getName();
				String familyerMobile = familyerInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300014: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(familyerName)){
					flg = false;
					logger.debug("rule300014: "+ applyCode + "家庭联系人姓名为空");
				}
				if(StringUtils.isEmpty(familyerMobile)){
					flg = false;
					logger.debug("rule300014: "+ applyCode + "家庭联系人手机号为空");
				}
				if (flg) {
					flgAll = true;
					familyerNames.add(familyerName);
					familyerMobiles.add(familyerMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300014(idcard, familyerNames,familyerMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300015</br>
	 * 证件号码不同，申请人的家庭联系人手机号码与系统中已有申请人的其他联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300015,order=17)
	public IRuleResult rule300015(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> familyerInfos = iFact.getFamilyContactsInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=familyerInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> familyerNames = new ArrayList<String>();
			List<String> familyerMobiles = new ArrayList<String>();
			for (ContactsInfo familyerInfo : familyerInfos) {
				Boolean flg = true;
				String familyerName = familyerInfo.getName();
				String familyerMobile = familyerInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300015: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(familyerName)){
					flg = false;
					logger.debug("rule300015: "+ applyCode + "家庭联系人姓名为空");
				}
				if(StringUtils.isEmpty(familyerMobile)){
					flg = false;
					logger.debug("rule300015: "+ applyCode + "家庭联系人手机号为空");
				}
				if (flg) {
					flgAll = true;
					familyerNames.add(familyerName);
					familyerMobiles.add(familyerMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300015(idcard, familyerNames,familyerMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300016</br>
	 * 证件号码不同，申请人的其他联系人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300016,order=18)
	public IRuleResult rule300016(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> otherLinkManInfos = iFact.getOtherLinkManInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=otherLinkManInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> otherLinkManNames = new ArrayList<String>();
			List<String> otherLinkManMobiles = new ArrayList<String>();
			for (ContactsInfo otherLinkManInfo : otherLinkManInfos) {
				Boolean flg = true;
				String otherLinkManName = otherLinkManInfo.getName();
				String otherLinkManMobile = otherLinkManInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300016: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(otherLinkManName)){
					flg = false;
					logger.debug("rule300016: "+ applyCode + "其他联系人姓名为空");
				}
				if(StringUtils.isEmpty(otherLinkManMobile)){
					flg = false;
					logger.debug("rule300016: "+ applyCode + "其他联系人手机号码为空");
				}
				if (flg) {
					flgAll = true;
					otherLinkManNames.add(otherLinkManName);
					otherLinkManMobiles.add(otherLinkManMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300016(idcard, otherLinkManNames,otherLinkManMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300017</br>
	 * 证件号码不同，申请人的其他联系人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300017,order=19)
	public IRuleResult rule300017(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> otherLinkManInfos = iFact.getOtherLinkManInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=otherLinkManInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			String idcard = customerInfo.getIdcard();
			List<String> otherLinkManNames = new ArrayList<String>();
			List<String> otherLinkManMobiles = new ArrayList<String>();
			for (ContactsInfo otherLinkManInfo : otherLinkManInfos) {
				Boolean flg = true;
				String otherLinkManName = otherLinkManInfo.getName();
				String otherLinkManMobile = otherLinkManInfo.getMobile();
				if(StringUtils.isEmpty(idcard)){
					flg = false;
					logger.debug("rule300016: "+ applyCode + "申请人证件号码为空");
				}
				if(StringUtils.isEmpty(otherLinkManName)){
					flg = false;
					logger.debug("rule300016: "+ applyCode + "其他联系人姓名为空");
				}
				if(StringUtils.isEmpty(otherLinkManMobile)){
					flg = false;
					logger.debug("rule300016: "+ applyCode + "其他联系人手机号码为空");
				}
				if (flg) {
					flgAll = true;
					otherLinkManNames.add(otherLinkManName);
					otherLinkManMobiles.add(otherLinkManMobile);
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300017(idcard, otherLinkManNames,otherLinkManMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300018</br>
	 * 一年内，证件号码相同，本次进件手机号码、单位电话和住宅电话与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300018,order=20)
	public IRuleResult rule300018(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String companyPhone = customerInfo.getCompanyPhone();
			String homePhone = customerInfo.getHomePhone();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300018: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300018: "+ applyCode + "申请人的手机号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300018: "+ applyCode + "申请人单位电话为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300018: "+ applyCode + "申请人住宅电话为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300018(idcard, mobile,companyPhone,homePhone,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300022</br>
	 * 一年内，证件号码相同，本次进件手机号码、单位电话与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300022,order=21)
	public IRuleResult rule300022(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String companyPhone = customerInfo.getCompanyPhone();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300022: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300022: "+ applyCode + "申请人的手机号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300022: "+ applyCode + "申请人单位电话为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300022(idcard, mobile,companyPhone,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300023</br>
	 * 一年内，证件号码相同，本次进件手机号码、住宅电话与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300023,order=22)
	public IRuleResult rule300023(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String homePhone = customerInfo.getHomePhone();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300023: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300023: "+ applyCode + "申请人的手机号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300023: "+ applyCode + "申请人住宅电话为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300023(idcard, mobile,homePhone,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300025</br>
	 * 一年内，证件号码相同，本次进件手机号码、单位名称与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300025,order=23)
	public IRuleResult rule300025(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String companyName = customerInfo.getCompanyName();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300023: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300023: "+ applyCode + "申请人的手机号码为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300023: "+ applyCode + "申请单位名称为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300025(idcard, mobile,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300026</br>
	 * 一年内，证件号码相同，本次进件手机号码、单位地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300026,order=24)
	public IRuleResult rule300026(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String companyAddresss = customerInfo.getCompanyAddresss();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300026: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300026: "+ applyCode + "申请人的手机号码为空");
			}
			if(StringUtils.isEmpty(companyAddresss)){
				flg = false;
				logger.debug("rule300026: "+ applyCode + "单位地址为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300026(idcard, mobile,companyAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	
	/**
	 * 300027</br>
	 * 一年内，证件号码相同，本次进件手机号码、住宅地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300027,order=25)
	public IRuleResult rule300027(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String homeAddresss = customerInfo.getHomeAddresss();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300027: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300026: "+ applyCode + "申请人的手机号码为空");
			}
			if(StringUtils.isEmpty(homeAddresss)){
				flg = false;
				logger.debug("rule300027: "+ applyCode + "住宅地址为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300027(idcard, mobile,homeAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300028</br>
	 * 证件号码不同，申请人的房产地址与系统中已有申请人的房产地址相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300028,order=26)
	public IRuleResult rule300028(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String housingAddresss = customerInfo.getHousingAddresss();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300028: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(housingAddresss)){
				flg = false;
				logger.debug("rule300028: "+ applyCode + "房产地址为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300028(idcard, housingAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300029</br>
	 * 一年内，证件号码相同，本次进件住宅电话、住宅地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300029,order=27)
	public IRuleResult rule300029(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homePhone = customerInfo.getHomePhone();
			String homeAddresss = customerInfo.getHomeAddresss();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300029: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300029: "+ applyCode + "申请人的住宅电话为空");
			}
			if(StringUtils.isEmpty(homeAddresss)){
				flg = false;
				logger.debug("rule300029: "+ applyCode + "住宅地址为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300029(idcard, homePhone,homeAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	
	/**
	 * 300030</br>
	 * 一年内，证件号码相同，本次进件住宅电话、单位名称与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300030,order=28)
	public IRuleResult rule300030(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homePhone = customerInfo.getHomePhone();
			String companyName = customerInfo.getCompanyName();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300030: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300030: "+ applyCode + "申请人的住宅电话为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300030: "+ applyCode + "单位名称为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300030(idcard, homePhone,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300031</br>
	 * 一年内，证件号码相同，本次进件住宅电话、单位电话与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300031,order=29)
	public IRuleResult rule300031(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homePhone = customerInfo.getHomePhone();
			String companyPhone = customerInfo.getCompanyPhone();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300031: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300031: "+ applyCode + "申请人的住宅电话为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300031: "+ applyCode + "单位电话为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300031(idcard, homePhone,companyPhone,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300032</br>
	 * 180天内，证件号码不同，申请人宅电和系统中已有申请人单电相同，且单位名称不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300032,order=30)
	public IRuleResult rule300032(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homePhone = customerInfo.getHomePhone();
			String companyName = customerInfo.getCompanyName();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300032: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300032: "+ applyCode + "申请人的住宅电话为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300032: "+ applyCode + "单位名称为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300032(idcard, homePhone,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300033</br>
	 * 证件号码不同，单位电话相同，单位名称前八个字不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300033,order=31)
	public IRuleResult rule300033(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyPhone = customerInfo.getCompanyPhone();
			String companyName = customerInfo.getCompanyName();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300033: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300033: "+ applyCode + "申请人的单位电话为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300033: "+ applyCode + "单位名称为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300033(idcard, companyPhone,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300034</br>
	 * 证件号码不同，住宅电话相同，住宅地址不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300034,order=32)
	public IRuleResult rule300034(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homePhone = customerInfo.getHomePhone();
			String homeAddresss = customerInfo.getHomeAddresss();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300034: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300034: "+ applyCode + "申请人的住宅电话为空");
			}
			if(StringUtils.isEmpty(homeAddresss)){
				flg = false;
				logger.debug("rule300034: "+ applyCode + "申请人住宅地址为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300034(idcard, homePhone,homeAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300035</br>
	 * 证件号码不同，住宅地址相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300035,order=33)
	public IRuleResult rule300035(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homeAddresss = customerInfo.getHomeAddresss();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300035: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homeAddresss)){
				flg = false;
				logger.debug("rule300035: "+ applyCode + "申请人住宅地址为空");
			}
			if(flg){
				appCodes = customerInfoService.checkRule300035(idcard,homeAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	} 
	
	/**
	 * 300036</br>
	 * 证件号码不同，单位电话相同，工作证明人单位电话相同，且大于等于2
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300036,order=34)
	public IRuleResult rule300036(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			Boolean flgAll = false;//是否需要查询数据库，默认不需要
			Boolean flg1 = true;//是否需要遍历证明人的标识默认需要
			String idcard = customerInfo.getIdcard();
			String companyPhone = customerInfo.getCompanyPhone();
			if(StringUtils.isEmpty(idcard)){
				flg1 = false;
				logger.debug("rule300036: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg1 = false;
				logger.debug("rule300036: "+ applyCode + "申请人单位电话为空");
			}
			List<String> workProverPhones = new ArrayList<String>();
			if (flg1) {
				for (ContactsInfo workProverInfo : workProverInfos) {
					Boolean flg = true;//是否需要将证明人电话加入默认加入
					String workProverPhone = workProverInfo.getCompanyPhone();
					if(StringUtils.isEmpty(workProverPhone)){
						flg = false;
						logger.debug("rule300036: "+ applyCode + "工作证明人单位电话为空");
					}
					if (flg) {
						flgAll = true;
						workProverPhones.add(workProverPhone);
					}
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300036(idcard, companyPhone,workProverPhones,applyCode);
			}
			if (appCodes.size()>=2) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	} 
	
	
	/**
	 * 300037</br>
	 * 证件号码不同，住宅电话相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300037,order=35)
	public IRuleResult rule300037(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			Boolean flgAll = true;//是否需要查询数据库，默认需要
			String idcard = customerInfo.getIdcard();
			String homePhone = customerInfo.getHomePhone();
			if(StringUtils.isEmpty(idcard)){
				flgAll = false;
				logger.debug("rule300037: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flgAll = false;
				logger.debug("rule300037: "+ applyCode + "申请人住宅电话为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300037(idcard, homePhone,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	} 
	
	/**
	 * 300038</br>
	 * 证件号码不同，工作证明人手机号码相同，单位名称前八个字不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300038,order=36)
	public IRuleResult rule300038(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		if (null!=customerInfo&&null!=workProverInfos) {
			String idcard = customerInfo.getIdcard();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300038: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300038: "+ applyCode + "单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			List<String> workProverMobiles = new ArrayList<String>();
			for (ContactsInfo workProver : workProverInfos) {
				Boolean flg1 = true;
				String workProverMobile = workProver.getMobile();
				if(StringUtils.isEmpty(workProverMobile)){
					flg1 = false;
					logger.debug("rule300038: "+ applyCode + "工作证明人手机号码为空");
				}
				if(flg1){
					workProverMobiles.add(workProverMobile);
				}
			}
			if(flg){
				appCodes = customerInfoService.checkRule300038(idcard,companyName,workProverMobiles,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300039</br>
	 * 证件号码不同，申请人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300039,order=37)
	public IRuleResult rule300039(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String name = customerInfo.getName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300039: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300039: "+ applyCode + "申请人手机号码为空");
			}
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300039: "+ applyCode + "申请人姓名为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300039(idcard,mobile,name,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300040</br>
	 * 证件号码不同，申请人手机号码与系统中已有申请人的其它联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300040,order=38)
	public IRuleResult rule300040(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String name = customerInfo.getName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300040: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300040: "+ applyCode + "申请人手机号码为空");
			}
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300040: "+ applyCode + "申请人姓名为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300040(idcard,mobile,name,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300041</br>
	 * 证件号码不同，申请人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300041,order=39)
	public IRuleResult rule300041(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String name = customerInfo.getName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300041: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300041: "+ applyCode + "申请人手机号码为空");
			}
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300041: "+ applyCode + "申请人姓名为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300041(idcard,mobile,name,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300042</br>
	 * 一年内，证件号码相同，本次进件住宅电话、单位地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300042,order=40)
	public IRuleResult rule300042(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homePhone = customerInfo.getHomePhone();
			String companyAddresss = customerInfo.getCompanyAddresss();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300042: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homePhone)){
				flg = false;
				logger.debug("rule300042: "+ applyCode + "住宅电话为空");
			}
			if(StringUtils.isEmpty(companyAddresss)){
				flg = false;
				logger.debug("rule300042: "+ applyCode + "单位地址为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300042(idcard,homePhone,companyAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300043</br>
	 * 一年内，证件号码相同，本次进件单位电话、住宅地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300043,order=41)
	public IRuleResult rule300043(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyPhone = customerInfo.getCompanyPhone();
			String homeAddresss = customerInfo.getHomeAddresss();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300043: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300043: "+ applyCode + "单位电话为空");
			}
			if(StringUtils.isEmpty(homeAddresss)){
				flg = false;
				logger.debug("rule300043: "+ applyCode + "住宅地址为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300043(idcard,companyPhone,homeAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300044</br>
	 * 一年内，证件号码相同，本次进件单位电话、单位名称与前次进件均不同【 这里的单位名称要精确匹配】
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300044,order=42)
	public IRuleResult rule300044(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyPhone = customerInfo.getCompanyPhone();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300044: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300044: "+ applyCode + "单位电话为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300044: "+ applyCode + "单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300044(idcard,companyPhone,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300045</br>
	 * 一年内，证件号码相同，本次进件单位电话、单位地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300045,order=43)
	public IRuleResult rule300045(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyPhone = customerInfo.getCompanyPhone();
			String companyAddresss = customerInfo.getCompanyAddresss();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300045: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule300045: "+ applyCode + "单位电话为空");
			}
			if(StringUtils.isEmpty(companyAddresss)){
				flg = false;
				logger.debug("rule300045: "+ applyCode + "单位地址为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300045(idcard,companyPhone,companyAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300046</br>
	 * 一年内，证件号码相同，本次进件住宅地址、单位名称与前次进件均不同 【这里的单位名称要精确匹配】
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300046,order=44)
	public IRuleResult rule300046(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homeAddresss = customerInfo.getHomeAddresss();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300046: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homeAddresss)){
				flg = false;
				logger.debug("rule300046: "+ applyCode + "住宅地址为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300046: "+ applyCode + "单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300046(idcard,homeAddresss,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300047</br>
	 * 一年内，证件号码相同，本次进件住宅地址、单位地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300047,order=45)
	public IRuleResult rule300047(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String homeAddresss = customerInfo.getHomeAddresss();
			String companyAddresss = customerInfo.getCompanyAddresss();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300047: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(homeAddresss)){
				flg = false;
				logger.debug("rule300047: "+ applyCode + "住宅地址为空");
			}
			if(StringUtils.isEmpty(companyAddresss)){
				flg = false;
				logger.debug("rule300047: "+ applyCode + "单位地址为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300047(idcard,homeAddresss,companyAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300048</br>
	 * 一年内，证件号码相同，本次进件单位名称、单位地址与前次进件均不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300048,order=46)
	public IRuleResult rule300048(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyName = customerInfo.getCompanyName();
			String companyAddresss = customerInfo.getCompanyAddresss();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300048: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300048: "+ applyCode + "单位名称为空");
			}
			if(StringUtils.isEmpty(companyAddresss)){
				flg = false;
				logger.debug("rule300048: "+ applyCode + "单位地址为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300048(idcard,companyName,companyAddresss,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300049</br>
	 * 证件号码不同，申请人的配偶身份证号码与系统中已有申请人的配偶身份证号码相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300049,order=47)
	public IRuleResult rule300049(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String spouseIdno = customerInfo.getSpouseIdno();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300049: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(spouseIdno)){
				flg = false;
				logger.debug("rule300049: "+ applyCode + "配偶身份证号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300049(idcard,spouseIdno,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300050</br>
	 * 证件号码不同，申请人的配偶手机号码与系统中已有申请人的配偶手机号码相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300050,order=48)
	public IRuleResult rule300050(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String spouseMobile = customerInfo.getSpouseMobile();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300050: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(spouseMobile)){
				flg = false;
				logger.debug("rule300050: "+ applyCode + "配偶手机号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300050(idcard,spouseMobile,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300051</br>
	 * 证件号码不同，单位地址相同，单位名称前八个字不同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300051,order=49)
	public IRuleResult rule300051(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyAddrProvince = customerInfo.getCompanyAddrProvince();
			String companyAddrCity = customerInfo.getCompanyAddrCity();
			String CompanyAddrDistrict = customerInfo.getCompanyAddrDistrict();
			String companyAddresss = customerInfo.getCompanyAddresss();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300051: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyAddresss)){
				flg = false;
				logger.debug("rule300051: "+ applyCode + "单位地址为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300051: "+ applyCode + "单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300051(idcard,companyAddrProvince,companyAddrCity,CompanyAddrDistrict,companyAddresss,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300052</br>
	 * 申请人的身份证号码与系统中已有申请人的配偶身份证号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300052,order=50)
	public IRuleResult rule300052(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300052: "+ applyCode + "申请人证件号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300052(idcard,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300053</br>
	 * 申请人的手机号码与系统中已有申请人的配偶手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300053,order=51)
	public IRuleResult rule300053(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String mobile = customerInfo.getMobile();
			Boolean flg = true;
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300053: "+ applyCode + "申请人的手机号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300053(mobile,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300054</br>
	 * 申请人与系统中已有客户为父母-子女关系，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300054,order=52)
	public IRuleResult rule300054(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> childs = iFact.getChidrenInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=childs&&childs.size()>0) {
			String name = customerInfo.getName();
			Boolean flg = true;
			List<String> childNames=new ArrayList<String>();
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300054: "+ applyCode + "申请人的姓名为空");
			}
			for (ContactsInfo contactsInfo : childs) {
				childNames.add(contactsInfo.getName());
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300054(name,applyCode,childNames);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300055</br>
	 * 申请人与系统中已有客户为子女-父母关系，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300055,order=53)
	public IRuleResult rule300055(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> parents = iFact.getParentInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=parents&&parents.size()>0) {
			String name = customerInfo.getName();
			List<String> parentNames=new ArrayList<String>();
			Boolean flg = true;
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300055: "+ applyCode + "申请人的姓名为空");
			}
			for (ContactsInfo contactsInfo : parents) {
				parentNames.add(contactsInfo.getName());
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300055(name,applyCode,parentNames);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300056</br>
	 * 申请人的姓名和手机号码与系统中已有申请人的家庭联系人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300056,order=54)
	public IRuleResult rule300056(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String name = customerInfo.getName();
			String mobile = customerInfo.getMobile();
			Boolean flg = true;
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300056: "+ applyCode + "申请人的姓名为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300056: "+ applyCode + "申请人的手机号为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300056(name,mobile,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300057</br>
	 * 申请人的姓名和手机号码与系统中已有申请人的其他联系人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300057,order=55)
	public IRuleResult rule300057(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String name = customerInfo.getName();
			String mobile = customerInfo.getMobile();
			Boolean flg = true;
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300057: "+ applyCode + "申请人的姓名为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300057: "+ applyCode + "申请人的手机号为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300057(name,mobile,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300058</br>
	 * 证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300058,order=56)
	public IRuleResult rule300058(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String companyAddrCity = customerInfo.getCompanyAddrCity();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300058: "+ applyCode + "申请人的证件号码为空");
			}
			if(StringUtils.isEmpty(companyAddrCity)){
				flg = false;
				logger.debug("rule300058: "+ applyCode + "申请人的单位城市为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule300058: "+ applyCode + "申请人的单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300058(idcard,companyAddrCity,companyName,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300059</br>
	 * 申请人的姓名和手机号码与系统中已有申请人的工作证明人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300059,order=57)
	public IRuleResult rule300059(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String name = customerInfo.getName();
			String mobile = customerInfo.getMobile();
			Boolean flg = true;
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300059: "+ applyCode + "申请人的姓名为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300059: "+ applyCode + "申请人的手机号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300059(name,mobile,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300060</br>
	 * 申请人的姓名与系统中已有申请人的工作证明人姓名相同，且已有申请人的姓名与申请人的工作证明人姓名相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300060,order=58)
	public IRuleResult rule300060(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			String name = customerInfo.getName();
			List<String> workProverNames = new ArrayList<String>();
			Boolean flg = true;
			Boolean flgAll = false;
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300060: "+ applyCode + "申请人的姓名为空");
			}
			if (flg) {
				for (ContactsInfo workProverInfo : workProverInfos) {
					Boolean flg1 = true;//是否需要将证明人加入默认加入
					String workProverName = workProverInfo.getName();
					if(StringUtils.isEmpty(workProverName)){
						flg1 = false;
						logger.debug("rule300060: "+ applyCode + "工作证明人姓名为空");
					}
					if (flg1) {
						flgAll = true;
						workProverNames.add(workProverName);
					}
				}
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flgAll){
				appCodes = customerInfoService.checkRule300060(name,workProverNames,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300061</br>
	 * 证件号码不同，申请人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300061,order=59)
	public IRuleResult rule300061(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		List<ContactsInfo> workProverInfos = iFact.getWorkProverInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo&&null!=workProverInfos) {
			String idcard = customerInfo.getIdcard();
			String name = customerInfo.getName();
			String mobile = customerInfo.getMobile();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300061: "+ applyCode + "申请人的证件号码为空");
			}
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300061: "+ applyCode + "申请人的姓名为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300061: "+ applyCode + "申请人的手机号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300061(idcard,name,mobile,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300062</br>
	 * 证件号码不同，申请人手机号码与系统中已有申请人的其他联系人号码相同，且姓名相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300062,order=60)
	public IRuleResult rule300062(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String name = customerInfo.getName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300062: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300062: "+ applyCode + "申请人手机号码为空");
			}
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300062: "+ applyCode + "申请人姓名为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300062(idcard,mobile,name,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300063</br>
	 * 证件号码不同，申请人手机号码与系统中已有申请人的工作证明人号码相同，且姓名相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300063,order=61)
	public IRuleResult rule300063(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (null!=customerInfo) {
			String idcard = customerInfo.getIdcard();
			String mobile = customerInfo.getMobile();
			String name = customerInfo.getName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300063: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(mobile)){
				flg = false;
				logger.debug("rule300063: "+ applyCode + "申请人手机号码为空");
			}
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300063: "+ applyCode + "申请人姓名为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300063(idcard,mobile,name,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300065</br>
	 * 借款人身份证号与系统中已有申请人相同，但姓名不同
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300065,order=59)
	public IRuleResult rule300065(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String name = customerInfo.getName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300065: "+ applyCode + "证件号码为空");
			}
			if(StringUtils.isEmpty(name)){
				flg = false;
				logger.debug("rule300065: "+ applyCode + "姓名为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule300065(idcard, name,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 300064</br>
	 * 一年内，信薪贷、信优贷产品借款人可认定工资较前一次申请时增长30%以上【身份证号一致】
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule300064,order=60)
	public IRuleResult rule300064(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String productCode =  customerInfo.getApplyProductCode();
			Integer approveIncome =  customerInfo.getApproveIncome();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule300064: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(productCode)){
				flg = false;
				logger.debug("rule300064: "+ applyCode + "申请人申请产品代码为空");
			}
			if(null==approveIncome){
				flg = false;
				logger.debug("rule300064: "+ applyCode + "申请人可认定工资为空");
			}
			Map<String,Object> re = new HashMap<String, Object>();
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if (flg) {
				if (IRuleContant.XXD_XYD_CODES.indexOf(productCode)>-1) {
					re = customerInfoService.checkRule300064(idcard,applyCode);
					if (null!=re) {
						String sourceSys = (String) re.get("sourceSys");
						String appcode = (String) re.get("applyCode");
						Integer income = (Integer) re.get("approveIncome");
						HistInfo histInfo = new HistInfo(sourceSys, appcode);
						if (null!=income&&income>0&&approveIncome>0&&approveIncome>income&&((approveIncome-income)/approveIncome>0.3)) {
							iRuleResult.setRuleResult(true);
							appCodes.add(histInfo);
							iRuleResult.setHitApplyCodes(appCodes);
						}
					}
				}
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 600001</br>
	 * 一年内，证件号码不同，申请人的单位电话与系统中已有申请人的单位电话相同，且大于等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule600001,order=63)
	public IRuleResult rule600001(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String companyPhone = customerInfo.getCompanyPhone();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule600001: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyPhone)){
				flg = false;
				logger.debug("rule600001: "+ applyCode + "申请人的单位电话为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule600001(idcard,companyPhone,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 600002</br>
	 * 一年内，证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且等于1
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule600002,order=64)
	public IRuleResult rule600002(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String companyAddrCity = customerInfo.getCompanyAddrCity();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule600002: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyAddrCity)){
				flg = false;
				logger.debug("rule600002: "+ applyCode + "申请人的单位城市为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule600002: "+ applyCode + "申请人的单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule600002(idcard,companyAddrCity,companyName,applyCode);
			}
			if (appCodes.size()==1) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 600003</br>
	 * 一年内，证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且大于等于2
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule600003,order=65)
	public IRuleResult rule600003(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String companyAddrCity = customerInfo.getCompanyAddrCity();
			String companyName = customerInfo.getCompanyName();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule600003: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(companyAddrCity)){
				flg = false;
				logger.debug("rule600003: "+ applyCode + "申请人的单位城市为空");
			}
			if(StringUtils.isEmpty(companyName)){
				flg = false;
				logger.debug("rule600003: "+ applyCode + "申请人的单位名称为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule600002(idcard,companyAddrCity,companyName,applyCode);
			}
			if (appCodes.size()>=2) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700001</br>
	 * 同一车辆识别代号（VIN码）不同发动机号码
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700001,order=66)
	public IRuleResult rule700001(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String vinCode = customerInfo.getVinCode();
			String engineNo = customerInfo.getEngineNo();
			Boolean flg = true;
			if(StringUtils.isEmpty(vinCode)){
				flg = false;
				logger.debug("rule600002: "+ applyCode + "车辆识别代号（VIN码）为空");
			}
			if(StringUtils.isEmpty(engineNo)){
				flg = false;
				logger.debug("rule700001: "+ applyCode + "发动机号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700001(vinCode,engineNo,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700002</br>
	 * 同一车辆识别代号（VIN码）不同号牌号码
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700002,order=67)
	public IRuleResult rule700002(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String vinCode = customerInfo.getVinCode();
			String vehicleNo = customerInfo.getVehicleNo();
			Boolean flg = true;
			if(StringUtils.isEmpty(vinCode)){
				flg = false;
				logger.debug("rule700002: "+ applyCode + "车辆识别代号（VIN码）为空");
			}
			if(StringUtils.isEmpty(vehicleNo)){
				flg = false;
				logger.debug("rule700001: "+ applyCode + "车牌号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700002(vinCode,vehicleNo,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700003</br>
	 * 同一发动机号码不同号牌号码
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700003,order=68)
	public IRuleResult rule700003(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String engineNo = customerInfo.getEngineNo();
			String vehicleNo = customerInfo.getVehicleNo();
			Boolean flg = true;
			if(StringUtils.isEmpty(engineNo)){
				flg = false;
				logger.debug("rule700003: "+ applyCode + "发动机号码为空");
			}
			if(StringUtils.isEmpty(vehicleNo)){
				flg = false;
				logger.debug("rule700003: "+ applyCode + "车牌号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700003(engineNo,vehicleNo,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700004</br>
	 * 同一发动机号码不同车辆识别代号（VIN码）
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700004,order=69)
	public IRuleResult rule700004(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String engineNo = customerInfo.getEngineNo();
			String vinCode = customerInfo.getVinCode();
			Boolean flg = true;
			if(StringUtils.isEmpty(engineNo)){
				flg = false;
				logger.debug("rule700004: "+ applyCode + "发动机号码为空");
			}
			if(StringUtils.isEmpty(vinCode)){
				flg = false;
				logger.debug("rule700004: "+ applyCode + "车辆识别代号（VIN码）为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700004(engineNo,vinCode,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700005</br>
	 * 同一号牌号码不同车辆识别代号（VIN码）
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700005,order=70)
	public IRuleResult rule700005(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String vehicleNo = customerInfo.getVehicleNo();
			String vinCode = customerInfo.getVinCode();
			Boolean flg = true;
			if(StringUtils.isEmpty(vehicleNo)){
				flg = false;
				logger.debug("rule700005: "+ applyCode + "车牌号码为空");
			}
			if(StringUtils.isEmpty(vinCode)){
				flg = false;
				logger.debug("rule700005: "+ applyCode + "车辆识别代号（VIN码）为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700005(vehicleNo,vinCode,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700006</br>
	 * 同一号牌号码不同发动机号码
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700006,order=71)
	public IRuleResult rule700006(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String vehicleNo = customerInfo.getVehicleNo();
			String engineNo = customerInfo.getEngineNo();
			Boolean flg = true;
			if(StringUtils.isEmpty(vehicleNo)){
				flg = false;
				logger.debug("rule700006: "+ applyCode + "车牌号码为空");
			}
			if(StringUtils.isEmpty(engineNo)){
				flg = false;
				logger.debug("rule700006: "+ applyCode + "发动机号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700006(vehicleNo,engineNo,applyCode);
			}
			if (appCodes.size()>0) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700007</br>
	 * 180天内，不同申请人同一车辆识别代号（VIN码）进件大于等于2件
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700007,order=72)
	public IRuleResult rule700007(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String vinCode = customerInfo.getVinCode();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule700007: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(vinCode)){
				flg = false;
				logger.debug("rule700007: "+ applyCode + "车辆识别代号（VIN码）为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700007(idcard,vinCode,applyCode);
			}
			if (appCodes.size()>=2) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700008</br>
	 * 180天内，不同申请人同一发动机号码进件大于等于2件
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700008,order=73)
	public IRuleResult rule700008(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String engineNo = customerInfo.getEngineNo();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule700008: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(engineNo)){
				flg = false;
				logger.debug("rule700008: "+ applyCode + "发动机号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700008(idcard,engineNo,applyCode);
			}
			if (appCodes.size()>=2) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
	/**
	 * 700009</br>
	 * 180天内，不同申请人同一号牌号码（车牌号）进件大于等于2件
	 * 
	 * @param iFact
	 * @return
	 */
	@RuleConfig(ruleCategory = IRuleCategory.IRule700009,order=74)
	public IRuleResult rule700009(IFact iFact){
		IRuleResult iRuleResult = new IRuleResult();
		CustomerInfo customerInfo = iFact.getCustomerInfo();
		String applyCode = iFact.getApplyCode();
		if (customerInfo!=null) {
			String idcard = customerInfo.getIdcard();
			String vehicleNo = customerInfo.getVehicleNo();
			Boolean flg = true;
			if(StringUtils.isEmpty(idcard)){
				flg = false;
				logger.debug("rule700009: "+ applyCode + "申请人证件号码为空");
			}
			if(StringUtils.isEmpty(vehicleNo)){
				flg = false;
				logger.debug("rule700009: "+ applyCode + "车牌号码为空");
			}
			List<HistInfo> appCodes = new ArrayList<HistInfo>();
			if(flg){
				appCodes = customerInfoService.checkRule700009(idcard,vehicleNo,applyCode);
			}
			if (appCodes.size()>=2) {
				iRuleResult.setRuleResult(true);
				iRuleResult.setHitApplyCodes(appCodes);
			}
		}
		return iRuleResult;
	}
	
}