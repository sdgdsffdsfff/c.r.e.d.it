package com.ctc.credit.kernel.base;

import java.io.Serializable;

import com.ctc.credit.kernel.util.StringUtil;



/**
 * 
 * SortBean
 * 
 * Creator: sunyue 2012-5-3 上午10:16:25
 * 
 * @version 1.0.0
 * 
 */
public class SortBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5002830185520511765L;
	private String property;
	private String direction;

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getDirection() {
		return direction == null || direction.equals("") ? "desc" : direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public SortBean(String property, String direction) {
		super();
		this.property = property;
		this.direction = direction;
	}

	public SortBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSortString() {
		if (!StringUtil.isNullStr(property)) {
			return " order by " + property + " " + getDirection();
		} else {
			return "";
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((direction == null) ? 0 : direction.hashCode());
		result = prime * result
				+ ((property == null) ? 0 : property.hashCode());
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
		SortBean other = (SortBean) obj;
		if (direction == null) {
			if (other.direction != null)
				return false;
		} else if (!direction.equals(other.direction))
			return false;
		if (property == null) {
			if (other.property != null)
				return false;
		} else if (!property.equals(other.property))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SortBean [property=" + property + ", direction=" + direction
				+ "]";
	}
	

}
