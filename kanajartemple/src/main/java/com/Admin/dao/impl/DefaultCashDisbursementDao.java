package com.Admin.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


import com.Admin.RowMapper.CashDisbursementRowMapper;

import com.Admin.bean.CashDisbursement;

import com.Admin.dao.CashDisbursementDao;


public class DefaultCashDisbursementDao implements CashDisbursementDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void save(CashDisbursement cashDisbursement) {
		Map<String, Object> param = getCashDisbursementParam(cashDisbursement);

		String sql = "insert into cashdisbursement(description,amount)" + "values(:description,:amount)";

		getNamedParameterJdbcTemplate().update(sql, param);

	}

	@Override
	public List<CashDisbursement> getCashDisbursement() {
	
		String str = "select * from cashdisbursement order by creation_date";
		return namedParameterJdbcTemplate.query(str, Collections.emptyMap(), new CashDisbursementRowMapper());
	}

	@Override
	public CashDisbursement getCashDisbursement(String id) {
		Map<String, Object> param = new HashMap<String, Object>(1);
		param.put("id", id);
		String str = "select * from cashdisbursement  where id=:id";
		return getNamedParameterJdbcTemplate().queryForObject(str,param, new CashDisbursementRowMapper());
	}

	@Override
	public Integer update(CashDisbursement cashDisbursement) {
		Map<String, Object> param = getCashDisbursementParam(cashDisbursement);
		param.put("id", cashDisbursement.getId());
		String sql = "update cashdisbursement set description=:description,amount=:amount"
				+ " where id=:id";

		return getNamedParameterJdbcTemplate().update(sql, param);
	}

	@Override
	public void delete(String id) {
		Map<String, Object> param = new HashMap<String, Object>(1);
		param.put("id", id);
		String sql = "delete from cashdisbursement where id=:id";

		getNamedParameterJdbcTemplate().update(sql, param);
	}

	private Map<String, Object> getCashDisbursementParam(CashDisbursement cashDisbursement) {
		Map<String, Object> param = new HashMap<String, Object>(2);
		param.put("description", cashDisbursement.getDescription().trim());
		param.put("amount", cashDisbursement.getAmount());
		return param;
	}

	protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Required
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

}
