package com.ctc.credit.tongdun.api.dto;

public class TongDunReqRiskApiDetailDto {
	private String partner_code;
	private String partner_key;
	private String sequence_id;
	private String rule_uuid;
	public String getPartner_code() {
		return partner_code;
	}
	public void setPartner_code(String partner_code) {
		this.partner_code = partner_code;
	}
	
	public String getSequence_id() {
		return sequence_id;
	}
	public void setSequence_id(String sequence_id) {
		this.sequence_id = sequence_id;
	}
	public String getRule_uuid() {
		return rule_uuid;
	}
	public void setRule_uuid(String rule_uuid) {
		this.rule_uuid = rule_uuid;
	}
	public String getPartner_key() {
		return partner_key;
	}
	public void setPartner_key(String partner_key) {
		this.partner_key = partner_key;
	}
	
	
}
