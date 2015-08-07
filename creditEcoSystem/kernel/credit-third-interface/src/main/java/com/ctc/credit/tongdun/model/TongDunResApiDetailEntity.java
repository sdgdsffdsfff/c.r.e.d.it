package com.ctc.credit.tongdun.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

@Entity
@Table(name = "TONGDUNRULESDETAILRES_INFO")
public class TongDunResApiDetailEntity extends AbstractCreditEntity{
/**
 * 
 */
private static final long serialVersionUID = -6089725864444542752L;

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