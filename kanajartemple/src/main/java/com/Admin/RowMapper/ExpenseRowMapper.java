package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Donation;
import com.Admin.bean.Expense;
import com.Admin.bean.Income;

public class ExpenseRowMapper implements RowMapper<Expense> {

	@Override
	public Expense mapRow(ResultSet rs, int rowNum) throws SQLException {
		Expense expense = new Expense();
		expense.setEid(rs.getInt("Eid"));
		expense.setExpenseName(rs.getString("ExpenditureName"));
		return expense;
	}

}
