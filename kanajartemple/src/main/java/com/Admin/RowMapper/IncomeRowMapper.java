package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Income;

public class IncomeRowMapper implements RowMapper<Income> {

	@Override
	public Income mapRow(ResultSet rs, int rowNum) throws SQLException {
		Income income = new Income();
		income.setRecNo(rs.getInt("RecNo"));
		income.setTitle(rs.getString("title"));
		income.setAmount(rs.getDouble("Amount"));
		income.setEdate(rs.getString("Edate"));
		income.setBdate(rs.getTimestamp("Bdate"));
		return income;
	}
}