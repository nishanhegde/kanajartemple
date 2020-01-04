package com.Admin.Service;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;

import com.Admin.bean.Donation;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.Expense;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.Income;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.bean.SashwathaPoojebean;

public interface kanajarTempleMethods {

	public Pooje getPooje(String PoojeId);

	public List<Map<String, Object>> getPooje();

	public List<Map<String, Object>> getAllPooje();

	public Poojebean getPoojeDataDetail(String RecNo, String PoojeId);

	public List<Map<String, Object>> getPoojeDataDetail(String PoojeId);

	public List<Map<String, Object>> getSashwathaPooje();

	public SashwathaPoojebean getSashwathaPooje(String RecNo);

	public Donation getDonation(String DonationId);

	public List<Map<String, Object>> getDonation();

	public DonationDetail getDonationDataDetail(String RecNo, String DonationId);

	public List<Map<String, Object>> getDonationDataDetail(String DonationId);

	public Expense getExpenditure(String Id);

	public List<Map<String, Object>> getExpenditure();
	
	public ExpenseData getExpenditureData(String RecNo,String Id);

	public List<Map<String, Object>> getExpenditureData(String Id);
	
	public Income getIncome(String Id);

	public List<Map<String, Object>> getIncome();
	
	public IncomeData getIncomeData(String RecNo,String Id);

	public List<Map<String, Object>> getIncomeData(String Id);
	
	public boolean checkEmailId(String emailid,String id);
	
	public boolean checkMobileNo(String mobileno,String id);
	
	public boolean checkCurrentPassword(String username,String currentpassword);
	
	public String getEmails();
	
	public java.sql.Date getCustomDate(String formdate);
	
	public List<Map<String, Object>> getSashwathaPoojeAddress(String month);
	
	public List<Map<String, Object>> getInvitationAddress(String filters);
	
}
