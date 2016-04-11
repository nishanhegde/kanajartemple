package com.Admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Admin.Service.SuperAdminService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.SuperAdminServiceImpl;
import com.Admin.bean.Donation;
import com.Admin.bean.Expense;
import com.Admin.bean.Income;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Pooje;

@Controller
@RequestMapping(value = "/SuperAdmin")
public class SuperAdminController {

	@Autowired
	private SuperAdminService superAdminService;
	@Autowired
	private kanajarTempleMethods defaultTempleMethods;

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
}
