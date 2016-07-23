package com.Brahmalingeshwara.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.Brahmalingeshwara.bean.SevaBookingBean;

@Component("dao")
public class HomeDao {
	
	@Autowired
	PlatformTransactionManager transactionManager;
	@Autowired
    DriverManagerDataSource dataSource;
    
	/*public PlatformTransactionManager getTransactionManager() {
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
	}*/
	
	public List getPageContent(String Pagename)
	{
		
		NamedParameterJdbcTemplate namedjdbc=new NamedParameterJdbcTemplate(dataSource);
		Map param=new HashMap();
		param.put("Pagename",Pagename);
		String str="select Content from admincms where PageName=:Pagename";
		
		return namedjdbc.queryForList(str, param);
		
		
	}
	
		
	public List getAddress()
	{
		NamedParameterJdbcTemplate namedjdbc=new NamedParameterJdbcTemplate(dataSource);
		Map param=new HashMap();
		String str="select * from sashwathapooje";
		
		return namedjdbc.queryForList(str, param);
	}
	
	public void insertseva(SevaBookingBean sbb)
	{
		NamedParameterJdbcTemplate namedjdbc=new NamedParameterJdbcTemplate(dataSource);
	       Map param=new HashMap();
	       
		   
	}



}
