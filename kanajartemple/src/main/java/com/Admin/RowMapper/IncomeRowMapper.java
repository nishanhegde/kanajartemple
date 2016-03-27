package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Donation;
import com.Admin.bean.Income;

public class IncomeRowMapper implements RowMapper<Income> {

	@Override
	public Income mapRow(ResultSet rs, int rowNum) throws SQLException {
		Income income=new Income();
		income.setIid(rs.getInt("Iid"));
		income.setIncomeName(rs.getString("IncomeName"));
		return income;
	}

}
