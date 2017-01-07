package com.Admin.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.jmx.export.annotation.ManagedNotification;
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

import com.Admin.Service.EmailService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.Service.Impl.AdminHomeService;
import com.Admin.bean.SashwathaPoojebean;

import com.Admin.validator.UserSashwathaPoojeValidator;

import net.sf.jasperreports.data.empty.EmptyDataAdapterImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	public static String REDIRECTPREFIX = "redirect:";

	@Value("${email.query.to}")
	private String queryTo;

	@Autowired
	private AdminHomeService adminHomeService;

	@Autowired
	private kanajarTempleMethods kanajarTempleMethods;

	@Resource
	private UserSashwathaPoojeValidator userSashwathaPoojeValidator;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private EmailService emailService;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "index";
	}

	@RequestMapping(value = "/video")
	public ModelAndView Video(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("Video");
		return mv;
	}

	@RequestMapping(value = "/home")
	public ModelAndView Home(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("Home");

		mv.addObject("Home", adminHomeService.getPageContent("1"));
		mv.addObject("News", adminHomeService.getPageContent("2"));
		return mv;
	}

	@RequestMapping(value = "/contactus")
	public ModelAndView ContactUs(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("ContactUs");
		mv.addObject(adminHomeService.getPageContent("6"));
		return mv;
	}

	@RequestMapping(value = "/usercms/{Pid}")
	public ModelAndView UserCMS(@PathVariable("Pid") String Pid, HttpServletRequest request,
			HttpServletResponse response) {
		String Pagename = request.getParameter("PageName");

		ModelAndView mv = new ModelAndView("UserCMS");
		mv.addObject(adminHomeService.getPageContent(Pid));
		return mv;
	}

	@RequestMapping(value = "/nithyapooje")
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
	public String NithyaPoojeUpdate(@ModelAttribute SashwathaPoojebean sbean, Model model, Locale locale,
			BindingResult bindingResult) {
		userSashwathaPoojeValidator.validate(sbean, bindingResult);
		if (!bindingResult.hasErrors() && adminHomeService.saveSashwathaPooje(sbean) == 1) {
			model.addAttribute("message", messageSource.getMessage("label.usersashwathapooje.success", null, locale));
		}
		model.addAttribute(sbean);
		return "NithyaPujeUpdate";
	}

	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public String query(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("query") String query, HttpServletRequest request, final RedirectAttributes redirectModel,
			Locale locale) {

		try {
			if (name != null && email != null && query != null) {
				String lineBreak = System.getProperty("line.separator");
				StringBuilder body = new StringBuilder();
				body.append("Name   : " + name.trim());
				body.append(lineBreak);
				body.append("Email : " + email);
				body.append(lineBreak);
				body.append("Query : " + query.trim());

				emailService.sendEmail(queryTo, email, "User Query", body.toString());
				redirectModel.addFlashAttribute("message",
						messageSource.getMessage("label.query.success", null, locale));
			}
		} catch (Exception ex) {
			logger.error(ex);
			redirectModel.addFlashAttribute("message", messageSource.getMessage("label.query.failure", null, locale));
		}

		return REDIRECTPREFIX + "/contactus";
	}

}
