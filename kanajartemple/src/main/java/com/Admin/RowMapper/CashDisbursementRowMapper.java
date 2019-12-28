package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Address;
import com.Admin.bean.CashDisbursement;

public class CashDisbursementRowMapper implements RowMapper<CashDisbursement> {

	@Override
	public CashDisbursement mapRow(ResultSet rs, int rowNum) throws SQLException {
		CashDisbursement cashDisbursement =new CashDisbursement();
		cashDisbursement.setId(rs.getInt("id"));
		cashDisbursement.setDescription(rs.getString("description"));
		cashDisbursement.setAmount(rs.getDouble("amount"));
	
		cashDisbursement.setCreation_date(rs.getTimestamp("creation_date"));
		cashDisbursement.setModified_date(rs.getTimestamp("modified_date"));
		return cashDisbursement;
	}

}
