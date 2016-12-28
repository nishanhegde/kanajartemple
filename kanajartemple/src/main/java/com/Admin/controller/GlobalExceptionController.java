package com.Admin.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jfree.util.Log;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionController {
	
	private static final Logger logger = Logger.getLogger(GlobalExceptionController.class);
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex,HttpServletRequest req) {

		logger.error(ex);
				
		ModelAndView model = new ModelAndView("admin/errorpage");
		
		model.addObject("errMsg", ex.getMessage());
		return model;

	}
}
