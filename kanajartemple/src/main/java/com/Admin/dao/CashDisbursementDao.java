package com.Admin.dao;

import java.util.List;
import java.util.Map;

import com.Admin.bean.CashDisbursement;
import com.Admin.bean.Reportbean;

public interface CashDisbursementDao {

	public void save(CashDisbursement cashDisbursement);

	public List<CashDisbursement> getCashDisbursement();

	public CashDisbursement getCashDisbursement(String id);

	public Integer update(CashDisbursement cashDisbursement);

	public void delete(String id);
	
	public List<Map<String, Object>> getReport(Reportbean rbean);
}
