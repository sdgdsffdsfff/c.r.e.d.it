package com.ztx.credit.report.model;

/**
 * 最近两年内的查询次数
 * 
 * @author xucy
 *
 */
public class Last2YearsQuery {
	private String postLoanManageCount;
	private String guaranteeCount;
	private String merchantReview;

	public String getPostLoanManageCount() {
		return postLoanManageCount;
	}

	public void setPostLoanManageCount(String postLoanManageCount) {
		this.postLoanManageCount = postLoanManageCount;
	}

	public String getGuaranteeCount() {
		return guaranteeCount;
	}

	public void setGuaranteeCount(String guaranteeCount) {
		this.guaranteeCount = guaranteeCount;
	}

	public String getMerchantReview() {
		return merchantReview;
	}

	public void setMerchantReview(String merchantReview) {
		this.merchantReview = merchantReview;
	}

	@Override
	public String toString() {
		return "Last2YearsQuery [postLoanManageCount=" + postLoanManageCount
				+ ", guaranteeCount=" + guaranteeCount + ", merchantReview="
				+ merchantReview + "]";
	}

}
