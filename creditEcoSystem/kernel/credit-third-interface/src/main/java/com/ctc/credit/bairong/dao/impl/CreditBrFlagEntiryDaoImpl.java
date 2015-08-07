package com.ctc.credit.bairong.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreditBrFlagEntiryDao;
import com.ctc.credit.bairong.model.CreditBrFlagEntiry;
import com.ctc.credit.kernel.base.BaseSearchBean;
import com.ctc.credit.kernel.base.PageList;
import com.ctc.credit.kernel.base.ParamBean;
import com.ctc.credit.kernel.base.ResultBean;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
/**
 * 百融：报告输出标识dao实现
 * @author danggang
 *
 */
@Repository
public class CreditBrFlagEntiryDaoImpl extends DaoHibernate<CreditBrFlagEntiry, String> implements CreditBrFlagEntiryDao {

}
