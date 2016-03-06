package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Poojebean;

public class PoojeDataRowMapper implements RowMapper<Poojebean> {

	@Override
	public Poojebean mapRow(ResultSet rs, int rowNum) throws SQLException {
		Poojebean pbean = new Poojebean();
		pbean.setPid(rs.getInt("Pid"));
		pbean.setRecNo(rs.getInt("RecNo"));
		pbean.setQuantity(rs.getInt("Quantity"));
		pbean.setName(rs.getString("Name"));
		pbean.setPDate(rs.getString("PDate"));
		pbean.setBDate(rs.getTimestamp("BDate"));
		return pbean;

	}

}
