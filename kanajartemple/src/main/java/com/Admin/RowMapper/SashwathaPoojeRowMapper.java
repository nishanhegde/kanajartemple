package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.DonationDetail;
import com.Admin.bean.Poojebean;
import com.Admin.bean.SashwathaPoojebean;

public class SashwathaPoojeRowMapper implements RowMapper<SashwathaPoojebean> {

	@Override
	public SashwathaPoojebean mapRow(ResultSet rs, int rowNum) throws SQLException {
		SashwathaPoojebean sbean = new SashwathaPoojebean();
		sbean.setPid(rs.getInt("Pid"));
		sbean.setRecNo(rs.getInt("RecNo"));
		sbean.setName(rs.getString("Name"));
		sbean.setAddress(rs.getString("Address"));
		sbean.setMobileNo(rs.getString("MobileNo"));
		sbean.setEmail(rs.getString("email"));
		sbean.setBdate(rs.getTimestamp("BDate"));
		sbean.setPdate(rs.getString("PDate"));
		return sbean;
	}

}
