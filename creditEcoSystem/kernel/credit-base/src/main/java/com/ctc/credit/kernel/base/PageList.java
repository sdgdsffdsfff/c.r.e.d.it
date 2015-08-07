/**  
 *  带总页数集合
 * <P>Title: </P>  
 * <P>Description: </P>  
 * <P>Copyright: Copyright (c) 2009-2015</P>  
 * <P>Company: 重庆乾元科技发展有限责任公司</P>  
 * @author SZQ  
 * @version 1.0  
 */
package com.ctc.credit.kernel.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @since 2007-12-6
 * @author pippo
 * @version $Id: PageList.java,v 1.1 2009/06/09 20:42:43 szq Exp $
 */
public class PageList<T > implements List<T>, Serializable {

	public static <T> PageList<T> emptyList() {
		List<T> emptyList = Collections.emptyList();
		return new PageList<T>(emptyList, 0L);
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 862753863113974863L;

	public PageList() {
		super();
	}

	/**
	 * @param dataList
	 * @param totalCount
	 */
	public PageList(List<T> dataList, Long totalCount) {
		super();
		this.dataList = dataList;
		this.totalCount = totalCount;
	}

	/**
	 * 查询结果数据集
	 */
	private List<T> dataList = new ArrayList<T>();

	/**
	 * 总页数
	 */
	private Long totalCount = 0L;

	/**
	 * @return the dataList
	 */
	public List<T> getDataList() {
		return this.dataList;
	}

	/**
	 * @param dataList
	 *            the dataList to set
	 */
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the totalCount
	 */
	public Long getTotalCount() {
		return this.totalCount;
	}

	/**
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotalCount(Long totalCount) {
		this.totalCount = totalCount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#add(java.lang.Object)
	 */
	public boolean add(T o) {
		return this.dataList.add(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#add(int, java.lang.Object)
	 */
	public void add(int index, T element) {
		this.dataList.add(index, element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#addAll(java.util.Collection)
	 */
	public boolean addAll(Collection<? extends T> c) {
		return this.dataList.addAll(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#addAll(int, java.util.Collection)
	 */
	public boolean addAll(int index, Collection<? extends T> c) {
		return this.dataList.addAll(index, c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#clear()
	 */
	public void clear() {
		this.dataList.clear();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#contains(java.lang.Object)
	 */
	public boolean contains(Object o) {
		return this.dataList.contains(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#containsAll(java.util.Collection)
	 */
	public boolean containsAll(Collection<?> c) {
		return this.dataList.containsAll(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#get(int)
	 */
	public T get(int index) {
		return this.dataList.get(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#indexOf(java.lang.Object)
	 */
	public int indexOf(Object o) {
		return this.dataList.indexOf(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#isEmpty()
	 */
	public boolean isEmpty() {
		return this.dataList.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#iterator()
	 */
	public Iterator<T> iterator() {
		return this.dataList.iterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#lastIndexOf(java.lang.Object)
	 */
	public int lastIndexOf(Object o) {
		return this.dataList.lastIndexOf(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#listIterator()
	 */
	public ListIterator<T> listIterator() {
		return this.dataList.listIterator();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#listIterator(int)
	 */
	public ListIterator<T> listIterator(int index) {
		return this.dataList.listIterator(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#remove(java.lang.Object)
	 */
	public boolean remove(Object o) {
		return this.dataList.remove(o);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#remove(int)
	 */
	public T remove(int index) {
		return this.dataList.remove(index);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#removeAll(java.util.Collection)
	 */
	public boolean removeAll(Collection<?> c) {
		return this.dataList.removeAll(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#retainAll(java.util.Collection)
	 */
	public boolean retainAll(Collection<?> c) {
		return this.dataList.retainAll(c);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#set(int, java.lang.Object)
	 */
	public T set(int index, T element) {
		return this.dataList.set(index, element);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#size()
	 */
	public int size() {
		return this.dataList.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#subList(int, int)
	 */
	public List<T> subList(int fromIndex, int toIndex) {
		return this.dataList.subList(fromIndex, toIndex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#toArray()
	 */
	public Object[] toArray() {
		return this.dataList.toArray();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.List#toArray(T[])
	 */
	@SuppressWarnings("hiding")
	public <T> T[] toArray(T[] a) {
		return this.dataList.toArray(a);
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("PageList [totalCount=" + totalCount + ",dataList = ");
		for (T t : dataList) {
			str.append("\r\n" + t);
		}
		str.append("]");
		return str.toString();
	}

}
