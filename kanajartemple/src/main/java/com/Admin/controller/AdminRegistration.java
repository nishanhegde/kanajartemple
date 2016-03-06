package com.Admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.Admin.Service.Impl.AdminHomeService;
import com.Admin.bean.RegistrationBean;
import com.Admin.validator.RegistrationValidator;

@Controller
public class AdminRegistration  {
	
	@Autowired
	private AdminHomeService service;

	@Autowired
	private RegistrationValidator regValidator;
	
	@RequestMapping(value="/Registration",method = RequestMethod.GET)
	public String registration(ModelMap model){
 
	 RegistrationBean rbean = new RegistrationBean();
	
		model.addAttribute("Register", rbean);
 
		//return form view
		return "admin/AdminRegistration";
	}
	
	@RequestMapping(value="/RegistrationSuccess",method = RequestMethod.POST)
	public String  registrationSubmit(
		@ModelAttribute("Register") RegistrationBean rbean,
		BindingResult bindingResult,final Model model) {
		
		regValidator.validate(rbean, bindingResult);
		if (bindingResult.hasErrors())
		{
			model.addAttribute("Register",rbean);
			return "admin/AdminRegistration";
		}
		service.addAdmin(rbean);
		model.addAttribute("invalid","Thank you for registering.");
		return "admin/login";
	}
	
	
}
