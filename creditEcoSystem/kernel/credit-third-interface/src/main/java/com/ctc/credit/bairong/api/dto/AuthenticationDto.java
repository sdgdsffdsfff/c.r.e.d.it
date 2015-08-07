package com.ctc.credit.bairong.api.dto;
/**
 * 身份信息核查
 * id:1（匹配成功）0（匹配失败）
 * cell:1（匹配成功）0（匹配失败）
 * mail:1（匹配成功）0（匹配失败）
 * key_relation: 由三位0/1字符组成，表示匹配成功的核心key值（id、cell、mail）之间的关系；
 * 第一位表示id和cell之间的关联关系，1为有关联，0为没有关联；第二位表示id和mail的关系取值同上；
 * 第三位表示cell和mail之间的关系，取值同上name:1（匹配成功）0（匹配失败）
 * tel_biz:1（匹配成功）0（匹配失败）
 * tel_home: 1（匹配成功）0（匹配失败）
 * @author danggang
 *
 */
public class AuthenticationDto {
	
	/** 流水账单**/
	private String swiftNumber;
	/** id身份证号码:1（匹配成功）0（匹配失败）**/
	private String id;
	/** cell手机号码:1（匹配成功）0（匹配失败）**/
	private String cell;
	/** mail邮箱地址:1（匹配成功）0（匹配失败）**/
	private String mail;
	/**key_relation: 由三位0/1字符组成，表示匹配成功的核心key值（id、cell、mail）之间的关系；
	 * 第一位表示id和cell之间的关联关系，1为有关联，0为没有关联；第二位表示id和mail的关系取值同上；
	 * 第三位表示cell和mail之间的关系，取值同上**/
	private String key_relation;
	/** name:1（匹配成功）0（匹配失败）**/
	private String name;
	/** tel_biz:1（匹配成功）0（匹配失败）**/
	private String tel_biz;
	/** tel_home: 1（匹配成功）0（匹配失败）**/
	private String tel_home;
	
	
	public String getSwiftNumber() {
		return swiftNumber;
	}
	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getKey_relation() {
		return key_relation;
	}
	public void setKey_relation(String key_relation) {
		this.key_relation = key_relation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel_biz() {
		return tel_biz;
	}
	public void setTel_biz(String tel_biz) {
		this.tel_biz = tel_biz;
	}
	public String getTel_home() {
		return tel_home;
	}
	public void setTel_home(String tel_home) {
		this.tel_home = tel_home;
	}
			
}
