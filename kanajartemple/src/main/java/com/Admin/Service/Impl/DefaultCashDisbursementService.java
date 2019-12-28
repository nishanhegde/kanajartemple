package com.Admin.Service.Impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Required;

import com.Admin.Service.CashDisbursementService;

import com.Admin.bean.CashDisbursement;
import com.Admin.bean.Reportbean;
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

	@Override
	public List<Map<String, Object>> getReport(Reportbean rbean) {
		List<Map<String, Object>> report = getCashDisbursementDao().getReport(rbean);


		if (CollectionUtils.isNotEmpty(report)) {
			Map<String, Object> details = report.iterator().next();

			details.put("FromDate", rbean.getFromDate());
			details.put("ToDate", rbean.getToDate());
			details.put("Total", calculateGrandTotal(report));

		}
		return report;
	}
	
	protected double calculateGrandTotal(List<Map<String, Object>> report) {
		return report.stream().mapToDouble(rept -> (Double) ((LinkedHashMap) rept).get("amount")).sum();
	}

}
