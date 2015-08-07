/**
 * 
 */
package com.ctc.credit.bairong.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ctc.credit.kernel.orm.entity.impl.AbstractCreditEntity;

/**
 * @author Chengang
 * 2015年8月3日 下午3:33:19 
 */
@Entity
@Table(name = "BAIRONG_RATING_INFO")
public class CreareBrRatingInfo extends AbstractCreditEntity {
	private static final long serialVersionUID = -6753096608644828907L;

	/** 流水号 **/
	private String swiftNo;
	
	/** p2p媒体阅览评级 **/
	private String p2pMediaRating;
	
	/** p2p消费评级 **/
	private String p2pConsumeRating;
	
	/** p2p百融信用评级 **/
	private String p2pBrcreditRating;

	@Column(name = "SWIFT_NUMBER")
	public String getSwiftNo() {
		return swiftNo;
	}

	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}

	@Column(name = "P2P_MEDIA_RATING")
	public String getP2pMediaRating() {
		return p2pMediaRating;
	}

	public void setP2pMediaRating(String p2pMediaRating) {
		this.p2pMediaRating = p2pMediaRating;
	}

	@Column(name = "P2P_CONSUME_RATING")
	public String getP2pConsumeRating() {
		return p2pConsumeRating;
	}

	public void setP2pConsumeRating(String p2pConsumeRating) {
		this.p2pConsumeRating = p2pConsumeRating;
	}

	@Column(name = "P2P_BRCREDIT_RATING")
	public String getP2pBrcreditRating() {
		return p2pBrcreditRating;
	}

	public void setP2pBrcreditRating(String p2pBrcreditRating) {
		this.p2pBrcreditRating = p2pBrcreditRating;
	}
	
}
