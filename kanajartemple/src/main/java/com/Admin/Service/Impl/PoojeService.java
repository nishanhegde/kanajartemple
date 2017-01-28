package com.Admin.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import com.Admin.Service.EmailService;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.IncomeData;
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

	public String getPoojedetailstoprint(Poojebean pbean) {
		return poojeDao.getPoojedetailstoprint(pbean);
	}

	public Integer getSashwathaPoojedetailstoprint(SashwathaPoojebean sbean) {
		return poojeDao.getSashwathaPoojedetailstoprint(sbean);
	}

	public List getPoojeReport(Reportbean rbean) {
		return poojeDao.getPoojeReport(rbean);
	}

	public Integer addincome(IncomeData ibean) {
		return poojeDao.addincome(ibean);
	}

	public List getIncomeReport(Reportbean rbean) {
		return poojeDao.getIncomeReport(rbean);
	}

	public List getSashwathaReport(Reportbean rbean) {
		return poojeDao.getSashwathaReport(rbean);
	}

	public String getDonationReceipt(DonationDetail dbean) {
		return poojeDao.getDonationReceipt(dbean);
	}

	public List getDonationReport(Reportbean rbean, String DonationName) {
		return poojeDao.getDonationReport(rbean, DonationName);
	}

	public Integer getExpenditureReceipt(ExpenseData ebean) {
		return poojeDao.getExpenditureReceipt(ebean);
	}

	public List getExpenditureReport(Reportbean rbean) {
		return poojeDao.getExpenditureReport(rbean);
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
