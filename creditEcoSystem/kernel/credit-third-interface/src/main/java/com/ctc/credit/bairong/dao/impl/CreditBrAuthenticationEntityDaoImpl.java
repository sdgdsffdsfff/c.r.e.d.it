package com.ctc.credit.bairong.dao.impl;
/**
 * 百融：身份核实DTO实现
 */
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.ctc.credit.bairong.dao.CreditBrAuthenticationEntityDao;
import com.ctc.credit.bairong.model.CreditBrAuthenticationEntity;
import com.ctc.credit.kernel.base.BaseSearchBean;
import com.ctc.credit.kernel.base.PageList;
import com.ctc.credit.kernel.base.ParamBean;
import com.ctc.credit.kernel.base.ResultBean;
import com.ctc.credit.kernel.dao.hibernate.DaoHibernate;
@Repository
public class CreditBrAuthenticationEntityDaoImpl extends DaoHibernate<CreditBrAuthenticationEntity, String> implements CreditBrAuthenticationEntityDao {
}
