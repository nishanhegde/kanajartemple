package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.BankAccount;
import com.Admin.bean.Donation;

public class BankAccountRowMapper implements RowMapper<BankAccount> {

	@Override
	public BankAccount mapRow(ResultSet rs, int rowNum) throws SQLException {
		BankAccount ba = new BankAccount();
		ba.setId(rs.getInt("id"));
		ba.setBankName(rs.getString("bankname"));
		ba.setAddress(rs.getString("address"));
		ba.setAccountNo(rs.getString("accountno"));
		ba.setIfscCode(rs.getString("ifsccode"));
		ba.setOpeningBalance(rs.getDouble("openingbalance"));
		return ba;
	}
}
