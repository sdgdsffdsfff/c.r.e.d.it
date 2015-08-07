package com.ctc.credit.antifraud.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "customer_info")
public class CustomerInfo extends AbstractCreditEntity {
	private static final long serialVersionUID = -7043501376536020566L;
	
	private String applyCode;
	private String name;
	private String idtype;
	private String idcard;
	private Integer sex;
	private Date birthday;
	private Integer maritalStatus;
	private Integer highestEducation;
	private Integer highestDiploma;
	private String mobile;
	private String mobile1;
	private String emailAddress;
	private String homePhone;
	private String companyName;
	private String curWorkStartyear;
	private String companyIndustry;
	private String profession;
	private Integer post;
	private Integer professionalTitle;
	private String department;
	private String companyAddrProvince;
	private String companyAddrCity;
	private String companyAddrDistrict;
	private String companyAddresss;
	private String companyPostcode;
	private String companyPhone;
	private Integer yearlyIncome;
	private Integer approveIncome;
	private String spouseName;
	private String spouseIdtype;
	private String spouseIdno;
	private String spouseCompany;
	private String spouseMobile;
	private String censusAddrProvince;
	private String censusAddrCity;
	private String censusAddrDistrict;
	private String censusAddresss;
	private String homeAddrProvince;
	private String homeAddrCity;
	private String homeAddrDistrict;
	private String homeAddresss;
	private String homePostcode;
	private String residenceStatus;
	private String housingAddrProvince;
	private String housingAddrCity;
	private String housingAddrDistrict;
	private String housingAddresss;
	private String housingPostcode;
	private String vinCode;
	private String vehicleNo;
	private Integer carPrice;
	private String engineNo;
	private Integer lendingAmount;
	private String salesmanName;
	private String departmentCity;
	private String businessType;
	private String businessSubType;
	private Date applyDate;
	private String applyChannel;
	private String applyProductCode;
	private Integer loanApplyAmount;
	private Integer loanApplyMonths;
	private String approvedProductCode;
	private String occurPlace;
	private String repaymentBankAccount;
	private String currentBusinessType;
	private String sourceSys;
	private String applySubchannel;
	private String refusedCode1;
	private String refusedCode2;
	private String refusedCode3;
	private String refusedCode4;

	
	
	/**
	 * @return the applyCode
	 */
	@Column(name="apply_code",length=50)
	public String getApplyCode() {
		return applyCode;
	}

	/**
	 * @param applyCode
	 *            the applyCode to set
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * @return the name
	 */
	@Column(name="name",length=50)
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the idtype
	 */
	@Column(name="idtype",length=1)
	public String getIdtype() {
		return idtype;
	}

	/**
	 * @param idtype
	 *            the idtype to set
	 */
	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	/**
	 * @return the idcard
	 */
	@Column(name="idcard")
	public String getIdcard() {
		return idcard;
	}

	/**
	 * @param idcard
	 *            the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	/**
	 * @return the sex
	 */
	@Column(name="sex",length=1)
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the birthday
	 */
	@Column(name="birthday")
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the maritalStatus
	 */
	@Column(name="marital_status",length=2)
	public Integer getMaritalStatus() {
		return maritalStatus;
	}

