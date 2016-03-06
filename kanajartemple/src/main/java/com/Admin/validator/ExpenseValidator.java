package com.Admin.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.Admin.bean.Expense;
import com.Admin.bean.Income;
import com.Admin.bean.Poojebean;
import com.Brahmalingeshwara.kanajartemple.KanajarTempleConstants;

public class ExpenseValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	public boolean supports(Class arg0) {
		return arg0.equals(Expense.class);
	}

	@Override
	public void validate(Object obj, Errors error) {

		Expense ebean = (Expense) obj;

		String edate = ebean.getEDate();
		Double amount = ebean.getAmount();
		ValidationUtils.rejectIfEmpty(error, "Title", "title.required");
		ValidationUtils.rejectIfEmpty(error, "Description", "description.required");
		ValidationUtils.rejectIfEmpty(error, "Amount", "amount.required");
		ValidationUtils.rejectIfEmpty(error, "EDate", "edate.required");

		if (amount <= 0) {
			error.rejectValue("Amount", "amount.limit");
		}

		if (!(edate != null && edate.isEmpty())) {
			pattern = Pattern.compile(KanajarTempleConstants.DATE_PATTERN);
			matcher = pattern.matcher(edate);
			if (!matcher.matches()) {
				error.rejectValue("EDate", "pdate.incorrect");
			}
		}

	}
}