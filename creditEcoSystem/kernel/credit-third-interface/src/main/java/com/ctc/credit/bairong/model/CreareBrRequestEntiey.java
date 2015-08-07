package com.ctc.credit.bairong.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bfd.facade.Apply_source;
import com.bfd.facade.Biz_industry;
import com.bfd.facade.Biz_positon;
import com.bfd.facade.Biz_type;
import com.bfd.facade.Educationallevel;
import com.bfd.facade.House_type;
import com.bfd.facade.Marriage;
import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
@Entity
@Table(name = "BAIRONG_REQUEST_INFO")
public class CreareBrRequestEntiey extends AbstractCreditEntity{

	private static final long serialVersionUID = 7360194259025859423L;
	/** 商户名称**/
	private String merchantName;
	/** 商户密码**/
	private String merchantPwd;
	/** 身份证号 **/
	private String idCardNo;
	/** 登陆唯一标示**/
	private String tonkenId;
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
	private Educationallevel educationallevel;
	/** a.未婚枚举项：a.未婚b.已婚c.离异d.丧偶**/
	private Marriage marriage;
	/** 年收入**/
	private double income;
	/** 职位：b.基层主管枚举项：a.员工b.基层主管c.中层主管d.高层主管e.其他**/
	private Biz_positon bizPositon;
	/** 公司名称**/
	private String bizWorkfor;
	/** 公司性质：枚举项：a.外资企业b.合资企业c.国营企业d.民营企业e.上市公司f.非盈利组织g.政府机关h.事业单位i.个体工商j.其他**/
	private Biz_type bizType;
	/** 单位所属的行业：b.政府机关枚举项：a.金融/保险b.政府机关c.旅游/饭店/宾馆/娱乐d.能源及通信服务e.
	 * 公共事业f.邮政/交通运输/物流业g.批发/零售/百货业h.轻工业i.房地产/基础建设/物管j.国内贸易公司
	 * k.制造业l.律师/会计师/咨询/培训m.进出口贸易n.IT产业o.媒体/出版/广告/文艺p.医疗q.其他**/
	private Biz_industry bizIndustry;
	/** 住房性质:c.租借房枚举项：a.有房有贷款b.有房无贷款c.租借房d．其他**/
	private House_type houseType;
	/** 邮政编码**/
	private String postalcode;
	/** 申请渠道**/
	private Apply_source applySource;
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
	/**请求时间**/ 
	private Date requestTime;
	
	@Column(name = "MERCHANT_NAME",length=255)
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	@Column(name = "MERCHANT_PWD",length=255)
	public String getMerchantPwd() {
		return merchantPwd;
	}
	
	public void setMerchantPwd(String merchantPwd) {
		this.merchantPwd = merchantPwd;
	}
	
	@Column(name = "ID_CARD_NO",length=20)
	public String getIdCardNo() {
		return idCardNo;
	}
	
	public void setIdCardNo(String idCardNo) {
		this.idCardNo = idCardNo;
	}
	
	@Column(name = "TOKEN_ID",length=50)
	public String getTonkenId() {
		return tonkenId;
	}
	public void setTonkenId(String tonkenId) {
		this.tonkenId = tonkenId;
	}
	
	@Column(name = "CELL_NO",length=20)
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
	
	@Column(name = "MAIL",length=20)
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column(name = "NAME",length=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "GID",length=50)
	public String getGid() {
		return gid;
	}
	public void setGid(String gid) {
		this.gid = gid;
	}
	
	@Column(name = "TEL_BIZ",length=20)
	public String getTelBiz() {
		return telBiz;
	}
	public void setTelBiz(String telBiz) {
		this.telBiz = telBiz;
	}
	
	@Column(name = "TEL_HOME",length=20)
	public String getTelHome() {
		return telHome;
	}
	public void setTelHome(String telHome) {
		this.telHome = telHome;
	}
	
	@Column(name = "HOME_ADDR",length=100)
	public String getHomeAddr() {
		return homeAddr;
	}
	public void setHomeAddr(String homeAddr) {
		this.homeAddr = homeAddr;
	}
	
	@Column(name = "BIZ_ADDR",length=100)
	public String getBizAddr() {
		return bizAddr;
	}
	public void setBizAddr(String bizAddr) {
		this.bizAddr = bizAddr;
	}
	
	@Column(name = "PER_ADDR",length=100)
	public String getPerAddr() {
		return perAddr;
	}
	public void setPerAddr(String perAddr) {
		this.perAddr = perAddr;
	}
	
	@Column(name = "APPLY_ADDR",length=100)
	public String getApplyAddr() {
		return applyAddr;
	}
	public void setApplyAddr(String applyAddr) {
		this.applyAddr = applyAddr;
	}
	
	@Column(name = "OTH_ADDR",length=100)
	public String getOthAddr() {
		return othAddr;
	}
	
	public void setOthAddr(String othAddr) {
		this.othAddr = othAddr;
	}
	
	@Column(name = "IMEI",length=15)
	public String getImei() {
		return imei;
	}
	public void setImei(String imei) {
		this.imei = imei;
	}
	
