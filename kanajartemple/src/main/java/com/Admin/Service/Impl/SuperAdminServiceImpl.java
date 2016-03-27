package com.Admin.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.Service.SuperAdminService;
import com.Admin.bean.Donation;
import com.Admin.bean.Expense;
import com.Admin.bean.Income;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.dao.SuperAdminDao;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {

	@Autowired
	private SuperAdminDao superAdminDao;

	public Integer CUDPooje(Pooje pbean, String code) {
		return superAdminDao.CUDPooje(pbean, code);
	}

	public Integer CUDDonation(Donation dbean, String code) {
		return superAdminDao.CUDDonation(dbean, code);
	}

	public List<Map<String, Object>> getAdmin() {
		return superAdminDao.getAdmin();
	}

	public List<Map<String, Object>> getAdminToReject() {
		return superAdminDao.getAdminToReject();
	}

	public Integer approveAdmin(String id) {
		return superAdminDao.approveAdmin(id);
	}

	public Integer rejectAdmin(String id) {
		return superAdminDao.rejectAdmin(id);
	}

	public Integer deleteAdmin(String id) {
		return superAdminDao.deleteAdmin(id);
	}

	@Override
	public Integer CUDIncome(Income ibean, String code) {
		return superAdminDao.CUDIncome(ibean, code);
	}

	@Override
	public Integer CUDExpense(Expense ebean, String code) {
		return superAdminDao.CUDExpense(ebean, code);
	}
}
