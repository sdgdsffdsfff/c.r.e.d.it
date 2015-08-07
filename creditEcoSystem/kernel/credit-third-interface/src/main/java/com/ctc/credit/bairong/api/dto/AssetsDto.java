package com.ctc.credit.bairong.api.dto;
/**
 * 资产评估
 * house: 0（无），1（明确有），2（很大概率有）
 * car: 0（无），1（明确有），2（很大概率有）
 * fin:0（无），1（明确有）
 * wealth:0（无），1（高储蓄净值用户），2（金融机构高端用户），3（电信运营商高端用户）
 * @author danggang
 *
 */
public class AssetsDto {
	
	/** 流水账单**/
	private String swiftNumber;
	
	/** house: 0（无），1（明确有），2（很大概率有）**/
	private String house;
	
	/** car: 0（无），1（明确有），2（很大概率有）**/
	private String car;
	
	/** fin:0（无），1（明确有）**/
	private String fin;
	
	/** wealth:0（无），1（高储蓄净值用户），2（金融机构高端用户），3（电信运营商高端用户）**/
	private String wealth;

	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}

	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public String getWealth() {
		return wealth;
	}

	public void setWealth(String wealth) {
		this.wealth = wealth;
	}
	
	
}
