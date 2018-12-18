package com.Admin.controller;

import java.util.Locale;
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

import com.Admin.Service.AddressService;
import com.Admin.bean.Address;
import com.Admin.bean.DonationDetail;
import com.Admin.validator.AddressValidator;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;


@Controller
@RequestMapping(value = "/address")
public class AddressController {

	private static final String REDIRECT_VIEW_ACCOUNT = KanajarTempleConstants.REDIRECT_PRIFIX + "/address/view";

	@Resource
	private AddressService addressService;

	@Resource
	private MessageSource messageSource;
	
	@Resource
	private AddressValidator addressValidator;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addAccount(Model model) {
		model.addAttribute(new Address());
		return KanajarTempleConstants.ADDRESS_VIEW + "/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAccount(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute Address address, BindingResult bindingResult, Model model,Locale locale) {

		addressValidator.validate(address, bindingResult);
		if (!bindingResult.hasErrors()) {
				addressService.save(address);
				model.addAttribute("message", messageSource.getMessage("save.success", null, locale));
		}
		
		model.addAttribute(address);
		return KanajarTempleConstants.ADDRESS_VIEW + "/add";
		
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewAccount(Model model) {
		model.addAttribute("address", addressService.getAddress());
		return KanajarTempleConstants.ADDRESS_VIEW + "/view";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editAccount(@PathVariable String id, Model model) {
		return getEditView(addressService.getAddress(id), model);
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String updateAccount(@ModelAttribute Address ba, Model model, Locale locale) {

		if (addressService.update(ba) == 1) {
			model.addAttribute("message", messageSource.getMessage("update.success", null, locale));
		}
		return getEditView(ba, model);
	}

	private String getEditView(Address ba, Model model) {
		model.addAttribute(ba);
		return KanajarTempleConstants.ADDRESS_VIEW + "/edit";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteAccount(@PathVariable String id, Model model) {
		addressService.delete(id);
		return REDIRECT_VIEW_ACCOUNT;
	}
}
