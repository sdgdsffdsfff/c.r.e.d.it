package com.ctc.credit.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import com.ctc.credit.antifraud.model.ContactsInfo;
import com.ctc.credit.antifraud.model.FraudQueryCondition;
import com.ctc.credit.kernel.util.CustDateMorpher;

public class EntityParse {

	/**
	 * 解析反欺诈请求参数，主要处理特殊的日期字符串，和数组
	 * 
	 * @param jsonStr 带解析字符串
	 * @return
	 */
	public static FraudQueryCondition parseFraudQueryEntity(String jsonStr) throws JSONException{
		if (StringUtils.isEmpty(jsonStr)) {
			throw new RuntimeException("待解析字符串不得为空");
		}
		FraudQueryCondition queryCondition;
		try {
			JSONObject jsonObject = JSONObject.fromObject(jsonStr);
			String[] dateFormats = new String[] {"yyyy-MM-dd HH:mm:ss"};
			CustDateMorpher dateMorpher = new CustDateMorpher(dateFormats);
			JSONUtils.getMorpherRegistry().registerMorpher(dateMorpher);
			JSONArray contactsInfos = (JSONArray) jsonObject.get("contactsInfo");
			List<ContactsInfo> contactsInfos2 = new ArrayList<ContactsInfo>();
			for (Object object : contactsInfos) {
				JSONObject object2 = (JSONObject) object;
				ContactsInfo contactsInfo = (ContactsInfo) JSONObject.toBean(object2,ContactsInfo.class);
				contactsInfos2.add(contactsInfo);
			}
			queryCondition = (FraudQueryCondition) JSONObject.toBean(jsonObject,FraudQueryCondition.class);
			queryCondition.setContactsInfo(contactsInfos2);
		} catch (Exception e) {
			throw new JSONException("json 字符串解析失败！");
		}
		return queryCondition;
		
	}
	
	public static void main(String[] args) {
		String content = "{'queryType':'0','contactsInfo':[{'phone':'','companyPhone':'','department':'','relation':'3','companyName':'','updateDate':'2015-12-12 2:12:12','id':'kMqgGEwdaJY1JStcaKrAw2i0jIAV5O2V','createUser':'','name':'小米','applyCode':'wsw07010001','createDate':'2015-12-12 09:12:12','updateUser':'','mobile':'123456789'},{'phone':'','companyPhone':'','department':'','relation':'3','companyName':'','updateDate':'','id':'wfoLyiSZgdudd75lqDu5NWGHqarbezjq','createUser':'','name':'ws','applyCode':'wsw07010001','createDate':'','updateUser':'','mobile':'15487412451'}],'sourceSys':'2','applyCode':'wsw07010001','customerInfo':{'curWorkStartyear':'','companyIndustry':'','spouseIdno':'','companyAddrCity':'','businessSubType':'','housingAddrDistrict':'','idtype':'','companyPhone':'','censusAddrProvince':'','profession':'','approveIncome':0,'homePhone':'50157512','applyProductCode':'','homeAddrCity':'','lendingAmount':0,'companyAddrProvince':'','loanApplyMonths':0,'residenceStatus':'','applyChannel':'','emailAddress':'','idcard':'310102198506211234','businessType':'','homePostcode':'','occurPlace':'','companyName':'','currentBusinessType':'','housingAddresss':'','spouseName':'','applyDate':'2014-12-12 12:12:12','applySubchannel':'','createUser':'','departmentCity':'','yearlyIncome':0,'spouseIdtype':'','vinCode':'','approvedProductCode':'','updateUser':'','mobile':'18015474124','housingAddrProvince':'','housingPostcode':'','highestDiploma':0,'birthday':'','sex':0,'department':'','salesmanName':'','sourceSys':'','companyAddrDistrict':'','maritalStatus':0,'loanApplyAmount':0,'censusAddresss':'','id':'1vZyilk7vrYv1DX8nmlryr5MvamGTu3X','spouseMobile':'','spouseCompany':'','name':'','professionalTitle':0,'censusAddrCity':'','createDate':'','carPrice':0,'homeAddrDistrict':'','vehicleNo':'','post':0,'updateDate':'','repaymentBankAccount':'','companyAddresss':'','housingAddrCity':'','engineNo':'','highestEducation':0,'censusAddrDistrict':'','mobile1':'','applyCode':'wsw07010001','refusedCode3':'','companyPostcode':'','refusedCode4':'','homeAddresss':'','refusedCode1':'','refusedCode2':'','homeAddrProvince':''}}";
		parseFraudQueryEntity(content);
	}
	
}
