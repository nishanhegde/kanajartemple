package com.Brahmalingeshwara.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Brahmalingeshwara.Dao.HomeDao;
import com.Brahmalingeshwara.bean.SevaBookingBean;

@Service("HomeService")
public class HomeService {
	
	@Autowired
	HomeDao dao;
	
	
	public HomeDao getDao() {
		return dao;
	}


	public void setDao(HomeDao dao) {
		this.dao = dao;
	}


	public List getPageContent(String Pagename)
	{
		return dao.getPageContent(Pagename);
	}

	public Map getHomedetails()
	{
		return dao.getHomedetails();
	}
	
	public List getAddress()
	{
		return dao.getAddress();
	}
	
	public void insertseva(SevaBookingBean sbb)
	{
		dao.insertseva(sbb);
	}


}
