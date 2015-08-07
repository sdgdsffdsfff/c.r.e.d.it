package com.ctc.credit.bairong.api.dto;

public class RatingDto {
	/** 流水号 **/
	private String swiftNo;
	
	/** p2p媒体阅览评级 **/
	private String p2pMediaRating;
	
	/** p2p消费评级 **/
	private String p2pConsumeRating;
	
	/** p2p百融信用评级 **/
	private String p2pBrcreditRating;

	public String getSwiftNo() {
		return swiftNo;
	}

	public void setSwiftNo(String swiftNo) {
		this.swiftNo = swiftNo;
	}

	public String getP2pMediaRating() {
		return p2pMediaRating;
	}

	public void setP2pMediaRating(String p2pMediaRating) {
		this.p2pMediaRating = p2pMediaRating;
	}

	public String getP2pConsumeRating() {
		return p2pConsumeRating;
	}

	public void setP2pConsumeRating(String p2pConsumeRating) {
		this.p2pConsumeRating = p2pConsumeRating;
	}

	public String getP2pBrcreditRating() {
		return p2pBrcreditRating;
	}

	public void setP2pBrcreditRating(String p2pBrcreditRating) {
		this.p2pBrcreditRating = p2pBrcreditRating;
	}
	
}
