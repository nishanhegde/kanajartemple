package com.Admin.Service.Impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;

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
	public synchronized Integer save(BankAccountEntry bae) {

//		Double openingBalance = bankAccountDao.getBalance(bae.getBankAccountId());
//		if (openingBalance == null) {
//			openingBalance = getBankAccount(bae.getBankAccountId().toString()).getOpeningBalance();
//		}
//		double balance = openingBalance.doubleValue();
//		double amount = bae.getAmount().doubleValue();
//		balance = bae.getTransaction().equals(TransactionEnum.DEPOSIT) ? balance + amount : balance - amount;
//		bae.setBalance(balance);
		return bankAccountDao.save(bae);
	}

	@Override
	public List<BankAccountEntry> getBankAccountEntries(String bankId) {
		List<BankAccountEntry> entries= bankAccountDao.getBankAccountEntries(bankId);
		return getEntriesWithBalance(this.getBankAccount(bankId).getOpeningBalance(), entries);
	}

	protected List<BankAccountEntry> getEntriesWithBalance(double balance, List<BankAccountEntry> entries) {
		if(CollectionUtils.isNotEmpty(entries))
		{
			for( BankAccountEntry entry:entries){
				balance=entry.getTransaction().equals(TransactionEnum.DEPOSIT) ? balance + entry.getAmount() : balance - entry.getAmount();
				entry.setBalance(balance);
			}
		}
		
		return entries;
	}

	@Override
	public List<BankAccountEntry> getBankAccountEntries() {
		return bankAccountDao.getBankAccountEntries();
	}

	@Override
	public Map<String, Object> getBankEntryReport(Reportbean rbean) {
		
		double openingBalance=getOpeningBalance(rbean);
		
		List<BankAccountEntry> entryList =getEntriesWithBalance(openingBalance, bankAccountDao.getBankEntryReport(rbean));

		
		JRDataSource datasource = new JRBeanCollectionDataSource(entryList);

		BankAccount bankAccount = getBankAccount(rbean.getId());
		Map<String, Object> parameterMap = new HashMap<String, Object>();
		parameterMap.put("datasource", datasource);
		parameterMap.put("bankName", bankAccount.getBankName());
		parameterMap.put("ifscCode", bankAccount.getIfscCode());
		parameterMap.put("accountNo", bankAccount.getAccountNo());
		parameterMap.put("FromDate", rbean.getFromDate());
		parameterMap.put("ToDate", rbean.getToDate());
		parameterMap.put("openingBalance",openingBalance);

		return parameterMap;
	}

	private double getOpeningBalance(Reportbean rbean) {
		List<BankAccountEntry> entries=bankAccountDao.getBankEntries(rbean);
		double balance=this.getBankAccount(rbean.getId()).getOpeningBalance();
		if(CollectionUtils.isNotEmpty(entries))
		{
			for( BankAccountEntry entry:entries){
				balance=entry.getTransaction().equals(TransactionEnum.DEPOSIT) ? balance + entry.getAmount() : balance - entry.getAmount();

			}
		}
		return balance;
	}

	
}
