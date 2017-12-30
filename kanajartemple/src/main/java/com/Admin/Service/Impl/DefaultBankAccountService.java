package com.Admin.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.Admin.Service.BankAccountService;
import com.Admin.bean.BankAccount;
import com.Admin.bean.BankAccountEntry;
import com.Admin.bean.Reportbean;
import com.Admin.dao.BankAccountDao;
import com.Brahmalingeshwara.kanajartemple.TransactionEnum;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class DefaultBankAccountService implements BankAccountService {

	@Resource
	private BankAccountDao bankAccountDao;

	@Override
	public synchronized void save(BankAccount ba) {
		bankAccountDao.save(ba);
	}

	@Override
	public List<BankAccount> getBankAccounts() {
		return bankAccountDao.getBankAccounts();
	}

	@Override
	public BankAccount getBankAccount(String id) {
		return bankAccountDao.getBankAccount(id);
	}

	@Override
	public Integer update(BankAccount ba) {
		return bankAccountDao.update(ba);
	}

	@Override
	public void delete(String id) {
		bankAccountDao.delete(id);
	}

	@Override
	public synchronized void save(BankAccountEntry bae) {

		Double openingBalance = bankAccountDao.getBalance(bae.getBankAccountId());
		if (openingBalance == null) {
			openingBalance = getBankAccount(bae.getBankAccountId().toString()).getOpeningBalance();
		}
		double balance = openingBalance.doubleValue();
		double amount = bae.getAmount().doubleValue();
		balance = bae.getTransaction().equals(TransactionEnum.DEPOSIT) ? balance + amount : balance - amount;
		bae.setBalance(balance);
		bankAccountDao.save(bae);
	}

	@Override
	public List<BankAccountEntry> getBankAccountEntries(String bankId) {
		return bankAccountDao.getBankAccountEntries(bankId);
	}

	@Override
	public Map<String, Object> getBankEntryReport(Reportbean rbean) {
		List<BankAccountEntry> entryList=bankAccountDao.getBankEntryReport(rbean);
		JRDataSource datasource = new JRBeanCollectionDataSource(entryList);
		
		BankAccount bankAccount=getBankAccount(rbean.getId());
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);
		parameterMap.put("bankName", bankAccount.getBankName());
		parameterMap.put("ifscCode", bankAccount.getIfscCode());
		parameterMap.put("accountNo",bankAccount.getAccountNo());
		parameterMap.put("FromDate", rbean.getFromDate());
		parameterMap.put("ToDate", rbean.getToDate());
		parameterMap.put("openingBalance", getOpeningBalance(entryList));
	
		return parameterMap;
	}

	private double getOpeningBalance(List<BankAccountEntry> entryList) {
		BankAccountEntry firstEntry=entryList.get(0);

		double balance=firstEntry.getBalance().doubleValue();
		double amount = firstEntry.getAmount().doubleValue();
		double openingBalance=firstEntry.getTransaction().equals(TransactionEnum.DEPOSIT) ? balance - amount : balance + amount;
		return openingBalance;
	}

	
}
