/**
 * 
 */
package com.ctc.credit.shenzhourong.dao.impl;

import org.springframework.stereotype.Repository;

import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
import com.ctc.credit.shenzhourong.dao.SzrRequestApplyDao;
import com.ctc.credit.shenzhourong.model.SzrRequestApplyInfo;

/**
 * @author Chengang
 * 2015年7月30日 上午9:36:24 
 */
@Repository
public class SzrRequestApplyDaoImpl extends DaoHibernate<SzrRequestApplyInfo, String> implements SzrRequestApplyDao {

}
