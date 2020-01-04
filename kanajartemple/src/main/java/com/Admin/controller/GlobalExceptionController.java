package com.Admin.controller;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	
	private static final Logger logger = Logger.getLogger(GlobalExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		logger.error(ex.getStackTrace());
				
		ModelAndView model = new ModelAndView("admin/errorpage");
		
		model.addObject("errMsg", ex.getMessage());
		return model;

	}
		
}