	/**
	 * @param maritalStatus
	 *            the maritalStatus to set
	 */
	public void setMaritalStatus(Integer maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	/**
	 * @return the highestEducation
	 */
	@Column(name="highest_education",length=2)
	public Integer getHighestEducation() {
		return highestEducation;
	}

	/**
	 * @param highestEducation
	 *            the highestEducation to set
	 */
	public void setHighestEducation(Integer highestEducation) {
		this.highestEducation = highestEducation;
	}

	/**
	 * @return the highestDiploma
	 */
	@Column(name="highest_diploma",length=1)
	public Integer getHighestDiploma() {
		return highestDiploma;
	}

	/**
	 * @param highestDiploma
	 *            the highestDiploma to set
	 */
	public void setHighestDiploma(Integer highestDiploma) {
		this.highestDiploma = highestDiploma;
	}

	/**
	 * @return the mobile
	 */
	@Column(name="mobile",length=16)
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the mobile1
	 */
	@Column(name="mobile1",length=255)
	public String getMobile1() {
		return mobile1;
	}

	/**
	 * @param mobile1
	 *            the mobile1 to set
	 */
	public void setMobile1(String mobile1) {
		this.mobile1 = mobile1;
	}

	/**
	 * @return the emailAddress
	 */
	@Column(name="email_address",length=30)
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the homePhone
	 */
	@Column(name="home_phone",length=255)
	public String getHomePhone() {
		return homePhone;
	}

	/**
	 * @param homePhone
	 *            the homePhone to set
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	/**
	 * @return the companyName
	 */
	@Column(name="company_name",length=255)
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the curWorkStartyear
	 */
	@Column(name="cur_work_startyear",length=255)
	public String getCurWorkStartyear() {
		return curWorkStartyear;
	}

	/**
	 * @param curWorkStartyear
	 *            the curWorkStartyear to set
	 */
	public void setCurWorkStartyear(String curWorkStartyear) {
		this.curWorkStartyear = curWorkStartyear;
	}

	/**
	 * @return the companyIndustry
	 */
	@Column(name="company_industry",length=1)
	public String getCompanyIndustry() {
		return companyIndustry;
	}

	/**
	 * @param companyIndustry
	 *            the companyIndustry to set
	 */
	public void setCompanyIndustry(String companyIndustry) {
		this.companyIndustry = companyIndustry;
	}

	/**
	 * @return the profession
	 */
	@Column(name="profession",length=1)
	public String getProfession() {
		return profession;
	}

	/**
	 * @param profession
	 *            the profession to set
	 */
	public void setProfession(String profession) {
		this.profession = profession;
	}

	/**
	 * @return the post
	 */
	@Column(name="post",length=1)
	public Integer getPost() {
		return post;
	}

	/**
	 * @param post
	 *            the post to set
	 */
	public void setPost(Integer post) {
		this.post = post;
	}

	/**
	 * @return the professionalTitle
	 */
	@Column(name="professional_title",length=1)
	public Integer getProfessionalTitle() {
		return professionalTitle;
	}

	/**
	 * @param professionalTitle
	 *            the professionalTitle to set
	 */
	public void setProfessionalTitle(Integer professionalTitle) {
		this.professionalTitle = professionalTitle;
	}

	/**
	 * @return the department
	 */
	@Column(name="department")
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department
	 *            the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the companyAddrProvince
	 */
	@Column(name="company_addr_province",length=255)
	public String getCompanyAddrProvince() {
		return companyAddrProvince;
	}

	/**
	 * @param companyAddrProvince
	 *            the companyAddrProvince to set
	 */
	public void setCompanyAddrProvince(String companyAddrProvince) {
		this.companyAddrProvince = companyAddrProvince;
	}

	/**
	 * @return the companyAddrCity
	 */
	@Column(name="company_addr_city",length=255)
	public String getCompanyAddrCity() {
		return companyAddrCity;
	}

	/**
	 * @param companyAddrCity
	 *            the companyAddrCity to set
	 */
	public void setCompanyAddrCity(String companyAddrCity) {
		this.companyAddrCity = companyAddrCity;
	}

	/**
	 * @return the companyAddrDistrict
	 */
	@Column(name="company_addr_district",length=255)
	public String getCompanyAddrDistrict() {
		return companyAddrDistrict;
	}

	/**
	 * @param companyAddrDistrict
	 *            the companyAddrDistrict to set
	 */
	public void setCompanyAddrDistrict(String companyAddrDistrict) {
		this.companyAddrDistrict = companyAddrDistrict;
	}

	/**
	 * @return the companyAddresss
	 */
	@Column(name="company_addresss",length=255)
	public String getCompanyAddresss() {
		return companyAddresss;
	}

	/**
	 * @param companyAddresss
	 *            the companyAddresss to set
	 */
	public void setCompanyAddresss(String companyAddresss) {
		this.companyAddresss = companyAddresss;
	}

	/**
	 * @return the companyPostcode
	 */
	@Column(name="company_postcode",length=15)
	public String getCompanyPostcode() {
		return companyPostcode;
	}

	/**
	 * @param companyPostcode
	 *            the companyPostcode to set
	 */
	public void setCompanyPostcode(String companyPostcode) {
		this.companyPostcode = companyPostcode;
	}

	/**
	 * @return the companyPhone
	 */
	@Column(name="company_phone",length=255)
	public String getCompanyPhone() {
		return companyPhone;
	}

	/**
	 * @param companyPhone
	 *            the companyPhone to set
	 */
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}

