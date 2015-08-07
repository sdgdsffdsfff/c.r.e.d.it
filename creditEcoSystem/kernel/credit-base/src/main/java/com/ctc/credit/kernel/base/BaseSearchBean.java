package com.ctc.credit.kernel.base;

import java.util.Date;
import java.util.List;

import com.ctc.credit.kernel.util.StringUtil;



public abstract class BaseSearchBean extends BaseObject {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5675130527310417237L;	
	protected StringBuffer whereStr = new StringBuffer(" where 1=1 "); //查询条件
	protected List<Object> paramList;
	protected String entityName = "";  //实体名称

	private String id;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 生成查询条件
	 * 
	 * @param
	 * @return
	 * @create by WPF at 2009-07-01
	 */
	public String genWhereString(String entityName, List<Object> paramList) {
		if (!StringUtil.isNullStr(entityName)) {
			this.entityName = entityName + ".";
		}
		this.paramList = paramList;
		return whereStr.toString();
	}
	
	public void appendLike(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " like ? ");
			paramList.add("%" + cloumnValue + "%");
		}
	}
	
	public void appendEqual(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " = ? ");
			paramList.add(cloumnValue);
		}
	}
	public void appendEqualInt(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " = ? ");
			paramList.add(StringUtil.nullToInteger(cloumnValue));
		}
	}
	public void appendNotEqualInt(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " != ? ");
			paramList.add(StringUtil.nullToInteger(cloumnValue));
		}
	}
	public void appendEqualLong(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " = ? ");
			paramList.add(StringUtil.nullToLong(cloumnValue));
		}
	}
	
	public void appendMaxLong(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " <= ? ");
			paramList.add(StringUtil.nullToLong(cloumnValue));
		}
	}
	
	public void appendMinLong(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " >= ? ");
			paramList.add(StringUtil.nullToLong(cloumnValue));
		}
	}
	
	public void appendMaxInt(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " <= ? ");
			paramList.add(StringUtil.nullToInteger(cloumnValue));
		}
	}
	public void appendMinInt(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " >= ? ");
			paramList.add(StringUtil.nullToInteger(cloumnValue));
		}
	}
	
	public void appendMax(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " <= ? ");
			paramList.add(cloumnValue);
		}
	}
	public void appendMin(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue)){
			whereStr.append(" and " + entityName  + columnName + " >= ? ");
			paramList.add(cloumnValue);
		}
	}
	
	public void appendMaxDateTime(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue) ){
			Date dt =  StringUtil.strToDateTime(cloumnValue);
			if(dt != null){
				whereStr.append(" and " + entityName  + columnName + " <= ? ");
				paramList.add(dt);
			}
		}
	}
	
	public void appendMinDateTime(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue) ){
			Date dt =  StringUtil.strToDateTime(cloumnValue);
			if(dt != null){
				whereStr.append(" and " + entityName  + columnName + " >= ? ");
				paramList.add(dt);
			}
		}
	}
	
	public void appendMaxDate(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue) ){
			Date dt =  StringUtil.strToDateTime(cloumnValue + " 23:59:59");
			if(dt != null){
				whereStr.append(" and " + entityName  + columnName + " <= ? ");
				paramList.add(dt);
			}
		}
	}
	
	public void appendMinDate(String columnName, String cloumnValue) {
		if(!StringUtil.isNullStr(cloumnValue) ){
			Date dt =  StringUtil.strToDateTime(cloumnValue + " 00:00:00");
			if(dt != null){
				whereStr.append(" and " + entityName  + columnName + " >= ? ");
				paramList.add(dt);
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BaseSearchBean other = (BaseSearchBean) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
