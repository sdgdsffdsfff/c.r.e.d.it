package com.ctc.credit.kernel.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * This class serves as the Base class for all other Managers - namely to hold
 * common CRUD methods that they might all use. You should only need to extend
 * this class when your require custom CRUD logic.
 * 
 * <p>
 * To register this class in your Spring context file, use the following XML.
 * 
 * <pre>
 *     &lt;bean id="userManager" class="com.wondertek.mobiletv.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.wondertek.mobiletv.dao.hibernate.GenericDaoHibernate"&gt;
 *                 &lt;constructor-arg value="com.wondertek.mobiletv.model.User"/&gt;
 *                 &lt;property name="sessionFactory" ref="sessionFactory"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 * 
 * <p>
 * If you're using iBATIS instead of Hibernate, use:
 * 
 * <pre>
 *     &lt;bean id="userManager" class="com.wondertek.mobiletv.service.impl.GenericManagerImpl"&gt;
 *         &lt;constructor-arg&gt;
 *             &lt;bean class="com.wondertek.mobiletv.dao.ibatis.GenericDaoiBatis"&gt;
 *                 &lt;constructor-arg value="com.wondertek.mobiletv.model.User"/&gt;
 *                 &lt;property name="dataSource" ref="dataSource"/&gt;
 *                 &lt;property name="sqlMapClient" ref="sqlMapClient"/&gt;
 *             &lt;/bean&gt;
 *         &lt;/constructor-arg&gt;
 *     &lt;/bean&gt;
 * </pre>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
@Transactional
@Service
public class GenericServiceImpl<T, PK extends Serializable> implements
		GenericService<T, PK> {
	/**
	 * Log variable for all child classes. Uses LogFactory.getLog(getClass())
	 * from Commons Logging
	 */
	protected final Log log = LogFactory.getLog(getClass());

	/**
	 * GenericDao instance, set by constructor of this class
	 */
	@Resource(name="daoHibernate")
	protected GenericDao<T, PK> genericDao;

	public GenericServiceImpl() {
	}

	/**
	 * Public constructor for creating a new GenericManagerImpl.
	 * 
	 * @param genericDao
	 *            the GenericDao to use for persistence
	 */
	public GenericServiceImpl(final GenericDao<T, PK> genericDao) {
		this.genericDao = genericDao;
	}

	/**
	 * {@inheritDoc}
	 */
	public List<T> getAll() {
		return genericDao.getAll();
	}

	public List<T> getAllPage(int start, int limit) {
		return genericDao.getAllPage(start, limit);
	}

	public long getAllCount() {
		return genericDao.getAllCount();
	}
	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap){
		return genericDao.searchByPage(searchBean, start, limit, orderMap);
	}

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit){
		return genericDao.searchByPage(searchBean, start, limit);
	}

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, boolean needCount){
		return genericDao.searchByPage(searchBean, start, limit, needCount);
	}

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap, boolean needCount){
		return genericDao.searchByPage(searchBean, start, limit, orderMap, needCount);
	}
	public PageList<Object[]> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap, boolean needCount,String fromTable){
		return genericDao.searchByPage(searchBean, start, limit, orderMap, needCount,fromTable);
	}
	/**
	 * {@inheritDoc}
	 */
	public T get(PK id) {
		return genericDao.get(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean exists(PK id) {
		return genericDao.exists(id);
	}

	/**
	 * {@inheritDoc}
	 */
	public T save(T object) {
		return genericDao.save(object);
	}

	/**
	 * {@inheritDoc}
	 */
	public void remove(T object) {
		genericDao.remove(object);
	}
	
	/**
	 * {@inheritDoc}
	 */
	public void removes(List<T> object){
		for(T t:object){
			genericDao.remove(t);
		}
	}

	public void update(T object) {
		genericDao.update(object);
	}

	// sql的需要加"sql"
	public Long countSql(String sql) {
		return genericDao.countSql(sql);
	}

	public Long countSql(String sql, Object[] parms) {
		return genericDao.countSql(sql, parms);
	}

	public Map<String, Object> querySql2Map(String sql) {
		return genericDao.querySql2Map(sql);
	}

	public List<Map<String, Object>> querySql2Listmap(String sql) {
		return genericDao.querySql2Listmap(sql);
	}

	public List querySql(String sql) {
		return genericDao.querySql(sql);
	}

	public List querySql(String sql, Object[] parms) {
		return genericDao.querySql(sql, parms);
	}

	public List querySql(String sql, int start, int limit) {
		return genericDao.querySql(sql, start, limit);
	}

	public boolean executeSql(String sql) {
		return genericDao.executeSql(sql);
	}

	public boolean executeSql(String sql, Object[] parms) {
		return genericDao.executeSql(sql, parms);
	}

	// hql的不加"hql"
	public long count(String hql) {
		return genericDao.count(hql);
	}

	public long count(String hql, Object[] parms) {
		return genericDao.count(hql, parms);
	}

	public List query(String hql) {
		return genericDao.query(hql);
	}

	public List query(String hql, int start, int limit) {
		return genericDao.query(hql, start, limit);
	}

	public List query(String hql, Object[] parms, int start, int limit) {
		return genericDao.query(hql, parms, start, limit);
	}
	
	public List query(String hql, Object[] parms) {
		return genericDao.query(hql, parms);
	}

	public void execute(String hql) {
		genericDao.execute(hql);
	}

	public void execute(String hql, Object[] parms) {
		genericDao.execute(hql, parms);
	}

	/**
	 * 创建Session
	 * 
	 * @param newSession
	 *            true 新建session,false 取得当前的Session
	 * @return
	 */
	public Session getSession(boolean newSession) {
		return genericDao.makeSession(newSession);
	}

	public void deleteAll(List<T> list) {
		genericDao.deleteAll(list);
	}

	public List<T> getListMatchingByCondition(Map<String, Object> conditions) {
		return genericDao.getListMatchingByCondition(conditions);
	}

	public List<T> getListByCondition(Map<String, Object> conditions) {
		return genericDao.getListByCondition(conditions);
	}
	
	/**
	 * 通用分页查询
	 * @param paramBean
	 * @return
	 */
	public ResultBean<T> search(ParamBean paramBean){
		return genericDao.search(paramBean);
	}
	
	/**
	 * 通用分页查询
	 * @param paramBean
	 * @return
	 */
	public  ResultBean<Map<String,Object>> searchObject(ParamBean paramBean){
		return genericDao.searchObject(paramBean);
	}
}
