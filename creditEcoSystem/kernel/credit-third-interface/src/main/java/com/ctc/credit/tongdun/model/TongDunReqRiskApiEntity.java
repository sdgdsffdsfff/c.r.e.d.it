package com.ctc.credit.tongdun.model;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "TONGDUNRISKAPIREQ_INFO")
public class TongDunReqRiskApiEntity extends AbstractCreditEntity {
/**
 * 
 */
private static final long serialVersionUID = -4028832797458316251L;

/**
*blackBox - (注:只适用移动端)同盾SDK采集信息
*/
private String blackBox;
/**
*partnerCode - 合作方代码，在用户接入时由同盾分配
*/
private String partnerCode;
/**
*secretKey -接口密钥,每个应用对应一个密钥,在用户接入时同同盾分配
*/
private String secretKey;
/**
*eventId - 事件ID，由用户自己创建，用来标识合作方应用下的某个事件
*/
private String eventId;
/**
*tokenId - 设备指纹服务的会话标示，与部署设备脚本时生成的Token一致
*/
private String tokenId;
/**
*cookieId - CookieId
*/
private String cookieId;
/**
*ipAddress - 用户访问的IP地址
*/
private String ipAddress;
/**
*idNumber - 身份证
*/
private String idNumber;
/**
*accountLogin - 登录账户名
*/
private String accountLogin;
/**
*accountName - 用户姓名或昵称
*/
private String accountName;
/**
*accountEmail - 邮箱
*/
private String accountEmail;
/**
*accountPhone - 电话座机号码
*/
private String accountPhone;
/**
*accountMobile - 手机号码
*/
private String accountMobile;
/**
*accountPassword - 用户密码摘要
*/
private String accountPassword;
/**
*transactionId - 内部交易流水
*/
private String transactionId;
/**
*organization - 工作单位
*/
private String organization;
/**
*bizLicense - 工商注册号
*/
private String bizLicense;
/**
*orgCode - 组织机构代码
*/
private String orgCode;
/**
*accountAddressStreet - 买家的街道地址信息
*/
private String accountAddressStreet;
/**
*accountAddressCounty - 买家的县或区地址信息
*/
private String accountAddressCounty;
/**
*accountAddressCity - 买家的城市地址信息
*/
private String accountAddressCity;
/**
*accountAddressProvince - 买家的省份地址信息
*/
private String accountAddressProvince;
/**
*accountAddressCountry - 买家的国家地址信息
*/
private String accountAddressCountry;
/**
*accountZipCode - 买家的邮编信息
*/
private String accountZipCode;
/**
*payeeUserid - 卖家或收款人ID
*/
private String payeeUserid;
/**
*payeeName - 卖家或收款人姓名
*/
private String payeeName;
/**
*payeeEmail - 卖家或收款人邮箱
*/
private String payeeEmail;
/**
*payeeMobile - 卖家或收款人手机
*/
private String payeeMobile;
/**
*payeePhone - 卖家或收款人座机
*/
private String payeePhone;
/**
*payeeIdNumber - 卖家或收款人身份证
*/
private String payeeIdNumber;
/**
*payeeCardNumber - 卖家或收款人银行卡号
*/
private String payeeCardNumber;
/**
*deliverName - 收货人姓名
*/
private String deliverName;
/**
*deliverMobile - 收货人手机号
*/
private String deliverMobile;
/**
*deliverPhone - 收货人座机号
*/
private String deliverPhone;
/**
*deliverAddressStreet - 收货人街道地址信息
*/
private String deliverAddressStreet;
/**
*deliverAddressCounty - 收货人县或区地址信息
*/
private String deliverAddressCounty;
/**
*deliverAddressCity - 收货人城市地址信息
*/
private String deliverAddressCity;
/**
*deliverAddressProvince - 收货人省份地址信息
*/
private String deliverAddressProvince;
/**
*deliverAddressCountry - 收货人国家地址信息
*/
private String deliverAddressCountry;
/**
*deliverZipCode - 收货人邮编信息
*/
private String deliverZipCode;
/**
*payId - 内部支付流水号
*/
private String payId;
/**
*payMethod - 支付方式
*/
private String payMethod;
/**
*payAmount - 支付金额
*/
private Long payAmount;
/**
*payCurrency - 支付货币
*/
private String payCurrency;
/**
*cardNumber - 银行卡号
*/
private String cardNumber;
/**
*cardType - 卡号类型
*/
private String cardType;
/**
*ccBin - BIN卡号
*/
private String ccBin;
/**
*ccPhone - BIN关联手机
*/
private String ccPhone;
/**
*ccExpirationYear - BIN卡过期年份
*/
private Long ccExpirationYear;
/**
*ccExpirationMonth - BIN卡过期月份
*/
private Long ccExpirationMonth;
/**
*eventOccurTime - 事件发生时间, 格式如yyyy-MM-dd HH:mm:ss
*/
private Date eventOccurTime;
/**
*userAgentCust - User-Agent
*/
private String userAgentCust;
/**
*referCust - Referer
*/
private String referCust;
/**
*items - 商品详情
*/
private String items;
/**
*itemsCount - 商品数量
*/
private String itemsCount;
/**
*respDetailType - 指定API返回的信息类型，默认返回决策信息。支持的信息类型有geoip(地理位置信息)、device(设备指纹信息)、attribution(归属地信息)。如需要多个则以逗号分隔，如geoip，device，attribution
*/
private String respDetailType;
/**
*othersValue - 自定义字段
*/
private String othersValue;
/**
* @param updateUser the updateUser to set - no comment
*/
/**
* @param blackBox the blackBox to set - no comment
*/
public void setBlackBox(String blackBox)
{
    this.blackBox = blackBox;
}
/**
* @return the blackBox - no comment
*/
@Column(name="black_box")
public String getBlackBox()
{
    return blackBox;
}
/**
* @param partnerCode the partnerCode to set - no comment
*/
public void setPartnerCode(String partnerCode)
{
    this.partnerCode = partnerCode;
}
/**
* @return the partnerCode - no comment
*/
@Column(name="partner_code")
public String getPartnerCode()
{
    return partnerCode;
}
/**
* @param secretKey the secretKey to set - no comment
*/
public void setSecretKey(String secretKey)
{
    this.secretKey = secretKey;
}
/**
* @return the secretKey - no comment
*/
@Column(name="secret_key")
public String getSecretKey()
{
    return secretKey;
}
/**
* @param eventId the eventId to set - no comment
*/
public void setEventId(String eventId)
{
    this.eventId = eventId;
}
/**
* @return the eventId - no comment
*/
@Column(name="event_id")
public String getEventId()
{
    return eventId;
}
/**
* @param tokenId the tokenId to set - no comment
*/
public void setTokenId(String tokenId)
{
    this.tokenId = tokenId;
}
/**
* @return the tokenId - no comment
*/
@Column(name="token_id")
public String getTokenId()
{
    return tokenId;
}
/**
* @param cookieId the cookieId to set - no comment
*/
public void setCookieId(String cookieId)
{
    this.cookieId = cookieId;
}
/**
* @return the cookieId - no comment
*/
@Column(name="cookie_id")
public String getCookieId()
{
    return cookieId;
}
/**
* @param ipAddress the ipAddress to set - no comment
*/
public void setIpAddress(String ipAddress)
{
    this.ipAddress = ipAddress;
}
/**
* @return the ipAddress - no comment
*/
@Column(name="ip_address")
public String getIpAddress()
{
    return ipAddress;
}
/**
* @param idNumber the idNumber to set - no comment
*/
public void setIdNumber(String idNumber)
{
    this.idNumber = idNumber;
}
/**
* @return the idNumber - no comment
*/
@Column(name="id_number")
public String getIdNumber()
{
    return idNumber;
}
/**
* @param accountLogin the accountLogin to set - no comment
*/
public void setAccountLogin(String accountLogin)
{
    this.accountLogin = accountLogin;
}
/**
* @return the accountLogin - no comment
*/
@Column(name="account_login")
public String getAccountLogin()
{
    return accountLogin;
}
/**
* @param accountName the accountName to set - no comment
*/
public void setAccountName(String accountName)
{
    this.accountName = accountName;
}
/**
* @return the accountName - no comment
*/
@Column(name="account_name")
public String getAccountName()
{
    return accountName;
}
/**
* @param accountEmail the accountEmail to set - no comment
*/
public void setAccountEmail(String accountEmail)
{
    this.accountEmail = accountEmail;
}
/**
* @return the accountEmail - no comment
*/
@Column(name="account_email")
public String getAccountEmail()
{
    return accountEmail;
}
/**
* @param accountPhone the accountPhone to set - no comment
*/
public void setAccountPhone(String accountPhone)
{
    this.accountPhone = accountPhone;
}
/**
* @return the accountPhone - no comment
*/
@Column(name="account_phone")
public String getAccountPhone()
{
    return accountPhone;
}
/**
* @param accountMobile the accountMobile to set - no comment
*/
public void setAccountMobile(String accountMobile)
{
    this.accountMobile = accountMobile;
}
/**
* @return the accountMobile - no comment
*/
@Column(name="account_mobile")
public String getAccountMobile()
{
    return accountMobile;
}
/**
* @param accountPassword the accountPassword to set - no comment
*/
public void setAccountPassword(String accountPassword)
{
    this.accountPassword = accountPassword;
}
/**
* @return the accountPassword - no comment
*/
@Column(name="account_password")
public String getAccountPassword()
{
    return accountPassword;
}
/**
* @param transactionId the transactionId to set - no comment
*/
public void setTransactionId(String transactionId)
{
    this.transactionId = transactionId;
}
/**
* @return the transactionId - no comment
*/
@Column(name="transaction_id")
public String getTransactionId()
{
    return transactionId;
}
/**
* @param organization the organization to set - no comment
*/
public void setOrganization(String organization)
{
    this.organization = organization;
}
/**
* @return the organization - no comment
*/
@Column(name="organization")
public String getOrganization()
{
    return organization;
}
/**
* @param bizLicense the bizLicense to set - no comment
*/
public void setBizLicense(String bizLicense)
{
    this.bizLicense = bizLicense;
}
/**
* @return the bizLicense - no comment
*/
@Column(name="biz_license")
public String getBizLicense()
{
    return bizLicense;
}
/**
* @param orgCode the orgCode to set - no comment
*/
public void setOrgCode(String orgCode)
{
    this.orgCode = orgCode;
}
/**
* @return the orgCode - no comment
*/
@Column(name="org_code")
public String getOrgCode()
{
    return orgCode;
}
/**
* @param accountAddressStreet the accountAddressStreet to set - no comment
*/
public void setAccountAddressStreet(String accountAddressStreet)
{
    this.accountAddressStreet = accountAddressStreet;
}
/**
* @return the accountAddressStreet - no comment
*/
@Column(name="account_address_street")
public String getAccountAddressStreet()
{
    return accountAddressStreet;
}
/**
* @param accountAddressCounty the accountAddressCounty to set - no comment
*/
public void setAccountAddressCounty(String accountAddressCounty)
{
    this.accountAddressCounty = accountAddressCounty;
}
/**
* @return the accountAddressCounty - no comment
*/
@Column(name="account_address_county")
public String getAccountAddressCounty()
{
    return accountAddressCounty;
}
/**
* @param accountAddressCity the accountAddressCity to set - no comment
*/
public void setAccountAddressCity(String accountAddressCity)
{
    this.accountAddressCity = accountAddressCity;
}
/**
* @return the accountAddressCity - no comment
*/
@Column(name="account_address_city")
public String getAccountAddressCity()
{
    return accountAddressCity;
}
/**
* @param accountAddressProvince the accountAddressProvince to set - no comment
*/
public void setAccountAddressProvince(String accountAddressProvince)
{
    this.accountAddressProvince = accountAddressProvince;
}
/**
* @return the accountAddressProvince - no comment
*/
@Column(name="account_address_province")
public String getAccountAddressProvince()
{
    return accountAddressProvince;
}
/**
* @param accountAddressCountry the accountAddressCountry to set - no comment
*/
public void setAccountAddressCountry(String accountAddressCountry)
{
    this.accountAddressCountry = accountAddressCountry;
}
/**
* @return the accountAddressCountry - no comment
*/
@Column(name="account_address_country")
public String getAccountAddressCountry()
{
    return accountAddressCountry;
}
/**
* @param accountZipCode the accountZipCode to set - no comment
*/
public void setAccountZipCode(String accountZipCode)
{
    this.accountZipCode = accountZipCode;
}
/**
* @return the accountZipCode - no comment
*/
@Column(name="account_zip_code")
public String getAccountZipCode()
{
    return accountZipCode;
}
/**
* @param payeeUserid the payeeUserid to set - no comment
*/
public void setPayeeUserid(String payeeUserid)
{
    this.payeeUserid = payeeUserid;
}
/**
* @return the payeeUserid - no comment
*/
@Column(name="payee_userid")
public String getPayeeUserid()
{
    return payeeUserid;
}
/**
* @param payeeName the payeeName to set - no comment
*/
public void setPayeeName(String payeeName)
{
    this.payeeName = payeeName;
}
/**
* @return the payeeName - no comment
*/
@Column(name="payee_name")
public String getPayeeName()
{
    return payeeName;
}
/**
* @param payeeEmail the payeeEmail to set - no comment
*/
public void setPayeeEmail(String payeeEmail)
{
    this.payeeEmail = payeeEmail;
}
/**
* @return the payeeEmail - no comment
*/
@Column(name="payee_email")
public String getPayeeEmail()
{
    return payeeEmail;
}
/**
* @param payeeMobile the payeeMobile to set - no comment
*/
public void setPayeeMobile(String payeeMobile)
{
    this.payeeMobile = payeeMobile;
}
/**
* @return the payeeMobile - no comment
*/
@Column(name="payee_mobile")
public String getPayeeMobile()
{
    return payeeMobile;
}
/**
* @param payeePhone the payeePhone to set - no comment
*/
public void setPayeePhone(String payeePhone)
{
    this.payeePhone = payeePhone;
}
/**
* @return the payeePhone - no comment
*/
@Column(name="payee_phone")
public String getPayeePhone()
{
    return payeePhone;
}
/**
* @param payeeIdNumber the payeeIdNumber to set - no comment
*/
public void setPayeeIdNumber(String payeeIdNumber)
{
    this.payeeIdNumber = payeeIdNumber;
}
/**
* @return the payeeIdNumber - no comment
*/
@Column(name="payee_id_number")
public String getPayeeIdNumber()
{
    return payeeIdNumber;
}
/**
* @param payeeCardNumber the payeeCardNumber to set - no comment
*/
public void setPayeeCardNumber(String payeeCardNumber)
{
    this.payeeCardNumber = payeeCardNumber;
}
/**
* @return the payeeCardNumber - no comment
*/
@Column(name="payee_card_number")
public String getPayeeCardNumber()
{
    return payeeCardNumber;
}
/**
* @param deliverName the deliverName to set - no comment
*/
public void setDeliverName(String deliverName)
{
    this.deliverName = deliverName;
}
/**
* @return the deliverName - no comment
*/
@Column(name="deliver_name")
public String getDeliverName()
{
    return deliverName;
}
/**
* @param deliverMobile the deliverMobile to set - no comment
*/
public void setDeliverMobile(String deliverMobile)
{
    this.deliverMobile = deliverMobile;
}
/**
* @return the deliverMobile - no comment
*/
@Column(name="deliver_mobile")
public String getDeliverMobile()
{
    return deliverMobile;
}
/**
* @param deliverPhone the deliverPhone to set - no comment
*/
public void setDeliverPhone(String deliverPhone)
{
    this.deliverPhone = deliverPhone;
}
/**
* @return the deliverPhone - no comment
*/
@Column(name="deliver_phone")
public String getDeliverPhone()
{
    return deliverPhone;
}
/**
* @param deliverAddressStreet the deliverAddressStreet to set - no comment
*/
public void setDeliverAddressStreet(String deliverAddressStreet)
{
    this.deliverAddressStreet = deliverAddressStreet;
}
/**
* @return the deliverAddressStreet - no comment
*/
@Column(name="deliver_address_street")
public String getDeliverAddressStreet()
{
    return deliverAddressStreet;
}
/**
* @param deliverAddressCounty the deliverAddressCounty to set - no comment
*/
public void setDeliverAddressCounty(String deliverAddressCounty)
{
    this.deliverAddressCounty = deliverAddressCounty;
}
/**
* @return the deliverAddressCounty - no comment
*/
@Column(name="deliver_address_county")
public String getDeliverAddressCounty()
{
    return deliverAddressCounty;
}
/**
* @param deliverAddressCity the deliverAddressCity to set - no comment
*/
public void setDeliverAddressCity(String deliverAddressCity)
{
    this.deliverAddressCity = deliverAddressCity;
}
/**
* @return the deliverAddressCity - no comment
*/
@Column(name="deliver_address_city")
public String getDeliverAddressCity()
{
    return deliverAddressCity;
}
/**
* @param deliverAddressProvince the deliverAddressProvince to set - no comment
*/
public void setDeliverAddressProvince(String deliverAddressProvince)
{
    this.deliverAddressProvince = deliverAddressProvince;
}
/**
* @return the deliverAddressProvince - no comment
*/
@Column(name="deliver_address_province")
public String getDeliverAddressProvince()
{
    return deliverAddressProvince;
}
/**
* @param deliverAddressCountry the deliverAddressCountry to set - no comment
*/
public void setDeliverAddressCountry(String deliverAddressCountry)
{
    this.deliverAddressCountry = deliverAddressCountry;
}
/**
* @return the deliverAddressCountry - no comment
*/
@Column(name="deliver_address_country")
public String getDeliverAddressCountry()
{
    return deliverAddressCountry;
}
/**
* @param deliverZipCode the deliverZipCode to set - no comment
*/
public void setDeliverZipCode(String deliverZipCode)
{
    this.deliverZipCode = deliverZipCode;
}
/**
* @return the deliverZipCode - no comment
*/
@Column(name="deliver_zip_code")
public String getDeliverZipCode()
{
    return deliverZipCode;
}
/**
* @param payId the payId to set - no comment
*/
public void setPayId(String payId)
{
    this.payId = payId;
}
/**
* @return the payId - no comment
*/
@Column(name="pay_id")
public String getPayId()
{
    return payId;
}
/**
* @param payMethod the payMethod to set - no comment
*/
public void setPayMethod(String payMethod)
{
    this.payMethod = payMethod;
}
/**
* @return the payMethod - no comment
*/
@Column(name="pay_method")
public String getPayMethod()
{
    return payMethod;
}
/**
* @param payAmount the payAmount to set - no comment
*/
public void setPayAmount(Long payAmount)
{
    this.payAmount = payAmount;
}
/**
* @return the payAmount - no comment
*/
@Column(name="pay_amount")
public Long getPayAmount()
{
    return payAmount;
}
/**
* @param payCurrency the payCurrency to set - no comment
*/
public void setPayCurrency(String payCurrency)
{
    this.payCurrency = payCurrency;
}
/**
* @return the payCurrency - no comment
*/
@Column(name="pay_currency")
public String getPayCurrency()
{
    return payCurrency;
}
/**
* @param cardNumber the cardNumber to set - no comment
*/
public void setCardNumber(String cardNumber)
{
    this.cardNumber = cardNumber;
}
/**
* @return the cardNumber - no comment
*/
@Column(name="card_number")
public String getCardNumber()
{
    return cardNumber;
}
/**
* @param cardType the cardType to set - no comment
*/
public void setCardType(String cardType)
{
    this.cardType = cardType;
}
/**
* @return the cardType - no comment
*/
@Column(name="card_type")
public String getCardType()
{
    return cardType;
}
/**
* @param ccBin the ccBin to set - no comment
*/
public void setCcBin(String ccBin)
{
    this.ccBin = ccBin;
}
/**
* @return the ccBin - no comment
*/
@Column(name="cc_bin")
public String getCcBin()
{
    return ccBin;
}
/**
* @param ccPhone the ccPhone to set - no comment
*/
public void setCcPhone(String ccPhone)
{
    this.ccPhone = ccPhone;
}
/**
* @return the ccPhone - no comment
*/
@Column(name="cc_phone")
public String getCcPhone()
{
    return ccPhone;
}
/**
* @param ccExpirationYear the ccExpirationYear to set - no comment
*/
public void setCcExpirationYear(Long ccExpirationYear)
{
    this.ccExpirationYear = ccExpirationYear;
}
/**
* @return the ccExpirationYear - no comment
*/
@Column(name="cc_expiration_year")
public Long getCcExpirationYear()
{
    return ccExpirationYear;
}
/**
* @param ccExpirationMonth the ccExpirationMonth to set - no comment
*/
public void setCcExpirationMonth(Long ccExpirationMonth)
{
    this.ccExpirationMonth = ccExpirationMonth;
}
/**
* @return the ccExpirationMonth - no comment
*/
@Column(name="cc_expiration_month")
public Long getCcExpirationMonth()
{
    return ccExpirationMonth;
}
/**
* @param eventOccurTime the eventOccurTime to set - no comment
*/
public void setEventOccurTime(Date eventOccurTime)
{
    this.eventOccurTime = eventOccurTime;
}
/**
* @return the eventOccurTime - no comment
*/
@Column(name="event_occur_time")
public Date getEventOccurTime()
{
    return eventOccurTime;
}
/**
* @param userAgentCust the userAgentCust to set - no comment
*/
public void setUserAgentCust(String userAgentCust)
{
    this.userAgentCust = userAgentCust;
}
/**
* @return the userAgentCust - no comment
*/
@Column(name="user_agent_cust")
public String getUserAgentCust()
{
    return userAgentCust;
}
/**
* @param referCust the referCust to set - no comment
*/
public void setReferCust(String referCust)
{
    this.referCust = referCust;
}
/**
* @return the referCust - no comment
*/
@Column(name="refer_cust")
public String getReferCust()
{
    return referCust;
}
/**
* @param items the items to set - no comment
*/
public void setItems(String items)
{
    this.items = items;
}
/**
* @return the items - no comment
*/
@Column(name="items")
public String getItems()
{
    return items;
}
/**
* @param itemsCount the itemsCount to set - no comment
*/
public void setItemsCount(String itemsCount)
{
    this.itemsCount = itemsCount;
}
/**
* @return the itemsCount - no comment
*/
@Column(name="items_count")
public String getItemsCount()
{
    return itemsCount;
}
/**
* @param respDetailType the respDetailType to set - no comment
*/
public void setRespDetailType(String respDetailType)
{
    this.respDetailType = respDetailType;
}
/**
* @return the respDetailType - no comment
*/
@Column(name="resp_detail_type")
public String getRespDetailType()
{
    return respDetailType;
}
/**
* @param othersValue the othersValue to set - no comment
*/
public void setOthersValue(String othersValue)
{
    this.othersValue = othersValue;
}
/**
* @return the othersValue - no comment
*/
@Column(name="others_value")
public String getOthersValue()
{
    return othersValue;
}

}