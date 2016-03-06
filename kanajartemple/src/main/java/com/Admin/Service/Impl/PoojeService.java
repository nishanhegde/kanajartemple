package com.Admin.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Admin.bean.DonationDetail;
import com.Admin.bean.Expense;
import com.Admin.bean.Income;
import com.Admin.bean.Poojebean;
import com.Admin.bean.Reportbean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.dao.impl.PoojeDao;

@Service("service")
public class PoojeService {

	@Autowired
	private PoojeDao dao;

	public PoojeDao getDao() {
		return dao;
	}

	public void setDao(PoojeDao dao) {
		this.dao = dao;
	}
	
	
	
	public String getPoojedetailstoprint(Poojebean pbean) {
		return dao.getPoojedetailstoprint(pbean);
	}
	
	public Integer getSashwathaPoojedetailstoprint(SashwathaPoojebean sbean) {
		return dao.getSashwathaPoojedetailstoprint(sbean);
	}
	
	
	
	public List getPoojeReport(Reportbean rbean)
	{
		return dao.getPoojeReport(rbean);
	}
	
	public Integer addincome(Income ibean)
	{
		return dao.addincome(ibean);
	}
	
	public List getIncomeReport(Reportbean rbean)
	{
		return dao.getIncomeReport(rbean);
	}
	
	public List getSashwathaReport(Reportbean rbean)
	{
		return dao.getSashwathaReport(rbean);
	}
	
	
	
	public String getDonationReceipt(DonationDetail dbean)
	{
		return dao.getDonationReceipt(dbean);
	}
	
	
	
	public List getDonationReport(Reportbean rbean,String DonationName)
	{
		return dao.getDonationReport(rbean,DonationName);
	}
	
	public String getExpenditureReceipt(Expense ebean)
	{
		return dao.getExpenditureReceipt(ebean);
	}
	
	
	public List getExpenditureReport(Reportbean rbean)
	{
		return dao.getExpenditureReport(rbean);
	}
	
	public List getAllReport(Reportbean rbean)
	{
		return dao.getAllReport(rbean);
	}
	
	public Integer updatePooje(Poojebean pbean)
	{
		return dao.updatePooje(pbean);
	}
	
	public Integer updateSashwathaPooje(SashwathaPoojebean sbean)
	{
		return dao.updateSashwathaPooje(sbean);
	}
	
	public Integer updateDonation(DonationDetail dbean)
	{
		return dao. updateDonation(dbean);
	}
	
	public Integer updateExpense(Expense ebean)
	{
		return dao.updateExpense(ebean);
	}
	
	public Integer updateIncome(Income ibean)
	{
		return dao.updateIncome(ibean);
	}
	
	
}
