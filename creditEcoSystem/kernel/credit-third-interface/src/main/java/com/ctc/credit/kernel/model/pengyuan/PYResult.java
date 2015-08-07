package com.ctc.credit.kernel.model.pengyuan;

import java.io.Serializable;
import java.util.List;

public class PYResult implements Serializable {

	private static final long serialVersionUID = -3906671860346274804L;

	private CreditApply cisReport;
	private PersonCheckInfo policeCheckInfo;
	private List<CisArtificialPersonInfo> artificialNationalInfoList;
	private CisPersonShareStock nationalPersonShareholderReport;
	private CisSeniorManager personTopManagerInfo;
	private CisCropInfo corpBaseNationalInfo;
	private CisCropExtendInfo registerContactInfos;
	private List<CisCropExtendInfo> manageContactInfosList;
	private CisOrgShareholderInfo nationalCorpShareholderInfo;
	private CisOrgSeniorManager corpTopManagerInfo;
	private CisCropOtherShareholderIf nationalCorpOtherShareholderInfo;
	private CisArtificialHolderIf nationalFrOtherCorpShareholderInfo;
	private CisTelCheckInfo telCheckInfo;
	private CisMoblieCheckInfo MoblieCheckInfo;
	private CisCourtDealInfo courtInfos;
	private CisPersonInfo personBaseInfo;
	private CisEducationInfo _personBaseInfo;
	private CisDegreeInfo degreeInfo;
	private CisCollegeInfo collegeInfo;
	private CisEducationCheck educationCheck;
	private CisEducationCheck educationInSchoolCheck;
	private CisPersonIndentityInfo PersonIndentityInfo;
	private CisPersonIdInfo identityVerifyInfo;
	private CisOstaInfo ostaInfo;

	public CisOstaInfo getOstaInfo() {
		return ostaInfo;
	}

	public void setOstaInfo(CisOstaInfo ostaInfo) {
		this.ostaInfo = ostaInfo;
	}
	public CisPersonIdInfo getIdentityVerifyInfo() {
		return identityVerifyInfo;
	}

	public void setIdentityVerifyInfo(CisPersonIdInfo identityVerifyInfo) {
		this.identityVerifyInfo = identityVerifyInfo;
	}
	public CreditApply getCisReport() {
		return cisReport;
	}

	public void setCisReport(CreditApply cisReport) {
		this.cisReport = cisReport;
	}

	public PersonCheckInfo getPoliceCheckInfo() {
		return policeCheckInfo;
	}

	public void setPoliceCheckInfo(PersonCheckInfo policeCheckInfo) {
		this.policeCheckInfo = policeCheckInfo;
	}

//	public CisArtificialPersonInfo getArtificialNationalInfo() {
//		return artificialNationalInfo;
//	}
//
//	public void setArtificialNationalInfo(
//			CisArtificialPersonInfo artificialNationalInfo) {
//		this.artificialNationalInfo = artificialNationalInfo;
//	}

	public CisPersonShareStock getNationalPersonShareholderReport() {
		return nationalPersonShareholderReport;
	}

	public CisEducationCheck getEducationInSchoolCheck() {
		return educationInSchoolCheck;
	}

	public void setEducationInSchoolCheck(
			CisEducationCheck educationInSchoolCheck) {
		this.educationInSchoolCheck = educationInSchoolCheck;
	}

	public void setNationalPersonShareholderReport(
			CisPersonShareStock nationalPersonShareholderReport) {
		this.nationalPersonShareholderReport = nationalPersonShareholderReport;
	}

	public CisSeniorManager getPersonTopManagerInfo() {
		return personTopManagerInfo;
	}

	public void setPersonTopManagerInfo(CisSeniorManager personTopManagerInfo) {
		this.personTopManagerInfo = personTopManagerInfo;
	}

	public CisCropInfo getCorpBaseNationalInfo() {
		return corpBaseNationalInfo;
	}

	public void setCorpBaseNationalInfo(CisCropInfo corpBaseNationalInfo) {
		this.corpBaseNationalInfo = corpBaseNationalInfo;
	}

	public CisOrgShareholderInfo getNationalCorpShareholderInfo() {
		return nationalCorpShareholderInfo;
	}

