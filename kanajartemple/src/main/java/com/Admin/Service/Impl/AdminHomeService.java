package com.Admin.Service.Impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.bean.CMSbean;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.dao.impl.AdminHomeDao;

@Service("adminHomeservice")
public class AdminHomeService {
	
	@Autowired
	private AdminHomeDao adminHomeDao;

	
	
	public CMSbean getPageContent(String Pid)
	{
		return adminHomeDao.getPageContent(Pid);
	}

	public Integer updatePageContent(CMSbean cbean)
	{
		return adminHomeDao.updatePageContent(cbean);
	}
	
	
	
	public Integer addAdmin(RegistrationBean regbean)
	{
		return adminHomeDao.addAdmin(regbean);	
	}

	public RegistrationBean getAdmin(String username)
	{
		return adminHomeDao.getAdmin(username);
	}
	
	public Integer updateAdmin(RegistrationBean rbean,String username)
	{
		return adminHomeDao.updateAdmin(rbean,username);
	}
	
	public Integer changePassword(ChangePassword cpbean,String username)
	{
		return adminHomeDao.changePassword(cpbean,username);
	}
	
	public String getPassword(String id)
	{
		return adminHomeDao.getPassword(id);
	}
	
	public Integer saveSashwathaPooje(SashwathaPoojebean sbean)
	{
		return adminHomeDao.saveSashwathaPooje(sbean);
	}
}
