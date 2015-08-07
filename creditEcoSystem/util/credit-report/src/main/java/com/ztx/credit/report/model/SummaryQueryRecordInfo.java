package com.ztx.credit.report.model;

/**
 * 查询记录汇总
 * @author xucy
 *
 */
public class SummaryQueryRecordInfo {

	private Last1MonthQueryInstitution last1MonthQueryInstitution;
	private Last1MonthQuery last1MonthQuery;
	private Last2YearsQuery last2YearsQuery;

	public Last1MonthQueryInstitution getLast1MonthQueryInstitution() {
		return last1MonthQueryInstitution == null? new Last1MonthQueryInstitution() :last1MonthQueryInstitution;
	}

	public void setLast1MonthQueryInstitution(
			Last1MonthQueryInstitution last1MonthQueryInstitution) {
		this.last1MonthQueryInstitution = last1MonthQueryInstitution;
	}

	public Last1MonthQuery getLast1MonthQuery() {
		return last1MonthQuery == null ? new Last1MonthQuery():last1MonthQuery;
	}

	public void setLast1MonthQuery(Last1MonthQuery last1MonthQuery) {
		this.last1MonthQuery = last1MonthQuery;
	}

	public Last2YearsQuery getLast2YearsQuery() {
		return last2YearsQuery == null ? new Last2YearsQuery() : last2YearsQuery;
	}

	public void setLast2YearsQuery(Last2YearsQuery last2YearsQuery) {
		this.last2YearsQuery = last2YearsQuery;
	}

	@Override
	public String toString() {
		return "SummaryQueryRecordInfo [last1MonthQueryInstitution="
				+ last1MonthQueryInstitution + ", last1MonthQuery="
				+ last1MonthQuery + ", last2YearsQuery=" + last2YearsQuery
				+ "]";
	}

}
