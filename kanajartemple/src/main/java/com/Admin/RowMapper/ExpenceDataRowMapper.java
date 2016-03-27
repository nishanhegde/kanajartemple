package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.ExpenseData;

public class ExpenceDataRowMapper implements RowMapper<ExpenseData> {

	@Override
	public ExpenseData mapRow(ResultSet rs, int rowNum) throws SQLException {
		ExpenseData expense =new ExpenseData();
		expense.setRecNo(rs.getInt("RecNo"));
		expense.setTitle(rs.getString("Title"));
		expense.setDescription(rs.getString("Description"));
		expense.setAmount(rs.getDouble("Amount"));
		expense.setEDate(rs.getString("EDate"));
		expense.setBDate(rs.getTimestamp("BDate"));
		return expense;
	}
}