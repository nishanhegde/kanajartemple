package com.Admin.bean;

import java.sql.Date;
import java.sql.Timestamp;

public class ExpenseData {

	private Integer RecNo;
	private String Title;
	private String Description;
	private Double Amount;
	private String EDate;
	private Timestamp BDate;
	
	public Integer getRecNo() {
		return RecNo;
	}
	public void setRecNo(Integer recNo) {
		RecNo = recNo;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public String getEDate() {
		return EDate;
	}
	public void setEDate(String eDate) {
		EDate = eDate;
	}
	public Timestamp getBDate() {
		return BDate;
	}
	public void setBDate(Timestamp bDate) {
		BDate = bDate;
	}

}
