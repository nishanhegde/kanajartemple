package com.Admin.Service;

import java.util.List;

import com.Admin.bean.CashDisbursement;

public interface CashDisbursementService {

	public void save(CashDisbursement cashDisbursement);

	public List<CashDisbursement> getCashDisbursement();

	public CashDisbursement getCashDisbursement(String id);

	public Integer update(CashDisbursement cashDisbursement);

	public void delete(String id);
}
