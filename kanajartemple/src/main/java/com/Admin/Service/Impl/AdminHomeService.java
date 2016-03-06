package com.Admin.Service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.bean.CMSbean;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.RegistrationBean;
import com.Admin.dao.impl.AdminHomeDao;

@Service("service")
public class AdminHomeService {
	
	@Autowired
	private AdminHomeDao dao;

	public AdminHomeDao getDao() {
		return dao;
	}

	public void setDao(AdminHomeDao dao) {
		this.dao = dao;
	}
	
	public List getPageContent(String Pagename)
	{
		return dao.getPageContent(Pagename);
	}

	public Integer updatePageContent(CMSbean cbean)
	{
		return dao.updatePageContent(cbean);
	}
	
	
	
	public Integer addAdmin(RegistrationBean regbean)
	{
		return dao.addAdmin(regbean);	
	}

	public RegistrationBean getAdmin(String username)
	{
		return dao.getAdmin(username);
	}
	
	public Integer updateAdmin(RegistrationBean rbean,String username)
	{
		return dao.updateAdmin(rbean,username);
	}
	
	public Integer changePassword(ChangePassword cpbean,String username)
	{
		return dao.changePassword(cpbean,username);
	}
	
	public String getPassword(String id)
	{
		return dao.getPassword(id);
	}
}
