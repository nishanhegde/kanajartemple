package com.Admin.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.AdminHomeService;
import com.Admin.bean.SashwathaPoojebean;

import com.Admin.validator.UserSashwathaPoojeValidator;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private AdminHomeService adminHomeService;

	@Autowired
	private kanajarTempleMethods kanajarTempleMethods;

	@Resource
	private UserSashwathaPoojeValidator userSashwathaPoojeValidator;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "/Video")
	public ModelAndView Video(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("Video");
		return mv;
	}

	@RequestMapping(value = "/Home")
	public ModelAndView Home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("Home");

		mv.addObject("Home", adminHomeService.getPageContent("1"));
		mv.addObject("News", adminHomeService.getPageContent("2"));
		return mv;
	}

	@RequestMapping(value = "/ContactUs")
	public ModelAndView ContactUs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ContactUs");
		mv.addObject(adminHomeService.getPageContent("6"));
		return mv;
	}

	@RequestMapping(value = "/UserCMS/{Pid}")
	public ModelAndView UserCMS(@PathVariable("Pid") String Pid, HttpServletRequest request,
			HttpServletResponse response) {
		String Pagename = request.getParameter("PageName");

		ModelAndView mv = new ModelAndView("UserCMS");
		mv.addObject(adminHomeService.getPageContent(Pid));
		return mv;
	}

	@RequestMapping(value = "/NithyaPooje")
	public ModelAndView NithyaPooje(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("NithyaPuje");
		mv.addObject("NithyaPooje", kanajarTempleMethods.getSashwathaPooje());
		return mv;
	}

	@RequestMapping(value = "/photos", method = RequestMethod.GET)
	public ModelAndView getPhotos(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("photos");
		return mv;
	}

	@RequestMapping(value = "/NithyaPooje/update/{id}")
	public ModelAndView NithyaPoojeUpdate(@PathVariable String id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("NithyaPujeUpdate");
		mv.addObject(kanajarTempleMethods.getSashwathaPooje(id));
		return mv;
	}

	@RequestMapping(value = "/NithyaPooje/update", method = RequestMethod.POST)
	public String NithyaPoojeUpdate(@ModelAttribute SashwathaPoojebean sbean, Model model, HttpServletResponse response,
			BindingResult bindingResult) {
		userSashwathaPoojeValidator.validate(sbean, bindingResult);
		if (bindingResult.hasErrors()) {
			model.addAttribute(sbean);
		} else if (adminHomeService.saveSashwathaPooje(sbean) == 1) {
			model.addAttribute(sbean);
		}
		return "NithyaPujeUpdate";
	}

}