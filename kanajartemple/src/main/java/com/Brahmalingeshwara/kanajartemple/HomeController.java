package com.Brahmalingeshwara.kanajartemple;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.Brahmalingeshwara.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	HomeService service;
	
	
	public HomeService getService() {
		return service;
	}

	public void setService(HomeService service) {
		this.service = service;
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value = "/Video")
	public ModelAndView Video(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("Video");
		return mv;
	}

	@RequestMapping(value = "/Home")
	public ModelAndView Home(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("Home");
		Map homedetails=service.getHomedetails();
		mv.addAllObjects(homedetails);
		return mv;
	}

	@RequestMapping(value = "/ContactUs")
	public ModelAndView ContactUs(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("ContactUs");
		return mv;
	}
	
	@RequestMapping(value = "/UserCMS")
	public ModelAndView UserCMS(HttpServletRequest request,HttpServletResponse response)
	{
		String Pagename=request.getParameter("PageName");
		
		ModelAndView mv=new ModelAndView("UserCMS");
		List content=service.getPageContent(Pagename);
		mv.addObject("CMScontent", content);
		mv.addObject("Pagename", Pagename);
		return mv;
	}
	
	@RequestMapping(value = "/NithyaPooje")
	public ModelAndView NithyaPooje(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView("NithyaPuje");
		mv.addObject("NithyaPooje", service.getAddress());
		return mv;
	}
	
}
