package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Address;

public class AddressRowMapper implements RowMapper<Address> {

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address address =new Address();
		address.setId(rs.getInt("id"));
		address.setFullname(rs.getString("fullname"));
		address.setAddress(rs.getString("address"));
		address.setMobile(rs.getString("mobile"));
		address.setEmail(rs.getString("email"));
		address.setCreation_date(rs.getTimestamp("creation_date"));
		address.setModified_date(rs.getTimestamp("modified_date"));
		return address;
	}

}
