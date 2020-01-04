package com.Admin.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.Admin.bean.Address;

public class AddressValidator extends AbstractValidator {

	public boolean supports(Class<?> arg0) {
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