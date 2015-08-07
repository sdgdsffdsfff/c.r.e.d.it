package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "BAIRONG_LEVEL_INFO")
public class CreareBrLevelEntiry extends AbstractCreditEntity{

	private static final long serialVersionUID = 768387768811246835L;
	
	
	/**商品类型*/
	private String merchandiseType;
	
	/**用户在该类目消费人群中的消费级别排名（根据过去12个月总消费金额（>0）排序)，该值=该用户排名/参与排名用户数量*/
	private String level;
	
	@Column(name = "MERCHANDISE_TYPE",length=255)
	public String getMerchandiseType() {
		return merchandiseType;
	}

	public void setMerchandiseType(String merchandiseType) {
		this.merchandiseType = merchandiseType;
	}
	@Column(name = "LEVELS",length=255)
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
	
	

}
