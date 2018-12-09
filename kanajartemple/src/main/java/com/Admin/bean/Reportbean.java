package com.Admin.bean;

import com.Admin.enums.AmountType;

public class Reportbean {
	

	private String dates;
	private String FromDate;
	private String ToDate;
	private String SaveAs;
	private String sortby;
	private String order;
	private String id;
	private String name;
	private Double Amount;
	private AmountType amountType;
	
	public String getDates() {
		return dates;
	}
	public void setDates(String dates) {
		this.dates = dates;
	}
	public String getFromDate() {
		return FromDate;
	}
	public void setFromDate(String fromDate) {
		FromDate = fromDate;
	}
	public String getToDate() {
		return ToDate;
	}
	public void setToDate(String toDate) {
		ToDate = toDate;
	}
	public String getSaveAs() {
		return SaveAs;
	}
	public void setSaveAs(String saveAs) {
		SaveAs = saveAs;
	}
	public String getSortby() {
		return sortby;
	}
	public void setSortby(String sortby) {
		this.sortby = sortby;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getAmount() {
		return Amount;
	}
	public void setAmount(Double amount) {
		Amount = amount;
	}
	public AmountType getAmountType() {
		return amountType;
	}
	public void setAmountType(AmountType amountType) {
		this.amountType = amountType;
	}	
	
}
