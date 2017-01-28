package com.Brahmalingeshwara.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.Admin.bean.SashwathaPoojebean;
import com.Brahmalingeshwara.bean.SevaBookingBean;
import com.Brahmalingeshwara.kanajartemple.Utills;

@Component("homeDao")
public class HomeDao {

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public List getAddress() {

		Map param = new HashMap();
		String str = "select * from sashwathapooje";

		return namedParameterJdbcTemplate.queryForList(str, param);
	}

	public void insertseva(SevaBookingBean sbb) {
		Map param = new HashMap();

	}

	public Integer saveSashwathaPooje(SashwathaPoojebean sbean) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RecNo", sbean.getPid());
		param.put("Pid", sbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(sbean.getName()));
		param.put("PDate", sbean.getPdate());
		param.put("Address", Utills.replaceWhiteSpace(sbean.getAddress()));
		param.put("mobile", sbean.getMobileNo());
		param.put("email", sbean.getEmail());

		String str = "insert into UserSashwathaPooje(RecNo,Name,Address,PDate,BDate,MobileNo,Email) "
				+ "values(:RecNo,:Name,:Address,:PDate,(select now()),:mobile,:email)";

		return namedParameterJdbcTemplate.update(str, param);
	}

}
