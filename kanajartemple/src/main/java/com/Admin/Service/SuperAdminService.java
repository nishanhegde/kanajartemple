package com.Admin.Service;

import java.util.List;
import java.util.Map;

import com.Admin.bean.Donation;
import com.Admin.bean.Expense;
import com.Admin.bean.Income;
import com.Admin.bean.Pooje;

public interface SuperAdminService {
	public Integer CUDPooje(Pooje pbean, String code);

	public Integer CUDDonation(Donation dbean, String code);

	public List<Map<String, Object>> getAdmin();

	public List<Map<String, Object>> getAdminToReject();

	public Integer approveAdmin(String id);

	public Integer rejectAdmin(String id);

	public Integer deleteAdmin(String id);
	
	public Integer CUDIncome(Income ibean, String code);
	
	public Integer CUDExpense(Expense ebean, String code);
}
