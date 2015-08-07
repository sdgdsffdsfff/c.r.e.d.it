package com.ctc.credit.qianhai.api.dto;

import java.util.List;

/**
 * 请求报文业务数据节点
 * @author sunny
 *
 */
public class BlkListRequestBusiData {

	/** 批次号 **/
	private String batchNo;
	
	private List<BlkListRequestBusiDataRecord> records;

	/**
	 * @return the batchNo
	 */
	public String getBatchNo() {
		return batchNo;
	}

	/**
	 * @param batchNo the batchNo to set
	 */
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	/**
	 * @return the records
	 */
	public List<BlkListRequestBusiDataRecord> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<BlkListRequestBusiDataRecord> records) {
		this.records = records;
	}
	
}