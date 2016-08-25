package com.Admin.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.bean.DonationDetail;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Poojebean;
import com.Admin.bean.Reportbean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.dao.impl.PoojeDao;

@Service("poojeService")
public class PoojeService {

	@Autowired
	private PoojeDao poojeDao;

	
	
	
	public String getPoojedetailstoprint(Poojebean pbean) {
		return poojeDao.getPoojedetailstoprint(pbean);
	}
	
	public Integer getSashwathaPoojedetailstoprint(SashwathaPoojebean sbean) {
		return poojeDao.getSashwathaPoojedetailstoprint(sbean);
	}
	
	
	
	public List getPoojeReport(Reportbean rbean)
	{
		return poojeDao.getPoojeReport(rbean);
	}
	
	public Integer addincome(IncomeData ibean)
	{
		return poojeDao.addincome(ibean);
	}
	
	public List getIncomeReport(Reportbean rbean)
	{
		return poojeDao.getIncomeReport(rbean);
	}
	
	public List getSashwathaReport(Reportbean rbean)
	{
		return poojeDao.getSashwathaReport(rbean);
	}
	
	
	
	public String getDonationReceipt(DonationDetail dbean)
	{
		return poojeDao.getDonationReceipt(dbean);
	}
	
	
	
	public List getDonationReport(Reportbean rbean,String DonationName)
	{
		return poojeDao.getDonationReport(rbean,DonationName);
	}
	
	public Integer getExpenditureReceipt(ExpenseData ebean)
	{
		return poojeDao.getExpenditureReceipt(ebean);
	}
	
	
	public List getExpenditureReport(Reportbean rbean)
	{
		return poojeDao.getExpenditureReport(rbean);
	}
	
	public List getAllReport(Reportbean rbean)
	{
		return poojeDao.getAllReport(rbean);
	}
	
	public Integer updatePooje(Poojebean pbean)
	{
		return poojeDao.updatePooje(pbean);
	}
	
	public Integer updateSashwathaPooje(SashwathaPoojebean sbean)
	{
		return poojeDao.updateSashwathaPooje(sbean);
	}
	
	public Integer updateDonation(DonationDetail dbean)
	{
		return poojeDao. updateDonation(dbean);
	}
	
	public Integer updateExpense(ExpenseData ebean)
	{
		return poojeDao.updateExpense(ebean);
	}
	
	public Integer updateIncome(IncomeData ibean)
	{
		return poojeDao.updateIncome(ibean);
	}
	
	
}
