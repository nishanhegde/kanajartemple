package com.Admin.dao.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.Admin.RowMapper.CMSPageRowMapper;
import com.Admin.RowMapper.PoojeRowMapper;
import com.Admin.RowMapper.RegisterRowMapper;
import com.Admin.RowMapper.SashwathaPoojeRowMapper;
import com.Admin.bean.CMSbean;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.SashwathaPoojebean;
import com.Brahmalingeshwara.kanajartemple.Utills;

@Component("adminHomeDao")
public class AdminHomeDao {

	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	DriverManagerDataSource dataSource;

	public PlatformTransactionManager getTransactionManager() {
		return transactionManager;
	}

	public void setTransactionManager(PlatformTransactionManager transactionManager) {
		this.transactionManager = transactionManager;
	}

	public DriverManagerDataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DriverManagerDataSource dataSource) {
		this.dataSource = dataSource;
	}

	public CMSbean getPageContent(String Pid) {

		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, String> param = new HashMap<String, String>();
		param.put("Pid", Pid);
		param.put("language", LocaleContextHolder.getLocale().toString());
		String str = "select * from admincms where Pid=:Pid and language=:language";
		return namedjdbc.queryForObject(str, param, new CMSPageRowMapper());

	}

	public Integer updatePageContent(CMSbean cbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, String> param = new HashMap<String, String>();
		param.put("Pid", cbean.getPid().toString());
		param.put("Content", cbean.getContent());
		param.put("language", LocaleContextHolder.getLocale().toString());
		String str = "update admincms set Content=:Content  where Pid=:Pid and language=:language";
		return namedjdbc.update(str, param);
	}

	public Integer addAdmin(RegistrationBean regbean) {

		Map<String, Object> param = new HashMap<String, Object>(2);
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		param.put("fullName", regbean.getFullName());

		param.put("password", regbean.getPassword());
		param.put("emailId", regbean.getEmailId());
		param.put("phoneNumber", regbean.getPhoneNumber());
		String sql = "insert into register(FullName,Password,EmailId,PhoneNumber) values(:fullName,:password,:emailId,:phoneNumber)";

		return namedjdbc.update(sql, param);

	}

	public RegistrationBean getAdmin(String username) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, String> param = new HashMap<String, String>();
		param.put("username", username);
		String str = "select id,EmailId,FullName,PhoneNumber from register where EmailId=:username";
		return namedjdbc.queryForObject(str, param, new RegisterRowMapper());
	}

	public Integer updateAdmin(RegistrationBean rbean, String username) {

		Map<String, Object> param = new HashMap<String, Object>(2);
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		param.put("fullName", rbean.getFullName());
		param.put("username", username);
		param.put("emailId", rbean.getEmailId());
		param.put("phoneNumber", rbean.getPhoneNumber());
		String sql = "update register set FullName=:fullName,EmailId=:emailId,PhoneNumber=:phoneNumber where EmailId=:username";

		return namedjdbc.update(sql, param);
	}

	public Integer changePassword(ChangePassword cpbean, String username) {
		Map<String, Object> param = new HashMap<String, Object>(2);
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		param.put("currentpassword", cpbean.getCurrentpassword());
		param.put("username", username);
		param.put("newpassword", cpbean.getNewpassword());
		String sql = "update register set Password=:newpassword where EmailId=:username and Password=:currentpassword";
		return namedjdbc.update(sql, param);
	}

	public String getPassword(String id) {
		Map<String, Object> param = new HashMap<String, Object>(2);
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		param.put("id", id);

		return namedjdbc.queryForObject("select Password  from register where EmailId=:id or PhoneNumber=:id", param,
				String.class);
	}

	@Transactional
	public Integer saveSashwathaPooje(SashwathaPoojebean sbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RecNo", sbean.getRecNo());
		param.put("Pid", sbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(sbean.getName()));
		param.put("PDate", sbean.getPdate());
		param.put("Address", Utills.replaceWhiteSpace(sbean.getAddress()));
		param.put("mobile", sbean.getMobileNo());
		param.put("email", sbean.getEmail());

		String str = "insert into UserSashwathaPooje(RecNo,Name,Address,PDate,BDate,MobileNo,Email) "
				+ "values(:RecNo,:Name,:Address,:PDate,(select now()),:mobile,:email)";

		return namedjdbc.update(str, param);
	}

	public List<Map<String, Object>> getUserSashwathaPoojeDetails() {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		String str = "select * from usersashwathapooje";
		return namedjdbc.queryForList(str, param);
	}

	public SashwathaPoojebean getUserSashwathaPoojeDetails(String id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);
		String str = "select * from usersashwathapooje where id=:id";
		return namedjdbc.queryForObject(str, param, new SashwathaPoojeRowMapper());
	}

	public Integer deleteUserSashwathaPoojeDetails(String id) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("id", id);

		String sql = "delete from usersashwathapooje where id=:id";
		return namedjdbc.update(sql, param);
	}

}
