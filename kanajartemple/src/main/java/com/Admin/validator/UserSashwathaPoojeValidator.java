package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.SashwathaPoojebean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

@Component("userSashwathaPoojeValidator")
public class UserSashwathaPoojeValidator implements Validator {

	
	private Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class arg0) {
		return arg0.equals(SashwathaPoojebean.class);
	}

	@Override
	public void validate(Object obj, Errors error) {

		SashwathaPoojebean sbean = (SashwathaPoojebean) obj;
		String name = sbean.getName().trim();
	
		String pdate = sbean.getPdate().trim();
		String emailId = sbean.getEmail().trim();
		String phoneNumber = sbean.getMobileNo().trim();

		ValidationUtils.rejectIfEmpty(error, "Name", "fullname.required");
		ValidationUtils.rejectIfEmpty(error, "Address", "address.required");
		ValidationUtils.rejectIfEmpty(error, "Pdate", "pdate.required");
		
		
		// email validation in spring
		if (!(emailId == null && emailId.isEmpty())) {
			pattern = Pattern.compile(KanajarTempleConstants.EMAIL_PATTERN);
			matcher = pattern.matcher(emailId);
			if (!matcher.matches()) {
				error.rejectValue("Email", "emailid.incorrect");
			}
		}

		// phone number validation
		if (!(phoneNumber == null && phoneNumber.isEmpty())) {
			pattern = Pattern.compile(KanajarTempleConstants.MOBILE_PATTERN);
			matcher = pattern.matcher(phoneNumber);
			if (!matcher.matches()) {
				error.rejectValue("MobileNo", "phoneNumber.incorrect");
			}
		}
		
		
		}
}