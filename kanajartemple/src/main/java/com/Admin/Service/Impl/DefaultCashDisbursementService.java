package com.Admin.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Required;

import com.Admin.Service.CashDisbursementService;

import com.Admin.bean.CashDisbursement;

import com.Admin.dao.CashDisbursementDao;

public class DefaultCashDisbursementService implements CashDisbursementService {

	private CashDisbursementDao cashDisbursementDao;

	@Override
	public void save(CashDisbursement cashDisbursement) {
		getCashDisbursementDao().save(cashDisbursement);

	}

	@Override
	public List<CashDisbursement> getCashDisbursement() {
		return getCashDisbursementDao().getCashDisbursement();
	}

	@Override
	public CashDisbursement getCashDisbursement(String id) {
		return getCashDisbursementDao().getCashDisbursement(id);
	}

	@Override
	public Integer update(CashDisbursement cashDisbursement) {

		return getCashDisbursementDao().update(cashDisbursement);
	}

	@Override
	public void delete(String id) {
		getCashDisbursementDao().delete(id);

	}

	protected CashDisbursementDao getCashDisbursementDao() {
		return cashDisbursementDao;
	}

	@Required
	public void setCashDisbursementDao(CashDisbursementDao cashDisbursementDao) {
		this.cashDisbursementDao = cashDisbursementDao;
	}

}
