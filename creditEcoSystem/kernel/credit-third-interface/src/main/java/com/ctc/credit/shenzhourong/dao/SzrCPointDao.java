/**
 * 
 */
package com.ctc.credit.shenzhourong.dao;

import com.ctc.credit.kernel.base.GenericDao;
import com.ctc.credit.shenzhourong.model.SzrCPointInfo;

/**
 * @author Chengang
 * 2015年7月28日 上午11:55:04 
 */
public interface SzrCPointDao extends GenericDao<SzrCPointInfo, String>  {
	
	public SzrCPointInfo getCreateDate(String mobile);

}
