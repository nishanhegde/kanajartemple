package com.Brahmalingeshwara.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.bean.SashwathaPoojebean;
import com.Brahmalingeshwara.Dao.HomeDao;
import com.Brahmalingeshwara.bean.SevaBookingBean;

@Service("homeService")
public class HomeService {
	
	@Autowired
	HomeDao homeDao;
	
	
	public void insertseva(SevaBookingBean sbb)
	{
		homeDao.insertseva(sbb);
	}


}
