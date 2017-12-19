package com.Admin.Service.Impl;

import java.util.List;

import javax.annotation.Resource;

import com.Admin.Service.BankAccountService;
import com.Admin.bean.BankAccount;
import com.Admin.dao.BankAccountDao;

public class DefaultBankAccountService implements BankAccountService {

	@Resource
	private  BankAccountDao bankAccountDao;
	
	@Override
	public void save(BankAccount ba) {
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
}
