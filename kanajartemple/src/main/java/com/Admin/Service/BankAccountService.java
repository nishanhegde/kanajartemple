package com.Admin.Service;

import java.util.List;

import com.Admin.bean.BankAccount;

public interface BankAccountService {
	
	public void save(BankAccount ba);
	
	public List<BankAccount> getBankAccounts();
	
	public BankAccount getBankAccount(String id);
	
	public Integer update(BankAccount ba);
	
	public void delete(String id);
}
