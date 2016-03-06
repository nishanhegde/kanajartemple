package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Donation;

public class DonationRowMapper implements RowMapper<Donation> {

	@Override
	public Donation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Donation donation =new Donation();
		donation.setDid(rs.getInt("Did"));
		donation.setDonationName(rs.getString("DonationName"));
		
		return donation;
	}

}
