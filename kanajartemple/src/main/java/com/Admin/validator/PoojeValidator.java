package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.bean.Poojebean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

public class PoojeValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class arg0) {
		return arg0.equals(Poojebean.class);
	}

	@Override
	public void validate(Object obj, Errors error) {

		Poojebean pbean = (Poojebean) obj;
		if (pbean != null) {
			Integer quantity = pbean.getQuantity();
			String pdate = pbean.getPDate();

			ValidationUtils.rejectIfEmpty(error, "Name", "fullname.required");
			ValidationUtils.rejectIfEmpty(error, "Quantity",
					"quantity.required");
			ValidationUtils.rejectIfEmpty(error, "PDate", "pdate.required");

			if (quantity <= 0) {
				error.rejectValue("Quantity", "quantity.limit");
			}

			if (!(pdate != null && pdate.isEmpty())) {
				pattern = Pattern.compile(KanajarTempleConstants.DATE_PATTERN);
				matcher = pattern.matcher(pdate);
				if (!matcher.matches()) {
					error.rejectValue("PDate", "pdate.incorrect");
				}
			}
		}
	}
}