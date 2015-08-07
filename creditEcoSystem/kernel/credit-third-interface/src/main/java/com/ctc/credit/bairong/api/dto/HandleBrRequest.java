/**
 * 
 */
package com.ctc.credit.bairong.api.dto;

import java.util.Date;

import com.bfd.facade.Apply_source;
import com.bfd.facade.Biz_industry;
import com.bfd.facade.Biz_positon;
import com.bfd.facade.Biz_type;
import com.bfd.facade.Educationallevel;
import com.bfd.facade.House_type;
import com.bfd.facade.Marriage;

/**
 * @author Chengang
 * 2015年7月31日 上午10:49:39 
 */
public class HandleBrRequest {
	/** 商户名称**/
	private String merchantName;
	/** 商户密码**/
	private String merchantPwd;
	/** 身份证号码**/
	private String idCardNo;
	/** 手机号码**/
	private String cell;
	/** 电子邮箱**/
	private String mail;
	/** 姓名**/
	private String name;
	/** 百融全局设备标识（需部署百融代码，bfdid）**/
	private String gid;
	/** 公司座机号，区号和分机号用“-”间隔）**/
	private String telBiz;
	/** 家庭座机号，区号和分机号用“-”间隔**/
	private String telHome;
	/** 家庭地址**/
	private String homeAddr;
	/** 公司地址**/
	private String bizAddr;
	/** 户籍地址**/
	private String perAddr;
	/** 申请地址(移动应用为GPS地址)**/
	private String applyAddr;
	/** 其他地址**/
	private String othAddr;
	/** IMEI号(移动应用)**/
	private String imei;
	/** IMSI号(移动应用)**/
	private String imsi;
	/** 手机品牌(移动应用)**/
	private String mobileType;
	/** 性别**/
	private String sex;
	/** 年龄**/
	private int age;
	/** c.本科枚举项：a.高中及以下b.大专c.本科d.硕士e.博士f.其他**/
	private String educationallevel;
	/** a.未婚枚举项：a.未婚b.已婚c.离异d.丧偶**/
	private String marriage;
	/** 年收入**/
	private double income;
	/** 职位：b.基层主管枚举项：a.员工b.基层主管c.中层主管d.高层主管e.其他**/
	private String bizPositon;
	/** 公司名称**/
	private String bizWorkfor;
	/** 公司性质：枚举项：a.外资企业b.合资企业c.国营企业d.民营企业e.上市公司f.非盈利组织g.政府机关h.事业单位i.个体工商j.其他**/
	private String bizType;
	/** 单位所属的行业：b.政府机关枚举项：a.金融/保险b.政府机关c.旅游/饭店/宾馆/娱乐d.能源及通信服务e.
	 * 公共事业f.邮政/交通运输/物流业g.批发/零售/百货业h.轻工业i.房地产/基础建设/物管j.国内贸易公司
	 * k.制造业l.律师/会计师/咨询/培训m.进出口贸易n.IT产业o.媒体/出版/广告/文艺p.医疗q.其他**/
	private String bizIndustry;
	/** 住房性质:c.租借房枚举项：a.有房有贷款b.有房无贷款c.租借房d．其他**/
	private String houseType;
	/** 邮政编码**/
	private String postalcode;
	/** 申请渠道**/
	private String applySource;
	/** 申请产品**/
	private String applyProduct;
	/** 申请额度**/
	private String applyMoney;
	/** 申请时间**/
	private String applyTime;
	/** 贷款原因(信用卡可不提供)**/
	private String loanReason;
	/** 银行卡号(信用卡可不提供)**/
	private String bankId;
	/** 还款期数(信用卡可不提供)**/
	private int refundPeriods;
	/**联系人姓名**/
	private String linkmanName;
	/**联系人地址**/
	private String linkmanAddr;
	/**联系人手机号码**/
	private String linkmanCell;
	/**联系人关系**/
	private String linkmanRela;
	/**客户登录APP的次数**/
	private int appVisitNum;
	/**学历、学籍证明附件数量**/
	private int eduAttNum;
	/**银行卡流水附件数量**/
	private int bankRunningAttNum;
	
	private String tonkenId;
	
