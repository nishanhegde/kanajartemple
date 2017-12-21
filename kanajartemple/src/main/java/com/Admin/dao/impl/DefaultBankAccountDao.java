package com.Admin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.Admin.RowMapper.BankAccountEntryRowMapper;
import com.Admin.RowMapper.BankAccountRowMapper;
import com.Admin.RowMapper.EmailRowMapper;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.BankAccount;
import com.Admin.bean.BankAccountEntry;
import com.Admin.dao.BankAccountDao;
import com.Brahmalingeshwara.kanajartemple.Status;

public class DefaultBankAccountDao implements BankAccountDao {

	@Resource
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Resource
	private kanajarTempleMethods kanajarTempleMethods;

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

	@Override
	public void save(BankAccountEntry bae) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("bankaccount_id", bae.getBankAccountId());
		param.put("amount", bae.getAmount());
		param.put("type", bae.getType().toString());
		param.put("transaction", bae.getTransaction().toString());
		param.put("chequeorrefno", bae.getChequeOrRefNo().trim());
		param.put("description", bae.getDescription().trim());
		param.put("transaction_date", kanajarTempleMethods.getCustomDate(bae.getTransactionDate().trim()));

		String sql = "insert into bankaccountentry(bankaccount_id,bankaccountentry_id,amount,type,transaction,chequeorrefno,transaction_date,description)"
				+ " values(:bankaccount_id,(SELECT IFNULL(MAX(bae.bankaccountentry_id), 0) + 1 FROM bankaccountentry bae where bae.bankaccount_id=:bankaccount_id)"
				+ " ,:amount,:type,:transaction,:chequeorrefno,:transaction_date,:description)";

		namedParameterJdbcTemplate.update(sql, param);
	}

	@Override
	public List<BankAccountEntry> getBankAccountEntries(String bankId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("bankaccount_id", bankId);
		String str = "select * from bankaccountentry  where bankaccount_id=:bankaccount_id";
		return namedParameterJdbcTemplate.query(str, param, new BankAccountEntryRowMapper());
	}
	
	

}
