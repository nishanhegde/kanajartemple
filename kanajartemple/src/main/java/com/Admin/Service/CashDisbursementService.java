package com.Admin.Service;

import java.util.List;

import com.Admin.bean.CashDisbursement;
import com.Admin.bean.Reportbean;

public interface CashDisbursementService {

	public void save(CashDisbursement cashDisbursement);

	public List<CashDisbursement> getCashDisbursement();

	public CashDisbursement getCashDisbursement(String id);

	public Integer update(CashDisbursement cashDisbursement);

	public void delete(String id);
	
	public List<?> getReport(Reportbean rbean);
}
