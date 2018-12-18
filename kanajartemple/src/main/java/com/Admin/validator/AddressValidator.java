package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.Address;
import com.Admin.bean.Donation;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.RegistrationBean;
import com.Admin.bean.SashwathaPoojebean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

public class AddressValidator extends AbstractValidator {

	
	private Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class arg0) {
		return arg0.equals(Address.class);
	}

	@Override
	public void validate(Object obj, Errors error) {

		Address address = (Address) obj;
	

		ValidationUtils.rejectIfEmpty(error, "fullname", "fullname.required");
		ValidationUtils.rejectIfEmpty(error, "address", "address.required");
		
		validateMobile(error, "mobile", address.getMobile().trim());
		validateEmail(error, "email", address.getEmail().trim());
		}
}