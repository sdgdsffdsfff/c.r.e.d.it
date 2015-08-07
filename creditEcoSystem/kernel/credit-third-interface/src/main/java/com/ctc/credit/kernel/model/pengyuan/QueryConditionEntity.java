package com.ctc.credit.kernel.model.pengyuan;

import java.io.Serializable;

/**
 * 
 * 通用查询条件实体对象
 * 
 * @author sunny
 * 
 */
public class QueryConditionEntity implements Serializable {

	private static final long serialVersionUID = 3255091409897261305L;

	/**
	 * <pre>
	 * 查询类型：
	 *  PY90035 ：电话正查
	 *  PY21603 ：电话反查
	 * </pre>
	 */
	private String queryType;
	
	/**
	 * <pre>
	 * 查询源:
	 *  SRC1:小贷
	 *  SRC2:账务
	 *  SRC3:其他【待扩展。。】
	 * </pre>
	 */
	private String querySource;
	
	/**
	 * 查询参数
	 */
	private QueryParameterEntity queryParas;

	/**
	 * @return the queryType
	 */
	public String getQueryType() {
		return queryType;
	}

	/**
	 * @param queryType the queryType to set
	 */
	public void setQueryType(String queryType) {
		this.queryType = queryType;
	}

	/**
	 * @return the querySource
	 */
	public String getQuerySource() {
		return querySource;
	}

	/**
	 * @param querySource the querySource to set
	 */
	public void setQuerySource(String querySource) {
		this.querySource = querySource;
	}

	/**
	 * @return the queryParas
	 */
	public QueryParameterEntity getQueryParas() {
		return queryParas;
	}

	/**
	 * @param queryParas the queryParas to set
	 */
	public void setQueryParas(QueryParameterEntity queryParas) {
		this.queryParas = queryParas;
	}
	
}