	@Column(name = "IMSI",length=15)
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	
	@Column(name = "MOBILE_TYPE",length=20)
	public String getMobileType() {
		return mobileType;
	}
	public void setMobileType(String mobileType) {
		this.mobileType = mobileType;
	}
	
	@Column(name = "SEX",length=1)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Column(name = "AGE",length=10)
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name = "EDUCATIONAL_ELVEL",length=10)
	public Educationallevel getEducationallevel() {
		return educationallevel;
	}
	public void setEducationallevel(Educationallevel educationallevel) {
		this.educationallevel = educationallevel;
	}
	
	@Column(name = "MARRIAGE",length=5)
	public Marriage getMarriage() {
		return marriage;
	}
	public void setMarriage(Marriage marriage) {
		this.marriage = marriage;
	}
	
	@Column(name = "INCOME")
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	
	@Column(name = "BIZ_POSITON",length=20)
	public Biz_positon getBizPositon() {
		return bizPositon;
	}
	public void setBizPositon(Biz_positon bizPositon) {
		this.bizPositon = bizPositon;
	}
	
	@Column(name = "BIZ_WORKFOR",length=50)
	public String getBizWorkfor() {
		return bizWorkfor;
	}
	public void setBizWorkfor(String bizWorkfor) {
		this.bizWorkfor = bizWorkfor;
	}
	
	@Column(name = "BIZ_TYPE",length=20)
	public Biz_type getBizType() {
		return bizType;
	}
	public void setBizType(Biz_type bizType) {
		this.bizType = bizType;
	}
	
	@Column(name = "BIZ_INDUSTRY",length=20)
	public Biz_industry getBizIndustry() {
		return bizIndustry;
	}
	public void setBizIndustry(Biz_industry bizIndustry) {
		this.bizIndustry = bizIndustry;
	}
	
	@Column(name = "HOUSE_TYPE",length=20)
	public House_type getHouseType() {
		return houseType;
	}
	public void setHouseType(House_type houseType) {
		this.houseType = houseType;
	}
	
	@Column(name = "POSTALCODE",length=20)
	public String getPostalcode() {
		return postalcode;
	}
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}
	
	@Column(name = "APPLY_SOURCE",length=20)
	public Apply_source getApplySource() {
		return applySource;
	}
	public void setApplySource(Apply_source applySource) {
		this.applySource = applySource;
	}
	
	@Column(name = "APPLY_PRODUCT",length=20)
	public String getApplyProduct() {
		return applyProduct;
	}
	public void setApplyProduct(String applyProduct) {
		this.applyProduct = applyProduct;
	}
	
	@Column(name = "APPLY_MONTH",length=20)
	public String getApplyMoney() {
		return applyMoney;
	}
	public void setApplyMoney(String applyMoney) {
		this.applyMoney = applyMoney;
	}
	
	@Column(name = "APPLY_TIME",length=30)
	public String getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}
	
	@Column(name = "LOAN_REASON",length=100)
	public String getLoanReason() {
		return loanReason;
	}
	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}
	
	@Column(name = "BANK_ID",length=30)
	public String getBankId() {
		return bankId;
	}
	public void setBankId(String bankId) {
		this.bankId = bankId;
	}
	
	@Column(name = "REFUND_PERIODS")
	public int getRefundPeriods() {
		return refundPeriods;
	}
	public void setRefundPeriods(int refundPeriods) {
		this.refundPeriods = refundPeriods;
	}
	
	@Column(name = "LINKMAN_NAME",length=20)
	public String getLinkmanName() {
		return linkmanName;
	}
	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}
	
	@Column(name = "LINKMAN_ADDR",length=100)
	public String getLinkmanAddr() {
		return linkmanAddr;
	}
	public void setLinkmanAddr(String linkmanAddr) {
		this.linkmanAddr = linkmanAddr;
	}
	
	@Column(name = "INKMAN_CELL",length=20)
	public String getLinkmanCell() {
		return linkmanCell;
	}
	public void setLinkmanCell(String linkmanCell) {
		this.linkmanCell = linkmanCell;
	}
	
	@Column(name = "LINKMAN_RELA",length=20)
	public String getLinkmanRela() {
		return linkmanRela;
	}
	public void setLinkmanRela(String linkmanRela) {
		this.linkmanRela = linkmanRela;
	}
	
	@Column(name = "APP_VISIT_NUM")
	public int getAppVisitNum() {
		return appVisitNum;
	}
	public void setAppVisitNum(int appVisitNum) {
		this.appVisitNum = appVisitNum;
	}
	
	@Column(name = "EDU_ATT_NUM")
	public int getEduAttNum() {
		return eduAttNum;
	}
	public void setEduAttNum(int eduAttNum) {
		this.eduAttNum = eduAttNum;
	}
	
	@Column(name = "BANK_RUNNING_ATT_NUM")
	public int getBankRunningAttNum() {
		return bankRunningAttNum;
	}
	public void setBankRunningAttNum(int bankRunningAttNum) {
		this.bankRunningAttNum = bankRunningAttNum;
	}
	
	@Column(name = "REQUEST_DATE")
	public Date getRequestTime() {
		return requestTime;
	}
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	} 
	
	
}
