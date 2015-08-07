package com.ctc.credit.kernel.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * ParamBean
 * 
 * @version 1.0.0
 * 
 */
public class ParamBean  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6023651813530695675L;
	
	/**
	 * 查询字段
	 */
	private String queryString;
	
	/**
	 * 缓存标志
	 */
	private Object cacheTag;
	
	/**
	 * 输入对象
	 */
	private Object searchBean;
	/**
	 * 输入对象集合
	 */
	private List<Object> searchBeanList = new ArrayList<Object>(10);
	/**
	 * 结果集总数
	 */
	private Integer total;
	/**
	 * 结果集索引开始位置
	 */
	private Integer start = 0;
	/**
	 * 结果集数量限制
	 */
	private Integer limit = 50;
	/**
	 * 结果集页数
	 */
	private Integer page = 1;
	
	/**
	 * 是否返回结果数
	 */
	private Boolean needCount = true;
	
	/**
	 * 排序信息对象
	 */
	private SortBean sortBean = new SortBean();

	/**
	 * 根据参数索引获取参数对象 getParam
	 * 
	 * @param i
	 * @return Object
	 * @exception
	 * @since 1.0.0
	 */
	public Object getParam(Integer i) {
		return getSearchBeanList().get(i);
	}

	public List<Object> getSearchBeanList() {
		return searchBeanList == null ? new ArrayList<Object>(10)
				: searchBeanList;
	}

	public ParamBean setSearchBeanList(List<Object> searchBeanList) {
		this.searchBeanList = searchBeanList;
		return this;
	}

	public ParamBean addSearchBeanect(Object obj) {
		getSearchBeanList().add(obj);
		return this;
	}

	public ParamBean addInputObject(Integer postion, Object obj) {
		getSearchBeanList().set(postion, obj);
		return this;
	}

	public SortBean getSortBean() {
		return sortBean;
	}

	public ParamBean setSortBean(SortBean sortBean) {
		this.sortBean = sortBean;
		return this;
	}

	public Integer getPage() {
		return page;
	}

	public ParamBean setPage(Integer page) {
		this.page = page;
		return this;
	}

	public Object getSearchBean() {
		return searchBean;
	}

	public ParamBean setSearchBean(Object searchBean) {
		this.searchBean = searchBean;
		return this;
	}

	public Integer getTotal() {
		return total;
	}

	public ParamBean setTotal(Integer total) {
		this.total = total;
		return this;
	}

	public Integer getStart() {
		return start;
	}

	public ParamBean setStart(Integer start) {
		this.start = start;
		return this;
	}

	public Integer getLimit() {
		return limit;
	}

	public ParamBean setLimit(Integer limit) {
		this.limit = limit;
		return this;
	}

	

	
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}

	public String getQueryString() {
		return queryString;
	}

	public Boolean getNeedCount() {
		return needCount;
	}

	public void setNeedCount(Boolean needCount) {
		this.needCount = needCount;
	}


	public void setCacheTag(Object cacheTag) {
		this.cacheTag = cacheTag;
	}

	public Object getCacheTag() {
		return cacheTag;
	}

	@Override
	public String toString() {
		return "ParamBean [cacheTag=" + cacheTag + ", searchBean=" + searchBean
				+ ", searchBeanList=" + searchBeanList + ", total=" + total
				+ ", start=" + start + ", limit=" + limit + ", page=" + page
				+ ", needCount=" + needCount + ", sortBean=" + sortBean + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cacheTag == null) ? 0 : cacheTag.hashCode());
		result = prime * result + ((limit == null) ? 0 : limit.hashCode());
		result = prime * result
				+ ((needCount == null) ? 0 : needCount.hashCode());
		result = prime * result + ((page == null) ? 0 : page.hashCode());
		result = prime * result
				+ ((queryString == null) ? 0 : queryString.hashCode());
		result = prime * result
				+ ((searchBean == null) ? 0 : searchBean.hashCode());
		result = prime * result
				+ ((searchBeanList == null) ? 0 : searchBeanList.hashCode());
		result = prime * result
				+ ((sortBean == null) ? 0 : sortBean.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParamBean other = (ParamBean) obj;
		if (cacheTag == null) {
			if (other.cacheTag != null)
				return false;
		} else if (!cacheTag.equals(other.cacheTag))
			return false;
		if (limit == null) {
			if (other.limit != null)
				return false;
		} else if (!limit.equals(other.limit))
			return false;
		if (needCount == null) {
			if (other.needCount != null)
				return false;
		} else if (!needCount.equals(other.needCount))
			return false;
		if (page == null) {
			if (other.page != null)
				return false;
		} else if (!page.equals(other.page))
			return false;
		if (queryString == null) {
			if (other.queryString != null)
				return false;
		} else if (!queryString.equals(other.queryString))
			return false;
		if (searchBean == null) {
			if (other.searchBean != null)
				return false;
		} else if (!searchBean.equals(other.searchBean))
			return false;
		if (searchBeanList == null) {
			if (other.searchBeanList != null)
				return false;
		} else if (!searchBeanList.equals(other.searchBeanList))
			return false;
		if (sortBean == null) {
			if (other.sortBean != null)
				return false;
		} else if (!sortBean.equals(other.sortBean))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
	
}
