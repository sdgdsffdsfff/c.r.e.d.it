package com.ctc.credit.blackgreylist.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.ctc.credit.blackgreylist.annotation.XlsWrite;

@Entity
@Table(name = "CREDIT_BLKGRAYLIST_DETAIL")
public class CreditBlkgraylistDetailEntity implements Serializable {

	private static final long serialVersionUID = -4882054506968303152L;
	
	@Id
	@Column(name = "ID", nullable = false)
	@GenericGenerator(name = "autoPKuuid", strategy = "uuid")
	@GeneratedValue(generator = "autoPKuuid")
	private String id;
	
	/** 渠道  **/
	@Column(name = "CHANNEL")
	private Long channel;
	
	/** 来源系统  **/
	@Column(name = "SOURCE_SYS")
	private Long sourceSys;
	
	/**
	 * warnLevel - no comment
	 */
	@Column(name = "WARN_LEVEL")
	private Long warnLevel;
	
	@Transient
	private String warnLevelDesc;
	
	@Transient
	private String status;
	
	@Transient
	private String channelDesc;
	
	@Transient
	private String sourceSysDesc;
	
	@Transient
	private String createDateDesc;
	
	/**
	 * categoryCode - no comment
	 */
	@Column(name = "CATEGORY_CODE")
	private String categoryCode;
	/**
	 * categoryDesc - no comment
	 */
	@XlsWrite(order=1)
	@Column(name = "CATEGORY_DESC")
	private String categoryDesc;
	/**
	 * enable - no comment
	 */
	@Column(name = "ENABLE")
	private Long enable;
	/**
	 * custName - no comment
	 */
	@XlsWrite(order=2)
	@Column(name = "CUST_NAME")
	private String custName;
	/**
	 * custIdnum - no comment
	 */
	@XlsWrite(order=3)
	@Column(name = "CUST_IDNUM")
	private String custIdnum;
	/**
	 * custMobile - no comment
	 */
	@XlsWrite(order=4)
	@Column(name = "CUST_MOBILE")
	private String custMobile;
	
	@Column(name = "CUST_MOBILE2")
	private String custMobile2;
	
	/**
	 * custHomeProvince - no comment
	 */
	@XlsWrite(order=5)
	@Column(name = "CUST_HOME_PROVINCE")
	private String custHomeProvince;
	/**
	 * custHomeCity - no comment
	 */
	@XlsWrite(order=6)
	@Column(name = "CUST_HOME_CITY")
	private String custHomeCity;
	/**
	 * custHomeDistrict - no comment
	 */
	@XlsWrite(order=7)
	@Column(name = "CUST_HOME_DISTRICT")
	private String custHomeDistrict;
	/**
	 * custHomeAddress - no comment
	 */
	@XlsWrite(order=8)
	@Column(name = "CUST_HOME_ADDRESS")
	private String custHomeAddress;
	/**
	 * custHomePhone - no comment
	 */
	@XlsWrite(order=9)
	@Column(name = "CUST_HOME_PHONE")
	private String custHomePhone;
	/**
	 * custCorpName - no comment
	 */
	@XlsWrite(order=10)
	@Column(name = "CUST_CORP_NAME")
	private String custCorpName;
	/**
	 * custCorpPhone - no comment
	 */
	@XlsWrite(order=11)
	@Column(name = "CUST_CORP_PHONE")
	private String custCorpPhone;
	/**
	 * custCorpAddress - no comment
	 */
	@XlsWrite(order=12)
	@Column(name = "CUST_CORP_ADDRESS")
	private String custCorpAddress;
	/**
	 * memo - no comment
	 */
	@XlsWrite(order=13)
	@Column(name = "MEMO")
	private String memo;
	/**
	 * applyNo - no comment
	 */
	@XlsWrite(order=14)
	@Column(name = "APPLY_NO")
	private String applyNo;
	
	/** 申请记录主键 **/
	@Column(name = "APPLY_ID")
	private String applyId;
	
	/** 申请记录响应序列号 **/
	@Column(name = "SEQ_NO")
	private String seqNo;
	
