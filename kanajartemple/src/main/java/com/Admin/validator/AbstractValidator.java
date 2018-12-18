package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.Donation;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.SashwathaPoojebean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

public abstract class AbstractValidator implements Validator {

	
	private Pattern pattern;
	private Matcher matcher;
	
	protected void validateMobile(Errors error,String qualifier,  String phoneNumber) {
		// phone number validation
		if (!(phoneNumber != null && phoneNumber.isEmpty())) {
			pattern = Pattern.compile(KanajarTempleConstants.MOBILE_PATTERN);
			matcher = pattern.matcher(phoneNumber);
			if (!matcher.matches()) {
				error.rejectValue(qualifier, "phoneNumber.incorrect");
			}
		}
	}
	
	protected void validateEmail(Errors error,String qualifier, String emailId) {
		// email validation in spring
		if (!(emailId != null && emailId.isEmpty())) {
			pattern = Pattern.compile(KanajarTempleConstants.EMAIL_PATTERN);
			matcher = pattern.matcher(emailId);
			if (!matcher.matches()) {
				error.rejectValue(qualifier, "emailid.incorrect");
			}
		}
	}
}