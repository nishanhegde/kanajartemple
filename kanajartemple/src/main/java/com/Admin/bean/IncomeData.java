package com.Admin.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class IncomeData {

	private Integer Iid;
	private Integer RecNo;
	private String title;
	private Double Amount;
	private String Edate;
	private Timestamp Bdate;

	public Integer getIid() {
		return Iid;
	}

	public void setIid(Integer iid) {
		Iid = iid;
	}

	public String getEdate() {
		return Edate;
	}

	public void setEdate(String edate) {
		Edate = edate;
	}

	public Integer getRecNo() {
		return RecNo;
	}

	public void setRecNo(Integer recNo) {
		RecNo = recNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getAmount() {
		return Amount;
	}

	public void setAmount(Double amount) {
		Amount = amount;
	}

	public Timestamp getBdate() {
		return Bdate;
	}

	public void setBdate(Timestamp bdate) {
		Bdate = bdate;
	}

}
