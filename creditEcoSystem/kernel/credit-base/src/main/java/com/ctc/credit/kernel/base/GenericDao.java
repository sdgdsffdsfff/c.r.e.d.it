package com.ctc.credit.kernel.base;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;




/**
 * Generic DAO (Data Access Object) with common methods to CRUD POJOs.
 *
 * <p>Extend this interface if you want typesafe (no casting necessary) DAO's for your
 * domain objects.
 *
 * @author <a href="mailto:bwnoll@gmail.com">Bryan Noll</a>
 * @param <T> a type variable
 * @param <PK> the primary key for that type
 */
public interface GenericDao <T, PK extends Serializable> {

    /**
     * Generic method used to get all objects of a particular type. This
     * is the same as lookup up all rows in a table.
     * @return List of populated objects
     */
    List<T> getAll();
    List<T> getAllPage(int start,int limit); 
    
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
     * ObjectRetrievalFailureException Runtime Exception is thrown if
     * nothing is found.
     *
     * @param id the identifier (primary key) of the object to get
     * @return a populated object
     * @see org.springframework.orm.ObjectRetrievalFailureException
     */
    T get(PK id);
    
    T load(PK id) ;

    /**
     * Checks for existence of an object of type T using the id arg.
     * @param id the id of the entity
     * @return - true if it exists, false if it doesn't
     */
    boolean exists(PK id);

    /**
     * Generic method to save an object - handles both update and insert.
     * @param object the object to save
     * @return the persisted object
     */
    T save(T object);

    /**
     * Generic method to delete an object based on class and id
     * @param id the identifier (primary key) of the object to remove
     */
    void remove(T object);
    
    /**
     * Gets all records without duplicates.
     * <p>Note that if you use this method, it is imperative that your model
     * classes correctly implement the hashcode/equals methods</p>
     * @return List of populated objects
     */
    /**
     * 
     */
    void update(T object);
    List<T> getAllDistinct();
    

    
    // sql的需要加"sql"
	public Long countSql(String sql);

	public Long countSql(String sql, Object[] parms);

	public List querySql(String sql);
	
	public List querySql(String sql, Object[] parms);
	
	public List querySql(String sql, Object[] parms, int start, int limit);
	
	public List querySql(String sql, int start, int limit);

	public boolean executeSql(String sql);

	public boolean executeSql(String sql, Object[] parms);

	public Map<String, Object> querySql2Map(String sql);
	
	public List<Map<String, Object>> querySql2Listmap(String sql);
	
	public List<Map<String, Object>> querySql2Listmap(String sql, Object[] parms);
	
	public List<Map<String, Object>> querySql2Listmap(Query query);
	
	public List<Map<String, Object>> querySql2Listmap(String sql, Object[] parms, int start, int limit);

	// hql的不加"hql"
	public long count(String hql);

	public long count(String hql, Object[] parms);

	public List query(String hql);

	public List query(String hql, int start, int limit);

	public List querySql(String sql, Object[] parms, int start, int limit, Class clazz);

	public List query(String hql, Object[] parms, int start, int limit);

//	PageList query(String hql, Object[] parms, PageInfo pageinfo);

	public void execute(String hql);

	public void execute(String hql, Object[] parms);
    
    
    /**
     * 以Batch的方式执行Hql
     * 用List传入所有需要一次性执行的完整HQL语句，包括参数
     * @param hqls
	 * @param paramList 每个Hql对应的参数列表
	 * @param commitPerCount 指定每执行N条语句进行一次提交
	 * @throws SQLException 
     */
	public void excuteHqlBatch(String sessionFactoryName, List<String> hqls,List<Object[]> paramList,int commitPerCount);
	
	/**
	 * 批量创建对象
	 * @param modelList
	 * @param commitPerCount 指定每执行N条语句进行一次提交
	 */ 
	public List<T> batchInsert(String sessionFactoryName, List<T> modelList,int commitPerCount);
   
	/**
	 * 创建Session
	 * @param newSession true 新建session,false 取得当前的Session
	 * @return
	 */
	public Session makeSession(boolean newSession);

	public void deleteAll(List<T> list);
	
	/**
	 * 完全匹配查询
	 * @param conditions
	 * @return
	 */
	public List<T> getListMatchingByCondition(Map<String, Object> conditions) ;
	
		/**
	 * 根据条件查询实例列表
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
	
	List query(String hql, Object[] parms);
}

