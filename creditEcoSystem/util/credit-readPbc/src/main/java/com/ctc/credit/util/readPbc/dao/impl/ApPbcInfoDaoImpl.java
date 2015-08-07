package com.ctc.credit.util.readPbc.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.alibaba.druid.pool.DruidPooledConnection;
import com.ctc.credit.util.readPbc.dao.ApPbcInfoDao;

@Repository
public class ApPbcInfoDaoImpl implements ApPbcInfoDao {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Blob getApPbcInfo(String id) {
		// //异常 HTML 2d20362e-a63a-46f9-bbaa-f3660c289862
		// //正常HTML 5853f529-eeb3-4b60-a497-27fcf2892b47
		String sql = "SELECT CONTENT_ FROM BDF_BLOB_STORE where ID_ = ?";
		
		Connection conn = null;
		PreparedStatement prep = null;
		ResultSet rs = null;
		Blob result = null;
		try {
			conn = dataSource.getConnection();
			prep = conn.prepareStatement(sql);
			prep.setString(1, id);
			rs = prep.executeQuery();
			while (rs.next()) {
				result = rs.getBlob("CONTENT_");
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (prep != null) {
					prep.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		return result;
	}

	@Override
	public List<Map<String, Object>> getNeedAnalysisFiles() {
		String sql = "select source_id_ from AZHL_APPLY_TEL_RESULT_ where  source_type_ = 2 and has_wrdpbc_ is null";
		return jdbcTemplate.queryForList(sql);
	}

	@Override
	public void updateAnalysisLog(Map<String, Object> param) {
		String sql = "insert into PBC_ANALYSIS_LOG values(sys_guid(),?,?,?,?)";
		jdbcTemplate.update(sql, param.get("source_id"), param.get("parth"),
				param.get("analysis_result"), param.get("source_type"));
	}
}