	/**
	 * salepersonName - no comment
	 */
	@XlsWrite(order=15)
	@Column(name = "SALEPERSON_NAME")
	private String salepersonName;
	/**
	 * departmentCity - no comment
	 */
	@XlsWrite(order=16)
	@Column(name = "DEPARTMENT_CITY")
	private String departmentCity;
	/**
	 * extInfo1 - no comment
	 */
	@XlsWrite(order=17)
	@Column(name = "EXT_INFO1")
	private String extInfo1;
	/**
	 * extInfo2 - no comment
	 */
	@XlsWrite(order=18)
	@Column(name = "EXT_INFO2")
	private String extInfo2;
	/**
	 * extInfo3 - no comment
	 */
	@XlsWrite(order=19)
	@Column(name = "EXT_INFO3")
	private String extInfo3;
	/**
	 * extInfo4 - no comment
	 */
	@XlsWrite(order=20)
	@Column(name = "EXT_INFO4")
	private String extInfo4;
	/**
	 * extInfo5 - no comment
	 */
	@XlsWrite(order=21)
	@Column(name = "EXT_INFO5")
	private String extInfo5;
	/**
	 * extInfo6 - no comment
	 */
	@XlsWrite(order=22)
	@Column(name = "EXT_INFO6")
	private String extInfo6;
	/**
	 * extInfo7 - no comment
	 */
	@XlsWrite(order=23)
	@Column(name = "EXT_INFO7")
	private String extInfo7;
	/**
	 * extInfo8 - no comment
	 */
	@XlsWrite(order=24)
	@Column(name = "EXT_INFO8")
	private String extInfo8;
	/**
	 * extInfo9 - no comment
	 */
	@XlsWrite(order=25)
	@Column(name = "EXT_INFO9")
	private String extInfo9;
	/**
	 * extInfo10 - no comment
	 */
	@XlsWrite(order=26)
	@Column(name = "EXT_INFO10")
	private String extInfo10;
	/**
	 * extInfo11 - no comment
	 */
	@XlsWrite(order=27)
	@Column(name = "EXT_INFO11")
	private String extInfo11;
	/**
	 * extInfo12 - no comment
	 */
	@XlsWrite(order=28)
	@Column(name = "EXT_INFO12")
	private String extInfo12;
	/**
	 * extInfo13 - no comment
	 */
	@XlsWrite(order=29)
	@Column(name = "EXT_INFO13")
	private String extInfo13;
	/**
	 * extInfo14 - no comment
	 */
	@XlsWrite(order=30)
	@Column(name = "EXT_INFO14")
	private String extInfo14;
	/**
	 * extInfo15 - no comment
	 */
	@XlsWrite(order=31)
	@Column(name = "EXT_INFO15")
	private String extInfo15;
	/**
	 * extInfo16 - no comment
	 */
	@XlsWrite(order=32)
	@Column(name = "EXT_INFO16")
	private String extInfo16;
	/**
	 * extInfo17 - no comment
	 */
	@XlsWrite(order=33)
	@Column(name = "EXT_INFO17")
	private String extInfo17;
	/**
	 * extInfo18 - no comment
	 */
	@XlsWrite(order=34)
	@Column(name = "EXT_INFO18")
	private String extInfo18;
	/**
	 * extInfo19 - no comment
	 */
	@XlsWrite(order=35)
	@Column(name = "EXT_INFO19")
	private String extInfo19;
	/**
	 * extInfo20 - no comment
	 */
	@XlsWrite(order=36)
	@Column(name = "EXT_INFO20")
	private String extInfo20;
	/**
	 * CREATEUSER - no comment
	 */
	@Column(name = "CREATE_USER")
	private String createUser;
	/**
	 * UPDATEUSER - no comment
	 */
	@Column(name = "UPDATE_USER")
	private String updateUser;
	
	@Column(name = "CREATE_DATE")
	private String createDate;
	/**
	 * UPDATEUSER - no comment
	 */
	@Column(name = "UPDATE_DATE")
	private String updateDate;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param warnLevel
	 *            the warnLevel to set - no comment
	 */
	public void setWarnLevel(Long warnLevel) {
		this.warnLevel = warnLevel;
	}

	/**
	 * @return the warnLevel - no comment
	 */
	
	public Long getWarnLevel() {
		return warnLevel;
	}

