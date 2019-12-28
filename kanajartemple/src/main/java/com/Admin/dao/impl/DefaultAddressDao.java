package com.Admin.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.Admin.RowMapper.AddressRowMapper;
import com.Admin.RowMapper.BankAccountRowMapper;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.Address;
import com.Admin.bean.BankAccount;
import com.Admin.dao.AddressDao;
import com.Brahmalingeshwara.kanajartemple.Status;

public class DefaultAddressDao implements AddressDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public void save(Address address) {
		Map<String, Object> param = getAddressParam(address);

		String sql = "insert into address(fullname,address,email,mobile)" + "values(:fullname,:address,:email,:mobile)";

		getNamedParameterJdbcTemplate().update(sql, param);

	}

	@Override
	public List<Address> getAddress() {
		Map<String, Object> param = new HashMap<String, Object>();
	
		String str = "select * from address order by creation_date";
		return namedParameterJdbcTemplate.query(str, param, new AddressRowMapper());
	}

	@Override
	public Address getAddress(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		String str = "select * from address  where id=:id";
		return getNamedParameterJdbcTemplate().queryForObject(str, param, new AddressRowMapper());
	}

	@Override
	public Integer update(Address address) {
		Map<String, Object> param = getAddressParam(address);
		param.put("id", address.getId());
		String sql = "update address set fullname=:fullname,address=:address,email=:email,mobile=:mobile"
				+ " where id=:id";

		return getNamedParameterJdbcTemplate().update(sql, param);
	}

	@Override
	public void delete(String id) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		String sql = "delete from address where id=:id";

		getNamedParameterJdbcTemplate().update(sql, param);
	}

	private Map<String, Object> getAddressParam(Address address) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("fullname", address.getFullname().trim());
		param.put("address", address.getAddress().trim());
		param.put("mobile", address.getEmail().trim());
		param.put("email", address.getEmail().trim());
		return param;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	@Required
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

}
