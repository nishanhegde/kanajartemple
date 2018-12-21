package com.Admin.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.Admin.RowMapper.SashwathaPoojeRowMapper;
import com.Admin.Service.Impl.PoojeService;
import com.Admin.bean.DonationDetail;
import com.Admin.bean.ExpenseData;
import com.Admin.bean.IncomeData;
import com.Admin.bean.Poojebean;
import com.Admin.bean.Reportbean;
import com.Admin.bean.SashwathaPoojebean;
import com.Admin.enums.AmountType;
import com.Brahmalingeshwara.kanajartemple.Utills;

@Component("poojeDao")
public class PoojeDao extends AbstractDao {

	Logger log = Logger.getLogger(PoojeDao.class);

	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Resource
	PoojeService poojeService;

	private String month[] = { "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC" };

	
	private String getSashwathaDate(String date) {
		return (date.substring(0, 3) + month[Integer.parseInt(date.substring(3, 5)) - 1]);

	}



	public String getPoojedetailstoprint(Poojebean pbean) {

		Map<String, Object> param = getPoojeParams(pbean);

		Integer RecNo = namedParameterJdbcTemplate
				.queryForObject("select MAX(RecNo)+1 as RecNo from allpoojedata where Pid=:Pid", param, Integer.class);
		if (RecNo == null) {
			RecNo = 1;
		}
		param.put("RecNo", RecNo);
		String str = "insert into allpoojedata(RecNo,Quantity,Name,Pid,PDate,BDate) "
				+ "values(:RecNo,:Quantity,:Name,:Pid,:PDate,(select now()))";
		Integer i = namedParameterJdbcTemplate.update(str, param);
		if (i == 1) {
			return RecNo.toString();
		}
		return null;
	}

