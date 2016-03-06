package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.DonationDetail;
import com.Admin.bean.Poojebean;

public class DonationDataRowMapper implements RowMapper<DonationDetail> {

	@Override
	public DonationDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
		DonationDetail dbean = new DonationDetail();
		dbean.setDid(rs.getInt("Did"));
		dbean.setRecNO(rs.getInt("RecNo"));
		dbean.setName(rs.getString("Name"));
		dbean.setAddress(rs.getString("Address"));
		dbean.setAmount(rs.getDouble("Amount"));
		dbean.setMobileNO(rs.getString("mobile"));
		dbean.setEmail(rs.getString("email"));
		dbean.setBdate(rs.getTimestamp("BDate"));
		return dbean;

	}

}
