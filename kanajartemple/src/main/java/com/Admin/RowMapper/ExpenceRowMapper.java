package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Expense;

public class ExpenceRowMapper implements RowMapper<Expense> {

	@Override
	public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
		Expense expense =new Expense();
		expense.setRecNo(rs.getInt("RecNo"));
		expense.setTitle(rs.getString("Title"));
		expense.setDescription(rs.getString("Description"));
		expense.setAmount(rs.getDouble("Amount"));
		expense.setEDate(rs.getString("EDate"));
		expense.setBDate(rs.getTimestamp("BDate"));
		return expense;
	}
}