	/**
	 * @param categoryCode
	 *            the categoryCode to set - no comment
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the categoryCode - no comment
	 */
	
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryDesc
	 *            the categoryDesc to set - no comment
	 */
	public void setCategoryDesc(String categoryDesc) {
		this.categoryDesc = categoryDesc;
	}

	/**
	 * @return the categoryDesc - no comment
	 */
	public String getCategoryDesc() {
		return categoryDesc;
	}

	/**
	 * @param enable
	 *            the enable to set - no comment
	 */
	public void setEnable(Long enable) {
		this.enable = enable;
	}

	/**
	 * @return the enable - no comment
	 */
	public Long getEnable() {
		return enable;
	}

	/**
	 * @param custName
	 *            the custName to set - no comment
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @return the custName - no comment
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @param custIdnum
	 *            the custIdnum to set - no comment
	 */
	public void setCustIdnum(String custIdnum) {
		this.custIdnum = custIdnum;
	}

	/**
	 * @return the custIdnum - no comment
	 */
	public String getCustIdnum() {
		return custIdnum;
	}

	/**
	 * @param custMobile
	 *            the custMobile to set - no comment
	 */
	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	/**
	 * @return the custMobile - no comment
	 */
	public String getCustMobile() {
		return custMobile;
	}

	/**
	 * @param custHomeProvince
	 *            the custHomeProvince to set - no comment
	 */
	public void setCustHomeProvince(String custHomeProvince) {
		this.custHomeProvince = custHomeProvince;
	}

	/**
	 * @return the custHomeProvince - no comment
	 */
	public String getCustHomeProvince() {
		return custHomeProvince;
	}

	/**
	 * @param custHomeCity
	 *            the custHomeCity to set - no comment
	 */
	public void setCustHomeCity(String custHomeCity) {
		this.custHomeCity = custHomeCity;
	}

	/**
	 * @return the custHomeCity - no comment
	 */
	public String getCustHomeCity() {
		return custHomeCity;
	}

	/**
	 * @param custHomeDistrict
	 *            the custHomeDistrict to set - no comment
	 */
	public void setCustHomeDistrict(String custHomeDistrict) {
		this.custHomeDistrict = custHomeDistrict;
	}

	/**
	 * @return the custHomeDistrict - no comment
	 */
	public String getCustHomeDistrict() {
		return custHomeDistrict;
	}

	/**
	 * @param custHomeAddress
	 *            the custHomeAddress to set - no comment
	 */
	public void setCustHomeAddress(String custHomeAddress) {
		this.custHomeAddress = custHomeAddress;
	}

	/**
	 * @return the custHomeAddress - no comment
	 */
	public String getCustHomeAddress() {
		return custHomeAddress;
	}

	/**
	 * @param custHomePhone
	 *            the custHomePhone to set - no comment
	 */
	public void setCustHomePhone(String custHomePhone) {
		this.custHomePhone = custHomePhone;
	}

	/**
	 * @return the custHomePhone - no comment
	 */
	public String getCustHomePhone() {
		return custHomePhone;
	}

	/**
	 * @param custCorpName
	 *            the custCorpName to set - no comment
	 */
	public void setCustCorpName(String custCorpName) {
		this.custCorpName = custCorpName;
	}

	/**
	 * @return the custCorpName - no comment
	 */
	public String getCustCorpName() {
		return custCorpName;
	}

	/**
	 * @param custCorpPhone
	 *            the custCorpPhone to set - no comment
	 */
	public void setCustCorpPhone(String custCorpPhone) {
		this.custCorpPhone = custCorpPhone;
	}

	/**
	 * @return the custCorpPhone - no comment
	 */
	public String getCustCorpPhone() {
		return custCorpPhone;
	}

	/**
	 * @param custCorpAddress
	 *            the custCorpAddress to set - no comment
	 */
	public void setCustCorpAddress(String custCorpAddress) {
		this.custCorpAddress = custCorpAddress;
	}

	/**
	 * @return the custCorpAddress - no comment
	 */
	public String getCustCorpAddress() {
		return custCorpAddress;
	}

	/**
	 * @param memo
	 *            the memo to set - no comment
	 */
	public void setMemo(String memo) {
		this.memo = memo;
	}

	/**
	 * @return the memo - no comment
	 */
	public String getMemo() {
		return memo;
	}

