package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.RegistrationBean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

public class RegistrationValidator implements Validator {

	@Autowired
	private kanajarTempleMethods defaultTempleMethods;
	private Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class arg0) {
		return arg0.equals(RegistrationBean.class);
	}

	@Override
	public void validate(Object obj, Errors error) {

		RegistrationBean regbean = (RegistrationBean) obj;
		String fullName = regbean.getFullName().trim();
		String password = regbean.getPassword();
		String confirmpassword = regbean.getConfirmPassword();
		String emailId = regbean.getEmailId().trim();
		String phoneNumber = regbean.getPhoneNumber().trim();

		ValidationUtils.rejectIfEmpty(error, "fullName", "fullname.required");
		ValidationUtils.rejectIfEmpty(error, "password", "password.required");
		ValidationUtils.rejectIfEmpty(error, "confirmPassword",
				"confirmpassword.required");
		ValidationUtils.rejectIfEmpty(error, "emailId", "emailid.required");
		ValidationUtils.rejectIfEmpty(error, "phoneNumber",
				"phonenumber.required");

		
		if (password.length() < 5) {
			error.rejectValue("password", "password.limit");
		}

		if (!(password.equals(confirmpassword))) {
			error.rejectValue("password", "password.identical");
		}

		// email validation in spring
		if (!(emailId != null && emailId.isEmpty())) {
			pattern = Pattern.compile(KanajarTempleConstants.EMAIL_PATTERN);
			matcher = pattern.matcher(emailId);
			if (!matcher.matches()) {
				error.rejectValue("emailId", "emailid.incorrect");
			}
		}

		// phone number validation
		if (!(phoneNumber != null && phoneNumber.isEmpty())) {
			pattern = Pattern.compile(KanajarTempleConstants.MOBILE_PATTERN);
			matcher = pattern.matcher(phoneNumber);
			if (!matcher.matches()) {
				error.rejectValue("phoneNumber", "phoneNumber.incorrect");
			}
		}
		
		if(defaultTempleMethods.checkEmailId(emailId,null))
		{
			error.rejectValue("emailId", "emailid.exists");
		}

		if(defaultTempleMethods.checkMobileNo(phoneNumber,null))
		{
			error.rejectValue("phoneNumber", "phoneNumber.exists");
		}
	}
}