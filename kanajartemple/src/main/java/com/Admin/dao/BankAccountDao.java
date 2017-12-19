package com.Admin.dao;

import java.util.List;

import com.Admin.bean.BankAccount;

public interface BankAccountDao {

	public void save(BankAccount ba);
	
	public List<BankAccount> getBankAccounts();
	
	public BankAccount getBankAccount(String id);
	
	public Integer update(BankAccount ba);
	
	public void delete(String id);
}
