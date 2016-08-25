package com.Brahmalingeshwara.kanajartemple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.Brahmalingeshwara.bean.SevaBookingBean;
import com.Brahmalingeshwara.service.HomeService;


@Controller
@RequestMapping("/SevaBooking")
public class SevaBooking {
	
	/*@Autowired
	HomeService service;
	
	public HomeService getService() {
		return service;
	}

	public void setService(HomeService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
		public String initForm(ModelMap model){
	 
		 SevaBookingBean sbb = new SevaBookingBean();
			
			//command object
			model.addAttribute("SevaDetails", sbb);
	 
			//return form view
			return "SevaBooking";
		}
	
	@RequestMapping(value = "/SevaBooking")
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		SevaBookingBean sbb=(SevaBookingBean)command;
		
		service.insertseva(sbb);
		
		return new ModelAndView("SevaBooking");
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processSubmit(
		@ModelAttribute("SevaDetails") SevaBookingBean sbb,
		BindingResult result, SessionStatus status) {
		
		customerValidator.validate(customer, result);
		 
		if (result.hasErrors()) {
			//if validator failed
			return "SevaBooking";
		} else {
			status.setComplete();
			//form success
			return "CustomerSuccess";
		}
		
 
		service.insertseva(sbb);
		//clear the command object from the session
		status.setComplete(); 
		//return form success view
		return "SevaBooking";
 
	}
*/
}
