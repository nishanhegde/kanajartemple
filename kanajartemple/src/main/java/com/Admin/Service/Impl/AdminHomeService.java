package com.Admin.Service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.CMSbean;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.dao.impl.AdminHomeDao;

@Service("adminHomeservice")
public class AdminHomeService {

	private static final Logger LOG = Logger.getLogger(AdminHomeService.class);

	@Autowired
	private AdminHomeDao adminHomeDao;

	@Autowired
	PoojeService poojeService;

	@Autowired
	PlatformTransactionManager transactionManager;

	public CMSbean getPageContent(String Pid) {
		return adminHomeDao.getPageContent(Pid);
	}

	public Integer updatePageContent(CMSbean cbean) {
		return adminHomeDao.updatePageContent(cbean);
	}

	public Integer addAdmin(RegistrationBean regbean) {
		return adminHomeDao.addAdmin(regbean);
	}

	public RegistrationBean getAdmin(String username) {
		return adminHomeDao.getAdmin(username);
	}

	public Integer updateAdmin(RegistrationBean rbean, String username) {
		return adminHomeDao.updateAdmin(rbean, username);
	}

	public Integer changePassword(ChangePassword cpbean, String username) {
		return adminHomeDao.changePassword(cpbean, username);
	}

	public String getPassword(String id) {
		return adminHomeDao.getPassword(id);
	}

	public Integer saveSashwathaPooje(SashwathaPoojebean sbean) {
		return adminHomeDao.saveSashwathaPooje(sbean);
	}

	public List<Map<String, Object>> getUserSashwathaPoojeDetails() {
		return adminHomeDao.getUserSashwathaPoojeDetails();
	}

	public SashwathaPoojebean getUserSashwathaPoojeDetails(String id) {
		return adminHomeDao.getUserSashwathaPoojeDetails(id);
	}

	public Integer deleteUserSashwathaPoojeDetails(String id) {
		return adminHomeDao.deleteUserSashwathaPoojeDetails(id);
	}

	public void approveUserSashwathaPoojeDetails(String id) {
		poojeService.updateSashwathaPooje(getUserSashwathaPoojeDetails(id));
		deleteUserSashwathaPoojeDetails(id);
	}
}
