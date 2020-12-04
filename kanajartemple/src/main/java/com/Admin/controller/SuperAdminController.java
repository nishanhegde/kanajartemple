package com.Admin.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Admin.Service.SuperAdminService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.AdminHomeService;

import com.Admin.bean.CMSbean;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.Donation;
import com.Admin.bean.Expense;
import com.Admin.bean.Income;

import com.Admin.bean.Pooje;
import com.Admin.validator.ChangePasswordValidator;

@Controller
@RequestMapping(value = "/SuperAdmin")
public class SuperAdminController {

	public static String REDIRECT_TO_APPROVE = "redirect:/SuperAdmin/address";

	@Autowired
	private AdminHomeService adminHomeservice;
	@Autowired
	private SuperAdminService superAdminService;
	@Autowired
	private kanajarTempleMethods defaultTempleMethods;
	@Autowired
	private ChangePasswordValidator changePasswordValidator;
	@Autowired
	private MessageSource messageSource;

	@RequestMapping(value = "/CUDPooje")
	public ModelAndView SuperAdminCUDPooje(HttpServletRequest request, HttpServletResponse response, Pooje pbean)
			throws IOException {

		ModelAndView mv = new ModelAndView("admin/PoojeTemplate");
		mv.addObject("Poojedata", defaultTempleMethods.getAllPooje());
		return mv;
	}

	@RequestMapping(value = "/CUDPooje/{Code}")
	public String SuperAdminCUDPooje(@PathVariable("Code") String code, HttpServletRequest request,
			HttpServletResponse response, Pooje pbean) throws IOException {

		Integer a = superAdminService.CUDPooje(pbean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDPooje";
		}
		return null;

	}

	@RequestMapping(value = "/CUDPooje/{Code}/{Pid}")
	public String SuperAdminCUDPooje(@PathVariable("Code") String code, @PathVariable("Pid") String Pid,
			HttpServletRequest request, HttpServletResponse response, Pooje pbean) throws IOException {

		pbean.setPid(Integer.valueOf(Pid));
		Integer a = superAdminService.CUDPooje(pbean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDPooje";
		}
		return null;

	}

	@RequestMapping(value = "/CUDIncome")
	public ModelAndView SuperAdminAddIncome(HttpServletRequest request, HttpServletResponse response, Donation dbean)
			throws IOException {

		ModelAndView mv = new ModelAndView("admin/IncomeTemplate");
		mv.addObject("Income", defaultTempleMethods.getIncome());
		return mv;
	}

	@RequestMapping(value = "/CUDIncome/{Code}")
	public String SuperAdminAddIncome(@PathVariable("Code") String code, HttpServletRequest request,
			HttpServletResponse response, Income ibean) throws IOException {
		Integer a = superAdminService.CUDIncome(ibean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDIncome";
		}
		return null;
	}

	@RequestMapping(value = "/CUDIncome/{Code}/{Iid}")
	public String SuperAdminAddIncome(@PathVariable("Code") String code, @PathVariable("Iid") String Iid,
			HttpServletRequest request, HttpServletResponse response, Income ibean) throws IOException {

		ibean.setIid(Integer.parseInt(Iid));
		Integer a = superAdminService.CUDIncome(ibean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDIncome";
		}
		return null;
	}

	@RequestMapping(value = "/CUDExpenditure")
	public ModelAndView SuperAdminAddExpenditure(HttpServletRequest request, HttpServletResponse response,
			Donation dbean) throws IOException {

		ModelAndView mv = new ModelAndView("admin/ExpenditureTemplate");
		mv.addObject("Expenditure", defaultTempleMethods.getExpenditure());
		return mv;
	}

	@RequestMapping(value = "/CUDExpenditure/{Code}")
	public String SuperAdminAddExpenditure(@PathVariable("Code") String code, HttpServletRequest request,
			HttpServletResponse response, Expense ebean) throws IOException {
		Integer a = superAdminService.CUDExpense(ebean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDExpenditure";
		}
		return null;
	}

	@RequestMapping(value = "/CUDExpenditure/{Code}/{Eid}")
	public String SuperAdminAddExpenditure(@PathVariable("Code") String code, @PathVariable("Eid") String Eid,
			HttpServletRequest request, HttpServletResponse response, Expense ebean) throws IOException {

		ebean.setEid(Integer.parseInt(Eid));
		Integer a = superAdminService.CUDExpense(ebean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDExpenditure";
		}
		return null;
	}

	@RequestMapping(value = "/CUDDonation")
	public ModelAndView SuperAdminAddDonation(HttpServletRequest request, HttpServletResponse response, Donation dbean)
			throws IOException {

		ModelAndView mv = new ModelAndView("admin/DonationTemplate");
		mv.addObject("Poojedata", defaultTempleMethods.getDonation());
		return mv;
	}