	/**
	 * @return the yearlyIncome
	 */
	@Column(name="yearly_income")
	public Integer getYearlyIncome() {
		return yearlyIncome;
	}

	/**
	 * @param yearlyIncome
	 *            the yearlyIncome to set
	 */
	public void setYearlyIncome(Integer yearlyIncome) {
		this.yearlyIncome = yearlyIncome;
	}

	/**
	 * @return the approveIncome
	 */
	@Column(name="approve_income",length=10)
	public Integer getApproveIncome() {
		return approveIncome;
	}

	/**
	 * @param approveIncome
	 *            the approveIncome to set
	 */
	public void setApproveIncome(Integer approveIncome) {
		this.approveIncome = approveIncome;
	}

	/**
	 * @return the spouseIdtype
	 */
	@Column(name="spouse_idtype",length=1)
	public String getSpouseIdtype() {
		return spouseIdtype;
	}

	/**
	 * @param spouseIdtype
	 *            the spouseIdtype to set
	 */
	public void setSpouseIdtype(String spouseIdtype) {
		this.spouseIdtype = spouseIdtype;
	}

	/**
	 * @return the spouseIdno
	 */
	@Column(name="spouse_idno")
	public String getSpouseIdno() {
		return spouseIdno;
	}

	/**
	 * @param spouseIdno
	 *            the spouseIdno to set
	 */
	public void setSpouseIdno(String spouseIdno) {
		this.spouseIdno = spouseIdno;
	}

	/**
	 * @return the spouseCompany
	 */
	@Column(name="spouse_company",length=100)
	public String getSpouseCompany() {
		return spouseCompany;
	}

	/**
	 * @param spouseCompany
	 *            the spouseCompany to set
	 */
	public void setSpouseCompany(String spouseCompany) {
		this.spouseCompany = spouseCompany;
	}

	/**
	 * @return the spouseMobile
	 */
	@Column(name="spouse_mobile",length=25)
	public String getSpouseMobile() {
		return spouseMobile;
	}

	/**
	 * @param spouseMobile
	 *            the spouseMobile to set
	 */
	public void setSpouseMobile(String spouseMobile) {
		this.spouseMobile = spouseMobile;
	}

	/**
	 * @return the censusAddrProvince
	 */
	@Column(name="census_addr_province",length=255)
	public String getCensusAddrProvince() {
		return censusAddrProvince;
	}

	/**
	 * @param censusAddrProvince
	 *            the censusAddrProvince to set
	 */
	public void setCensusAddrProvince(String censusAddrProvince) {
		this.censusAddrProvince = censusAddrProvince;
	}

	/**
	 * @return the censusAddrCity
	 */
	@Column(name="census_addr_city",length=255)
	public String getCensusAddrCity() {
		return censusAddrCity;
	}

	/**
	 * @param censusAddrCity
	 *            the censusAddrCity to set
	 */
	public void setCensusAddrCity(String censusAddrCity) {
		this.censusAddrCity = censusAddrCity;
	}

	/**
	 * @return the censusAddrDistrict
	 */
	@Column(name="census_addr_district",length=255)
	public String getCensusAddrDistrict() {
		return censusAddrDistrict;
	}

	/**
	 * @param censusAddrDistrict
	 *            the censusAddrDistrict to set
	 */
	public void setCensusAddrDistrict(String censusAddrDistrict) {
		this.censusAddrDistrict = censusAddrDistrict;
	}

	/**
	 * @return the censusAddresss
	 */
	@Column(name="census_addresss",length=255)
	public String getCensusAddresss() {
		return censusAddresss;
	}

	/**
	 * @param censusAddresss
	 *            the censusAddresss to set
	 */
	public void setCensusAddresss(String censusAddresss) {
		this.censusAddresss = censusAddresss;
	}