	private Date requestDate;

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantPwd() {
		return merchantPwd;
	}

	public void setMerchantPwd(String merchantPwd) {
		this.merchantPwd = merchantPwd;
	}

	public String getIdCardNo() {
		return idCardNo;
	}

	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}

	public String getCell() {
		return cell;
	}

	public void setCell(String cell) {
		this.cell = cell;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getTelBiz() {
		return telBiz;
	}

	public void setTelBiz(String telBiz) {
		this.telBiz = telBiz;
	}

	public String getTelHome() {
		return telHome;
	}

	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}

	public String getHomeAddr() {
		return homeAddr;
	}

	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}

	public String getBizAddr() {
		return bizAddr;
	}

	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}

	public String getPerAddr() {
		return perAddr;
	}

	public void setPerAddr(String perAddr) {
		this.perAddr = perAddr;
	}

	public String getApplyAddr() {
		return applyAddr;
	}

	public void setApplyAddr(String applyAddr) {
		this.applyAddr = applyAddr;
	}

	public String getOthAddr() {
		return othAddr;
	}

	public void setOthAddr(String othAddr) {
		this.othAddr = othAddr;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
		this.imsi = imsi;
	}

	public String getMobileType() {
		return mobileType;
	}

	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducationallevel() {
		return educationallevel;
	}

	public void setEducationallevel(String educationallevel) {
		this.educationallevel = educationallevel;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) { 
		this.marriage = marriage;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public String getBizPositon() {
		return bizPositon;
	}

	public void setBizPositon(String bizPositon) {
		this.bizPositon = bizPositon;
	}

	public String getBizWorkfor() {
		return bizWorkfor;
	}

	public void setBizWorkfor(String bizWorkfor) {
		this.bizWorkfor = bizWorkfor;
	}

	public String getBizType() {
		return bizType;
	}

	public void setBizType(String bizType) {
		this.bizType = bizType;
	}

	public String getBizIndustry() {
		return bizIndustry;
	}

	public void setBizIndustry(String bizIndustry) {
		this.bizIndustry = bizIndustry;
	}

	public String getHouseType() {
		return houseType;
	}

	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}

	public String getPostalcode() {
		return postalcode;
	}

	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	public String getApplySource() {
		return applySource;
	}

	public void setApplySource(String applySource) {
		this.applySource = applySource;
	}

	public String getApplyProduct() {
		return applyProduct;
	}

	public void setApplyProduct(String applyProduct) {
		this.applyProduct = applyProduct;
	}

	public String getApplyMoney() {
		return applyMoney;
	}

	public void setApplyMoney(String applyMoney) {
		this.applyMoney = applyMoney;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	public String getBankId() {
		return bankId;
	}

	public void setBankId(String bankId) {
		this.bankId = bankId;
	}

	public int getRefundPeriods() {
		return refundPeriods;
	}

	public void setRefundPeriods(int refundPeriods) {
		this.refundPeriods = refundPeriods;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanAddr() {
		return linkmanAddr;
	}

	public void setLinkmanAddr(String linkmanAddr) {
		this.linkmanAddr = linkmanAddr;
	}

	public String getLinkmanCell() {
		return linkmanCell;
	}

	public void setLinkmanCell(String linkmanCell) {
		this.linkmanCell = linkmanCell;
	}

	public String getLinkmanRela() {
		return linkmanRela;
	}

	public void setLinkmanRela(String linkmanRela) {
		this.linkmanRela = linkmanRela;
	}

	public int getAppVisitNum() {
		return appVisitNum;
	}

	public void setAppVisitNum(int appVisitNum) {
		this.appVisitNum = appVisitNum;
	}

	public int getEduAttNum() {
		return eduAttNum;
	}

	public void setEduAttNum(int eduAttNum) {
		this.eduAttNum = eduAttNum;
	}

	public int getBankRunningAttNum() {
		return bankRunningAttNum;
	}

	public void setBankRunningAttNum(int bankRunningAttNum) {
		this.bankRunningAttNum = bankRunningAttNum;
	}

	public String getTonkenId() {
		return tonkenId;
	}

	public void setTonkenId(String tonkenId) {
		this.tonkenId = tonkenId;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	
	

}
