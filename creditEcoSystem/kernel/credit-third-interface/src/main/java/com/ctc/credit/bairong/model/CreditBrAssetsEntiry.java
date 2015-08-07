package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;
/**
 * 百融:资产评估实体类
 * @author danggang
 *
 */
@Entity
@Table(name = "BAIRONG_ASSETS_INFO")
public class CreditBrAssetsEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = 6941618354089264310L;
	
	/**流水账单*/
	private String swiftNumber;
	
	/**house: 0（无），1（明确有），2（很大概率有）*/
	private String house;
	
	/**car: 0（无），1（明确有），2（很大概率有）*/
	private String car;
	
	/**fin:0（无），1（明确有）*/
	private String fin;
	
	/**wealth:0（无），1（高储蓄净值用户），2（金融机构高端用户），3（电信运营商高端用户）*/
	private String wealth;

	@Column(name = "SWIFT_NUMBER",length=255)
	public String getSwiftNumber() {
		return swiftNumber;
	}

	public void setSwiftNumber(String swiftNumber) {
		this.swiftNumber = swiftNumber;
	}
	@Column(name = "HOUSE",length=1)
	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	@Column(name = "CAR",length=1)
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	@Column(name = "FIN",length=1)
	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}
	@Column(name = "WEALTH",length=1)
	public String getWealth() {
		return wealth;
	}

	public void setWealth(String wealth) {
		this.wealth = wealth;
	}
}
