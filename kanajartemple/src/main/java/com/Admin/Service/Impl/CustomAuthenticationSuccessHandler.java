package com.Admin.Service.Impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.Admin.bean.RegistrationBean;

public class CustomAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private AdminHomeService adminHomeservice;

	public AdminHomeService getAdminHomeservice() {
		return adminHomeservice;
	}

	public void setAdminHomeservice(AdminHomeService adminHomeservice) {
		this.adminHomeservice = adminHomeservice;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String username = authentication.getName();
		HttpSession session = request.getSession();
		RegistrationBean rbean = adminHomeservice.getAdmin(username);
		session.setAttribute("Username", rbean.getEmailId());
		session.setAttribute("FullName", rbean.getFullName());
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