	@RequestMapping(value = "/CUDDonation/{Code}")
	public String SuperAdminAddDonation(@PathVariable("Code") String code, HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {
		Integer a = superAdminService.CUDDonation(dbean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDDonation";
		}
		return null;
	}

	@RequestMapping(value = "/CUDDonation/{Code}/{Did}")
	public String SuperAdminAddDonation(@PathVariable("Code") String code, @PathVariable("Did") String Did,
			HttpServletRequest request, HttpServletResponse response, Donation dbean) throws IOException {

		dbean.setDid(Integer.parseInt(Did));
		Integer a = superAdminService.CUDDonation(dbean, code);
		if (a != null) {
			return AdminController.REDIRECTPREFIX + "/SuperAdmin/CUDDonation";
		}
		return null;
	}

	@RequestMapping(value = "/ApproveAdmin")
	public ModelAndView ApproveAdmin(HttpServletRequest request, HttpServletResponse response, Donation dbean)
			throws IOException {
		ModelAndView mv = new ModelAndView("admin/ApproveAdmin");
		mv.addObject("Admins", superAdminService.getAdmin());
		return mv;

	}

	@RequestMapping(value = "/RejectAdmin")
	public ModelAndView RejectAdmin(HttpServletRequest request, HttpServletResponse response, Donation dbean)
			throws IOException {
		ModelAndView mv = new ModelAndView("admin/RejectAdmin");
		mv.addObject("Admins", superAdminService.getAdminToReject());
		return mv;

	}

	@RequestMapping(value = "/Approve/{id}")
	public ModelAndView ApproveAdmin(@PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {

		Integer a = superAdminService.approveAdmin(id);
		ModelAndView mv = new ModelAndView("admin/ApproveAdmin");
		mv.addObject("Admins", superAdminService.getAdmin());
		return mv;
	}

	@RequestMapping(value = "/Reject/{id}")
	public ModelAndView RejectAdmin(@PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {

		Integer a = superAdminService.rejectAdmin(id);
		ModelAndView mv = new ModelAndView("admin/RejectAdmin");
		mv.addObject("Admins", superAdminService.getAdminToReject());
		return mv;
	}

	@RequestMapping(value = "/Delete/{id}")
	public ModelAndView DeleteAdmin(@PathVariable("id") String id, HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {

		Integer a = superAdminService.deleteAdmin(id);
		ModelAndView mv = new ModelAndView("admin/ApproveAdmin");
		mv.addObject("Admins", superAdminService.getAdmin());
		return mv;
	}

	@RequestMapping(value = "/CMS/{Pid}", method = RequestMethod.GET)
	public ModelAndView SuperAdminCMS(@PathVariable("Pid") String Pid, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("admin/AdminCMS");
		mv.addObject("CMScontent", adminHomeservice.getPageContent(Pid));
		return mv;
	}

	@RequestMapping(value = "/CMS/save", method = RequestMethod.POST)
	public String Admin_CMS_Success(HttpServletRequest request, HttpServletResponse response, CMSbean cbean)
			throws IOException {
		adminHomeservice.updatePageContent(cbean);
		response.sendRedirect("../CMS/" + cbean.getPid());
		return null;
	}

	@RequestMapping(value = "/kannadaeditor", method = RequestMethod.GET)
	public String CMSEditor(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return "admin/kannadaeditor";
	}


	@RequestMapping(value = "/address", method = RequestMethod.GET)
	public String getAddress(Model model) throws IOException {
		model.addAttribute("data", adminHomeservice.getUserSashwathaPoojeDetails());
		return "admin/UserSashwathapooje";
	}

	@RequestMapping(value = "/address/{id}", method = RequestMethod.GET)
	public String getAddress(@PathVariable String id, Model model) throws IOException {
		model.addAttribute(adminHomeservice.getUserSashwathaPoojeDetails(id));
		return "admin/usersashwathapoojefullview";
	}

	@RequestMapping(value = "/address/approve/{id}", method = RequestMethod.GET)
	public String approveAddress(@PathVariable String id) throws IOException {
		adminHomeservice.approveUserSashwathaPoojeDetails(id);
		return REDIRECT_TO_APPROVE;
	}

	@RequestMapping(value = "/address/delete/{id}", method = RequestMethod.GET)
	public String deleteAddress(@PathVariable String id) throws IOException {
		adminHomeservice.deleteUserSashwathaPoojeDetails(id);
		return REDIRECT_TO_APPROVE;
	}

	@RequestMapping(value = "/resetadminpassword", method = RequestMethod.GET)
	public String getresetPassword(Model model) {

		model.addAttribute("admins", superAdminService.getAdminToReject());
		model.addAttribute(new ChangePassword());
		return "admin/resetAdminPassword";
	}

	@RequestMapping(value = "/resetadminpassword", method = RequestMethod.POST)
	public String setResetPassword(@ModelAttribute ChangePassword cpbean, BindingResult bindingResult, Locale locale,
			Model model) {

		changePasswordValidator.validate(cpbean, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute(cpbean);

		} else {
			Integer i = adminHomeservice.resetPassword(cpbean);
			String message;
			if (i == 1) {
				message = messageSource.getMessage("message.reset.success", null, locale);

			} else {

				message = messageSource.getMessage("message.error", null, locale);
			}
			model.addAttribute("message", message);
			model.addAttribute(new ChangePassword());

		}
		model.addAttribute("admins", superAdminService.getAdminToReject());
		return "admin/resetAdminPassword";

	}

}
