package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.Donation;
import com.Admin.bean.RegistrationBean;

public class RegisterRowMapper implements RowMapper<RegistrationBean> {

	@Override
	public RegistrationBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistrationBean rbean =new RegistrationBean();
		rbean.setId(rs.getInt("id"));
		rbean.setFullName(rs.getString("FullName"));
		rbean.setEmailId(rs.getString("EmailId"));
		rbean.setPhoneNumber(rs.getString("PhoneNumber"));
		return rbean;
	}

}