	public void setNationalCorpShareholderInfo(
			CisOrgShareholderInfo nationalCorpShareholderInfo) {
		this.nationalCorpShareholderInfo = nationalCorpShareholderInfo;
	}

	public CisOrgSeniorManager getCorpTopManagerInfo() {
		return corpTopManagerInfo;
	}

	public void setCorpTopManagerInfo(CisOrgSeniorManager corpTopManagerInfo) {
		this.corpTopManagerInfo = corpTopManagerInfo;
	}

	public CisCropOtherShareholderIf getNationalCorpOtherShareholderInfo() {
		return nationalCorpOtherShareholderInfo;
	}

	public void setNationalCorpOtherShareholderInfo(
			CisCropOtherShareholderIf nationalCorpOtherShareholderInfo) {
		this.nationalCorpOtherShareholderInfo = nationalCorpOtherShareholderInfo;
	}

	public List<CisArtificialPersonInfo> getArtificialNationalInfoList() {
		return artificialNationalInfoList;
	}

	public void setArtificialNationalInfoList(
			List<CisArtificialPersonInfo> artificialNationalInfoList) {
		this.artificialNationalInfoList = artificialNationalInfoList;
	}


	public CisArtificialHolderIf getNationalFrOtherCorpShareholderInfo() {
		return nationalFrOtherCorpShareholderInfo;
	}

	public void setNationalFrOtherCorpShareholderInfo(
			CisArtificialHolderIf nationalFrOtherCorpShareholderInfo) {
		this.nationalFrOtherCorpShareholderInfo = nationalFrOtherCorpShareholderInfo;
	}

	public CisTelCheckInfo getTelCheckInfo() {
		return telCheckInfo;
	}

	public void setTelCheckInfo(CisTelCheckInfo telCheckInfo) {
		this.telCheckInfo = telCheckInfo;
	}

	public CisMoblieCheckInfo getMoblieCheckInfo() {
		return MoblieCheckInfo;
	}

	public CisCropExtendInfo getRegisterContactInfos() {
		return registerContactInfos;
	}

	public void setRegisterContactInfos(CisCropExtendInfo registerContactInfos) {
		this.registerContactInfos = registerContactInfos;
	}

	public List<CisCropExtendInfo> getManageContactInfosList() {
		return manageContactInfosList;
	}

	public void setManageContactInfosList(List<CisCropExtendInfo> manageContactInfosList) {
		this.manageContactInfosList = manageContactInfosList;
	}

	public void setMoblieCheckInfo(CisMoblieCheckInfo moblieCheckInfo) {
		MoblieCheckInfo = moblieCheckInfo;
	}

	public CisCourtDealInfo getCourtInfos() {
		return courtInfos;
	}

	public void setCourtInfos(CisCourtDealInfo courtInfos) {
		this.courtInfos = courtInfos;
	}

	public CisPersonInfo getPersonBaseInfo() {
		return personBaseInfo;
	}

	public void setPersonBaseInfo(CisPersonInfo personBaseInfo) {
		this.personBaseInfo = personBaseInfo;
	}

	public CisEducationInfo get_personBaseInfo() {
		return _personBaseInfo;
	}

	public void set_personBaseInfo(CisEducationInfo _personBaseInfo) {
		this._personBaseInfo = _personBaseInfo;
	}

	public CisDegreeInfo getDegreeInfo() {
		return degreeInfo;
	}

	public void setDegreeInfo(CisDegreeInfo degreeInfo) {
		this.degreeInfo = degreeInfo;
	}

	public CisCollegeInfo getCollegeInfo() {
		return collegeInfo;
	}

	public void setCollegeInfo(CisCollegeInfo collegeInfo) {
		this.collegeInfo = collegeInfo;
	}

	public CisEducationCheck getEducationCheck() {
		return educationCheck;
	}

	public void setEducationCheck(CisEducationCheck educationCheck) {
		this.educationCheck = educationCheck;
	}

	public CisPersonIndentityInfo getPersonIndentityInfo() {
		return PersonIndentityInfo;
	}

	public void setPersonIndentityInfo(
			CisPersonIndentityInfo personIndentityInfo) {
		PersonIndentityInfo = personIndentityInfo;
	}

}