	/**
	 * @param applyNo
	 *            the applyNo to set - no comment
	 */
	public void setApplyNo(String applyNo) {
		this.applyNo = applyNo;
	}

	/**
	 * @return the applyNo - no comment
	 */
	public String getApplyNo() {
		return applyNo;
	}

	/**
	 * @param salepersonName
	 *            the salepersonName to set - no comment
	 */
	public void setSalepersonName(String salepersonName) {
		this.salepersonName = salepersonName;
	}

	/**
	 * @return the salepersonName - no comment
	 */
	public String getSalepersonName() {
		return salepersonName;
	}

	/**
	 * @param departmentCity
	 *            the departmentCity to set - no comment
	 */
	public void setDepartmentCity(String departmentCity) {
		this.departmentCity = departmentCity;
	}

	/**
	 * @return the departmentCity - no comment
	 */
	public String getDepartmentCity() {
		return departmentCity;
	}

	/**
	 * @param extInfo1
	 *            the extInfo1 to set - no comment
	 */
	public void setExtInfo1(String extInfo1) {
		this.extInfo1 = extInfo1;
	}

	/**
	 * @return the extInfo1 - no comment
	 */
	public String getExtInfo1() {
		return extInfo1;
	}

	/**
	 * @param extInfo2
	 *            the extInfo2 to set - no comment
	 */
	public void setExtInfo2(String extInfo2) {
		this.extInfo2 = extInfo2;
	}

	/**
	 * @return the extInfo2 - no comment
	 */
	public String getExtInfo2() {
		return extInfo2;
	}

	/**
	 * @param extInfo3
	 *            the extInfo3 to set - no comment
	 */
	public void setExtInfo3(String extInfo3) {
		this.extInfo3 = extInfo3;
	}

	/**
	 * @return the extInfo3 - no comment
	 */
	public String getExtInfo3() {
		return extInfo3;
	}

	/**
	 * @param extInfo4
	 *            the extInfo4 to set - no comment
	 */
	public void setExtInfo4(String extInfo4) {
		this.extInfo4 = extInfo4;
	}

	/**
	 * @return the extInfo4 - no comment
	 */
	public String getExtInfo4() {
		return extInfo4;
	}

	/**
	 * @param extInfo5
	 *            the extInfo5 to set - no comment
	 */
	public void setExtInfo5(String extInfo5) {
		this.extInfo5 = extInfo5;
	}

	/**
	 * @return the extInfo5 - no comment
	 */
	public String getExtInfo5() {
		return extInfo5;
	}

	/**
	 * @param extInfo6
	 *            the extInfo6 to set - no comment
	 */
	public void setExtInfo6(String extInfo6) {
		this.extInfo6 = extInfo6;
	}

	/**
	 * @return the extInfo6 - no comment
	 */
	public String getExtInfo6() {
		return extInfo6;
	}

	/**
	 * @param extInfo7
	 *            the extInfo7 to set - no comment
	 */
	public void setExtInfo7(String extInfo7) {
		this.extInfo7 = extInfo7;
	}

	/**
	 * @return the extInfo7 - no comment
	 */
	public String getExtInfo7() {
		return extInfo7;
	}

	/**
	 * @param extInfo8
	 *            the extInfo8 to set - no comment
	 */
	public void setExtInfo8(String extInfo8) {
		this.extInfo8 = extInfo8;
	}

	/**
	 * @return the extInfo8 - no comment
	 */
	public String getExtInfo8() {
		return extInfo8;
	}

	/**
	 * @param extInfo9
	 *            the extInfo9 to set - no comment
	 */
	public void setExtInfo9(String extInfo9) {
		this.extInfo9 = extInfo9;
	}

	/**
	 * @return the extInfo9 - no comment
	 */
	public String getExtInfo9() {
		return extInfo9;
	}

	/**
	 * @param extInfo10
	 *            the extInfo10 to set - no comment
	 */
	public void setExtInfo10(String extInfo10) {
		this.extInfo10 = extInfo10;
	}

	/**
	 * @return the extInfo10 - no comment
	 */
	public String getExtInfo10() {
		return extInfo10;
	}

	/**
	 * @param extInfo11
	 *            the extInfo11 to set - no comment
	 */
	public void setExtInfo11(String extInfo11) {
		this.extInfo11 = extInfo11;
	}

