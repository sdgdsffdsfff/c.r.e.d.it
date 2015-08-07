/**
 * 
 */
package com.ctc.credit.shenzhourong.dao;


import java.util.List;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.shenzhourong.model.SzrBlklistInfo;

/**
 * @author Chengang
 * 2015年7月24日 上午10:37:49 
 */
public interface SzrBlklistDao extends GenericDao<SzrBlklistInfo, String> {

	/**
	 * 根据姓名查询时间
	 * @author Chengang
	 * @param idNo
	 * @return
	 */
	public SzrBlklistInfo querycreateDate(String idNo, String name);
}
