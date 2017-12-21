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
import com.Admin.bean.BankAccount;
import com.Admin.bean.BankAccountEntry;
import com.Admin.bean.CMSbean;
import com.Admin.bean.RegistrationBean;

import com.Admin.bean.ChangePassword;
import com.Admin.bean.Coupon;
import com.Admin.validator.ChangePasswordValidator;
import com.Admin.validator.EditProfileValidator;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;
import com.Brahmalingeshwara.kanajartemple.TransactionEnum;
import com.Brahmalingeshwara.kanajartemple.TypeEnum;

@Controller
@RequestMapping(value = "/Admin")
public class BankAccountController {

	private static final String REDIRECT_VIEW_ACCOUNT = KanajarTempleConstants.REDIRECT_PRIFIX + "/Admin/viewaccount";

	@Resource
	private BankAccountService bankAccountService;

	@Resource
	private MessageSource messageSource;

	@RequestMapping(value = "/addaccount", method = RequestMethod.GET)
	public String addAccount(Model model) {
		model.addAttribute(new BankAccount());
		return KanajarTempleConstants.BANK_ACC_VIEW + "/addaccount";
	}

	@RequestMapping(value = "/addaccount", method = RequestMethod.POST)
	public String addAccount(@ModelAttribute BankAccount ba, Model model) {
		bankAccountService.save(ba);
		return REDIRECT_VIEW_ACCOUNT;
	}

	@RequestMapping(value = "/viewaccount", method = RequestMethod.GET)
	public String viewAccount(Model model) {
		model.addAttribute("bankAccounts", bankAccountService.getBankAccounts());
		return KanajarTempleConstants.BANK_ACC_VIEW + "/viewaccount";
	}

	@RequestMapping(value = "/editaccount/{id}", method = RequestMethod.GET)
	public String editAccount(@PathVariable String id, Model model) {
		return getEditAccountView(bankAccountService.getBankAccount(id), model);
	}

	

	@RequestMapping(value = "/editaccount", method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute BankAccount ba, Model model, Locale locale) {

		if (bankAccountService.update(ba) == 1) {
			model.addAttribute("message", messageSource.getMessage("update.success", null, locale));
		}
		return getEditAccountView(ba, model);
	}
	
	private String getEditAccountView(BankAccount ba, Model model) {
		model.addAttribute(ba);
		return KanajarTempleConstants.BANK_ACC_VIEW + "/editaccount";
	}
	
	@RequestMapping(value = "/deleteaccount/{id}", method = RequestMethod.GET)
	public String deleteAccount(@PathVariable String id, Model model) {
		bankAccountService.delete(id);
		return REDIRECT_VIEW_ACCOUNT;
	}
	
	@RequestMapping(value = "/addaccountentry", method = RequestMethod.GET)
	public String addAccountEntry(Model model) {
		model.addAttribute(new BankAccountEntry());
		model.addAttribute("transactions", TransactionEnum.values());
		model.addAttribute("types", TypeEnum.values());
		model.addAttribute("bankAccounts", bankAccountService.getBankAccounts());
		return KanajarTempleConstants.BANK_ACC_VIEW + "/addaccountentry";
	}

	@RequestMapping(value = "/addaccountentry", method = RequestMethod.POST)
	public String saveAccountEntry(@ModelAttribute BankAccountEntry bae,Model model) {
		bankAccountService.save(bae);
		return KanajarTempleConstants.REDIRECT_PRIFIX + "/Admin/viewaccountentry/"+bae.getBankAccountId();
	}
	
	@RequestMapping(value = "/viewaccountentry/{bankId}", method = RequestMethod.GET)
	public String viewAccountEntry(@PathVariable String bankId,Model model) {
		model.addAttribute("bankAccountEntry", bankAccountService.getBankAccountEntries(bankId));
		model.addAttribute(bankAccountService.getBankAccount(bankId));
		return KanajarTempleConstants.BANK_ACC_VIEW + "/viewaccountentry";
	}
}
