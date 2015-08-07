
package com.ctc.credit.tongdun.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "TONGDUNRISKAPIRES_INFO")
public class TongDunResRiskApiEntity extends AbstractCreditEntity {
/**
 * 
 */
private static final long serialVersionUID = -5755908138479559088L;

private String p_id;

private String resinfo;

@Column(name="p_id")
public String getP_id() {
	return p_id;
}
public void setP_id(String p_id) {
	this.p_id = p_id;
}
@Column(name="resinfo")
public String getResinfo() {
	return resinfo;
}
public void setResinfo(String resinfo) {
	this.resinfo = resinfo;
}


}