	/**
	 * @return the extInfo11 - no comment
	 */
	public String getExtInfo11() {
		return extInfo11;
	}

	/**
	 * @param extInfo12
	 *            the extInfo12 to set - no comment
	 */
	public void setExtInfo12(String extInfo12) {
		this.extInfo12 = extInfo12;
	}

	/**
	 * @return the extInfo12 - no comment
	 */
	public String getExtInfo12() {
		return extInfo12;
	}

	/**
	 * @param extInfo13
	 *            the extInfo13 to set - no comment
	 */
	public void setExtInfo13(String extInfo13) {
		this.extInfo13 = extInfo13;
	}

	/**
	 * @return the extInfo13 - no comment
	 */
	public String getExtInfo13() {
		return extInfo13;
	}

	/**
	 * @param extInfo14
	 *            the extInfo14 to set - no comment
	 */
	public void setExtInfo14(String extInfo14) {
		this.extInfo14 = extInfo14;
	}

	/**
	 * @return the extInfo14 - no comment
	 */
	public String getExtInfo14() {
		return extInfo14;
	}

	/**
	 * @param extInfo15
	 *            the extInfo15 to set - no comment
	 */
	public void setExtInfo15(String extInfo15) {
		this.extInfo15 = extInfo15;
	}

	/**
	 * @return the extInfo15 - no comment
	 */
	public String getExtInfo15() {
		return extInfo15;
	}

	/**
	 * @param extInfo16
	 *            the extInfo16 to set - no comment
	 */
	public void setExtInfo16(String extInfo16) {
		this.extInfo16 = extInfo16;
	}

	/**
	 * @return the extInfo16 - no comment
	 */
	public String getExtInfo16() {
		return extInfo16;
	}

	/**
	 * @param extInfo17
	 *            the extInfo17 to set - no comment
	 */
	public void setExtInfo17(String extInfo17) {
		this.extInfo17 = extInfo17;
	}

	/**
	 * @return the extInfo17 - no comment
	 */
	public String getExtInfo17() {
		return extInfo17;
	}

	/**
	 * @param extInfo18
	 *            the extInfo18 to set - no comment
	 */
	public void setExtInfo18(String extInfo18) {
		this.extInfo18 = extInfo18;
	}

	/**
	 * @return the extInfo18 - no comment
	 */
	public String getExtInfo18() {
		return extInfo18;
	}

	/**
	 * @param extInfo19
	 *            the extInfo19 to set - no comment
	 */
	public void setExtInfo19(String extInfo19) {
		this.extInfo19 = extInfo19;
	}

	/**
	 * @return the extInfo19 - no comment
	 */
	public String getExtInfo19() {
		return extInfo19;
	}

	/**
	 * @param extInfo20
	 *            the extInfo20 to set - no comment
	 */
	public void setExtInfo20(String extInfo20) {
		this.extInfo20 = extInfo20;
	}

	/**
	 * @return the extInfo20 - no comment
	 */
	public String getExtInfo20() {
		return extInfo20;
	}

