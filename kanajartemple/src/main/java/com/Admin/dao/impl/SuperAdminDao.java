package com.Admin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.Admin.bean.Donation;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;

@Component("dao")
public class SuperAdminDao {

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	DriverManagerDataSource dataSource;


	public Integer CUDPooje(Pooje pbean, String code) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(
				dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pid", pbean.getPid());
		param.put("PoojeName", pbean.getPoojeName());
		param.put("Amount", pbean.getAmount());
		param.put("code", code);
		String sql = null;
		if (code.equalsIgnoreCase("insert")) {
			sql = "insert into pooje(PoojeName,Amount) values(:PoojeName,:Amount)";
		}
		if(code.equalsIgnoreCase("update")) {
			sql = "update pooje set PoojeName=:PoojeName,Amount=:Amount where pid=:pid";
		}
		
		if(code.equalsIgnoreCase("delete")){
			sql = "update pooje set Status='Inactive' where pid=:pid";
		}
		return namedjdbc.update(sql, param);

	}

	public Integer CUDDonation(Donation dbean, String code) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(
				dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Did", dbean.getDid());
		param.put("DonationName",dbean.getDonationName());

		param.put("code", code);
		String sql = null;
		if (code.equalsIgnoreCase("insert")) {
			sql = "insert into Donation(DonationName) values(:DonationName)";

		}
		if(code.equalsIgnoreCase("update")) {
			sql = "update donation set DonationName=:DonationName where Did=:Did";
		}
		
		if(code.equalsIgnoreCase("delete")){
			sql = "update donation set Status='Inactive' where Did=:Did";
		}

		return namedjdbc.update(sql, param);

	}
	
	public List<Map<String,Object>> getAdmin() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(
				dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		
		String sql ="select * from register where id != 1 and Status='Inactive'";
		return namedjdbc.queryForList(sql, param);

	}
	
	public List<Map<String,Object>> getAdminToReject() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(
				dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		
		String sql ="select * from register where id != 1 and Status='Active'";
		return namedjdbc.queryForList(sql, param);

	}
	
	public Integer approveAdmin(String id)
	{
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(
				dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		
		String sql = "update register set Status='Active' where id=:id";
		

		return namedjdbc.update(sql, param);

	}
	
	public Integer deleteAdmin(String id)
	{
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(
				dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		
		String sql = "delete from register where id=:id";
		return namedjdbc.update(sql, param);

	}
	
	public Integer rejectAdmin(String id)
	{
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(
				dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		String sql = "update register set Status='Inactive' where id=:id";
		return namedjdbc.update(sql, param);

	}

}