	/**
	 * @return the homeAddrProvince
	 */
	@Column(name="home_addr_province",length=255)
	public String getHomeAddrProvince() {
		return homeAddrProvince;
	}

	/**
	 * @param homeAddrProvince
	 *            the homeAddrProvince to set
	 */
	public void setHomeAddrProvince(String homeAddrProvince) {
		this.homeAddrProvince = homeAddrProvince;
	}

	/**
	 * @return the homeAddrCity
	 */
	@Column(name="home_addr_city",length=255)
	public String getHomeAddrCity() {
		return homeAddrCity;
	}

	/**
	 * @param homeAddrCity
	 *            the homeAddrCity to set
	 */
	public void setHomeAddrCity(String homeAddrCity) {
		this.homeAddrCity = homeAddrCity;
	}

	/**
	 * @return the homeAddrDistrict
	 */
	@Column(name="home_addr_district",length=255)
	public String getHomeAddrDistrict() {
		return homeAddrDistrict;
	}

	/**
	 * @param homeAddrDistrict
	 *            the homeAddrDistrict to set
	 */
	public void setHomeAddrDistrict(String homeAddrDistrict) {
		this.homeAddrDistrict = homeAddrDistrict;
	}

	/**
	 * @return the homeAddresss
	 */
	@Column(name="home_addresss",length=255)
	public String getHomeAddresss() {
		return homeAddresss;
	}

	/**
	 * @param homeAddresss
	 *            the homeAddresss to set
	 */
	public void setHomeAddresss(String homeAddresss) {
		this.homeAddresss = homeAddresss;
	}

	/**
	 * @return the homePostcode
	 */
	@Column(name="home_postcode",length=15)
	public String getHomePostcode() {
		return homePostcode;
	}

	/**
	 * @param homePostcode
	 *            the homePostcode to set
	 */
	public void setHomePostcode(String homePostcode) {
		this.homePostcode = homePostcode;
	}

	/**
	 * @return the residenceStatus
	 */
	@Column(name="residence_status",length=1)
	public String getResidenceStatus() {
		return residenceStatus;
	}

	/**
	 * @param residenceStatus
	 *            the residenceStatus to set
	 */
	public void setResidenceStatus(String residenceStatus) {
		this.residenceStatus = residenceStatus;
	}

	/**
	 * @return the housingAddrProvince
	 */
	@Column(name="housing_addr_province",length=255)
	public String getHousingAddrProvince() {
		return housingAddrProvince;
	}

	/**
	 * @param housingAddrProvince
	 *            the housingAddrProvince to set
	 */
	public void setHousingAddrProvince(String housingAddrProvince) {
		this.housingAddrProvince = housingAddrProvince;
	}

	/**
	 * @return the housingAddrCity
	 */
	@Column(name="housing_addr_city",length=255)
	public String getHousingAddrCity() {
		return housingAddrCity;
	}

	/**
	 * @param housingAddrCity
	 *            the housingAddrCity to set
	 */
	public void setHousingAddrCity(String housingAddrCity) {
		this.housingAddrCity = housingAddrCity;
	}

	/**
	 * @return the housingAddrDistrict
	 */
	@Column(name="housing_addr_district",length=255)
	public String getHousingAddrDistrict() {
		return housingAddrDistrict;
	}

	/**
	 * @param housingAddrDistrict
	 *            the housingAddrDistrict to set
	 */
	public void setHousingAddrDistrict(String housingAddrDistrict) {
		this.housingAddrDistrict = housingAddrDistrict;
	}

	/**
	 * @return the housingAddresss
	 */
	@Column(name="housing_addresss",length=255)
	public String getHousingAddresss() {
		return housingAddresss;
	}

	/**
	 * @param housingAddresss
	 *            the housingAddresss to set
	 */
	public void setHousingAddresss(String housingAddresss) {
		this.housingAddresss = housingAddresss;
	}

	/**
	 * @return the housingPostcode
	 */
	@Column(name="housing_postcode",length=15)
	public String getHousingPostcode() {
		return housingPostcode;
	}

