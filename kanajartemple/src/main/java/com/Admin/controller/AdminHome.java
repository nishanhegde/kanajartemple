package com.Admin.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.Admin.Service.BankAccountService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.AdminHomeService;
import com.Admin.bean.CMSbean;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.Coupon;
import com.Admin.validator.ChangePasswordValidator;
import com.Admin.validator.EditProfileValidator;

@Controller
public class AdminHome {

	public static String REDIRECT_TO_APPROVE = "redirect:/Admin/address";

	@Autowired
	private AdminHomeService adminHomeservice;

	@Autowired
	private kanajarTempleMethods defaultTempleMethods;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private ChangePasswordValidator changePasswordValidator;

	@Autowired
	private EditProfileValidator editProfileValidator;
	
	@Resource
	private BankAccountService bankAccountService;

	@RequestMapping(value = "/login")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin/login");
		return mv;
	}

	@RequestMapping(value = "Admin/coupon", method = RequestMethod.GET)
	public String getCoupon(Model model) {
		model.addAttribute(new Coupon());
		return "admin/couponGenerator";
	}

	@RequestMapping(value = "Admin/coupon",method = RequestMethod.POST)
	public String setCoupon(@ModelAttribute Coupon coupon,Model model) {
		
		model.addAttribute("coupon",coupon);
		return "admin/Coupon";
	}

	@RequestMapping(value = "/failure")
	public ModelAndView failure(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		ModelAndView mv = new ModelAndView("admin/login");

		mv.addObject("invalid", messageSource.getMessage("label.failure", null, locale));
		return mv;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		HttpSession session = request.getSession();
		session.invalidate();

		return new ModelAndView("admin/login");
	}

	@RequestMapping(value = "/A403")
	public ModelAndView A403(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin/A403");
		return mv;
	}

	@RequestMapping(value = "/404")
	public ModelAndView pageNotFound404() {
		ModelAndView mv = new ModelAndView("admin/404");
		return mv;
	}

	@RequestMapping(value = "/Admin/home")
	public ModelAndView Adminhome(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin/Adminhome");

		List<?> PoojeDetails = defaultTempleMethods.getPooje();
		mv.addObject("PoojeDetails", PoojeDetails);
		mv.addObject("DonationDetails", defaultTempleMethods.getDonation());
		mv.addObject("IncomeDetails", defaultTempleMethods.getIncome());
		mv.addObject("ExpenseDetails", defaultTempleMethods.getExpenditure());
		mv.addObject("BankAccounts", bankAccountService.getBankAccounts());
		return mv;
	}

	@RequestMapping(value = "/Admin/EditProfile")
	public ModelAndView AdminEditProfile(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String username = (String) request.getSession().getAttribute("Username");

		ModelAndView mv = new ModelAndView("admin/EditProfile");
		mv.addObject("Data", adminHomeservice.getAdmin(username));
		mv.addObject("Register", new RegistrationBean());

		return mv;
	}

	@RequestMapping(value = "/Admin/EditProfileSuccess")
	public String AdminEditProfileSuccess(@ModelAttribute("Register") RegistrationBean rbean,
			HttpServletRequest request, HttpServletResponse response, Model model, BindingResult bindingResult,
			Locale locale) {
		editProfileValidator.validate(rbean, bindingResult);
		String username = getCurrentUser();
		if (bindingResult.hasErrors()) {
			model.addAttribute("Register", rbean);
		} else {
			Integer i = adminHomeservice.updateAdmin(rbean, username);

			if (i == 1) {
				invalidateSecuritySession();
				return AdminController.REDIRECTPREFIX + "/Admin/home";
			} else {
				model.addAttribute("message", messageSource.getMessage("message.error", null, locale));
				model.addAttribute("Register", new RegistrationBean());
			}
		}
		model.addAttribute("Data", adminHomeservice.getAdmin(username));
		return "admin/EditProfile";
	}

	@RequestMapping(value = "Admin/ChangePassword")
	public ModelAndView ChangePassword(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/ChangePassword");
		mv.addObject(new ChangePassword());
		return mv;
	}

	@RequestMapping(value = "Admin/ChangePasswordSuccess")
	public String ChangePasswordSuccess(@ModelAttribute ChangePassword cpbean, HttpServletRequest request,
			HttpServletResponse response, BindingResult bindingResult, Locale locale, Model model) {

		changePasswordValidator.validate(cpbean, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute(cpbean);

		} else {
			Integer i = adminHomeservice.changePassword(cpbean, getCurrentUser());
			if (i == 1) {
				invalidateSecuritySession();
				return AdminController.REDIRECTPREFIX + "/Admin/home";
			} else {
				model.addAttribute("message", messageSource.getMessage("message.error", null, locale));
				model.addAttribute(new ChangePassword());

			}
		}
		return "admin/ChangePassword";
	}

	@RequestMapping(value = "/forgotpassword")
	public ModelAndView ForgotPassword(@RequestParam("id") String id, HttpServletRequest request,
			HttpServletResponse response, Locale locale) {
		ModelAndView mv = new ModelAndView("admin/login");
		String password = null;
		if (id != null) {
			password = adminHomeservice.getPassword(id);
			if (password != null) {
				mv.addObject("invalid", "Password:" + password);
			} else {
				mv.addObject("invalid", messageSource.getMessage("message.invalid.field", null, locale));

			}
		}
		return mv;
	}

	private String getCurrentUser() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		return user.getUsername();
	}

	private void invalidateSecuritySession() {
		SecurityContextHolder.getContext().setAuthentication(null);
		SecurityContextHolder.clearContext();
	}
	
	@RequestMapping(value = "Admin/getemail")
	public ModelAndView getemail(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView mv = new ModelAndView("admin/getemail");
		mv.addObject("emails", defaultTempleMethods.getEmails());
		return mv;
	}
}
