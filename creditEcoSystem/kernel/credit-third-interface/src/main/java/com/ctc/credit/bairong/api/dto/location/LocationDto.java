package com.ctc.credit.bairong.api.dto.location;


/*addrnm:
n:申请地址(1代表家庭住址，2代表公司地址，3代表户籍地址，4代表申请地址，5代表其他地址)
m:百融地址,最多输出5个
n1:两个地址之间的距离（根据经纬度,单位:千米(精确到小数点后第1位))*/

public class LocationDto {
	
	/** 流水账单**/
	private String swiftNumber;
	
	/** 家庭地址**/
	private HomeAddrDto home_addr;
	
	/** 公司地址**/
	private BizAddrDto biz_addr;
	
	/** 户籍地址**/
	private PerAddrDto per_addr;
	
	/** 申请地址**/
	private ApplyAddrDto apply_addr;
	
	/** 其他地址**/
	private OthAddrDto oth_addr;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public HomeAddrDto getHome_addr() {
		return home_addr;
	}

	public void setHome_addr(HomeAddrDto home_addr) {
		this.home_addr = home_addr;
	}

	public BizAddrDto getBiz_addr() {
		return biz_addr;
	}

	public void setBiz_addr(BizAddrDto biz_addr) {
		this.biz_addr = biz_addr;
	}

	public PerAddrDto getPer_addr() {
		return per_addr;
	}

	public void setPer_addr(PerAddrDto per_addr) {
		this.per_addr = per_addr;
	}

	public ApplyAddrDto getApply_addr() {
		return apply_addr;
	}

	public void setApply_addr(ApplyAddrDto apply_addr) {
		this.apply_addr = apply_addr;
	}

	public OthAddrDto getOth_addr() {
		return oth_addr;
	}

	public void setOth_addr(OthAddrDto oth_addr) {
		this.oth_addr = oth_addr;
	}
	
	
}