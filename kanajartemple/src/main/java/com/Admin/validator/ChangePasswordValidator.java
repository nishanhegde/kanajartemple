package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.ChangePassword;
import com.Admin.bean.RegistrationBean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

public class ChangePasswordValidator implements Validator {

	@Autowired
	private kanajarTempleMethods defaultTempleMethods;
	private Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class arg0) {
		return arg0.equals(ChangePassword.class);
	}

	@Override
	public void validate(Object obj, Errors error) {

		ChangePassword cbean = (ChangePassword) obj;
		String currentpassword = cbean.getCurrentpassword().trim();
		String password = cbean.getNewpassword();
		String confirmpassword = cbean.getConfirmpassword();
		
		ValidationUtils.rejectIfEmpty(error, "currentpassword", "currentpassword.required");
		ValidationUtils.rejectIfEmpty(error, "newpassword", "password.required");
		ValidationUtils.rejectIfEmpty(error, "confirmpassword",
				"confirmpassword.required");
		
		
		if (password.length() < 5) {
			error.rejectValue("newpassword", "password.limit");
		}

		if (!(password.equals(confirmpassword))) {
			error.rejectValue("newpassword", "password.identical");
		}

		User user = (User) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	
		if(!defaultTempleMethods.checkCurrentPassword(user.getUsername(),currentpassword))
		{
			error.rejectValue("currentpassword", "currentpassword.exists");
		}

		
	}
}