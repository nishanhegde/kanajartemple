package com.Admin.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.Admin.Service.EmailService;
import com.Admin.Service.kanajarTempleMethods;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Pooje;
import com.Admin.bean.Poojebean;
import com.Admin.bean.Reportbean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.cronjob.NithyaPoojeCronJob;
import com.Admin.dao.impl.PoojeDao;
import com.Admin.event.NithyaPoojeEvent;

@Service("poojeService")
public class PoojeService {
	private static final Logger logger = Logger.getLogger(PoojeService.class);

	@Autowired
	private PoojeDao poojeDao;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private EmailService emailService;

	@Resource
	private kanajarTempleMethods defaultTempleMethods;

	public synchronized String getPoojedetailstoprint(Poojebean pbean) {
		return poojeDao.getPoojedetailstoprint(pbean);
	}

	public synchronized Integer getSashwathaPoojedetailstoprint(SashwathaPoojebean sbean) {
		return poojeDao.getSashwathaPoojedetailstoprint(sbean);
	}

	public List getPoojeReport(Reportbean rbean) {
		Pooje pooje = defaultTempleMethods.getPooje(rbean.getId());

		List<Map<String, Object>> report = poojeDao.getPoojeReport(rbean);

		if (CollectionUtils.isNotEmpty(report)) {
			int quantity = report.stream().mapToInt(rept -> (Integer) ((LinkedHashMap) rept).get("Quantity")).sum();
			setHeaderData(rbean, pooje, report, quantity);
		}

		return report;
	}

	private void setHeaderData(Reportbean rbean, Pooje pooje, List<Map<String, Object>> report, int quantity) {
		Map<String, Object> details = report.get(0);
		details.put("PoojeName", pooje.getPoojeName());
		setDates(rbean, details);
		details.put("BaseAmount", pooje.getAmount());
		details.put("TotalQuantity", quantity);
		details.put("Total", quantity * pooje.getAmount());
	}

	public synchronized Integer addincome(IncomeData ibean) {
		return poojeDao.addincome(ibean);
	}

	public List getIncomeReport(Reportbean rbean) {

		List<Map<String, Object>> report = poojeDao.getIncomeReport(rbean);

		Double grandtotal = calculateGrandTotal(report);

		if (CollectionUtils.isNotEmpty(report)) {
			Map<String, Object> details = report.get(0);

			setDates(rbean, details);
			details.put("Total", grandtotal);
			details.put("IncomeName", rbean.getName());
		}
		return report;
	}

	public List getSashwathaReport(Reportbean rbean) {

		Pooje pooje = defaultTempleMethods.getPooje(rbean.getId());

		List<Map<String, Object>> report = poojeDao.getSashwathaReport(rbean);
		if (CollectionUtils.isNotEmpty(report)) {
			setHeaderData(rbean, pooje, report, report.size());
		}
		return report;
	}

	public synchronized String getDonationReceipt(DonationDetail dbean) {
		return poojeDao.getDonationReceipt(dbean);
	}

	public List getDonationReport(Reportbean rbean, String DonationName) {

		List<Map<String, Object>> report = poojeDao.getDonationReport(rbean, DonationName);

		if (CollectionUtils.isNotEmpty(report)) {
			Double grandtotal = calculateGrandTotal(report);

			Map<String, Object> details = report.get(0);
			details.put("DonationName", DonationName);
			setDates(rbean, details);
			details.put("Total", grandtotal);
		}
		return report;
	}

	private void setDates(Reportbean rbean, Map<String, Object> details) {
		details.put("TodayDate", new Date());
		details.put("FromDate", rbean.getFromDate());
		details.put("ToDate", rbean.getToDate());
	}

	public synchronized Integer getExpenditureReceipt(ExpenseData ebean) {
		return poojeDao.getExpenditureReceipt(ebean);
	}

	public List getExpenditureReport(Reportbean rbean) {

		List<Map<String, Object>> report = poojeDao.getExpenditureReport(rbean);

		Double grandtotal = calculateGrandTotal(report);

		if (CollectionUtils.isNotEmpty(report)) {
			Map<String, Object> details = report.get(0);

			setDates(rbean, details);
			details.put("Total", grandtotal);
			details.put("ExpenditureName", rbean.getName());
		}
		return report;
	}

	public double calculateGrandTotal(List<Map<String, Object>> report) {
		return report.stream().mapToDouble(rept -> (Double) ((LinkedHashMap) rept).get("Amount")).sum();
	}

	public List getAllReport(Reportbean rbean) {
		return poojeDao.getAllReport(rbean);
	}

	public Integer updatePooje(Poojebean pbean) {
		return poojeDao.updatePooje(pbean);
	}

	public Integer updateSashwathaPooje(SashwathaPoojebean sbean) {
		return poojeDao.updateSashwathaPooje(sbean);
	}

	public Integer updateDonation(DonationDetail dbean) {
		return poojeDao.updateDonation(dbean);
	}

	public Integer updateExpense(ExpenseData ebean) {
		return poojeDao.updateExpense(ebean);
	}

	public Integer updateIncome(IncomeData ibean) {
		return poojeDao.updateIncome(ibean);
	}

	public Integer deletePooje(String poojeid, String recno) {
		return poojeDao.deletePooje(poojeid, recno);
	}

	public Integer deleteSashwathaPooje(String recno) {
		return poojeDao.deleteSashwathaPooje(recno);
	}

	public Integer deleteDonation(String did, String recno) {
		return poojeDao.deleteDonation(did, recno);
	}

	public Integer deleteIncome(String iid, String recno) {
		return poojeDao.deleteIncome(iid, recno);
	}

	public Integer deleteExpense(String eid, String recno) {
		return poojeDao.deleteExpense(eid, recno);
	}

	public void sendNithyaPoojeEmail() {
		for (SashwathaPoojebean pooje : poojeDao.getNithyaPooje()) {
			if (pooje.getEmail() != null && !pooje.getEmail().isEmpty()) {
				eventPublisher.publishEvent(new NithyaPoojeEvent(this, pooje));
			}
		}

	}

	public void sendNithyaPoojeSMS() {
		try {
			StringBuilder numbers = new StringBuilder();
			for (SashwathaPoojebean pooje : poojeDao.getNithyaPooje()) {
				if (pooje.getMobileNo() != null
						&& !pooje.getMobileNo().isEmpty() & pooje.getMobileNo().trim().length() == 10) {
					if (numbers.length() > 0) {
						numbers.append(",");
					}
					numbers.append("91" + pooje.getMobileNo());
				}
			}

			if (numbers.length() > 0) {
				emailService.sendSMS(numbers.toString(), "We have performed POOJA on " + getConvertedDate(new Date())
						+ " for the fulfilment of your wishes.We wish you and your family will be blessed with happiness, peace and prosperity by Lord Shree Brahmalingeshwara, Shree Veerabhadra and Shree Melbanta.");
			}
		} catch (Exception e) {
			logger.error(e);
		}

	}

	private String getConvertedDate(final Date date) {
		final String pattern = "dd-MM-YYYY";
		final SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
}
