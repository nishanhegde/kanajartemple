package com.Admin.dao;

import java.util.List;

import com.Admin.bean.BankAccount;
import com.Admin.bean.BankAccountEntry;

public interface BankAccountDao {

	public void save(BankAccount ba);
	
	public List<BankAccount> getBankAccounts();
	
	public BankAccount getBankAccount(String id);
	
	public Integer update(BankAccount ba);
	
	public void delete(String id);
	
	public void save(BankAccountEntry bae);
	
	public List<BankAccountEntry> getBankAccountEntries(String bankId);
}
