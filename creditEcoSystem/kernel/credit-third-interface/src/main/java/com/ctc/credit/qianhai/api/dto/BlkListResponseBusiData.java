package com.ctc.credit.qianhai.api.dto;

import java.util.List;

/**
 * 响应报文业务数据节点
 * @author sunny
 *
 */
public class BlkListResponseBusiData {

	/** 批次号 **/
	private String batchNo;
	
	private List<BlkListResponseBusiDataRecord> records;

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
	public List<BlkListResponseBusiDataRecord> getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(List<BlkListResponseBusiDataRecord> records) {
		this.records = records;
	}
	
}