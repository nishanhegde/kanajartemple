package com.Admin.Service.Impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.Admin.Service.EmailService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.CMSbean;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.controller.HomeController;
import com.Admin.dao.impl.AdminHomeDao;

@Service("adminHomeservice")
public class AdminHomeService {

	private static final Logger logger = Logger.getLogger(AdminHomeService.class);

	@Value("${email.query.to}")
	private String queryTo;

	@Value("${website.url}")
	private String website;

	@Autowired
	private AdminHomeDao adminHomeDao;

	@Autowired
	PoojeService poojeService;

	@Autowired
	private EmailService emailService;

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
		Integer result = adminHomeDao.saveSashwathaPooje(sbean);
		if (result == 1) {
			try {
				String lineBreak = System.getProperty("line.separator");
				StringBuilder body = new StringBuilder();
				body.append("Dear Admin,");
				body.append(lineBreak + lineBreak);
				body.append("There is a new request to approve the nithya pooje details.");
				body.append(lineBreak);
				body.append("Please follow the below link to approve  ");
				body.append(lineBreak);
				body.append(website + "/Admin/address");

				emailService.sendEmail(queryTo, sbean.getEmail(), "Request to update nithya pooje details",
						body.toString());
			} catch (Exception ex) {
				logger.error(ex);

			}
		}
		return result;

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
