package com.ctc.credit.kernel.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

/**
 * Generic Manager that talks to GenericDao to CRUD POJOs.
 * 
 * <p>
 * Extend this interface if you want typesafe (no casting necessary) managers
 * for your domain objects.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 * @param <T>
 *            a type variable
 * @param <PK>
 *            the primary key for that type
 */
public interface GenericService<T, PK extends Serializable> {

	/**
	 * Generic method used to get all objects of a particular type. This is the
	 * same as lookup up all rows in a table.
	 * 
	 * @return List of populated objects
	 */

	List<T> getAll();

	List<T> getAllPage(int start, int limit);
	
	
	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap) ;

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit) ;

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, boolean needCount) ;

	public PageList<T> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap, boolean needCount);
	public PageList<Object[]> searchByPage(BaseSearchBean searchBean, int start,
			int limit, Map<String, String> orderMap, boolean needCount,String fromTable);

	long getAllCount();

	/**
	 * Generic method to get an object based on class and identifier. An
	 * ObjectRetrievalFailureException Runtime Exception is thrown if nothing is
	 * found.
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return a populated object
	 * @see org.springframework.orm.ObjectRetrievalFailureException
	 */

	T get(PK id);

	/**
	 * Checks for existence of an object of type T using the id arg.
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to get
	 * @return - true if it exists, false if it doesn't
	 */

	boolean exists(PK id);

	/**
	 * Generic method to save an object - handles both update and insert.
	 * 
	 * @param object
	 *            the object to save
	 * @return the updated object
	 */

	T save(T object);

	/**
	 * Generic method to delete an object based on class and id
	 * 
	 * @param id
	 *            the identifier (primary key) of the object to remove
	 */

	void remove(T object);
	
	/**
	 * 批量删除实体
	 * @param object
	 */
	void removes(List<T> object);

	/**
     * 
     */

	void update(T object);

	// sql的需要加"sql"

	public Long countSql(String sql);

	public Long countSql(String sql, Object[] parms);

	List querySql(String sql);

	List querySql(String sql, Object[] parms);

	List querySql(String sql, int start, int limit);

	boolean executeSql(String sql);

	boolean executeSql(String sql, Object[] parms);

	public Map<String, Object> querySql2Map(String sql);

	public List<Map<String, Object>> querySql2Listmap(String sql);

	// hql的不加"hql"

	long count(String hql);

	long count(String hql, Object[] parms);

	List query(String hql);

	List query(String hql, int start, int limit);

	List query(String hql, Object[] parms, int start, int limit);
	
	List query(String hql, Object[] parms);

	void execute(String hql);

	void execute(String hql, Object[] parms);

	/**
	 * 创建Session
	 * 
	 * @param newSession
	 *            true 新建session,false 取得当前的Session
	 * @return
	 */
	public Session getSession(boolean newSession);

	public void deleteAll(List<T> list);

	/**
	 * 完全匹配查询
	 * 
	 * @param conditions
	 * @return
	 */
	public List<T> getListMatchingByCondition(Map<String, Object> conditions);

	/**
	 * 根据条件查询实例列表
	 * 
	 * @param conditions
	 * @return
	 */
	public List<T> getListByCondition(Map<String, Object> conditions);
	
	/**
	 * 通用分页查询
	 * @param paramBean
	 * @return
	 */
	public ResultBean<T> search(ParamBean paramBean);
	
	/**
	 * 通用分页查询
	 * @param paramBean
	 * @return
	 */
	public  ResultBean<Map<String,Object>> searchObject(ParamBean paramBean);
}
