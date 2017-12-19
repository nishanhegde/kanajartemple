package com.Admin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.Admin.RowMapper.BankAccountRowMapper;
import com.Admin.RowMapper.EmailRowMapper;
import com.Admin.bean.BankAccount;
import com.Admin.dao.BankAccountDao;
import com.Brahmalingeshwara.kanajartemple.Status;

public class DefaultBankAccountDao implements BankAccountDao {

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void save(BankAccount ba) {
		Map<String, Object> param = getBankAccountParam(ba);

		String sql = "insert into bankaccount(bankname,accountno,address,ifsccode)"
				+ "values(:bankname,:accountno,:address,:ifsccode)";

		namedParameterJdbcTemplate.update(sql, param);
	}

	private Map<String, Object> getBankAccountParam(BankAccount ba) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("bankname", ba.getBankName().trim());
		param.put("accountno", ba.getAccountNo().trim());
		param.put("address", ba.getAddress().trim());
		param.put("ifsccode", ba.getIfscCode().trim());
		return param;
	}

	@Override
	public List<BankAccount> getBankAccounts() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("status", Status.Active.toString());
		String str = "select * from bankaccount  where status=:status";
		return namedParameterJdbcTemplate.query(str, param, new BankAccountRowMapper());
	}

	@Override
	public BankAccount getBankAccount(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		String str = "select * from bankaccount  where id=:id";
		return namedParameterJdbcTemplate.queryForObject(str, param, new BankAccountRowMapper());
	}

	@Override
	public Integer update(BankAccount ba) {
		Map<String, Object> param = getBankAccountParam(ba);
		param.put("id", ba.getId());
		String sql = "update bankaccount set bankname=:bankname,accountno=:accountno,address=:address,ifsccode=:ifsccode"
				+ " where id=:id";

		return namedParameterJdbcTemplate.update(sql, param);
	}

	@Override
	public void delete(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("status", Status.Inactive.toString());
		param.put("id", id);
		String sql = "update bankaccount set status=:status where id=:id";

		namedParameterJdbcTemplate.update(sql, param);
	}
	
}