	/**
	 * @return the createUser
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * @param createUser the createUser to set
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	/**
	 * @return the updateUser
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * @param updateUser the updateUser to set
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the updateDate
	 */
	public String getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}
	
	public static Map<String, String> BLKGRAY_GATEGORY = new HashMap<String, String>();
	/**
	 * @return the warnLevelDesc
	 */
	public String getWarnLevelDesc() {
		return warnLevelDesc;
	}

	/**
	 * @param warnLevelDesc the warnLevelDesc to set
	 */
	public void setWarnLevelDesc(String warnLevelDesc) {
		this.warnLevelDesc = warnLevelDesc;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the createDateDesc
	 */
	public String getCreateDateDesc() {
		return createDateDesc;
	}

	/**
	 * @param createDateDesc the createDateDesc to set
	 */
	public void setCreateDateDesc(String createDateDesc) {
		this.createDateDesc = createDateDesc;
	}
	/**
	 * @return the channel
	 */
	public Long getChannel() {
		return channel;
	}

	/**
	 * @param channel the channel to set
	 */
	public void setChannel(Long channel) {
		this.channel = channel;
	}

	/**
	 * @return the sourceSys
	 */
	public Long getSourceSys() {
		return sourceSys;
	}

	/**
	 * @param sourceSys the sourceSys to set
	 */
	public void setSourceSys(Long sourceSys) {
		this.sourceSys = sourceSys;
	}
	
	/**
	 * @return the custMobile1
	 */
	public String getCustMobile1() {
		return custMobile2;
	}

	/**
	 * @param custMobile1 the custMobile1 to set
	 */
	public void setCustMobile1(String custMobile1) {
		this.custMobile2 = custMobile1;
	}

	/**
	 * @return the custMobile2
	 */
	public String getCustMobile2() {
		return custMobile2;
	}

	/**
	 * @param custMobile2 the custMobile2 to set
	 */
	public void setCustMobile2(String custMobile2) {
		this.custMobile2 = custMobile2;
	}

	/**
	 * @return the applyId
	 */
	public String getApplyId() {
		return applyId;
	}

	/**
	 * @param applyId the applyId to set
	 */
	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	/**
	 * @return the seqNo
	 */
	public String getSeqNo() {
		return seqNo;
	}

	/**
	 * @param seqNo the seqNo to set
	 */
	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	/**
	 * @return the channelDesc
	 */
	public String getChannelDesc() {
		return channelDesc;
	}

	/**
	 * @param channelDesc the channelDesc to set
	 */
	public void setChannelDesc(String channelDesc) {
		this.channelDesc = channelDesc;
	}

	/**
	 * @return the sourceSysDesc
	 */
	public String getSourceSysDesc() {
		return sourceSysDesc;
	}

	/**
	 * @param sourceSysDesc the sourceSysDesc to set
	 */
	public void setSourceSysDesc(String sourceSysDesc) {
		this.sourceSysDesc = sourceSysDesc;
	}

	static{
		BLKGRAY_GATEGORY.put("欺诈客户黑名单", "fraud_customet_blacklist");
		BLKGRAY_GATEGORY.put("内部不良客户黑名单", "undesirable_customer_blacklist");
		BLKGRAY_GATEGORY.put("营业部反馈同行黑名单", "peer_blacklist");
		BLKGRAY_GATEGORY.put("人法网失信黑名单", "court_blacklist");
		BLKGRAY_GATEGORY.put("网络客户黑名单", "network_blacklist");
		BLKGRAY_GATEGORY.put("内部营业部拒绝黑名单", "rejected_customer_blacklist");
		BLKGRAY_GATEGORY.put("不良嗜好客户黑名单", "addiction_customer_blacklist");
		BLKGRAY_GATEGORY.put("家人反对贷款客户黑名单", "against_customer_blacklist");
		BLKGRAY_GATEGORY.put("恶意投诉客户黑名单", "maliciousclaim_customer_blacklist");
		BLKGRAY_GATEGORY.put("不良单位黑名单", "undesirable_company_blacklist");
		BLKGRAY_GATEGORY.put("倒闭工厂黑名单", "closedown_company_blacklist");
		BLKGRAY_GATEGORY.put("关注电话黑名单", "focus_phone_blacklist");
		BLKGRAY_GATEGORY.put("内部员工黑名单", "staff_blacklist");
		BLKGRAY_GATEGORY.put("外部征信黑名单", "out_credit_blacklist");//如：平安前海
		BLKGRAY_GATEGORY.put("疑似欺诈客户灰名单A", "A_fraud_customer_graylist");
		BLKGRAY_GATEGORY.put("疑似欺诈客户灰名单B", "B_fraud_customer_graylist");
		BLKGRAY_GATEGORY.put("疑似欺诈客户灰名单C", "C_fraud_customet_graylist");
		BLKGRAY_GATEGORY.put("疑似欺诈客户灰名单D", "D_fraud_customet_graylist");
		BLKGRAY_GATEGORY.put("身份泄露客户灰名单",  "disclosure_customer_graylist");
		BLKGRAY_GATEGORY.put("营业部同业灰名单","peer_graylist");
		BLKGRAY_GATEGORY.put("关注电话黑名单超时转灰", "phone_graylist");
		BLKGRAY_GATEGORY.put("违规销售人员进件客户灰名单", "salemen_graylist");
	}
}
