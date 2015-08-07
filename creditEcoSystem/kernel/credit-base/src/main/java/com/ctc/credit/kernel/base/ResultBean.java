package com.ctc.credit.kernel.base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * 业务执行结果对象
 * 
 * ResultBean
 * 
 * 
 * @version 1.0.0
 * 
 */
public class ResultBean<T> implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4329054640002077889L;
	private boolean success = false;// 执行结果
	private T returnObject;// 执行返回结果
	private List<T> returnSet;// 执行结果集
	private long total;// 结果集总数
	private int start;// 结果集索引开始位置
	private int limit = 50;// 结果集数量限制
	private String errorMessage;// 执行错误描述
	private String msg;// 描述信息
	private String[] msgList;// 描述信息集合
	private int page;//当前页码
	private int totalPage;
	private boolean hasNext = false; //是否有下一页
	

	public String[] getMsgList() {
		return msgList;
	}

	public ResultBean<T> setMsgList(String[] msgList) {
		this.msgList = msgList;
		return this;
	}

	public List<T> getReturnSet() {
		return returnSet;
	}
	
	/**
	 * 打印集合
	 * @return
	 */
	public void printReturnSet() {
		if(returnSet == null) return;
		for(T t:returnSet){
			System.out.println(t);
		}
	}

	public ResultBean<T> setReturnSet(List<T> returnSet) {
		this.returnSet = returnSet;
		return this;
	}

	public long getTotal() {
		return total;
	}

	public ResultBean<T> setTotal(long total) {
		this.total = total;
		return this;
	}

	public int getStart() {
		return start;
	}

	public ResultBean<T> setStart(int start) {
		this.start = start;
		return this;
	}

	public int getLimit() {
		return limit;
	}

	public ResultBean<T> setLimit(int limit) {
		this.limit = limit;
		return this;
	}

	public Object getReturnObject() {
		return returnObject;
	}

	public ResultBean<T> setReturnObject(T returnObject) {
		this.returnObject = returnObject;
		return this;
	}

	public boolean isSuccess() {
		return success;
	}

	public ResultBean<T> setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public ResultBean<T> setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResultBean<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPage() {
		return page;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalPage() {
		totalPage = (int) (total/limit);
		if(total%limit != 0){
			totalPage++;
		}
		return totalPage;
	}

	public void setHasNext(Boolean hasNext) {
		this.hasNext = hasNext;
	}

	public Boolean getHasNext() {
		return hasNext;
	}

	@Override
	public String toString() {
		return "ResultBean [success=" + success + ", returnObject="
				+ returnObject + ", returnSet=" + returnSet + ", total="
				+ total + ", start=" + start + ", limit=" + limit
				+ ", errorMessage=" + errorMessage + ", msg=" + msg
				+ ", msgList=" + Arrays.toString(msgList) + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorMessage == null) ? 0 : errorMessage.hashCode());
		result = prime * result + (hasNext ? 1231 : 1237);
		result = prime * result + limit;
		result = prime * result + ((msg == null) ? 0 : msg.hashCode());
		result = prime * result + Arrays.hashCode(msgList);
		result = prime * result + page;
		result = prime * result
				+ ((returnObject == null) ? 0 : returnObject.hashCode());
		result = prime * result
				+ ((returnSet == null) ? 0 : returnSet.hashCode());
		result = prime * result + start;
		result = prime * result + (success ? 1231 : 1237);
		result = prime * result + (int) (total ^ (total >>> 32));
		result = prime * result + totalPage;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultBean other = (ResultBean) obj;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		if (hasNext != other.hasNext)
			return false;
		if (limit != other.limit)
			return false;
		if (msg == null) {
			if (other.msg != null)
				return false;
		} else if (!msg.equals(other.msg))
			return false;
		if (!Arrays.equals(msgList, other.msgList))
			return false;
		if (page != other.page)
			return false;
		if (returnObject == null) {
			if (other.returnObject != null)
				return false;
		} else if (!returnObject.equals(other.returnObject))
			return false;
		if (returnSet == null) {
			if (other.returnSet != null)
				return false;
		} else if (!returnSet.equals(other.returnSet))
			return false;
		if (start != other.start)
			return false;
		if (success != other.success)
			return false;
		if (total != other.total)
			return false;
		if (totalPage != other.totalPage)
			return false;
		return true;
	}
	
	
}
