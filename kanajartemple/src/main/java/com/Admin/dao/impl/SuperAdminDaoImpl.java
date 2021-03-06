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
import com.Admin.bean.Expense;
import com.Admin.bean.Income;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.dao.SuperAdminDao;

@Component
public class SuperAdminDaoImpl implements SuperAdminDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public Integer CUDPooje(Pooje pbean, String code) {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pid", pbean.getPid());
		param.put("PoojeName", pbean.getPoojeName());
		param.put("Amount", pbean.getAmount());
		param.put("code", code);
		String sql = null;
		if (code.equalsIgnoreCase("insert")) {
			sql = "insert into pooje(PoojeName,Amount) values(:PoojeName,:Amount)";
		}
		if (code.equalsIgnoreCase("update")) {
			sql = "update pooje set PoojeName=:PoojeName,Amount=:Amount where pid=:pid";
		}

		if (code.equalsIgnoreCase("delete")) {
			sql = "update pooje set Status='Inactive' where pid=:pid";
		}
		return namedParameterJdbcTemplate.update(sql, param);

	}

	@Override
	public Integer CUDDonation(Donation dbean, String code) {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Did", dbean.getDid());
		param.put("DonationName", dbean.getDonationName());

		param.put("code", code);
		String sql = null;
		if (code.equalsIgnoreCase("insert")) {
			sql = "insert into donation(DonationName) values(:DonationName)";

		}
		if (code.equalsIgnoreCase("update")) {
			sql = "update donation set DonationName=:DonationName where Did=:Did";
		}

		if (code.equalsIgnoreCase("delete")) {
			sql = "update donation set Status='Inactive' where Did=:Did";
		}
		return namedParameterJdbcTemplate.update(sql, param);
	}

	@Override
	public List<Map<String, Object>> getAdmin() {
	
		Map<String, Object> param = new HashMap<String, Object>();

		String sql = "select * from register where Status='Inactive'";
		return namedParameterJdbcTemplate.queryForList(sql, param);

	}

	@Override
	public List<Map<String, Object>> getAdminToReject() {
	
		Map<String, Object> param = new HashMap<String, Object>();

		String sql = "select * from register where Status='Active'";
		return namedParameterJdbcTemplate.queryForList(sql, param);

	}

	@Override
	public Integer approveAdmin(String id) {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);

		String sql = "update register set Status='Active' where id=:id";

		return namedParameterJdbcTemplate.update(sql, param);

	}

	@Override
	public Integer deleteAdmin(String id) {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);

		String sql = "delete from register where id=:id";
		return namedParameterJdbcTemplate.update(sql, param);

	}

	@Override
	public Integer rejectAdmin(String id) {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		String sql = "update register set Status='Inactive' where id=:id";
		return namedParameterJdbcTemplate.update(sql, param);

	}

	@Override
	public Integer CUDIncome(Income ibean, String code) {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Iid", ibean.getIid());
		param.put("IncomeName", ibean.getIncomeName());
		param.put("code", code);
		String sql = null;
		if (code.equalsIgnoreCase("insert")) {
			sql = "insert into income(IncomeName) values(:IncomeName)";
		}
		if (code.equalsIgnoreCase("update")) {
			sql = "update income set IncomeName=:IncomeName where Iid=:Iid";
		}
		if (code.equalsIgnoreCase("delete")) {
			sql = "update income set Status='Inactive' where Iid=:Iid";
		}
		return namedParameterJdbcTemplate.update(sql, param);
	}

	@Override
	public Integer CUDExpense(Expense ebean, String code) {
	
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Eid", ebean.getEid());
		param.put("ExpenseName", ebean.getExpenseName());
		param.put("code", code);
		String sql = null;
		if (code.equalsIgnoreCase("insert")) {
			sql = "insert into expenditure(ExpenditureName) values(:ExpenseName)";
		}
		if (code.equalsIgnoreCase("update")) {
			sql = "update expenditure set ExpenditureName=:ExpenseName where Eid=:Eid";
		}
		if (code.equalsIgnoreCase("delete")) {
			sql = "update expenditure set Status='Inactive' where Eid=:Eid";
		}
		return namedParameterJdbcTemplate.update(sql, param);
	}

}
