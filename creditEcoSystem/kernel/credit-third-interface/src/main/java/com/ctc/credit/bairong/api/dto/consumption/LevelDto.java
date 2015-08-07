package com.ctc.credit.bairong.api.dto.consumption;
/**
 * 用户在该类目消费人群中的消费级别排名Dto
 * @author danggang
 *
 */
public class LevelDto {

	/**商品类型**/
	private String commodityType;
	/**根据过去12个月总消费金额（>0）排序)，该值=该用户排名/参与排名用户数量**/
	private String levelRanking;

	public String getCommodityType() {
		return commodityType;
	}

	public void setCommodityType(String commodityType) {
		this.commodityType = commodityType;
	}

	public String getLevelRanking() {
		return levelRanking;
	}

	public void setLevelRanking(String levelRanking) {
		this.levelRanking = levelRanking;
	}
	
	

}
