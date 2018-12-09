package com.Admin.Service;

import java.util.List;
import java.util.Map;

import com.Admin.bean.BankAccount;
import com.Admin.bean.BankAccountEntry;
import com.Admin.bean.Reportbean;

public interface BankAccountService {
	
	public void save(BankAccount ba);
	
	public List<BankAccount> getBankAccounts();
	
	public BankAccount getBankAccount(String id);
	
	public Integer update(BankAccount ba);
	
	public void delete(String id);
	
	public void save(BankAccountEntry bae);
	
	public List<BankAccountEntry> getBankAccountEntries(String bankId);
	
	public List<BankAccountEntry> getBankAccountEntries();
	
	public Map<String, Object> getBankEntryReport(Reportbean rbean);
}
