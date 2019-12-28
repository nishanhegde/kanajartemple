package com.Admin.dao;

import java.util.List;

import com.Admin.bean.CashDisbursement;

public interface CashDisbursementDao {

	public void save(CashDisbursement cashDisbursement);

	public List<CashDisbursement> getCashDisbursement();

	public CashDisbursement getCashDisbursement(String id);

	public Integer update(CashDisbursement cashDisbursement);

	public void delete(String id);
}