	/**
	 * @param housingPostcode
	 *            the housingPostcode to set
	 */
	public void setHousingPostcode(String housingPostcode) {
		this.housingPostcode = housingPostcode;
	}

	/**
	 * @return the vehicleNo
	 */
	@Column(name="vehicle_no",length=255)
	public String getVehicleNo() {
		return vehicleNo;
	}

	/**
	 * @param vehicleNo
	 *            the vehicleNo to set
	 */
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	/**
	 * @return the carPrice
	 */
	@Column(name="car_price",length=10)
	public Integer getCarPrice() {
		return carPrice;
	}

	/**
	 * @param carPrice
	 *            the carPrice to set
	 */
	public void setCarPrice(Integer carPrice) {
		this.carPrice = carPrice;
	}

	/**
	 * @return the engineNo
	 */
	@Column(name="engine_no",length=50)
	public String getEngineNo() {
		return engineNo;
	}

	/**
	 * @param engineNo
	 *            the engineNo to set
	 */
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}

	/**
	 * @return the lendingAmount
	 */
	@Column(name="lending_amount",length=10)
	public Integer getLendingAmount() {
		return lendingAmount;
	}

	/**
	 * @param lendingAmount
	 *            the lendingAmount to set
	 */
	public void setLendingAmount(Integer lendingAmount) {
		this.lendingAmount = lendingAmount;
	}

	/**
	 * @return the salesmanName
	 */
	@Column(name="salesman_name",length=50)
	public String getSalesmanName() {
		return salesmanName;
	}

	/**
	 * @param salesmanName
	 *            the salesmanName to set
	 */
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}

	/**
	 * @return the departmentCity
	 */
	@Column(name="department_city",length=50)
	public String getDepartmentCity() {
		return departmentCity;
	}

	/**
	 * @param departmentCity
	 *            the departmentCity to set
	 */
	public void setDepartmentCity(String departmentCity) {
		this.departmentCity = departmentCity;
	}
	
	/**
	 * @return the businessType
	 */
	@Column(name="business_type",length=1)
	public String getBusinessType() {
		return businessType;
	}
	/**
	 * @param businessType the businessType to set
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	/**
	 * @return the businessSubType
	 */
	@Column(name="business_sub_type",length=2)
	public String getBusinessSubType() {
		return businessSubType;
	}
	/**
	 * @param businessSubType the businessSubType to set
	 */
	public void setBusinessSubType(String businessSubType) {
		this.businessSubType = businessSubType;
	}
	/**
	 * @return the applyDate
	 */
	@Column(name="apply_date")
	public Date getApplyDate() {
		return applyDate;
	}
	/**
	 * @param applyDate the applyDate to set
	 */
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	/**
	 * @return the applyChannel
	 */
	@Column(name="apply_channel",length=10)
	public String getApplyChannel() {
		return applyChannel;
	}
	/**
	 * @param applyChannel the applyChannel to set
	 */
	public void setApplyChannel(String applyChannel) {
		this.applyChannel = applyChannel;
	}
	/**
	 * @return the applyProductCode
	 */
	@Column(name="apply_product_code",length=5)
	public String getApplyProductCode() {
		return applyProductCode;
	}
	/**
	 * @param applyProductCode the applyProductCode to set
	 */
	public void setApplyProductCode(String applyProductCode) {
		this.applyProductCode = applyProductCode;
	}
	/**
	 * @return the loanApplyAmount
	 */
	@Column(name="loan_apply_amount",length=10)
	public Integer getLoanApplyAmount() {
		return loanApplyAmount;
	}
	/**
	 * @param loanApplyAmount the loanApplyAmount to set
	 */
	public void setLoanApplyAmount(Integer loanApplyAmount) {
		this.loanApplyAmount = loanApplyAmount;
	}
	/**
	 * @return the loanApplyMonths
	 */
	@Column(name="loan_apply_months",length=10)
	public Integer getLoanApplyMonths() {
		return loanApplyMonths;
	}
	/**
	 * @param loanApplyMonths the loanApplyMonths to set
	 */
	public void setLoanApplyMonths(Integer loanApplyMonths) {
		this.loanApplyMonths = loanApplyMonths;
	}
	/**
	 * @return the approvedProductCode
	 */
	@Column(name="approved_product_code",length=5)
	public String getApprovedProductCode() {
		return approvedProductCode;
	}
	/**
	 * @param approvedProductCode the approvedProductCode to set
	 */
	public void setApprovedProductCode(String approvedProductCode) {
		this.approvedProductCode = approvedProductCode;
	}
	/**
	 * @return the occurPlace
	 */
	@Column(name="occur_place",length=6)
	public String getOccurPlace() {
		return occurPlace;
	}
	/**
	 * @param occurPlace the occurPlace to set
	 */
	public void setOccurPlace(String occurPlace) {
		this.occurPlace = occurPlace;
	}
	/**
	 * @return the repaymentBankAccount
	 */
	@Column(name="repayment_bank_account",length=50)
	public String getRepaymentBankAccount() {
		return repaymentBankAccount;
	}
	/**
	 * @param repaymentBankAccount the repaymentBankAccount to set
	 */
	public void setRepaymentBankAccount(String repaymentBankAccount) {
		this.repaymentBankAccount = repaymentBankAccount;
	}

	/**
	 * @return the currentBusinessType
	 */
	@Column(name="current_business_type",length=2)
	public String getCurrentBusinessType() {
		return currentBusinessType;
	}

	/**
	 * @param currentBusinessType the currentBusinessType to set
	 */
	public void setCurrentBusinessType(String currentBusinessType) {
		this.currentBusinessType = currentBusinessType;
	}


	/**
	 * @return the sourceSys
	 */
	@Column(name="source_sys",length=2)
	public String getSourceSys() {
		return sourceSys;
	}

	/**
	 * @param sourceSys the sourceSys to set
	 */
	public void setSourceSys(String sourceSys) {
		this.sourceSys = sourceSys;
	}

	/**
	 * @return the applySubchannel
	 */
	@Column(name="apply_subchannel",length=10)
	public String getApplySubchannel() {
		return applySubchannel;
	}

	/**
	 * @param applySubchannel the applySubchannel to set
	 */
	public void setApplySubchannel(String applySubchannel) {
		this.applySubchannel = applySubchannel;
	}

	/**
	 * @return the refusedCode1
	 */
	@Column(name="refused_code1",length=50)
	public String getRefusedCode1() {
		return refusedCode1;
	}

	/**
	 * @param refusedCode1 the refusedCode1 to set
	 */
	public void setRefusedCode1(String refusedCode1) {
		this.refusedCode1 = refusedCode1;
	}

	/**
	 * @return the refusedCode2
	 */
	@Column(name="refused_code2",length=50)
	public String getRefusedCode2() {
		return refusedCode2;
	}

	/**
	 * @param refusedCode2 the refusedCode2 to set
	 */
	public void setRefusedCode2(String refusedCode2) {
		this.refusedCode2 = refusedCode2;
	}

	/**
	 * @return the refusedCode3
	 */
	@Column(name="refused_code3",length=50)
	public String getRefusedCode3() {
		return refusedCode3;
	}

	/**
	 * @param refusedCode3 the refusedCode3 to set
	 */
	public void setRefusedCode3(String refusedCode3) {
		this.refusedCode3 = refusedCode3;
	}

	/**
	 * @return the refusedCode4
	 */
	@Column(name="refused_code4",length=50)
	public String getRefusedCode4() {
		return refusedCode4;
	}

	/**
	 * @param refusedCode4 the refusedCode4 to set
	 */
	public void setRefusedCode4(String refusedCode4) {
		this.refusedCode4 = refusedCode4;
	}

	/**
	 * @return the spouseName
	 */
	@Column(name="spouse_name")
	public String getSpouseName() {
		return spouseName;
	}

	/**
	 * @param spouseName the spouseName to set
	 */
	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	/**
	 * @return the vinCode
	 */
	@Column(name="vin_code",length=25)
	public String getVinCode() {
		return vinCode;
	}

	/**
	 * @param vinCode the vinCode to set
	 */
	public void setVinCode(String vinCode) {
		this.vinCode = vinCode;
	}

}
