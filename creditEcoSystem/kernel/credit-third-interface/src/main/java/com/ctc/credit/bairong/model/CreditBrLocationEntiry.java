package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融：位置信息核查实体类
 * 
 * 位置信息核查addrnm:
 * n:申请地址(1代表家庭住址，2代表公司地址，3代表户籍地址，4代表申请地址，5代表其他地址)
 * m:百融地址,最多输出5个n1:两个地址之间的距离（根据经纬度,单位:千米(精确到小数点后第1位))
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_LOCATION_INFO")
public class CreditBrLocationEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = 4369776351529634247L;
	
	/**流水账单*/
	private String swiftNumber;
	
	private String addr11;
	private String addr12;
	private String addr13;
	private String addr14;
	private String addr15;
	
	private String addr21;
	private String addr22;
	private String addr23;
	private String addr24;
	private String addr25;
	
	private String addr31;
	private String addr32;
	private String addr33;
	private String addr34;
	private String addr35;
	
	private String addr41;
	private String addr42;
	private String addr43;
	private String addr44;
	private String addr45;
	
	private String addr51;
	private String addr52;
	private String addr53;
	private String addr54;
	private String addr55;
	
	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}
	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}
	@Column(name = "ADDR11",length=255)
	public String getAddr11() {
		return addr11;
	}
	public void setAddr11(String addr11) {
		this.addr11 = addr11;
	}
	@Column(name = "ADDR12",length=255)
	public String getAddr12() {
		return addr12;
	}
	public void setAddr12(String addr12) {
		this.addr12 = addr12;
	}
	
	@Column(name = "ADDR13",length=255)
	public String getAddr13() {
		return addr13;
	}
	public void setAddr13(String addr13) {
		this.addr13 = addr13;
	}
	
	@Column(name = "ADDR14",length=255)
	public String getAddr14() {
		return addr14;
	}
	public void setAddr14(String addr14) {
		this.addr14 = addr14;
	}
	
	@Column(name = "ADDR15",length=255)
	public String getAddr15() {
		return addr15;
	}
	public void setAddr15(String addr15) {
		this.addr15 = addr15;
	}
	
	@Column(name = "ADDR21",length=255)
	public String getAddr21() {
		return addr21;
	}
	public void setAddr21(String addr21) {
		this.addr21 = addr21;
	}
	
	@Column(name = "ADDR22",length=255)
	public String getAddr22() {
		return addr22;
	}
	public void setAddr22(String addr22) {
		this.addr22 = addr22;
	}
	
	@Column(name = "ADDR23",length=255)
	public String getAddr23() {
		return addr23;
	}
	public void setAddr23(String addr23) {
		this.addr23 = addr23;
	}
	
	@Column(name = "ADDR24",length=255)
	public String getAddr24() {
		return addr24;
	}
	public void setAddr24(String addr24) {
		this.addr24 = addr24;
	}
	
	@Column(name = "ADDR25",length=255)
	public String getAddr25() {
		return addr25;
	}
	public void setAddr25(String addr25) {
		this.addr25 = addr25;
	}
	
	@Column(name = "ADDR31",length=255)
	public String getAddr31() {
		return addr31;
	}
	public void setAddr31(String addr31) {
		this.addr31 = addr31;
	}
	
	@Column(name = "ADDR32",length=255)
	public String getAddr32() {
		return addr32;
	}
	public void setAddr32(String addr32) {
		this.addr32 = addr32;
	}
	
	@Column(name = "ADDR33",length=255)
	public String getAddr33() {
		return addr33;
	}
	public void setAddr33(String addr33) {
		this.addr33 = addr33;
	}
	
	@Column(name = "ADDR34",length=255)
	public String getAddr34() {
		return addr34;
	}
	public void setAddr34(String addr34) {
		this.addr34 = addr34;
	}
	
	@Column(name = "ADDR35",length=255)
	public String getAddr35() {
		return addr35;
	}
	public void setAddr35(String addr35) {
		this.addr35 = addr35;
	}
	
	@Column(name = "ADDR41",length=255)
	public String getAddr41() {
		return addr41;
	}
	public void setAddr41(String addr41) {
		this.addr41 = addr41;
	}
	
	@Column(name = "ADDR42",length=255)
	public String getAddr42() {
		return addr42;
	}
	public void setAddr42(String addr42) {
		this.addr42 = addr42;
	}
	
	@Column(name = "ADDR43",length=255)
	public String getAddr43() {
		return addr43;
	}
	public void setAddr43(String addr43) {
		this.addr43 = addr43;
	}
	
	@Column(name = "ADDR44",length=255)
	public String getAddr44() {
		return addr44;
	}
	public void setAddr44(String addr44) {
		this.addr44 = addr44;
	}
	
	@Column(name = "ADDR45",length=255)
	public String getAddr45() {
		return addr45;
	}
	public void setAddr45(String addr45) {
		this.addr45 = addr45;
	}
	
	@Column(name = "ADDR51",length=255)
	public String getAddr51() {
		return addr51;
	}
	public void setAddr51(String addr51) {
		this.addr51 = addr51;
	}
	
	@Column(name = "ADDR52",length=255)
	public String getAddr52() {
		return addr52;
	}
	public void setAddr52(String addr52) {
		this.addr52 = addr52;
	}
	@Column(name = "ADDR53",length=255)
	public String getAddr53() {
		return addr53;
	}
	public void setAddr53(String addr53) {
		this.addr53 = addr53;
	}
	
	@Column(name = "ADDR54",length=255)
	public String getAddr54() {
		return addr54;
	}
	public void setAddr54(String addr54) {
		this.addr54 = addr54;
	}
	
	@Column(name = "ADDR55",length=255)
	public String getAddr55() {
		return addr55;
	}
	public void setAddr55(String addr55) {
		this.addr55 = addr55;
	}
	
	

}
