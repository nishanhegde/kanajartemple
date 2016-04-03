package com.Admin.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.util.CollectionUtils;

import com.Admin.RowMapper.DonationDataRowMapper;
import com.Admin.RowMapper.DonationRowMapper;
import com.Admin.RowMapper.ExpenceDataRowMapper;
import com.Admin.RowMapper.ExpenseRowMapper;
import com.Admin.RowMapper.IncomeDataRowMapper;
import com.Admin.RowMapper.IncomeRowMapper;
import com.Admin.RowMapper.PoojeDataRowMapper;
import com.Admin.RowMapper.PoojeRowMapper;
import com.Admin.RowMapper.SashwathaPoojeRowMapper;
import com.Admin.bean.Donation;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.Expense;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.Income;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.dao.kanajarTempleMethodsDao;

@Component
public class kanajarTempleMethodsDaoImpl implements kanajarTempleMethodsDao {

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	DriverManagerDataSource dataSource;

	@Override
	public Pooje getPooje(String PoojeId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Poojeid", PoojeId);
		String str = "select * from pooje where pid=:Poojeid";
		return namedjdbc.queryForObject(str, param, new PoojeRowMapper());

	}

	@Override
	public List<Map<String, Object>> getPooje() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();

		String str = "select * from pooje where pid !=1 and Status='Active'";

		return namedjdbc.queryForList(str, param);
	}

	@Override
	public List<Map<String, Object>> getAllPooje() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();

		String str = "select * from pooje where Status='Active'";

		return namedjdbc.queryForList(str, param);
	}

	@Override
	public Poojebean getPoojeDataDetail(String RecNo, String PoojeId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Poojeid", PoojeId);
		param.put("RecNo", RecNo);
		String str = "select RecNo,Quantity,Name,Pid,DATE_FORMAT(PDate, '%d-%m-%Y') as PDate,BDate from allpoojedata where Pid=:Poojeid and RecNo=:RecNo";
		return namedjdbc.queryForObject(str, param, new PoojeDataRowMapper());
	}

	@Override
	public List<Map<String, Object>> getPoojeDataDetail(String PoojeId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Poojeid", PoojeId);
		String str = "select RecNo,Quantity,Name,Pid,DATE_FORMAT(PDate, '%d-%m-%Y') as PDate,BDate from allpoojedata where Pid=:Poojeid";
		return namedjdbc.queryForList(str, param);
	}

	@Override
	public List<Map<String, Object>> getSashwathaPooje() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		String str = "select * from sashwathapooje";
		return namedjdbc.queryForList(str, param);
	}

	@Override
	public SashwathaPoojebean getSashwathaPooje(String RecNo) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RecNo", RecNo);
		String str = "select * from sashwathapooje where RecNo=:RecNo";
		return namedjdbc.queryForObject(str, param, new SashwathaPoojeRowMapper());
	}

	@Override
	public Donation getDonation(String DonationId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("DonationId", DonationId);
		String str = "select * from donation where Did=:DonationId";
		return namedjdbc.queryForObject(str, param, new DonationRowMapper());
	}

	@Override
	public List<Map<String, Object>> getDonation() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();

		String str = "select * from donation where Status='Active'";
		return namedjdbc.queryForList(str, param);
	}

	@Override
	public DonationDetail getDonationDataDetail(String RecNo, String DonationId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("DonationId", DonationId);
		param.put("RecNo", RecNo);
		String str = "select * from alldonationdata where Did=:DonationId and RecNo=:RecNo";
		return namedjdbc.queryForObject(str, param, new DonationDataRowMapper());
	}

	@Override
	public List<Map<String, Object>> getDonationDataDetail(String DonationId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("DonationId", DonationId);

		String str = "select * from alldonationdata where Did=:DonationId";
		return namedjdbc.queryForList(str, param);
	}

	@Override
	public Expense getExpenditure(String Id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("ExpenseId", Id);
		String str = "select * from expenditure where Eid=:ExpenseId";
		return namedjdbc.queryForObject(str, param, new ExpenseRowMapper());
	}

	@Override
	public List<Map<String, Object>> getExpenditure() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		String str = "select * from expenditure where Status='Active'";
		return namedjdbc.queryForList(str, param);
	}

	@Override
	public ExpenseData getExpenditureData(String RecNo,String Id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RecNo", RecNo);
		param.put("Id", Id);
		String str = "select RecNo,Title,Description,Amount,DATE_FORMAT(EDate, '%d-%m-%Y') as EDate,BDate from allexpendituredata where RecNo=:RecNo and Eid=:Id";
		return namedjdbc.queryForObject(str, param, new ExpenceDataRowMapper());
	}

	@Override
	public List<Map<String, Object>> getExpenditureData(String expenseId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Eid", expenseId);
		String str = "select RecNo,Title,Description,Amount,DATE_FORMAT(EDate, '%d-%m-%Y') as EDate,BDate from allexpendituredata where Eid=:Eid";
		return namedjdbc.queryForList(str, param);
	}
	@Override
	public List<Map<String, Object>> getIncome() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();

		String str = "select * from income where Status='Active'";
		return namedjdbc.queryForList(str, param);

	}

	@Override
	public Income getIncome(String Id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("IncomeId", Id);
		String str = "select * from income where Iid=:IncomeId";
		return namedjdbc.queryForObject(str, param, new IncomeRowMapper());
	}

	@Override
	public IncomeData getIncomeData(String RecNo,String Id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RecNo", RecNo);
		param.put("Id", Id);
		String str = "select RecNo,title,Amount,DATE_FORMAT(Edate, '%d-%m-%Y') as Edate,Bdate from allincomedata where RecNo=:RecNo and Iid=:Id";
		return namedjdbc.queryForObject(str, param, new IncomeDataRowMapper());
	}

	@Override
	public List<Map<String, Object>> getIncomeData(String incomeId) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Id", incomeId);
		String str = "select RecNo,title,Amount,DATE_FORMAT(Edate, '%d-%m-%Y') as Edate,Bdate from income where=:Id";
		return namedjdbc.queryForList(str, param);
	}

	@Override
	public boolean checkEmailId(String emailid, String id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("emailid", emailid);
		param.put("id", id);
		String str = null;
		if (id == null) {
			str = "select * from register where EmailId=:emailid";
		} else {
			str = "select * from register where EmailId=:emailid and id!=:id";
		}

		if (CollectionUtils.isEmpty(namedjdbc.queryForList(str, param))) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkMobileNo(String mobileno, String id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("mobileno", mobileno);
		param.put("id", id);
		String str = null;
		if (id == null) {
			str = "select * from register where PhoneNumber=:mobileno";
		} else {
			str = "select * from register where PhoneNumber=:mobileno and id!=:id";
		}
		if (CollectionUtils.isEmpty(namedjdbc.queryForList(str, param))) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkCurrentPassword(String username, String currentpassword) {

		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("username", username);
		param.put("currentpassword", currentpassword);
		String str = "select * from register where Password=:currentpassword and (PhoneNumber=:username or EmailId=:username)";
		if (CollectionUtils.isEmpty(namedjdbc.queryForList(str, param))) {
			return false;
		} else {
			return true;
		}
	}

}