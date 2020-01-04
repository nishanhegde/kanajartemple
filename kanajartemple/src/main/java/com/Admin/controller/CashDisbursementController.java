package com.Admin.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Admin.Service.CashDisbursementService;

import com.Admin.bean.CashDisbursement;
import com.Admin.bean.Reportbean;
import com.Admin.validator.AddressValidator;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value = "/cash")
public class CashDisbursementController {

	private static final String REDIRECT_VIEW_ACCOUNT = KanajarTempleConstants.REDIRECT_PRIFIX + "/cash/view";

	@Resource
	private CashDisbursementService cashDisbursementService;

	@Resource
	private MessageSource messageSource;

	@Resource
	private AddressValidator addressValidator;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAccount(Model model) {
		model.addAttribute(new CashDisbursement());
		return KanajarTempleConstants.CASHDISPURSEMENT_VIEW + "/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute CashDisbursement cashDisbursement, BindingResult bindingResult, Model model,
			Locale locale) {

		// addressValidator.validate(cashDisbursement, bindingResult);
		if (!bindingResult.hasErrors()) {
			cashDisbursementService.save(cashDisbursement);
			model.addAttribute("message", messageSource.getMessage("save.success", null, locale));
		}

		model.addAttribute(cashDisbursement);
		return REDIRECT_VIEW_ACCOUNT;

	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAccount(Model model) {
		model.addAttribute("cashDisbursement", cashDisbursementService.getCashDisbursement());
		return KanajarTempleConstants.CASHDISPURSEMENT_VIEW + "/view";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editAccount(@PathVariable String id, Model model) {
		return getEditView(cashDisbursementService.getCashDisbursement(id), model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute CashDisbursement cashDisbursement, Model model, Locale locale) {

		if (cashDisbursementService.update(cashDisbursement) == 1) {
			model.addAttribute("message", messageSource.getMessage("update.success", null, locale));
		}
		return getEditView(cashDisbursement, model);
	}

	private String getEditView(CashDisbursement ba, Model model) {
		model.addAttribute(ba);
		return KanajarTempleConstants.CASHDISPURSEMENT_VIEW + "/edit";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteAccount(@PathVariable String id, Model model) {
		cashDisbursementService.delete(id);
		return REDIRECT_VIEW_ACCOUNT;
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public String AdminPoojeReport(Model model) {

		return KanajarTempleConstants.CASHDISPURSEMENT_VIEW + "/report";
	}

	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public ModelAndView AdminPoojeReportSuccess(HttpServletRequest request, HttpServletResponse response,
			Reportbean rbean) {

		List<?> report = cashDisbursementService.getReport(rbean);

		ModelAndView mv = new ModelAndView("CashDisbursementReport",
				Collections.singletonMap("datasource", new JRBeanCollectionDataSource(report)));
		mv.addObject("format", rbean.getSaveAs());
		return mv;
	}

}
