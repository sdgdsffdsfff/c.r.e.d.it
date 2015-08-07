/**
 * 
 */
package com.ctc.credit.shenzhourong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.shenzhourong.dao.SzrBlklistDao;
import com.ctc.credit.shenzhourong.model.SzrBlklistInfo;
import com.ctc.credit.shenzhourong.model.SzrCPointInfo;

/**
 * @author Chengang
 * 2015年7月24日 上午10:39:09 
 */
@Repository
public class SzrBlklistDaoImpl extends DaoHibernate<SzrBlklistInfo, String> implements SzrBlklistDao {

	@SuppressWarnings("unchecked")
	@Override
	public SzrBlklistInfo querycreateDate(String idNo, String name) {
		String hql = "from SzrBlklistInfo t where t.idNo=? and t.name=?";
		List<SzrBlklistInfo> dates = this.query(hql, new Object[]{idNo,name});
		return dates.size()>0?dates.get(0):null;
	}
	
	
	

}
