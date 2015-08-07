package com.ctc.credit.antifraud.service;

import java.util.List;
import java.util.Map;

import com.ctc.credit.antifraud.model.CustomerInfo;
import com.ctc.credit.antifraud.model.HistInfo;
import com.ctc.credit.kernel.base.GenericService;

public interface CustomerInfoService extends
		GenericService<CustomerInfo, String> {
	
	/**
	 * 通过申请单号查询客户信息
	 * 
	 * @param applyCode
	 */
	public CustomerInfo queryCustomerByApplyCode(String applyCode);
	
	/**
	 * 从指定系统中查询客户历史信息
	 * 
	 * @param applyCode
	 * @param sourceSys
	 * @return
	 */
	public CustomerInfo queryHistCustomerInfo(String applyCode,String sourceSys);
	
	public List<String> queryCustomerInfosNearyly();
	
	/**
	 * 借款人身份证号与系统中已有申请人相同，但姓名不同
	 * 
	 * @param idcard
	 * @param name
	 * @return
	 */
	public List<HistInfo> checkRule300065(String idcard,String name,String applyCode);
	
	/**
	 * 申请人的单位电话与其工作证明人的固定电话相同，申请人的工作部门与其工作证明人的工作部门不相同
	 * 
	 * @param comphone
	 * @param dept
	 * @param applyCode
	 * @return
	 */
	public long checkRule200003(String comphone, String applyCode);

	/**
	 * 证件号码不同，申请人手机号码与系统中已有申请人手机号码相同，且大于等于1
	 * 
	 * @param idcard
	 * @param mobile
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300001(String idcard, String mobile, String applyCode);

	/**
	 * 证件号码不同，申请人电子邮箱与系统中已有申请人电子邮箱相同，且大于等于1
	 * 
	 * @param idcard
	 * @param email
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300002(String idcard, String email, String applyCode);

	/**
	 * 180天内，证件号码不同，工作证明人姓名不同，工作证明人手机号码相同，且大于等于1
	 * 
	 * @param idcard
	 * @param workProverNames
	 * @param workProverMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300003(String idcard,
			List<String> workProverNames, List<String> workProverMobiles,
			String applyCode);
	
	/**
	 * 一年内，证件号码不同，工作证明人手机号码相同，且大于等于3
	 * 
	 * @param idcard
	 * @param workProverMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300004(String idcard,
			List<String> workProverMobiles, String applyCode);

	/**
	 * 180天内，证件号码不同，申请人单电和系统中已有申请人宅电相同，且单位名称不同，且大于等于1
	 * 
	 * @param idcard
	 * @param companyPhone
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300005(String idcard, String companyPhone,
			String companyName, String applyCode);

	/**
	 * 180天内，证件号码不同，家庭联系人姓名不同，家庭联系人手机号码相同，且大于等于1【包括配偶】
	 * 
	 * @param idcard
	 * @param familyerNames
	 * @param familyerMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300006(String idcard,
			List<String> familyerNames, List<String> familyerMobiles,
			String applyCode);

	/**
	 * 一年内，证件号码不同，家庭联系人手机号码相同，且大于等于3 【家庭联系人 包括配偶】
	 * 
	 * @param idcard
	 * @param familyerMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300007(String idcard,
			List<String> familyerMobiles, String applyCode);

	/**
	 * 180天内，证件号码不同，其他联系人姓名不同，其他联系人手机号码相同，且大于等于1
	 * 
	 * @param idcard
	 * @param otherLinkManNames
	 * @param otherLinkManMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300009(String idcard,
			List<String> otherLinkManNames, List<String> otherLinkManMobiles,
			String applyCode);

	/**
	 * 一年内，证件号码不同，其他联系人手机号码相同，且大于等于3
	 * 
	 * @param idcard
	 * @param otherLinkManMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300010(String idcard,
			List<String> otherLinkManMobiles, String applyCode);

	/**
	 * 证件号码不同，申请人的工作证明人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param workProverNames
	 * @param workProverMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300012(String idcard,
			List<String> workProverNames, List<String> workProverMobiles,
			String applyCode);

	/**
	 * 证件号码不同，申请人的工作证明人手机号码与系统中已有申请人的其他联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param workProverNames
	 * @param workProverMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300013(String idcard,
			List<String> workProverNames, List<String> workProverMobiles,
			String applyCode);

	/**
	 * 证件号码不同，申请人的家庭联系人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param familyerNames
	 * @param familyerMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300014(String idcard,
			List<String> familyerNames, List<String> familyerMobiles,
			String applyCode);

	/**
	 * 证件号码不同，申请人的家庭联系人手机号码与系统中已有申请人的其他联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param familyerNames
	 * @param familyerMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300015(String idcard,
			List<String> familyerNames, List<String> familyerMobiles,
			String applyCode);

	/**
	 * 证件号码不同，申请人的其他联系人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param otherLinkManNames
	 * @param otherLinkManMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300016(String idcard,
			List<String> otherLinkManNames, List<String> otherLinkManMobiles,
			String applyCode);

	/**
	 * 证件号码不同，申请人的其他联系人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param otherLinkManNames
	 * @param otherLinkManMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300017(String idcard,
			List<String> otherLinkManNames, List<String> otherLinkManMobiles,
			String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件手机号码、单位电话和住宅电话与前次进件均不同
	 * 
	 * @param idcard
	 * @param mobile
	 * @param companyPhone
	 * @param homePhone
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300018(String idcard, String mobile,
			String companyPhone, String homePhone, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件手机号码、单位电话与前次进件均不同
	 * 
	 * @param idcard
	 * @param mobile
	 * @param companyPhone
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300022(String idcard, String mobile,
			String companyPhone, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件手机号码、住宅电话与前次进件均不同
	 * 
	 * @param idcard
	 * @param mobile
	 * @param homePhone
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300023(String idcard, String mobile,
			String homePhone, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件手机号码、单位名称与前次进件均不同
	 * 
	 * @param idcard
	 * @param mobile
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300025(String idcard, String mobile,
			String companyName, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件手机号码、单位地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param mobile
	 * @param companyAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300026(String idcard, String mobile,
			String companyAddresss, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件手机号码、住宅地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param mobile
	 * @param homeAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300027(String idcard, String mobile,
			String homeAddresss, String applyCode);

	/**
	 * 证件号码不同，申请人的房产地址与系统中已有申请人的房产地址相同，且大于等于1
	 * 
	 * @param idcard
	 * @param housingAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300028(String idcard, String housingAddresss,
			String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件住宅电话、住宅地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param homePhone
	 * @param homeAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300029(String idcard, String homePhone,
			String homeAddresss, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件住宅电话、单位名称与前次进件均不同
	 * 
	 * @param idcard
	 * @param homePhone
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300030(String idcard, String homePhone,
			String companyName, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件住宅电话、单位电话与前次进件均不同
	 * 
	 * @param idcard
	 * @param homePhone
	 * @param companyPhone
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300031(String idcard, String homePhone,
			String companyPhone, String applyCode);

	/**
	 * 180天内，证件号码不同，申请人宅电和系统中已有申请人单电相同，且单位名称不同，且大于等于1
	 * 
	 * @param idcard
	 * @param homePhone
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300032(String idcard, String homePhone,
			String companyName, String applyCode);

	/**
	 * 证件号码不同，单位电话相同，单位名称前八个字不同，且大于等于1
	 * 
	 * @param idcard
	 * @param companyPhone
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300033(String idcard, String companyPhone,
			String companyName, String applyCode);

	/**
	 * 证件号码不同，住宅电话相同，住宅地址不同，且大于等于1
	 * 
	 * @param idcard
	 * @param homePhone
	 * @param homeAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300034(String idcard, String homePhone,
			String homeAddresss, String applyCode);

	/**
	 * 证件号码不同，住宅地址相同，且大于等于1
	 * 
	 * @param idcard
	 * @param homeAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300035(String idcard, String homeAddresss,
			String applyCode);

	/**
	 * 证件号码不同，单位电话相同，工作证明人单位电话相同，且大于等于2
	 * 
	 * @param idcard
	 * @param companyPhone
	 * @param workProverPhones
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300036(String idcard, String companyPhone,
			List<String> workProverPhones, String applyCode);

	/**
	 * 证件号码不同，住宅电话相同，且大于等于1
	 * 
	 * @param idcard
	 * @param homePhone
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300037(String idcard, String homePhone,
			String applyCode);

	/**
	 * 证件号码不同，工作证明人手机号码相同，单位名称前八个字不同，且大于等于1
	 * 
	 * @param idcard
	 * @param companyName
	 * @param workProverMobiles
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300038(String idcard, String companyName,
			List<String> workProverMobiles, String applyCode);

	/**
	 * 证件号码不同，申请人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param mobile
	 * @param name
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300039(String idcard, String mobile,
			String name, String applyCode);

	/**
	 * 证件号码不同，申请人手机号码与系统中已有申请人的其它联系人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param mobile
	 * @param name
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300040(String idcard, String mobile,
			String name, String applyCode);

	/**
	 * 证件号码不同，申请人手机号码与系统中已有申请人的工作证明人号码相同，且姓名不同，且大于等于1
	 * 
	 * @param idcard
	 * @param mobile
	 * @param name
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300041(String idcard, String mobile,
			String name, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件住宅电话、单位地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param homePhone
	 * @param companyAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300042(String idcard, String homePhone,
			String companyAddresss, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件单位电话、住宅地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param companyPhone
	 * @param homeAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300043(String idcard, String companyPhone,
			String homeAddresss, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件单位电话、单位名称与前次进件均不同
	 * 
	 * @param idcard
	 * @param companyPhone
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300044(String idcard, String companyPhone,
			String companyName, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件单位电话、单位地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param companyPhone
	 * @param companyAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300045(String idcard, String companyPhone,
			String companyAddresss, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件住宅地址、单位名称与前次进件均不同
	 * 
	 * @param idcard
	 * @param homeAddresss
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300046(String idcard, String homeAddresss,
			String companyName, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件住宅地址、单位地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param homeAddresss
	 * @param companyAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300047(String idcard, String homeAddresss,
			String companyAddresss, String applyCode);

	/**
	 * 一年内，证件号码相同，本次进件单位名称、单位地址与前次进件均不同
	 * 
	 * @param idcard
	 * @param companyName
	 * @param companyAddresss
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300048(String idcard, String companyName,
			String companyAddresss, String applyCode);

	/**
	 * 证件号码不同，申请人的配偶身份证号码与系统中已有申请人的配偶身份证号码相同，且大于等于1
	 * 
	 * @param idcard
	 * @param spouseIdno
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300049(String idcard, String spouseIdno,
			String applyCode);

	/**
	 * 证件号码不同，申请人的配偶手机号码与系统中已有申请人的配偶手机号码相同，且大于等于1
	 * 
	 * @param idcard
	 * @param spouseMobile
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300050(String idcard, String spouseMobile,
			String applyCode);

	/**
	 * 证件号码不同，单位地址相同，单位名称前八个字不同，且大于等于1
	 * 
	 * @param idcard
	 * @param companyAddresss
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300051(String idcard, String province,String city,String dist,String companyAddresss,
			String companyName, String applyCode);

	/***
	 * 申请人的身份证号码与系统中已有申请人的配偶身份证号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param idcard
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300052(String idcard, String applyCode);

	/**
	 * 申请人的手机号码与系统中已有申请人的配偶手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param mobile
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300053(String mobile, String applyCode);

	/**
	 * 申请人与系统中已有客户为父母-子女关系，且已有申请人当前逾期大于等于5天
	 * 
	 * @param name
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300054(String name, String applyCode,List<String> childNames);

	/**
	 * 申请人与系统中已有客户为子女-父母关系，且已有申请人当前逾期大于等于5天
	 * 
	 * @param name
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300055(String name, String applyCode,List<String> parentNames);

	/**
	 * 申请人的姓名和手机号码与系统中已有申请人的家庭联系人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param name
	 * @param mobile
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300056(String name, String mobile,
			String applyCode);

	/**
	 * 申请人的姓名和手机号码与系统中已有申请人的其他联系人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param name
	 * @param mobile
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300057(String name, String mobile,
			String applyCode);

	/**
	 * 证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param idcard
	 * @param companyAddrCity
	 * @param companyName
	 * @return
	 */
	public List<HistInfo> checkRule300058(String idcard, String companyAddrCity,
			String companyName,String applyCode);

	/***
	 * 申请人的姓名和手机号码与系统中已有申请人的工作证明人的姓名和手机号码相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param name
	 * @param mobile
	 * @return
	 */
	public List<HistInfo> checkRule300059(String name, String mobile,String applyCode);

	/**
	 * 申请人的姓名与系统中已有申请人的工作证明人姓名相同，且已有申请人的姓名与申请人的工作证明人姓名相同，且已有申请人当前逾期大于等于5天
	 * 
	 * @param name
	 * @param workProverNames
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300060(String name,
			List<String> workProverNames, String applyCode);


	/**
	 * 一年内，信薪贷、信优贷产品借款人可认定工资较前一次申请时增长30%以上
	 * 
	 * @param idcard
	 * @param applyCode
	 * @return
	 */
	public Map<String, Object> checkRule300064(String idcard, String applyCode);

	/**
	 * 一年内，证件号码不同，申请人的单位电话与系统中已有申请人的单位电话相同，且大于等于1
	 * 
	 * @param idcard
	 * @param companyPhone
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule600001(String idcard, String companyPhone,
			String applyCode);

	/**
	 * 一年内，证件号码不同，相同单位城市，申请人的单位名称前八个字与系统中已有申请人的单位名称前八个字相同，且等于1
	 * 
	 * @param idcard
	 * @param companyAddrCity
	 * @param companyName
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule600002(String idcard, String companyAddrCity,
			String companyName, String applyCode);

	/**
	 * 同一车辆识别代号（VIN码）不同发动机号码
	 * 
	 * @param vinCode
	 * @param vehicleNo
	 * @return
	 */
	public List<HistInfo> checkRule700001(String vinCode, String engineNo,String applyCode);

	/**
	 * 同一车辆识别代号（VIN码）不同号牌号码
	 * 
	 * @param vinCode
	 * @param vehicleNo
	 * @return
	 */
	public List<HistInfo> checkRule700002(String vinCode, String vehicleNo,String applyCode);

	/**
	 * 同一发动机号码不同号牌号码
	 * 
	 * @param engineNo
	 * @param vehicleNo
	 * @return
	 */
	public List<HistInfo> checkRule700003(String engineNo, String vehicleNo,String applyCode);

	/**
	 * 同一发动机号码不同车辆识别代号（VIN码）
	 * 
	 * @param engineNo
	 * @param vinCode
	 * @return
	 */
	public List<HistInfo> checkRule700004(String engineNo, String vinCode,String applyCode);

	/**
	 * 同一号牌号码不同车辆识别代号（VIN码）
	 * 
	 * @param vehicleNo
	 * @param vinCode
	 * @return
	 */
	public List<HistInfo> checkRule700005(String vehicleNo, String vinCode,String applyCode);

	/**
	 * 同一号牌号码不同发动机号码
	 * 
	 * @param vehicleNo
	 * @param engineNo
	 * @return
	 */
	public List<HistInfo> checkRule700006(String vehicleNo, String engineNo,String applyCode);

	/**
	 * 180天内，不同申请人同一车辆识别代号（VIN码）进件大于等于2件
	 * 
	 * @param idcard
	 * @param vinCode
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule700007(String idcard, String vinCode,
			String applyCode);

	/**
	 * 180天内，不同申请人同一发动机号码进件大于等于2件
	 * 
	 * @param idcard
	 * @param engineNo
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule700008(String idcard, String engineNo,
			String applyCode);

	/**
	 * 180天内，不同申请人同一号牌号码（车牌号）进件大于等于2件
	 * 
	 * @param idcard
	 * @param vehicleNo
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule700009(String idcard, String vehicleNo,
			String applyCode);

	/**
	 * 证件号码不同，申请人手机号码与系统中已有申请人的家庭联系人号码相同，且姓名相同，且大于等于1
	 * @param idcard
	 * @param name
	 * @param mobile
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300061(String idcard, String name,
			String mobile, String applyCode);

	/**
	 * 证件号码不同，申请人手机号码与系统中已有申请人的其他联系人号码相同，且姓名相同，且大于等于1
	 * 
	 * @param idcard
	 * @param mobile
	 * @param name
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300062(String idcard, String mobile,
			String name, String applyCode);

	/**
	 * 证件号码不同，申请人手机号码与系统中已有申请人的工作证明人号码相同，且姓名相同，且大于等于1
	 * 
	 * @param idcard
	 * @param mobile
	 * @param name
	 * @param applyCode
	 * @return
	 */
	public List<HistInfo> checkRule300063(String idcard, String mobile,
			String name, String applyCode);

}
