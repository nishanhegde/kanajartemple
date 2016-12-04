package com.Admin.Service.Impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.Donation;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.Expense;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.Income;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.dao.kanajarTempleMethodsDao;


public class kanajarTempleMethodsImpl implements kanajarTempleMethods {


	  
	@Autowired
	private kanajarTempleMethodsDao defaultTempleMethodsDao;

	@Override
	public Pooje getPooje(String PoojeId) {
		return defaultTempleMethodsDao.getPooje(PoojeId);
	}

	@Override
	public List<Map<String, Object>> getPooje() {
		return defaultTempleMethodsDao.getPooje();
	}

	@Override
	public List<Map<String, Object>> getAllPooje() {
		return defaultTempleMethodsDao.getAllPooje();
	}

	@Override
	public Poojebean getPoojeDataDetail(String RecNo, String PoojeId) {
		return defaultTempleMethodsDao.getPoojeDataDetail(RecNo, PoojeId);
	}

	@Override
	public List<Map<String, Object>> getPoojeDataDetail(String PoojeId) {
		return defaultTempleMethodsDao.getPoojeDataDetail(PoojeId);
	}

	@Override
	public List<Map<String, Object>> getSashwathaPooje() {
		return defaultTempleMethodsDao.getSashwathaPooje();
	}

	@Override
	public SashwathaPoojebean getSashwathaPooje(String RecNo) {
		return defaultTempleMethodsDao.getSashwathaPooje(RecNo);
	}

	@Override
	public Donation getDonation(String DonationId) {
	return defaultTempleMethodsDao.getDonation(DonationId);	
	}

	@Override
	public List<Map<String, Object>> getDonation() {
		return defaultTempleMethodsDao.getDonation();
	}

	@Override
	public DonationDetail getDonationDataDetail(String RecNo, String DonationId) {
		return defaultTempleMethodsDao.getDonationDataDetail(RecNo, DonationId);
	}

	@Override
	public List<Map<String, Object>> getDonationDataDetail(String DonationId) {
		return defaultTempleMethodsDao.getDonationDataDetail(DonationId);
	}

	@Override
	public Expense getExpenditure(String Id) {
		return defaultTempleMethodsDao.getExpenditure(Id);
	}

	@Override
	public List<Map<String, Object>> getExpenditure() {
		return defaultTempleMethodsDao.getExpenditure();
	}

	@Override
	public ExpenseData getExpenditureData(String RecNo,String Id) {
		return defaultTempleMethodsDao.getExpenditureData(RecNo,Id);
	}

	@Override
	public List<Map<String, Object>> getExpenditureData(String Id) {
		return defaultTempleMethodsDao.getExpenditureData(Id);
	}

	@Override
	public IncomeData getIncomeData(String RecNo,String Id) {
		return defaultTempleMethodsDao.getIncomeData(RecNo,Id);
	}

	@Override
	public List<Map<String, Object>> getIncomeData(String Id) {
		return defaultTempleMethodsDao.getIncomeData(Id);
	}

	@Override
	public boolean checkEmailId(String emailid,String id) {
		return defaultTempleMethodsDao.checkEmailId(emailid,id);
	}

	@Override
	public boolean checkMobileNo(String mobileno,String id) {
		return defaultTempleMethodsDao.checkMobileNo(mobileno,id);
	}

	@Override
	public boolean checkCurrentPassword(String username, String currentpassword) {
	
		return defaultTempleMethodsDao.checkCurrentPassword(username,currentpassword);
	}

	@Override
	public Income getIncome(String Id) {
		return defaultTempleMethodsDao.getIncome(Id);
	}

	@Override
	public List<Map<String, Object>> getIncome() {
		return defaultTempleMethodsDao.getIncome();
	}

}
