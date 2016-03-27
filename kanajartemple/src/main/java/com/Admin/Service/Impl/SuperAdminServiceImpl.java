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
import com.Admin.dao.impl.SuperAdminDaoImpl;

@Service("service")
public class SuperAdminServiceImpl implements SuperAdminService {

	@Autowired
	private SuperAdminDaoImpl dao;

	public SuperAdminDaoImpl getDao() {
		return dao;
	}

	public void setDao(SuperAdminDaoImpl dao) {
		this.dao = dao;
	}

	@Override
	public Integer CUDPooje(Pooje pbean, String code) {
		return dao.CUDPooje(pbean, code);
	}

	@Override
	public Integer CUDDonation(Donation dbean, String code) {
		return dao.CUDDonation(dbean, code);
	}

	@Override
	public List<Map<String, Object>> getAdmin() {
		return dao.getAdmin();
	}

	@Override
	public List<Map<String, Object>> getAdminToReject() {
		return dao.getAdminToReject();
	}

	@Override
	public Integer approveAdmin(String id) {
		return dao.approveAdmin(id);
	}

	@Override
	public Integer rejectAdmin(String id) {
		return dao.rejectAdmin(id);
	}

	@Override
	public Integer deleteAdmin(String id) {
		return dao.deleteAdmin(id);
	}

	@Override
	public Integer CUDIncome(Income ibean, String code) {
		return dao.CUDIncome(ibean, code);
	}

	@Override
	public Integer CUDExpense(Expense ebean, String code) {
		return dao.CUDExpense(ebean, code);
	}
}
