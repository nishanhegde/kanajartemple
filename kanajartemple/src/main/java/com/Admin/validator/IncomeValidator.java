package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.bean.Income;
import com.Admin.bean.Poojebean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

public class IncomeValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class arg0) {
		return arg0.equals(Income.class);
	}

	@Override
	public void validate(Object obj, Errors error) {

		Income ibean = (Income) obj;
		if (ibean != null) {
			
			String edate = ibean.getEdate();
			Double amount=ibean.getAmount();
			ValidationUtils.rejectIfEmpty(error, "title", "title.required");
			ValidationUtils.rejectIfEmpty(error, "Amount",
					"amount.required");
			ValidationUtils.rejectIfEmpty(error, "Edate", "edate.required");

			if (amount <= 0) {
				error.rejectValue("Amount", "amount.limit");
			}

			if (!(edate != null && edate.isEmpty())) {
				pattern = Pattern.compile(KanajarTempleConstants.DATE_PATTERN);
				matcher = pattern.matcher(edate);
				if (!matcher.matches()) {
					error.rejectValue("Edate", "pdate.incorrect");
				}
			}
		}
	}
}