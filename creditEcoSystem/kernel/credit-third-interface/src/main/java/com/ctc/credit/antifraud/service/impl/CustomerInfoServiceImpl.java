package com.ctc.credit.antifraud.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctc.credit.antifraud.dao.CustomerInfoDao;
import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.model.HistInfo;
import com.ctc.credit.antifraud.service.CustomerInfoService;
import com.ctc.credit.kernel.base.GenericServiceImpl;

@Service
@Transactional
public class CustomerInfoServiceImpl extends
		GenericServiceImpl<CustomerInfo, String> implements CustomerInfoService {

	private static Logger logger = Logger
			.getLogger(CustomerInfoServiceImpl.class);

	public CustomerInfoServiceImpl() {
	}

	@Autowired
	private CustomerInfoDao customerInfoDao;

	@Override
	public CustomerInfo queryCustomerByApplyCode(String applyCode) {

		return customerInfoDao.queryCustomerByApplyCode(applyCode);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300065(String idcard, String name, String applyCode) {
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.name<>? and c.applyCode<>?";
		List<HistInfo> appCodes = this.query(hql, new Object[] { idcard, name,
				applyCode });
		return appCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public long checkRule200003(String comphone, String applyCode) {
		String hql = "select count(*) from CustomerInfo c,ContactsInfo ct where c.applyCode=ct.applyCode and c.applyCode=? and c.companyPhone=ct.companyPhone and c.companyPhone=? and c.department<>ct.department";
		List<Long> sizes = this
				.query(hql, new Object[] { applyCode, comphone });
		return sizes.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300001(String idcard, String mobile, String applyCode) {
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.mobile=? and c.applyCode<>?";
		List<HistInfo> applyCodes = this.query(hql, new Object[] { idcard, mobile,
				applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300002(String idcard, String email, String applyCode) {
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.emailAddress=? and c.applyCode<>?";
		List<HistInfo> applyCodes = this.query(hql, new Object[] { idcard, email,
				applyCode });
		return applyCodes;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300003(String idcard,
			List<String> workProverNames, List<String> workProverMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='3' and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=workProverNames&&null!=workProverMobiles&&workProverNames.size()==workProverMobiles.size()) {
			for (int i = 0; i < workProverNames.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+workProverNames.get(i)
							+ "' and ci.mobile='"+workProverMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+workProverNames.get(i)
							+ "' and ci.mobile='"+workProverMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				applyCodes = this.query(hql,new Object[]{idcard,applyCode});
			}
		}
		return applyCodes;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<HistInfo> checkRule300004(String idcard,
			List<String> workProverMobiles, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='3' and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate and ci.mobile in(";
		StringBuilder hqladd = new StringBuilder();
		if (null!=workProverMobiles&&workProverMobiles.size()>0) {
			for (int i = 0; i < workProverMobiles.size(); i++) {
				if(i==0) {
					hqladd.append("'"+workProverMobiles.get(i)+ "'");
				}else {
					hqladd.append(",'"+workProverMobiles.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				applyCodes = this.query(hql,new Object[]{idcard,applyCode});
			}
		}
		return applyCodes;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300005(String idcard, String companyPhone,
			String companyName, String applyCode) {
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.homePhone=? and c.companyName<>? and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate";
		List<HistInfo> applyCodes = this.query(hql, new Object[] { idcard, companyPhone,companyName, applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> queryCustomerInfosNearyly() {
		String hql = "select c.applyCode from CustomerInfo c where c.createDate between sysdate - 16 and sysdate";
		List<String> applyCodes = this.query(hql);
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300006(String idcard,
			List<String> familyerNames, List<String> familyerMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation in ('1','2','4') and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=familyerNames&&null!=familyerMobiles&&familyerNames.size()==familyerMobiles.size()) {
			for (int i = 0; i < familyerNames.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+familyerNames.get(i)
							+ "' and ci.mobile='"+familyerMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+familyerNames.get(i)
							+ "' and ci.mobile='"+familyerMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		
		String hql2 = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate and (";
		StringBuilder hqladd2 = new StringBuilder();
		if (null!=familyerNames&&null!=familyerMobiles&&familyerNames.size()==familyerMobiles.size()) {
			for (int i = 0; i < familyerNames.size(); i++) {
				if(i==0) {
					hqladd2.append("(c.spouseName<>'"+familyerNames.get(i)
							+ "' and c.spouseMobile='"+familyerMobiles.get(i)
							+ "')");
				}else {
					hqladd2.append(" or (c.spouseName<>'"+familyerNames.get(i)
							+ "' and c.spouseMobile='"+familyerMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd2.toString())) {
				hql2=hql2 + hqladd2.toString() +")";
				List<HistInfo> codes = this.query(hql2,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300007(String idcard,
			List<String> familyerMobiles, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation in ('1','2','4') and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate and ci.mobile in(";
		StringBuilder hqladd = new StringBuilder();
		if (null!=familyerMobiles&&familyerMobiles.size()>0) {
			for (int i = 0; i < familyerMobiles.size(); i++) {
				if(i==0) {
					hqladd.append("'"+familyerMobiles.get(i)+ "'");
				}else {
					hqladd.append(",'"+familyerMobiles.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		//配偶是否命中
		String hql2 = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate and c.spouseMobile in(";
		StringBuilder hqladd2 = new StringBuilder();
		if (null!=familyerMobiles&&familyerMobiles.size()>0) {
			for (int i = 0; i < familyerMobiles.size(); i++) {
				if(i==0) {
					hqladd2.append("'"+familyerMobiles.get(i)+ "'");
				}else {
					hqladd2.append(",'"+familyerMobiles.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd2.toString())) {
				hql2=hql2 + hqladd2.toString() +")";
				List<HistInfo> codes  = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300009(String idcard,
			List<String> otherLinkManNames, List<String> otherLinkManMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='9' and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=otherLinkManNames&&null!=otherLinkManMobiles&&otherLinkManNames.size()==otherLinkManMobiles.size()) {
			for (int i = 0; i < otherLinkManMobiles.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+otherLinkManNames.get(i)
							+ "' and ci.mobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+otherLinkManNames.get(i)
							+ "' and ci.mobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				applyCodes = this.query(hql,new Object[]{idcard,applyCode});
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300010(String idcard,
			List<String> otherLinkManMobiles, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='9' and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate and ci.mobile in(";
		StringBuilder hqladd = new StringBuilder();
		if (null!=otherLinkManMobiles&&otherLinkManMobiles.size()>0) {
			for (int i = 0; i < otherLinkManMobiles.size(); i++) {
				if(i==0) {
					hqladd.append("'"+otherLinkManMobiles.get(i)+ "'");
				}else {
					hqladd.append(",'"+otherLinkManMobiles.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				applyCodes = this.query(hql,new Object[]{idcard,applyCode});
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300012(String idcard,
			List<String> workProverNames, List<String> workProverMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation in ('1','2','4') and c.applyCode<>? and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=workProverNames&&null!=workProverMobiles&&workProverNames.size()==workProverMobiles.size()) {
			for (int i = 0; i < workProverNames.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+workProverNames.get(i)
							+ "' and ci.mobile='"+workProverMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+workProverNames.get(i)
							+ "' and ci.mobile='"+workProverMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		
		String hql2 = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.applyCode<>? and (";
		StringBuilder hqladd2 = new StringBuilder();
		if (null!=workProverNames&&null!=workProverMobiles&&workProverNames.size()==workProverMobiles.size()) {
			for (int i = 0; i < workProverNames.size(); i++) {
				if(i==0) {
					hqladd2.append("(c.spouseName<>'"+workProverNames.get(i)
							+ "' and c.spouseMobile='"+workProverMobiles.get(i)
							+ "')");
				}else {
					hqladd2.append(" or (c.spouseName<>'"+workProverNames.get(i)
							+ "' and c.spouseMobile='"+workProverMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd2.toString())) {
				hql2=hql2 + hqladd2.toString() +")";
				List<HistInfo> codes  = this.query(hql2,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300013(String idcard,
			List<String> workProverNames, List<String> workProverMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='9' and c.applyCode<>? and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=workProverNames&&null!=workProverMobiles&&workProverNames.size()==workProverMobiles.size()) {
			for (int i = 0; i < workProverNames.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+workProverNames.get(i)
							+ "' and ci.mobile='"+workProverMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+workProverNames.get(i)
							+ "' and ci.mobile='"+workProverMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300014(String idcard,
			List<String> familyerNames, List<String> familyerMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='3' and c.applyCode<>? and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=familyerNames&&null!=familyerMobiles&&familyerNames.size()==familyerMobiles.size()) {
			for (int i = 0; i < familyerNames.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+familyerNames.get(i)
							+ "' and ci.mobile='"+familyerMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+familyerNames.get(i)
							+ "' and ci.mobile='"+familyerMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300015(String idcard,
			List<String> familyerNames, List<String> familyerMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='9' and c.applyCode<>? and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=familyerNames&&null!=familyerMobiles&&familyerNames.size()==familyerMobiles.size()) {
			for (int i = 0; i < familyerNames.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+familyerNames.get(i)
							+ "' and ci.mobile='"+familyerMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+familyerNames.get(i)
							+ "' and ci.mobile='"+familyerMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300016(String idcard,
			List<String> otherLinkManNames, List<String> otherLinkManMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='3' and c.applyCode<>? and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=otherLinkManNames&&null!=otherLinkManMobiles&&otherLinkManNames.size()==otherLinkManMobiles.size()) {
			for (int i = 0; i < otherLinkManMobiles.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+otherLinkManNames.get(i)
							+ "' and ci.mobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+otherLinkManNames.get(i)
							+ "' and ci.mobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				applyCodes = this.query(hql,new Object[]{idcard,applyCode});
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300017(String idcard,
			List<String> otherLinkManNames, List<String> otherLinkManMobiles,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation in ('1','2','4') and c.applyCode<>? and (";
		StringBuilder hqladd = new StringBuilder();
		if (null!=otherLinkManNames&&null!=otherLinkManMobiles&&otherLinkManNames.size()==otherLinkManMobiles.size()) {
			for (int i = 0; i < otherLinkManMobiles.size(); i++) {
				if(i==0) {
					hqladd.append("(ci.name<>'"+otherLinkManNames.get(i)
							+ "' and ci.mobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}else {
					hqladd.append(" or (ci.name<>'"+otherLinkManNames.get(i)
							+ "' and ci.mobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		
		String hql2 = "select c.applyCode from CustomerInfo c where c.idcard<>? and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate and (";
		StringBuilder hqladd2 = new StringBuilder();
		if (null!=otherLinkManNames&&null!=otherLinkManMobiles&&otherLinkManNames.size()==otherLinkManMobiles.size()) {
			for (int i = 0; i < otherLinkManNames.size(); i++) {
				if(i==0) {
					hqladd2.append("(c.spouseName<>'"+otherLinkManNames.get(i)
							+ "' and c.spouseMobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}else {
					hqladd2.append(" or (c.spouseName<>'"+otherLinkManNames.get(i)
							+ "' and c.spouseMobile='"+otherLinkManMobiles.get(i)
							+ "')");
				}
			}
			if (StringUtils.isNotEmpty(hqladd2.toString())) {
				hql2=hql2 + hqladd2.toString() +")";
				List<HistInfo> codes = this.query(hql2,new Object[]{idcard,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300018(String idcard, String mobile,
			String companyPhone, String homePhone, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.mobile<>? and c.companyPhone<>? and c.homePhone<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, mobile,companyPhone,homePhone,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300022(String idcard, String mobile,
			String companyPhone, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.mobile<>? and c.companyPhone<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, mobile,companyPhone,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300023(String idcard, String mobile,
			String homePhone, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.mobile<>? and c.homePhone<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, mobile,homePhone,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300025(String idcard, String mobile,
			String companyName, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.mobile<>? and c.companyName<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, mobile,companyName,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300026(String idcard, String mobile,
			String companyAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.mobile<>? and c.companyAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, mobile,companyAddresss,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300027(String idcard, String mobile,
			String homeAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.mobile<>? and c.homeAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, mobile,homeAddresss,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300028(String idcard, String housingAddresss,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.housingAddresss=? and c.applyCode<>?";
		applyCodes = this.query(hql, new Object[] { idcard, housingAddresss,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300029(String idcard, String homePhone,
			String homeAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.homePhone<>? and c.homeAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, homePhone,homeAddresss,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300030(String idcard, String homePhone,
			String companyName, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.homePhone<>? and c.companyName<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, homePhone,companyName,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300031(String idcard, String homePhone,
			String companyPhone, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.homePhone<>? and c.companyPhone<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, homePhone,companyPhone,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300032(String idcard, String homePhone,
			String companyName, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.companyPhone=? and c.companyName<>? and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate";
		applyCodes = this.query(hql, new Object[] { idcard, homePhone,companyName,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300033(String idcard, String companyPhone,
			String companyName, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.companyPhone=? and substr(regexp_replace(c.companyName,'[省市县区]',''),0,8) <> substr(regexp_replace(?,'[省市县区]',''),0,8) and c.applyCode<>?";
		
		applyCodes = this.query(hql, new Object[] { idcard, companyPhone,companyName,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300034(String idcard, String homePhone,
			String homeAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.homePhone=? and c.homeAddresss<>? and c.applyCode<>?";
		applyCodes = this.query(hql, new Object[] { idcard, homePhone,homeAddresss,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300035(String idcard, String homeAddresss,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.homeAddresss=? and c.applyCode<>?";
		applyCodes = this.query(hql, new Object[] { idcard,homeAddresss,applyCode });
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300036(String idcard, String companyPhone,
			List<String> workProverPhones, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and c.companyPhone=? and ci.relation='3' and c.applyCode<>? and ci.companyPhone in(";
		StringBuilder hqladd = new StringBuilder();
		if (null!=workProverPhones&&workProverPhones.size()>0) {
			for (int i = 0; i < workProverPhones.size(); i++) {
				if(i==0) {
					hqladd.append("'"+workProverPhones.get(i)+ "'");
				}else {
					hqladd.append(",'"+workProverPhones.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,companyPhone,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300037(String idcard, String homePhone,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.homePhone=? and c.applyCode<>?";
		applyCodes = this.query(hql,new Object[]{idcard,homePhone,applyCode});
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300038(String idcard, String companyName,
			List<String> workProverMobiles, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='3' and substr(regexp_replace(c.companyName,'[省市县区]',''),0,8) <> substr(regexp_replace(?,'[省市县区]',''),0,8) and c.applyCode<>? and ci.mobile in(";
		StringBuilder hqladd = new StringBuilder();
		if (null!=workProverMobiles&&workProverMobiles.size()>0) {
			for (int i = 0; i < workProverMobiles.size(); i++) {
				if(i==0) {
					hqladd.append("'"+workProverMobiles.get(i)+ "'");
				}else {
					hqladd.append(",'"+workProverMobiles.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{idcard,companyName,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300039(String idcard, String mobile,
			String name, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation in ('1','2','4') and ci.mobile=? and ci.name<>? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,mobile,name,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		
		String hql2 = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.spouseMobile=? and c.spouseName<>? and c.applyCode<>?";
		List<HistInfo> codes1 = this.query(hql2,new Object[]{idcard,mobile,name,applyCode});
		if (codes1.size()>0) {
				applyCodes.addAll(codes1);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300040(String idcard, String mobile,
			String name, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='9' and ci.mobile=? and ci.name<>? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,mobile,name,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300041(String idcard, String mobile,
			String name, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='3' and ci.mobile=? and ci.name<>? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,mobile,name,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<HistInfo> checkRule300042(String idcard, String homePhone,
			String companyAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.homePhone<>? and c.companyAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,homePhone,companyAddresss,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300043(String idcard, String companyPhone,
			String homeAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.companyPhone<>? and c.homeAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,companyPhone,homeAddresss,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300044(String idcard, String companyPhone,
			String companyName, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.companyPhone<>? and c.companyName<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,companyPhone,companyName,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300045(String idcard, String companyPhone,
			String companyAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.companyPhone<>? and c.companyAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,companyPhone,companyAddresss,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300046(String idcard, String homeAddresss,
			String companyName, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.homeAddresss<>? and c.companyName<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,homeAddresss,companyName,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300047(String idcard, String homeAddresss,
			String companyAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.homeAddresss<>? and c.companyAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,homeAddresss,companyAddresss,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300048(String idcard, String companyName,
			String companyAddresss, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard=? and c.companyName<>? and c.companyAddresss<>? and c.applyCode<>? and c.applyDate between sysdate - 365 and sysdate";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,companyName,companyAddresss,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300049(String idcard, String spouseIdno,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.spouseIdno=? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,spouseIdno,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300050(String idcard, String spouseMobile,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.spouseMobile=? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,spouseMobile,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300051(String idcard, String province,String city,String dist,String companyAddresss,
			String companyName, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.companyAddrProvince=? and c.companyAddrCity=? and c.companyAddrDistrict=? and c.companyAddresss=? and c.applyCode<>? and substr(REGEXP_REPLACE(c.companyName,'[省市县区]',''),0,8)<>substr(REGEXP_REPLACE(?,'[省市县区]',''),0,8)";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,province,city,dist,companyAddresss,companyName,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300052(String idcard, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,LoanInfo li where c.applyCode=li.applyCode and c.spouseIdno=? and to_number(li.currentExpiryDays)>=5 and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300053(String mobile, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,LoanInfo li where c.applyCode=li.applyCode and c.spouseMobile=? and to_number(li.currentExpiryDays)>=5 and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{mobile,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300054(String name, String applyCode,List<String> childNames) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci,LoanInfo li where c.applyCode=ci.applyCode and c.applyCode=li.applyCode and ci.name=? and ci.relation='1' and to_number(li.currentExpiryDays)>=5 and c.applyCode<>? and c.name in(";
		StringBuilder hqladd = new StringBuilder();
		if (null!=childNames&&childNames.size()>0) {
			for (int i = 0; i < childNames.size(); i++) {
				if(i==0) {
					hqladd.append("'"+childNames.get(i)+ "'");
				}else {
					hqladd.append(",'"+childNames.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{name,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300055(String name, String applyCode,List<String> parentNames) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci,LoanInfo li where c.applyCode=ci.applyCode and c.applyCode=li.applyCode and ci.name=? and ci.relation='2' and to_number(li.currentExpiryDays)>=5 and c.applyCode<>? and c.name in(";
		StringBuilder hqladd = new StringBuilder();
		if (null!=parentNames&&parentNames.size()>0) {
			for (int i = 0; i < parentNames.size(); i++) {
				if(i==0) {
					hqladd.append("'"+parentNames.get(i)+ "'");
				}else {
					hqladd.append(",'"+parentNames.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{name,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300056(String name, String mobile,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci,LoanInfo li where c.applyCode=ci.applyCode and c.applyCode=li.applyCode and ci.name=? and ci.mobile=? and ci.relation in ('1','2','4') and to_number(li.currentExpiryDays)>=5 and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{name,mobile,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		
		String hql2 = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,LoanInfo li where c.applyCode=li.applyCode and c.spouseName=? and c.spouseMobile=? and to_number(li.currentExpiryDays)>=5 and c.applyCode<>?";
		List<HistInfo> codes2 = this.query(hql2,new Object[]{name,mobile,applyCode});
		if (codes2.size()>0) {
				applyCodes.addAll(codes2);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300057(String name, String mobile,
			String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select c.applyCode from CustomerInfo c,ContactsInfo ci,LoanInfo li where c.applyCode=ci.applyCode and c.applyCode=li.applyCode and ci.name=? and ci.mobile=? and ci.relation='9' and to_number(li.currentExpiryDays)>=5 and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{name,mobile,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300058(String idcard, String companyAddrCity,
			String companyName,String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,LoanInfo li where c.applyCode=li.applyCode and c.idcard<>? and c.companyAddrCity=? and substr(c.companyName,0,8)=substr(?,0,8) and to_number(li.currentExpiryDays)>=5 and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,companyAddrCity,companyName,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300059(String name, String mobile,String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci,LoanInfo li where c.applyCode=ci.applyCode and c.applyCode=li.applyCode and ci.name=? and ci.mobile=? and ci.relation='3' and to_number(li.currentExpiryDays)>=5 and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{name,mobile,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300060(String name,
			List<String> workProverNames, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci,LoanInfo li where c.applyCode=ci.applyCode and c.applyCode=li.applyCode and ci.name=? and ci.relation='3' and to_number(li.currentExpiryDays)>=5 and c.applyCode<>? and c.name in(";
		if (null!=workProverNames&&workProverNames.size()>0) {
			StringBuilder hqladd = new StringBuilder();
			for (int i = 0; i < workProverNames.size(); i++) {
				if(i==0) {
					hqladd .append("'"+workProverNames.get(i)+ "'");
				}else {
					hqladd.append(",'"+workProverNames.get(i)+ "'");
				}
			}
			if (StringUtils.isNotEmpty(hqladd.toString())) {
				hql=hql + hqladd.toString() +")";
				List<HistInfo> codes = this.query(hql,new Object[]{name,applyCode});
				if (null!=codes&&codes.size()>0) {
					applyCodes.addAll(codes);
				}
			}
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> checkRule300064(String idcard, String applyCode) {
		String hql = "select c.sourceSys,c.applyCode,c.approveIncome from CustomerInfo c where c.idcard=? and c.applyCode<>? order by c.applyDate desc";
		List<Object[]> codes = this.query(hql,new Object[]{idcard,applyCode});
		List<Map<String, Object>> mapList = new ArrayList<Map<String,Object>>();
		for (Object[] lis : codes) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("sourceSys", lis[0]);
			map.put("applyCode", lis[1]);
			map.put("approveIncome", lis[2]);
			mapList.add(map);
		}
		return null!=mapList&&mapList.size()>0?mapList.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule600001(String idcard, String companyPhone,
			String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.companyPhone=? and c.applyDate between sysdate - 365 and sysdate and c.applyCode<>?";
		codes = this.query(hql,new Object[]{idcard,companyPhone,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule600002(String idcard, String companyAddrCity,
			String companyName, String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.companyAddrCity=? and substr(regexp_replace(c.companyName,'[省市县区]',''),0,8) = substr(regexp_replace(?,'[省市县区]',''),0,8) and c.applyDate between sysdate - 365 and sysdate and c.applyCode<>?";
		codes = this.query(hql,new Object[]{idcard,companyAddrCity,companyName,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700001(String vinCode, String engineNo,String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.vinCode=? and c.engineNo<>? and c.applyCode<>?";
		codes = this.query(hql,new Object[]{vinCode,engineNo,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700002(String vinCode, String vehicleNo,String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.vinCode=? and c.vehicleNo<>? and c.applyCode<>?";
		codes = this.query(hql,new Object[]{vinCode,vehicleNo,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700003(String engineNo, String vehicleNo,String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.engineNo=? and c.vehicleNo<>? and c.applyCode<>?";
		codes = this.query(hql,new Object[]{engineNo,vehicleNo,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700004(String engineNo, String vinCode,String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.engineNo=? and c.vinCode<>? and c.applyCode<>?";
		codes = this.query(hql,new Object[]{engineNo,vinCode,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700005(String vehicleNo, String vinCode,String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.vehicleNo=? and c.vinCode<>? and c.applyCode<>?";
		codes = this.query(hql,new Object[]{vehicleNo,vinCode,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700006(String vehicleNo, String engineNo,String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.vehicleNo=? and c.engineNo<>? and c.applyCode<>?";
		codes = this.query(hql,new Object[]{vehicleNo,engineNo,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700007(String idcard, String vinCode,
			String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.vinCode=? and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate";
		codes = this.query(hql,new Object[]{idcard,vinCode,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700008(String idcard, String engineNo,
			String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.engineNo=? and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate";
		codes = this.query(hql,new Object[]{idcard,engineNo,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule700009(String idcard, String vehicleNo,
			String applyCode) {
		List<HistInfo> codes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.vehicleNo=? and c.applyCode<>? and c.applyDate between sysdate - 180 and sysdate";
		codes = this.query(hql,new Object[]{idcard,vehicleNo,applyCode});
		return codes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public CustomerInfo queryHistCustomerInfo(String applyCode, String sourceSys) {
		String hql = "from CustomerInfo c where c.applyCode=? and c.sourceSys=?";
		List<CustomerInfo> customerInfos = this.query(hql,new Object[]{applyCode,sourceSys});
		return customerInfos.size()>0?customerInfos.get(0):null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300061(String idcard, String name,
			String mobile, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation in ('1','2','4') and ci.mobile=? and ci.name=? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,mobile,name,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		
		String hql2 = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c where c.idcard<>? and c.spouseMobile=? and c.spouseName=? and c.applyCode<>?";
		List<HistInfo> codes1 = this.query(hql2,new Object[]{idcard,mobile,name,applyCode});
		if (codes1.size()>0) {
				applyCodes.addAll(codes1);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300062(String idcard, String mobile,
			String name, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='9' and ci.mobile=? and ci.name=? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,mobile,name,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<HistInfo> checkRule300063(String idcard, String mobile,
			String name, String applyCode) {
		List<HistInfo> applyCodes = new ArrayList<HistInfo>();
		String hql = "select new com.ctc.credit.antifraud.model.HistInfo(c.sourceSys,c.applyCode) from CustomerInfo c,ContactsInfo ci where c.applyCode=ci.applyCode and c.idcard<>? and ci.relation='3' and ci.mobile=? and ci.name=? and c.applyCode<>?";
		List<HistInfo> codes = this.query(hql,new Object[]{idcard,mobile,name,applyCode});
		if (codes.size()>0) {
				applyCodes.addAll(codes);
		}
		return applyCodes;
	}

}
