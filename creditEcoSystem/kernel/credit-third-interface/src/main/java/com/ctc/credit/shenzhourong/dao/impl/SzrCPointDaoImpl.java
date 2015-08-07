/**
 * 
 */
package com.ctc.credit.shenzhourong.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.shenzhourong.dao.SzrCPointDao;
import com.ctc.credit.shenzhourong.model.SzrCPointInfo;

/**
 * @author Chengang
 * 2015年7月28日 上午11:56:42 
 */
@Repository
public class SzrCPointDaoImpl extends DaoHibernate<SzrCPointInfo, String> implements SzrCPointDao{

	
	@SuppressWarnings("unchecked")
	@Override
	public SzrCPointInfo getCreateDate(String mobile) {
		String hql = "from SzrCPointInfo t where t.mobile=?";
		List<SzrCPointInfo> datas = this.query(hql, new Object[]{mobile});
		return datas.size() > 0 ? datas.get(0) : null;
	}
}
