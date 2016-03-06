package com.Admin.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.SuperAdminService;
import com.Admin.bean.Donation;
import com.Admin.bean.Pooje;

@Controller
@RequestMapping(value = "/SuperAdmin")
public class SuperAdminController {

	@Autowired
	private SuperAdminService service;
	@Autowired
	private kanajarTempleMethods defaultTempleMethods;

	@RequestMapping(value = "/CUDPooje")
	public ModelAndView SuperAdminCUDPooje(HttpServletRequest request,
			HttpServletResponse response, Pooje pbean) throws IOException {

		ModelAndView mv = new ModelAndView("admin/PoojeTemplate");
		mv.addObject("Poojedata", defaultTempleMethods.getAllPooje());
		return mv;
	}

	@RequestMapping(value = "/CUDPooje/{Code}")
	public String SuperAdminCUDPooje(@PathVariable("Code") String code,
			HttpServletRequest request, HttpServletResponse response,
			Pooje pbean) throws IOException {

		Integer a = service.CUDPooje(pbean, code);
		if (a != null) {
			return PoojeController.REDIRECTPREFIX + "/SuperAdmin/CUDPooje";
		}
		return null;

	}

	@RequestMapping(value = "/CUDPooje/{Code}/{Pid}")
	public String SuperAdminCUDPooje(@PathVariable("Code") String code,
			@PathVariable("Pid") String Pid, HttpServletRequest request,
			HttpServletResponse response, Pooje pbean) throws IOException {

		pbean.setPid(Integer.valueOf(Pid));
		Integer a = service.CUDPooje(pbean, code);
		if (a != null) {
			return PoojeController.REDIRECTPREFIX + "/SuperAdmin/CUDPooje";
		}
		return null;

	}

	@RequestMapping(value = "/CUDDonation")
	public ModelAndView SuperAdminAddDonation(HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {

		ModelAndView mv = new ModelAndView("admin/DonationTemplate");
		mv.addObject("Poojedata", defaultTempleMethods.getDonation());
		return mv;
	}

	@RequestMapping(value = "/CUDDonation/{Code}")
	public String SuperAdminAddDonation(@PathVariable("Code") String code,
			HttpServletRequest request, HttpServletResponse response,
			Donation dbean) throws IOException {
		Integer a = service.CUDDonation(dbean, code);
		if (a != null) {
			return PoojeController.REDIRECTPREFIX + "/SuperAdmin/CUDDonation";
		}
		return null;
	}

	@RequestMapping(value = "/CUDDonation/{Code}/{Did}")
	public String SuperAdminAddDonation(@PathVariable("Code") String code,
			@PathVariable("Did") String Did, HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {

		dbean.setDid(Integer.parseInt(Did));
		Integer a = service.CUDDonation(dbean, code);
		if (a != null) {
			return PoojeController.REDIRECTPREFIX + "/SuperAdmin/CUDDonation";
		}
		return null;
	}

	@RequestMapping(value = "/ApproveAdmin")
	public ModelAndView ApproveAdmin(HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {
		ModelAndView mv = new ModelAndView("admin/ApproveAdmin");
		mv.addObject("Admins", service.getAdmin());
		return mv;

	}

	@RequestMapping(value = "/RejectAdmin")
	public ModelAndView RejectAdmin(HttpServletRequest request,
			HttpServletResponse response, Donation dbean) throws IOException {
		ModelAndView mv = new ModelAndView("admin/RejectAdmin");
		mv.addObject("Admins", service.getAdminToReject());
		return mv;

	}

	@RequestMapping(value = "/Approve/{id}")
	public ModelAndView ApproveAdmin(@PathVariable("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			Donation dbean) throws IOException {

		Integer a = service.approveAdmin(id);
		ModelAndView mv = new ModelAndView("admin/ApproveAdmin");
		mv.addObject("Admins", service.getAdmin());
		return mv;
	}

	@RequestMapping(value = "/Reject/{id}")
	public ModelAndView RejectAdmin(@PathVariable("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			Donation dbean) throws IOException {

		Integer a = service.rejectAdmin(id);
		ModelAndView mv = new ModelAndView("admin/RejectAdmin");
		mv.addObject("Admins", service.getAdminToReject());
		return mv;
	}

	@RequestMapping(value = "/Delete/{id}")
	public ModelAndView DeleteAdmin(@PathVariable("id") String id,
			HttpServletRequest request, HttpServletResponse response,
			Donation dbean) throws IOException {

		Integer a = service.deleteAdmin(id);
		ModelAndView mv = new ModelAndView("admin/ApproveAdmin");
		mv.addObject("Admins", service.getAdmin());
		return mv;
	}
}
