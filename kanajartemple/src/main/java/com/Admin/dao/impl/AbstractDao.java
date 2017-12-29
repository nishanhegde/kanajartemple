package com.Admin.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.Admin.bean.Reportbean;

public class AbstractDao {
	
	protected Map<String, Object> getReportParam(Reportbean rbean) {
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
	
	protected java.sql.Date getCustomDate(String formdate) {
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


}
