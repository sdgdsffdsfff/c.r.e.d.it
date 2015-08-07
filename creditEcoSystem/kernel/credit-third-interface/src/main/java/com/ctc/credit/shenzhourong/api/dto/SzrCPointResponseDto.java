/**
 * 
 */
package com.ctc.credit.shenzhourong.api.dto;

/**
 * @author Chengang
 * 2015年7月27日 下午2:08:08 
 */
public class SzrCPointResponseDto {
	/** 返回状态代码  **/
	private String status;
	/** 返回 状态值 **/
	private String value;
	/** 手机 **/
	private String mobile;
	/** 分数 **/
	private String score;
	/** 返回 状态值 **/
	private String tag1;
	/** 返回 状态值 **/
	private String tag2;
	/** 返回 状态值 **/
	private String tag3;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getTag1() {
		return tag1;
	}
	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}
	public String getTag2() {
		return tag2;
	}
	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}
	public String getTag3() {
		return tag3;
	}
	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}
	
	

}
