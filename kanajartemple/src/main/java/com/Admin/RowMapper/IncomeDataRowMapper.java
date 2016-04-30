package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.IncomeData;

public class IncomeDataRowMapper implements RowMapper<IncomeData> {

	@Override
	public IncomeData mapRow(ResultSet rs, int rowNum) throws SQLException {
		IncomeData income = new IncomeData();
		income.setRecNo(rs.getInt("RecNo"));
		income.setTitle(rs.getString("title"));
		income.setAmount(rs.getDouble("Amount"));
		income.setIid(rs.getInt("Iid"));
		income.setEdate(rs.getString("Edate"));
		income.setBdate(rs.getTimestamp("Bdate"));
		return income;
	}
}