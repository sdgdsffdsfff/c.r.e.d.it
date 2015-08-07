package com.ctc.credit.kernel.base;

import java.io.Reader;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Clob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.util.Assert;

import com.ctc.credit.kernel.util.StringUtil;

  
/**
 * This class serves as the Base class for all other DAOs - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * 
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre> 
 *      &lt;bean id=&quot;fooDao&quot; class=&quot;com.wondertek.mobiletv.dao.hibernate.GenericDaoHibernate&quot;&gt;
 *          &lt;constructor-arg value=&quot;com.wondertek.mobiletv.model.Foo&quot;/&gt;
 *          &lt;property name=&quot;sessionFactory&quot; ref=&quot;sessionFactory&quot;/&gt;
 *      &lt;/bean&gt;
 * </pre>
 * 
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
@SuppressWarnings("rawtypes")
@Repository
public class GenericDaoHibernate<T, PK extends Serializable> implements
		GenericDao<T, PK> {
	
	public GenericDaoHibernate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log log = LogFactory.getLog(getClass());
	protected Class<T> persistentClass;

	/**
	 * Constructor that takes in a class to see which type of entity to persist
	 * 
	 * @param persistentClass
	 *            the class type you'd like to persist
	 */
	public GenericDaoHibernate(final Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	private SessionFactory sessionFactory;

	public Session getSession() {
		Assert.notNull(sessionFactory,
				"-----------sessionFactory can not be null-----------------");
		return sessionFactory.getCurrentSession();
	}

	/**
	 * 获取在该对象之上的Criteria实例对象
	 * 
	 * @return Criteria实例对象
	 */
	protected Criteria getBaseCriteria() {
		return getSession().createCriteria(persistentClass);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
		return getBaseCriteria().list();
	}

	public long getAllCount() {
		return ((Long) getBaseCriteria().setProjection(
				Projections.rowCount()).uniqueResult()).longValue();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllPage(int start, int limit) {
		Criteria criteria = getBaseCriteria();
		CriteriaImpl impl = (CriteriaImpl) criteria;
		Projection projection = impl.getProjection();
		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		if (start > 0) {
			criteria.setFirstResult(start);
		}
		if (limit > 0) {
			criteria.setMaxResults(limit);
		}

		try {
			criteria.addOrder(Order.asc("id"));
		} catch (Exception e) {
		}
		return criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getAllPage(int start, int limit,List<Criterion> crilsit,List<Order> orders) {
		Criteria criteria = getBaseCriteria();
		CriteriaImpl impl = (CriteriaImpl) criteria;
		Projection projection = impl.getProjection();
		criteria.setProjection(projection);
		if (projection == null) {
			criteria.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
		}
		if (start > 0) {
			criteria.setFirstResult(start);
		}
		if (limit > 0) {
			criteria.setMaxResults(limit);
		}
		for (Order order : orders)
			criteria.addOrder(order);
		
		if (crilsit!=null)
			for (Criterion criterion : crilsit)
				criteria.add(criterion);
		return criteria.list();
	}
	
	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap) {
		return searchByPage(searchBean, start, limit, orderMap, true);
	}

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit) {
		return searchByPage(searchBean, start, limit, null, true);
	}

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, boolean needCount) {
		return searchByPage(searchBean, start, limit, null, needCount);
	}

	@SuppressWarnings("unchecked")
	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap, boolean needCount) {
		String hql = null;
		hql = " from "
				+ persistentClass.getName().substring(
						persistentClass.getName().lastIndexOf(".") + 1)
				+ " t where 1=1";
		List<Object> paramList = new ArrayList<Object>();
		String whereStr = searchBean != null ? searchBean.genWhereString("t",
				paramList) : "";
		StringBuilder orderStr = new StringBuilder();
		if (orderMap != null && orderMap.size() > 0) {
			orderStr.append(" order by ");
			boolean first = true;
			for (Entry<String, String> entry : orderMap.entrySet()) {
				if (first) {
					first = false;
				} else {
					orderStr.append(",");
				}
				orderStr.append(entry.getKey() + " " + entry.getValue());
			}
		}
		Long count = 0l;
		if (needCount) {
			count = count("select count(t) " + hql + whereStr,
					paramList.toArray());
		}
		List<T> result = (limit == -1) ? query(
				hql + whereStr + orderStr.toString(), paramList.toArray())
				: query(hql + whereStr + orderStr.toString(),
						paramList.toArray(), start, limit);
		return new PageList(result, count);
	}

	@SuppressWarnings("unchecked")
	public PageList<Object[]> searchByPage(BaseSearchBean searchBean,
			int start, int limit, Map<String, String> orderMap,
			boolean needCount, String fromTable) {
		String hql = null;
		if (StringUtil.isNullStr(fromTable)) {
			hql = " from "
					+ persistentClass.getName().substring(
							persistentClass.getName().lastIndexOf(".") + 1)
					+ " t where 1=1";
		} else {
			hql = " from " + fromTable + " where 1=1";
		}
		List<Object> paramList = new ArrayList<Object>();
		String whereStr = searchBean != null ? searchBean.genWhereString("t",
				paramList) : "";
		StringBuilder orderStr = new StringBuilder();
		if (orderMap != null && orderMap.size() > 0) {
			orderStr.append(" order by ");
			boolean first = true;
			for (Entry<String, String> entry : orderMap.entrySet()) {
				if (first) {
					first = false;
				} else {
					orderStr.append(",");
				}
				orderStr.append(entry.getKey() + " " + entry.getValue());
			}
		}
		Long count = 0l;
		if (needCount) {
			count = count("select count(t) " + hql + whereStr,
					paramList.toArray());
		}
		List<Object[]> result = (limit == -1) ? query(
				hql + whereStr + orderStr.toString(), paramList.toArray())
				: query(hql + whereStr + orderStr.toString(),
						paramList.toArray(), start, limit);
		return new PageList(result, count);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public List<T> getAllDistinct() {
		Collection result = new LinkedHashSet(getAll());
		return new ArrayList(result);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T get(PK id) {
		try {
			return (T) getSession().get(persistentClass, id);
		} catch (Exception e) {
			return null;
		}
		
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T load(PK id) {
		return (T) getSession().load(persistentClass, id);
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public boolean exists(PK id) {
		T entity = get(id);
		return entity != null;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	public T save(T object) {
		return (T) getSession().merge(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(T object) {
		getSession().delete(object);
	}

	// 要求传入的hql必须是select count(*) from xxx的形式,这样uniqueResult才能正确返回
	public long count(String hql) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		long ret = ((Long) query.uniqueResult()).longValue();
		return ret;
	}

	public long count(String hql, Object param) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setParameter(0, param);
		long ret = ((Long) query.uniqueResult()).longValue();
		return ret;
	}

	// 同count(String hql)
	public long count(String hql, Object[] parms) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (parms != null) {
			for (int i = 0; i < parms.length; i++) {
				query.setParameter(i, parms[i]);
			}
		}
		Long ret = 0l;
//		if (query.uniqueResult() != null) {
//			ret = ((Long) query.uniqueResult()).longValue();
//		}
		//hgm20140504修改 上面的方法会进行2次count
		Object obj = query.uniqueResult();
		if (obj != null) {
			ret = ((Long) obj).longValue();
		}
		
		return ret;
	}

	public List query(String hql) {
		return getSession().createQuery(hql).list();
	}

	/*
	 * 分页的方式查询方式，总数要用count函数获取,查count时请去掉排序字段，这样可以快一些
	 * hql中自己拼装自带排序字段，Query不能根据PageInfo添加 下三个query函数同
	 */
	public List query(String hql, int start, int limit) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		query.setFirstResult(start > 0 ? start : 0);
		query.setMaxResults(limit > 0 && limit < Constants.QUERY_PAGE_MAX_SIZE ? limit
				: Constants.QUERY_PAGE_MAX_SIZE);
		List ls = query.list();
		return ls;
	}

	public List querySql(String sql, Object[] parms,int start, int limit, Class clazz) {
		Session session = getSession();
		session.clear();
		Query query = session.createSQLQuery(sql).setResultTransformer(
				Transformers.aliasToBean(clazz));
		if (parms != null) {
			for (int i = 0; i < parms.length; i++) {
				query.setParameter(i, parms[i]);
			}
		}
		query.setFirstResult(start > 0 ? start : 0);
		query.setMaxResults(limit > 0 && limit < Constants.QUERY_PAGE_MAX_SIZE ? limit
				: Constants.QUERY_PAGE_MAX_SIZE);
		List ls = query.list();
		return ls;
	}

	public List query(String hql, Object[] parms) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (parms != null) {
			for (int i = 0; i < parms.length; i++) {
				query.setParameter(i, parms[i]);
			}
		}
		List ls = query.list();
		return ls;
	}

	public List query(String hql, Object[] parms, int start, int limit) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (parms != null) {
			for (int i = 0; i < parms.length; i++) {
				query.setParameter(i, parms[i]);
			}
		}
		query.setFirstResult(start > 0 ? start : 0);
		query.setMaxResults(limit > 0 && limit < Constants.QUERY_PAGE_MAX_SIZE ? limit
				: Constants.QUERY_PAGE_MAX_SIZE);
		List ls = query.list();
		return ls;
	}

	// execute native sql

	public List querySql(String sql) {
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		List ls = query.list();
		return ls;
	}

	public List querySql(String sql, int start, int limit) {
		Session session = getSession();
		session.clear();
		Query query = session.createSQLQuery(sql);
		query.setFirstResult(start > 0 ? start : 0);
		query.setMaxResults(limit > 0 && limit < Constants.QUERY_PAGE_MAX_SIZE ? limit
				: Constants.QUERY_PAGE_MAX_SIZE);
		List ls = query.list();
		return ls;
	}

	public boolean executeSql(String sql) {
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		boolean ret = query.executeUpdate() > 0 ? true : false;
		return ret;
	}

	public Long countSql(String sql) {
		Session session = getSession();
		session.clear();
		Query query = session.createSQLQuery(sql);
		Long ret = ((java.math.BigDecimal) query.uniqueResult()).longValue();
		return ret;

	}

	public Long countSql(String sql, Object[] parms) {
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		for (int i = 0; i < parms.length; i++) {
			query.setParameter(i, parms[i]);
		}
		Long ret = ((BigInteger) query.uniqueResult()).longValue();
		return ret;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> querySql2Map(String sql) {
		// Session session = getSession();
		Session session = getSession();
		Query query = session.createSQLQuery(sql).setResultTransformer(
				Transformers.ALIAS_TO_ENTITY_MAP);
		List ls = query.list();
		Map<String, Object> map = (ls != null && ls.size() > 0) ? (Map) ls
				.get(0) : null;

		// model中的类型和sql查询出来的可能有一些不一致,需要手工修改.
		if (map != null) {
			for (Map.Entry entry : map.entrySet()) {
				if (entry.getValue() instanceof java.sql.Clob) {
					Clob clob = (Clob) entry.getValue();
					try {
						Reader reader = clob.getCharacterStream();
						if (reader != null) {
							StringBuffer sb = new StringBuffer();
							char[] charbuf = new char[4096];
							for (int i = reader.read(charbuf); i > 0; i = reader
									.read(charbuf)) {
								sb.append(charbuf, 0, i);
							}
							map.put((String) entry.getKey(), sb.toString());
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				} else if (entry.getValue() instanceof java.sql.Timestamp) {
					java.sql.Timestamp time = (java.sql.Timestamp) entry
							.getValue();
					map.put((String) entry.getKey(),
							new java.util.Date(time.getTime()));

				} else if (entry.getValue() instanceof BigDecimal) {

					BigDecimal decimal = (BigDecimal) entry.getValue();
					map.put((String) entry.getKey(), decimal.longValue());
				}
			}
		}
		session.close();
		// releaseSession(session);
		return map;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> querySql2Listmap(String sql) {
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql).setResultTransformer(
				Transformers.ALIAS_TO_ENTITY_MAP); // list里面是map
		List<Map<String, Object>> maps = query.list();
		for (Map<String, Object> map : maps) {
			for (Map.Entry entry : map.entrySet()) {
				if (entry.getValue() instanceof java.sql.Clob) {
					Clob clob = (Clob) entry.getValue();
					try {
						Reader reader = clob.getCharacterStream();
						if (reader != null) {
							StringBuffer sb = new StringBuffer();
							char[] charbuf = new char[4096];
							for (int i = reader.read(charbuf); i > 0; i = reader
									.read(charbuf)) {
								sb.append(charbuf, 0, i);
							}
							map.put((String) entry.getKey(), sb.toString());
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				} else if (entry.getValue() instanceof java.sql.Timestamp) {
					java.sql.Timestamp time = (java.sql.Timestamp) entry
							.getValue();
					map.put((String) entry.getKey(),
							new java.util.Date(time.getTime()));
				} else if (entry.getValue() instanceof BigDecimal) {

					BigDecimal decimal = (BigDecimal) entry.getValue();
					map.put((String) entry.getKey(), decimal.longValue());
				}
			}
		}
		return maps;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> querySql2Listmap(String sql, Object[] parms) {
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql).setResultTransformer(
				Transformers.ALIAS_TO_ENTITY_MAP); // list里面是map
		for (int i = 0; i < parms.length; i++) {
			query.setParameter(i, parms[i]);
		}
		List<Map<String, Object>> maps = query.list();
		for (Map<String, Object> map : maps) {
			for (Map.Entry entry : map.entrySet()) {
				if (entry.getValue() instanceof java.sql.Clob) {
					Clob clob = (Clob) entry.getValue();
					try {
						Reader reader = clob.getCharacterStream();
						if (reader != null) {
							StringBuffer sb = new StringBuffer();
							char[] charbuf = new char[4096];
							for (int i = reader.read(charbuf); i > 0; i = reader
									.read(charbuf)) {
								sb.append(charbuf, 0, i);
							}
							map.put((String) entry.getKey(), sb.toString());
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				} else if (entry.getValue() instanceof java.sql.Timestamp) {
					java.sql.Timestamp time = (java.sql.Timestamp) entry
							.getValue();
					map.put((String) entry.getKey(),
							new java.util.Date(time.getTime()));
				} else if (entry.getValue() instanceof BigDecimal) {

					BigDecimal decimal = (BigDecimal) entry.getValue();
					map.put((String) entry.getKey(), decimal.longValue());
				}
			}
		}
		return maps;
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> querySql2Listmap(String sql,
			Object[] parms, int start, int limit) {
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql).setResultTransformer(
				Transformers.ALIAS_TO_ENTITY_MAP); // list里面是map
		for (int i = 0; i < parms.length; i++) {
			query.setParameter(i, parms[i]);
		}
		query.setFirstResult(start > 0 ? start : 0);
		query.setMaxResults(limit > 0 && limit < Constants.QUERY_PAGE_MAX_SIZE ? limit
				: Constants.QUERY_PAGE_MAX_SIZE);

		List<Map<String, Object>> maps = query.list();
		for (Map<String, Object> map : maps) {
			for (Map.Entry entry : map.entrySet()) {
				if (entry.getValue() instanceof java.sql.Clob) {
					Clob clob = (Clob) entry.getValue();
					try {
						Reader reader = clob.getCharacterStream();
						if (reader != null) {
							StringBuffer sb = new StringBuffer();
							char[] charbuf = new char[4096];
							for (int i = reader.read(charbuf); i > 0; i = reader
									.read(charbuf)) {
								sb.append(charbuf, 0, i);
							}
							map.put((String) entry.getKey(), sb.toString());
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				} else if (entry.getValue() instanceof java.sql.Timestamp) {
					java.sql.Timestamp time = (java.sql.Timestamp) entry
							.getValue();
					map.put((String) entry.getKey(),
							new java.util.Date(time.getTime()));
				} else if (entry.getValue() instanceof BigDecimal) {

					BigDecimal decimal = (BigDecimal) entry.getValue();
					map.put((String) entry.getKey(), decimal.longValue());
				}
			}
		}
		return maps;
	}

	public List<Map<String, Object>> querySql2Listmap(Query query) {
		Session session = this.getSession();
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP); // list里面是map

		@SuppressWarnings("unchecked")
		List<Map<String, Object>> maps = query.list();
		for (Map<String, Object> map : maps) {
			for (Map.Entry entry : map.entrySet()) {
				if (entry.getValue() instanceof java.sql.Clob) {
					Clob clob = (Clob) entry.getValue();
					try {
						Reader reader = clob.getCharacterStream();
						if (reader != null) {
							StringBuffer sb = new StringBuffer();
							char[] charbuf = new char[4096];
							for (int i = reader.read(charbuf); i > 0; i = reader
									.read(charbuf)) {
								sb.append(charbuf, 0, i);
							}
							map.put((String) entry.getKey(), sb.toString());
						}
					} catch (Exception e) {
						log.error(e.getMessage());
					}
				} else if (entry.getValue() instanceof java.sql.Timestamp) {
					java.sql.Timestamp time = (java.sql.Timestamp) entry
							.getValue();
					map.put((String) entry.getKey(),
							new java.util.Date(time.getTime()));
				} else if (entry.getValue() instanceof BigDecimal) {

					BigDecimal decimal = (BigDecimal) entry.getValue();
					map.put((String) entry.getKey(), decimal.longValue());
				}
			}
		}
		return maps;
	}

	public List querySql(String sql, Object[] parms) {
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		for (int i = 0; i < parms.length; i++) {
			query.setParameter(i, parms[i]);
		}
		List ls = query.list();
		return ls;
	}

	public List querySql(String sql, Object[] parms, int start, int limit) {
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		for (int i = 0; i < parms.length; i++) {
			query.setParameter(i, parms[i]);
		}
		query.setFirstResult(start > 0 ? start : 0);
		query.setMaxResults(limit > 0 && limit < Constants.QUERY_PAGE_MAX_SIZE ? limit
				: Constants.QUERY_PAGE_MAX_SIZE);
		List ls = query.list();
		return ls;
	}

	public boolean executeSql(String sql, Object[] parms) {
		Session session = getSession();
		Query query = session.createSQLQuery(sql);
		for (int i = 0; i < parms.length; i++) {
			query.setParameter(i, parms[i]);
		}
		boolean ret = query.executeUpdate() > 0 ? true : false;
		return ret;
	}

	public void update(T object) {
		getSession().saveOrUpdate(object);
	}

	public void execute(String hql) {
		Session session = getSession();
		session.createQuery(hql).executeUpdate();
		session.flush();
	}

	public void execute(String hql, Object[] parms) {
		Session session = getSession();
		Query query = session.createQuery(hql);
		if (parms != null && parms.length > 0)
			for (int i = 0; i < parms.length; i++) {
				query.setParameter(i, parms[i]);
			}
		query.executeUpdate();
	}

	/**
	 * 以Batch的方式执行Hql 用List传入所有需要一次性执行的完整HQL语句，包括参数
	 * 
	 * @param hqls
	 * @param paramList
	 *            每个Hql对应的参数列表
	 * @param commitPerCount
	 *            指定每执行N条语句进行一次提交
	 * @throws SQLException
	 */
	public void excuteHqlBatch(String sessionFactoryName, List<String> hqls,
			List<Object[]> paramList, int commitPerCount) {
		if (null == hqls || hqls.size() < 1)
			return;
		SessionFactory sf = (SessionFactory) Constants.ctx
				.getBean(sessionFactoryName);
		Session session = null;
		try {
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			int commitInCount = commitPerCount;
			if (commitInCount == 0 || commitInCount > 1000)
				commitInCount = 100;// 默认100条提交一次
			for (int i = 0; i < hqls.size(); i++) {
				String hqlStr = hqls.get(i);
				Query query = session.createQuery(hqlStr);
				// 设置参数
				if (paramList.size() > i) {
					Object[] params = paramList.get(i);
					if (params != null && params.length > 0) {
						for (int j = 0; j < params.length; j++) {
							query.setParameter(j, params[j]);
						}
						query.executeUpdate();
					}
				}
				if (i % commitInCount == 0) {
					session.flush();
					session.clear();
				}
			}
			tx.commit();
		} catch (TransactionSystemException e) {
			log.error(e.getMessage() + "\n" + e.getStackTrace());
		} catch (Exception e) {
			log.error(e.getMessage() + "\n" + e.getStackTrace());
		}
	}

	/**
	 * 批量创建对象
	 * 
	 * @param modelList
	 * @param commitPerCount
	 *            指定每执行N条语句进行一次提交
	 */
	public List<T> batchInsert(String sessionFactoryName, List<T> modelList,
			int commitPerCount) {
		List<T> tModelLst = new ArrayList<T>();
		if (null == modelList || modelList.size() < 1)
			return null;
		int i = 0;
		int commitInCount = commitPerCount;
		if (commitInCount == 0 || commitInCount > 1000)
			commitInCount = 100;// 默认100条提交一次
		SessionFactory sf = (SessionFactory) Constants.ctx
				.getBean(sessionFactoryName);// "sessionFactory"
		Session session = null;
		try {
			session = sf.openSession();
			Transaction tx = session.beginTransaction();
			for (T model : modelList) {
				model = save(model);
				tModelLst.add(model);
				i++;
				if (i % commitInCount == 0) {
					session.flush();
					session.clear();
				}
			}
			session.flush();
			session.clear();
			tx.commit();
		} catch (TransactionSystemException e) {
			e.printStackTrace();
			log.error(e.getMessage() + "\n" + e.getStackTrace());
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage() + "\n" + e.getStackTrace());
		}
		return tModelLst;
	}

	/**
	 * 创建Session
	 * 
	 * @param newSession
	 *            true 新建session,false 取得当前的Session
	 * @return
	 */
	public Session makeSession(boolean newSession) {
		if (newSession) {
			return sessionFactory.openSession();
		} else {
			Session session = getSession();
			session.flush();
			return session;
		}
	}

	public void deleteAll(List<T> list) {
		for (T t : list) {
			getSession().delete(t);
		}
	}

	protected void setQueryParam(Map<String, Object> conditions,
			StringBuffer whereString, List<Object> params) {
		if (conditions == null) {
			return;
		}
		Set<Map.Entry<String, Object>> conditionSet = conditions.entrySet();
		for (Map.Entry<String, Object> condition : conditionSet) {
			String paramName = condition.getKey();
			Object paramValue = condition.getValue();
			if (StringUtils.isNotBlank(paramName) && paramValue != null) {
				if (paramValue instanceof String) {
					String value = paramValue.toString().trim();
					if (StringUtils.isNotBlank((String) paramValue)) {
						whereString.append(" and " + paramName + " like ? ");
						params.add("%" + value + "%");
					}
				} else if (paramValue instanceof Date) {
					if (paramName.endsWith("_beginTime")) {
						whereString.append(" and "
								+ paramName.replaceAll("_beginTime", "")
								+ " >= ?");
						params.add(TimeUtil.getBeginOfDay((Date) paramValue));
					} else if (paramName.endsWith("_endTime")) {
						whereString.append(" and "
								+ paramName.replaceAll("_endTime", "")
								+ " <= ?");
						params.add(TimeUtil.getEndOfDay((Date) paramValue));
					} else {
						whereString.append(" and " + paramName + " = ?");
						params.add(paramValue);
					}
				} else {
					whereString.append(" and " + paramName + " = ?");
					params.add(paramValue);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<T> getListByCondition(Map<String, Object> conditions) {
		String tableName = this.persistentClass.getSimpleName();

		StringBuffer queryString = new StringBuffer("from " + tableName);
		StringBuffer whereString = new StringBuffer(" where 1 = 1 ");
		List<Object> params = new ArrayList<Object>();

		setQueryParam(conditions, whereString, params);

		queryString.append(whereString.toString());
		Query query = getSession().createQuery(queryString.toString());
		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
		return query.list();
	}

	@SuppressWarnings("unchecked")
	public List<T> getListMatchingByCondition(Map<String, Object> conditions) {
		String tableName = persistentClass.getSimpleName();

		StringBuffer queryString = new StringBuffer("from " + tableName);
		StringBuffer whereString = new StringBuffer(" where 1 = 1 ");
		List<Object> params = new ArrayList<Object>();

		setQueryMatchingParam(conditions, whereString, params);

		queryString.append(whereString.toString());
		Query query = getSession().createQuery(queryString.toString());
		for (int i = 0; i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
		return query.list();
	}

	protected void setQueryMatchingParam(Map<String, Object> conditions,
			StringBuffer whereString, List<Object> params) {
		if (conditions == null) {
			return;
		}
		Set<Map.Entry<String, Object>> conditionSet = conditions.entrySet();
		for (Map.Entry<String, Object> condition : conditionSet) {
			String paramName = condition.getKey();
			Object paramValue = condition.getValue();
			if (StringUtils.isNotBlank(paramName) && paramValue != null) {
				if (paramValue instanceof String) {
					String value = paramValue.toString().trim();
					if (StringUtils.isNotBlank((String) paramValue)) {
						whereString.append(" and " + paramName + " = ? ");
						params.add(value);
					}
				} else if (paramValue instanceof Date) {
					if (paramName.endsWith("_beginTime")) {
						whereString.append(" and "
								+ paramName.replaceAll("_beginTime", "")
								+ "= ?");
						params.add(TimeUtil.getBeginOfDay((Date) paramValue));
					} else if (paramName.endsWith("_endTime")) {
						whereString
								.append(" and "
										+ paramName.replaceAll("_endTime", "")
										+ " = ?");
						params.add(TimeUtil.getEndOfDay((Date) paramValue));
					} else {
						whereString.append(" and " + paramName + " = ?");
						params.add(paramValue);
					}
				} else {
					whereString.append(" and " + paramName + " = ?");
					params.add(paramValue);
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public  ResultBean<Map<String,Object>> searchObject(ParamBean paramBean) {
		ResultBean<Map<String,Object>> resultBean = new ResultBean<Map<String,Object>>();
		List<Object> objList = new ArrayList<Object>();
		String whereStr = genWhereStr(paramBean, objList);
		
		String hql = " from " + persistentClass.getName().substring(
				persistentClass.getName().lastIndexOf(".") + 1) + "  t ";
		
		if (paramBean.getNeedCount()) {
			long total = this.count("select count(t) " + hql + whereStr, objList.toArray());
			resultBean.setTotal(total);
		}
		String queryString = paramBean.getQueryString();
		String[] fields =  queryString.split(",");
		queryString = "select " + queryString + " ";
		List<Object[]> lst = this.query(queryString  + 
				hql + whereStr + paramBean.getSortBean().getSortString(), objList.toArray(),
				paramBean.getStart(), paramBean.getLimit());
		Map<String,Object> mp = null;
		List<Map<String,Object>> resultSet = new ArrayList<Map<String,Object>>();
		for(Object[] obj:lst){
			mp = new HashMap<String,Object>();
			for(int i=0;i<obj.length;i++){
				mp.put(fields[i], obj[i]);
			}
			resultSet.add(mp);
		}
		resultBean.setReturnSet(resultSet);
		resultBean.setSuccess(true);
		resultBean.setMsg("加载成功");
		return resultBean;
	}
	
	@SuppressWarnings("unchecked")
	public  ResultBean<T> search(ParamBean paramBean) {
		ResultBean<T> resultBean = new ResultBean<T>();
		List<Object> objList = new ArrayList<Object>();
		String whereStr = genWhereStr(paramBean, objList);
		
		String hql = " from " + persistentClass.getName().substring(
				persistentClass.getName().lastIndexOf(".") + 1) + "  t ";
		
		if (paramBean.getNeedCount()) {
			long total = this.count("select count(t) " + hql + whereStr, objList.toArray());
			resultBean.setTotal(total);
		}
		List<T> lst = this.query(
				hql + whereStr + paramBean.getSortBean().getSortString(), objList.toArray(),
				paramBean.getStart(), paramBean.getLimit());
		resultBean.setReturnSet(lst);
		resultBean.setPage(paramBean.getPage());
		resultBean.setLimit(paramBean.getLimit());
		resultBean.setSuccess(true);
		resultBean.setMsg("加载成功");
		return resultBean;
	}
	public String genWhereStr(ParamBean paramBean, List<Object> objList){
		Object searchBean = paramBean.getSearchBean();
		if(searchBean instanceof BaseSearchBean){
			return ((BaseSearchBean)searchBean).genWhereString("t", objList);
		}
		return "";
	}
}
