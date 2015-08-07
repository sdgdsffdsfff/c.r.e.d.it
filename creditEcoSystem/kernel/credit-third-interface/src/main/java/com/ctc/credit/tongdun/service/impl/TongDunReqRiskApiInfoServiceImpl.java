package com.ctc.credit.tongdun.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ctc.credit.constant.ConfigsContant;
import com.ctc.credit.kernel.base.GenericServiceImpl;
import com.ctc.credit.tongdun.api.dto.TongDunReqRiskApiDto;
import com.ctc.credit.tongdun.dao.TongDunReqRiskApiLogDao;
import com.ctc.credit.tongdun.model.TongDunReqRiskApiEntity;
import com.ctc.credit.tongdun.pojo.HandleTdRiskApiRequest;
import com.ctc.credit.tongdun.service.TongDunReqRiskApiInfoService;

@Service
@Transactional
public class TongDunReqRiskApiInfoServiceImpl extends GenericServiceImpl<TongDunReqRiskApiEntity, String>implements TongDunReqRiskApiInfoService {
	private Logger log = Logger.getLogger("D");
	@Autowired
	TongDunReqRiskApiLogDao tongDunReqRiskLogDao;
	@Override
	public TongDunReqRiskApiEntity tongDunReqRiskInfoSave(HandleTdRiskApiRequest handleRequest)
			throws Exception {
		TongDunReqRiskApiDto  tongDunReqRiskApiDto=handleRequest.getTongDunReqRiskApiDto();
		TongDunReqRiskApiEntity tongDunReqRiskEntity=new TongDunReqRiskApiEntity();
		tongDunReqRiskEntity.setBlackBox(tongDunReqRiskApiDto.getBlack_box());
		InputStream input = null;
		Properties prop = new Properties();
		input = ConfigsContant.class.getClassLoader().getResourceAsStream("tongdun.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			log.equals(e.getMessage());
		}finally{
			try {
				input.close();
			} catch (IOException e) {
				input = null;
				e.printStackTrace();
			}
		}
		tongDunReqRiskEntity.setPartnerCode(prop.getProperty("partner_code"));
		tongDunReqRiskEntity.setSecretKey(prop.getProperty("secret_key"));
		tongDunReqRiskEntity.setEventId(tongDunReqRiskApiDto.getEvent_id());
		tongDunReqRiskEntity.setTokenId(tongDunReqRiskApiDto.getToken_id());
		tongDunReqRiskEntity.setCookieId(tongDunReqRiskApiDto.getCookie_id());
		tongDunReqRiskEntity.setIpAddress(tongDunReqRiskApiDto.getIp_address());
		tongDunReqRiskEntity.setIdNumber(tongDunReqRiskApiDto.getId_number());
		tongDunReqRiskEntity.setAccountLogin(tongDunReqRiskApiDto.getAccount_login());
		tongDunReqRiskEntity.setAccountName(tongDunReqRiskApiDto.getAccount_name());
		tongDunReqRiskEntity.setAccountEmail(tongDunReqRiskApiDto.getAccount_email());
		tongDunReqRiskEntity.setAccountPhone(tongDunReqRiskApiDto.getAccount_phone());
		tongDunReqRiskEntity.setAccountMobile(tongDunReqRiskApiDto.getAccount_mobile());
		
		
		
		tongDunReqRiskEntity.setAccountPassword(tongDunReqRiskApiDto.getAccount_password());
		tongDunReqRiskEntity.setTransactionId(tongDunReqRiskApiDto.getTransaction_id());
		tongDunReqRiskEntity.setOrganization(tongDunReqRiskApiDto.getOrganization());
		tongDunReqRiskEntity.setBizLicense(tongDunReqRiskApiDto.getBiz_license());
		tongDunReqRiskEntity.setOrgCode(tongDunReqRiskApiDto.getOrg_code());
		tongDunReqRiskEntity.setAccountAddressStreet(tongDunReqRiskApiDto.getAccount_address_street());
		tongDunReqRiskEntity.setAccountAddressCountry(tongDunReqRiskApiDto.getAccount_address_country());
		tongDunReqRiskEntity.setAccountAddressCity(tongDunReqRiskApiDto.getAccount_address_city());
		tongDunReqRiskEntity.setAccountAddressCounty(tongDunReqRiskApiDto.getAccount_address_county());
		tongDunReqRiskEntity.setAccountAddressProvince(tongDunReqRiskApiDto.getAccount_address_province());
		tongDunReqRiskEntity.setAccountZipCode(tongDunReqRiskApiDto.getAccount_zip_code());
		tongDunReqRiskEntity.setPayeeUserid(tongDunReqRiskApiDto.getPayee_userid());
		tongDunReqRiskEntity.setPayeeName(tongDunReqRiskApiDto.getPayee_name());
		tongDunReqRiskEntity.setPayeeEmail(tongDunReqRiskApiDto.getPayee_email());
		tongDunReqRiskEntity.setPayeeMobile(tongDunReqRiskApiDto.getPayee_mobile());
		tongDunReqRiskEntity.setPayeePhone(tongDunReqRiskApiDto.getPayee_phone());
		tongDunReqRiskEntity.setPayeeIdNumber(tongDunReqRiskApiDto.getPayee_id_number());
		tongDunReqRiskEntity.setPayeeCardNumber(tongDunReqRiskApiDto.getPayee_card_number());
		tongDunReqRiskEntity.setDeliverName(tongDunReqRiskApiDto.getDeliver_name());
		tongDunReqRiskEntity.setDeliverMobile(tongDunReqRiskApiDto.getDeliver_mobile());
		tongDunReqRiskEntity.setDeliverPhone(tongDunReqRiskApiDto.getDeliver_phone());
		tongDunReqRiskEntity.setDeliverAddressStreet(tongDunReqRiskApiDto.getDeliver_address_street());
		tongDunReqRiskEntity.setDeliverAddressCity(tongDunReqRiskApiDto.getDeliver_address_city());
		tongDunReqRiskEntity.setDeliverAddressCountry(tongDunReqRiskApiDto.getDeliver_address_country());
		tongDunReqRiskEntity.setDeliverAddressCounty(tongDunReqRiskApiDto.getDeliver_address_county());
		tongDunReqRiskEntity.setDeliverAddressProvince(tongDunReqRiskApiDto.getDeliver_address_province());
		tongDunReqRiskEntity.setDeliverZipCode(tongDunReqRiskApiDto.getDeliver_zip_code());
		tongDunReqRiskEntity.setPayId(tongDunReqRiskApiDto.getPay_id());
		tongDunReqRiskEntity.setPayMethod(tongDunReqRiskApiDto.getPay_method());
		if(!"".equals(tongDunReqRiskApiDto.getPay_amount()) && tongDunReqRiskApiDto.getPay_amount()!=null){
			tongDunReqRiskEntity.setPayAmount(Long.valueOf((tongDunReqRiskApiDto.getPay_amount())));
		}
		tongDunReqRiskEntity.setPayCurrency(tongDunReqRiskApiDto.getPay_currency());
		tongDunReqRiskEntity.setCardNumber(tongDunReqRiskApiDto.getCard_number());
		tongDunReqRiskEntity.setCardType(tongDunReqRiskApiDto.getCard_type());
		tongDunReqRiskEntity.setCcBin(tongDunReqRiskApiDto.getCc_bin());
		if(!"".equals(tongDunReqRiskApiDto.getCc_expiration_month()) && tongDunReqRiskApiDto.getCc_expiration_month()!=null){
			tongDunReqRiskEntity.setCcExpirationMonth(Long.valueOf(tongDunReqRiskApiDto.getCc_expiration_month()));
		}
		if(!"".equals(tongDunReqRiskApiDto.getCc_expiration_year()) && tongDunReqRiskApiDto.getCc_expiration_year()!=null){
			tongDunReqRiskEntity.setCcExpirationYear(Long.valueOf(tongDunReqRiskApiDto.getCc_expiration_year()));
		}
		
		tongDunReqRiskEntity.setCcPhone(tongDunReqRiskApiDto.getCc_phone());
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		tongDunReqRiskEntity.setEventOccurTime(sdf.parse(sdf.format(new Date())));
		tongDunReqRiskEntity.setUserAgentCust(tongDunReqRiskApiDto.getUser_agent_cust());
		tongDunReqRiskEntity.setReferCust(tongDunReqRiskApiDto.getRefer_cust());
		tongDunReqRiskEntity.setItems(tongDunReqRiskApiDto.getItems());
		tongDunReqRiskEntity.setItemsCount(tongDunReqRiskApiDto.getItems_count());
		tongDunReqRiskEntity.setRespDetailType(tongDunReqRiskApiDto.getResp_detail_type());
		tongDunReqRiskEntity.setCreateUser("creditadmin");
		tongDunReqRiskEntity.setCreateDate(sdf.parse(sdf.format(new Date())));
		tongDunReqRiskEntity.setOthersValue(handleRequest.getOthers_value());
		tongDunReqRiskLogDao.saveTdReqRiskApiInfo(tongDunReqRiskEntity);
		return tongDunReqRiskEntity;
	}
	
	
	

}
