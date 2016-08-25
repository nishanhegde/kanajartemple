package com.Admin.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.Admin.bean.DonationDetail;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Poojebean;
import com.Admin.bean.Reportbean;
import com.Admin.bean.SashwathaPoojebean;
import com.Brahmalingeshwara.kanajartemple.Utills;

@Component("poojeDao")
public class PoojeDao<K> {

	Logger log = Logger.getLogger(PoojeDao.class);
	@Autowired
	PlatformTransactionManager transactionManager;

	@Autowired
	DriverManagerDataSource dataSource;

	private String month[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

	private java.sql.Date getCustomDate(String formdate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date date = null;
		try {
			date = formatter.parse(formdate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date PDate = new java.sql.Date(date.getTime());

		return PDate;
	}

	private String getSashwathaDate(String date) {
		return (date.substring(0, 3) + month[Integer.parseInt(date.substring(3, 5)) - 1]);

	}

	private Map<String, Object> getReportParam(Reportbean rbean) {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("id", rbean.getId());
		param.put("ColumnName", rbean.getDates());

		param.put("FromDate", getCustomDate(rbean.getFromDate()));
		if (rbean.getDates() != null && rbean.getDates().equalsIgnoreCase("BDate")) {
			Integer dd = Integer.parseInt(rbean.getToDate().substring(0, 2));
			dd++;
			String todate = dd + rbean.getToDate().substring(2);
			param.put("ToDate", getCustomDate(todate));
		} else {
			param.put("ToDate", getCustomDate(rbean.getToDate()));
		}
		return param;
	}

	public String getPoojedetailstoprint(Poojebean pbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Pid", pbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(pbean.getName()));
		param.put("Quantity", pbean.getQuantity());
		param.put("PDate", getCustomDate(pbean.getPDate()));

		Integer RecNo = namedjdbc.queryForObject("select MAX(RecNo)+1 as RecNo from allpoojedata where Pid=:Pid", param,
				Integer.class);
		if (RecNo == null) {
			RecNo = 1;
		}
		param.put("RecNo", RecNo);
		String str = "insert into allpoojedata(RecNo,Quantity,Name,Pid,PDate,BDate) "
				+ "values(:RecNo,:Quantity,:Name,:Pid,:PDate,(select now()))";
		Integer i = namedjdbc.update(str, param);
		if (i == 1) {
			return RecNo.toString();
		}
		return null;
	}

	public Integer getSashwathaPoojedetailstoprint(SashwathaPoojebean sbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Pid", sbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(sbean.getName()));
		param.put("PDate", getSashwathaDate(sbean.getPdate()));
		param.put("Address", Utills.replaceWhiteSpace(sbean.getAddress()));
		param.put("mobile", sbean.getMobileNo());
		param.put("email", sbean.getEmail());

		String str = "insert into SashwathaPooje(Name,Address,PDate,BDate,MobileNo,Email) "
				+ "values(:Name,:Address,:PDate,(select now()),:mobile,:email)";

		Integer i = namedjdbc.update(str, param);
		Integer RecNo = null;
		if (i == 1) {
			String str2 = "select RecNo from SashwathaPooje where Name=:Name and PDate=:PDate order by BDate DESC";
			LinkedHashMap linkedList = (LinkedHashMap) namedjdbc.queryForList(str2, param).get(0);
			RecNo = Integer.valueOf(linkedList.get("RecNo").toString());
		}
		return RecNo;
	}

	public List<Map<String, Object>> getPoojeReport(Reportbean rbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = getReportParam(rbean);
		String PoojeName = null;
		String BaseAmount = null;
		String sql = "select Amount,Quantity,PoojeName from pooje p1," + "allpoojedata s1 where  p1.pid=:id and s1."
				+ rbean.getDates() + ">=:FromDate and s1." + rbean.getDates() + "<=:ToDate and p1.pid=s1.Pid";
		double grandtotal = 00.0;
		List total = namedjdbc.queryForList(sql, param);
		for (int i = 0; i < total.size(); i++) {
			LinkedHashMap linkedList = (LinkedHashMap) total.get(i);
			if (i == 0) {
				PoojeName = linkedList.get("PoojeName").toString();
				BaseAmount = linkedList.get("Amount").toString();
			}
			Double Amount = (Double) linkedList.get("Amount");
			Integer quantity = (Integer) linkedList.get("Quantity");
			grandtotal += Amount * quantity;

		}

		String str = "select  @acount:=@acount+1 SI,RecNo,Quantity,Name,Pid,DATE_FORMAT(PDate, '%d-%m-%Y') as PDate,"
				+ "BDate from (SELECT @acount:= 0) AS acount,allpoojedata" + " where " + rbean.getDates()
				+ ">=:FromDate and " + rbean.getDates() + "<=:ToDate and  Pid=:id";
		List<Map<String, Object>> report = new ArrayList<Map<String, Object>>();
		Map<String, Object> details = new HashMap<String, Object>();
		details.put("PoojeName", PoojeName);
		details.put("TodayDate", new Date());
		details.put("FromDate", rbean.getFromDate());
		details.put("ToDate", rbean.getToDate());
		details.put("BaseAmount", BaseAmount);
		details.put("Total", grandtotal);
		report = namedjdbc.queryForList(str, param);
		report.add(0, details);
		return report;
	}

	public Integer addincome(IncomeData ibean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Iid", ibean.getIid());
		param.put("title", Utills.replaceWhiteSpace(ibean.getTitle()));
		param.put("Amount", ibean.getAmount());
		param.put("EDate", getCustomDate(ibean.getEdate()));
		Integer RecNo;

		RecNo = namedjdbc.queryForObject("select MAX(RecNo)+1 as RecNo from allincomedata where Iid=:Iid", param,
				Integer.class);
		if (RecNo == null) {
			RecNo = 1;
		}
		param.put("RecNo", RecNo);

		String str = "insert into allincomedata(RecNo,Iid,title,Amount,EDate,BDate) "
				+ "values(:RecNo,:Iid,:title,:Amount,:EDate,(select now()))";
		Integer i = namedjdbc.update(str, param);
		if (i == 1) {
			return RecNo;
		}
		return null;
	}

	public List<Map<String, Object>> getIncomeReport(Reportbean rbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = getReportParam(rbean);

		String str = "select @acount:=@acount+1 SI,RecNo,title,DATE_FORMAT(Bdate, '%d-%m-%Y %h:%i %p') as Bdate,Amount from (SELECT @acount:= 0) AS acount,allincomedata where Iid=:id and "
				+ rbean.getDates() + ">=:FromDate and " + rbean.getDates() + "<=:ToDate order by " + rbean.getSortby()
				+ " " + rbean.getOrder();

		List report = new ArrayList();
		Map<String, Object> details = new HashMap<String, Object>();

		details.put("TodayDate", new Date());
		details.put("FromDate", rbean.getFromDate());
		details.put("ToDate", rbean.getToDate());
		details.put("IncomeName", rbean.getName());
		report = namedjdbc.queryForList(str, param);
		double grandtotal = 00.0;

		for (int i = 0; i < report.size(); i++) {
			LinkedHashMap linkedList = (LinkedHashMap) report.get(i);

			grandtotal += Double.parseDouble(linkedList.get("Amount").toString());
		}
		details.put("Total", grandtotal);
		report.add(0, details);

		return report;
	}

	public List getSashwathaReport(Reportbean rbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = getReportParam(rbean);
		if (rbean.getDates().equalsIgnoreCase("PDate")) {
			param.put("FromDate", getSashwathaDate(rbean.getFromDate()));
			param.put("ToDate", getSashwathaDate(rbean.getToDate()));
		}
		String sql = "select Amount from pooje p1,SashwathaPooje s1 where p1.pid=:id and s1." + rbean.getDates()
				+ ">=:FromDate and s1." + rbean.getDates() + "<=:ToDate and p1.pid=s1.Pid or " + rbean.getDates()
				+ "=:ToDate ";
		String str = "select @acount:=@acount+1 SI,RecNo,Name,Address,PDate,MobileNo,Email,BDate,Pid"
				+ " from (SELECT @acount:= 0) AS acount,SashwathaPooje where " + rbean.getDates() + ">=:FromDate and "
				+ rbean.getDates() + "<=:ToDate or " + rbean.getDates() + " LIKE '%:ToDate%' ";

		double grandtotal = 00.0;
		String BaseAmount = null;
		List total = namedjdbc.queryForList(sql, param);
		for (int i = 0; i < total.size(); i++) {
			LinkedHashMap<String, Object> linkedList = (LinkedHashMap) total.get(i);
			if (i == 0) {
				BaseAmount = linkedList.get("Amount").toString();
			}
			grandtotal += Double.parseDouble(linkedList.get("Amount").toString());
		}

		List<Map<String, Object>> report = new ArrayList<Map<String, Object>>();
		Map<String, Object> details = new HashMap<String, Object>();

		details.put("TodayDate", new Date());
		details.put("FromDate", rbean.getFromDate());
		details.put("ToDate", rbean.getToDate());
		details.put("BaseAmount", BaseAmount);
		details.put("Total", grandtotal);
		report = namedjdbc.queryForList(str, param);
		report.add(0, details);

		return report;
	}

	/* Donation */

	public String getDonationReceipt(DonationDetail dbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Did", dbean.getDid());
		param.put("Name", Utills.replaceWhiteSpace(dbean.getName()));
		param.put("Address", Utills.replaceWhiteSpace(dbean.getAddress()));
		param.put("mobile", dbean.getMobileNO());
		param.put("email", dbean.getEmail());
		param.put("Amount", dbean.getAmount());
		Integer RecNo = null;

		try {
			RecNo = namedjdbc.queryForObject("select MAX(RecNo)+1 as RecNo from alldonationdata where Did=:Did", param,
					Integer.class);

			param.put("RecNo", RecNo);

		} catch (Exception e) {
			RecNo = 1;
			param.put("RecNo", RecNo);
		}
		if (RecNo == null) {
			RecNo = 1;
			param.put("RecNo", RecNo);
		}
		String str = "insert into alldonationdata "

				+ "(RecNo,Name,Address,Amount,mobile,email,BDate,Did) values(:RecNo,:Name,:Address,:Amount,:mobile,:email,(select now()),:Did)";

		Integer i = namedjdbc.update(str, param);

		if (i == 1) {
			return RecNo.toString();
		}
		return null;
	}

	public List<Map<String, Object>> getDonationReport(Reportbean rbean, String DonationName) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = getReportParam(rbean);
		String str = "select @acount:=@acount+1 SI,RecNo,Name,Address,Amount,mobile,email,BDate,"
				+ "Did from (SELECT @acount:= 0) AS acount,alldonationdata"
				+ " where BDate>=:FromDate and BDate<=:ToDate and Did=:id  order by " + rbean.getSortby() + " "
				+ rbean.getOrder();

		double grandtotal = 00.0;
		List report = namedjdbc.queryForList(str, param);
		for (int i = 0; i < report.size(); i++) {
			LinkedHashMap linkedList = (LinkedHashMap) report.get(i);

			grandtotal += Double.parseDouble(linkedList.get("Amount").toString());
		}

		Map<String, Object> details = new HashMap<String, Object>();
		details.put("DonationName", DonationName);
		details.put("TodayDate", new Date());
		details.put("FromDate", rbean.getFromDate());
		details.put("ToDate", rbean.getToDate());
		details.put("Total", grandtotal);
		report.add(0, details);

		return report;
	}

	public Integer getExpenditureReceipt(ExpenseData ebean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Eid", ebean.getEid());
		param.put("Title", Utills.replaceWhiteSpace(ebean.getTitle()));
		param.put("Description", Utills.replaceWhiteSpace(ebean.getDescription()));
		param.put("Amount", ebean.getAmount());
		param.put("EDate", getCustomDate(ebean.getEDate()));

		Integer RecNo;

		RecNo = namedjdbc.queryForObject("select MAX(RecNo)+1 as RecNo from allexpendituredata where Eid=:Eid", param,
				Integer.class);
		if (RecNo == null) {
			RecNo = 1;
		}
		param.put("RecNo", RecNo);
		String str = "insert into allexpendituredata(RecNo,Eid,Title,Description,Amount,EDate,BDate) values(:RecNo,:Eid,:Title,:Description,:Amount,:EDate,(select now()))";

		Integer i = namedjdbc.update(str, param);

		if (i == 1) {
			return RecNo;
		}

		return null;
	}

	public List getExpenditureReport(Reportbean rbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = getReportParam(rbean);
		String str = "select @acount:=@acount+1 SI,RecNo,Title,Description,Amount,"
				+ "DATE_FORMAT(EDate, '%d-%m-%Y') as EDate,"
				+ "BDate from (SELECT @acount:= 0) AS acount,allexpendituredata where Eid=:id and " + rbean.getDates()
				+ ">=:FromDate and " + rbean.getDates() + "<=:ToDate  order by " + rbean.getSortby() + " "
				+ rbean.getOrder();

		double grandtotal = 00.0;
		List report = namedjdbc.queryForList(str, param);
		for (int i = 0; i < report.size(); i++) {
			LinkedHashMap linkedList = (LinkedHashMap) report.get(i);
			grandtotal += Double.parseDouble(linkedList.get("Amount").toString());
		}

		Map<String, Object> details = new HashMap<String, Object>();

		details.put("TodayDate", new Date());
		details.put("FromDate", rbean.getFromDate());
		details.put("ToDate", rbean.getToDate());
		details.put("Total", grandtotal);
		details.put("ExpenditureName", rbean.getName());
		report.add(0, details);

		return report;
	}

	public List getAllReport(Reportbean rbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = getReportParam(rbean);

		/* calculating all pooje amount total */
		double poojetotal = 0.0;
		String poojesql = "select Amount,Quantity from pooje p1,allpoojedata s1 where s1.BDate>=:FromDate "
				+ "and s1.BDate<=:ToDate and p1.pid=s1.Pid";
		List pooje = namedjdbc.queryForList(poojesql, param);
		for (int i = 0; i < pooje.size(); i++) {
			LinkedHashMap poojeList = (LinkedHashMap) pooje.get(i);
			Double amount = Double.parseDouble(poojeList.get("Amount").toString());
			Integer quantity = Integer.parseInt(poojeList.get("Quantity").toString());
			poojetotal += (amount * quantity);

		}

		/* calculating Sashwatha pooje amount total */
		String sashpoojesql = "select Amount from pooje p1,sashwathapooje s1 where s1.BDate>=:FromDate "
				+ "and s1.BDate<=:ToDate and p1.pid=s1.Pid";
		List sashpooje = namedjdbc.queryForList(sashpoojesql, param);
		for (int i = 0; i < sashpooje.size(); i++) {
			LinkedHashMap sashpoojeList = (LinkedHashMap) sashpooje.get(i);
			poojetotal += Double.parseDouble(sashpoojeList.get("Amount").toString());

		}

		/* calculating all Donation amount total */
		double donationtotal = 0.0;
		String donationsql = "select Amount from alldonationdata where BDate>=:FromDate and BDate<=:ToDate ";
		List donation = namedjdbc.queryForList(donationsql, param);
		for (int j = 0; j < donation.size(); j++) {
			LinkedHashMap linkedList2 = (LinkedHashMap) donation.get(j);
			donationtotal += Double.parseDouble(linkedList2.get("Amount").toString());
		}

		/* Expense Total */
		String expensesql = "select Amount from allexpendituredata where BDate>=:FromDate and BDate<=:ToDate ";

		double expensetotal = 00.0;
		List total = namedjdbc.queryForList(expensesql, param);
		for (int k = 0; k < total.size(); k++) {
			LinkedHashMap linkedList = (LinkedHashMap) total.get(k);

			expensetotal += Double.parseDouble(linkedList.get("Amount").toString());
		}

		/* income Total */
		String incomesql = "select Amount from allincomedata where Bdate>=:FromDate and Bdate<=:ToDate ";

		double incometotal = 00.0;
		List income = namedjdbc.queryForList(incomesql, param);
		for (int k = 0; k < income.size(); k++) {
			LinkedHashMap linkedList = (LinkedHashMap) income.get(k);

			incometotal += Double.parseDouble(linkedList.get("Amount").toString());
		}

		// Grand total
		double grandtotal = poojetotal + donationtotal + incometotal - expensetotal;
		List report = new ArrayList();
		Map<String, Object> details = new HashMap<String, Object>();

		details.put("TodayDate", new Date());
		details.put("FromDate", rbean.getFromDate());
		details.put("ToDate", rbean.getToDate());

		details.put("PoojeTotal", poojetotal);
		details.put("DonationTotal", donationtotal);
		details.put("IncomeTotal", incometotal);
		details.put("Expenditure", expensetotal);
		details.put("GrandTotal", grandtotal);

		report.add(details);

		return report;

	}

	public Integer updatePooje(Poojebean pbean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Pid", pbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(pbean.getName()));
		param.put("Quantity", pbean.getQuantity());
		param.put("PDate", getCustomDate(pbean.getPDate()));
		param.put("RecNo", pbean.getRecNo());
		String str = "update allpoojedata set Quantity=:Quantity,Name=:Name,PDate=:PDate where "
				+ "RecNo=:RecNo and Pid=:Pid";
		return namedjdbc.update(str, param);

	}

	public Integer updateSashwathaPooje(SashwathaPoojebean sbean) {

		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Pid", sbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(sbean.getName()));
		String PDate = sbean.getPdate();
		if (PDate.length() == 6) {
			param.put("PDate", sbean.getPdate());
		} else {
			param.put("PDate", getSashwathaDate(PDate));

		}

		param.put("Address", Utills.replaceWhiteSpace(sbean.getAddress()));
		param.put("mobile", sbean.getMobileNo());
		param.put("email", sbean.getEmail());
		param.put("RecNo", sbean.getRecNo());

		String str = "update SashwathaPooje set Name=:Name,Address=:Address,PDate=:PDate,"
				+ "MobileNo=:mobile,Email=:email where RecNo=:RecNo";

		return namedjdbc.update(str, param);
	}

	public Integer updateDonation(DonationDetail dbean) {

		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Did", dbean.getDid());
		param.put("Name", Utills.replaceWhiteSpace(dbean.getName()));
		param.put("Address", Utills.replaceWhiteSpace(dbean.getAddress()));
		param.put("mobile", dbean.getMobileNO());
		param.put("email", dbean.getEmail());
		param.put("Amount", dbean.getAmount());
		param.put("RecNo", dbean.getRecNO());

		String str = "update alldonationdata set Name=:Name,Address=:Address,Amount=:Amount,"
				+ "mobile=:mobile,email=:email where Did=:Did and RecNo=:RecNo";
		return namedjdbc.update(str, param);
	}

	public Integer updateExpense(ExpenseData ebean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Title", Utills.replaceWhiteSpace(ebean.getTitle()));
		param.put("Description", Utills.replaceWhiteSpace(ebean.getDescription()));
		param.put("Amount", ebean.getAmount());
		param.put("EDate", getCustomDate(ebean.getEDate()));
		param.put("RecNo", ebean.getRecNo());
		param.put("Eid", ebean.getEid());
		String str = "update allexpendituredata set Title=:Title,Description=:Description,Amount=:Amount,"
				+ "EDate=:EDate where RecNo=:RecNo and Eid=:Eid";

		return namedjdbc.update(str, param);

	}

	public Integer updateIncome(IncomeData ibean) {
		NamedParameterJdbcTemplate namedjdbc = new NamedParameterJdbcTemplate(dataSource);
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("title", Utills.replaceWhiteSpace(ibean.getTitle()));
		param.put("Amount", ibean.getAmount());
		param.put("EDate", getCustomDate(ibean.getEdate()));
		param.put("RecNo", ibean.getRecNo());
		param.put("Iid", ibean.getIid());
		String str = "update allincomedata set title=:title,Amount=:Amount,"
				+ "Edate=:EDate where RecNo=:RecNo and Iid=:Iid";

		return namedjdbc.update(str, param);
	}
}