	private Map<String, Object> getPoojeParams(Poojebean pbean) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Pid", pbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(pbean.getName()));
		param.put("Quantity", pbean.getQuantity());
		param.put("PDate", getCustomDate(pbean.getPDate()));
		return param;
	}

	public Integer getSashwathaPoojedetailstoprint(SashwathaPoojebean sbean) {

		StringBuilder sql = new StringBuilder(
				"insert into sashwathapooje(Name,Address,PDate,BDate,MobileNo,Email) values(");
		sql.append("\"" + Utills.replaceWhiteSpace(sbean.getName()) + "\",");
		sql.append("\"" + Utills.replaceWhiteSpace(sbean.getAddress()) + "\",");
		sql.append("\"" + getSashwathaDate(sbean.getPdate()) + "\",");
		sql.append("(select now()),:MobileNo,:Email)");

		SqlParameterSource fileParameters = new BeanPropertySqlParameterSource(sbean);

		KeyHolder keyHolder = new GeneratedKeyHolder();
		namedParameterJdbcTemplate.update(sql.toString(), fileParameters, keyHolder);
		return keyHolder.getKey().intValue();
	}

	public List<Map<String, Object>> getPoojeReport(Reportbean rbean) {

		Map<String, Object> param = getReportParam(rbean);
		String str = "select  RecNo,Quantity,Name,Pid,DATE_FORMAT(PDate, '%d-%m-%Y') as PDate,"
				+ "BDate from allpoojedata" + " where " + rbean.getDates() + ">=:FromDate and " + rbean.getDates()
				+ "<=:ToDate and  Pid=:id";

		return namedParameterJdbcTemplate.queryForList(str, param);
	}

	public Integer addincome(IncomeData ibean) {

		Map<String, Object> param = getIncomeParam(ibean);
		Integer RecNo;

		RecNo = namedParameterJdbcTemplate
				.queryForObject("select MAX(RecNo)+1 as RecNo from allincomedata where Iid=:Iid", param, Integer.class);
		if (RecNo == null) {
			RecNo = 1;
		}
		param.put("RecNo", RecNo);

		String str = "insert into allincomedata(RecNo,Iid,title,Amount,EDate,BDate) "
				+ "values(:RecNo,:Iid,:title,:Amount,:EDate,(select now()))";
		Integer i = namedParameterJdbcTemplate.update(str, param);
		if (i == 1) {
			return RecNo;
		}
		return null;
	}

	private Map<String, Object> getIncomeParam(IncomeData ibean) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Iid", ibean.getIid());
		param.put("title", Utills.replaceWhiteSpace(ibean.getTitle()));
		param.put("Amount", ibean.getAmount());
		param.put("EDate", getCustomDate(ibean.getEdate()));
		return param;
	}

	public List<Map<String, Object>> getIncomeReport(Reportbean rbean) {

		Map<String, Object> param = getReportParam(rbean);

		String str = "select RecNo,title,DATE_FORMAT(Bdate, '%d-%m-%Y %h:%i %p') as Bdate,Amount from allincomedata where Iid=:id and "
				+ rbean.getDates() + ">=:FromDate and " + rbean.getDates() + "<=:ToDate order by " + rbean.getSortby()
				+ " " + rbean.getOrder();

		return namedParameterJdbcTemplate.queryForList(str, param);
	}

	public List getSashwathaReport(Reportbean rbean) {

		Map<String, Object> param = getReportParam(rbean);
		if (rbean.getDates().equalsIgnoreCase("PDate")) {
			param.put("FromDate", getSashwathaDate(rbean.getFromDate()));
			param.put("ToDate", getSashwathaDate(rbean.getToDate()));
		}

		String str = "select RecNo,Name,Address,PDate,MobileNo,Email,BDate,Pid" + " from sashwathapooje where "
				+ rbean.getDates() + ">=:FromDate and " + rbean.getDates() + "<=:ToDate or " + rbean.getDates()
				+ " LIKE '%:ToDate%' ";

		return namedParameterJdbcTemplate.queryForList(str, param);
	}

	/* Donation */

	public String getDonationReceipt(DonationDetail dbean) {

		Map<String, Object> param = getDonationParams(dbean);
		Integer RecNo = namedParameterJdbcTemplate.queryForObject(
				"select IFNULL(MAX(RecNo), 0) + 1 as RecNo from alldonationdata where Did=:Did", param, Integer.class);
		param.put("RecNo", RecNo);

		String str = "insert into alldonationdata "
				+ "(RecNo,Name,Address,Amount,mobile,email,BDate,Did,bankentryid) values(:RecNo,:Name,:Address,:Amount,:mobile,:email,(select now()),:Did,:bankentryid)";

		Integer i = namedParameterJdbcTemplate.update(str, param);

		if (i == 1) {
			return RecNo.toString();
		}
		return null;
	}

	private Map<String, Object> getDonationParams(DonationDetail dbean) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Did", dbean.getDid());
		param.put("Name", Utills.replaceWhiteSpace(dbean.getName()));
		param.put("Address", Utills.replaceWhiteSpace(dbean.getAddress()));
		param.put("mobile", dbean.getMobileNO());
		param.put("email", dbean.getEmail());
		param.put("Amount", dbean.getAmount());
		param.put("bankentryid", dbean.getBankentryid());
		return param;
	}

	public List<Map<String, Object>> getDonationReport(Reportbean rbean, String DonationName) {

		Map<String, Object> param = getReportParam(rbean);
		param.put("amount", rbean.getAmount());
		StringBuilder query=new StringBuilder();
		query.append("select RecNo,Name,Address,Amount,mobile,email,DATE_FORMAT(BDate, '%d-%m-%Y %h:%i %p') as BDate," + "Did from alldonationdata"
				+ " where BDate>=:FromDate and BDate<=:ToDate and Amount>=:amount and Did=:id ");
		
		if(!Objects.equals(AmountType.ALL, rbean.getAmountType()))
		{
			query.append("AND bankentryid IS ");
			query.append(Objects.equals(AmountType.BANK, rbean.getAmountType())?"NOT ":"");
			query.append("NULL ");
		}
		
		query.append("order by "
				+ rbean.getSortby() + " " + rbean.getOrder());
		

		return namedParameterJdbcTemplate.queryForList(query.toString(), param);
	}

	public Integer getExpenditureReceipt(ExpenseData ebean) {

		Map<String, Object> param = getExpenseParams(ebean);

		Integer RecNo;

		RecNo = namedParameterJdbcTemplate.queryForObject(
				"select MAX(RecNo)+1 as RecNo from allexpendituredata where Eid=:Eid", param, Integer.class);
		if (RecNo == null) {
			RecNo = 1;
		}
		param.put("RecNo", RecNo);
		String str = "insert into allexpendituredata(RecNo,Eid,Title,Description,Amount,EDate,BDate) values(:RecNo,:Eid,:Title,:Description,:Amount,:EDate,(select now()))";

		Integer i = namedParameterJdbcTemplate.update(str, param);

		if (i == 1) {
			return RecNo;
		}

		return null;
	}

	private Map<String, Object> getExpenseParams(ExpenseData ebean) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Eid", ebean.getEid());
		param.put("Title", Utills.replaceWhiteSpace(ebean.getTitle()));
		param.put("Description", Utills.replaceWhiteSpace(ebean.getDescription()));
		param.put("Amount", ebean.getAmount());
		param.put("EDate", getCustomDate(ebean.getEDate()));
		return param;
	}

	public List getExpenditureReport(Reportbean rbean) {

		Map<String, Object> param = getReportParam(rbean);
		String str = "select RecNo,Title,Description,Amount," + "DATE_FORMAT(EDate, '%d-%m-%Y') as EDate,"
				+ "DATE_FORMAT(BDate, '%d-%m-%Y %h:%i %p') as BDate from allexpendituredata where Eid=:id and " + rbean.getDates() + ">=:FromDate and "
				+ rbean.getDates() + "<=:ToDate  order by " + rbean.getSortby() + " " + rbean.getOrder();

		return namedParameterJdbcTemplate.queryForList(str, param);
	}

	public List getAllReport(Reportbean rbean) {

		Map<String, Object> param = getReportParam(rbean);

		/* calculating all pooje amount total */
		double poojetotal = 0.0;
		String poojesql = "select Amount,Quantity from pooje p1,allpoojedata s1 where s1.BDate>=:FromDate "
				+ "and s1.BDate<=:ToDate and p1.pid=s1.Pid";
		List pooje = namedParameterJdbcTemplate.queryForList(poojesql, param);
		for (int i = 0; i < pooje.size(); i++) {
			LinkedHashMap poojeList = (LinkedHashMap) pooje.get(i);
			Double amount = Double.parseDouble(poojeList.get("Amount").toString());
			Integer quantity = Integer.parseInt(poojeList.get("Quantity").toString());
			poojetotal += (amount * quantity);
		}

		/* calculating Sashwatha pooje amount total */
		String sashpoojesql = "select Amount from pooje p1,sashwathapooje s1 where s1.BDate>=:FromDate "
				+ "and s1.BDate<=:ToDate and p1.pid=s1.Pid";
		poojetotal +=poojeService.calculateGrandTotal(namedParameterJdbcTemplate.queryForList(sashpoojesql, param));
		
		/* calculating all Donation amount total */
		String donationsql = "select Amount from alldonationdata where BDate>=:FromDate and BDate<=:ToDate ";
		double donationtotal =poojeService.calculateGrandTotal(namedParameterJdbcTemplate.queryForList(donationsql, param));

		/* Expense Total */
		String expensesql = "select Amount from allexpendituredata where BDate>=:FromDate and BDate<=:ToDate ";
		double expensetotal = poojeService.calculateGrandTotal(namedParameterJdbcTemplate.queryForList(expensesql, param));

		/* income Total */
		String incomesql = "select Amount from allincomedata where Bdate>=:FromDate and Bdate<=:ToDate ";
		double incometotal = poojeService.calculateGrandTotal(namedParameterJdbcTemplate.queryForList(incomesql, param));

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

		Map<String, Object> param = getPoojeParams(pbean);
		param.put("RecNo", pbean.getRecNo());
		String str = "update allpoojedata set Quantity=:Quantity,Name=:Name,PDate=:PDate where "
				+ "RecNo=:RecNo and Pid=:Pid";
		return namedParameterJdbcTemplate.update(str, param);

	}

	public Integer updateSashwathaPooje(SashwathaPoojebean sbean) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("Pid", sbean.getPid());
		param.put("Name", Utills.replaceWhiteSpace(sbean.getName()));
		String PDate = sbean.getPdate();
		if (PDate.trim().length() == 6) {
			param.put("PDate", sbean.getPdate());
		} else {
			param.put("PDate", getSashwathaDate(PDate));

		}

		param.put("Address", Utills.replaceWhiteSpace(sbean.getAddress()));
		param.put("mobile", sbean.getMobileNo());
		param.put("email", sbean.getEmail());
		param.put("RecNo", sbean.getRecNo());

		String str = "update sashwathapooje set Name=:Name,Address=:Address,PDate=:PDate,"
				+ "MobileNo=:mobile,Email=:email where RecNo=:RecNo";

		return namedParameterJdbcTemplate.update(str, param);
	}

	public Integer updateDonation(DonationDetail dbean) {

		Map<String, Object> param = getDonationParams(dbean);
		param.put("RecNo", dbean.getRecNO());

		String str = "update alldonationdata set Name=:Name,Address=:Address,Amount=:Amount,"
				+ "mobile=:mobile,email=:email where Did=:Did and RecNo=:RecNo";
		return namedParameterJdbcTemplate.update(str, param);
	}

	public Integer updateExpense(ExpenseData ebean) {

		Map<String, Object> param =getExpenseParams(ebean);
		param.put("RecNo", ebean.getRecNo());

		String str = "update allexpendituredata set Title=:Title,Description=:Description,Amount=:Amount,"
				+ "EDate=:EDate where RecNo=:RecNo and Eid=:Eid";

		return namedParameterJdbcTemplate.update(str, param);

	}

	public Integer updateIncome(IncomeData ibean) {

		Map<String, Object> param =getIncomeParam(ibean);
		param.put("RecNo", ibean.getRecNo());
		
		String str = "update allincomedata set title=:title,Amount=:Amount,"
				+ "Edate=:EDate where RecNo=:RecNo and Iid=:Iid";

		return namedParameterJdbcTemplate.update(str, param);
	}

	public Integer deletePooje(String poojeid, String recno) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("pid", poojeid);
		param.put("RecNo", recno);

		String sql = "delete from allpoojedata where pid=:pid and RecNo=:RecNo";
		return namedParameterJdbcTemplate.update(sql, param);
	}

	public Integer deleteSashwathaPooje(String recno) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("RecNo", recno);

		String sql = "delete from sashwathapooje where RecNo=:RecNo";
		return namedParameterJdbcTemplate.update(sql, param);
	}

	public Integer deleteDonation(String did, String recno) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("did", did);
		param.put("RecNo", recno);

		String sql = "delete from alldonationdata where Did=:did and RecNo=:RecNo";
		return namedParameterJdbcTemplate.update(sql, param);
	}

	public Integer deleteIncome(String iid, String recno) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("iid", iid);
		param.put("RecNo", recno);

		String sql = "delete from allincomedata where iid=:iid and RecNo=:RecNo";
		return namedParameterJdbcTemplate.update(sql, param);
	}

	public Integer deleteExpense(String eid, String recno) {

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("eid", eid);
		param.put("RecNo", recno);

		String sql = "delete from allexpendituredata where eid=:eid and RecNo=:RecNo";
		return namedParameterJdbcTemplate.update(sql, param);
	}

	// Returns list of nithya pooje ,whose pooje date is current system date
	public List<SashwathaPoojebean> getNithyaPooje() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("poojeDate", getSashwathaDate(getConvertedDate(new Date())));
		String str = "select * from sashwathapooje where PDate=:poojeDate";
		return namedParameterJdbcTemplate.query(str, param, new SashwathaPoojeRowMapper());
	}

	private String getConvertedDate(final Date date) {
		final String pattern = "dd-MM-yyyy";
		final SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
}
