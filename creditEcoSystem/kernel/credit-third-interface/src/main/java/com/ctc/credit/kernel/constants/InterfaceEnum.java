package com.ctc.credit.kernel.constants;

/**
 * 通用接口类型枚举类
 * 
 * @author sunny
 *
 */
public enum InterfaceEnum {
	
	RH("10"), // 爱金接口
	JXL("20"), // 聚信立接口
	PY("30"); // 鹏元接口

	private String interfaceCategory;

	private InterfaceEnum(String interfaceCategory) {
		this.interfaceCategory = interfaceCategory;
	}

	public String getChannel() {
		return interfaceCategory;
	}
	
}
