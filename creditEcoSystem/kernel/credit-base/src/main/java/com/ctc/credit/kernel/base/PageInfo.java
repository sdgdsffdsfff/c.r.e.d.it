package com.ctc.credit.kernel.base;

//分页用的参数信息
public class PageInfo {
    public static final int DESCENDING =1; //$NON-NLS-1$
    public static final int ASCENDING = 2; //$NON-NLS-1$
    public boolean resultNeedPage = true;
    
	// 总记录数
	private int fullListSize = 0;
	//每页记录数
	private int pageSize = 20;
	// 当前页码
	private int start = 0;
	// an ID for the search used to get the list
	private String searchId;
	// 排序字段
	private String sortCriterion;
	// 正序或逆序
	private int sortDirection = 0;

	public int getFirstRow() {
		return this.pageSize * (this.start - 1);
	}

	public int getFullListSize() {
		return this.fullListSize;
	}

	public int getObjectsPerPage() {
		return this.pageSize;
	}

	public int getPageNumber() {
		return this.start;
	}

	public String getSearchId() {
		return this.searchId;
	}

	public String getSortCriterion() {
		return this.sortCriterion;
	}

	public int getSortDirection() {
		return this.sortDirection;
	}

	public void setFullListSize(final int fullListSize) {
		this.fullListSize = fullListSize;
	}

	public void setObjectsPerPage(final int objectsPerPage) {
		this.pageSize = objectsPerPage;
	}

	public void setPageNumber(final int start) {
		this.start = start + 1;
	}

	public void setSearchId(final String searchId) {
		this.searchId = searchId;
	}

	public void setSortCriterion(final String sortCriterion) {
		this.sortCriterion = sortCriterion;
	}

	public void setSortDirection(final int sortDirection) {
		this.sortDirection = sortDirection;
	}
	public boolean isResultNeedPage() {
		return resultNeedPage;
	}
	public void setResultNeedPage(boolean resultNeedPage) {
		this.resultNeedPage = resultNeedPage;
	}

	@Override
	public String toString() {
		return "PageInfo [resultNeedPage=" + resultNeedPage + ", fullListSize="
				+ fullListSize + ", pageSize=" + pageSize + ", start=" + start
				+ ", searchId=" + searchId + ", sortCriterion=" + sortCriterion
				+ ", sortDirection=" + sortDirection + "]";
	}
	
}
