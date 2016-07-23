package com.Admin.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.Admin.bean.CMSbean;
import com.Admin.bean.Donation;

public class CMSPageRowMapper implements RowMapper<CMSbean> {

	@Override
	public CMSbean mapRow(ResultSet rs, int rowNum) throws SQLException {
		CMSbean cmsPage =new CMSbean();
		cmsPage.setPid(rs.getInt("Pid"));
		cmsPage.setPagename(rs.getString("PageName"));
		cmsPage.setContent(rs.getString("Content"));		
		return cmsPage;
	}

}
